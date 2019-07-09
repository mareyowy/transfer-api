import spock.lang.Specification

class FirstSpecification extends Specification {

   def "2 plus 2 equals 4"() {
        given:
            int first = 2
            int second = 2
        when:
            int result = first + second
        then:
            result == 4
    }
}
