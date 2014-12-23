import java.io.Serializable;

/**
 * Created by Mohammed Alshehry on 12/24/14.
 */
public class City implements Comparable, Serializable {

    private String name;
    private String country;
    private GeographicCoordinate geographicCoordinate;

    public City(String name, String country, GeographicCoordinate geographicCoordinate) {
        this.name = name;
        this.country = country;
        this.geographicCoordinate = geographicCoordinate;
    }

    public City() {
        this(null, null, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GeographicCoordinate getGeographicCoordinate() {
        return geographicCoordinate;
    }

    public void setGeographicCoordinate(GeographicCoordinate geographicCoordinate) {
        this.geographicCoordinate = geographicCoordinate;
    }

    @Override
    public int compareTo(Object o) {
        if(o != null) {
            if(o instanceof City) {
                City city = (City) o;
                if(this.country.compareTo(city.getCountry()) == 0)
                    return this.name.compareTo(city.getName());
                else
                    return this.country.compareTo(city.getCountry());
            }
            else
                throw new ClassCastException();
        }
        else
            throw new NullPointerException();
    }
}
