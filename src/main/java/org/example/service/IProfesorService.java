package org.example.service;

import org.example.model.Profesor;
import java.util.List;

/**
 * Interfaz IProfesorService
 * Define el contrato para la lógica de negocio de Profesores.
 *
 * Esta interfaz especifica qué operaciones de negocio deben implementarse.
 * Contiene validaciones y reglas de negocio específicas para profesores.
 *
 * Implementación esperada:
 * - ProfesorService: Implementa la lógica de negocio
 */
public interface IProfesorService {
    // Agregar un nuevo profesor con validaciones
    void agregar(Profesor profesor);
    // Actualizar un profesor existente con validaciones
    void actualizar(Profesor profesor);
    // Eliminar un profesor por su ID
    void eliminar(int id);
    // Obtener un profesor específico por su ID
    Profesor obtenerPorId(int id);
    // Obtener la lista de todos los profesores
    List<Profesor> obtenerTodos();
}

