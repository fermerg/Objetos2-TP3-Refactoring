package oop2.tp3.ejercicio2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recaudacion {
    public static final int PERMALINK_INDEX = 0;
    public static final int COMPANY_NAME_INDEX = 1;
    public static final int NUMBER_EMPLOYEES_INDEX = 2;
    public static final int CATEGORY_INDEX = 3;
    public static final int CITY_INDEX = 4;
    public static final int STATE_INDEX = 5;
    public static final int FUNDED_DATE_INDEX = 6;
    public static final int RAISED_AMOUNT_INDEX = 7;
    public static final int RAISED_CURRENCY_INDEX = 8;
    public static final int ROUND_INDEX = 9;
    private final CsvReader csvReader;

    public Recaudacion() {
        this.csvReader = new CsvReader();
    }

    private static List<String[]> filterByOption(List<String[]> datosCSV, int indice, String valor) {
        List<String[]> datosFiltrados = new ArrayList<>();

        for (String[] datosCsv : datosCSV) {
            if (datosCsv[indice].equals(valor)) {
                datosFiltrados.add(datosCsv);
            }
        }
        return datosFiltrados;
    }

    private static List<Map<String, String>> getMaps(List<String[]> datosCSV) {
        List<Map<String, String>> output = new ArrayList<>();

        for (String[] datoCsv : datosCSV) {
            Map<String, String> mapeado = new HashMap<String, String>();
            mapeado.put("permalink", datoCsv[PERMALINK_INDEX]);
            mapeado.put("company_name", datoCsv[COMPANY_NAME_INDEX]);
            mapeado.put("number_employees", datoCsv[NUMBER_EMPLOYEES_INDEX]);
            mapeado.put("category", datoCsv[CATEGORY_INDEX]);
            mapeado.put("city", datoCsv[CITY_INDEX]);
            mapeado.put("state", datoCsv[STATE_INDEX]);
            mapeado.put("funded_date", datoCsv[FUNDED_DATE_INDEX]);
            mapeado.put("raised_amount", datoCsv[RAISED_AMOUNT_INDEX]);
            mapeado.put("raised_currency", datoCsv[RAISED_CURRENCY_INDEX]);
            mapeado.put("round", datoCsv[ROUND_INDEX]);
            output.add(mapeado);
        }
        return output;
    }

    public List<Map<String, String>> filtrarDatos(Map<String, String> options) {

        List<String[]> datosCSV = this.csvReader.cargarDatosCSV();


        if (options.containsKey("company_name")) {
            datosCSV = filterByOption(datosCSV, COMPANY_NAME_INDEX, options.get("company_name"));
        }

        if (options.containsKey("city")) {
            datosCSV = filterByOption(datosCSV, CITY_INDEX, options.get("city"));
        }

        if (options.containsKey("state")) {
            datosCSV = filterByOption(datosCSV, STATE_INDEX, options.get("state"));
        }

        if (options.containsKey("round")) {
            datosCSV = filterByOption(datosCSV, ROUND_INDEX, options.get("round"));
        }

        return getMaps(datosCSV);
    }
}


//Ejercicio 2, Pasos a realizar:
//
//    Movamos la lectura del archivo csv a otra clase.
//    Mejoremos el for utizando el foreach.
//    Transformemos el método estático en método de instancia (agreguemos constructor e inicialicemos ahi).
//    Removamos código duplicado utilizando expresiones lambda.
//    Removamos las constantes duplicadas.