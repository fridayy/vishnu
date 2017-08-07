package ninja.harmless.vishnu.common.geo;

import ninja.harmless.vishnu.common.resource.LatLon;

/**
 * Provides Geo calculation conviencies methods
 *
 * @author bnjm@harmless.ninja - 8/7/17.
 */
public abstract class GeoCalculation {

    private static final double EARTH_RADIUS = 6371d;

    /**
     * Calculates the projected next point given the speed and time e.g: 700km/h
     * @param current
     * @param target
     * @return
     */
    public static LatLon calculateProjectedPosition(LatLon current, LatLon target) {
        double speed = 194.4444 / 1000;
        double time = 2;

        double distance = (speed * time);

        double Y = Math.sin(Math.toRadians(target.getLon() - current.getLon())) * Math.cos(Math.toRadians(target.getLat()));
        double X = Math.cos(Math.toRadians(current.getLat()))*Math.sin(Math.toRadians(target.getLat())) - Math.sin(Math.toRadians(current.getLat()))*Math.cos(Math.toRadians(target.getLat()))*Math.cos(Math.toRadians(target.getLon() - current.getLon()));

        double bearing = Math.toDegrees(Math.atan2(Y,X));


        double lat2 = Math.asin(Math.sin(Math.PI / 180 * current.getLat()) * Math.cos(distance / EARTH_RADIUS) +
                Math.cos(Math.PI / 180 * current.getLat()) * Math.sin(distance / EARTH_RADIUS) * Math.cos(Math.PI / 180 * bearing));

        double lon2 = Math.PI / 180 * current.getLon() + Math.atan2(Math.sin( Math.PI / 180 * bearing)
                * Math.sin(distance / EARTH_RADIUS) * Math.cos( Math.PI / 180 * current.getLat() ),
                Math.cos(distance / EARTH_RADIUS) - Math.sin( Math.PI / 180 * current.getLat()) * Math.sin(lat2));

        double lat22 =  180 / Math.PI * lat2;
        double lon22 = 180 / Math.PI * lon2;

        return new LatLon(lat22, lon22);
    }
}
