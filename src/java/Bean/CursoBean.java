package Bean;

import DAO.CursoDAO;
import DAO.CursoDAOImplement;
import Model.Curso;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CursoBean implements Serializable {
    private Curso curso;
    private List<Curso> cursos;

    public CursoBean() {
        curso = new Curso();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getCursos() {
        CursoDAO dao = new CursoDAOImplement();
        cursos = dao.mostrarCursos();
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar() {
        CursoDAO dao = new CursoDAOImplement();
        dao.insertarCurso(curso);
        curso = new Curso();
        addMessage("Curso Agregado");
    }
    
    public void eliminar() {
        CursoDAO dao = new CursoDAOImplement();
        dao.eliminarCurso(curso);
        curso = new Curso();
        addMessage("Curso Eliminado");
    }
    
    public void modificar() {
        CursoDAO dao = new CursoDAOImplement();
        dao.modificarCurso(curso);
        curso = new Curso();
        addMessage("Curso Modificado");
    }
}