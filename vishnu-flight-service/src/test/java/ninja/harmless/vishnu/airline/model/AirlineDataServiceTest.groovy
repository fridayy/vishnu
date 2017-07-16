package ninja.harmless.vishnu.airline.model

import ninja.harmless.vishnu.airline.model.entity.Airline
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException
import ninja.harmless.vishnu.common.hateoas.ResourceDisassmbler
import ninja.harmless.vishnu.common.resource.AirlineResource
import org.springframework.hateoas.ResourceAssembler
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
            
            ResourceAssembler mockedResourceAssembler = Mock(ResourceAssembler)
            mockedResourceAssembler.toResource(_) >> new AirlineResource(input.uuid, input.name)
            ResourceDisassmbler mockedDisassembler = Mock(ResourceDisassmbler)
            classUnderTest = new AirlineDataService(mockedRepository, mockedResourceAssembler, mockedDisassembler)
        when:
            def result = classUnderTest.findOneById(1L)
        then:
            result instanceof ResourceSupport
            result.name == input.name
            result.uuid == input.uuid
        where:
            input                    || _
            new Airline("Bla")       || _
            new Airline("Lufthansa") || _
        
    }
    
    void "findOne() is null safe"() {
        given:
            AirlineRepository mockedRepository = Mock(AirlineRepository)
            mockedRepository.findById(_) >> Optional.ofNullable(null)
            
            ResourceAssembler mockedResourceAssembler = Mock(ResourceAssembler)
            mockedResourceAssembler.toResource(_) >> null
            ResourceDisassmbler mockedDisassembler = Mock(ResourceDisassmbler)
            classUnderTest = new AirlineDataService(mockedRepository, mockedResourceAssembler, mockedDisassembler)
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
            ResourceAssembler mockedResourceAssembler = Mock(ResourceAssembler)
            mockedResourceAssembler.toResource(_) >> new AirlineResource(airline.uuid, airline.name)
            ResourceDisassmbler mockedDisassembler = Mock(ResourceDisassmbler)
            classUnderTest = new AirlineDataService(mockedRepository, mockedResourceAssembler, mockedDisassembler)
        when:
            def result = classUnderTest.findOneByUUID(airline.uuid)
        then:
            result instanceof ResourceSupport
            result.name == airline.name
            result.uuid == airline.uuid
    }
}
