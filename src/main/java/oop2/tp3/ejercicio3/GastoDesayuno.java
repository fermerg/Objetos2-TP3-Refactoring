package oop2.tp3.ejercicio3;
public class GastoDesayuno extends Gasto {
    public GastoDesayuno(int monto) {
        super(monto);
    }

    @Override
    public String nombre() {
        return "Desayuno";
    }

    protected int montoComida() {
        return this.monto();
    }

    @Override
    protected boolean esExceso() {
        return this.monto() > 1000;
    }
}