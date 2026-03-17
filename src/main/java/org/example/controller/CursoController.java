package org.example.controller;

import org.example.model.Curso;
import org.example.service.ICursoService;
import org.example.view.CursoView;
import java.util.List;

/**
 * Clase CursoController
 * Controlador que gestiona las operaciones del módulo de Cursos.
 * Intermediaria entre la vista (CursoView) y el servicio (ICursoService).
 *
 * Responsabilidades:
 * - Mostrar menú de opciones
 * - Capturar entrada del usuario
 * - Orquestar operaciones CRUD
 * - Presentar resultados
 */
public class CursoController {

    // Servicio inyectado para operaciones de cursos
    private ICursoService service;
    // Vista para interfaz de usuario
    private CursoView view;

    /**
     * Constructor
     * Recibe el servicio inyectado y crea instancia de la vista
     *
     * @param service - Servicio de cursos inyectado
     */
    public CursoController(ICursoService service) {
        this.service = service;
        this.view = new CursoView();
    }

    /**
     * Inicia el módulo de Cursos con menú interactivo
     * Opciones disponibles:
     * 1. Agregar curso
     * 2. Actualizar curso
     * 3. Eliminar curso
     * 4. Consultar curso
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
                    agregar();  // Opción 1: agregar nuevo curso
                    break;
                case 2:
                    actualizar();  // Opción 2: actualizar curso
                    break;
                case 3:
                    eliminar();  // Opción 3: eliminar curso
                    break;
                case 4:
                    consultar();  // Opción 4: consultar curso
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
     * Agrega un nuevo curso
     * Solicita datos al usuario y delega al servicio
     */
    private void agregar() {
        // Solicitar datos del curso
        String nombre = view.obtenerNombre();
        String descripcion = view.obtenerDescripcion();
        String estado = view.obtenerEstado();

        // Crear objeto Curso con los datos
        Curso curso = new Curso(nombre, descripcion, estado);
        // Delegar al servicio para guardar (validará los datos)
        service.agregar(curso);
    }

    /**
     * Actualiza un curso existente
     * Busca el curso, solicita nuevos datos y actualiza
     */
    private void actualizar() {
        // Solicitar ID del curso a actualizar
        int id = view.obtenerIdCurso();
        // Obtener el curso actual
        Curso curso = service.obtenerPorId(id);

        // Verificar si existe
        if (curso == null) {
            view.mostrarError("Curso no encontrado");
            return;
        }

        // Solicitar nuevos datos
        String nombre = view.obtenerNombre();
        String descripcion = view.obtenerDescripcion();
        String estado = view.obtenerEstado();

        // Actualizar los valores del objeto
        curso.setNombre(nombre);
        curso.setDescripcion(descripcion);
        curso.setEstado(estado);

        // Delegar al servicio para actualizar
        service.actualizar(curso);
    }

    /**
     * Elimina un curso
     * Solicita ID y delega al servicio
     */
    private void eliminar() {
        // Solicitar ID del curso a eliminar
        int id = view.obtenerIdCurso();
        // Delegar al servicio para eliminar
        service.eliminar(id);
    }

    /**
     * Consulta un curso específico
     * Solicita ID, busca y muestra los datos
     */
    private void consultar() {
        // Solicitar ID del curso a consultar
        int id = view.obtenerIdCurso();
        // Obtener el curso del servicio
        Curso curso = service.obtenerPorId(id);

        // Mostrar resultado
        if (curso != null) {
            view.mostrarMensaje(curso.toString());
        } else {
            view.mostrarError("Curso no encontrado");
        }
    }

    /**
     * Lista todos los cursos registrados
     * Obtiene lista completa y la muestra formateada
     */
    private void listarTodos() {
        // Obtener lista de todos los cursos
        List<Curso> cursos = service.obtenerTodos();

        // Verificar si hay cursos
        if (cursos.isEmpty()) {
            view.mostrarMensaje("No hay cursos registrados");
        } else {
            // Mostrar encabezado
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║      LISTA DE CURSOS               ║");
            System.out.println("╚════════════════════════════════════╝");
            // Mostrar cada curso
            for (Curso c : cursos) {
                System.out.println(c);
            }
        }
    }
}

