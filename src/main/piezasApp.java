package main;

import Clases.ConexionPiezas;

public class piezasApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexionPiezas.openConnection();
		ConexionPiezas.createDB("Piezas");
		ConexionPiezas.createTablePiezas("Piezas", "PIEZAS");
		ConexionPiezas.createTableProveedores("Piezas", "PROVEEDORES");
		ConexionPiezas.createTableSuministra("Piezas", "SUMINISTRA");
		ConexionPiezas.insertDataPiezas("Piezas", "PIEZAS", "Pieza1");
		ConexionPiezas.insertDataProveedores("Piezas", "PROVEEDORES", 0001, "Proveedor1");
		ConexionPiezas.insertDataSuministra("Piezas", "SUMINISTRA", 1, (char) 0001, 300);
		ConexionPiezas.getValuesPiezas("Piezas", "PIEZAS");
		ConexionPiezas.getValuesProveedores("Piezas", "PROVEEDORES");
		ConexionPiezas.getValuesSuministra("Piezas", "SUMINISTRA");
		ConexionPiezas.deleteRecord("Piezas", "SUMINISTRA", "0001");
		ConexionPiezas.deleteTAbla("Piezas", "SUMINISTRA");
		
	}

}
