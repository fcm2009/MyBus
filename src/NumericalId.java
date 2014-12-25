import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by st201138010 on 12/25/2014.
 */
public abstract class NumericalId extends SQLTable {

    protected static ResultSet createTextualId(Long id, Class type) throws SQLException {
        String query = "SELECT * from " + type.getSimpleName() + " " +
                "WHERE ID = " + id;
        ResultSet tmp = SQLTable.connectToDB().executeQuery(query);
        return tmp;
    }

}
