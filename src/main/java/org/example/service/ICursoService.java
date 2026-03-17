package org.example.service;

import org.example.model.Curso;
import java.util.List;

/**
 * Interfaz ICursoService
 * Define el contrato para la lógica de negocio de Cursos.
 *
 * Esta interfaz especifica qué operaciones de negocio deben implementarse.
 * Contiene validaciones y reglas de negocio específicas para cursos.
 *
 * Implementación esperada:
 * - CursoService: Implementa la lógica de negocio
 */
public interface ICursoService {
    // Agregar un nuevo curso con validaciones
    void agregar(Curso curso);
    // Actualizar un curso existente con validaciones
    void actualizar(Curso curso);
    // Eliminar un curso por su ID
    void eliminar(int id);
    // Obtener un curso específico por su ID
    Curso obtenerPorId(int id);
    // Obtener la lista de todos los cursos
    List<Curso> obtenerTodos();
}

