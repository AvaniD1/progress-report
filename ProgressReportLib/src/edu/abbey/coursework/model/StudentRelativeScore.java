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
public class StudentRelativeScore  extends StudentRawScore {
    private String examDate;
    private String examDescription;
    private int totalScore;
    private int averageScore;
    private int maximumScore;
    private double percentile;

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamDescription() {
        return examDescription;
    }

    public void setExamDescription(String examDescription) {
        this.examDescription = examDescription;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public int getMaximumScore() {
        return maximumScore;
    }

    public void setMaximumScore(int maximumScore) {
        this.maximumScore = maximumScore;
    }

    public double getPercentile() {
        return percentile;
    }

    public void setPercentile(double percentile) {
        this.percentile = percentile;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.examDate);
        hash = 71 * hash + Objects.hashCode(this.examDescription);
        hash = 71 * hash + this.totalScore;
        hash = 71 * hash + this.averageScore;
        hash = 71 * hash + this.maximumScore;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.percentile) ^ (Double.doubleToLongBits(this.percentile) >>> 32));
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
        
        if (! super.equals(obj)) return false;
        
        final StudentRelativeScore other = (StudentRelativeScore) obj;
        if (this.totalScore != other.totalScore) {
            return false;
        }
        if (this.averageScore != other.averageScore) {
            return false;
        }
        if (this.maximumScore != other.maximumScore) {
            return false;
        }
        if (this.percentile != other.percentile) {
            return false;
        }
        if (!Objects.equals(this.examDate, other.examDate)) {
            return false;
        }
        if (!Objects.equals(this.examDescription, other.examDescription)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
        "StudentRelativeScore{" + "examDate=" + examDate 
                + ", examDescription=" + examDescription 
                + ", totalScore=" + totalScore 
                + ", averageScore=" + averageScore 
                + ", maximumScore=" + maximumScore 
                + ", percentile=" + percentile + '}';
    }
}
