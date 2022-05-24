package digital.house;


import digital.house.flyweight.factory.ComputerFactory;
import digital.house.flyweight.model.Computer;

public class Aplication {
    public static void main(String[] args) {
        // Definir factory
        ComputerFactory computerFactory = new ComputerFactory();
        //Definir objeto
        Computer equipo;
        for (int i = 1; i < 24; i++) {
            if (esPar(i)) {
                equipo = computerFactory.crearComputadora(16, 500);
            } else {
                equipo = computerFactory.crearComputadora(2, 128);
            }
        }
        System.out.println("Total en cache: " + Computer.getContador());
    }

    public static boolean esPar(int numero) {
        return ((numero % 2) == 0);
    }
}

//TODO: Modelo Computer
//TODO: Factory Computer
//TODO: Main Computer alearotias
