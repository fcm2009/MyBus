import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class SQLTable {

	private String username = "s201135790";
	private String password = "201135790";

	public Statement connectToDB() throws SQLException {
    	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@ics-db.ccse.kfupm.edu.sa:1521:xe",username,password);
    	return connection.createStatement();
    }
	
	public abstract void  writeToDB() throws SQLException;

}
