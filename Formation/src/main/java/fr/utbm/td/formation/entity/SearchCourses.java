/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.td.formation.entity;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author ag
 */
@Table(keyspace = "formation", name = "searchcourse",
        readConsistency = "QUORUM",
        writeConsistency = "QUORUM",
        caseSensitiveKeyspace = false,
        caseSensitiveTable = false)
public class SearchCourses {

    private UUID searchID;
    private String keyWordFormation;
    private String location;
    private String date;
    private String startTime;
    private String endTime;

    public SearchCourses() {
    }

    public SearchCourses(UUID searchID, String keyWordFormation, String location, String date, String startTime, String endTime) {
        this.searchID = searchID;
        this.keyWordFormation = keyWordFormation;
        this.location = location;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @PartitionKey
    @Column(name = "search_id")
    public UUID getSearchID() {
        return searchID;
    }

    public void setSearchID(UUID searchID) {
        this.searchID = searchID;
    }

    @Column(name = "keyword_formation")
    public String getKeyWordFormation() {
        return keyWordFormation;
    }

    public void setKeyWordFormation(String keyWordFormation) {
        this.keyWordFormation = keyWordFormation;
    }

    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String Location) {
        this.location = Location;
    }

    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "start_time")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Column(name = "end_time")
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.searchID);
        hash = 79 * hash + Objects.hashCode(this.keyWordFormation);
        hash = 79 * hash + Objects.hashCode(this.location);
        hash = 79 * hash + Objects.hashCode(this.date);
        hash = 79 * hash + Objects.hashCode(this.startTime);
        hash = 79 * hash + Objects.hashCode(this.endTime);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SearchCourses other = (SearchCourses) obj;
        if (!Objects.equals(this.keyWordFormation, other.keyWordFormation)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.searchID, other.searchID)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.startTime, other.startTime)) {
            return false;
        }
        if (!Objects.equals(this.endTime, other.endTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SearchCourses{" + "searchID=" + searchID + ", keyWordFormation=" + keyWordFormation + ", Location=" + location + ", date=" + date + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }
}
