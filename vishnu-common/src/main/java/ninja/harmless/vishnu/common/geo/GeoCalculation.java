package ninja.harmless.vishnu.common.geo;

import ninja.harmless.vishnu.common.resource.LatLon;

import static java.lang.Math.*;

/**
 * Provides Geo calculation conviencies methods
 *
 * @author bnjm@harmless.ninja - 8/7/17.
 */
public abstract class GeoCalculation {

    private static final double EARTH_RADIUS = 6371d;

    /**
     * Calculates the projected next point given the speed and time e.g: 700km/h
     *
     * @param current
     * @param target
     * @return
     */
    public static LatLon calculateProjectedPosition(LatLon current, LatLon target) {
        double speed = 194.4444 / 100;
        double time = 2;

        double distance = (speed * time);

        double Y = sin(toRadians(target.getLon() - current.getLon())) * cos(toRadians(target.getLat()));
        double X = cos(toRadians(current.getLat())) * sin(toRadians(target.getLat())) - sin(toRadians(current.getLat()))
                * cos(toRadians(target.getLat())) * cos(toRadians(target.getLon() - current.getLon()));

        double bearing = toDegrees(atan2(Y, X));

        double lat2 = Math.asin(sin(PI / 180 * current.getLat()) * cos(distance / EARTH_RADIUS) +
                cos(PI / 180 * current.getLat()) * sin(distance / EARTH_RADIUS) * cos(PI / 180 * bearing));

        double lon2 = PI / 180 * current.getLon() + atan2(sin(PI / 180 * bearing)
                        * sin(distance / EARTH_RADIUS) * cos(PI / 180 * current.getLat()),
                cos(distance / EARTH_RADIUS) - sin(PI / 180 * current.getLat()) * sin(lat2));

        double correctedLat = 180 / PI * lat2;
        double correctedLon = 180 / PI * lon2;

        return new LatLon(correctedLat, correctedLon);
    }
}
