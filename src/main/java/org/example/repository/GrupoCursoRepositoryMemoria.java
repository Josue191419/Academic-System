package org.example.repository;

import org.example.model.GrupoCurso;
import java.util.ArrayList;
import java.util.List;

// Clase GrupoCursoRepositoryMemoria
// Implementa IGrupoCursoRepository para almacenamiento en memoria
public class GrupoCursoRepositoryMemoria implements IGrupoCursoRepository {

    // Lista en memoria para almacenar las relaciones grupo-curso
    private List<GrupoCurso> grupoCursos = new ArrayList<>();
    // Contador para generar IDs únicos
    private int idCounter = 1;

    // Agregar una nueva relación grupo-curso
    @Override
    public void agregar(GrupoCurso grupoCurso) {
        // Asignar ID único
        grupoCurso.setId(idCounter++);
        // Agregar a la lista
        grupoCursos.add(grupoCurso);
    }

    // Actualizar una relación existente
    @Override
    public void actualizar(GrupoCurso grupoCurso) {
        // Buscar la relación por ID
        for (int i = 0; i < grupoCursos.size(); i++) {
            if (grupoCursos.get(i).getId() == grupoCurso.getId()) {
                // Actualizar la relación
                grupoCursos.set(i, grupoCurso);
                return;
            }
        }
    }

    // Eliminar una relación por ID
    @Override
    public void eliminar(int id) {
        // Remover la relación con el ID especificado
        grupoCursos.removeIf(gc -> gc.getId() == id);
    }

    // Obtener una relación por ID
    @Override
    public GrupoCurso obtenerPorId(int id) {
        // Buscar y retornar la relación con el ID
        for (GrupoCurso gc : grupoCursos) {
            if (gc.getId() == id) {
                return gc;
            }
        }
        return null;
    }

    // Obtener todas las relaciones
    @Override
    public List<GrupoCurso> obtenerTodos() {
        // Retornar una copia de la lista para evitar modificaciones externas
        return new ArrayList<>(grupoCursos);
    }
}
