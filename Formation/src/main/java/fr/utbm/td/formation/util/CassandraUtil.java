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

    public void createKeySpaces() {

        String query = "CREATE KEYSPACE IF NOT EXISTS Formation WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': '1'};";
        Cluster cluster = Cluster.builder().withClusterName("Cluster 1").addContactPoint("localhost").build();
        Session session = cluster.connect();
        session.execute(query);
        session.execute("USE Formation");

    }
}
