package ninja.harmless.vishnu.common.hateoas;

import org.springframework.hateoas.ResourceSupport;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
public interface ResourceDisassmbler<R extends ResourceSupport, T> {
    T fromResource(R resource);
}
