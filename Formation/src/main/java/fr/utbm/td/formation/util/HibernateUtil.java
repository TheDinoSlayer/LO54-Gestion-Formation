/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.td.formation.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author ag
 */
public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("Initial SessionFacotry creation failed" + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
