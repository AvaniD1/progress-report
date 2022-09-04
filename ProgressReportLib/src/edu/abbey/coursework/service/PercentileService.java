/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework.service;

import java.util.List;

/**
 *
 * @author Avani Dwivedi
 */
public class PercentileService {
    
    public double getPercentile(int studentScore, List<Integer> allScoresAscending){
        
        // All score are in ascending order already
        // find the rank
        int rank = 0;
        for(int score : allScoresAscending){
            if(studentScore >= score){
                rank++;
            }
            else break;
        }
        double percentile = (rank*100/allScoresAscending.size());
        return percentile;
    }
    
}
