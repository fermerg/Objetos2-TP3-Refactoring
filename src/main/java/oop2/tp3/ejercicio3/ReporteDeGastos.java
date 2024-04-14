package oop2.tp3.ejercicio3;

import java.time.LocalDate;
import java.util.List;

public class ReporteDeGastos {

    public String imprimir(List<Gasto> gastos, LocalDate fechaReporte) {
        int total = 0;
        int gastosDeComida = 0;
        String reporte;

        reporte = "Expenses " + fechaReporte + "\n";

        for (Gasto gasto : gastos) {
            gastosDeComida += gasto.montoComida();

            String nombreGasto = gasto.nombre();

            String marcaExcesoComidas = gasto.esExceso() ? "X" : " ";

            reporte += nombreGasto + " " + gasto.monto() + " " + marcaExcesoComidas + "\n";

            total += gasto.monto();
        }
        reporte += "Gastos de comida: " + gastosDeComida + "\n";
        reporte += "Total de gastos: " + total + "\n";

        return reporte;
    }
}
