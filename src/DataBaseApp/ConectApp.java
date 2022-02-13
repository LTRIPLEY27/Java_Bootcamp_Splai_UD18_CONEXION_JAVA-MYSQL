package DataBaseApp;
import CreateQuery.QuerysTienda;
import CreateQuery.FatherClass;
import CreateQuery.QuerysAlmacenes;
import CreateQuery.QuerysCientificos;
import CreateQuery.QuerysDirectores;
import CreateQuery.QuerysInvestigadores;

/*
 * @utor: Isabel Calzadilla
 * UD18 : JAVA DATBASE CONECTION
 * EJERCICIOS : 1-3-5-7-9 GRUPALES
 * */

public class ConectApp {

	public static void main(String[] args) {
			
		
		
	/*	QuerysTienda tienda = new QuerysTienda("remote", "Taquito20.", "TIENDA_INFORMATICA", "FABRICANTES", "ARTICULOS");
		tienda.crearConexion();
		tienda.crearDataBase();
		String fabricantes = "CREATE TABLE "  + tienda.getTableName() + " (ID int AUTO_INCREMENT PRIMARY KEY, nombre nvarchar (100));";
		String articulos = "CREATE TABLE "  + tienda.getTableNameTwo() + "(ID int AUTO_INCREMENT PRIMARY KEY, nombre nvarchar (100), precio int, codigo int, FOREIGN KEY(codigo) REFERENCES " + tienda.getTableName() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
		tienda.createTable(fabricantes);
		tienda.createTable(articulos);
		String values = "INSERT INTO " + tienda.getTableName() + "(nombre) VALUES ( 'Portatil') ;";
		String valuesTwo =  "INSERT INTO " + tienda.getTableNameTwo() + "(nombre, precio, codigo) VALUES ( 'portatil', 874, 1) ;";
		
		tienda.insertValues(values);
		tienda.insertValues(valuesTwo);*/
		
		
		/*
		QuerysAlmacenes almacen = new QuerysAlmacenes("remote", "Taquito20.", "ALMACENES", "ALMACENES", "CAJAS");
		almacen.crearConexion();
		almacen.crearDataBase();
		String tabla1 = "CREATE TABLE " + almacen.getTableName() + "(ID int AUTO_INCREMENT PRIMARY KEY, lugar nvarchar (100), capacidad int);";
		String tabla2 = "CREATE TABLE " + almacen.getTableNameTwo() + "" + "(ID varchar (5) PRIMARY KEY, contenido nvarchar (100), valor int, almacen int, FOREIGN KEY(almacen) REFERENCES " + almacen.getTableName() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
		almacen.createTable(tabla1);
		almacen.createTable(tabla2);
		String values = "INSERT INTO " + almacen.getTableName() + "(lugar, capacidad) VALUES ('Barcelona', 14000) ;";
		String valuesTwo = "INSERT INTO " + almacen.getTableNameTwo() + "(ID, contenido, valor, almacen) VALUES ('123A', 'electrodomesticos', 800, 1) ;";
		almacen.insertValues(values);
		almacen.insertValues(valuesTwo);
		//almacen.getValues();
		
		QuerysDirectores directores = new QuerysDirectores("remote", "Taquito20.", "DIRECTORES", "DESPACHOS", "DIRECTORES");
		directores.crearConexion();
		directores.crearDataBase();
		String tabla1 = "CREATE TABLE " + directores.getTableName() + "" + "(ID int PRIMARY KEY,  capacidad int);";
		String tabla2 = "CREATE TABLE " + directores.getTableNameTwo() + "" + "(ID varchar (8) PRIMARY KEY, nomApels nvarchar (255), IDJefe varchar (8), capacidad int, FOREIGN KEY(IDJefe) REFERENCES " + directores.getTableNameTwo() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "															FOREIGN KEY(capacidad) REFERENCES " + directores.getTableName() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
		directores.createTable(tabla1);
		directores.createTable(tabla2);
		String values = "INSERT INTO " + directores.getTableName() + "(ID, capacidad) VALUES (1, 14000) ;";
		String valuesTwo = "INSERT INTO " + directores.getTableNameTwo() + "(ID, nomApels, IDJefe, capacidad) VALUES ('123A', 'LUDWIG VAN BEETHOVEN', '123B', 1) ;";
		
		directores.insertValues(values);
		directores.insertValues(valuesTwo);*/
		
		/*
		QuerysCientificos cientificos = new QuerysCientificos("remote", "Taquito20.", "cientificos", "CIENTIFICOS", "PROYECTOS", "ASIGNADO_A");
		cientificos.crearConexion();
		cientificos.crearDataBase();
		String tabla1 = "CREATE TABLE " + cientificos.getTableName() + "" + "(ID varchar (8) PRIMARY KEY,  nomApels nvarchar (255));";
		String tabla2 = "CREATE TABLE " + cientificos.getTableNameTwo() + "" + "(ID char (4) PRIMARY KEY,  nombre nvarchar (255), horas int);";
		String tabla3 = "CREATE TABLE " + cientificos.getTableNameThree() + "" + "(ID char (4) PRIMARY KEY,  cientifico varchar (8), proyecto char (4), FOREIGN KEY(cientifico) REFERENCES " + cientificos.getTableName() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE,"+
															"FOREIGN KEY(proyecto) REFERENCES "   + cientificos.getTableNameTwo() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
		cientificos.createTable(tabla1);
		cientificos.createTable(tabla2);
		cientificos.createTable(tabla3);
		String values = "INSERT INTO " + cientificos.getTableName() + "(ID, nomApels) VALUES ('123A', 'LUDWIG VAN BEETHOVEN') ;";
		String values2 = "INSERT INTO " + cientificos.getTableNameTwo() + "(ID, nombre, horas) VALUES ('123A', 'música', 140) ;";
		String values3 = "INSERT INTO " + cientificos.getTableNameThree() + "(ID, cientifico, proyecto) VALUES ('123A', '123A', '123A') ;";
		cientificos.insertValues(values);
		cientificos.insertValues(values2);
		cientificos.insertValues(values3);*/
		
		QuerysInvestigadores investigador = new QuerysInvestigadores("remote", "Taquito20.", "investigadores", "FACULTAD", "INVESTIGADORES", "EQUIPOS", "RESERVA");
		investigador.crearConexion();
		investigador.crearDataBase();
		String tabla1 = "CREATE TABLE " + investigador.getTableName() + "" + "(ID int PRIMARY KEY,  nombre nvarchar (100));";
		String tabla2 = "CREATE TABLE " + investigador.getTableNameTwo() + "" + "(ID varchar (8) PRIMARY KEY,  nomApels nvarchar (255), facultad int, FOREIGN KEY(facultad) REFERENCES " + investigador.getTableName() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
		String tabla3 = "CREATE TABLE " + investigador.getTableNameThree() + "" + "(ID char (4) PRIMARY KEY,  nombre nvarchar (100), facultad int, FOREIGN KEY(facultad) REFERENCES " + investigador.getTableName() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
		String tabla4 = "CREATE TABLE " + investigador.getTableNameFour() + "" + "(ID char (4) PRIMARY KEY,  comienzo date, fin date, investigadores varchar (8), equipos char (4), FOREIGN KEY(investigadores) REFERENCES " + investigador.getTableNameTwo() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE," 
				+ "														 FOREIGN KEY(equipos) REFERENCES "  + investigador.getTableNameThree() + "(ID) ON DELETE CASCADE ON UPDATE CASCADE);";
		investigador.createTable(tabla1);
		investigador.createTable(tabla2);
		investigador.createTable(tabla3);
		investigador.createTable(tabla4);
		
		String values1 = "INSERT INTO " + investigador.getTableName() + "(ID, nombre) VALUES (1, 'FILOSOFIA') ;";
		String values2 = "INSERT INTO " + investigador.getTableNameTwo() + "(ID, nomApels, facultad) VALUES ('123A', 'LUDWIG VAN BEETHOVEN', 1) ;";
		String values3 = "INSERT INTO " + investigador.getTableNameThree() + "(ID, nombre, facultad) VALUES ('123A', 'pitagóricos', 1) ;";
		String values4 = "INSERT INTO " + investigador.getTableNameFour() + "(ID, comienzo, fin, investigadores, equipos) VALUES ('123A', '1978-06-27','2020-04-05', '123A', '123A') ;";
		
		investigador.insertValues(values1);
		investigador.insertValues(values2);
		investigador.insertValues(values3);
		investigador.insertValues(values4);
	}

}
