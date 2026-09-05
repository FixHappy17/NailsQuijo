
package ConsoleDAO;

import Console.JPAUtil;
import Console.Cliente;
import static Console.JPAUtil.getEntityManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;



public class ClienteDAO {
    public List<Cliente> listar (String filtroNome, String gmail, String telefone ) {
       
       EntityManager em = JPAUtil.getEntityManager();
       List<Cliente> cliente = null;
       
       try {
           String textoQuery = "SELECT c FROM Cliente c "+
                   "WHERE (:nome is null or c.nome LIKE :nome) "+
                   "AND (:gmail is null or c.gmail LIKE :gmail) "+
                   "AND (:telefone is null or c.telefone LIKE :telefone)";
           
           Query consulta = em.createQuery(textoQuery);
           
           consulta.setParameter("nome", (filtroNome == null || filtroNome.trim().isEmpty()) ? null : "%" + filtroNome + "%");
           consulta.setParameter("gmail", (gmail == null || gmail.trim().isEmpty()) ? null : "%" + gmail + "%");
           consulta.setParameter("telefone", (telefone == null || telefone.trim().isEmpty()) ? null : "%" + telefone + "%");
           
           cliente = consulta.getResultList();
           
       }finally{
           JPAUtil.closeEntityManager();
       }
       return cliente;
 
    }
    
    public List<Cliente> listar() {
    EntityManager em = getEntityManager();
    try {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    } finally {
        em.close();
    }
}
    
    
    
    /**
    * Cadastra uma nova manicure no banco de dados.
    * *@param m Objeto Manicure a ser cadastrado.
    */
   
   public void cadastrar(Cliente c){
       EntityManager em = JPAUtil.getEntityManager();
       try {
           em.getTransaction().begin();
           em.persist(c); // Salva o novo registro usando JPA
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
    * Obtém uma manicure pelo seu ID.
    * *@param id Identificador da manicure.
    * @return Objeto Manicure encontrado null.
    */
   public Cliente obter(int id){
       EntityManager em = JPAUtil.getEntityManager();
       try{
           return em.find(Cliente.class, id);
       }finally{
           JPAUtil.closeEntityManager();
       }
   }
   
   
   
   
   /**
    * Atualiza os dados de uma manicure existente no banco de dados.
    * *@param m Objeto contendo os dados atualizados da manicure.
    */
   public void atualizar(Cliente c){
       EntityManager em = JPAUtil.getEntityManager();
       try{
           em.getTransaction().begin();
           em.merge(c);
           em.getTransaction().commit();
       }catch (Exception e){
           em.getTransaction().rollback();
           throw e;
       }finally {
           JPAUtil.closeEntityManager();
       }
   }
   
   
   /**
    * Remove uma manicure do banco de dados pelo ID.
    * *@param id Identificador do filme a ser excluido.
    */
   public void excluir (int id){
       EntityManager em = JPAUtil.getEntityManager();
       try{
           Cliente c = em.find(Cliente.class,id);
           if(c != null){
               em.getTransaction().begin();
               em.remove(c);
               em.getTransaction().commit();
           }
       }catch(Exception e){
           em.getTransaction().rollback();
           throw e;
       }finally{
           JPAUtil.closeEntityManager();
       }
   }
   
   
    
}
