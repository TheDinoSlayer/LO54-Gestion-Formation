/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.utbm.td.formation.repository;

import fr.utbm.td.formation.entity.Location;
import fr.utbm.td.formation.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ag
 */
public class LocationDAO {
    public List<Location> getLocations() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Location");
        return query.list();
    }
}
