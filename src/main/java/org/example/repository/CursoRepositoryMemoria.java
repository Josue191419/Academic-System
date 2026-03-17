package org.example.repository;

import org.example.model.Curso;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase CursoRepositoryMemoria
 * Implementa la interfaz ICursoRepository para almacenamiento en memoria.
 *
 * Los datos se almacenan en un ArrayList en lugar de una BD MySQL.
 * Útil para pruebas sin necesidad de conexión a BD.
 *
 * Similar a EstudianteRepositoryMemoria pero para la entidad Curso.
 */
public class CursoRepositoryMemoria implements ICursoRepository {

    // Lista en memoria que simula la BD
    private List<Curso> cursos = new ArrayList<>();
    // Contador para generar IDs únicos automáticamente
    private int idCounter = 1;

    /**
     * Agrega un nuevo curso a la lista en memoria
     * Le asigna automáticamente un ID incrementado
     *
     * @param curso - Objeto Curso a agregar
     */
    @Override
    public void agregar(Curso curso) {
        // Asignar ID único e incrementar el contador
        curso.setId(idCounter++);
        // Agregar a la lista
        cursos.add(curso);
    }

    /**
     * Actualiza un curso existente en la lista
     * Busca por ID y reemplaza el objeto
     *
     * @param curso - Objeto Curso con datos actualizados
     */
    @Override
    public void actualizar(Curso curso) {
        // Buscar el curso por ID y actualizar
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getId() == curso.getId()) {
                cursos.set(i, curso);
                return;
            }
        }
    }

    /**
     * Elimina un curso de la lista usando su ID
     *
     * @param id - Identificador único del curso a eliminar
     */
    @Override
    public void eliminar(int id) {
        // Eliminar el curso con el ID especificado
        cursos.removeIf(c -> c.getId() == id);
    }

    /**
     * Obtiene un curso específico usando su ID
     *
     * @param id - Identificador único del curso
     * @return Curso - El curso encontrado, o null si no existe
     */
    @Override
    public Curso obtenerPorId(int id) {
        // Buscar y devolver el primer curso con el ID especificado
        return cursos.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Obtiene la lista de todos los cursos almacenados en memoria
     *
     * @return List<Curso> - Nueva lista con copias de los cursos
     */
    @Override
    public List<Curso> obtenerTodos() {
        // Devolver una copia de la lista
        return new ArrayList<>(cursos);
    }
}

