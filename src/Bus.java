import java.io.Serializable;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Bus implements Comparable, Serializable {

    private int number;
    private String chassis;
    private Type type;
    private String model;
    private String manufacturer;
    private String plate;
    private int capacity;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public Type type() {
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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

    @Override
    public String toString() {
        return "" + number;
    }

}
