package oop2.tp3.ejercicio3;
public class GastoAlquilerAutos extends Gasto {
    public GastoAlquilerAutos(int monto) {
        super(monto);
    }

    @Override
    public String nombre() {
        return "Alquiler de autos";
    }
}