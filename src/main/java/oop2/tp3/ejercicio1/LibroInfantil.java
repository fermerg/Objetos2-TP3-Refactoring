package oop2.tp3.ejercicio1;
public class LibroInfantil extends Libro{
    private static final double PRECIO_BASE = 1.5;
    private static final double RECARGO = 1.5;
    private static final double LIMITE_DIAS = 3;

    public LibroInfantil(String nombre) {
        super(nombre);
    }


    @Override
    public double calcularDeuda(int diasAlquilados) {
        double monto = PRECIO_BASE;
        if (diasAlquilados > LIMITE_DIAS){
            monto += (diasAlquilados - LIMITE_DIAS) * RECARGO;
        }
        return monto;
    }

    @Override
    public int calcularPuntos(int diasAlquilados) {
        return super.calcularPuntos(diasAlquilados);
    }
}