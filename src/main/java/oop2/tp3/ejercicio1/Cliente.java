package oop2.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String name;
    private List<Alquiler> alquileres = new ArrayList<>();

    public Cliente(String nombre) {
        this.name = nombre;
    }

    public void alquilar(Alquiler rental) {
        alquileres.add(rental);
    }
    public Object[] calcularDeudaYPuntosObtenidos(){
        Object[] resultado = new Object[2];
        double totalDeuda = 0;
        int puntos = 0;
        for (Alquiler alquiler : alquileres){
            totalDeuda += alquiler.calcularDeuda();
            puntos += alquiler.calcularPuntos();
        }
        resultado[0] = totalDeuda;
        resultado[1] = puntos;
        return resultado;
    }

}
