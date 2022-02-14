package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ConexionPeliculas {
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
				String Query2 = "DROP DATABASE IF EXISTS `Peliculas`";
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
				public static void createTablePeliculas(String db, String name) {
					try {
						String Querydb = "USE " + db + ";";
						Statement stdb = conexion.createStatement();
						stdb.executeUpdate(Querydb);
						String Query2 = "DROP TABLE IF EXISTS `PELICULAS`;";
						String Query = "CREATE TABLE " + name + ""
								+ "(Codigo int PRIMARY KEY AUTO_INCREMENT, Nombre NVARCHAR(100),CalificacionEdad int);";
						Statement st = conexion.createStatement();
						st.executeUpdate(Query2);
						st.executeUpdate(Query);
						System.out.println("Tabla creada con exito!");

					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
						System.out.println("Error crando tabla.");

					}

				}

				public static void createTableSalas(String db, String name) {
					try {
						String Querydb = "USE " + db + ";";
						Statement stdb = conexion.createStatement();
						stdb.executeUpdate(Querydb);
						String Query2 = "DROP TABLE IF EXISTS `SALAS`;";
						String Query = "CREATE TABLE " + name + ""
								+ "(Codigo int PRIMARY KEY AUTO_INCREMENT, Nombre NVARCHAR(100),Pelicula int,"
								+ "FOREIGN KEY (`Pelicula`) REFERENCES `PELICULAS` (`Codigo`));";
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
				public static void insertDataPeliculas(String db, String table_name, String name, int calificacion) {
					try {
						String Querydb = "USE " + db + ";";
						Statement stdb = conexion.createStatement();
						stdb.executeUpdate(Querydb);

						String Query = "INSERT INTO " + table_name + " (Nombre, CalificacionEdad) VALUE(" + "\"" + name + "\", " + "\""
								+ calificacion + "\"); ";
						Statement st = conexion.createStatement();
						st.executeUpdate(Query);

						System.out.println("Datos almacenados correctamente");
						;

					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
						JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
					}

				}
				
				public static void insertDataSalas(String db, String table_name, String name, int pelicula) {
					try {
						String Querydb = "USE " + db + ";";
						Statement stdb = conexion.createStatement();
						stdb.executeUpdate(Querydb);

						String Query = "INSERT INTO " + table_name + " (Nombre, Pelicula) VALUE(" + "\"" + name + "\", " + "\""
								+ pelicula + "\"); ";
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
				public static void getValuesPeliculas(String db, String table_name) {
					try {
						String Querydb = "USE " + db + ";";
						Statement stdb = conexion.createStatement();
						stdb.executeUpdate(Querydb);

						String Query = "SELECT * FROM " + table_name;
						Statement st = conexion.createStatement();
						java.sql.ResultSet resultSet;
						resultSet = st.executeQuery(Query);

						while (resultSet.next()) {
							System.out.println("Codigo: " + resultSet.getString("Codigo") + " " + "Nombre: " + resultSet.getString("Nombre")
									+ " " + "CalificacionEdad:" + resultSet.getString("CalificacionEdad")+ " ");
						}
					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
						System.out.println("Error en la adquisicion de datos");
					}

				}
				
				public static void getValuesSalas(String db, String table_name) {
					try {
						String Querydb = "USE " + db + ";";
						Statement stdb = conexion.createStatement();
						stdb.executeUpdate(Querydb);

						String Query = "SELECT * FROM " + table_name;
						Statement st = conexion.createStatement();
						java.sql.ResultSet resultSet;
						resultSet = st.executeQuery(Query);

						while (resultSet.next()) {
							System.out.println("Codigo: " + resultSet.getString("Codigo") + " " + "Nombre: " + resultSet.getString("Nombre")
									+ " " + "Pelicula:" + resultSet.getString("Pelicula")+ " ");
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
