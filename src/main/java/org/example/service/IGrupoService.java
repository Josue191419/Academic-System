package org.example.service;

import org.example.model.Grupo;
import java.util.List;

/**
 * Interfaz IGrupoService
 * Define el contrato para la lógica de negocio de Grupos.
 *
 * Esta interfaz especifica qué operaciones de negocio deben implementarse.
 * Contiene validaciones y reglas de negocio específicas para grupos.
 *
 * Implementación esperada:
 * - GrupoService: Implementa la lógica de negocio
 */
public interface IGrupoService {
    // Agregar un nuevo grupo con validaciones
    void agregar(Grupo grupo);
    // Actualizar un grupo existente con validaciones
    void actualizar(Grupo grupo);
    // Eliminar un grupo por su ID
    void eliminar(int id);
    // Obtener un grupo específico por su ID
    Grupo obtenerPorId(int id);
    // Obtener la lista de todos los grupos
    List<Grupo> obtenerTodos();
}

