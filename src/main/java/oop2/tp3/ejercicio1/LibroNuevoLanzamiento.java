package oop2.tp3.ejercicio1;
public class LibroNuevoLanzamiento extends Libro{
    private static final double PRECIO_BASE = 3;
    private static final double BONUS_DIAS = 1;

    public LibroNuevoLanzamiento(String nombre) {
        super(nombre);
    }


    @Override
    public double calcularDeuda(int diasAlquilados) {
        double monto = diasAlquilados * PRECIO_BASE;
        return monto;
    }

    @Override
    public int calcularPuntos(int diasAlquilados) {
        return(diasAlquilados > BONUS_DIAS ? 2 : 1);
    }
}
