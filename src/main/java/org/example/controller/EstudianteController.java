package org.example.controller;

import org.example.model.Estudiante;
import org.example.service.IEstudianteService;
import org.example.view.EstudianteView;
import java.util.List;

/**
 * Clase EstudianteController
 * Actúa como intermediaria entre la vista y el servicio.
 *
 * Responsabilidades:
 * - Capturar entrada del usuario desde la vista
 * - Orquestar las operaciones del servicio
 * - Presentar resultados al usuario a través de la vista
 * - Controlar el flujo de la aplicación para el módulo de estudiantes
 *
 * Arquitectura MVC:
 * - Vista (EstudianteView): Interfaz de usuario
 * - Controlador (EstudianteController): Lógica de flujo
 * - Servicio (IEstudianteService): Lógica de negocio
 * - Repositorio: Acceso a datos
 *
 * Patrón: Separación de responsabilidades
 */
public class EstudianteController {

    // Atributo privado: servicio para operaciones de estudiantes
    private IEstudianteService service;

    // Atributo privado: vista para mostrar menús e interactuar con usuario
    private EstudianteView view;

    /**
     * Constructor
     * Recibe el servicio inyectado y crea una instancia de la vista
     *
     * @param service - Servicio de estudiantes inyectado
     */
    public EstudianteController(IEstudianteService service) {
        this.service = service;
        this.view = new EstudianteView();
    }

    /**
     * Método principal que inicia el módulo de Estudiantes
     * Muestra un menú interactivo con opciones CRUD
     * El usuario puede:
     * 1. Agregar un nuevo estudiante
     * 2. Actualizar un estudiante existente
     * 3. Eliminar un estudiante
     * 4. Consultar un estudiante por ID
     * 5. Listar todos los estudiantes
     * 6. Volver al menú principal
     */
    public void iniciar() {
        // Bandera para controlar si se debe mantener el menú activo
        while (true) {
            // Mostrar el menú de opciones
            view.mostrarMenu();
            // Obtener la opción seleccionada por el usuario
            int opcion = view.obtenerOpcion();

            // Procesar la opción seleccionada
            switch (opcion) {
                case 1:
                    // Opción 1: Agregar nuevo estudiante
                    agregar();
                    break;
                case 2:
                    // Opción 2: Actualizar estudiante existente
                    actualizar();
                    break;
                case 3:
                    // Opción 3: Eliminar estudiante
                    eliminar();
                    break;
                case 4:
                    // Opción 4: Consultar estudiante por ID
                    consultar();
                    break;
                case 5:
                    // Opción 5: Listar todos los estudiantes
                    listarTodos();
                    break;
                case 6:
                    // Opción 6: Volver al menú principal
                    return;  // Salir del método (volver a Main)
                default:
                    // Opción inválida
                    view.mostrarError("Opción inválida");
            }
        }
    }

    /**
     * Método privado para agregar un nuevo estudiante
     *
     * Flujo:
     * 1. Solicitar datos al usuario a través de la vista
     * 2. Crear objeto Estudiante con los datos
     * 3. Delegar al servicio para guardar (que a su vez valida)
     */
    private void agregar() {
        // Solicitar datos del estudiante al usuario
        String nombre = view.obtenerNombre();
        String identificacion = view.obtenerIdentificacion();
        String email = view.obtenerEmail();
        String fechaNacimiento = view.obtenerFechaNacimiento();
        String estado = view.obtenerEstado();

        // Crear objeto Estudiante con los datos ingresados
        Estudiante estudiante = new Estudiante(nombre, identificacion, email, fechaNacimiento, estado);

        // Delegar al servicio para guardar (el servicio validará)
        service.agregar(estudiante);
    }

    /**
     * Método privado para actualizar un estudiante existente
     *
     * Flujo:
     * 1. Solicitar el ID del estudiante a actualizar
     * 2. Obtener el estudiante del servicio
     * 3. Solicitar nuevos datos al usuario
     * 4. Actualizar el objeto con los nuevos datos
     * 5. Delegar al servicio para actualizar
     */
    private void actualizar() {
        // Solicitar el ID del estudiante a actualizar
        int id = view.obtenerIdEstudiante();

        // Obtener el estudiante actual desde el servicio
        Estudiante estudiante = service.obtenerPorId(id);

        // Verificar si el estudiante existe
        if (estudiante == null) {
            // Si no existe, mostrar error y salir
            view.mostrarError("Estudiante no encontrado");
            return;
        }

        // Solicitar los nuevos datos al usuario
        String nombre = view.obtenerNombre();
        String identificacion = view.obtenerIdentificacion();
        String email = view.obtenerEmail();
        String fechaNacimiento = view.obtenerFechaNacimiento();
        String estado = view.obtenerEstado();

        // Actualizar los valores del objeto estudiante
        estudiante.setNombre(nombre);
        estudiante.setIdentificacion(identificacion);
        estudiante.setEmail(email);
        estudiante.setFechaNacimiento(fechaNacimiento);
        estudiante.setEstado(estado);

        // Delegar al servicio para actualizar en BD
        service.actualizar(estudiante);
    }

    /**
     * Método privado para eliminar un estudiante
     *
     * Flujo:
     * 1. Solicitar el ID del estudiante a eliminar
     * 2. Delegar al servicio para eliminar
     */
    private void eliminar() {
        // Solicitar el ID del estudiante a eliminar
        int id = view.obtenerIdEstudiante();

        // Delegar al servicio para eliminar de la BD
        service.eliminar(id);
    }

    /**
     * Método privado para consultar un estudiante específico
     *
     * Flujo:
     * 1. Solicitar el ID del estudiante a buscar
     * 2. Obtener el estudiante del servicio
     * 3. Mostrar los datos si existe, o mensaje de error si no
     */
    private void consultar() {
        // Solicitar el ID del estudiante a buscar
        int id = view.obtenerIdEstudiante();

        // Obtener el estudiante del servicio
        Estudiante estudiante = service.obtenerPorId(id);

        // Verificar si el estudiante existe
        if (estudiante != null) {
            // Si existe, mostrar sus datos
            view.mostrarMensaje(estudiante.toString());
        } else {
            // Si no existe, mostrar error
            view.mostrarError("Estudiante no encontrado");
        }
    }

    /**
     * Método privado para listar todos los estudiantes
     *
     * Flujo:
     * 1. Obtener lista de todos los estudiantes del servicio
     * 2. Si hay estudiantes, mostrar cada uno
     * 3. Si no hay, mostrar mensaje informativo
     */
    private void listarTodos() {
        // Obtener lista de todos los estudiantes del servicio
        List<Estudiante> estudiantes = service.obtenerTodos();

        // Verificar si hay estudiantes registrados
        if (estudiantes.isEmpty()) {
            // Si no hay, mostrar mensaje
            view.mostrarMensaje("No hay estudiantes registrados");
        } else {
            // Si hay, mostrar encabezado y lista
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║      LISTA DE ESTUDIANTES          ║");
            System.out.println("╚════════════════════════════════════╝");
            // Iterar y mostrar cada estudiante
            for (Estudiante e : estudiantes) {
                System.out.println(e);
            }
        }
    }
}

