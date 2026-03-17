package org.example.repository;

import org.example.misc.Conexion;
import org.example.model.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase EstudianteRepositoryMySQL
 * Implementa la interfaz IEstudianteRepository para persistencia en BD MySQL.
 *
 * Esta clase es responsable de:
 * - Conectarse a la BD MySQL
 * - Ejecutar operaciones CRUD (Create, Read, Update, Delete)
 * - Mapear objetos Java a registros de BD y viceversa
 * - Manejar excepciones SQL
 *
 * Utiliza:
 * - PreparedStatement para prevenir inyección SQL
 * - Try-with-resources para cerrar automáticamente recursos
 * - Clase Conexion para obtener conexiones a la BD
 *
 * Tabla esperada en MySQL: `u484426513_proc126`.`estudiante`
 * Columnas: id, nombre, identificacion, email, fecha_nacimiento, estado
 */
public class EstudianteRepositoryMySQL implements IEstudianteRepository {

    /**
     * Agrega un nuevo estudiante a la BD MySQL
     *
     * SQL: INSERT INTO estudiante (nombre, identificacion, email, fecha_nacimiento, estado)
     *      VALUES (?, ?, ?, ?, ?)
     *
     * El ID se genera automáticamente en la BD (AUTO_INCREMENT)
     *
     * @param estudiante - Objeto Estudiante con los datos a insertar
     */
    @Override
    public void agregar(Estudiante estudiante) {
        // Sentencia SQL INSERT con parámetros (?) para evitar inyección SQL
        String sql = "INSERT INTO `u484426513_proc126`.`estudiante` (nombre, identificacion, email, fecha_nacimiento, estado) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.getConnection();  // Obtener conexión a la BD
             PreparedStatement ps = conexion.prepareStatement(sql)) {  // Preparar la sentencia

            // Asignar valores a los parámetros
            ps.setString(1, estudiante.getNombre());           // ? 1: nombre
            ps.setString(2, estudiante.getIdentificacion());   // ? 2: identificacion
            ps.setString(3, estudiante.getEmail());            // ? 3: email
            ps.setString(4, estudiante.getFechaNacimiento());  // ? 4: fecha_nacimiento
            ps.setString(5, estudiante.getEstado());           // ? 5: estado

            // Ejecutar la inserción
            ps.executeUpdate();
            System.out.println("✓ Estudiante agregado exitosamente");
        } catch (SQLException e) {
            // Si ocurre error, mostrar mensaje informativo
            System.out.println("✗ Error al agregar estudiante: " + e.getMessage());
        }
    }

    /**
     * Actualiza los datos de un estudiante existente en la BD
     *
     * SQL: UPDATE estudiante SET nombre=?, identificacion=?, email=?,
     *      fecha_nacimiento=?, estado=? WHERE id=?
     *
     * El ID debe existir en la BD, de lo contrario no se actualizará nada
     *
     * @param estudiante - Objeto Estudiante con datos actualizados (debe contener ID)
     */
    @Override
    public void actualizar(Estudiante estudiante) {
        // Sentencia SQL UPDATE con parámetros
        String sql = "UPDATE `u484426513_proc126`.`estudiante` SET nombre=?, identificacion=?, email=?, fecha_nacimiento=?, estado=? WHERE id=?";

        try (Connection conexion = Conexion.getConnection();  // Obtener conexión
             PreparedStatement ps = conexion.prepareStatement(sql)) {  // Preparar sentencia

            // Asignar valores a los parámetros
            ps.setString(1, estudiante.getNombre());           // ? 1: nombre
            ps.setString(2, estudiante.getIdentificacion());   // ? 2: identificacion
            ps.setString(3, estudiante.getEmail());            // ? 3: email
            ps.setString(4, estudiante.getFechaNacimiento());  // ? 4: fecha_nacimiento
            ps.setString(5, estudiante.getEstado());           // ? 5: estado
            ps.setInt(6, estudiante.getId());                  // ? 6: id (WHERE)

            // Ejecutar la actualización
            ps.executeUpdate();
            System.out.println("✓ Estudiante actualizado exitosamente");
        } catch (SQLException e) {
            // Si ocurre error, mostrar mensaje informativo
            System.out.println("✗ Error al actualizar estudiante: " + e.getMessage());
        }
    }

    /**
     * Elimina un estudiante de la BD usando su ID
     *
     * SQL: DELETE FROM estudiante WHERE id=?
     *
     * @param id - Identificador único del estudiante a eliminar
     */
    @Override
    public void eliminar(int id) {
        // Sentencia SQL DELETE con parámetro
        String sql = "DELETE FROM `u484426513_proc126`.`estudiante` WHERE id=?";

        try (Connection conexion = Conexion.getConnection();  // Obtener conexión
             PreparedStatement ps = conexion.prepareStatement(sql)) {  // Preparar sentencia

            // Asignar el valor del ID
            ps.setInt(1, id);  // ? 1: id

            // Ejecutar la eliminación
            ps.executeUpdate();
            System.out.println("✓ Estudiante eliminado exitosamente");
        } catch (SQLException e) {
            // Si ocurre error, mostrar mensaje informativo
            System.out.println("✗ Error al eliminar estudiante: " + e.getMessage());
        }
    }

    /**
     * Obtiene un estudiante específico de la BD usando su ID
     *
     * SQL: SELECT * FROM estudiante WHERE id=?
     *
     * @param id - Identificador único del estudiante a buscar
     * @return Estudiante - Objeto encontrado, o null si no existe
     */
    @Override
    public Estudiante obtenerPorId(int id) {
        // Sentencia SQL SELECT con parámetro
        String sql = "SELECT * FROM `u484426513_proc126`.`estudiante` WHERE id=?";

        try (Connection conexion = Conexion.getConnection();  // Obtener conexión
             PreparedStatement ps = conexion.prepareStatement(sql)) {  // Preparar sentencia

            // Asignar el valor del ID
            ps.setInt(1, id);  // ? 1: id

            // Ejecutar la consulta y obtener resultados
            ResultSet rs = ps.executeQuery();

            // Si se encontró un registro
            if (rs.next()) {
                // Crear un objeto Estudiante con los datos de la BD
                return new Estudiante(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("identificacion"),
                    rs.getString("email"),
                    rs.getString("fecha_nacimiento"),
                    rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            // Si ocurre error, mostrar mensaje informativo
            System.out.println("✗ Error al obtener estudiante: " + e.getMessage());
        }
        // Devolver null si no se encontró o hubo error
        return null;
    }

    /**
     * Obtiene la lista de todos los estudiantes registrados en la BD
     *
     * SQL: SELECT * FROM estudiante
     *
     * @return List<Estudiante> - Lista con todos los estudiantes, vacía si no hay registros
     */
    @Override
    public List<Estudiante> obtenerTodos() {
        // Crear una lista para almacenar los estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();
        // Sentencia SQL SELECT sin parámetros
        String sql = "SELECT * FROM `u484426513_proc126`.`estudiante`";

        try (Connection conexion = Conexion.getConnection();  // Obtener conexión
             PreparedStatement ps = conexion.prepareStatement(sql)) {  // Preparar sentencia

            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();

            // Iterar sobre todos los registros encontrados
            while (rs.next()) {
                // Crear un objeto Estudiante con cada registro
                estudiantes.add(new Estudiante(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("identificacion"),
                    rs.getString("email"),
                    rs.getString("fecha_nacimiento"),
                    rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            // Si ocurre error, mostrar mensaje informativo
            System.out.println("✗ Error al obtener estudiantes: " + e.getMessage());
        }
        // Devolver la lista (vacía si no se encontraron registros o hubo error)
        return estudiantes;
    }
}

