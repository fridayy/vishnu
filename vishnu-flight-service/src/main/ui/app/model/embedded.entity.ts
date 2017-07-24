import AirlineResource from './airline.entity';
import AirplaneResource from './airplane.entity';
import CountryResource from './country.entity';
import AirportResource from './airport.entity';
import FlightResource from './flight.entity';

interface EmbeddedResource {
  airlineResourceList: AirlineResource[],
  airplaneResourceList: AirplaneResource[],
  countryResourceList: CountryResource[],
  airportResourceList: AirportResource[],
  flightResourceList: FlightResource[]
}

export default EmbeddedResource;
