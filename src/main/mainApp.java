package main;
import Clases.Conexion;
public class mainApp {

	public static void main(String[] args) {
		
		Conexion.openConnection();
		Conexion.createDB("RECETAS");
		Conexion.createTableTiposPlato("RECETAS", "TIPOS_PLATO");
		Conexion.createTableReceta("RECETAS","RECETA");
		Conexion.createTableIngredientes("RECETAS", "INGREDIENTES");
		Conexion.insertDataTipoPlato("RECETAS", "TIPOS_PLATO", "Pasta");
		Conexion.insertDataRecetas("RECETAS", "RECETA", "Spaghetti carbonara", "130.0", "1");
		Conexion.insertDataIngredientes("RECETAS", "INGREDIENTES", "Nata", "1");
		Conexion.getValuesIngredientes("RECETAS", "INGREDIENTES");
		Conexion.getValuesRecetas("RECETAS", "RECETA");
		Conexion.getValuesTiposPlato("RECETAS", "TIPOS_PLATO");
		Conexion.deleteRecord("RECETAS", "RECETA", "1");
		Conexion.deleteTAbla("RECETAS", "RECETA");
		
	}

}
