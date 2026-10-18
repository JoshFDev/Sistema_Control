/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
import java.util.List;

/**
 *
 * @author sergi
 */
public interface UserDAO {
    public void insertarUser(User user);
    public void modificarUser(User user);
    public void eliminarUser(User user);
    public List<User> mostrarUser();
    public User buscarPorUsuario(String usuario);    
    public User verificarCredenciales(String usuario, String contrasena);
}
