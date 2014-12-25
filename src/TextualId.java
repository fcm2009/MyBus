import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by st201138010 on 12/25/2014.
 */
public abstract class TextualId extends SQLTable {

    protected static ResultSet createTextualId(String id, Class type) throws SQLException {
        String query = "SELECT * from " + type.getSimpleName() + " " +
                "WHERE ID = '" + id + "'";
        ResultSet tmp = SQLTable.connectToDB().executeQuery(query);
        SQLTable.closeConnection();
        return tmp;
    }

}
