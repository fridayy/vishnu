import CountryResource from './country.entity';
import CountryLinkResource from './CountryLinkResource';

interface AirportResource {
  iataCode: string,
  city: string,
  uuid: string,
  _links: CountryLinkResource,
  concreteCountry: CountryResource
}

export default AirportResource;
