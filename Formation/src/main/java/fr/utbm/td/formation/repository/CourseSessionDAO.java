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
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
            if (session != null) {
                session.close();
            }
        }
        return cs;
    }

    public List<CourseSession> getCoursesSessions(String title, String city, Date startDate, Date endDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Criteria criteria = session.createCriteria(CourseSession.class)
                .createAlias("course", "c")
                .createAlias("location", "l");

        if (title != null && !title.isEmpty()) {
            criteria.add(Restrictions.disjunction().add(Restrictions.like("c.title", "%" + title + "%")));
        }
        if (city != null && !city.isEmpty()) {
            criteria.add(Restrictions.disjunction().add(Restrictions.eq("l.city", city)));
        }
        if (startDate != null) {
            criteria.add(Restrictions.ge("startDate", startDate));
        }
        if (endDate != null) {
            criteria.add(Restrictions.le("endDate", endDate));
        }

        List<CourseSession> listCS = criteria.list();

        session.close();

        return listCS;
    }
}
