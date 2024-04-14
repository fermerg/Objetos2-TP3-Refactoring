package oop2.tp3.ejercicio4;

import org.jdbi.v3.core.Jdbi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PersonaRepository {

    private final Jdbi jdbi;

    public PersonaRepository(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    /**
     * Busca por nombre o parte
     */
    public List<Persona> buscarPorNombre(String nombreOParte) {
        return jdbi.withHandle(handle -> {
            var resultado = handle
                    .select("SELECT nombre, apellido FROM persona WHERE nombre LIKE ?")
                    .bind(0, "%" + nombreOParte + "%")
                    .mapToMap(String.class)
                    .list();

            List<Persona> personas = new ArrayList<>();

            for (Map<String, String> map : resultado) {
                personas.add(new Persona(map.get("nombre"), map.get("apellido")));
            }

            return personas;
        });

    }


    /**
     * Dado un id, retorna:
     * - null si el id no se encuentra en la BD
     * - la instancia de Persona encontrada
     */
    public Optional<Persona> buscarId(Long id) {
        return jdbi.withHandle(handle -> {

            var resultado = handle
                    .select("SELECT nombre, apellido FROM persona WHERE id_persona = ?")
                    .bind(0, id)
                    .mapToMap(String.class)
                    .list();

            if (resultado.isEmpty()) {
                return Optional.empty();
            }

            return Optional.of(new Persona(resultado.get(0).get("nombre"), resultado.get(0).get("apellido")));

        });
    }

}
