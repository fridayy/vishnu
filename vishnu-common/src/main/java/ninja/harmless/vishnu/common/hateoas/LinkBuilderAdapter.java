package ninja.harmless.vishnu.common.hateoas;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.util.StringValueResolver;

/**
 * Custom {@link ControllerLinkBuilder} able to resolve property placeholders like ${api.version}
 * since the {@link ControllerLinkBuilder} does not resolve property placeholders.
 *
 * @author bnjm@harmless.ninja - 12/10/16.
 */
public class LinkBuilderAdapter implements EmbeddedValueResolverAware {

    private static final LinkBuilderFactory FACTORY = new LinkBuilderFactory();
    private StringValueResolver resolver;

    public static ControllerLinkBuilder linkTo(Object invocationValue) {
        return FACTORY.linkTo(invocationValue);
    }

    public static <T> T methodOn(Class<T> controller, Object... parameters) {
        return ControllerLinkBuilder.methodOn(controller, parameters);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        FACTORY.setResolver(resolver);
    }
}
