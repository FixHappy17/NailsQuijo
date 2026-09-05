
package ConsoleDAO;

import Console.JPAUtil;
import Console.Produtos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class ProdutosDAO {
    
    
    /**
     * Cadastra um novo produto no banco de dados
     * @param p 
     */
    public void cadastrar (Produtos p){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw e;
        }finally{
        JPAUtil.closeEntityManager();
    }
    }
    
    /**
     * Obtém um produto pelo id
     * @param id
     * @return 
     */
    public Produtos obter (int id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            return em.find(Produtos.class,id);
            
        }finally{
            JPAUtil.closeEntityManager();
        }
    }
    
    /**
     * Atualiza os dados de um produto existente no banco de dados
     * @param p 
     */
    public void atualizar (Produtos p){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }catch(Exception e){
            throw e;
        }finally{
            JPAUtil.closeEntityManager();
        }
    }
    
    
    /**
     * Remove um produto do banco de dados pelo id.
     * @param id 
     */
    public void excluir (int id){
        EntityManager em = JPAUtil.getEntityManager();
        try{
            Produtos p = em.find(Produtos.class,id);
            if(p != null){
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
            }
        }catch(Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally{
            JPAUtil.closeEntityManager();
        }
    }
    
    
    /**
     * Método para filtrar e pesquisar produtos com os parâmetros.
     * @param filtroNome
     * @param filtroMarca
     * @param filtroCategoria
     * @param filtroQuantidade
     * @return 
     */
    public List<Produtos> listar (String filtroNome, String filtroMarca, String filtroCategoria, Integer filtroQuantidade){
        
        EntityManager em = JPAUtil.getEntityManager();
        List<Produtos> produtos = null;
        
        try{
            String textoQuery = "SELECT p FROM Produtos p "+
                    "WHERE (:nome is null or p.nome LIKE :nome) "+
                    "AND (:marca is null or p.marca LIKE :marca) "+
                    "AND(:categoria is null or p.categoria LIKE :categoria) "+
                    "AND (:quantidade is null or p.quantidade = :quantidade) ";
            
            Query consulta = em.createQuery(textoQuery);
            
            consulta.setParameter("nome",(filtroNome == null || filtroNome.trim().isEmpty()) ? null : "%" + filtroNome + "%");
            consulta.setParameter("marca",(filtroMarca == null || filtroMarca.trim().isEmpty()) ? null : "%" + filtroMarca + "%");
            consulta.setParameter("categoria",(filtroCategoria == null || filtroCategoria.trim().isEmpty()) ? null : "%" + filtroCategoria + "%");
            consulta.setParameter("quantidade", filtroQuantidade);
            
            produtos = consulta.getResultList();
                    
                    
        }finally{
            JPAUtil.closeEntityManager();
        }
        return produtos;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
