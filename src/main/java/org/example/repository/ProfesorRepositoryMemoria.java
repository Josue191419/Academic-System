package org.example.repository;

import org.example.model.Profesor;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ProfesorRepositoryMemoria
 * Implementa la interfaz IProfesorRepository para almacenamiento en memoria.
 *
 * Los datos se almacenan en un ArrayList en lugar de una BD MySQL.
 * Útil para pruebas sin necesidad de conexión a BD.
 *
 * Similar a EstudianteRepositoryMemoria pero para la entidad Profesor.
 */
public class ProfesorRepositoryMemoria implements IProfesorRepository {

    // Lista en memoria que simula la BD
    private List<Profesor> profesores = new ArrayList<>();
    // Contador para generar IDs únicos automáticamente
    private int idCounter = 1;

    /**
     * Agrega un nuevo profesor a la lista en memoria
     * Le asigna automáticamente un ID incrementado
     *
     * @param profesor - Objeto Profesor a agregar
     */
    @Override
    public void agregar(Profesor profesor) {
        // Asignar ID único e incrementar el contador
        profesor.setId(idCounter++);
        // Agregar a la lista
        profesores.add(profesor);
    }

    /**
     * Actualiza un profesor existente en la lista
     * Busca por ID y reemplaza el objeto
     *
     * @param profesor - Objeto Profesor con datos actualizados
     */
    @Override
    public void actualizar(Profesor profesor) {
        // Buscar el profesor por ID y actualizar
        for (int i = 0; i < profesores.size(); i++) {
            if (profesores.get(i).getId() == profesor.getId()) {
                profesores.set(i, profesor);
                return;
            }
        }
    }

    /**
     * Elimina un profesor de la lista usando su ID
     *
     * @param id - Identificador único del profesor a eliminar
     */
    @Override
    public void eliminar(int id) {
        // Eliminar el profesor con el ID especificado
        profesores.removeIf(p -> p.getId() == id);
    }

    /**
     * Obtiene un profesor específico usando su ID
     *
     * @param id - Identificador único del profesor
     * @return Profesor - El profesor encontrado, o null si no existe
     */
    @Override
    public Profesor obtenerPorId(int id) {
        // Buscar y devolver el primer profesor con el ID especificado
        return profesores.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Obtiene la lista de todos los profesores almacenados en memoria
     *
     * @return List<Profesor> - Nueva lista con copias de los profesores
     */
    @Override
    public List<Profesor> obtenerTodos() {
        // Devolver una copia de la lista
        return new ArrayList<>(profesores);
    }
}

