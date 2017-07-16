package ninja.harmless.vishnu.common.config;

import ninja.harmless.vishnu.common.hateoas.LinkBuilderAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
@Configuration
public class WebConfiguration {
    @Bean
    LinkBuilderAdapter linkBuilderAdapter() {
        return new LinkBuilderAdapter();
    }
}
