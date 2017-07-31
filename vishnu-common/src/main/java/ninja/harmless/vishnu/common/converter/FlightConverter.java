package ninja.harmless.vishnu.common.converter;

import ninja.harmless.vishnu.common.resource.FlightResource;
import ninja.harmless.vishnu.common.resource.RawFlightResource;

import java.time.LocalDateTime;

/**
 * @author bnjm@harmless.ninja - 7/31/17.
 */
public class FlightConverter implements Converter<RawFlightResource, FlightResource> {
    @Override
    public RawFlightResource convert(FlightResource obj) {
        return new RawFlightResource(
                obj.getFrom(),
                obj.getTo(),
                LocalDateTime.parse(obj.getDepartureTime()),
                LocalDateTime.parse(obj.getArrivalTime()),
                obj.getFlightNumber(),
                obj.getAirplane(),
                obj.getOperator(),
                obj.getUuid(),
                obj.getStatus()
        );
    }

}
