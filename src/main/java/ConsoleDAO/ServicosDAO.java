package ConsoleDAO;

import Console.Servicos;
import static Console.JPAUtil.getEntityManager;
import jakarta.persistence.EntityManager;
import java.util.List;

public class ServicosDAO {

    public void cadastrar(Servicos servico) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(servico);
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

    public void atualizar(Servicos servico) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(servico);
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

    public void excluir(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Servicos s = em.find(Servicos.class, id);
            if (s != null) {
                em.remove(s);
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

    public Servicos obter(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Servicos.class, id);
        } finally {
            em.close();
        }
    }

    public List<Servicos> listar() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT s FROM Servicos s", Servicos.class).getResultList();
        } finally {
            em.close();
        }
    }
}