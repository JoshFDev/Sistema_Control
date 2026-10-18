package Bean;

import DAO.CadeteDAO;
import DAO.CadeteDAOImplement;
import Model.Cadete;
import Model.Curso;
import Persistencia.NewHibernateUtil;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cache.ehcache.management.impl.BeanUtils;

@ManagedBean
@ViewScoped
public class CadeteBean {
    private Cadete cadete;
    private List<Cadete> cadetes;
    private boolean listaActualizada = false;
    
    @ManagedProperty(value="#{cursoBean}")
    private CursoBean cursoBean;

    public CadeteBean() {
        cadete = new Cadete();
        cadete.setCurso(new Curso());
    }

    public Cadete getCadete() {
        return cadete;
    }

    public void setCadete(Cadete cadete) {
        this.cadete = cadete;
    }

    public List<Cadete> getCadetes() {
        if (!listaActualizada || cadetes == null) {
            CadeteDAO DAO = new CadeteDAOImplement();
            cadetes = DAO.mostrarCadetes();
            listaActualizada = true;
        }
        return cadetes;
    }

    public void setCadetes(List<Cadete> cadetes) {
        this.cadetes = cadetes;
    }
    
    public CursoBean getCursoBean() {
        return cursoBean;
    }

    public void setCursoBean(CursoBean cursoBean) {
        this.cursoBean = cursoBean;
    }
    
    private void addMessage(String summary, String detail, FacesMessage.Severity severity) {
        FacesMessage message = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar() {
        try {
            CadeteDAO DAO = new CadeteDAOImplement();
            DAO.insertarCadete(cadete);
            resetForm();
            listaActualizada = false;
            addMessage("Éxito", "Cadete agregado correctamente", FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
            addMessage("Error", "No se pudo agregar el cadete: " + e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

public void modificar() {
    try {
        // Validar campos requeridos
        if (cadete.getNombres() == null || cadete.getNombres().trim().isEmpty()) {
            addMessage("Error", "El nombre es obligatorio", FacesMessage.SEVERITY_ERROR);
            return;
        }
        
        if (cadete.getPaterno() == null || cadete.getPaterno().trim().isEmpty()) {
            addMessage("Error", "El apellido paterno es obligatorio", FacesMessage.SEVERITY_ERROR);
            return;
        }
        
        // Validar que tenga ID
        if (cadete.getIdcadete() == null) {
            addMessage("Error", "ID de cadete no válido", FacesMessage.SEVERITY_ERROR);
            return;
        }
        
        // Validar curso
        if (cadete.getCurso() == null || cadete.getCurso().getIdcurso() == null) {
            addMessage("Error", "Debe seleccionar un curso válido", FacesMessage.SEVERITY_ERROR);
            return;
        }
        CadeteDAO dao = new CadeteDAOImplement();
        // Modificar en la base de datos
        dao.modificarCadete(cadete);
        listaActualizada = false;
        
        addMessage("Éxito", "Cadete modificado correctamente", FacesMessage.SEVERITY_INFO);
        
    } catch (Exception e) {
        addMessage("Error", "No se pudo modificar el cadete: " + e.getMessage(), FacesMessage.SEVERITY_ERROR);
        e.printStackTrace();
    }
}    
    
    public void eliminar() {
        try {
            CadeteDAO DAO = new CadeteDAOImplement();
            DAO.eliminarCadete(cadete);
            resetForm();
            listaActualizada = false;
            addMessage("Éxito", "Cadete eliminado correctamente", FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
            addMessage("Error", "No se pudo eliminar el cadete: " + e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
    private void resetForm() {
        cadete = new Cadete();
        cadete.setCurso(new Curso());
    }
    
}