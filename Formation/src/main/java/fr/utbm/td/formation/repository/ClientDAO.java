/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.td.formation.repository;

import fr.utbm.td.formation.entity.Client;
import fr.utbm.td.formation.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author ag
 */
public class ClientDAO {

    public void registerClient(Client c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(c);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
