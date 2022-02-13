package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuerysInvestigadores extends FatherClass {

	public QuerysInvestigadores(String user, String password, String dataName, String tableName, String tableNameTwo,
			String tableNameThree, String tableNameFour) {
		super(user, password, dataName, tableName, tableNameTwo, tableNameThree, tableNameFour);
	
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
									 "\nNombre y Apellidos = " + result.getString("nomApels") +
									 "\nFacultad = " + result.getString("facultad"));
			}			
		}catch (SQLException ex ) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la obtención de la data");
		}
	}
}
