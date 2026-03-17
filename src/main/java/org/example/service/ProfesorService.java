package org.example.service;

import org.example.model.Profesor;
import org.example.repository.IProfesorRepository;
import org.example.util.Validaciones;
import java.util.List;

/**
 * Clase ProfesorService
 * Implementa la lógica de negocio para la gestión de Profesores.
 *
 * Responsabilidades:
 * - Validar datos antes de enviarlos al repositorio
 * - Implementar reglas de negocio específicas para profesores
 * - Orquestar operaciones entre vistas y repositorios
 *
 * Similar a EstudianteService pero para la entidad Profesor
 */
public class ProfesorService implements IProfesorService {

    // Repositorio inyectado para acceso a datos
    private IProfesorRepository repository;
    // Utilidad para validaciones de datos
    private Validaciones validaciones;

    /**
     * Constructor
     * Recibe el repositorio inyectado y crea instancia de Validaciones
     *
     * @param repository - Implementación del repositorio (MySQL o Memoria)
     */
    public ProfesorService(IProfesorRepository repository) {
        this.repository = repository;
        this.validaciones = new Validaciones();
    }

    /**
     * Agrega un nuevo profesor validando todos sus datos
     *
     * @param profesor - Objeto Profesor a agregar
     */
    @Override
    public void agregar(Profesor profesor) {
        // Validar que el profesor sea válido
        if (validaciones.esValido(profesor)) {
            // Si es válido, delegar al repositorio
            repository.agregar(profesor);
        } else {
            // Si no es válido, mostrar error sin guardar
            System.out.println("✗ Datos del profesor inválidos");
        }
    }

    /**
     * Actualiza un profesor existente validando sus datos
     *
     * @param profesor - Objeto Profesor con datos actualizados
     */
    @Override
    public void actualizar(Profesor profesor) {
        // Validar que el profesor sea válido
        if (validaciones.esValido(profesor)) {
            // Si es válido, delegar al repositorio
            repository.actualizar(profesor);
        } else {
            // Si no es válido, mostrar error sin actualizar
            System.out.println("✗ Datos del profesor inválidos");
        }
    }

    /**
     * Elimina un profesor usando su ID
     *
     * @param id - Identificador único del profesor a eliminar
     */
    @Override
    public void eliminar(int id) {
        // Delegar la eliminación al repositorio
        repository.eliminar(id);
    }

    /**
     * Obtiene un profesor específico usando su ID
     *
     * @param id - Identificador único del profesor
     * @return Profesor - El profesor encontrado, o null si no existe
     */
    @Override
    public Profesor obtenerPorId(int id) {
        // Delegar la búsqueda al repositorio
        return repository.obtenerPorId(id);
    }

    /**
     * Obtiene la lista de todos los profesores
     *
     * @return List<Profesor> - Lista con todos los profesores registrados
     */
    @Override
    public List<Profesor> obtenerTodos() {
        // Delegar la búsqueda de todos los profesores al repositorio
        return repository.obtenerTodos();
    }
}

