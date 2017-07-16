package ninja.harmless.vishnu.common.data;

import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;
import java.util.UUID;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
public interface DataService<R extends ResourceSupport> {

    R findOneById(Long id);

    PagedResources<R> get(int size, int page);

    R findOneByUUID(UUID uuid);

    List<R> findAll();

    R insert(R entity);

    R delete(UUID uuid);

    R update(R entity);

}