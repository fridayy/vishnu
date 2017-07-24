import HrefResource from './href.entity';

interface LinkResource {
  first: HrefResource,
  self: HrefResource,
  next: HrefResource,
  last: HrefResource
}

export default LinkResource;
