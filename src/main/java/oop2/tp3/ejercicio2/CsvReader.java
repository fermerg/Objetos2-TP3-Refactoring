package oop2.tp3.ejercicio2;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    private final String fileName;

    public CsvReader(String fileName) {
        this.fileName = fileName;
    }

    public List<String[]> cargarDatosCSV() {
        List<String[]> datosCSV = new ArrayList<>();
        try (CSVReader archivo = new CSVReader(new FileReader(fileName))) {
            String[] fila;
            while ((fila = archivo.readNext()) != null) {
                datosCSV.add(fila);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        datosCSV.remove(0); // Remove header
        return datosCSV;
    }
}