package controler;
import javax.swing.JOptionPane;

import model.FatherClass;
import model.QuerysAlmacenes;
import model.QuerysCientificos;
import model.QuerysDirectores;
import model.QuerysInvestigadores;
import model.QuerysTienda;

/*
 * @utor: Isabel Calzadilla
 * UD18 : JAVA DATBASE CONECTION
 * EJERCICIOS : 1-3-5-7-9 GRUPALES
 * */


public class ControlerClass {
	
	public static void startProgram() {
		
		String question = JOptionPane.showInputDialog("Desea crear base de datos? \nIndique 1 para SÍ \nIndique 2 para NO");
		int getQuestion = Integer.parseInt(question);
		
		if(getQuestion != 2) {
			/*String ask = JOptionPane.showInputDialog("1.- para 'TIENDA DE INFORMÁTICA' \n2.- para 'ALMACENES'\n3.- para 'DIRECTORES'\n4.- para 'CIENTIFICOS'\n5.- para 'INVESTIGADORES'\n6.- para SALIR");*/
			//int response = Integer.parseInt(ask);
			do {
				String ask = JOptionPane.showInputDialog("1.- para 'TIENDA DE INFORMÁTICA' \n2.- para 'ALMACENES'\n3.- para 'DIRECTORES'\n4.- para 'CIENTIFICOS'\n5.- para 'INVESTIGADORES'\n6.- para SALIR");
				int response = Integer.parseInt(ask);
				
					switch(response) {
						case 1:
							QuerysTienda tienda = new QuerysTienda("remote", "Taquito20.", "TIENDA_INFORMATICA", "FABRICANTES", "ARTICULOS");
							tienda.crearConexion();
							tienda.crearDataBase();
							String fabricantes = "CREATE TABLE "  + tienda.getTableName() + " (ID int AUTO_INCREMENT PRIMARY KEY, nombre nvarchar (100));";
							String articulos = "CREATE TABLE "  + tienda.getTableNameTwo() + "(ID int AUTO_INCREMENT PRIMARY KEY, nombre nvarchar (100), precio int, codigo int, FOREIGN KEY(codigo) REFERENCES " + tienda.getTableName() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
							tienda.createTable(fabricantes);
							tienda.createTable(articulos);
							String values = "INSERT INTO " + tienda.getTableName() + "(nombre) VALUES ( 'Portatil') ;";
							String valuesTwo =  "INSERT INTO " + tienda.getTableNameTwo() + "(nombre, precio, codigo) VALUES ( 'portatil', 874, 1) ;";
							tienda.insertValues(values);
							tienda.insertValues(valuesTwo);
							String query = "SELECT * FROM " + tienda.getTableName() + " ;";
							tienda.getValues(query);
							tienda.cierraConexion();
							break;
						case 2:	
							QuerysAlmacenes almacen = new QuerysAlmacenes("remote", "Taquito20.", "ALMACENES", "ALMACENES", "CAJAS");
							almacen.crearConexion();
							almacen.crearDataBase();
							String tabla1 = "CREATE TABLE " + almacen.getTableName() + "(ID int AUTO_INCREMENT PRIMARY KEY, lugar nvarchar (100), capacidad int);";
							String tabla2 = "CREATE TABLE " + almacen.getTableNameTwo() + "" + "(ID varchar (5) PRIMARY KEY, contenido nvarchar (100), valor int, almacen int, FOREIGN KEY(almacen) REFERENCES " + almacen.getTableName() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
							almacen.createTable(tabla1);
							almacen.createTable(tabla2);
							String values1 = "INSERT INTO " + almacen.getTableName() + "(lugar, capacidad) VALUES ('Barcelona', 14000) ;";
							String values2 = "INSERT INTO " + almacen.getTableNameTwo() + "(ID, contenido, valor, almacen) VALUES ('123A', 'electrodomesticos', 800, 1) ;";
							almacen.insertValues(values1);
							almacen.insertValues(values2);
							String query1 = "SELECT * FROM " + almacen.getTableName() + " ;";
							almacen.getValues(query1);
							almacen.cierraConexion();
							break;
						case 3:	
							QuerysDirectores directores = new QuerysDirectores("remote", "Taquito20.", "DIRECTORES", "DESPACHOS", "DIRECTORES");
							directores.crearConexion();
							directores.crearDataBase();
							String tabla3 = "CREATE TABLE " + directores.getTableName() + " (ID int PRIMARY KEY,  capacidad int);";
							String tabla4 = "CREATE TABLE " + directores.getTableNameTwo() + " (ID varchar (8) PRIMARY KEY, nomApels nvarchar (255), IDJefe varchar (8), despacho int, FOREIGN KEY(IDJefe) REFERENCES " + directores.getTableNameTwo() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY(despacho) REFERENCES " + directores.getTableName() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
							directores.createTable(tabla3);
							directores.createTable(tabla4);
							String values3 = "INSERT INTO " + directores.getTableName() + "(ID, capacidad) VALUES (1, 14000) ;";
							String values4 = "INSERT INTO " + directores.getTableNameTwo() + "(ID, nomApels, IDJefe, despacho) VALUES ('123A', 'LUDWIG VAN BEETHOVEN', '123B', 1) ;";
							
							directores.insertValues(values3);
							directores.insertValues(values4);
							String query2 = "SELECT * FROM " + directores.getTableName() + " ;";
							directores.getValues(query2);
							directores.cierraConexion();
							break;
						case 4:	
							QuerysCientificos cientificos = new QuerysCientificos("remote", "Taquito20.", "cientificos", "CIENTIFICOS", "PROYECTOS", "ASIGNADO_A");
							cientificos.crearConexion();
							cientificos.crearDataBase();
							String tabla5 = "CREATE TABLE " + cientificos.getTableName() + "" + "(ID varchar (8) PRIMARY KEY,  nomApels nvarchar (255));";
							String tabla6 = "CREATE TABLE " + cientificos.getTableNameTwo() + "" + "(ID char (4) PRIMARY KEY,  nombre nvarchar (255), horas int);";
							String tabla7 = "CREATE TABLE " + cientificos.getTableNameThree() + "" + "(ID char (4) PRIMARY KEY,  cientifico varchar (8), proyecto char (4), FOREIGN KEY(cientifico) REFERENCES " + cientificos.getTableName() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE,"+
																				"FOREIGN KEY(proyecto) REFERENCES "   + cientificos.getTableNameTwo() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
							cientificos.createTable(tabla5);
							cientificos.createTable(tabla6);
							cientificos.createTable(tabla7);
							String values5 = "INSERT INTO " + cientificos.getTableName() + "(ID, nomApels) VALUES ('123A', 'LUDWIG VAN BEETHOVEN') ;";
							String values6 = "INSERT INTO " + cientificos.getTableNameTwo() + "(ID, nombre, horas) VALUES ('123A', 'música', 140) ;";
							String values7 = "INSERT INTO " + cientificos.getTableNameThree() + "(ID, cientifico, proyecto) VALUES ('123A', '123A', '123A') ;";
							cientificos.insertValues(values5);
							cientificos.insertValues(values6);
							cientificos.insertValues(values7);
							String query3 = "SELECT * FROM " + cientificos.getTableName() + " ;";
							cientificos.getValues(query3);
							cientificos.cierraConexion();
							break;
						case 5:	
							QuerysInvestigadores investigador = new QuerysInvestigadores("remote", "Taquito20.", "investigadores", "FACULTAD", "INVESTIGADORES", "EQUIPOS", "RESERVA");
							investigador.crearConexion();
							investigador.crearDataBase();
							String tabla8 = "CREATE TABLE " + investigador.getTableName() + "" + "(ID int PRIMARY KEY,  nombre nvarchar (100));";
							String tabla9 = "CREATE TABLE " + investigador.getTableNameTwo() + "" + "(ID varchar (8) PRIMARY KEY,  nomApels nvarchar (255), facultad int, FOREIGN KEY(facultad) REFERENCES " + investigador.getTableName() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
							String tabla10 = "CREATE TABLE " + investigador.getTableNameThree() + "" + "(ID char (4) PRIMARY KEY,  nombre nvarchar (100), facultad int, FOREIGN KEY(facultad) REFERENCES " + investigador.getTableName() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
							String tabla11 = "CREATE TABLE " + investigador.getTableNameFour() + "" + "(ID char (4) PRIMARY KEY,  comienzo date, fin date, investigadores varchar (8), equipos char (4), FOREIGN KEY(investigadores) REFERENCES " + investigador.getTableNameTwo() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE," 
									+ "														 FOREIGN KEY(equipos) REFERENCES "  + investigador.getTableNameThree() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
							investigador.createTable(tabla8);
							investigador.createTable(tabla9);
							investigador.createTable(tabla10);
							investigador.createTable(tabla11);
							
							String values8 = "INSERT INTO " + investigador.getTableName() + "(ID, nombre) VALUES (1, 'FILOSOFIA') ;";
							String values9 = "INSERT INTO " + investigador.getTableNameTwo() + "(ID, nomApels, facultad) VALUES ('123A', 'LUDWIG VAN BEETHOVEN', 1) ;";
							String values10 = "INSERT INTO " + investigador.getTableNameThree() + "(ID, nombre, facultad) VALUES ('123A', 'pitagóricos', 1) ;";
							String values11 = "INSERT INTO " + investigador.getTableNameFour() + "(ID, comienzo, fin, investigadores, equipos) VALUES ('123A', '1978-06-27','2020-04-05', '123A', '123A') ;";
							
							investigador.insertValues(values8);
							investigador.insertValues(values9);
							investigador.insertValues(values10);
							investigador.insertValues(values11);
							String query4 = "SELECT * FROM " + investigador.getTableNameTwo() + " ;";
							investigador.getValues(query4);
							investigador.cierraConexion();
							break;
						default:
							JOptionPane.showMessageDialog(null, "Dede de ingresar una opcion válida");
							break;
					}
					
					question = JOptionPane.showInputDialog("Desea crear base de datos? \nIndique 1 para SÍ \nIndique 2 para NO").toLowerCase();
					getQuestion = Integer.parseInt(question);
			}while(getQuestion != 2);
		}else {
			JOptionPane.showMessageDialog(null, "Goodbye");
		}
	}
	
}
