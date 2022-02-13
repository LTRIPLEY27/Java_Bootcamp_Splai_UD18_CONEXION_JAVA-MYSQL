package model;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;*/

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuerysTienda extends FatherClass{

	public QuerysTienda(String user, String password, String dataName, String tableName, String tableNameTwo) {
		super(user, password, dataName, tableName, tableNameTwo);
	
	}
		
	public void getValues(String querys) {
		try {
			String queryDB = "USE " + super.getDataName() + ";";
			Statement stDb = super.getConn().createStatement();
			stDb.executeUpdate(queryDB);

			String query = querys;
			Statement st = super.getConn().createStatement();
			ResultSet result = st.executeQuery(query);
			System.out.println("Los datos almacenados de la tabla son los siguientes : \n\n");
			while(result.next()) {
				System.out.println("ID " + result.getString("ID") +
									" " + "Nombre " + result.getString("nombre"));
			}			
		}catch (SQLException ex ) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la obtención de la data");
		}
	}
	
	
}
