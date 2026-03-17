package org.example.model;

/**
 * Clase Estudiante
 * Esta clase representa una entidad de Estudiante en el sistema académico.
 * Es un modelo que encapsula los datos de un estudiante con sus atributos privados
 * y métodos públicos (getters y setters) para acceder y modificar sus valores.
 *
 * Atributos:
 * - id: Identificador único del estudiante (asignado por la BD)
 * - nombre: Nombre completo del estudiante
 * - identificacion: Número de identificación único (cédula, pasaporte, etc.)
 * - email: Correo electrónico del estudiante
 * - fechaNacimiento: Fecha de nacimiento en formato YYYY-MM-DD
 * - estado: Estado del estudiante (activo o inactivo)
 */
public class Estudiante {

    // Atributo privado: identificador único del estudiante
    private int id;
    // Atributo privado: nombre completo del estudiante
    private String nombre;
    // Atributo privado: identificación única (ej: cédula)
    private String identificacion;
    // Atributo privado: correo electrónico del estudiante
    private String email;
    // Atributo privado: fecha de nacimiento (formato: YYYY-MM-DD)
    private String fechaNacimiento;
    // Atributo privado: estado del estudiante (activo/inactivo)
    private String estado;

    /**
     * Constructor completo
     * Se utiliza cuando se obtiene un estudiante de la BD y ya posee un ID
     *
     * @param id - Identificador único del estudiante
     * @param nombre - Nombre completo del estudiante
     * @param identificacion - Número de identificación único
     * @param email - Correo electrónico del estudiante
     * @param fechaNacimiento - Fecha de nacimiento (YYYY-MM-DD)
     * @param estado - Estado del estudiante (activo/inactivo)
     */
    public Estudiante(int id, String nombre, String identificacion, String email, String fechaNacimiento, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    /**
     * Constructor sin ID
     * Se utiliza cuando se crea un nuevo estudiante (aún no tiene ID de BD)
     * El ID será asignado por la BD o el repositorio
     *
     * @param nombre - Nombre completo del estudiante
     * @param identificacion - Número de identificación único
     * @param email - Correo electrónico del estudiante
     * @param fechaNacimiento - Fecha de nacimiento (YYYY-MM-DD)
     * @param estado - Estado del estudiante (activo/inactivo)
     */
    public Estudiante(String nombre, String identificacion, String email, String fechaNacimiento, String estado) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    // ============ GETTERS Y SETTERS ============
    // Estos métodos permiten acceder y modificar los atributos privados
    // Siguiendo el principio de encapsulamiento (OOP)

    // Getter del ID: devuelve el identificador del estudiante
    public int getId() {
        return id;
    }

    // Setter del ID: asigna un nuevo identificador al estudiante
    public void setId(int id) {
        this.id = id;
    }

    // Getter del nombre: devuelve el nombre del estudiante
    public String getNombre() {
        return nombre;
    }

    // Setter del nombre: asigna un nuevo nombre al estudiante
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter de identificación: devuelve el número de identificación
    public String getIdentificacion() {
        return identificacion;
    }

    // Setter de identificación: asigna una nueva identificación al estudiante
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    // Getter del email: devuelve el correo electrónico del estudiante
    public String getEmail() {
        return email;
    }

    // Setter del email: asigna un nuevo correo electrónico al estudiante
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter de fecha de nacimiento: devuelve la fecha de nacimiento
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    // Setter de fecha de nacimiento: asigna una nueva fecha de nacimiento
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    // Getter del estado: devuelve el estado actual del estudiante
    public String getEstado() {
        return estado;
    }

    // Setter del estado: asigna un nuevo estado al estudiante (activo/inactivo)
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método toString()
     * Devuelve una representación en texto del objeto Estudiante
     * Se utiliza para mostrar la información del estudiante de forma legible
     *
     * @return String - Representación en texto del estudiante
     */
    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}

