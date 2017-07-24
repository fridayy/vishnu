import LinkResource from './link.entity';
import EmbeddedResource from './embedded.entity';


interface HatoasResource {
  _embedded: EmbeddedResource,
  _links: LinkResource
  page: PageResource
}

export default HatoasResource
