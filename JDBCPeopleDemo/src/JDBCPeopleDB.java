import java.sql.SQLException;

public class JDBCPeopleDB {
	
	static DBUser gabrielCredentials = new DBUser("root", "UFPhD2012");
	
	// Database name
	static String dbName = "PEOPLE";
	
	// person obj
	static People gabriel = new People("Gabriel", "Ferraz", 30, 29123458761L, 11122333444L);

	// db Instance
	static DataBase db = new PeopleDB(gabriel, dbName, DBUser.user, DBUser.pass);

	public static void main(String[] args) throws SQLException {

		try {
			db.create();
		} catch (SQLException e) {
			e.printStackTrace();
			db.connect();
			((PeopleDB)db).createTable();
			

			db.insert("PEOPLE");

			// try {
			// db.printAll("person");
			// } catch (SQLException e2) {
			// e2.getMessage();
			// e2.printStackTrace();
			// }
		}

	}

	/*** HELPERS ***/

}