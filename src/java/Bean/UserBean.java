package Bean;

import DAO.UserDAO;
import DAO.UserDAOImplement;
import Model.User;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UserBean {
    private User user;
    private boolean loggedIn;
    private String inputUsuario;  
    private String inputContrasena;

    private String nuevoUsuario;
    private String nuevaContrasena;
    private String confirmarContrasena;

    public UserBean() {
        user = new User();
    }

    public String login() {
        UserDAO dao = new UserDAOImplement();
        User usuarioEncontrado = dao.verificarCredenciales(inputUsuario, inputContrasena);
        
        if(usuarioEncontrado != null) {
            this.user = usuarioEncontrado;
            loggedIn = true;
            addMessage("Bienvenido " + user.getUsuario());
            return "Menu.xhtml?faces-redirect=true";
        } else {
            addErrorMessage("Usuario o contraseña incorrectos");
            return null;
        }
    }
    
    /**
     * Método para cerrar sesión
     */
    public String logout() {
        loggedIn = false;
        this.user = new User();
        this.inputUsuario = null;
        this.inputContrasena = null;
        return "/login.xhtml?faces-redirect=true";
    }

    public void insertar() {
        if (!nuevaContrasena.equals(confirmarContrasena)) {
            addErrorMessage("Las contraseñas no coinciden");
            return;
        }
        
        UserDAO dao = new UserDAOImplement();
        user.setUsuario(nuevoUsuario);
        user.setContrasena(nuevaContrasena); 
        dao.insertarUser(user);
        
        addMessage("Usuario registrado exitosamente");
        resetFormularioRegistro();
    }
    public void inserta() {
        UserDAO dao = new UserDAOImplement();
        dao.insertarUser(user);
        addMessage("Usuario registrado");
    }
    public void modificar() {
        UserDAO dao = new UserDAOImplement();
        dao.modificarUser(user);
        addMessage("Usuario actualizado exitosamente");
    }
    
    public void eliminar() {
        UserDAO dao = new UserDAOImplement();
        dao.eliminarUser(user);
        addMessage("Usuario eliminado exitosamente");
        this.user = new User();
    }
    
    /**
     * Métodos auxiliares
     */
    private void resetFormularioRegistro() {
        this.nuevoUsuario = null;
        this.nuevaContrasena = null;
        this.confirmarContrasena = null;
    }
    
    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    private void addErrorMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Getters y Setters
     */
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getInputUsuario() {
        return inputUsuario;
    }

    public void setInputUsuario(String inputUsuario) {
        this.inputUsuario = inputUsuario;
    }

    public String getInputContrasena() {
        return inputContrasena;
    }

    public void setInputContrasena(String inputContrasena) {
        this.inputContrasena = inputContrasena;
    }

    public String getNuevoUsuario() {
        return nuevoUsuario;
    }

    public void setNuevoUsuario(String nuevoUsuario) {
        this.nuevoUsuario = nuevoUsuario;
    }

    public String getNuevaContrasena() {
        return nuevaContrasena;
    }

    public void setNuevaContrasena(String nuevaContrasena) {
        this.nuevaContrasena = nuevaContrasena;
    }

    public String getConfirmarContrasena() {
        return confirmarContrasena;
    }

    public void setConfirmarContrasena(String confirmarContrasena) {
        this.confirmarContrasena = confirmarContrasena;
    }
}