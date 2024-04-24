package oop2.tp3.ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Recaudacion {

    public static final String COMPANY_NAME = "company_name";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String ROUND = "round";
    private final CsvReader csvReader;
    private List<String[]> data;

    public Recaudacion() {
        this.csvReader = new CsvReader("src/main/resources/data.csv");
    }

    private static List<Map<String, String>> transformToListOfHashMap(List<String[]> datosCSV) {
        List<Map<String, String>> output = new ArrayList<>();

        for (String[] datoCsv : datosCSV) {
            Map<String, String> mapeado = new HashMap<String, String>();
            mapeado.put("permalink", datoCsv[0]);
            mapeado.put(COMPANY_NAME, datoCsv[1]);
            mapeado.put("number_employees", datoCsv[2]);
            mapeado.put("category", datoCsv[3]);
            mapeado.put(CITY, datoCsv[4]);
            mapeado.put(STATE, datoCsv[5]);
            mapeado.put("funded_date", datoCsv[6]);
            mapeado.put("raised_amount", datoCsv[7]);
            mapeado.put("raised_currency", datoCsv[8]);
            mapeado.put(ROUND, datoCsv[9]);
            output.add(mapeado);
        }
        return output;
    }

    private List<String[]> filter(Predicate<String[]> predicate) {
        List<String[]> datosFiltrados = new ArrayList<>();

        for (String[] fila : data) {
            if (predicate.test(fila)) {
                datosFiltrados.add(fila);
            }
        }
        return datosFiltrados;
    }

    public List<Map<String, String>> where(Map<String, String> options) {

        data = this.csvReader.cargarDatosCSV();


        if (options.containsKey(COMPANY_NAME)) {
            data = filter((fila) -> fila[1].equals(options.get(COMPANY_NAME)));
        }

        if (options.containsKey(CITY)) {
            data = filter((fila) -> fila[4].equals(options.get(CITY)));
        }

        if (options.containsKey(STATE)) {
            data = filter((fila) -> fila[5].equals(options.get(STATE)));
        }

        if (options.containsKey(ROUND)) {
            data = filter((fila) -> fila[9].equals(options.get(ROUND)));
        }

        return transformToListOfHashMap(data);
    }
}


//Ejercicio 2, Pasos a realizar:
//
//    Movamos la lectura del archivo csv a otra clase.
//    Mejoremos el for utizando el foreach.
//    Transformemos el método estático en método de instancia (agreguemos constructor e inicialicemos ahi).
//    Removamos código duplicado utilizando expresiones lambda.
//    Removamos las constantes duplicadas.