import {Component, NgZone, OnInit} from '@angular/core';
import {SseService} from '../../service/sse.service';
import * as leaflet from 'leaflet';
import LeafletCircleContainer from '../../model/leaflet-circle-container.model';

@Component({
    selector: 'app-monitor',
    templateUrl: './monitor.component.html',
    styleUrls: ['./monitor.component.css']
})
export class MonitorComponent implements OnInit {
    tileLayer: any;
    zone: NgZone;
    l: any;
    circleContainer: any = {};

    constructor(private sseService: SseService) {
        this.l = leaflet;
        this.tileLayer = leaflet.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            maxZoom: 19,
            attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
        });
        this.zone = new NgZone({enableLongStackTrace: false});
    }

    ngOnInit(): void {
        const map = leaflet.map('mapid').setView([51.505, -0.09], 4);
        map.addLayer(this.tileLayer);
        this.sseService.get().subscribe();

        // leaflet.geoJSON(geojsonFeature).addTo(map);
        this.sseService.get()
            .map(next => JSON.parse(next))
            .subscribe(next => {
                this.zone.run(() => {
                    if (next.status !== 'landed') {
                        if (this.circleContainer[next.flightNumber] === undefined) {
                            this.circleContainer[next.flightNumber] = []
                        }
                        const circle = leaflet.circle([next.latLon.lat, next.latLon.lon]);
                        this.circleContainer[next.flightNumber].push(circle);
                        circle.addTo(map);
                        console.log(this.circleContainer);
                    } else if (next.status === 'landed') {
                        this.circleContainer[next.flightNumber].forEach(i => {
                            i.remove();
                            console.log('remove circle');
                        });
                        this.circleContainer[next.flightNumber] = [];
                    }
                });
            });
    }
}
