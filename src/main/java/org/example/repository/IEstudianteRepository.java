package org.example.repository;

import org.example.model.Estudiante;
import java.util.List;

/**
 * Interfaz IEstudianteRepository
 * Define el contrato para la persistencia de datos de Estudiantes.
 *
 * Esta interfaz especifica qué operaciones CRUD (Create, Read, Update, Delete)
 * deben ser implementadas por cualquier clase que desee actuar como repositorio
 * de estudiantes (ya sea MySQL, memoria, archivos, etc.).
 *
 * Principios SOLID aplicados:
 * - Segregación de Interfaz: Interfaz pequeña y específica
 * - Inversión de Dependencias: El código cliente depende de abstracciones, no de implementaciones
 *
 * Implementaciones esperadas:
 * - EstudianteRepositoryMySQL: Persiste datos en BD MySQL
 * - EstudianteRepositoryMemoria: Persiste datos en memoria (ArrayList)
 */
public interface IEstudianteRepository {

    /**
     * Agrega un nuevo estudiante al repositorio
     *
     * @param estudiante - Objeto Estudiante a agregar
     */
    void agregar(Estudiante estudiante);

    /**
     * Actualiza los datos de un estudiante existente
     * El estudiante a actualizar es identificado por su ID
     *
     * @param estudiante - Objeto Estudiante con datos actualizados
     */
    void actualizar(Estudiante estudiante);

    /**
     * Elimina un estudiante del repositorio
     *
     * @param id - Identificador único del estudiante a eliminar
     */
    void eliminar(int id);

    /**
     * Obtiene un estudiante específico por su identificador
     *
     * @param id - Identificador único del estudiante
     * @return Estudiante - El objeto Estudiante encontrado, o null si no existe
     */
    Estudiante obtenerPorId(int id);

    /**
     * Obtiene la lista de todos los estudiantes registrados
     *
     * @return List<Estudiante> - Lista con todos los estudiantes, vacía si no hay registros
     */
    List<Estudiante> obtenerTodos();
}

