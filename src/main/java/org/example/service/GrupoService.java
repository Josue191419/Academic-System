package org.example.service;

import org.example.model.Grupo;
import org.example.repository.IGrupoRepository;
import org.example.util.Validaciones;
import java.util.List;

/**
 * Clase GrupoService
 * Implementa la lógica de negocio para la gestión de Grupos.
 *
 * Responsabilidades:
 * - Validar datos antes de enviarlos al repositorio
 * - Implementar reglas de negocio específicas para grupos
 * - Orquestar operaciones entre vistas y repositorios
 *
 * Similar a EstudianteService pero para la entidad Grupo
 */
public class GrupoService implements IGrupoService {

    // Repositorio inyectado para acceso a datos
    private IGrupoRepository repository;
    // Utilidad para validaciones de datos
    private Validaciones validaciones;

    /**
     * Constructor
     * Recibe el repositorio inyectado y crea instancia de Validaciones
     *
     * @param repository - Implementación del repositorio (MySQL o Memoria)
     */
    public GrupoService(IGrupoRepository repository) {
        this.repository = repository;
        this.validaciones = new Validaciones();
    }

    /**
     * Agrega un nuevo grupo validando todos sus datos
     *
     * @param grupo - Objeto Grupo a agregar
     */
    @Override
    public void agregar(Grupo grupo) {
        // Validar que el grupo sea válido
        if (validaciones.esValido(grupo)) {
            // Si es válido, delegar al repositorio
            repository.agregar(grupo);
        } else {
            // Si no es válido, mostrar error sin guardar
            System.out.println("✗ Datos del grupo inválidos");
        }
    }

    /**
     * Actualiza un grupo existente validando sus datos
     *
     * @param grupo - Objeto Grupo con datos actualizados
     */
    @Override
    public void actualizar(Grupo grupo) {
        // Validar que el grupo sea válido
        if (validaciones.esValido(grupo)) {
            // Si es válido, delegar al repositorio
            repository.actualizar(grupo);
        } else {
            // Si no es válido, mostrar error sin actualizar
            System.out.println("✗ Datos del grupo inválidos");
        }
    }

    /**
     * Elimina un grupo usando su ID
     *
     * @param id - Identificador único del grupo a eliminar
     */
    @Override
    public void eliminar(int id) {
        // Delegar la eliminación al repositorio
        repository.eliminar(id);
    }

    /**
     * Obtiene un grupo específico usando su ID
     *
     * @param id - Identificador único del grupo
     * @return Grupo - El grupo encontrado, o null si no existe
     */
    @Override
    public Grupo obtenerPorId(int id) {
        // Delegar la búsqueda al repositorio
        return repository.obtenerPorId(id);
    }

    /**
     * Obtiene la lista de todos los grupos
     *
     * @return List<Grupo> - Lista con todos los grupos registrados
     */
    @Override
    public List<Grupo> obtenerTodos() {
        // Delegar la búsqueda de todos los grupos al repositorio
        return repository.obtenerTodos();
    }
}

