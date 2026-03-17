package org.example.service;

import org.example.model.GrupoCurso;
import java.util.List;

// Interfaz IGrupoCursoService
// Define el contrato para la lógica de negocio de GrupoCurso
public interface IGrupoCursoService {

    // Agregar una nueva relación con validaciones
    void agregar(GrupoCurso grupoCurso);
    // Actualizar una relación existente
    void actualizar(GrupoCurso grupoCurso);
    // Eliminar una relación por ID
    void eliminar(int id);
    // Obtener una relación por ID
    GrupoCurso obtenerPorId(int id);
    // Obtener todas las relaciones
    List<GrupoCurso> obtenerTodos();
}
