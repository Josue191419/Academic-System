package org.example.repository;

import org.example.misc.Conexion;
import org.example.model.GrupoCurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Clase GrupoCursoRepositoryMySQL
// Implementa IGrupoCursoRepository para persistencia en BD MySQL
public class GrupoCursoRepositoryMySQL implements IGrupoCursoRepository {

    // Agregar una nueva relación grupo-curso a la BD
    @Override
    public void agregar(GrupoCurso grupoCurso) {
        // SQL para insertar en grupo_curso
        String sql = "INSERT INTO `u484426513_proc126`.`grupo_curso` (grupo_id, curso_id) VALUES (?, ?)";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Asignar valores a los parámetros
            ps.setInt(1, grupoCurso.getGrupoId());
            ps.setInt(2, grupoCurso.getCursoId());

            // Ejecutar la inserción
            ps.executeUpdate();
            System.out.println("✓ Relación grupo-curso agregada exitosamente");
        } catch (SQLException e) {
            System.out.println("✗ Error al agregar relación grupo-curso: " + e.getMessage());
        }
    }

    // Actualizar una relación existente
    @Override
    public void actualizar(GrupoCurso grupoCurso) {
        // SQL para actualizar
        String sql = "UPDATE `u484426513_proc126`.`grupo_curso` SET grupo_id=?, curso_id=? WHERE id=?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Asignar valores
            ps.setInt(1, grupoCurso.getGrupoId());
            ps.setInt(2, grupoCurso.getCursoId());
            ps.setInt(3, grupoCurso.getId());

            // Ejecutar actualización
            ps.executeUpdate();
            System.out.println("✓ Relación grupo-curso actualizada exitosamente");
        } catch (SQLException e) {
            System.out.println("✗ Error al actualizar relación grupo-curso: " + e.getMessage());
        }
    }

    // Eliminar una relación por ID
    @Override
    public void eliminar(int id) {
        // SQL para eliminar
        String sql = "DELETE FROM `u484426513_proc126`.`grupo_curso` WHERE id=?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Asignar ID
            ps.setInt(1, id);

            // Ejecutar eliminación
            ps.executeUpdate();
            System.out.println("✓ Relación grupo-curso eliminada exitosamente");
        } catch (SQLException e) {
            System.out.println("✗ Error al eliminar relación grupo-curso: " + e.getMessage());
        }
    }

    // Obtener una relación por ID
    @Override
    public GrupoCurso obtenerPorId(int id) {
        // SQL para seleccionar por ID
        String sql = "SELECT * FROM `u484426513_proc126`.`grupo_curso` WHERE id=?";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Asignar ID
            ps.setInt(1, id);

            // Ejecutar consulta
            ResultSet rs = ps.executeQuery();

            // Si hay resultado
            if (rs.next()) {
                // Crear objeto GrupoCurso
                return new GrupoCurso(
                    rs.getInt("id"),
                    rs.getInt("grupo_id"),
                    rs.getInt("curso_id")
                );
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al obtener relación grupo-curso: " + e.getMessage());
        }
        return null;
    }

    // Obtener todas las relaciones
    @Override
    public List<GrupoCurso> obtenerTodos() {
        // Lista para almacenar resultados
        List<GrupoCurso> grupoCursos = new ArrayList<>();
        // SQL para seleccionar todos
        String sql = "SELECT * FROM `u484426513_proc126`.`grupo_curso`";

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            // Ejecutar consulta
            ResultSet rs = ps.executeQuery();

            // Iterar sobre resultados
            while (rs.next()) {
                // Crear objeto y agregar a la lista
                grupoCursos.add(new GrupoCurso(
                    rs.getInt("id"),
                    rs.getInt("grupo_id"),
                    rs.getInt("curso_id")
                ));
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al obtener relaciones grupo-curso: " + e.getMessage());
        }
        return grupoCursos;
    }
}
