package ninja.harmless.vishnu.common.hateoas;

import org.springframework.hateoas.core.DummyInvocationUtils;
import org.springframework.hateoas.mvc.ControllerLinkBuilderFactory;
import org.springframework.util.StringValueResolver;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Custom {@link ControllerLinkBuilderFactory} which resolves a placeholder and
 * replaces the path in the {@link UriComponentsBuilder} with the resolved path.
 *
 * @author bnjm@harmless.ninja - 12/10/16.
 */
public class LinkBuilderFactory extends ControllerLinkBuilderFactory {

    private StringValueResolver stringValueResolver;

    @Override
    protected UriComponentsBuilder applyUriComponentsContributer(UriComponentsBuilder builder, DummyInvocationUtils.MethodInvocation invocation) {
        UriComponentsBuilder r = super.applyUriComponentsContributer(builder, invocation);
        String path = r.build().getPath();
        String resolvedPath = stringValueResolver.resolveStringValue(path);
        r.replacePath(resolvedPath);
        return r;
    }

    public void setResolver(StringValueResolver resolver) {
        this.stringValueResolver = resolver;
    }
}