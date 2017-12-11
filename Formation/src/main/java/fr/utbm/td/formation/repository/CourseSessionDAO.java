/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.td.formation.repository;

import fr.utbm.td.formation.entity.CourseSession;
import fr.utbm.td.formation.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ag
 */
public class CourseSessionDAO {

    public CourseSession getCourseSessionByID(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CourseSession cs = null;
        try {
            cs = (CourseSession) session.get(CourseSession.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return cs;
    }
    
    public List<CourseSession> getCoursesSessions(String title, String city, Date startDate, Date endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String requete = "FROM CourseSession as cs "
                + "WHERE cs.course.title LIKE ? "
                + "AND cs.location.city = ? "
                + "AND cs.startDate >= ? "
                + "AND cs.endDate <= ?";
        
        Query query = session.createQuery(requete)
                .setString(0, "%"+title+"%")
                .setString(1, city)
                .setParameter(2, startDate)
                .setParameter(3, endDate);

        //session.close();
        return query.list();
    }
}
