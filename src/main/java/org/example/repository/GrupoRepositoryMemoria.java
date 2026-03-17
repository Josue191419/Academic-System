package org.example.repository;

import org.example.model.Grupo;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase GrupoRepositoryMemoria
 * Implementa la interfaz IGrupoRepository para almacenamiento en memoria.
 *
 * Los datos se almacenan en un ArrayList en lugar de una BD MySQL.
 * Útil para pruebas sin necesidad de conexión a BD.
 *
 * Similar a EstudianteRepositoryMemoria pero para la entidad Grupo.
 */
public class GrupoRepositoryMemoria implements IGrupoRepository {

    // Lista en memoria que simula la BD
    private List<Grupo> grupos = new ArrayList<>();
    // Contador para generar IDs únicos automáticamente
    private int idCounter = 1;

    /**
     * Agrega un nuevo grupo a la lista en memoria
     * Le asigna automáticamente un ID incrementado
     *
     * @param grupo - Objeto Grupo a agregar
     */
    @Override
    public void agregar(Grupo grupo) {
        // Asignar ID único e incrementar el contador
        grupo.setId(idCounter++);
        // Agregar a la lista
        grupos.add(grupo);
    }

    /**
     * Actualiza un grupo existente en la lista
     * Busca por ID y reemplaza el objeto
     *
     * @param grupo - Objeto Grupo con datos actualizados
     */
    @Override
    public void actualizar(Grupo grupo) {
        // Buscar el grupo por ID y actualizar
        for (int i = 0; i < grupos.size(); i++) {
            if (grupos.get(i).getId() == grupo.getId()) {
                grupos.set(i, grupo);
                return;
            }
        }
    }

    /**
     * Elimina un grupo de la lista usando su ID
     *
     * @param id - Identificador único del grupo a eliminar
     */
    @Override
    public void eliminar(int id) {
        // Eliminar el grupo con el ID especificado
        grupos.removeIf(g -> g.getId() == id);
    }

    /**
     * Obtiene un grupo específico usando su ID
     *
     * @param id - Identificador único del grupo
     * @return Grupo - El grupo encontrado, o null si no existe
     */
    @Override
    public Grupo obtenerPorId(int id) {
        // Buscar y devolver el primer grupo con el ID especificado
        return grupos.stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Obtiene la lista de todos los grupos almacenados en memoria
     *
     * @return List<Grupo> - Nueva lista con copias de los grupos
     */
    @Override
    public List<Grupo> obtenerTodos() {
        // Devolver una copia de la lista
        return new ArrayList<>(grupos);
    }
}


