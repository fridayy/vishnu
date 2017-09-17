package ninja.harmless.vishnu.repository

import ninja.harmless.vishnu.model.Passenger
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
/**
 * @author bnjm@harmless.ninja - 9/12/17.
 */
@RepositoryRestResource(collectionResourceRel = "passenger", path = "passenger")
interface PassengerRepository extends PagingAndSortingRepository<Passenger, UUID> {

}