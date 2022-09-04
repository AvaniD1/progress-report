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
public class StudentPercentageScore {
    private String studentId;
    private int examId;
    private String examDescription;
    private int percentageScore;
    private int percentageAvgScore;
    private int percentageMaxScore;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getPercentageScore() {
        return percentageScore;
    }

    public void setPercentageScore(int percentageScore) {
        this.percentageScore = percentageScore;
    }

    public int getPercentageAvgScore() {
        return percentageAvgScore;
    }

    public void setPercentageAvgScore(int percentageAvgScore) {
        this.percentageAvgScore = percentageAvgScore;
    }

    public int getPercentageMaxScore() {
        return percentageMaxScore;
    }

    public void setPercentageMaxScore(int percentageMaxScore) {
        this.percentageMaxScore = percentageMaxScore;
    }

    public String getExamDescription() {
        return examDescription;
    }

    public void setExamDescription(String examDescription) {
        this.examDescription = examDescription;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.studentId);
        hash = 47 * hash + this.examId;
        hash = 47 * hash + Objects.hashCode(this.examDescription);
        hash = 47 * hash + this.percentageScore;
        hash = 47 * hash + this.percentageAvgScore;
        hash = 47 * hash + this.percentageMaxScore;
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
        final StudentPercentageScore other = (StudentPercentageScore) obj;
        if (this.examId != other.examId) {
            return false;
        }
        if (this.percentageScore != other.percentageScore) {
            return false;
        }
        if (this.percentageAvgScore != other.percentageAvgScore) {
            return false;
        }
        if (this.percentageMaxScore != other.percentageMaxScore) {
            return false;
        }
        if (!Objects.equals(this.studentId, other.studentId)) {
            return false;
        }
        if (!Objects.equals(this.examDescription, other.examDescription)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StudentPercentageScore{" + "studentId=" + studentId 
                + ", examId=" + examId + ", examDescription=" 
                + examDescription + ", percentageScore=" 
                + percentageScore + ", percentageAvgScore=" 
                + percentageAvgScore + ", percentageMaxScore=" 
                + percentageMaxScore + '}';
    }


    
    
}
