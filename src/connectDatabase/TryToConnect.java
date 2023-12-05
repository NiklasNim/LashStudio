package connectDatabase;
import java.sql.*;



public class TryToConnect {
		
	public static void main(String[] args) {
		    try {
		        // Indlæsning af JDBC-driveren
		        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		        // Oprettelse af en forbindelse
		        String connectionUrl = "jdbc:sqlserver://hildur.ucn.dk;databaseName=DMA-CSD-V23_10481979;user=DMA-CSD-V23_10481979;password=Password1!;trustServerCertificate=true";
		        Connection con = DriverManager.getConnection(connectionUrl);
		        System.out.println("Connected to database: " + !con.isClosed());

		        // Test af forbindelsen
		        testDatabaseConnection(con);

		        // Lukker forbindelsen
		        con.close();
		        System.out.println("Disconnected from database: " + con.isClosed());

		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		    }
		}

		// Metode til at teste databaseforbindelsen
		public static void testDatabaseConnection(Connection con) throws SQLException {
		    // Opretter en SQL forespørgsel for at hente tabelnavne
		    String sqlQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES";
		    Statement stmt = con.createStatement();
		    ResultSet rs = stmt.executeQuery(sqlQuery);

		    System.out.println("Liste af tabeller i databasen:");
		    while (rs.next()) {
		        System.out.println(rs.getString("TABLE_NAME"));
		    }

		    // Lukker Statement og ResultSet
		    rs.close();
		    stmt.close();
		}

	}

