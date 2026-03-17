package org.example.model;

/**
 * Clase Grupo
 * Esta clase representa una entidad de Grupo en el sistema académico.
 * Un grupo es un conjunto de estudiantes que comparten cursos o actividades comunes.
 * Encapsula los datos con atributos privados y métodos públicos (getters y setters).
 *
 * Atributos:
 * - id: Identificador único del grupo (asignado por la BD)
 * - nombre: Nombre del grupo (ej: "Grupo A", "Grupo 2024-1")
 * - descripcion: Descripción o características del grupo
 * - estado: Estado del grupo (activo o inactivo)
 */
public class Grupo {

    // Atributo privado: identificador único del grupo
    private int id;
    // Atributo privado: nombre del grupo
    private String nombre;
    // Atributo privado: descripción del grupo
    private String descripcion;
    // Atributo privado: estado del grupo (activo/inactivo)
    private String estado;

    /**
     * Constructor completo
     * Se utiliza cuando se obtiene un grupo de la BD y ya posee un ID
     *
     * @param id - Identificador único del grupo
     * @param nombre - Nombre del grupo
     * @param descripcion - Descripción del grupo
     * @param estado - Estado del grupo (activo/inactivo)
     */
    public Grupo(int id, String nombre, String descripcion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    /**
     * Constructor sin ID
     * Se utiliza cuando se crea un nuevo grupo (aún no tiene ID de BD)
     * El ID será asignado por la BD o el repositorio
     *
     * @param nombre - Nombre del grupo
     * @param descripcion - Descripción del grupo
     * @param estado - Estado del grupo (activo/inactivo)
     */
    public Grupo(String nombre, String descripcion, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    // ============ GETTERS Y SETTERS ============
    // Estos métodos permiten acceder y modificar los atributos privados
    // Siguiendo el principio de encapsulamiento (OOP)

    // Getter del ID: devuelve el identificador del grupo
    public int getId() {
        return id;
    }

    // Setter del ID: asigna un nuevo identificador al grupo
    public void setId(int id) {
        this.id = id;
    }

    // Getter del nombre: devuelve el nombre del grupo
    public String getNombre() {
        return nombre;
    }

    // Setter del nombre: asigna un nuevo nombre al grupo
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter de descripción: devuelve la descripción del grupo
    public String getDescripcion() {
        return descripcion;
    }

    // Setter de descripción: asigna una nueva descripción al grupo
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter del estado: devuelve el estado actual del grupo
    public String getEstado() {
        return estado;
    }

    // Setter del estado: asigna un nuevo estado al grupo (activo/inactivo)
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método toString()
     * Devuelve una representación en texto del objeto Grupo
     * Se utiliza para mostrar la información del grupo de forma legible
     *
     * @return String - Representación en texto del grupo
     */
    @Override
    public String toString() {
        return "Grupo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

