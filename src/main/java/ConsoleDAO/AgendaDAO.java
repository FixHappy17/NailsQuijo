package ConsoleDAO;

import Console.Agenda;
import static Console.JPAUtil.getEntityManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class AgendaDAO {

    // CADASTRAR
    public void cadastrar(Agenda agenda) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(agenda);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // ATUALIZAR
    public void atualizar(Agenda agenda) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(agenda);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // EXCLUIR
    public void excluir(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Agenda agenda = em.find(Agenda.class, id);
            if (agenda != null) {
                em.remove(agenda);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // OBTER
    public Agenda obter(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Agenda.class, id);
        } finally {
            em.close();
        }
    }

    // LISTAR TODOS
    public List<Agenda> listar() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT a FROM Agenda a", Agenda.class).getResultList();
        } finally {
            em.close();
        }
    }

    // LISTAR COM FILTROS
    public List<Agenda> listar(String nomeCliente, String nomeManicure) {
        EntityManager em = getEntityManager();
        try {
            StringBuilder jpql = new StringBuilder("SELECT a FROM Agenda a WHERE 1=1 ");

            if (nomeCliente != null && !nomeCliente.trim().isEmpty()) {
                jpql.append(" AND LOWER(a.cliente.nome) LIKE LOWER(:nomeCliente)");
            }
            if (nomeManicure != null && !nomeManicure.trim().isEmpty()) {
                jpql.append(" AND LOWER(a.manicure.nome) LIKE LOWER(:nomeManicure)");
            }

            TypedQuery<Agenda> query = em.createQuery(jpql.toString(), Agenda.class);

            if (nomeCliente != null && !nomeCliente.trim().isEmpty()) {
                query.setParameter("nomeCliente", "%" + nomeCliente + "%");
            }
            if (nomeManicure != null && !nomeManicure.trim().isEmpty()) {
                query.setParameter("nomeManicure", "%" + nomeManicure + "%");
            }

            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    
    // Atualizar se foi realizado ou não
    
    public void atualizarStatus(int idAgenda, String status){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            Agenda agenda = em.find(Agenda.class, idAgenda);
            if (agenda != null){
                agenda.setRealizado(status);
                em.merge(agenda);
            }
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw e;
        }finally{
            em.close();
        }
    }
    
}