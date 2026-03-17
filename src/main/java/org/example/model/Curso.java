package org.example.model;

/**
 * Clase Curso
 * Esta clase representa una entidad de Curso en el sistema académico.
 * Un curso es una asignatura o materia que los estudiantes pueden tomar.
 * Encapsula los datos con atributos privados y métodos públicos (getters y setters).
 *
 * Atributos:
 * - id: Identificador único del curso (asignado por la BD)
 * - nombre: Nombre del curso (ej: "Programación I", "Cálculo")
 * - descripcion: Descripción del contenido del curso
 * - estado: Estado del curso (activo o inactivo)
 */
public class Curso {

    // Atributo privado: identificador único del curso
    private int id;
    // Atributo privado: nombre del curso
    private String nombre;
    // Atributo privado: descripción del curso
    private String descripcion;
    // Atributo privado: estado del curso (activo/inactivo)
    private String estado;

    /**
     * Constructor completo
     * Se utiliza cuando se obtiene un curso de la BD y ya posee un ID
     *
     * @param id - Identificador único del curso
     * @param nombre - Nombre del curso
     * @param descripcion - Descripción del curso
     * @param estado - Estado del curso (activo/inactivo)
     */
    public Curso(int id, String nombre, String descripcion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    /**
     * Constructor sin ID
     * Se utiliza cuando se crea un nuevo curso (aún no tiene ID de BD)
     * El ID será asignado por la BD o el repositorio
     *
     * @param nombre - Nombre del curso
     * @param descripcion - Descripción del curso
     * @param estado - Estado del curso (activo/inactivo)
     */
    public Curso(String nombre, String descripcion, String estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    // ============ GETTERS Y SETTERS ============
    // Estos métodos permiten acceder y modificar los atributos privados
    // Siguiendo el principio de encapsulamiento (OOP)

    // Getter del ID: devuelve el identificador del curso
    public int getId() {
        return id;
    }

    // Setter del ID: asigna un nuevo identificador al curso
    public void setId(int id) {
        this.id = id;
    }

    // Getter del nombre: devuelve el nombre del curso
    public String getNombre() {
        return nombre;
    }

    // Setter del nombre: asigna un nuevo nombre al curso
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter de descripción: devuelve la descripción del curso
    public String getDescripcion() {
        return descripcion;
    }

    // Setter de descripción: asigna una nueva descripción al curso
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getter del estado: devuelve el estado actual del curso
    public String getEstado() {
        return estado;
    }

    // Setter del estado: asigna un nuevo estado al curso (activo/inactivo)
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método toString()
     * Devuelve una representación en texto del objeto Curso
     * Se utiliza para mostrar la información del curso de forma legible
     *
     * @return String - Representación en texto del curso
     */
    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

