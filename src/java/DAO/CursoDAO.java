/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Curso;
import java.util.List;

/**
 *
 * @author Joshua
 */
public interface CursoDAO {
    public void insertarCurso(Curso curso);
    public void modificarCurso(Curso curso);
    public void eliminarCurso(Curso curso);
    public List<Curso> mostrarCursos();  
}
