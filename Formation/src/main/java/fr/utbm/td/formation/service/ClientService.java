/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.td.formation.service;

import fr.utbm.td.formation.entity.Client;
import fr.utbm.td.formation.entity.CourseSession;

/**
 *
 * @author ag
 */
public class ClientService {

    public void registerClient(String firstName, String lastName, String address, String phone, String email, int idCS) {
        CourseSessionService csService = new CourseSessionService();
        CourseSession cs = csService.getCourseSessionByID(idCS);
        
        Client c = new Client(lastName, firstName, address, phone, email, cs);
        
    }
}
