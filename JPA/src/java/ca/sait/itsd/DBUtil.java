/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Administrator
 */
public class DBUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("JPAapplicationPU");
    public static EntityManagerFactory getEmFactory(){
        return emf;
    }
}
