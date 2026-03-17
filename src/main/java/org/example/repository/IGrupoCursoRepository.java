package org.example.repository;

import org.example.model.GrupoCurso;
import java.util.List;

// Interfaz IGrupoCursoRepository
// Define el contrato para la persistencia de datos de GrupoCurso
public interface IGrupoCursoRepository {
    // Agregar una nueva relación grupo-curso
    void agregar(GrupoCurso grupoCurso);
    // Actualizar una relación existente
    void actualizar(GrupoCurso grupoCurso);
    // Eliminar una relación por su ID
    void eliminar(int id);
    // Obtener una relación específica por su ID
    GrupoCurso obtenerPorId(int id);
    // Obtener la lista de todas las relaciones
    List<GrupoCurso> obtenerTodos();
}
