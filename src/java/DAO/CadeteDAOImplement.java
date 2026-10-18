package DAO;

import Model.Cadete;
import Model.Curso;
import Persistencia.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CadeteDAOImplement implements CadeteDAO {

    @Override
    public void insertarCadete(Cadete cadete) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            // Validar y cargar el curso
            if (cadete.getCurso() != null && cadete.getCurso().getIdcurso() != null) {
                Curso curso = (Curso) session.get(Curso.class, cadete.getCurso().getIdcurso());
                if (curso != null) {
                    cadete.setCurso(curso);
                }
            }
            
            session.save(cadete);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al insertar cadete: " + e.getMessage());
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void modificarCadete(Cadete cadete) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            // Cargar el cadete existente
            Cadete cadeteExistente = (Cadete) session.get(Cadete.class, cadete.getIdcadete());
            if (cadeteExistente == null) {
                throw new HibernateException("Cadete no encontrado con ID: " + cadete.getIdcadete());
            }
            
            // Actualizar propiedades
            cadeteExistente.setProcedencia(cadete.getProcedencia());
            cadeteExistente.setMatricula(cadete.getMatricula());
            cadeteExistente.setGradoOstento(cadete.getGradoOstento());
            cadeteExistente.setHijoMilitar(cadete.getHijoMilitar());
            cadeteExistente.setBeneficioExamen(cadete.getBeneficioExamen());
            cadeteExistente.setNombres(cadete.getNombres());
            cadeteExistente.setPaterno(cadete.getPaterno());
            cadeteExistente.setMaterno(cadete.getMaterno());
            cadeteExistente.setEdad(cadete.getEdad());
            cadeteExistente.setSexo(cadete.getSexo());
            cadeteExistente.setFechaNacimiento(cadete.getFechaNacimiento());
            cadeteExistente.setLugarNacimiento(cadete.getLugarNacimiento());
            cadeteExistente.setNacionalidad(cadete.getNacionalidad());
            cadeteExistente.setFechaIngreso(cadete.getFechaIngreso());
            cadeteExistente.setFechaEgreso(cadete.getFechaEgreso());
            cadeteExistente.setCelular(cadete.getCelular());
            cadeteExistente.setDireccion(cadete.getDireccion());
            cadeteExistente.setFotografia(cadete.getFotografia());
            cadeteExistente.setPromedioIngreso(cadete.getPromedioIngreso());
            cadeteExistente.setPromedioEgreso(cadete.getPromedioEgreso());
            cadeteExistente.setCursosAdicionales(cadete.getCursosAdicionales());
            cadeteExistente.setEstadoCivil(cadete.getEstadoCivil());
            cadeteExistente.setRfc(cadete.getRfc());
            cadeteExistente.setCorreoElectronico(cadete.getCorreoElectronico());
            cadeteExistente.setNombrePadreOmadreMilitar(cadete.getNombrePadreOmadreMilitar());
            cadeteExistente.setEstadoPadreOmadreMilitar(cadete.getEstadoPadreOmadreMilitar());
            cadeteExistente.setArchivo(cadete.getArchivo());
            
            // Manejar el curso
            if (cadete.getCurso() != null && cadete.getCurso().getIdcurso() != null) {
                Curso curso = (Curso) session.get(Curso.class, cadete.getCurso().getIdcurso());
                if (curso != null) {
                    cadeteExistente.setCurso(curso);
                }
            }
            
            session.update(cadeteExistente);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al modificar cadete: " + e.getMessage());
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void eliminarCadete(Cadete cadete) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            // Cargar el cadete para eliminación
            Cadete cadeteAEliminar = (Cadete) session.get(Cadete.class, cadete.getIdcadete());
            if (cadeteAEliminar != null) {
                session.delete(cadeteAEliminar);
            }
            
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error al eliminar cadete: " + e.getMessage());
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Cadete> mostrarCadetes() {
        Session session = null;
        List<Cadete> lista = null;
        try {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Cadete c LEFT JOIN FETCH c.curso");
            lista = (List<Cadete>) query.list();
        } catch (HibernateException e) {
            System.out.println("Error al obtener cadetes: " + e.getMessage());
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return lista;
    }
}