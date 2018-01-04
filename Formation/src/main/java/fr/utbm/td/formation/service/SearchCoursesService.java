/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.td.formation.service;

import fr.utbm.td.formation.entity.SearchCourses;
import fr.utbm.td.formation.repository.SearchCoursesDAO;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ag
 */
public class SearchCoursesService {

    public void save(String keyword, String location, String date, String startTime, String endTime) {
        UUID id = UUID.randomUUID();

        SearchCourses sc = new SearchCourses(id, keyword, location, date, startTime, endTime);
        SearchCoursesDAO scDAO = new SearchCoursesDAO();
        scDAO.saveSearch(sc);
    }
    
    public List<SearchCourses> getSearches() {
        SearchCoursesDAO scDAO = new SearchCoursesDAO();
        return scDAO.getSearches();
    }
}
