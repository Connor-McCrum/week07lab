/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class DBoperations {
    public String getUsernames(){
        String result="";
        
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        Query usernames = em.createNamedQuery("Users.findAll", Users.class);
        //basicly saying something like select *
        //uses the JPQL database langauge
        //look inside Users for how these query names are generated
        
        List<Users> usernamesList;
        
        try{
            usernamesList = usernames.getResultList();
            
            for(Users u: usernamesList){
                result = result + u.getUsername() + ",";
            }
        }
        finally{
            em.close();
        }
        
        return result;
    }
    public boolean addUsername(String username){
        boolean result = false;
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try{
            trans.begin();
            
            em.persist(new Users(0, username));//create new user object
            //and sent to persistence to the database to populate
            //user id is 0 becuase it's a placeholder the em handles the setting 
            //of the id
            
            trans.commit();
            
            result = true;
            
        }
        catch(Exception e){
            trans.rollback();
            e.printStackTrace();
        }
        
        return result;
    }
    public boolean deleteUsername(String username){
        boolean result = false;
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try{
            trans.begin();
            
            Users user = (Users) em.createNamedQuery("Users.findByUsername").
                    setParameter("username", username)
                    .getSingleResult();
            em.remove(user);
            
            trans.commit();
            
            result = true;
            
        }
        catch(Exception e){
            trans.rollback();
            e.printStackTrace();
        }
        
        return result;
    }
    public boolean updateUsername(String username, String newUsername){
        boolean result = false;
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        EntityTransaction trans = em.getTransaction();
        
        try{
            trans.begin();
            
            Users user = (Users) em.createNamedQuery("Users.findByUsername")
                    .setParameter("username", trans)
                    .getSingleResult();
            user.setUsername(newUsername);
            
            
            result = true;
            
        }
        catch(Exception e){
            trans.rollback();
            e.printStackTrace();
        }
        
        return result;
    }
    
}
