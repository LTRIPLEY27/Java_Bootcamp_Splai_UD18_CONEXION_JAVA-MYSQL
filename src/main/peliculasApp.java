package main;

import Clases.ConexionPeliculas;

public class peliculasApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConexionPeliculas.openConnection();
		ConexionPeliculas.createDB("Peliculas");
		ConexionPeliculas.createTablePeliculas("Peliculas", "PELICULAS");
		ConexionPeliculas.createTableSalas("Peliculas", "SALAS");
		ConexionPeliculas.insertDataPeliculas("Peliculas",  "PELICULAS", "a", 10);
		ConexionPeliculas.insertDataSalas("Peliculas", "SALAS", "Sala1", 1);
		ConexionPeliculas.getValuesPeliculas("Peliculas",  "PELICULAS");
		ConexionPeliculas.getValuesSalas("Peliculas", "SALAS");
		ConexionPeliculas.deleteRecord("Peliculas", "SALAS", "1");
		ConexionPeliculas.deleteTAbla("Peliculas", "SALAS");
		
	}

}
