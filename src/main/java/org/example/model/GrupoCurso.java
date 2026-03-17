package org.example.model;

// Clase GrupoCurso
// Representa la relación entre Grupo y Curso en el sistema académico
public class GrupoCurso {

    // Identificador único de la relación
    private int id;
    // Identificador del grupo
    private int grupoId;
    // Identificador del curso
    private int cursoId;

    // Constructor completo
    public GrupoCurso(int id, int grupoId, int cursoId) {
        this.id = id;
        this.grupoId = grupoId;
        this.cursoId = cursoId;
    }

    // Constructor sin ID (para nuevos registros)
    public GrupoCurso(int grupoId, int cursoId) {
        this.grupoId = grupoId;
        this.cursoId = cursoId;
    }

    // Getter para id
    public int getId() {
        return id;
    }

    // Setter para id
    public void setId(int id) {
        this.id = id;
    }

    // Getter para grupoId
    public int getGrupoId() {
        return grupoId;
    }

    // Setter para grupoId
    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }

    // Getter para cursoId
    public int getCursoId() {
        return cursoId;
    }

    // Setter para cursoId
    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    // Método toString para representación en cadena
    @Override
    public String toString() {
        return "GrupoCurso{" +
                "id=" + id +
                ", grupoId=" + grupoId +
                ", cursoId=" + cursoId +
                '}';
    }
}
