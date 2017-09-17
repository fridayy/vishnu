package ninja.harmless.vishnu.model

import javax.persistence.Entity
import javax.persistence.Id

/**
 * @author bnjm@harmless.ninja - 9/12/17.
 */
@Entity
class Passenger {
    @Id
    UUID id

    String firstName
    String lastName
    String passportNumber
}
