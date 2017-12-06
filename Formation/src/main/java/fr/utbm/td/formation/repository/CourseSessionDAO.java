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
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ag
 */
public class CourseSessionDAO {

    public List<CourseSession> getCoursesSessions(String title, String city, Date startDate, Date endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String requete = "FROM course_session as cs, course as c, location as l "
                + "INNER JOIN cs.course_code AS c.code "
                + "INNER JOIN cd.location_id as l.id"
                + "WHERE c.title = ?, l.city = ?, cs.start_date = ?, cs.end_date = ?";
        Query query = session.createQuery(requete)
                .setString(0, title)
                .setString(1, city)
                .setParameter(2, startDate)
                .setParameter(3, endDate);

        session.close();
        return query.list();
    }
}
