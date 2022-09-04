/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework.model;

import java.util.Objects;

/**
 *
 * @author Avani Dwivedi
 */
public class YearGroup {

    private String yearGroupId;
    private String displayName;
    private String description;
    
    public String getYearGroupId() {
        return yearGroupId;
    }

    public void setYearGroupId(String yearGroupId) {
        this.yearGroupId = yearGroupId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
@Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.yearGroupId);
        hash = 89 * hash + Objects.hashCode(this.displayName);
        hash = 89 * hash + Objects.hashCode(this.description);
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
        final YearGroup other = (YearGroup) obj;
        if (!Objects.equals(this.yearGroupId, other.yearGroupId)) {
            return false;
        }
        if (!Objects.equals(this.displayName, other.displayName)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "YearGroup{" + "yearGroupId=" + yearGroupId + ", displayName=" + displayName + ", description=" + description + '}';
    }

    
    
}
