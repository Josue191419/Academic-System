package org.example.repository;

import org.example.model.Profesor;
import java.util.List;

/**
 * Interfaz IProfesorRepository
 * Define el contrato para la persistencia de datos de Profesores.
 * Especifica las operaciones CRUD que debe implementar cualquier repositorio de Profesores.
 *
 * Implementaciones esperadas:
 * - ProfesorRepositoryMySQL: Persiste datos en BD MySQL
 * - ProfesorRepositoryMemoria: Persiste datos en memoria (ArrayList)
 */
public interface IProfesorRepository {
    // Agregar un nuevo profesor
    void agregar(Profesor profesor);
    // Actualizar un profesor existente
    void actualizar(Profesor profesor);
    // Eliminar un profesor por su ID
    void eliminar(int id);
    // Obtener un profesor específico por su ID
    Profesor obtenerPorId(int id);
    // Obtener la lista de todos los profesores
    List<Profesor> obtenerTodos();
}

