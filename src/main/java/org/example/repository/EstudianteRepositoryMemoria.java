package org.example.repository;

import org.example.model.Estudiante;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase EstudianteRepositoryMemoria
 * Implementa la interfaz IEstudianteRepository para almacenamiento en memoria.
 *
 * Esta clase es útil para:
 * - Pruebas sin necesidad de BD
 * - Ejecución cuando no hay conexión a BD disponible
 * - Desarrollo inicial sin infraestructura de BD
 *
 * Características:
 * - Los datos se almacenan en un ArrayList en memoria RAM
 * - Los datos se pierden cuando finaliza el programa
 * - No requiere conexión a BD
 * - Los IDs se generan automáticamente incrementándose
 * - El acceso es más rápido que una BD
 *
 * Limitaciones:
 * - Capacidad limitada por la memoria disponible
 * - Datos no persistentes (no se guardan)
 * - No es adecuado para aplicaciones en producción
 */
public class EstudianteRepositoryMemoria implements IEstudianteRepository {

    // Lista en memoria que actúa como BD simulada
    private List<Estudiante> estudiantes = new ArrayList<>();

    // Contador para generar IDs únicos automáticamente
    private int idCounter = 1;

    /**
     * Agrega un nuevo estudiante a la lista en memoria
     * Le asigna automáticamente un ID incrementado
     *
     * @param estudiante - Objeto Estudiante a agregar
     */
    @Override
    public void agregar(Estudiante estudiante) {
        // Asignar un ID único al estudiante
        estudiante.setId(idCounter++);  // Incrementar el contador para el próximo ID
        // Agregar el estudiante a la lista
        estudiantes.add(estudiante);
    }

    /**
     * Actualiza un estudiante existente en la lista
     * Busca por ID y reemplaza el objeto
     *
     * @param estudiante - Objeto Estudiante con datos actualizados
     */
    @Override
    public void actualizar(Estudiante estudiante) {
        // Iterar sobre la lista para encontrar el estudiante con el ID correcto
        for (int i = 0; i < estudiantes.size(); i++) {
            // Si encontramos el estudiante con el ID buscado
            if (estudiantes.get(i).getId() == estudiante.getId()) {
                // Reemplazar el estudiante antiguo con el actualizado
                estudiantes.set(i, estudiante);
                return;  // Salir después de actualizar
            }
        }
    }

    /**
     * Elimina un estudiante de la lista usando su ID
     *
     * @param id - Identificador único del estudiante a eliminar
     */
    @Override
    public void eliminar(int id) {
        // Usar removeIf para eliminar el estudiante con el ID especificado
        // removeIf: elimina todos los elementos que cumplen la condición
        estudiantes.removeIf(e -> e.getId() == id);
    }

    /**
     * Obtiene un estudiante específico usando su ID
     *
     * @param id - Identificador único del estudiante
     * @return Estudiante - El estudiante encontrado, o null si no existe
     */
    @Override
    public Estudiante obtenerPorId(int id) {
        // Usar stream para buscar el primer estudiante con el ID especificado
        return estudiantes.stream()
                .filter(e -> e.getId() == id)     // Filtrar por ID
                .findFirst()                       // Obtener el primero (si existe)
                .orElse(null);                     // Devolver null si no existe
    }

    /**
     * Obtiene la lista de todos los estudiantes almacenados en memoria
     *
     * @return List<Estudiante> - Nueva lista con copias de los estudiantes
     */
    @Override
    public List<Estudiante> obtenerTodos() {
        // Devolver una copia de la lista para evitar modificaciones externas
        return new ArrayList<>(estudiantes);
    }
}

