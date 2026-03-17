package org.example.repository;

import org.example.model.Curso;
import java.util.List;

/**
 * Interfaz ICursoRepository
 * Define el contrato para la persistencia de datos de Cursos.
 * Especifica las operaciones CRUD que debe implementar cualquier repositorio de Cursos.
 *
 * Implementaciones esperadas:
 * - CursoRepositoryMySQL: Persiste datos en BD MySQL
 * - CursoRepositoryMemoria: Persiste datos en memoria (ArrayList)
 */
public interface ICursoRepository {
    // Agregar un nuevo curso
    void agregar(Curso curso);
    // Actualizar un curso existente
    void actualizar(Curso curso);
    // Eliminar un curso por su ID
    void eliminar(int id);
    // Obtener un curso específico por su ID
    Curso obtenerPorId(int id);
    // Obtener la lista de todos los cursos
    List<Curso> obtenerTodos();
}

