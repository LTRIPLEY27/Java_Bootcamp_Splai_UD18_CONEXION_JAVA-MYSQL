package DataBaseApp;
import CreateQuery.QuerysTienda;
import CreateQuery.FatherClass;
import CreateQuery.QuerysAlmacenes;
import CreateQuery.QuerysCientificos;
import CreateQuery.QuerysDirectores;
public class ConectApp {

	public static void main(String[] args) {
			/*QuerysTienda query = new QuerysTienda();
			
			query.crearConexion();
			//query.cierraConexion();
			//query.crearDataBase();
			//query.createTable();
			//query.createTableTwo();
			query.inserValuesTableOne();
			query.inserValuesTableTwo();
			*/
			//QuerysAlmacenes almacen = new QuerysAlmacenes();
			
			//almacen.crearConexion();
			/*almacen.crearDataBase();
			almacen.createTable();
			almacen.createTableTwo();
			almacen.inserValuesTableOne();
			almacen.inserValuesTableTwo();*/
			//almacen.getValues();
		
		
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
		String values2 = "INSERT INTO " + cientificos.getTableNameTwo() + "(ID, nombre, horas) VALUES ('123A', 'm�sica', 140) ;";
		String values3 = "INSERT INTO " + cientificos.getTableNameThree() + "(ID, cientifico, proyecto) VALUES ('123A', '123A', '123A') ;";
		cientificos.insertValues(values);
		cientificos.insertValues(values2);
		cientificos.insertValues(values3);*/
		
		
	}

}
