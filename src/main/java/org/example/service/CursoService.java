package org.example.service;

import org.example.model.Curso;
import org.example.repository.ICursoRepository;
import org.example.util.Validaciones;
import java.util.List;

/**
 * Clase CursoService
 * Implementa la lógica de negocio para la gestión de Cursos.
 *
 * Responsabilidades:
 * - Validar datos antes de enviarlos al repositorio
 * - Implementar reglas de negocio específicas para cursos
 * - Orquestar operaciones entre vistas y repositorios
 *
 * Similar a EstudianteService pero para la entidad Curso
 */
public class CursoService implements ICursoService {

    // Repositorio inyectado para acceso a datos
    private ICursoRepository repository;
    // Utilidad para validaciones de datos
    private Validaciones validaciones;

    /**
     * Constructor
     * Recibe el repositorio inyectado y crea instancia de Validaciones
     *
     * @param repository - Implementación del repositorio (MySQL o Memoria)
     */
    public CursoService(ICursoRepository repository) {
        this.repository = repository;
        this.validaciones = new Validaciones();
    }

    /**
     * Agrega un nuevo curso validando todos sus datos
     *
     * @param curso - Objeto Curso a agregar
     */
    @Override
    public void agregar(Curso curso) {
        // Validar que el curso sea válido
        if (validaciones.esValido(curso)) {
            // Si es válido, delegar al repositorio
            repository.agregar(curso);
        } else {
            // Si no es válido, mostrar error sin guardar
            System.out.println("✗ Datos del curso inválidos");
        }
    }

    /**
     * Actualiza un curso existente validando sus datos
     *
     * @param curso - Objeto Curso con datos actualizados
     */
    @Override
    public void actualizar(Curso curso) {
        // Validar que el curso sea válido
        if (validaciones.esValido(curso)) {
            // Si es válido, delegar al repositorio
            repository.actualizar(curso);
        } else {
            // Si no es válido, mostrar error sin actualizar
            System.out.println("✗ Datos del curso inválidos");
        }
    }

    /**
     * Elimina un curso usando su ID
     *
     * @param id - Identificador único del curso a eliminar
     */
    @Override
    public void eliminar(int id) {
        // Delegar la eliminación al repositorio
        repository.eliminar(id);
    }

    /**
     * Obtiene un curso específico usando su ID
     *
     * @param id - Identificador único del curso
     * @return Curso - El curso encontrado, o null si no existe
     */
    @Override
    public Curso obtenerPorId(int id) {
        // Delegar la búsqueda al repositorio
        return repository.obtenerPorId(id);
    }

    /**
     * Obtiene la lista de todos los cursos
     *
     * @return List<Curso> - Lista con todos los cursos registrados
     */
    @Override
    public List<Curso> obtenerTodos() {
        // Delegar la búsqueda de todos los cursos al repositorio
        return repository.obtenerTodos();
    }
}

