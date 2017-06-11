package ninja.harmless.vishnu.common

import spock.lang.Specification

/**
 * @author bnjm@harmless.ninja - 6/11/17.
 */
class ExampleSpockTest extends Specification {

    void "spock tests are running"() {
        given:
            String test = "test"
        when:
            println test
        then:
            noExceptionThrown()
    }
}
