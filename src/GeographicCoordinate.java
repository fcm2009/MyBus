import java.io.Serializable;

/**
 * Created by Mohammed Alshehry on 12/24/14.
 */
public class GeographicCoordinate implements Comparable, Serializable {

    private Double latitude;
    private Double longitude;
    private final static int earthRadius = 6371;

    public GeographicCoordinate(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public GeographicCoordinate() {
        this(null, null);
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public double calculateDistance(GeographicCoordinate gs) {
        double latitude1 = Math.toRadians(this.latitude);
        double latitude2 = Math.toRadians(gs.getLatitude());
        double latitudeChange = Math.toRadians(gs.getLatitude() - this.getLatitude());
        double longitudeChange = Math.toRadians(gs.getLongitude() - this.longitude);

        double a = Math.sin(latitudeChange / 2.0) * Math.sin(latitudeChange / 2.0) +
                Math.cos(latitude1) * Math.cos(latitude2) *
                        Math.sin(longitudeChange / 2.0) * Math.sin(longitudeChange / 2.0);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return Math.round(earthRadius * c);
    }

    @Override
    public int compareTo(Object o) {
        if(o != null) {
            if(o instanceof GeographicCoordinate) {
                GeographicCoordinate gc = (GeographicCoordinate) o;
                if(this.latitude.compareTo(gc.getLatitude()) == 0)
                    return this.longitude.compareTo(gc.getLongitude());
                else
                    return this.latitude.compareTo(gc.getLatitude());
            }
            else
                throw new ClassCastException();
        }
        else
            throw new NullPointerException();
    }
}
