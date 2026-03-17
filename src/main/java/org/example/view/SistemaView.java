package org.example.view;

import java.util.Scanner;

/**
 * Clase SistemaView
 * Responsable de la interfaz principal del Sistema Académico.
 *
 * Esta clase maneja la presentación de:
 * - Menú principal del sistema
 * - Mensaje de bienvenida
 * - Mensaje de despedida
 * - Mensajes de error del sistema
 *
 * Es utilizada por la clase Main para mostrar la interfaz de usuario
 * y permite al usuario navegar entre los diferentes módulos del sistema.
 */
public class SistemaView {

    // Atributo privado: Scanner para capturar entrada del usuario
    private Scanner scanner;

    /**
     * Constructor
     * Inicializa el Scanner para capturar entrada desde System.in
     */
    public SistemaView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal del sistema
     * Presenta las opciones disponibles:
     * 1. Módulo de Estudiantes
     * 2. Módulo de Profesores
     * 3. Módulo de Grupos
     * 4. Módulo de Cursos
     * 5. Salir
     */
    public void mostrarMenuPrincipal() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║   SISTEMA ACADÉMICO - MENÚ PRINCIPAL║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println("1. Módulo de Estudiantes");
        System.out.println("2. Módulo de Profesores");
        System.out.println("3. Módulo de Grupos");
        System.out.println("4. Módulo de Cursos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Captura la opción del menú principal seleccionada por el usuario
     *
     * @return int - La opción numérica seleccionada, o -1 si es inválida
     */
    public int obtenerOpcionPrincipal() {
        try {
            // Intentar leer un entero desde la entrada
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            // Si no es un número válido, devolver -1
            return -1;
        }
    }

    /**
     * Muestra un mensaje de bienvenida al usuario
     * Se ejecuta cuando inicia el programa
     */
    public void mostrarBienvenida() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║   ¡Bienvenido al Sistema Académico!║");
        System.out.println("╚════════════════════════════════════╝");
    }

    /**
     * Muestra un mensaje de despedida al usuario
     * Se ejecuta cuando el usuario selecciona salir del programa
     */
    public void mostrarDespedida() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║   ¡Hasta luego! Gracias por usar   ║");
        System.out.println("║   nuestro sistema académico        ║");
        System.out.println("╚════════════════════════════════════╝");
    }

    /**
     * Muestra un mensaje de error del sistema al usuario
     * Se utiliza para informar de errores a nivel del menú principal
     * Incluye un símbolo ✗ para indicar error
     *
     * @param error - Texto de error a mostrar
     */
    public void mostrarError(String error) {
        System.out.println("✗ " + error);
    }
}

