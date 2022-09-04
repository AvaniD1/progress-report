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
public class StudentRawScore {
    
    private String studentId;
    private int examId;
    private int score;

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
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.studentId);
        hash = 67 * hash + Objects.hashCode(this.examId);
        hash = 67 * hash + this.score;
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
        final StudentRawScore other = (StudentRawScore) obj;
        if (this.score != other.score) {
            return false;
        }
        if (!Objects.equals(this.studentId, other.studentId)) {
            return false;
        }
        if (this.examId != other.examId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StudentRawScore{" + "studentId=" 
                + studentId + ", examId=" 
                + examId + ", score=" + score + '}';
    }

 
    
    
}
