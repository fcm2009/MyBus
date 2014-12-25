import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by st201138010 on 12/26/2014.
 */
public class Test {

    public static void main(String[] args) {
        try {
            Bus a = new Bus(1l);
        } catch (SQLException e) {
            System.out.print(e.getMessage() + "*********");
        }
    }
}
