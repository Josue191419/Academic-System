package org.example.controller;

import org.example.model.Profesor;
import org.example.service.IProfesorService;
import org.example.view.ProfesorView;
import java.util.List;

/**
 * Clase ProfesorController
 * Controlador que gestiona las operaciones del módulo de Profesores.
 * Intermediaria entre la vista (ProfesorView) y el servicio (IProfesorService).
 *
 * Responsabilidades:
 * - Mostrar menú de opciones
 * - Capturar entrada del usuario
 * - Orquestar operaciones CRUD
 * - Presentar resultados
 */
public class ProfesorController {

    // Servicio inyectado para operaciones de profesores
    private IProfesorService service;
    // Vista para interfaz de usuario
    private ProfesorView view;

    /**
     * Constructor
     * Recibe el servicio inyectado y crea instancia de la vista
     *
     * @param service - Servicio de profesores inyectado
     */
    public ProfesorController(IProfesorService service) {
        this.service = service;
        this.view = new ProfesorView();
    }

    /**
     * Inicia el módulo de Profesores con menú interactivo
     * Opciones disponibles:
     * 1. Agregar profesor
     * 2. Actualizar profesor
     * 3. Eliminar profesor
     * 4. Consultar profesor
     * 5. Listar todos
     * 6. Volver al menú principal
     */
    public void iniciar() {
        // Bucle infinito hasta que el usuario elija salir
        while (true) {
            // Mostrar menú de opciones
            view.mostrarMenu();
            // Capturar opción del usuario
            int opcion = view.obtenerOpcion();

            // Procesar la opción seleccionada
            switch (opcion) {
                case 1:
                    agregar();  // Opción 1: agregar nuevo profesor
                    break;
                case 2:
                    actualizar();  // Opción 2: actualizar profesor
                    break;
                case 3:
                    eliminar();  // Opción 3: eliminar profesor
                    break;
                case 4:
                    consultar();  // Opción 4: consultar profesor
                    break;
                case 5:
                    listarTodos();  // Opción 5: listar todos
                    break;
                case 6:
                    return;  // Opción 6: volver al menú principal
                default:
                    view.mostrarError("Opción inválida");  // Opción no válida
            }
        }
    }

    /**
     * Agrega un nuevo profesor
     * Solicita datos al usuario y delega al servicio
     */
    private void agregar() {
        // Solicitar datos del profesor
        String nombre = view.obtenerNombre();
        String identificacion = view.obtenerIdentificacion();
        String email = view.obtenerEmail();
        String departamento = view.obtenerDepartamento();
        String estado = view.obtenerEstado();

        // Crear objeto Profesor con los datos
        Profesor profesor = new Profesor(nombre, identificacion, email, departamento, estado);
        // Delegar al servicio para guardar (validará los datos)
        service.agregar(profesor);
    }

    /**
     * Actualiza un profesor existente
     * Busca el profesor, solicita nuevos datos y actualiza
     */
    private void actualizar() {
        // Solicitar ID del profesor a actualizar
        int id = view.obtenerIdProfesor();
        // Obtener el profesor actual
        Profesor profesor = service.obtenerPorId(id);

        // Verificar si existe
        if (profesor == null) {
            view.mostrarError("Profesor no encontrado");
            return;
        }

        // Solicitar nuevos datos
        String nombre = view.obtenerNombre();
        String identificacion = view.obtenerIdentificacion();
        String email = view.obtenerEmail();
        String departamento = view.obtenerDepartamento();
        String estado = view.obtenerEstado();

        // Actualizar los valores del objeto
        profesor.setNombre(nombre);
        profesor.setIdentificacion(identificacion);
        profesor.setEmail(email);
        profesor.setDepartamento(departamento);
        profesor.setEstado(estado);

        // Delegar al servicio para actualizar
        service.actualizar(profesor);
    }

    /**
     * Elimina un profesor
     * Solicita ID y delega al servicio
     */
    private void eliminar() {
        // Solicitar ID del profesor a eliminar
        int id = view.obtenerIdProfesor();
        // Delegar al servicio para eliminar
        service.eliminar(id);
    }

    /**
     * Consulta un profesor específico
     * Solicita ID, busca y muestra los datos
     */
    private void consultar() {
        // Solicitar ID del profesor a consultar
        int id = view.obtenerIdProfesor();
        // Obtener el profesor del servicio
        Profesor profesor = service.obtenerPorId(id);

        // Mostrar resultado
        if (profesor != null) {
            view.mostrarMensaje(profesor.toString());
        } else {
            view.mostrarError("Profesor no encontrado");
        }
    }

    /**
     * Lista todos los profesores registrados
     * Obtiene lista completa y la muestra formateada
     */
    private void listarTodos() {
        // Obtener lista de todos los profesores
        List<Profesor> profesores = service.obtenerTodos();

        // Verificar si hay profesores
        if (profesores.isEmpty()) {
            view.mostrarMensaje("No hay profesores registrados");
        } else {
            // Mostrar encabezado
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║      LISTA DE PROFESORES           ║");
            System.out.println("╚════════════════════════════════════╝");
            // Mostrar cada profesor
            for (Profesor p : profesores) {
                System.out.println(p);
            }
        }
    }
}

