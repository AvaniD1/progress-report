/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework;

import java.util.Objects;

/**
 *
 * @author Avani Dwivedi
 */
public class SelectedData {
    
    private String yearGroupId;
    private String studentId;
    private String subjectId;

    public String getYearGroupId() {
        return yearGroupId;
    }

    public void setYearGroupId(String yearGroupId) {
        this.yearGroupId = yearGroupId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.yearGroupId);
        hash = 47 * hash + Objects.hashCode(this.studentId);
        hash = 47 * hash + Objects.hashCode(this.subjectId);
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
        final SelectedData other = (SelectedData) obj;
        if (!Objects.equals(this.yearGroupId, other.yearGroupId)) {
            return false;
        }
        if (!Objects.equals(this.studentId, other.studentId)) {
            return false;
        }
        if (!Objects.equals(this.subjectId, other.subjectId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SelectedData{" + "yearGroupId=" + yearGroupId + ", studentId=" + studentId + ", subjectId=" + subjectId + '}';
    }
 
}
