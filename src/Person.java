import java.util.Date;

/**
 * Created by Mohammed Alshehry on 12/23/14.
 */
public abstract class Person implements Comparable {

    private String id;
    private Gender gender;
    private String name;
    private String phone;

    public Person(String id, Gender gender, String name, String phone) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.phone = phone;
    }

    public Person(String id, Gender gender) {
        this(id, gender, null, null);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int compareTo(Object o) {
        if(o != null) {
            if(o instanceof Person) {
                Person person = (Person) o;
                return this.id.compareTo(person.id);
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
