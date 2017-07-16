package ninja.harmless.vishnu.common.controller;

import ninja.harmless.vishnu.common.data.DataService;
import ninja.harmless.vishnu.common.exception.MalformedUUIDException;
import ninja.harmless.vishnu.common.exception.RequestParameterNotFoundException;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

/**
 * Represents a generic REST controller.
 *
 * @author bnjm@harmless.ninja - 7/16/17.
 */
public abstract class GenericCrudController<R extends ResourceSupport> {

    private DataService<R> dataService;

    public GenericCrudController(DataService<R> dataService) {
        this.dataService = dataService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<R> getOne(@PathVariable String id) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new MalformedUUIDException("Could not convert String to UUID (length < 5)", e);
        }
        return new ResponseEntity<>(dataService.findOneByUUID(uuid), OK);
    }


    @GetMapping(params = "q", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<R>> getAll(@RequestParam String q) {
        if ("all".equalsIgnoreCase(q)) {
            return new ResponseEntity<>(dataService.findAll(), OK);
        }
        throw new RequestParameterNotFoundException("Request parameter {" + q + "} is not mapped");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedResources<R>> getPaged(@RequestParam(value = "size", defaultValue = "15") int size,
                                                      @RequestParam(value = "page", defaultValue = "0") int page) {
        return new ResponseEntity<>(dataService.get(size, page), OK);
    }

    @PostMapping
    public ResponseEntity<R> insert(@RequestBody R body) {
        dataService.insert(body);
        return new ResponseEntity<>(CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<R> delete(@PathVariable String id) {
        dataService.delete(UUID.fromString(id));
        return new ResponseEntity<>(GONE);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<R> update(@RequestBody R body) {
        return new ResponseEntity<>(dataService.update(body), OK);
    }
}
