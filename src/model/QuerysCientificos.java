package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuerysCientificos extends FatherClass {

	public QuerysCientificos(String user, String password, String dataName, String tableName, String tableNameTwo, String tableNameThree) {
		super(user, password, dataName, tableName, tableNameTwo, tableNameThree);
		
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
				System.out.println("DNI = " + result.getString("ID") +
									 "\nNombre y Apellidos = " + result.getString("nomApels"));
			}			
		}catch (SQLException ex ) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la obtenci?n de la data");
		}
	}
}
