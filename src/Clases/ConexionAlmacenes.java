package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class ConexionAlmacenes {
	public static Connection conexion;

	public static void openConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(
					"jdbc:mysql://192.168.1.102:3306?useTimezone=true&serverTimezone=UTC", "remote", "Reus.2022");// credenciales
																													// temporales
			System.out.print("Server Connected");
			fecha();

		} catch (SQLException | ClassNotFoundException ex) {
			System.out.print("No se ha podido conectar con mi base de datos");
			fecha();
			System.out.println(ex.getMessage());

		}

	}

	// METODO QUE CIERRA LA CONEXION CON SERVER MYSQL
	public static void closeConnection() {
		try {
			conexion.close();
			System.out.print("Server Disconnected");
			fecha();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.print("Error cerrando conexion");
			fecha();
		}
	}

	// METODO QUE CREA LA BASE DE DATOS
	public static void createDB(String name) {
		try {
			String Query2 = "DROP DATABASE IF EXISTS `Almacenes`";
			String Query = "CREATE DATABASE " + name;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query2);
			st.executeUpdate(Query);
			System.out.println("DB creada con exito!");

			JOptionPane.showMessageDialog(null, "Se ha creado la DB " + name + "de forma exitosa.");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la DB.");
		}
	}
	
	// METODO QUE CREA TABLAS MYSQL
		public static void createTableCajeros(String db, String name) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);
				String Query2 = "DROP TABLE IF EXISTS `CAJEROS`;";
				String Query = "CREATE TABLE " + name + ""
						+ "(Codigo int PRIMARY KEY AUTO_INCREMENT, NomApels NVARCHAR(255));";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query2);
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");

			}

		}
		public static void createTableProductos(String db, String name) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);
				String Query2 = "DROP TABLE IF EXISTS `PRODUCTOS`;";
				String Query = "CREATE TABLE " + name + ""
						+ "(Codigo int PRIMARY KEY AUTO_INCREMENT, Nombre NVARCHAR(100),Precio int);";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query2);
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");

			}

		}
		
		public static void createTableMaquinasRegistradoras(String db, String name) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);
				String Query2 = "DROP TABLE IF EXISTS `MAQUINAS_REGISTRADORAS`;";
				String Query = "CREATE TABLE " + name + ""
						+ "(Codigo int PRIMARY KEY AUTO_INCREMENT, Piso int);";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query2);
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");

			}

		}
		
		public static void createTableVenta(String db, String name) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);
				String Query2 = "DROP TABLE IF EXISTS `VENTA`;";
				String Query = "CREATE TABLE " + name + ""
						+ "(Cajero int ,Maquina int, Producto int, PRIMARY KEY(Cajero,Maquina,Producto),"
						+ "FOREIGN KEY (`Cajero`) REFERENCES `CAJEROS` (`Codigo`),"
						+ "FOREIGN KEY (`Maquina`) REFERENCES `MAQUINAS_REGISTRADORAS` (`Codigo`),"
						+ "FOREIGN KEY (`Producto`) REFERENCES `PRODUCTOS` (`Codigo`));";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query2);
				st.executeUpdate(Query);
				System.out.println("Tabla creada con exito!");

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error crando tabla.");

			}

		}
	
		// METODO QUE INSERTA DATOS EN TABLAS MYSQL
		public static void insertDataCajeros(String db, String table_name, String name) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "INSERT INTO " + table_name + " (NomApels) VALUE(" + "\"" + name + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);

				System.out.println("Datos almacenados correctamente");
				;

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}

		}
		
		public static void insertDataMaquinaRegistradora(String db, String table_name, int piso) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "INSERT INTO " + table_name + " (Piso) VALUE(" + "\"" + piso + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);

				System.out.println("Datos almacenados correctamente");
				;

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}

		}
		
		public static void insertDataProductos(String db, String table_name,String name, int precio) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "INSERT INTO " + table_name + " (Nombre,Precio) VALUE(" + "\"" + name + "\"," + "\"" + precio + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);

				System.out.println("Datos almacenados correctamente");
				;

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}

		}
		
		public static void insertDataVenta(String db, String table_name,int cajero, int maquina,int producto) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "INSERT INTO " + table_name + " (Cajero,Maquina,Producto) VALUE(" + "\"" + cajero + "\"," + "\"" + maquina + "\"," + "\"" + producto + "\"); ";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);

				System.out.println("Datos almacenados correctamente");
				;

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
			}

		}
	
		// METODO QUE OBTIENE VALORES MYSQL
		
		public static void getValuesCajeros(String db, String table_name) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "SELECT * FROM " + table_name;
				Statement st = conexion.createStatement();
				java.sql.ResultSet resultSet;
				resultSet = st.executeQuery(Query);

				while (resultSet.next()) {
					System.out.println("Codigo: " + resultSet.getString("Codigo") + " " + "NomApels: " + resultSet.getString("NomApels") + " ");
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}

		}
		
		public static void getValuesMaquinasRegistradoras(String db, String table_name) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "SELECT * FROM " + table_name;
				Statement st = conexion.createStatement();
				java.sql.ResultSet resultSet;
				resultSet = st.executeQuery(Query);

				while (resultSet.next()) {
					System.out.println("Codigo: " + resultSet.getString("Codigo") + " " + "Piso: " + resultSet.getString("Piso") + " ");
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}

		}
		
		public static void getValuesProductos(String db, String table_name) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "SELECT * FROM " + table_name;
				Statement st = conexion.createStatement();
				java.sql.ResultSet resultSet;
				resultSet = st.executeQuery(Query);

				while (resultSet.next()) {
					System.out.println("Codigo: " + resultSet.getString("Codigo") + " " + "Nombre: " + resultSet.getString("Nombre") + " " + "Precio: "+ resultSet.getString("Precio"));
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}

		}
		
		public static void getValuesVenta(String db, String table_name) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "SELECT * FROM " + table_name;
				Statement st = conexion.createStatement();
				java.sql.ResultSet resultSet;
				resultSet = st.executeQuery(Query);

				while (resultSet.next()) {
					System.out.println("Cajero: " + resultSet.getString("Cajero") + " " + "Maquina: " + resultSet.getString("Maquina") + " " + "Producto: "+ resultSet.getString("Producto"));
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error en la adquisicion de datos");
			}

		}
	
	
	// METODO QUE LIMPIA TABLAS MYSQL
		public static void deleteRecord(String db, String table_name, String ID) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "DELETE FROM " + table_name + " WHERE ID = \"" + ID + "\"";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);

				System.out.println("Registros de tabla ELIMINADOS con exito!");

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
			}
		}

		// METODO QUE ELIMINA TABLAS MYSQL
		public static void deleteTAbla(String db, String table_name) {
			try {
				String Querydb = "USE " + db + ";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);

				String Query = "DROP TABLE " + table_name + ";";
				Statement st = conexion.createStatement();
				st.executeUpdate(Query);

				System.out.println("TABLA ELIMINADA con exito!");

			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Error borrando la tabla");
			}
		}

		public static void fecha() {
			Date date = new Date();
			DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
			System.out.println(" - " + hourdateFormat.format(date));
		}
	
}
