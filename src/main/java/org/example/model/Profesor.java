package org.example.model;

/**
 * Clase Profesor
 * Esta clase representa una entidad de Profesor en el sistema académico.
 * Encapsula los datos de un profesor con atributos privados y métodos públicos
 * (getters y setters) siguiendo el principio de encapsulamiento de POO.
 *
 * Atributos:
 * - id: Identificador único del profesor (asignado por la BD)
 * - nombre: Nombre completo del profesor
 * - identificacion: Número de identificación único (cédula, pasaporte, etc.)
 * - email: Correo electrónico del profesor
 * - departamento: Departamento al que pertenece el profesor
 * - estado: Estado del profesor (activo o inactivo)
 */
public class Profesor {

    // Atributo privado: identificador único del profesor
    private int id;
    // Atributo privado: nombre completo del profesor
    private String nombre;
    // Atributo privado: identificación única (ej: cédula)
    private String identificacion;
    // Atributo privado: correo electrónico del profesor
    private String email;
    // Atributo privado: departamento al que pertenece
    private String departamento;
    // Atributo privado: estado del profesor (activo/inactivo)
    private String estado;

    /**
     * Constructor completo
     * Se utiliza cuando se obtiene un profesor de la BD y ya posee un ID
     *
     * @param id - Identificador único del profesor
     * @param nombre - Nombre completo del profesor
     * @param identificacion - Número de identificación único
     * @param email - Correo electrónico del profesor
     * @param departamento - Departamento al que pertenece
     * @param estado - Estado del profesor (activo/inactivo)
     */
    public Profesor(int id, String nombre, String identificacion, String email, String departamento, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
        this.departamento = departamento;
        this.estado = estado;
    }

    /**
     * Constructor sin ID
     * Se utiliza cuando se crea un nuevo profesor (aún no tiene ID de BD)
     * El ID será asignado por la BD o el repositorio
     *
     * @param nombre - Nombre completo del profesor
     * @param identificacion - Número de identificación único
     * @param email - Correo electrónico del profesor
     * @param departamento - Departamento al que pertenece
     * @param estado - Estado del profesor (activo/inactivo)
     */
    public Profesor(String nombre, String identificacion, String email, String departamento, String estado) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
        this.departamento = departamento;
        this.estado = estado;
    }

    // ============ GETTERS Y SETTERS ============
    // Estos métodos permiten acceder y modificar los atributos privados
    // Siguiendo el principio de encapsulamiento (OOP)

    // Getter del ID: devuelve el identificador del profesor
    public int getId() {
        return id;
    }

    // Setter del ID: asigna un nuevo identificador al profesor
    public void setId(int id) {
        this.id = id;
    }

    // Getter del nombre: devuelve el nombre del profesor
    public String getNombre() {
        return nombre;
    }

    // Setter del nombre: asigna un nuevo nombre al profesor
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter de identificación: devuelve el número de identificación
    public String getIdentificacion() {
        return identificacion;
    }

    // Setter de identificación: asigna una nueva identificación al profesor
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    // Getter del email: devuelve el correo electrónico del profesor
    public String getEmail() {
        return email;
    }

    // Setter del email: asigna un nuevo correo electrónico al profesor
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter del departamento: devuelve el departamento del profesor
    public String getDepartamento() {
        return departamento;
    }

    // Setter del departamento: asigna un nuevo departamento al profesor
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    // Getter del estado: devuelve el estado actual del profesor
    public String getEstado() {
        return estado;
    }

    // Setter del estado: asigna un nuevo estado al profesor (activo/inactivo)
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método toString()
     * Devuelve una representación en texto del objeto Profesor
     * Se utiliza para mostrar la información del profesor de forma legible
     *
     * @return String - Representación en texto del profesor
     */
    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", email='" + email + '\'' +
                ", departamento='" + departamento + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

