/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Cadete;
import java.util.List;

/**
 *
 * @author Joshua
 */
public interface CadeteDAO {
    public void insertarCadete(Cadete cadete);
    public void modificarCadete(Cadete cadete);
    public void eliminarCadete(Cadete cadete);
    public List<Cadete> mostrarCadetes();       
}
