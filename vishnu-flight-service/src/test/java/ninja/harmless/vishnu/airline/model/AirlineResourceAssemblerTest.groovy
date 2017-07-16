package ninja.harmless.vishnu.airline.model

import ninja.harmless.vishnu.airline.model.entity.Airline
import org.springframework.hateoas.ResourceSupport
import spock.lang.Specification
import spock.lang.Subject

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
class AirlineResourceAssemblerTest extends Specification {

    @Subject
    AirlineResourceAssembler classUnderTest

    void setup() {
        classUnderTest = new AirlineResourceAssembler()
    }

    void "assembles as expected"() {
        given:
            Airline airline = new Airline("Lufthansa")
        when:
            def result = classUnderTest.toResource(airline)
        then:
            result instanceof ResourceSupport
            result.name == airline.name
            result.uuid == airline.uuid
    }
}
