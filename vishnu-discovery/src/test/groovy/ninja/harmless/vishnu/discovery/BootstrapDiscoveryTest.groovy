package ninja.harmless.vishnu.discovery

import ninja.harmless.vishnu.common.test.category.SpringIntegrationTest
import org.junit.experimental.categories.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

/**
 * @author bnjm@harmless.ninja - 6/11/17.
 */
@Category(SpringIntegrationTest)
@SpringBootTest
class BootstrapDiscoveryTest extends Specification {
    @Autowired
    ApplicationContext ctx

    void "bootstraps as expected"() {
        expect:
            ctx != null
    }
}
