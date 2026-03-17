package org.example.misc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase Conexion
 * Esta clase es responsable de gestionar la conexión con la base de datos MySQL.
 * Implementa el patrón Singleton para proporcionar una forma centralizada y consistente
 * de obtener conexiones a la BD.
 *
 * Nota: Esta clase contiene las credenciales de acceso a la BD MySQL en la nube.
 * En producción, estas credenciales deberían ser manejadas de forma segura
 * (ej: variables de entorno, archivos de configuración encriptados).
 */
public class Conexion {

    // URL de conexión a la BD MySQL en la nube
    // Formato: jdbc:mysql://HOST:PUERTO/NOMBRE_BASE_DATOS?opciones
    private static final String URL = "jdbc:mysql://195.35.59.3:3306/u484426513_proc126?useSSL=true&serverTimezone=UTC";

    // Usuario de acceso a la BD MySQL
    private static final String USUARIO = "u484426513_proc126";

    // Contraseña del usuario para acceder a la BD MySQL
    private static final String PASSWORD = "sP=!v8wk$2";

    /**
     * Método getConnection()
     * Este método estático proporciona una nueva conexión a la BD MySQL.
     * Se debe llamar cada vez que se necesite una conexión para realizar operaciones.
     *
     * Características:
     * - Intenta establecer la conexión usando las credenciales definidas
     * - Si la conexión es exitosa, devuelve el objeto Connection
     * - Si falla, imprime un mensaje de error y devuelve null
     * - Es responsabilidad del cliente cerrar la conexión después de usarla
     *
     * @return Connection - Objeto Connection si es exitoso, null si hay error
     */
    public static Connection getConnection(){
        try{
            // Intentar obtener una conexión con la BD usando DriverManager
            // DriverManager.getConnection(url, usuario, contraseña)
            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            // Si la conexión es exitosa, mostrar un mensaje confirmatorio
            System.out.println("Conexion establecida!");
            // Devolver la conexión al cliente
            return conexion;
        }catch(SQLException e){
            // Si ocurre un error SQLException, capturarlo e informar al usuario
            System.out.println("Error al conectar conexion: " + e.getMessage());
            // Imprimir el stack trace completo para debugging
            e.printStackTrace();
            // Devolver null indicando que no se pudo conectar
            return null;
        }
    }

}
