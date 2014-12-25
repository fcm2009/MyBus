import java.io.Serializable;
import java.util.*;
import java.sql.*;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public class Bus extends TextualId implements Comparable, Serializable {

    private Long id;
    private String chassis;
    private Type type;
    private String model;
    private String manufacturer;
    private String plate;
    private Integer capacity;
    private ArrayList<Plan> plansList;
    private ArrayList<Authorization> authorizationList;

    public Bus(Long id, String chassis,  Type type, String model, String manufacturer, String plate, Integer capacity) {
        this.id = id;
        this.chassis = chassis;
        this.type = type;
        this.model = model;
        this.manufacturer = manufacturer;
        this.plate = plate;
        this.capacity = capacity;
        this.plansList = new ArrayList<Plan>();
        this.authorizationList = new ArrayList<Authorization>();
    }

    public Bus(Long id) throws SQLException {
        ResultSet tmp = NumericalId.createTextualId(id, this.getClass());
        tmp.next();
        this.id = tmp.getLong(1);
        this.chassis = tmp.getString(2);
        this.type = Type.valueOf(tmp.getString(3));
        this.model = tmp.getString(4);
        this.manufacturer = tmp.getString(5);
        this.plate = tmp.getString(6);
        this.capacity = tmp.getInt(7);
        this.plansList = new ArrayList<Plan>();
        this.authorizationList = new ArrayList<Authorization>();
        SQLTable.closeConnection();
    }

    public Bus() {
        this(null, null, null, null, null, null, null);
    }

    public Long getId() {
        return id;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) throws SQLException {
        this.chassis = chassis;
        String query = "UPDATE BUS SET chassis = " + getChassis()
                + " where CHASSIS = '" + getChassis() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) throws SQLException {
        this.type = type;

        String query = "update bus " +
                "set CLASS = '" + getType() + "' " +
                "where CHASSIS_NUM = '" + getChassis() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) throws SQLException {
        this.model = model;

        String query = "update bus " +
                "set model = '" + getModel() + "' " +
                "where CHASSIS_NUM = '" + getChassis() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) throws SQLException {
        this.manufacturer = manufacturer;

        String query = "update bus " +
                "set manufacturer = '" + getManufacturer() + "' " +
                "where CHASSIS_NUM = '" + getChassis() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) throws SQLException {
        this.plate = plate;

        String query = "update bus " +
                "set plate_number = '" + getPlate() + "' " +
                "where ch = '" + getChassis() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) throws SQLException {
        this.capacity = capacity;

        String query = "update bus " +
                "set capacity = " + getCapacity() + " " +
                "where CHASSIS_NUM = '" + getChassis() + "'";
        connectToDB().execute(query);
        closeConnection();
    }

    public void addAuthorization(Authorization authorization) {
        this.authorizationList.add(authorization);
    }

    public void deleteAuthorization(Authorization authorization) {
        this.authorizationList.remove(authorization);
    }

    public void addPlan(Plan plan) {
        this.plansList.add(plan);
    }

    public void deletePlan(Plan plan) {
        this.plansList.remove(plan);
    }

    @Override
    public void writeToDB() throws SQLException {
    	String query = "insert into Bus values("
    					+ capacity + ", '" + chassis + "', '" + type + "', '" + model + "', '" + manufacturer + "', '" + plate + "', " + chassis + ")";
    	connectToDB().execute(query);
        closeConnection();
    }

    @Override
    public void deleteFromDB() throws SQLException {
        String query = "DELETE FROM BUS WHERE CHASSIS_NUM = '" +  chassis + "'";
        connectToDB().execute(query);
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
