package org.example.repository;

import org.example.model.Grupo;
import java.util.List;

/**
 * Interfaz IGrupoRepository
 * Define el contrato para la persistencia de datos de Grupos.
 * Especifica las operaciones CRUD que debe implementar cualquier repositorio de Grupos.
 *
 * Implementaciones esperadas:
 * - GrupoRepositoryMySQL: Persiste datos en BD MySQL
 * - GrupoRepositoryMemoria: Persiste datos en memoria (ArrayList)
 */
public interface IGrupoRepository {
    // Agregar un nuevo grupo
    void agregar(Grupo grupo);
    // Actualizar un grupo existente
    void actualizar(Grupo grupo);
    // Eliminar un grupo por su ID
    void eliminar(int id);
    // Obtener un grupo específico por su ID
    Grupo obtenerPorId(int id);
    // Obtener la lista de todos los grupos
    List<Grupo> obtenerTodos();
}

