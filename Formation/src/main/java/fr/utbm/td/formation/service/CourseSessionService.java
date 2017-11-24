/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.td.formation.service;

import fr.utbm.td.formation.entity.CourseSession;
import fr.utbm.td.formation.repository.HibernateCourseSession;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ag
 */
public class CourseSessionService {

    public List<CourseSession> getCoursesSessions(String title, String city, Date startDate, Date endDate) {
        HibernateCourseSession hcs = new HibernateCourseSession();
        return hcs.getCoursesSessions(title, city, startDate, endDate);
    }
}
