/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.td.formation.repository;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;
import fr.utbm.td.formation.entity.SearchCourses;
import java.util.List;

/**
 *
 * @author ag
 */
public class SearchCoursesDAO {

    public void saveSearch(SearchCourses sc) {
        Cluster cluster = Cluster.builder().addContactPoint("localhost").withPort(9042).build();
        Session session = cluster.connect("formation");

        MappingManager manager = new MappingManager(session);
        Mapper<SearchCourses> mapper = manager.mapper(SearchCourses.class);
        mapper.save(sc);

        cluster.close();
    }

    public List<SearchCourses> getSearches() {
        Cluster cluster = Cluster.builder().addContactPoint("localhost").withPort(9042).build();
        Session session = cluster.connect("formation");

        MappingManager manager = new MappingManager(session);
        SearchAccessor accessor = manager.createAccessor(SearchAccessor.class);
        Result<SearchCourses> result = accessor.getAll();
        return result.all();
    }

    @Accessor
    interface SearchAccessor {
        @Query("SELECT * FROM searchcourse")
        Result<SearchCourses> getAll();
    }
}
