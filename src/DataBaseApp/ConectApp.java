package DataBaseApp;
import CreateQuery.Querys;
public class ConectApp {

	public static void main(String[] args) {
			Querys query = new Querys();
			query.crearConexion();
			//query.cierraConexion();
			//query.crearDataBase();
			//query.createTable();
			//query.createTableTwo();
			query.inserValuesTableOne();
			query.inserValuesTableTwo();
	}

}
