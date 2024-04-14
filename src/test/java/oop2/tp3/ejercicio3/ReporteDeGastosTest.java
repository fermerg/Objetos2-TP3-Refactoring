package oop2.tp3.ejercicio3;

import oop2.tp3.ejercicio3.GastoAlquilerAutos;
import oop2.tp3.ejercicio3.GastoCena;
import oop2.tp3.ejercicio3.GastoDesayuno;
import oop2.tp3.ejercicio3.ReporteDeGastos;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReporteDeGastosTest {
    @Test
    public void testImprimirReporteDeGastosDesayuno() {
        var gasto = new GastoDesayuno(1000);
        var reporte = new ReporteDeGastos();
        var salida = reporte.imprimir(List.of(gasto), LocalDate.now());
        assertEquals("Expenses " + LocalDate.now() + "\n" +
                "Desayuno 1000  \n" +
                "Gastos de comida: 1000\n" +
                "Total de gastos: 1000\n", salida);
    }

    @Test
    public void testImprimirReporteDeGastosCena() {
        var gasto = new GastoCena(2000);
        var reporte = new ReporteDeGastos();
        var salida = reporte.imprimir(List.of(gasto), LocalDate.of(2024, 4, 14));
        assertEquals("Expenses 2024-04-14\n" +
                "Cena 2000  \n" +
                "Gastos de comida: 2000\n" +
                "Total de gastos: 2000\n", salida);
    }

    @Test
    public void testImprimirReporteDeGastosAlquilerAuto() {
        var gasto = new GastoAlquilerAutos(6000);
        var reporte = new ReporteDeGastos();
        var salida = reporte.imprimir(List.of(gasto), LocalDate.now());
        assertEquals("Expenses " + LocalDate.now() + "\n" +
                "Alquiler de autos 6000  \n" +
                "Gastos de comida: 0\n" +
                "Total de gastos: 6000\n", salida);
    }

    @Test
    public void testImprimirReporteDeGastosComidaYAlquilerAuto() {
        var gasto = new GastoAlquilerAutos(4000);
        var gastoCena = new GastoCena(7500);
        var reporte = new ReporteDeGastos();
        var salida = reporte.imprimir(List.of(gasto, gastoCena),
                LocalDate.of(2024,4, 14));
        assertEquals("Expenses 2024-04-14\n" +
                "Alquiler de autos 4000  \n" +
                "Cena 7500 X\n" +
                "Gastos de comida: 7500\n" +
                "Total de gastos: 11500\n", salida);
    }


}

//Ejercicio 3: Utilicemos polimorfismo y collecting parameters.
//
//    Escribamos tests. Hagamos lo mínimo para que nos permita testear.
//    Por ejemplo, no usar sysout, retornar un String con el reporte. Esto nos permite asertar contra el valor de retorno.
//    Incorporemos la jerarquía de gastos para utilizar polimorfismo.
//    Apliquemos polimorfismo para eliminar el switch.
//    Apliquemos polimorfismo (collecting parameter) para eliminar preguntar por el tipo para el cálculo del monto de comida.
//    Apliquemos polimorfismo (collecting parameter) para eliminar preguntar por el tipo para la marca de exceso.
