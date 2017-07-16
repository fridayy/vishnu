package ninja.harmless.vishnu.common.data;

import ninja.harmless.vishnu.common.exception.ResourceNotFoundException;
import ninja.harmless.vishnu.common.hateoas.ResourceDisassmbler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author bnjm@harmless.ninja - 7/16/17.
 */
public abstract class GenericDataService<T, R extends ResourceSupport> implements DataService<R> {

    protected PagingAndSortingRepository<T, Long> repository;
    protected ResourceAssembler<T, R> resourceAssembler;
    protected ResourceDisassmbler<R, T> resourceDisassmbler;

    public GenericDataService(PagingAndSortingRepository<T, Long> repository, ResourceAssembler<T, R> resourceAssembler, ResourceDisassmbler<R, T> resourceDisassmbler) {
        this.repository = repository;
        this.resourceAssembler = resourceAssembler;
        this.resourceDisassmbler = resourceDisassmbler;
    }

    @Override
    public R findOneById(Long id) {
        Optional<T> airline = repository.findById(id);

        return resourceAssembler.toResource(airline.orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public PagedResources<R> get(int size, int page) {
        Assert.notNull(size, "Size cannot be null");
        Assert.notNull(page, "Page cannot be null");

        Page<T> p = repository.findAll(PageRequest.of(page, size));
        PagedResourcesAssembler<T> pagedResourcesAssembler = new PagedResourcesAssembler<>(null, null);
        return pagedResourcesAssembler.toResource(p, resourceAssembler);
    }

    @Override
    public List<R> findAll() {
        List<T> items = (List<T>) repository.findAll();
        return items.stream().map(resourceAssembler::toResource).collect(Collectors.toList());
    }

    @Override
    public R insert(R entity) {
        Optional<R> optional = Optional.ofNullable(entity);
        T airline = resourceDisassmbler.fromResource(optional.orElseThrow(ResourceNotFoundException::new));
        repository.save(airline);

        return optional.orElseThrow(ResourceNotFoundException::new);
    }
}
