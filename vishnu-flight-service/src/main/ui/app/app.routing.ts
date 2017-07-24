import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './component/home/home.component';
import {AirlinesComponent} from './component/airlines/airlines.component';
import {PagedContentComponent} from 'app/component/paged-content/paged-content.component';
import {AirplaneComponent} from './component/airplane/airplane.component';
import {CountryComponent} from 'app/component/country/country.component';
import {AirportComponent} from './component/airport/airport.component';
import {FlightComponent} from './component/flight/flight.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'paged', component: PagedContentComponent, children: [
    {path: 'airlines', component: AirlinesComponent, outlet: 'paged'},
    {path: 'airplanes', component: AirplaneComponent, outlet: 'paged'},
    {path: 'airports', component: AirportComponent, outlet: 'paged'},
    {path: 'countries', component: CountryComponent, outlet: 'paged'},
    {path: 'flights', component: FlightComponent, outlet: 'paged'},
  ]}
];

export const routing = RouterModule.forRoot(routes);
