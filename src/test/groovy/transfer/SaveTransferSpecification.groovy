package groovy.transfer

import com.marey.transferapi.account.model.Account
import com.marey.transferapi.account.repository.AccountRepository
import com.marey.transferapi.transfer.model.Iban
import com.marey.transferapi.transfer.model.Transfer
import com.marey.transferapi.transfer.repository.TransferRepository
import com.marey.transferapi.transfer.request.TransferRequest
import com.marey.transferapi.transfer.request.TransferResponseStatus
import com.marey.transferapi.transfer.service.TransferServiceImpl
import com.marey.transferapi.user.model.User
import com.marey.transferapi.user.repository.UserRepository
import groovy.traits.AccountTrait
import groovy.traits.UserTrait
import spock.lang.Specification

import java.time.LocalDateTime

class SaveTransferSpecification extends Specification implements UserTrait, AccountTrait {

    def transferRepository = Mock(TransferRepository)
    def accountRepository = Mock(AccountRepository)
    def userRepository = Mock(UserRepository)

    def transferService = new TransferServiceImpl(accountRepository, userRepository, transferRepository)

    def userId = 1L

    def "should save new transfer"() {
        given:
            def user = getUser() as User
            def account = getAccount() as Account
            def senderAccount = Iban.of("PL19249000052632432769159267")
            def transferRequest = transferRequest()


        when:
            1 * accountRepository.getAccount(senderAccount) >> account
            1 * accountRepository.accountBelongsToUser(_ as Iban, _ as Long) >> true
            1 * userRepository.getUser(userId) >> user
            1 * transferRepository.saveTransfer(_ as Transfer) >> 1L

        then:
            def response = transferService.saveTransfer(transferRequest)
            def savedTransfer = response.getTransfer()

            response.getResponseStatus() == TransferResponseStatus.OK

            savedTransfer.getAmount() == transferRequest.getAmount()
            savedTransfer.getTitle() == transferRequest.getTitle()
            savedTransfer.getSenderAccount() == transferRequest.getSenderAccount()
            savedTransfer.getSenderAddress() == user.getAddress()
            savedTransfer.getSenderName() == user.getName()
            savedTransfer.getRecipientAccount() == transferRequest.getRecipientAccount()
            savedTransfer.getRecipientName() == transferRequest.getRecipientName()
            savedTransfer.getRecipientAddress() == transferRequest.getRecipientAddress()
            savedTransfer.getSendDate() == transferRequest.getSendDate()
            savedTransfer.getBalanceAfter() == account.getAvailableFunds() - transferRequest.getAmount()
            savedTransfer.getId() == 1L
            account.getAvailableFunds() == savedTransfer.getBalanceAfter()
    }

    def "negative way"() {
        given:
            def user = getUser() as User
            def account = invalidAccount(dailyLimit, availableFunds)
            def transferRequest = transferRequest()

        when:
            1 * accountRepository.getAccount(_ as Account) >> account
            1 * accountRepository.accountBelongsToUser(_,_) >>accountBelongsToUser
            1 * userRepository.getUser(userId) >> user
            0 * transferRepository.saveTransfer(_ as Transfer) >> 1L

        then:
            def transferResponse = transferService.saveTransfer(transferRequest)
            transferResponse.getResponseStatus() == transferStatus

        where:
            dailyLimit  |   availableFunds  |   accountBelongsToUser    |   transferStatus
            100.00      |   300.00          |   true                    |   TransferResponseStatus.LIMIT_EXCEEDED
            1000.00     |   100.00          |   true                    |   TransferResponseStatus.FUNDS_NOT_AVAILABLE
            1000.00     |   300.00          |   false                   |   TransferResponseStatus.ACCOUNT_NOT_AVAILABLE
    }

    def transferRequest() {
        [
                senderAccount: Iban.of("PL19249000052632432769159267"),
                recipientAccount: Iban.of("PL58249000059226380531859730"),
                recipientName: "Krystyna Nowak",
                recipientAddress: "ul.Zwyczajna 2/1",
                sendDate: LocalDateTime.now().plusDays(1L),
                amount: 250.00 as BigDecimal,
                title: "Przelew zwykły",
                userId: 1L
        ] as TransferRequest
    }

    def invalidAccount(dailyLimit, availableFunds){
        [
                accountName: "Konto Osobiste",
                balance: 300.00 as BigDecimal,
                availableFunds: availableFunds,
                dailyLimit: dailyLimit,
                ownerId: 1L,
                iban: Iban.of("PL58249000059226380531859730")
        ] as Account
    }
}
