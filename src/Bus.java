import java.io.Serializable;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Bus implements Comparable, Serializable {

    private String id;
    private String chassis;
    private Type type;
    private String model;
    private String manufacturer;
    private String plate;
    private Integer capacity;
    private Following following;

    public Bus(String id, String chassis, Type type, String model, String manufacturer, String plate, Integer capacity, Following following) {
        this.id = id;
        this.chassis = chassis;
        this.type = type;
        this.model = model;
        this.manufacturer = manufacturer;
        this.plate = plate;
        this.capacity = capacity;
        this.following = following;
    }

    public Bus() {
        this(null, null, null, null, null, null, null, null);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public Type getType() {
        return type;
    }

    public void setTrype(String trype) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Following getFollowing() {
        return following;
    }

    public void setFollowing(Following following) {
        this.following = following;
    }

    @Override
    public int compareTo(Object o) {
        if(o != null) {
            if(o instanceof Bus) {
                Bus bus = (Bus) o;
                return this.chassis.compareTo(bus.getChassis());
            }
            else
                throw new ClassCastException();
        }
        else
            throw new NullPointerException();
    }

    @Override
    public boolean equals(Object obj) {
        return this.compareTo(obj) == 0;
    }

}
