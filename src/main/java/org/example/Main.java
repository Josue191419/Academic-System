package org.example;

import org.example.controller.*;
import org.example.repository.*;
import org.example.repository.EstudianteRepositoryMySQL;
import org.example.repository.EstudianteRepositoryMemoria;
import org.example.service.*;
import org.example.view.SistemaView;
import org.example.misc.Conexion;

import java.sql.Connection;
import java.util.Scanner;

/**
 * Clase Principal (Main)
 * Esta es la clase de entrada del programa. Se encarga de:
 * 1. Inicializar la interfaz gráfica (SistemaView)
 * 2. Verificar la conexión con la base de datos MySQL
 * 3. Instanciar los repositorios (pueden ser MySQL o en memoria)
 * 4. Instanciar los servicios con sus respectivos repositorios
 * 5. Instanciar los controladores con sus servicios
 * 6. Manejar el menú principal y dirigir al usuario a los módulos correspondientes
 */
public class Main {
    public static void main(String[] args) {
        // Crear la vista del sistema (interfaz de usuario)
        SistemaView sistemaView = new SistemaView();
        // Crear un scanner para leer entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Mostrar mensaje de bienvenida al usuario
        sistemaView.mostrarBienvenida();

        // Variable para seleccionar si usar MySQL o memoria (TRUE = MySQL, FALSE = Memoria)
        // Cambiar a false si deseas usar almacenamiento en memoria en lugar de la base de datos
        boolean useMySQL = true;

        // Verificar la conexión inicial con la base de datos
        if (useMySQL) {
            // Intentar obtener una conexión de prueba
            Connection testConn = Conexion.getConnection();
            if (testConn == null) {
                // Si la conexión falla, mostrar un mensaje de error
                System.out.println("✗ No se pudo establecer conexión con la base de datos. Revisa URL/usuario/password o la red.");
            } else {
                // Si la conexión es exitosa, cerrarla (fue solo para probar)
                try { testConn.close(); } catch (Exception ignored) {}
            }
        }

        // Declarar las interfaces de repositorio (se usarán para inyección de dependencias)
        // Esto permite cambiar fácilmente entre MySQL y memoria sin cambiar todo el código
        IEstudianteRepository estudianteRepository;
        IProfesorRepository profesorRepository;
        IGrupoRepository grupoRepository;
        ICursoRepository cursoRepository;

        // Inicializar los repositorios según el tipo seleccionado (MySQL o Memoria)
        if (useMySQL) {
            // Usar repositorios que se conectan a MySQL
            estudianteRepository = new EstudianteRepositoryMySQL();
            profesorRepository = new ProfesorRepositoryMySQL();
            grupoRepository = new GrupoRepositoryMySQL();
            cursoRepository = new CursoRepositoryMySQL();
        } else {
            // Usar repositorios que almacenan datos en memoria (ArrayList)
            estudianteRepository = new EstudianteRepositoryMemoria();
            profesorRepository = new ProfesorRepositoryMemoria();
            grupoRepository = new GrupoRepositoryMemoria();
            cursoRepository = new CursoRepositoryMemoria();
        }

        // Crear los servicios, inyectando los repositorios correspondientes
        // Los servicios contienen la lógica de negocio y validaciones
        IEstudianteService estudianteService = new EstudianteService(estudianteRepository);
        IProfesorService profesorService = new ProfesorService(profesorRepository);
        IGrupoService grupoService = new GrupoService(grupoRepository);
        ICursoService cursoService = new CursoService(cursoRepository);

        // Crear los controladores, inyectando los servicios correspondientes
        // Los controladores orquestan la interacción entre vistas y servicios
        EstudianteController estudianteController = new EstudianteController(estudianteService);
        ProfesorController profesorController = new ProfesorController(profesorService);
        GrupoController grupoController = new GrupoController(grupoService);
        CursoController cursoController = new CursoController(cursoService);

        // Flag para controlar si el programa debe seguir ejecutándose
        boolean ejecutando = true;
        // Bucle principal del programa
        while (ejecutando) {
            // Mostrar el menú principal
            sistemaView.mostrarMenuPrincipal();
            // Leer la opción del usuario
            int opcion = scanner.nextInt();
            // Consumir el salto de línea después del número
            scanner.nextLine();

            // Procesar la opción seleccionada
            switch (opcion) {
                case 1:
                    // Opción 1: Ir al módulo de Estudiantes
                    estudianteController.iniciar();
                    break;
                case 2:
                    // Opción 2: Ir al módulo de Profesores
                    profesorController.iniciar();
                    break;
                case 3:
                    // Opción 3: Ir al módulo de Grupos
                    grupoController.iniciar();
                    break;
                case 4:
                    // Opción 4: Ir al módulo de Cursos
                    cursoController.iniciar();
                    break;
                case 5:
                    // Opción 5: Salir del programa
                    ejecutando = false; // Salir del bucle principal
                    sistemaView.mostrarDespedida(); // Mostrar mensaje de despedida
                    break;
                default:
                    // Si la opción no es válida, mostrar un mensaje de error
                    sistemaView.mostrarError("Opción inválida");
            }
        }

        // Cerrar el scanner para liberar recursos
        scanner.close();
    }
}
