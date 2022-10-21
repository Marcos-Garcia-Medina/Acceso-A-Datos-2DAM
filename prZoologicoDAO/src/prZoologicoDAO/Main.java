package prZoologicoDAO;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Animal a = new Animal("Perro","Casa", 30);
		Animal b = new Animal("Carpincho","Casa", 30);
		AnimalDAO.insertAnimal(a);
		//AnimalDAO.insertAnimal(b);
		//AnimalDAO.deleteAllAnimales();
		
		//AnimalDAO.deleteAnimalByNombre("Perro");
		
		//Animal a = AnimalDAO.findById(5);
		//System.out.println(a.toString());
		
		ArrayList<Animal> animales = AnimalDAO.findAllAnimales();
		
		for(int i = 0; i < animales.size();i++) {
			System.out.println(animales.get(i));
		}
			
		
	}

}
