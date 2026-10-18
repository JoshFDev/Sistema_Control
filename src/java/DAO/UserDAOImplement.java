/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.User;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author sergi
 */
public class UserDAOImplement implements UserDAO{
    @Override
    public User buscarPorUsuario(String usuario) {
        Session session = null;
        User user = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM User WHERE usuario = :usuario");
            query.setParameter("usuario", usuario);
            user = (User) query.uniqueResult();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }    
    @Override
    public void insertarUser(User user) {
        Session session = null;
        try {
            session =NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
                        
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally{
            if (session != null) {
             session.close();
            }
        }
    }

    @Override
    public void modificarUser(User user) {
        Session session = null;
        try {
            session =NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
                        
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally{
            if (session != null) {
             session.close();
            }
        }
    }

    @Override
    public void eliminarUser(User user) {
        Session session = null;
        try {
            session =NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
                        
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally{
            if (session != null) {
             session.close();
            }
        }
    }

    @Override
    public List<User> mostrarUser() {
        Session session = null;
        List<User> lista =null;
                try {
            session =NewHibernateUtil.getSessionFactory().openSession();
                    Query query = session.createQuery("from User");
                    lista = (List<User>) query.list();                      
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            } finally{
            if (session != null) {
             session.close();
            }
        }
        return lista;
    }
    @Override
        public User verificarCredenciales(String usuario, String contrasena) {
            Session session = null;
            User user = null;
            try {
                session = NewHibernateUtil.getSessionFactory().openSession();

                // Consulta HQL para verificar credenciales
                Query query = session.createQuery("FROM User WHERE usuario = :usuario AND contrasena = :contrasena");
                query.setParameter("usuario", usuario);
                query.setParameter("contrasena", contrasena);

                user = (User) query.uniqueResult();

            } catch (HibernateException e) {
                System.out.println(e.getMessage());
            } finally {
                if (session != null) {
                    session.close();
                }
            }
            return user;
        }

    
}
