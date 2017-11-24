/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.td.formation.controller;

import fr.utbm.td.formation.entity.CourseSession;
import fr.utbm.td.formation.service.CourseSessionService;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ag
 */
public class DefaultController {

    public void getCoursesSessions() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select a course");
        String title = sc.nextLine();

        System.out.println("Select a location");
        String location = sc.nextLine();
        
        Date startDate = Date.from(Instant.MIN);
        Date endDate = Date.from(Instant.MIN);
        
        
        CourseSessionService css = new CourseSessionService();
        List<CourseSession> listCS = css.getCoursesSessions(title, title, startDate, endDate);
        
        if(!listCS.isEmpty()) {
            for (CourseSession cs : listCS) {
                System.out.println(cs.toString());
            }
        }
    }
}
