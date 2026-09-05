
package Console;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
        
        
      
/**
 * Classe utilitária responsável por gerenciar conexões via JPA/Hibernate.
 * Centraliza a criação do EntityManagerFactory e EntityManager.
 * * @author FixHappy
 */        
public class JPAUtil {
    
// Nome da unidade de persistencia configurada no persistence.xml
    private static final String PERSISTENCE_UNITY = "AliceNailsQuijo";
    
    private static EntityManager em;
    private static EntityManagerFactory fabrica;
    
    
   /**
     * Retorna a instância ativa do EntityManager.
     * Cria a fábrica de conexões caso ainda não exista.
     * * @return EntityManager para operações com o banco de dados.
     */
    
   public static EntityManager getEntityManager(){
       if(fabrica == null || !fabrica.isOpen()){
           fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNITY);
       }
       
       if (em == null || !em.isOpen()){
           em = fabrica.createEntityManager();
       }
       return em;
   } 
   
   /**
    * Fecha o EntityManager atual se estiver aberto
    */
   
   public static void closeEntityManager(){
       if (em != null && em.isOpen()){
           em.close();
       }
   }

   
}
