package main;

import Clases.ConexionAlmacenes;


public class almacenesApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexionAlmacenes.openConnection();
		ConexionAlmacenes.createDB("Almacenes");
		ConexionAlmacenes.createTableCajeros("Almacenes", "CAJEROS");
		ConexionAlmacenes.createTableMaquinasRegistradoras("Almacenes", "MAQUINAS_REGISTRADORAS");
		ConexionAlmacenes.createTableProductos("Almacenes", "PRODUCTOS");
		ConexionAlmacenes.createTableVenta("Almacenes", "VENTA");
		ConexionAlmacenes.insertDataCajeros("Almaceces", "CAJEROS", "Cajero1");
		ConexionAlmacenes.insertDataMaquinaRegistradora("Almacenes", "MAQUINAS_REGISTRADORAS", 3);
		ConexionAlmacenes.insertDataProductos("Almacenes", "PRODUCTOS", "Producto1", 30);
		ConexionAlmacenes.insertDataVenta("Almacenes", "VENTA", 1, 1, 1);
		ConexionAlmacenes.getValuesCajeros("Almacenes", "CAJEROS");
		ConexionAlmacenes.getValuesMaquinasRegistradoras("Almacenes", "MAQUINAS_REGISTRADORAS");
		ConexionAlmacenes.getValuesProductos("Almacenes", "PRODUCTOS");
		ConexionAlmacenes.getValuesVenta("Almacenes", "VENTA");
		ConexionAlmacenes.deleteRecord("Almacenes", "CAJEROS", "1");
		ConexionAlmacenes.deleteTAbla("Almacenes", "CAJEROS");
	}

}
