/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.td.formation.util;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 *
 * @author ag
 */
public class CassandraUtil {
    
    public static void createKeySpaces() {
        String formation = "CREATE KEYSPACE formation WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}";
        String table = "CREATE TABLE searchcourse ("
                + "search_id uuid PRIMARY KEY,"
                + "keyword_formation text,"
                + "location text,"
                + "date text,"
                + "start_time text,"
                + "end_time text);";
        
        Cluster cluster = Cluster.builder().addContactPoint("localhost").withPort(9042).build();
        Session session = cluster.connect();
        session.execute(formation);
        session.execute("USE formation;");
        session.execute(table);
        cluster.close();
    }
}
