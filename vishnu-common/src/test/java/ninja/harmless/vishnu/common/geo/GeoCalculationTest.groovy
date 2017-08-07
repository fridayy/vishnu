package ninja.harmless.vishnu.common.geo

import ninja.harmless.vishnu.common.resource.LatLon
import spock.lang.Specification

/**
 * @author bnjm@harmless.ninja - 8/7/17.
 */
class GeoCalculationTest extends Specification {
    void "returns correct result"() {
        given:
            LatLon initial = new LatLon(39.099912, -94.581213)
            LatLon target = new LatLon(38.627089, -90.200203)
        when:
            def result = GeoCalculation.calculateProjectedPosition(initial, target)
        then:
            result.lat == 39.09951523624032 as double
            result.lon == -94.5767354736298 as double
    }
}
