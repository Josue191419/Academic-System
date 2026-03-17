package org.example.repository;

import org.example.misc.Conexion;
import org.example.model.Grupo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase GrupoRepositoryMySQL
 * Implementa la interfaz IGrupoRepository para persistencia en BD MySQL.
 *
 * Similar a EstudianteRepositoryMySQL, pero para la entidad Grupo.
 * Realiza operaciones CRUD en la tabla `grupo` de la BD.
 *
 * Tabla esperada: `u484426513_proc126`.`grupo`
 * Columnas: id, nombre, descripcion, estado
 */
public class GrupoRepositoryMySQL implements IGrupoRepository {

    /**
     * Agrega un nuevo grupo a la BD MySQL
     * El ID se genera automáticamente en la BD (AUTO_INCREMENT)
     *
     * @param grupo - Objeto Grupo con los datos a insertar
     */
    @Override
    public void agregar(Grupo grupo) {
        // Sentencia SQL INSERT para agregar un nuevo grupo
        String sql = "INSERT INTO `u484426513_proc126`.`grupo` (nombre, descripcion, estado) VALUES (?, ?, ?)";

        try (Connection conexion = Conexion.getConnection();  // Obtener conexión
             PreparedStatement ps = conexion.prepareStatement(sql)) {  // Preparar sentencia

            // Asignar valores a los parámetros
            ps.setString(1, grupo.getNombre());         // nombre
            ps.setString(2, grupo.getDescripcion());    // descripcion
            ps.setString(3, grupo.getEstado());         // estado

            // Ejecutar la inserción
            ps.executeUpdate();
            System.out.println("✓ Grupo agregado exitosamente");
        } catch (SQLException e) {
            System.out.println("✗ Error al agregar grupo: " + e.getMessage());
        }
    }

    /**
     * Actualiza los datos de un grupo existente en la BD
     *
     * @param grupo - Objeto Grupo con datos actualizados
     */
    @Override
    public void actualizar(Grupo grupo) {
        // Sentencia SQL UPDATE para actualizar un grupo existente
        String sql = "UPDATE `u484426513_proc126`.`grupo` SET nombre=?, descripcion=?, estado=? WHERE id=?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Asignar valores a los parámetros
            ps.setString(1, grupo.getNombre());
            ps.setString(2, grupo.getDescripcion());
            ps.setString(3, grupo.getEstado());
            ps.setInt(4, grupo.getId());  // ID para la cláusula WHERE

            // Ejecutar la actualización
            ps.executeUpdate();
            System.out.println("✓ Grupo actualizado exitosamente");
        } catch (SQLException e) {
            System.out.println("✗ Error al actualizar grupo: " + e.getMessage());
        }
    }

    /**
     * Elimina un grupo de la BD usando su ID
     *
     * @param id - Identificador único del grupo a eliminar
     */
    @Override
    public void eliminar(int id) {
        // Sentencia SQL DELETE para eliminar un grupo
        String sql = "DELETE FROM `u484426513_proc126`.`grupo` WHERE id=?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Asignar el valor del ID
            ps.setInt(1, id);

            // Ejecutar la eliminación
            ps.executeUpdate();
            System.out.println("✓ Grupo eliminado exitosamente");
        } catch (SQLException e) {
            System.out.println("✗ Error al eliminar grupo: " + e.getMessage());
        }
    }

    /**
     * Obtiene un grupo específico de la BD usando su ID
     *
     * @param id - Identificador único del grupo a buscar
     * @return Grupo - Objeto encontrado, o null si no existe
     */
    @Override
    public Grupo obtenerPorId(int id) {
        // Sentencia SQL SELECT para obtener un grupo por ID
        String sql = "SELECT * FROM `u484426513_proc126`.`grupo` WHERE id=?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Asignar el valor del ID
            ps.setInt(1, id);

            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();

            // Si se encontró un registro
            if (rs.next()) {
                // Crear y devolver el objeto Grupo con los datos
                return new Grupo(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("estado")
                );
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al obtener grupo: " + e.getMessage());
        }
        return null;  // Devolver null si no se encontró
    }

    /**
     * Obtiene la lista de todos los grupos registrados en la BD
     *
     * @return List<Grupo> - Lista con todos los grupos
     */
    @Override
    public List<Grupo> obtenerTodos() {
        // Crear una lista para almacenar los grupos
        List<Grupo> grupos = new ArrayList<>();
        // Sentencia SQL SELECT para obtener todos los grupos
        String sql = "SELECT * FROM `u484426513_proc126`.`grupo`";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Ejecutar la consulta
            ResultSet rs = ps.executeQuery();

            // Iterar sobre todos los registros encontrados
            while (rs.next()) {
                // Crear un objeto Grupo con cada registro y agregarlo a la lista
                grupos.add(new Grupo(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("estado")
                ));
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al obtener grupos: " + e.getMessage());
        }
        return grupos;  // Devolver lista (vacía si no hay registros)
    }
}

