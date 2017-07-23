package ninja.harmless.vishnu.airplane.model

import ninja.harmless.vishnu.airplane.model.entity.Airplane
import ninja.harmless.vishnu.common.exception.ResourceNotFoundException
import ninja.harmless.vishnu.common.hateoas.ResourceDisassembler
import ninja.harmless.vishnu.common.resource.AirplaneResource
import org.springframework.hateoas.ResourceAssembler
import spock.lang.Specification
/**
 * @author bnjm@harmless.ninja - 7/23/17.
 */
class AirplaneDataServiceTest extends Specification {
    
    AirplaneDataService classUnderTest
    
    void "returns correct entity when using findOneByUUID"() {
        given:
            AirplaneRepository mockedRepository = Mock(AirplaneRepository)
            ResourceAssembler mockedAssembler = Mock(ResourceAssembler)
            ResourceDisassembler mockedDisassembler = Mock(ResourceDisassembler)
            classUnderTest = new AirplaneDataService(
                    mockedRepository, mockedAssembler, mockedDisassembler)
            Airplane mockedAirplane = new Airplane("TEST", 100)
            mockedRepository.findAirplaneByUuid(*_) >> Optional.of(mockedAirplane)
            AirplaneResource mockedResource = new AirplaneResource("TEST", 100, mockedAirplane.uuid)
            mockedAssembler.toResource(mockedAirplane) >> mockedResource
        when:
            def result = classUnderTest.findOneByUUID(UUID.randomUUID())
        then:
            result == mockedResource
    }
    
    void "throws exception if nothing was found by findOneByUUID"() {
        given:
            AirplaneRepository mockedRepository = Mock(AirplaneRepository)
            ResourceAssembler mockedAssembler = Mock(ResourceAssembler)
            ResourceDisassembler mockedDisassembler = Mock(ResourceDisassembler)
            classUnderTest = new AirplaneDataService(
                    mockedRepository, mockedAssembler, mockedDisassembler)
            mockedRepository.findAirplaneByUuid(*_) >> Optional.empty()
        when:
            classUnderTest.findOneByUUID(UUID.randomUUID())
        then:
            thrown(ResourceNotFoundException)
    }
    
    void "returns an entity when delete is called"() {
        given:
            AirplaneRepository mockedRepository = Mock(AirplaneRepository)
            ResourceAssembler mockedAssembler = Mock(ResourceAssembler)
            ResourceDisassembler mockedDisassembler = Mock(ResourceDisassembler)
            classUnderTest = new AirplaneDataService(
                    mockedRepository, mockedAssembler, mockedDisassembler)
            Airplane mockedAirplane = new Airplane("TEST", 100)
            mockedRepository.findAirplaneByUuid(*_) >> Optional.of(mockedAirplane)
            AirplaneResource mockedResource = new AirplaneResource("TEST", 100, mockedAirplane.uuid)
            mockedAssembler.toResource(mockedAirplane) >> mockedResource
        when:
            def result = classUnderTest.delete(UUID.randomUUID())
        then:
            1 * mockedRepository.deleteAirplaneByUuid(*_)
            result == mockedResource
    }
    
    void "throws exception if entity wasn't found (delete)"() {
        given:
            AirplaneRepository mockedRepository = Mock(AirplaneRepository)
            ResourceAssembler mockedAssembler = Mock(ResourceAssembler)
            ResourceDisassembler mockedDisassembler = Mock(ResourceDisassembler)
            classUnderTest = new AirplaneDataService(
                    mockedRepository, mockedAssembler, mockedDisassembler)
            mockedRepository.findAirplaneByUuid(*_) >> Optional.empty()
        when:
            classUnderTest.delete(UUID.randomUUID())
        then:
            thrown(ResourceNotFoundException)
    }
    
    void "update works as expected"() {
        given:
            AirplaneRepository mockedRepository = Mock(AirplaneRepository)
            ResourceAssembler mockedAssembler = Mock(ResourceAssembler)
            ResourceDisassembler mockedDisassembler = Mock(ResourceDisassembler)
            classUnderTest = new AirplaneDataService(
                    mockedRepository, mockedAssembler, mockedDisassembler)
            Airplane mockedAirplane = new Airplane("TEST", 100)
            mockedRepository.findAirplaneByUuid(*_) >> Optional.of(mockedAirplane)
            AirplaneResource mockedResource = new AirplaneResource("TEST", 100, mockedAirplane.uuid)
            mockedDisassembler.fromResource(mockedResource) >> mockedAirplane
        when:
            def result = classUnderTest.update(mockedResource)
        then:
            result.typeDeclaration == mockedAirplane.typeDeclaration
            result.capacity == mockedAirplane.capacity
            1 * mockedRepository.save(mockedAirplane)
    }
}
