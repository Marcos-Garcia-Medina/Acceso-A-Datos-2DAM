package main;

import java.util.ArrayList;

import dao.SerieDao;
import pojo.Serie;
import pojo.Temporada;

public class Main {

	public static void main(String[] args) {
		//Serie serie = new Serie("Los Simpsons", 7, "Disney Plus");
		SerieDao serieDao = new SerieDao();
		//serieDao.insertar(serie);
		
		//SerieDao serieDao = new SerieDao();
		//System.out.println(serieDao.buscarPorId(1));
		
		//SerieDao serieDao = new SerieDao();
		//Serie serie = serieDao.buscarPorId(1);
		/*Temporada t1 = new Temporada(1, "Temporada 1", serie);
		Temporada t2 = new Temporada(2, "Temporada 2", serie);
		
		TemporadaDao temporadaDao = new TemporadaDao();
		temporadaDao.insertar(t1);
		temporadaDao.insertar(t2);*/
		
		/*ArrayList<Serie> series = serieDao.buscarTodos();
		
		for(Serie serie : series) {
			System.out.println("SERIE: " + serie.getTitulo());
			for(Temporada temporada : serie.getTemporadas()) {
				System.out.println("TEMPORADA: " + temporada.getTitulo());
			}
		}*/
		
		System.out.println(serieDao.buscarPorId(2));
		
		/*ArrayList<Temporada> temporadas = serieDao.obtenerTemporadas(serie);
		for(Temporada temporada : temporadas) {
			System.out.println(temporada);
		}*/
	}

}
