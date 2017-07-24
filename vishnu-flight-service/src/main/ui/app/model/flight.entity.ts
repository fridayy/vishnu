import AirportResource from './airport.entity';
import AirplaneResource from './airplane.entity';
import AirlineResource from './airline.entity';

interface FlightResource {
  depatureTime: Date,
  arrivalTime: Date,
  flightNumber: string,
  uuid: string,
  from: AirportResource,
  to: AirportResource,
  airplane: AirplaneResource,
  airline: AirlineResource,
  status: string,
  // Navigational HATEOAS links
  _links: {
    from: { href: string },
    to: { href: string },
    airplane: { href: string },
    airline: { href: string },
  }
}

export default FlightResource;

