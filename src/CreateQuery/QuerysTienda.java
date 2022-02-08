package CreateQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuerysTienda {

	private Connection conn;
	private String user;
	private String password;
	private String dataName;
	private String tableName;
	private String tableNameTwo;
	
	public QuerysTienda() {
		this.user = "remote";
		this.password = "Taquito20.";
		this.dataName = "TIENDA_INFORMÁTICA";
		this.tableName = "FABRICANTES";
		this.tableNameTwo = "ARTICULOS";
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
				
				String queryTab = "CREATE TABLE " + this.tableName + "" + "(codigo int AUTO_INCREMENT PRIMARY KEY, nombre nvarchar (100));";
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
				
				String queryTab = "CREATE TABLE " + this.tableNameTwo + "" + "(idArticulo int AUTO_INCREMENT PRIMARY KEY, nombre nvarchar (100), precio int, codigo int, FOREIGN KEY(codigo) REFERENCES " + this.tableName + "(codigo) ON DELETE CASCADE ON UPDATE CASCADE);";
				Statement st = conn.createStatement();
				st.executeUpdate(queryTab);
				System.out.println("Corrected");
			} catch (SQLException ex){
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");	
			}
		}
		
		public void inserValuesTableOne() {
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
		
		public void inserValuesTableTwo() {
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
					System.out.println("Código " + result.getString("codigo") +
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
