/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.td.formation.service;

import fr.utbm.td.formation.entity.CourseSession;
import fr.utbm.td.formation.repository.CourseSessionDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ag
 */
public class CourseSessionService {

    public CourseSession getCourseSessionByID(int id) {
        CourseSessionDAO cs = new CourseSessionDAO();
        return cs.getCourseSessionByID(id);
    }
    
    public List<CourseSession> getCoursesSessions(String title, String city, Date startDate, Date endDate) {
        CourseSessionDAO cs = new CourseSessionDAO();
        return cs.getCoursesSessions(title, city, startDate, endDate);
    }
}
