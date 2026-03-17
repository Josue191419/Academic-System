package org.example.view;

import java.util.Scanner;

/**
 * Clase EstudianteView
 * Responsable de la interfaz de usuario (UI) para el módulo de Estudiantes.
 *
 * Responsabilidades:
 * - Mostrar menús y opciones al usuario
 * - Capturar entrada del usuario desde consola
 * - Mostrar mensajes de error, éxito e información
 * - Mantener la presentación separada de la lógica de negocio
 *
 * Patrón: Separación de Vista (V) en arquitectura MVC
 *
 * La vista no contiene lógica de negocio, solo presentación.
 * El controlador es responsable de interpretar los datos de la vista.
 */
public class EstudianteView {

    // Atributo privado: Scanner para capturar entrada del usuario
    private Scanner scanner;

    /**
     * Constructor
     * Inicializa el Scanner para capturar entrada desde System.in
     */
    public EstudianteView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal del módulo de Estudiantes
     * Presenta las opciones disponibles:
     * 1. Agregar
     * 2. Actualizar
     * 3. Eliminar
     * 4. Consultar
     * 5. Listar todos
     * 6. Volver
     */
    public void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║     MÓDULO DE ESTUDIANTES          ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println("1. Agregar Estudiante");
        System.out.println("2. Actualizar Estudiante");
        System.out.println("3. Eliminar Estudiante");
        System.out.println("4. Consultar Estudiante");
        System.out.println("5. Listar Todos");
        System.out.println("6. Volver");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Captura la opción del menú seleccionada por el usuario
     *
     * @return int - La opción numérica seleccionada, o -1 si es inválida
     */
    public int obtenerOpcion() {
        try {
            // Intentar leer un entero desde la entrada
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // Si no es un número válido, devolver -1
            return -1;
        }
    }

    /**
     * Solicita el nombre del estudiante al usuario
     *
     * @return String - El nombre ingresado por el usuario
     */
    public String obtenerNombre() {
        System.out.print("Nombre: ");
        return scanner.nextLine();
    }

    /**
     * Solicita el número de identificación del estudiante al usuario
     *
     * @return String - La identificación ingresada por el usuario
     */
    public String obtenerIdentificacion() {
        System.out.print("Identificación: ");
        return scanner.nextLine();
    }

    /**
     * Solicita el correo electrónico del estudiante al usuario
     *
     * @return String - El email ingresado por el usuario
     */
    public String obtenerEmail() {
        System.out.print("Email: ");
        return scanner.nextLine();
    }

    /**
     * Solicita la fecha de nacimiento del estudiante al usuario
     * Especifica el formato esperado: YYYY-MM-DD
     *
     * @return String - La fecha ingresada por el usuario
     */
    public String obtenerFechaNacimiento() {
        System.out.print("Fecha de Nacimiento (YYYY-MM-DD): ");
        return scanner.nextLine();
    }

    /**
     * Solicita el estado del estudiante al usuario
     * Especifica las opciones válidas: activo/inactivo
     *
     * @return String - El estado ingresado por el usuario
     */
    public String obtenerEstado() {
        System.out.print("Estado (activo/inactivo): ");
        return scanner.nextLine();
    }

    /**
     * Solicita el ID del estudiante con el que se desea trabajar
     *
     * @return int - El ID ingresado por el usuario, o -1 si es inválido
     */
    public int obtenerIdEstudiante() {
        System.out.print("ID del Estudiante: ");
        try {
            // Intentar leer un entero desde la entrada
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // Si no es un número válido, devolver -1
            return -1;
        }
    }

    /**
     * Muestra un mensaje informativo al usuario
     *
     * @param mensaje - Texto a mostrar
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Muestra un mensaje de error al usuario
     * Incluye un símbolo ✗ para indicar error
     *
     * @param error - Texto de error a mostrar
     */
    public void mostrarError(String error) {
        System.out.println("✗ " + error);
    }

    /**
     * Muestra un mensaje de éxito al usuario
     * Incluye un símbolo ✓ para indicar éxito
     *
     * @param mensaje - Texto de éxito a mostrar
     */
    public void mostrarExito(String mensaje) {
        System.out.println("✓ " + mensaje);
    }
}

