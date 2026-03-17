package org.example.util;

import org.example.model.Estudiante;
import org.example.model.Profesor;
import org.example.model.Grupo;
import org.example.model.Curso;

/**
 * Clase Validaciones
 * Esta clase contiene métodos para validar los datos de entrada del sistema.
 * Implementa validaciones de:
 * - Campos de texto (no vacíos)
 * - Formato de correo electrónico
 * - Números de identificación
 * - Estados válidos (activo/inactivo)
 * - Formato de fechas
 * - Objetos completos (Estudiante, Profesor, Grupo, Curso)
 *
 * Se utiliza en la capa de servicios para garantizar que los datos sean válidos
 * antes de ser almacenados en la BD.
 */
public class Validaciones {

    /**
     * Valida que un texto no sea nulo ni esté vacío
     *
     * @param texto - Cadena de texto a validar
     * @return boolean - true si el texto es válido, false en caso contrario
     */
    public boolean textoValido(String texto) {
        // Verifica que el texto no sea nulo, no esté vacío y no contenga solo espacios en blanco
        return texto != null && !texto.isEmpty() && !texto.trim().isEmpty();
    }

    /**
     * Valida que una dirección de correo electrónico tenga un formato válido
     * Utiliza expresión regular para validar el patrón de email
     *
     * Patrón: usuario@dominio.extension
     * Ejemplo: juan@gmail.com
     *
     * @param email - Dirección de correo a validar
     * @return boolean - true si el email tiene formato válido, false en caso contrario
     */
    public boolean emailValido(String email) {
        // Expresión regular que valida formato de email
        // ^[A-Za-z0-9+_.-]+ = inicio: letras, números, símbolos (+_.-)
        // @([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$ = dominio.extensión (mínimo 2 letras)
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$");
    }

    /**
     * Valida que una identificación sea válida
     * Debe ser:
     * - No nula
     * - Contener solo dígitos numéricos
     * - Tener una longitud mínima de 5 caracteres
     *
     * @param identificacion - Número de identificación a validar
     * @return boolean - true si es válida, false en caso contrario
     */
    public boolean identificacionValida(String identificacion) {
        // Valida que sea numérica y tenga al menos 5 dígitos
        return identificacion != null && identificacion.matches("^[0-9]+$") && identificacion.length() >= 5;
    }

    /**
     * Valida que un estado sea uno de los valores permitidos: "activo" o "inactivo"
     * La validación no distingue entre mayúsculas y minúsculas
     *
     * @param estado - Estado a validar ("activo" o "inactivo")
     * @return boolean - true si es un estado válido, false en caso contrario
     */
    public boolean estadoValido(String estado) {
        // Verifica que el estado sea exactamente "activo" o "inactivo" (sin importar mayúsculas)
        return estado != null && (estado.equalsIgnoreCase("activo") || estado.equalsIgnoreCase("inactivo"));
    }

    /**
     * Valida que una fecha tenga el formato correcto YYYY-MM-DD
     * Ejemplo: 1990-05-15 (15 de mayo de 1990)
     *
     * @param fecha - Fecha a validar en formato YYYY-MM-DD
     * @return boolean - true si el formato es válido, false en caso contrario
     */
    public boolean fechaValida(String fecha) {
        // Expresión regular que valida formato YYYY-MM-DD
        // \\d{4} = 4 dígitos para el año
        // \\d{2} = 2 dígitos para el mes
        // \\d{2} = 2 dígitos para el día
        return fecha != null && fecha.matches("^\\d{4}-\\d{2}-\\d{2}$");
    }

    /**
     * Valida que un objeto Estudiante sea completamente válido
     * Valida todos sus atributos según las reglas específicas de Estudiante
     *
     * @param estudiante - Objeto Estudiante a validar
     * @return boolean - true si todos los datos del estudiante son válidos, false en caso contrario
     */
    public boolean esValido(Estudiante estudiante) {
        // Verificar que el estudiante no sea nulo
        // Y que TODOS sus atributos cumplan con las validaciones individuales
        return estudiante != null &&
                textoValido(estudiante.getNombre()) &&              // Nombre no vacío
                identificacionValida(estudiante.getIdentificacion()) &&  // ID válida
                emailValido(estudiante.getEmail()) &&               // Email con formato correcto
                fechaValida(estudiante.getFechaNacimiento()) &&     // Fecha en formato YYYY-MM-DD
                estadoValido(estudiante.getEstado());               // Estado activo/inactivo
    }

    /**
     * Valida que un objeto Profesor sea completamente válido
     * Valida todos sus atributos según las reglas específicas de Profesor
     *
     * @param profesor - Objeto Profesor a validar
     * @return boolean - true si todos los datos del profesor son válidos, false en caso contrario
     */
    public boolean esValido(Profesor profesor) {
        // Verificar que el profesor no sea nulo
        // Y que TODOS sus atributos cumplan con las validaciones individuales
        return profesor != null &&
                textoValido(profesor.getNombre()) &&               // Nombre no vacío
                identificacionValida(profesor.getIdentificacion()) &&   // ID válida
                emailValido(profesor.getEmail()) &&                // Email con formato correcto
                textoValido(profesor.getDepartamento()) &&         // Departamento no vacío
                estadoValido(profesor.getEstado());                // Estado activo/inactivo
    }

    /**
     * Valida que un objeto Grupo sea completamente válido
     * Valida todos sus atributos según las reglas específicas de Grupo
     *
     * @param grupo - Objeto Grupo a validar
     * @return boolean - true si todos los datos del grupo son válidos, false en caso contrario
     */
    public boolean esValido(Grupo grupo) {
        // Verificar que el grupo no sea nulo
        // Y que TODOS sus atributos cumplan con las validaciones individuales
        return grupo != null &&
                textoValido(grupo.getNombre()) &&                  // Nombre no vacío
                textoValido(grupo.getDescripcion()) &&             // Descripción no vacía
                estadoValido(grupo.getEstado());                   // Estado activo/inactivo
    }

    /**
     * Valida que un objeto Curso sea completamente válido
     * Valida todos sus atributos según las reglas específicas de Curso
     *
     * @param curso - Objeto Curso a validar
     * @return boolean - true si todos los datos del curso son válidos, false en caso contrario
     */
    public boolean esValido(Curso curso) {
        // Verificar que el curso no sea nulo
        // Y que TODOS sus atributos cumplan con las validaciones individuales
        return curso != null &&
                textoValido(curso.getNombre()) &&                  // Nombre no vacío
                textoValido(curso.getDescripcion()) &&             // Descripción no vacía
                estadoValido(curso.getEstado());                   // Estado activo/inactivo
    }
}
