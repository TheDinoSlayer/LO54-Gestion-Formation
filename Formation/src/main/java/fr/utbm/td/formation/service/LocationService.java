/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.utbm.td.formation.service;

import fr.utbm.td.formation.entity.Location;
import fr.utbm.td.formation.repository.LocationDAO;
import java.util.List;

/**
 *
 * @author ag
 */
public class LocationService {
    public List<Location> getLocations() {
        LocationDAO l = new LocationDAO();
        return l.getLocations();
    }
}
