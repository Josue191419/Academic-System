package org.example.repository;

import org.example.misc.Conexion;
import org.example.model.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase ProfesorRepositoryMySQL
 * Implementa la interfaz IProfesorRepository para persistencia en BD MySQL.
 *
 * Similar a EstudianteRepositoryMySQL, pero para la entidad Profesor.
 * Realiza operaciones CRUD en la tabla `profesor` de la BD.
 *
 * Tabla esperada: `u484426513_proc126`.`profesor`
 * Columnas: id, nombre, identificacion, email, departamento, estado
 */
public class ProfesorRepositoryMySQL implements IProfesorRepository {

    /**
     * Agrega un nuevo profesor a la BD MySQL
     * El ID se genera automáticamente en la BD (AUTO_INCREMENT)
     *
     * @param profesor - Objeto Profesor con los datos a insertar
     */
    @Override
    public void agregar(Profesor profesor) {
        // Sentencia SQL INSERT para agregar un nuevo profesor
        String sql = "INSERT INTO `u484426513_proc126`.`profesor` (nombre, identificacion, email, departamento, estado) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.getConnection();  // Obtener conexión
             PreparedStatement ps = conexion.prepareStatement(sql)) {  // Preparar sentencia

            // Asignar valores a los parámetros
            ps.setString(1, profesor.getNombre());           // nombre
            ps.setString(2, profesor.getIdentificacion());   // identificacion
            ps.setString(3, profesor.getEmail());            // email
            ps.setString(4, profesor.getDepartamento());     // departamento
            ps.setString(5, profesor.getEstado());           // estado

            // Ejecutar la inserción
            ps.executeUpdate();
            System.out.println("✓ Profesor agregado exitosamente");
        } catch (SQLException e) {
            System.out.println("✗ Error al agregar profesor: " + e.getMessage());
        }
    }

    /**
     * Actualiza los datos de un profesor existente en la BD
     *
     * @param profesor - Objeto Profesor con datos actualizados
     */
    @Override
    public void actualizar(Profesor profesor) {
        // Sentencia SQL UPDATE para actualizar un profesor existente
        String sql = "UPDATE `u484426513_proc126`.`profesor` SET nombre=?, identificacion=?, email=?, departamento=?, estado=? WHERE id=?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Asignar valores a los parámetros
            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getIdentificacion());
            ps.setString(3, profesor.getEmail());
            ps.setString(4, profesor.getDepartamento());
            ps.setString(5, profesor.getEstado());
            ps.setInt(6, profesor.getId());  // ID para la cláusula WHERE

            // Ejecutar la actualización
            ps.executeUpdate();
            System.out.println("✓ Profesor actualizado exitosamente");
        } catch (SQLException e) {
            System.out.println("✗ Error al actualizar profesor: " + e.getMessage());
        }
    }

    /**
     * Elimina un profesor de la BD usando su ID
     *
     * @param id - Identificador único del profesor a eliminar
     */
    @Override
    public void eliminar(int id) {
        // Sentencia SQL DELETE para eliminar un profesor
        String sql = "DELETE FROM `u484426513_proc126`.`profesor` WHERE id=?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Asignar el valor del ID
            ps.setInt(1, id);

            // Ejecutar la eliminación
            ps.executeUpdate();
            System.out.println("✓ Profesor eliminado exitosamente");
        } catch (SQLException e) {
            System.out.println("✗ Error al eliminar profesor: " + e.getMessage());
        }
    }

    /**
     * Obtiene un profesor específico de la BD usando su ID
     *
     * @param id - Identificador único del profesor a buscar
     * @return Profesor - Objeto encontrado, o null si no existe
     */
    @Override
    public Profesor obtenerPorId(int id) {
        // Sentencia SQL SELECT para obtener un profesor por ID
        String sql = "SELECT * FROM `u484426513_proc126`.`profesor` WHERE id=?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Asignar el valor del ID
            ps.setInt(1, id);

            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();

            // Si se encontró un registro
            if (rs.next()) {
                // Crear y devolver el objeto Profesor con los datos
                return new Profesor(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("identificacion"),
                    rs.getString("email"),
                    rs.getString("departamento"),
                    rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al obtener profesor: " + e.getMessage());
        }
        return null;  // Devolver null si no se encontró
    }

    /**
     * Obtiene la lista de todos los profesores registrados en la BD
     *
     * @return List<Profesor> - Lista con todos los profesores
     */
    @Override
    public List<Profesor> obtenerTodos() {
        // Crear una lista para almacenar los profesores
        List<Profesor> profesores = new ArrayList<>();
        // Sentencia SQL SELECT para obtener todos los profesores
        String sql = "SELECT * FROM `u484426513_proc126`.`profesor`";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();

            // Iterar sobre todos los registros encontrados
            while (rs.next()) {
                // Crear un objeto Profesor con cada registro y agregarlo a la lista
                profesores.add(new Profesor(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("identificacion"),
                    rs.getString("email"),
                    rs.getString("departamento"),
                    rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al obtener profesores: " + e.getMessage());
        }
        return profesores;  // Devolver lista (vacía si no hay registros)
    }
}

