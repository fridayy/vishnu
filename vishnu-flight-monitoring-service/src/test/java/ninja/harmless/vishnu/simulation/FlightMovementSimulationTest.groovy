package ninja.harmless.vishnu.simulation

import ninja.harmless.vishnu.common.resource.LatLon
import ninja.harmless.vishnu.repository.ReactiveFlightRepository
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

/**
 * @author bnjm@harmless.ninja - 8/7/17.
 */
class FlightMovementSimulationTest extends Specification {
    @Subject
    FlightMovementSimulation classUnderTest

    @Unroll
    void "has arrived"() {
        given:
            ReactiveFlightRepository mockedRepository = Mock(ReactiveFlightRepository)
            classUnderTest = new FlightMovementSimulation(mockedRepository)
        when:
            def result = classUnderTest.hasArrived(new LatLon(lat, lon), new LatLon(46.99110031, 15.43959999))
        then:
            result == expectation
        where:
            lat               | lon               || expectation
            46.991832400481   | 15.4403201019421  || true
            47.0150638995419  | 15.4631840460949  || false
            49.0150638995419  | 11.4631840460949  || false
            -49.0150638995419 | -11.4631840460949 || false
            46.992            | 15.441            || true
            46.992832400481   | 15.4423201019421  || true


    }
}
