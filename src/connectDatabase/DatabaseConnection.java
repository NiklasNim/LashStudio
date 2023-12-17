package connectDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseConnection {
	
	private static DatabaseConnection databaseConnection;
	private Connection connection = null;
	private static final String serverAddress = "hildur.ucn.dk";
	private static final String databaseName = "DMA-CSD-V23_10481979";
	private static final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String userName = "DMA-CSD-V23_10481979";
	private static String password = "Password1!";
	private static final int serverPort = 1433;
	
	
    private DatabaseConnection() {
    	String connectionString = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s;encrypt=false", 
                serverAddress, serverPort, databaseName, userName, password);

		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(connectionString);
		} catch (ClassNotFoundException e) {
			System.err.println("Could not load JDBC driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Could not connect to database " + databaseName + "@" + serverAddress + ":" + serverPort + " as user " + userName + " using password ****");
			System.out.println("Connection string was: " + connectionString.substring(0, connectionString.length() - password.length()) + "....");
			e.printStackTrace();
		}
	}
	

	public static DatabaseConnection getInstance() {
		if(databaseConnection == null) {
			databaseConnection = new DatabaseConnection();
		}
		return databaseConnection;
	}
	
	public void startTransaction() throws SQLException {
		connection.setAutoCommit(false);
	}
	
	public void commitTransaction() throws SQLException {
		connection.commit();
		connection.setAutoCommit(true);
	}
	
	public void rollbackTransaction() throws SQLException {
		connection.rollback();
		connection.setAutoCommit(true);
	}
	
	public int executeInsertWithIdentity(PreparedStatement ps) throws SQLException  {
		int res = -1;
		try {
			res = ps.executeUpdate();
			if(res > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return res;
	}
	
	public int executeInsertWithIdentity(String sql) throws SQLException  {
		System.out.println("DBConnection, Inserting: " + sql);
		int res = -1;
		try (Statement s = connection.createStatement()) {
			res = s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			if(res > 0) {
				ResultSet rs = s.getGeneratedKeys();
				rs.next();
				res = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return res;
	}
	
	public int executeUpdate(String sql) throws SQLException {
		System.out.println("DBConnection, Updating: " + sql);
		int res = -1;
		try (Statement s = connection.createStatement()){
			res = s.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return res;
	}
	
	
	public Connection getConnection() {
		return connection;
	}
	
	public void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}