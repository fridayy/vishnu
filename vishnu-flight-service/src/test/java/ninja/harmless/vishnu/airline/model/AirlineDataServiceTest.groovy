package ninja.harmless.vishnu.airline.model

import ninja.harmless.vishnu.airline.model.entity.Airline
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException
import org.springframework.hateoas.ResourceSupport
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
class AirlineDataServiceTest extends Specification {
    
    @Subject
    AirlineDataService classUnderTest
    
    @Unroll
    void "findOne(Long id) returns expected values"() {
        given:
            AirlineRepository mockedRepository = Mock(AirlineRepository)
            mockedRepository.findById(_) >> Optional.of(input)
            classUnderTest = new AirlineDataService(mockedRepository)
        when:
            def result = classUnderTest.findOneById(1L)
        then:
            result instanceof ResourceSupport
            result.name == input.name
            result.uuid == input.uuid
        where:
            input              || _
            new Airline("Bla") || _
            new Airline("Lufthansa") || _
        
    }
    
    void "findOne() is null safe"() {
        given:
            AirlineRepository mockedRepository = Mock(AirlineRepository)
            mockedRepository.findById(_) >> Optional.ofNullable(null)
            classUnderTest = new AirlineDataService(mockedRepository)
        when:
            classUnderTest.findOneById(1L)
        then:
            thrown(ResourceNotFoundException)
    }
    
    void "entities can be found with UUID"() {
        given:
            AirlineRepository mockedRepository = Mock(AirlineRepository)
            Airline airline = new Airline("TEST")
            mockedRepository.findAirlineByUuid(_) >> Optional.ofNullable(airline)
            classUnderTest = new AirlineDataService(mockedRepository)
        when:
            def result = classUnderTest.findOneByUUID(airline.uuid)
        then:
            result instanceof ResourceSupport
            result.name == airline.name
            result.uuid == airline.uuid
    }
}
