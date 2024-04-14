package oop2.tp3.ejercicio3;
public class GastoCena extends Gasto {
    public GastoCena(int monto) {
        super(monto);
    }

    public String nombre() {
        return "Cena";
    }

    protected int montoComida() {
        return this.monto();
    }

    @Override
    protected boolean esExceso() {
        return this.monto() > 5000;
    }

}