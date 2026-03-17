package org.example.service;

import org.example.model.Estudiante;
import org.example.repository.IEstudianteRepository;
import org.example.util.Validaciones;
import java.util.List;

/**
 * Clase EstudianteService
 * Implementa la lógica de negocio para la gestión de Estudiantes.
 *
 * Responsabilidades:
 * - Validar datos antes de enviarlos al repositorio
 * - Implementar reglas de negocio
 * - Orquestar operaciones entre vistas y repositorios
 * - Manejar excepciones de negocio
 *
 * Arquitectura:
 * View -> Controller -> Service -> Repository -> BD
 *
 * Patrón: Inyección de Dependencias
 * - El repositorio se inyecta en el constructor
 * - Permite cambiar de implementación sin modificar el servicio
 * - Facilita las pruebas unitarias
 */
public class EstudianteService implements IEstudianteService {

    // Atributo privado: repositorio para acceso a datos
    private IEstudianteRepository repository;

    // Atributo privado: utilidad para validaciones
    private Validaciones validaciones;

    /**
     * Constructor
     * Recibe el repositorio inyectado (inyección de dependencias)
     * Inicializa la instancia de Validaciones
     *
     * @param repository - Implementación del repositorio (MySQL o Memoria)
     */
    public EstudianteService(IEstudianteRepository repository) {
        this.repository = repository;
        this.validaciones = new Validaciones();
    }

    /**
     * Agrega un nuevo estudiante validando todos sus datos
     *
     * Lógica:
     * 1. Validar que todos los datos del estudiante sean correctos
     * 2. Si es válido, delegar al repositorio para guardar
     * 3. Si no es válido, mostrar mensaje de error sin guardar
     *
     * @param estudiante - Objeto Estudiante a agregar
     */
    @Override
    public void agregar(Estudiante estudiante) {
        // Verificar si el estudiante es válido usando la clase Validaciones
        if (validaciones.esValido(estudiante)) {
            // Si es válido, delegar la persistencia al repositorio
            repository.agregar(estudiante);
        } else {
            // Si no es válido, informar al usuario sin guardar
            System.out.println("✗ Datos del estudiante inválidos");
        }
    }

    /**
     * Actualiza un estudiante existente validando sus datos
     *
     * Lógica:
     * 1. Validar que todos los datos del estudiante sean correctos
     * 2. Si es válido, delegar al repositorio para actualizar
     * 3. Si no es válido, mostrar mensaje de error sin actualizar
     *
     * @param estudiante - Objeto Estudiante con datos actualizados
     */
    @Override
    public void actualizar(Estudiante estudiante) {
        // Verificar si el estudiante es válido
        if (validaciones.esValido(estudiante)) {
            // Si es válido, delegar la actualización al repositorio
            repository.actualizar(estudiante);
        } else {
            // Si no es válido, informar al usuario sin actualizar
            System.out.println("✗ Datos del estudiante inválidos");
        }
    }

    /**
     * Elimina un estudiante usando su ID
     *
     * Nota: En este caso no hacemos validaciones adicionales,
     * simplemente delegamos la operación al repositorio
     *
     * @param id - Identificador único del estudiante a eliminar
     */
    @Override
    public void eliminar(int id) {
        // Delegar la eliminación al repositorio
        repository.eliminar(id);
    }

    /**
     * Obtiene un estudiante específico usando su ID
     *
     * @param id - Identificador único del estudiante
     * @return Estudiante - El estudiante encontrado, o null si no existe
     */
    @Override
    public Estudiante obtenerPorId(int id) {
        // Delegar la búsqueda al repositorio
        return repository.obtenerPorId(id);
    }

    /**
     * Obtiene la lista de todos los estudiantes
     *
     * @return List<Estudiante> - Lista con todos los estudiantes registrados
     */
    @Override
    public List<Estudiante> obtenerTodos() {
        // Delegar la búsqueda de todos los estudiantes al repositorio
        return repository.obtenerTodos();
    }
}

