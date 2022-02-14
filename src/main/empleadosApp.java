package main;

import Clases.Conexion;
import Clases.ConexionEmpleados;

public class empleadosApp {

	public static void main(String[] args) {
		
		ConexionEmpleados.openConnection();
		ConexionEmpleados.createDB("Empleados");
		ConexionEmpleados.createTableDepartamentos("Empleados", "DEPARTAMENTOS");
		ConexionEmpleados.createTableEmpleados("Empleados", "EMPLEADOS");
		ConexionEmpleados.insertDataDepartamentos("Empleados", "DEPARTAMENTOS", "Los pibes", "600");
		ConexionEmpleados.insertDataEmpleados("Empleados", "EMPLEADOS", "12345678", "a", "b", "1");
		ConexionEmpleados.getValuesDepartamentos("Empleados", "DEPARTAMENTOS");
		ConexionEmpleados.getValuesEmpleados("Empleados", "EMPLEADOS");
		ConexionEmpleados.deleteRecord("Empleados", "DEPARTAMENTOS", "1");
		ConexionEmpleados.deleteTAbla("Empleados", "DEPARTAMENTOS");
	}

}
