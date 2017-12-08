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
        String requete = "FROM CourseSession as cs "
                //+ "INNER JOIN cs.course c "
                //+ "INNER JOIN cs.location l "
                //+ "WHERE cs.course.title LIKE ?";
                + " AND cs.location.city = ?";
                //+ "AND cs.startDate >= ? AND cs.endDate <= ?";
        /*
        
        from course as c
        inner join course_session as cs 
        on c.code=cs.course_code
        inner join location as l
        on cs.location_id = l.id
        */
        Query query = session.createQuery(requete)
                //.setString(0, "%"+title+"%");
                .setString(0, city);
                //.setParameter(2, startDate)
                //.setParameter(3, endDate);

        //session.close();
        return query.list();
    }
}
