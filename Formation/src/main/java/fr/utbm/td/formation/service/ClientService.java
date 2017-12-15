/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.td.formation.service;

import fr.utbm.td.formation.entity.Client;
import fr.utbm.td.formation.entity.CourseSession;
import fr.utbm.td.formation.repository.ClientDAO;

/**
 *
 * @author ag
 */
public class ClientService {

    private final ClientDAO cDAO;

    public ClientService() {
        cDAO = new ClientDAO();
    }

    public void registerClient(String firstName, String lastName, String address, String phone, String email, int idCS) {
        CourseSessionService csService = new CourseSessionService();
        CourseSession cs = csService.getCourseSessionByID(idCS);

        Client c = new Client(lastName, firstName, address, phone, email, cs);
        cDAO.registerClient(c);
    }

    public Client getLastClient() {
        return cDAO.getLastClient();
    }
}
