package org.example.view;

import java.util.Scanner;

/**
 * Clase ProfesorView
 * Responsable de la interfaz de usuario para el módulo de Profesores.
 *
 * Responsabilidades:
 * - Mostrar menús y opciones al usuario
 * - Capturar entrada del usuario desde consola
 * - Mostrar mensajes de error, éxito e información
 * - Mantener la presentación separada de la lógica
 *
 * Patrón: Separación de Vista (V) en arquitectura MVC
 */
public class ProfesorView {

    // Scanner para capturar entrada del usuario
    private Scanner scanner;

    /**
     * Constructor
     * Inicializa el Scanner para capturar entrada desde System.in
     */
    public ProfesorView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal del módulo de Profesores
     * Presenta las opciones disponibles para gestionar profesores
     */
    public void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║     MÓDULO DE PROFESORES           ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println("1. Agregar Profesor");
        System.out.println("2. Actualizar Profesor");
        System.out.println("3. Eliminar Profesor");
        System.out.println("4. Consultar Profesor");
        System.out.println("5. Listar Todos");
        System.out.println("6. Volver");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Captura la opción del menú seleccionada por el usuario
     *
     * @return int - La opción numérica, o -1 si no es válida
     */
    public int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Solicita el nombre del profesor al usuario
     *
     * @return String - El nombre ingresado
     */
    public String obtenerNombre() {
        System.out.print("Nombre: ");
        return scanner.nextLine();
    }

    /**
     * Solicita el número de identificación del profesor al usuario
     *
     * @return String - La identificación ingresada
     */
    public String obtenerIdentificacion() {
        System.out.print("Identificación: ");
        return scanner.nextLine();
    }

    /**
     * Solicita el correo electrónico del profesor al usuario
     *
     * @return String - El email ingresado
     */
    public String obtenerEmail() {
        System.out.print("Email: ");
        return scanner.nextLine();
    }

    /**
     * Solicita el departamento del profesor al usuario
     *
     * @return String - El departamento ingresado
     */
    public String obtenerDepartamento() {
        System.out.print("Departamento: ");
        return scanner.nextLine();
    }

    /**
     * Solicita el estado del profesor al usuario
     *
     * @return String - El estado ingresado (activo/inactivo)
     */
    public String obtenerEstado() {
        System.out.print("Estado (activo/inactivo): ");
        return scanner.nextLine();
    }

    /**
     * Solicita el ID del profesor con el que se desea trabajar
     *
     * @return int - El ID ingresado, o -1 si es inválido
     */
    public int obtenerIdProfesor() {
        System.out.print("ID del Profesor: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
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
     *
     * @param error - Texto de error a mostrar
     */
    public void mostrarError(String error) {
        System.out.println("✗ " + error);
    }

    /**
     * Muestra un mensaje de éxito al usuario
     *
     * @param mensaje - Texto de éxito a mostrar
     */
    public void mostrarExito(String mensaje) {
        System.out.println("✓ " + mensaje);
    }
}

