package org.example.service;

import org.example.model.Estudiante;
import java.util.List;

/**
 * Interfaz IEstudianteService
 * Define el contrato para la lógica de negocio relacionada con Estudiantes.
 *
 * Esta interfaz especifica qué operaciones de negocio deben ser implementadas.
 * A diferencia del repositorio, el servicio:
 * - Contiene la lógica de validación
 * - Orquesta múltiples repositorios si es necesario
 * - Implementa reglas de negocio
 * - Maneja excepciones de negocio
 *
 * Implementación esperada:
 * - EstudianteService: Implementa la lógica de negocio usando IEstudianteRepository
 *
 * Principios aplicados:
 * - Separación de capas (vista, negocio, datos)
 * - Inyección de dependencias
 * - Single Responsibility Principle (SRP)
 */
public interface IEstudianteService {

    /**
     * Agrega un nuevo estudiante validando los datos
     *
     * @param estudiante - Objeto Estudiante a agregar
     */
    void agregar(Estudiante estudiante);

    /**
     * Actualiza un estudiante existente validando los datos
     *
     * @param estudiante - Objeto Estudiante con datos actualizados
     */
    void actualizar(Estudiante estudiante);

    /**
     * Elimina un estudiante del sistema
     *
     * @param id - Identificador único del estudiante a eliminar
     */
    void eliminar(int id);

    /**
     * Obtiene un estudiante específico
     *
     * @param id - Identificador único del estudiante
     * @return Estudiante - El estudiante encontrado, o null si no existe
     */
    Estudiante obtenerPorId(int id);

    /**
     * Obtiene la lista de todos los estudiantes
     *
     * @return List<Estudiante> - Lista con todos los estudiantes
     */
    List<Estudiante> obtenerTodos();
}

