package groovy.traits

import com.marey.transferapi.account.model.Account
import com.marey.transferapi.transfer.model.Iban

trait AccountTrait {

    def accountList() {
         [
                [
                        accountName   : "Konto osobiste",
                        balance       : 20000.00 as BigDecimal,
                        availableFunds: 20000.00 as BigDecimal,
                        dailyLimit    : 1000.00 as BigDecimal,
                        ownerId       : 1L,
                        iban          : Iban.of("PL39249000059776064109923774")
                ] as Account,
                [
                        accountName   : "Konto osobiste",
                        balance       : 300000.00 as BigDecimal,
                        availableFunds: 300000.00 as BigDecimal,
                        dailyLimit    : 1000.00 as BigDecimal,
                        ownerId       : 1L,
                        iban          : Iban.of("PL10249000058638830642010725")
                ] as Account,
                [
                        accountName   : "Konto oszczędnościowe",
                        balance       : 1000.00 as BigDecimal,
                        availableFunds: 1000.00 as BigDecimal,
                        dailyLimit    : 500.00 as BigDecimal,
                        ownerId       : 2L,
                        iban          : Iban.of("PL19249000052632432769159267")
                ] as Account,
                [
                        accountName   : "Konto osobiste",
                        balance       : 20000.00 as BigDecimal,
                        availableFunds: 20000.00 as BigDecimal,
                        dailyLimit    : 1000.00 as BigDecimal,
                        ownerId       : 2L,
                        iban          : Iban.of("PL58249000059226380531859730")
                ] as Account,
                [
                        accountName   : "Konto osobiste",
                        balance       : 1000000.00 as BigDecimal,
                        availableFunds: 1000000.00 as BigDecimal,
                        dailyLimit    : 1000.00 as BigDecimal,
                        ownerId       : 3L,
                        iban          : Iban.of("PL85249000054157666476460084")
                ] as Account,
                [
                        accountName   : "Konto oszczędnościowe",
                        balance       : 20000.00 as BigDecimal,
                        availableFunds: 20000.00 as BigDecimal,
                        dailyLimit    : 1000.00 as BigDecimal,
                        ownerId       : 3L,
                        iban          : Iban.of("PL30249000053679780493680750")
                ] as Account
        ] as Set
    }

    def getAccount() {
        [
                accountName   : "Konto osobiste",
                balance       : 20000.00 as BigDecimal,
                availableFunds: 20000.00 as BigDecimal,
                dailyLimit    : 1000.00 as BigDecimal,
                ownerId       : 1L,
                iban          : Iban.of("PL39249000059776064109923774")
        ] as Account
    }

}