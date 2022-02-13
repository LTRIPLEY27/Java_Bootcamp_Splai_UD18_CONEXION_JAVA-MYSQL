package CreateQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FatherClass {
	private Connection conn;
	private String user;
	private String password;
	private String dataName;
	private String tableName;
	private String tableNameTwo;
	// STRINGS PARA CADA UNA DE LAS TABLAS
	
	public FatherClass(String user, String password, String dataName, String tableName, String tableNameTwo) {
		this.user = user;
		this.password = password;
		this.dataName = dataName;
		this.tableName = tableName;
		this.tableNameTwo = tableNameTwo;
	}
	
	
		public String getTableName() {
		return tableName;
	}


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}


	public String getTableNameTwo() {
		return tableNameTwo;
	}


	public void setTableNameTwo(String tableNameTwo) {
		this.tableNameTwo = tableNameTwo;
	}


		public void crearConexion() {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://192.168.1.164:3306?useTimezone=true&serverTimezone=UTC", user, password);
				System.out.println("Sucessfully conected");
			} catch(SQLException  | ClassNotFoundException ex) {
				System.out.print("No se ha podido establecer conexión");
				System.out.print(ex);
			}
		}
		
		public void cierraConexion() {
			try {
				conn.close();
				System.out.println("Disconected");
			} catch(SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en el cierre");
			}
		}
		
		public void crearDataBase() {
			try {
				String query = "CREATE DATABASE " + this.dataName;
				Statement st = conn.createStatement();
				st.executeUpdate(query);
				System.out.println("Data exitosa");
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en el cierre");
			}
		}
		
		public void createTable(String table) {
			// TABLA SIN FOREIGN KEY 
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String queryTab = table;
				Statement st = conn.createStatement();
				st.executeUpdate(queryTab);
				System.out.println("Corrected");
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");	
			}
		}
	
		
		public void insertValues(String values) {
			String name = "Portatil";
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String queryInsert = values;
				
				Statement st = conn.createStatement();
				st.executeUpdate(queryInsert);
				System.out.println("Corrected Insert");
			}catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				System.out.println("Error en el almacenamiento");
			}
		}
		
		
		public void getValues() {
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				//SE PUEDE CUSTOMIZAR CON UN IF PARA APLICAR EN CADA CASO LA CONSULTA DE LA TABLA
				String query = "SELECT * FROM " + this.tableName;
				Statement st = conn.createStatement();
				ResultSet result = st.executeQuery(query);
				
				while(result.next()) {
					System.out.println("ID " + result.getString("ID") +
										" " + "Nombre " + result.getString("nombre"));
				}			
			}catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la obtención de la data");
			}
		}
		
		public void deleteQuerys() {
			int ID = 2;
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String query = "DELETE FROM " + this.tableName + " WHERE codigo = \"" + ID + "\" ;";
				Statement st = conn.createStatement();
				st.executeQuery(query);
				
			}catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la eliminacion de los datos");
			}
		}
		
	
}
