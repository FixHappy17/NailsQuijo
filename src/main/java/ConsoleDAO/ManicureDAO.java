
package ConsoleDAO;

import Console.JPAUtil;
import static Console.JPAUtil.getEntityManager;
import Console.Manicure;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;


public class ManicureDAO {
    
   public List<Manicure> listar (String filtroNome, String gmail, String telefone ) {
       
       EntityManager em = JPAUtil.getEntityManager();
       List<Manicure> manicure = null;
       
       try {
           String textoQuery = "SELECT m FROM Manicure m "+
                   "WHERE (:nome is null or m.nome LIKE :nome) "+
                   "AND (:gmail is null or m.gmail LIKE :gmail) "+
                   "AND (:telefone is null or m.telefone LIKE :telefone)";
           
           Query consulta = em.createQuery(textoQuery);
           
           consulta.setParameter("nome", (filtroNome == null || filtroNome.trim().isEmpty()) ? null : "%" + filtroNome + "%");
           consulta.setParameter("gmail", (gmail == null || gmail.trim().isEmpty()) ? null : "%" + gmail + "%");
           consulta.setParameter("telefone", (telefone == null || telefone.trim().isEmpty()) ? null : "%" + telefone + "%");
           
           manicure = consulta.getResultList();
           
       }finally{
           JPAUtil.closeEntityManager();
       }
       return manicure;
   }
   
   public List<Manicure> listar() {
    EntityManager em = getEntityManager();
    try {
        return em.createQuery("SELECT m FROM Manicure m", Manicure.class).getResultList();
    } finally {
        em.close();
    }
}
   
   /**
    * Cadastra uma nova manicure no banco de dados.
    * *@param m Objeto Manicure a ser cadastrado.
    */
   
   public void cadastrar(Manicure m){
       EntityManager em = JPAUtil.getEntityManager();
       try {
           em.getTransaction().begin();
           em.persist(m); // Salva o novo registro usando JPA
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
   public Manicure obter(int id){
       EntityManager em = JPAUtil.getEntityManager();
       try{
           return em.find(Manicure.class, id);
       }finally{
           JPAUtil.closeEntityManager();
       }
   }
   
   
   
   
   /**
    * Atualiza os dados de uma manicure existente no banco de dados.
    * *@param m Objeto contendo os dados atualizados da manicure.
    */
   public void atualizar(Manicure m){
       EntityManager em = JPAUtil.getEntityManager();
       try{
           em.getTransaction().begin();
           em.merge(m);
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
           Manicure m = em.find(Manicure.class,id);
           if(m != null){
               em.getTransaction().begin();
               em.remove(m);
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
