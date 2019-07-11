package groovy.transfer

import com.marey.transferapi.transfer.model.Iban
import spock.lang.Specification

class IbanSpecification extends Specification {

    def "iban with spaces should equals to iban without them"() {
        when:
            def ibanWithoutSpaces = Iban.of("PL25249000055769185431610563")
            def ibanWithSpaces = Iban.of("PL25 2490 0005 5769 1854 3161 0563")
        then:
            ibanWithoutSpaces == ibanWithSpaces

    }
}
