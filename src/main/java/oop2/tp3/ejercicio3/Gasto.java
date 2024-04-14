package oop2.tp3.ejercicio3;
public abstract class Gasto {
    private final int monto;

    public Gasto(int monto) {
        this.monto = monto;
    }

    public int monto() {
        return this.monto;
    }

    protected int montoComida() {
        return 0;
    }

    protected boolean esExceso() {
        return false;
    }

    public abstract String nombre();
}