package ninja.harmless.vishnu.flight.model.entity;

/**
 * @author bnjm@harmless.ninja - 7/24/17.
 */
public enum FlightStatus {
    DEPARTED("departed"),
    DELAYED("delayed"),
    IN_FLIGHT("in flight"),
    LANDED("landed"),
    ON_APPROACH("on approach");

    private String stringValue;

    FlightStatus(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public static FlightStatus fromStringValue(String stringValue) {
        for (FlightStatus flightStatus : FlightStatus.values()) {
            if (flightStatus.getStringValue().equalsIgnoreCase(stringValue)) {
                return flightStatus;
            }
        }
        return null;
    }
}
