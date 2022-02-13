package DataBaseApp;
import CreateQuery.QuerysTienda;
import CreateQuery.FatherClass;
import CreateQuery.QuerysAlmacenes;
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
		
		/*QuerysTienda tienda = new QuerysTienda("remote", "Taquito20.", "TIENDA_INFORMATICA", "FABRICANTES", "ARTICULOS");
		tienda.crearConexion();
		tienda.crearDataBase();
		tienda.createTableFabricantes();
		tienda.createTableArticulos();*/
		
		QuerysAlmacenes almacen = new QuerysAlmacenes("remote", "Taquito20.", "ALMACENES", "ALMACENES", "CAJAS");
		almacen.crearConexion();
		almacen.crearDataBase();
		almacen.createTableAlmacenes();
		almacen.createTableCajas();
		almacen.inserValuesTableOneAlmacenes();
		almacen.inserValuesTableTwoCajas();
		//almacen.getValues();
	}

}
