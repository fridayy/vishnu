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
                            this.circleContainer[next.flightNumber] = {items: [], color: this.generateColor()};
                        }
                        const circle = leaflet.circle([next.latLon.lat, next.latLon.lon],
                            {color: this.circleContainer[next.flightNumber].color});
                        circle.bindPopup('<b>Flight Number: </b> '
                            + next.flightNumber + '<br><b>From:</b> ' + next.from.city +
                        '<br><b>To: </b>' + next.to.city
                        );
                        this.circleContainer[next.flightNumber].items.push(circle);
                        circle.addTo(map);
                    } else if (next.status === 'landed' && this.circleContainer[next.flightNumber] !== undefined) {
                        this.circleContainer[next.flightNumber].items.forEach(i => {
                            i.remove();
                        });
                    }
                });
            });
    }

    generateColor(): string {
        const colors: Array<string> = [
            '#f44336',
            '#E91E63',
            '#9C27B0',
            '#673AB7',
            '#3F51B5',
            '#2196F3',
            '#03A9F4',
            '#00BCD4',
            '#009688',
            '#4CAF50',
            '#CDDC39',
            '#FFEB3B',
            '#FFC107',
            '#FF9800',
            '#FF5722',
            '#795548',
            '#263238',

        ];

        const min = 0;
        const max = colors.length;
        const selector = Math.floor(Math.random() * (max - min + 1)) + min;

        return colors[selector];
    }
}
