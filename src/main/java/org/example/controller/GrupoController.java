package org.example.controller;

import org.example.model.Grupo;
import org.example.service.IGrupoService;
import org.example.view.GrupoView;
import java.util.List;

/**
 * Clase GrupoController
 * Controlador que gestiona las operaciones del módulo de Grupos.
 * Intermediaria entre la vista (GrupoView) y el servicio (IGrupoService).
 *
 * Responsabilidades:
 * - Mostrar menú de opciones
 * - Capturar entrada del usuario
 * - Orquestar operaciones CRUD
 * - Presentar resultados
 */
public class GrupoController {

    // Servicio inyectado para operaciones de grupos
    private IGrupoService service;
    // Vista para interfaz de usuario
    private GrupoView view;

    /**
     * Constructor
     * Recibe el servicio inyectado y crea instancia de la vista
     *
     * @param service - Servicio de grupos inyectado
     */
    public GrupoController(IGrupoService service) {
        this.service = service;
        this.view = new GrupoView();
    }

    /**
     * Inicia el módulo de Grupos con menú interactivo
     * Opciones disponibles:
     * 1. Agregar grupo
     * 2. Actualizar grupo
     * 3. Eliminar grupo
     * 4. Consultar grupo
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
                    agregar();  // Opción 1: agregar nuevo grupo
                    break;
                case 2:
                    actualizar();  // Opción 2: actualizar grupo
                    break;
                case 3:
                    eliminar();  // Opción 3: eliminar grupo
                    break;
                case 4:
                    consultar();  // Opción 4: consultar grupo
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
     * Agrega un nuevo grupo
     * Solicita datos al usuario y delega al servicio
     */
    private void agregar() {
        // Solicitar datos del grupo
        String nombre = view.obtenerNombre();
        String descripcion = view.obtenerDescripcion();
        String estado = view.obtenerEstado();

        // Crear objeto Grupo con los datos
        Grupo grupo = new Grupo(nombre, descripcion, estado);
        // Delegar al servicio para guardar (validará los datos)
        service.agregar(grupo);
    }

    /**
     * Actualiza un grupo existente
     * Busca el grupo, solicita nuevos datos y actualiza
     */
    private void actualizar() {
        // Solicitar ID del grupo a actualizar
        int id = view.obtenerIdGrupo();
        // Obtener el grupo actual
        Grupo grupo = service.obtenerPorId(id);

        // Verificar si existe
        if (grupo == null) {
            view.mostrarError("Grupo no encontrado");
            return;
        }

        // Solicitar nuevos datos
        String nombre = view.obtenerNombre();
        String descripcion = view.obtenerDescripcion();
        String estado = view.obtenerEstado();

        // Actualizar los valores del objeto
        grupo.setNombre(nombre);
        grupo.setDescripcion(descripcion);
        grupo.setEstado(estado);

        // Delegar al servicio para actualizar
        service.actualizar(grupo);
    }

    /**
     * Elimina un grupo
     * Solicita ID y delega al servicio
     */
    private void eliminar() {
        // Solicitar ID del grupo a eliminar
        int id = view.obtenerIdGrupo();
        // Delegar al servicio para eliminar
        service.eliminar(id);
    }

    /**
     * Consulta un grupo específico
     * Solicita ID, busca y muestra los datos
     */
    private void consultar() {
        // Solicitar ID del grupo a consultar
        int id = view.obtenerIdGrupo();
        // Obtener el grupo del servicio
        Grupo grupo = service.obtenerPorId(id);

        // Mostrar resultado
        if (grupo != null) {
            view.mostrarMensaje(grupo.toString());
        } else {
            view.mostrarError("Grupo no encontrado");
        }
    }

    /**
     * Lista todos los grupos registrados
     * Obtiene lista completa y la muestra formateada
     */
    private void listarTodos() {
        // Obtener lista de todos los grupos
        List<Grupo> grupos = service.obtenerTodos();

        // Verificar si hay grupos
        if (grupos.isEmpty()) {
            view.mostrarMensaje("No hay grupos registrados");
        } else {
            // Mostrar encabezado
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║      LISTA DE GRUPOS               ║");
            System.out.println("╚════════════════════════════════════╝");
            // Mostrar cada grupo
            for (Grupo g : grupos) {
                System.out.println(g);
            }
        }
    }
}


