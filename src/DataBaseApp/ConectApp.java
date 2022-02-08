package DataBaseApp;
import CreateQuery.QuerysTienda;
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
			QuerysAlmacenes almacen = new QuerysAlmacenes();
			
			almacen.crearConexion();
			/*almacen.crearDataBase();
			almacen.createTable();
			almacen.createTableTwo();
			almacen.inserValuesTableOne();
			almacen.inserValuesTableTwo();*/
			almacen.getValues();
	}

}
