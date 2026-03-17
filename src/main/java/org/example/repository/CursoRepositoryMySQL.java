package org.example.repository;

import org.example.misc.Conexion;
import org.example.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase CursoRepositoryMySQL
 * Implementa la interfaz ICursoRepository para persistencia en BD MySQL.
 *
 * Similar a EstudianteRepositoryMySQL, pero para la entidad Curso.
 * Realiza operaciones CRUD en la tabla `curso` de la BD.
 *
 * Tabla esperada: `u484426513_proc126`.`curso`
 * Columnas: id, nombre, descripcion, estado
 */
public class CursoRepositoryMySQL implements ICursoRepository {

    /**
     * Agrega un nuevo curso a la BD MySQL
     * El ID se genera automáticamente en la BD (AUTO_INCREMENT)
     *
     * @param curso - Objeto Curso con los datos a insertar
     */
    @Override
    public void agregar(Curso curso) {
        // Sentencia SQL INSERT para agregar un nuevo curso
        String sql = "INSERT INTO `u484426513_proc126`.`curso` (`nombre`, `descripcion`, `estado`) VALUES (?, ?, ?)";

        try (Connection conexion = Conexion.getConnection();  // Obtener conexión
             PreparedStatement ps = conexion.prepareStatement(sql)) {  // Preparar sentencia

            // Asignar valores a los parámetros
            ps.setString(1, curso.getNombre());         // nombre
            ps.setString(2, curso.getDescripcion());    // descripcion
            ps.setString(3, curso.getEstado());         // estado

            // Ejecutar la inserción
            ps.executeUpdate();
            System.out.println("✓ Curso agregado exitosamente");
        } catch (SQLException e) {
            System.out.println("✗ Error al agregar curso: " + e.getMessage());
        }
    }

    /**
     * Actualiza los datos de un curso existente en la BD
     *
     * @param curso - Objeto Curso con datos actualizados
     */
    @Override
    public void actualizar(Curso curso) {
        // Sentencia SQL UPDATE para actualizar un curso existente
        String sql = "UPDATE `u484426513_proc126`.`curso` SET nombre=?, descripcion=?, estado=? WHERE id=?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Asignar valores a los parámetros
            ps.setString(1, curso.getNombre());
            ps.setString(2, curso.getDescripcion());
            ps.setString(3, curso.getEstado());
            ps.setInt(4, curso.getId());  // ID para la cláusula WHERE

            // Ejecutar la actualización
            ps.executeUpdate();
            System.out.println("✓ Curso actualizado exitosamente");
        } catch (SQLException e) {
            System.out.println("✗ Error al actualizar curso: " + e.getMessage());
        }
    }

    /**
     * Elimina un curso de la BD usando su ID
     *
     * @param id - Identificador único del curso a eliminar
     */
    @Override
    public void eliminar(int id) {
        // Sentencia SQL DELETE para eliminar un curso
        String sql = "DELETE FROM `u484426513_proc126`.`curso` WHERE id=?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Asignar el valor del ID
            ps.setInt(1, id);

            // Ejecutar la eliminación
            ps.executeUpdate();
            System.out.println("✓ Curso eliminado exitosamente");
        } catch (SQLException e) {
            System.out.println("✗ Error al eliminar curso: " + e.getMessage());
        }
    }

    /**
     * Obtiene un curso específico de la BD usando su ID
     *
     * @param id - Identificador único del curso a buscar
     * @return Curso - Objeto encontrado, o null si no existe
     */
    @Override
    public Curso obtenerPorId(int id) {
        // Sentencia SQL SELECT para obtener un curso por ID
        String sql = "SELECT * FROM `u484426513_proc126`.`curso` WHERE id=?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Asignar el valor del ID
            ps.setInt(1, id);

            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();

            // Si se encontró un registro
            if (rs.next()) {
                // Crear y devolver el objeto Curso con los datos
                return new Curso(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener curso: " + e.getMessage());
        }
        return null;  // Devolver null si no se encontró
    }

    /**
     * Obtiene la lista de todos los cursos registrados en la BD
     *
     * @return List<Curso> - Lista con todos los cursos
     */
    @Override
    public List<Curso> obtenerTodos() {
        // Crear una lista para almacenar los cursos
        List<Curso> cursos = new ArrayList<>();
        // Sentencia SQL SELECT para obtener todos los cursos
        String sql = "SELECT * FROM `u484426513_proc126`.`curso`";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();

            // Iterar sobre todos los registros encontrados
            while (rs.next()) {
                // Crear un objeto Curso con cada registro y agregarlo a la lista
                cursos.add(new Curso(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            System.out.println(" Error al obtener cursos: " + e.getMessage());
        }
        return cursos;  // Devolver lista (vacía si no hay registros)
    }
}

