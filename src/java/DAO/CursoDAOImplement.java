/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Curso;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Joshua
 */
public class CursoDAOImplement implements CursoDAO{

    @Override
    public void insertarCurso(Curso curso) {
        Session session=null;
        try {
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(curso);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
        finally{
            if(session !=null){
                session.close();
            }
        }
    }

    @Override
    public void modificarCurso(Curso curso) {
        Session session=null;
        try {
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(curso);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
        finally{
            if(session !=null){
                session.close();
            }
        }
    }

    @Override
    public void eliminarCurso(Curso curso) {
        Session session=null;
        try {
            session= NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(curso);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
        finally{
            if(session !=null){
                session.close();
            }
        }
    }

    @Override
    public List<Curso> mostrarCursos() {
        Session session = null;
        List<Curso> lista = null;
        try {
            session= NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Curso");//Viene del Model
            lista = (List<Curso>) query.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            
        }finally{
            if(session !=null){
                session.close();
            }
        }
        return lista;
    }
}
