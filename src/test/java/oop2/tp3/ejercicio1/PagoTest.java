package oop2.tp3.ejercicio1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagoTest {
    @Test
    public void testPago() {

        Libro laMeta = new LibroInfantil("La Metamorfosis");
        Libro rayuela = new LibroNuevoLanzamiento("Rayuela");
        Libro ficciones = new LibroRegular("Ficciones");
        Cliente yo = getCliente(laMeta, rayuela, ficciones);

        Object[] resultado = yo.calcularDeudaYPuntosObtenidos();
        assertEquals(14.0, resultado[0]);
        assertEquals(4, resultado[1]);
    }

    private static Cliente getCliente(Libro laMeta, Libro rayuela, Libro ficciones) {
        CopiaLibro libroLaMeta = new CopiaLibro(laMeta);
        CopiaLibro libroRayuela = new CopiaLibro(rayuela);
        CopiaLibro libroFicciones = new CopiaLibro(ficciones);
        Alquiler alquilerLaMeta = new Alquiler(libroLaMeta, 4);
        Alquiler alquilerRayuela = new Alquiler(libroRayuela, 3);
        Alquiler alquilerFicciones = new Alquiler(libroFicciones, 2);
        Cliente yo = new Cliente("Javier");
        yo.alquilar(alquilerFicciones);
        yo.alquilar(alquilerLaMeta);
        yo.alquilar(alquilerRayuela);
        return yo;
    }

    @Test
    public void testPuntos(){
        Libro rayuela = new LibroNuevoLanzamiento("Rayuela");
        CopiaLibro libroRayuela = new CopiaLibro(rayuela);
        Alquiler alquilerRayuela = new Alquiler(libroRayuela, 1);
        Cliente yo = new Cliente("Javier");
        yo.alquilar(alquilerRayuela);
        Object[] resultado = yo.calcularDeudaYPuntosObtenidos();

        assertEquals(1, resultado[1]);
    }
}
