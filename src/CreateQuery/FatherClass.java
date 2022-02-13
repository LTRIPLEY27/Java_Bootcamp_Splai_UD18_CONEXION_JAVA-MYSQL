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
	private final String FABRICANTES = "(ID int AUTO_INCREMENT PRIMARY KEY, nombre nvarchar (100));";
	private final String ARTICULOS = "(ID int AUTO_INCREMENT PRIMARY KEY, nombre nvarchar (100), precio int, codigo int, FOREIGN KEY(codigo) REFERENCES " + this.tableName + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
	
	public FatherClass(String user, String password, String dataName, String tableName, String tableNameTwo) {
		this.user = user;
		this.password = password;
		this.dataName = dataName;
		this.tableName = tableName;
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
		
		public void createTableFabricantes() {
			// TABLA SIN FOREIGN KEY 
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String queryTab = "CREATE TABLE " + this.tableName + "" + "(ID int AUTO_INCREMENT PRIMARY KEY, nombre nvarchar (100));";
				Statement st = conn.createStatement();
				st.executeUpdate(queryTab);
				System.out.println("Corrected");
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");	
			}
		}
		
		public void createTableArticulos() {
			// TABLA SIN FOREIGN KEY 
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String queryTab = "CREATE TABLE " + this.tableNameTwo + "" + "(ID int AUTO_INCREMENT PRIMARY KEY, nombre nvarchar (100), precio int, codigo int, FOREIGN KEY(codigo) REFERENCES " + this.tableName + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
				Statement st = conn.createStatement();
				st.executeUpdate(queryTab);
				System.out.println("Corrected");
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");	
			}
		}
		
		public void inserValuesTableOneFabricantes() {
			String name = "Portatil";
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String queryInsert = "INSERT INTO " + this.tableName + "(nombre) VALUES (" + "\"" + name + "\") ;";
				
				Statement st = conn.createStatement();
				st.executeUpdate(queryInsert);
				System.out.println("Corrected Insert");
			}catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				System.out.println("Error en el almacenamiento");
			}
		}
		
		public void inserValuesTableTwoArticulos() {
			String name = "Portatil";
			int price = 874;
			int code = 2;
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String queryInsert = "INSERT INTO " + this.tableNameTwo + "(nombre, precio, codigo) VALUES (" + "\"" + name + "\", "
						+ "\"" + price +  "\", " +  "\"" + code +  "\") ;";
				
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
		
		
		//////////  TABLAS ALMACENES
		
		public void createTableAlmacenes() {
			// TABLA SIN FOREIGN KEY 
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String queryTab = "CREATE TABLE " + this.tableName + "" + "(ID int AUTO_INCREMENT PRIMARY KEY, lugar nvarchar (100), capacidad int);";
				Statement st = conn.createStatement();
				st.executeUpdate(queryTab);
				System.out.println("Corrected");
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error creando tabla.");	
			}
		}
		
		public void createTableCajas() {
			// TABLA SIN FOREIGN KEY 
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String queryTab = "CREATE TABLE " + this.tableNameTwo + "" + "(ID varchar (5) PRIMARY KEY, contenido nvarchar (100), valor int, almacen int, FOREIGN KEY(almacen) REFERENCES " + this.tableName + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
				Statement st = conn.createStatement();
				st.executeUpdate(queryTab);
				System.out.println("Corrected");
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error creando tabla.");	
			}
		}
		
		public void inserValuesTableOneAlmacenes() {
			String place = "Barcelona";
			int capacity = 14000;
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String queryInsert = "INSERT INTO " + this.tableName + "(lugar, capacidad) VALUES (" + "\"" 
									+ place + "\", " + "\"" + capacity +  "\") ;";
				
				Statement st = conn.createStatement();
				st.executeUpdate(queryInsert);
				System.out.println("Corrected Insert");
			}catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				System.out.println("Error en el almacenamiento");
			}
		}
		
		//RECIBIR PARÁMETROS
		public void inserValuesTableTwoCajas() {
			String cajas = "ABC2";
			String contenido = "Portatil";
			int price = 874;
			int code = 2;
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String queryInsert = "INSERT INTO " + this.tableNameTwo + "(ID, contenido, valor, almacen) VALUES (" + "\"" + cajas + "\", "
						+ "\"" + contenido + "\", "
						+ "\"" + price +  "\", " +  "\"" + code +  "\") ;";
				
				Statement st = conn.createStatement();
				st.executeUpdate(queryInsert);
				System.out.println("Corrected Insert");
			}catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				System.out.println("Error en el almacenamiento");
			}
		}
		
		
		/// TABLAS DIRECTORES
		
		public void createTableDespachos() {
		
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String queryTab = "CREATE TABLE " + this.tableName + "" + "(ID int PRIMARY KEY,  capacidad int);";
				Statement st = conn.createStatement();
				st.executeUpdate(queryTab);
				System.out.println("Corrected");
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error creando tabla.");	
			}
		}
		
		public void createTableDirectores() {
			// TABLA SIN FOREIGN KEY 
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String queryTab = "CREATE TABLE " + this.tableNameTwo + "" + "(ID varchar (8) PRIMARY KEY, nomApels nvarchar (255), capacidad int);";
				Statement st = conn.createStatement();
				st.executeUpdate(queryTab);
				System.out.println("Corrected");
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error creando tabla.");	
			}
		}
}
