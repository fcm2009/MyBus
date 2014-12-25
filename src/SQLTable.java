import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class SQLTable {

	private static String username = "s201135790";
	private static String password = "201135790";
	private static Connection connection;

	protected static Statement connectToDB() throws SQLException {
    	connection = DriverManager.getConnection("jdbc:oracle:thin:@ics-db.ccse.kfupm.edu.sa:1521:xe",username,password);
    	return connection.createStatement();
    }

	protected static void closeConnection() throws SQLException {
		connection.close();
	}

	protected abstract void  writeToDB() throws SQLException;

	protected abstract void deleteFromDB() throws SQLException;

}
