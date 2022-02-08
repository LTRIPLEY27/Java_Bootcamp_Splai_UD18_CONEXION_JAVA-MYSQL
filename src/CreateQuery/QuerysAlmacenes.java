package CreateQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class QuerysAlmacenes {
	private Connection conn;
	private String user;
	private String password;
	private String dataName;
	private String tableName;
	private String tableNameTwo;
	
	public QuerysAlmacenes() {
		this.user = "remote";
		this.password = "Taquito20.";
		this.dataName = "almacenes";
		this.tableName = "almacenes";
		this.tableNameTwo = "cajas";
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
		
		public void createTable() {
			// TABLA SIN FOREIGN KEY 
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String queryTab = "CREATE TABLE " + this.tableName + "" + "(idAlmacen int AUTO_INCREMENT PRIMARY KEY, lugar nvarchar (100), capacidad int);";
				Statement st = conn.createStatement();
				st.executeUpdate(queryTab);
				System.out.println("Corrected");
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");	
			}
		}
		
		public void createTableTwo() {
			// TABLA SIN FOREIGN KEY 
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String queryTab = "CREATE TABLE " + this.tableNameTwo + "" + "(idCajas char (5) PRIMARY KEY, contenido nvarchar (100), valor int, almacen int, FOREIGN KEY(almacen) REFERENCES " + this.tableName + "(idAlmacen ) ON DELETE CASCADE ON UPDATE CASCADE);";
				Statement st = conn.createStatement();
				st.executeUpdate(queryTab);
				System.out.println("Corrected");
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");	
			}
		}
		
		public void inserValuesTableOne() {
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
		
		public void inserValuesTableTwo() {
			String cajas = "ABC2";
			String contenido = "Portatil";
			int price = 874;
			int code = 2;
			try {
				String queryDB = "USE " + this.dataName + ";";
				Statement stDb = conn.createStatement();
				stDb.executeUpdate(queryDB);
				
				String queryInsert = "INSERT INTO " + this.tableNameTwo + "(idCajas, contenido, valor, almacen) VALUES (" + "\"" + cajas + "\", "
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
					System.out.println("Codigo Almacén " + result.getString("idAlmacen") +
										" " + "Lugar " + result.getString("lugar") +
										" " + "Capacidad " + result.getString("capacidad"));
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
				
				String query = "DELETE FROM " + this.tableName + " WHERE idAlmacened = \"" + ID + "\" ;";
				Statement st = conn.createStatement();
				st.executeQuery(query);
				
			}catch (SQLException ex ) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la eliminacion de los datos");
			}
		}
}
