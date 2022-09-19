import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLJavaConnection {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
			// connection
			String url = "jdbc:mysql://localhost:3306/mysqldemo";
			String user = "root";
			String password = "password";

			conn = DriverManager.getConnection(url, user, password);
			if (conn != null) {
				System.out.println("Connected to the database mysqldemo");
			}
			
			//create
            String sql = "CREATE TABLE Persons ("
                    + "    PersonID int,"
                    + "    LastName varchar(255),"
                    + "    FirstName varchar(255),"
                    + "    Address varchar(255),"
                    + "    City varchar(255)"
                    + ");";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

		} catch (SQLException ex) {
			System.out.println("Exception ::" + ex.getMessage());
			ex.printStackTrace();
		} finally {
			conn.close();
		}
	}

}
