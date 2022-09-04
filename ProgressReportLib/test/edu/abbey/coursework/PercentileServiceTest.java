/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework;

import edu.abbey.coursework.service.PercentileService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javafx.print.Collation;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Avani Dwivedi
 */
public class PercentileServiceTest {
    
    private PercentileService percentileService = new PercentileService();
    
    @Test
    public void testPercentile(){
        
        List<Integer> allScoresAscending = new ArrayList();
        allScoresAscending.addAll(Arrays.asList(10,20,30,40,50,60,70,80,90,100));
        Assert.assertEquals(50.0,
                percentileService.getPercentile(50, allScoresAscending)
                ,0.01);
        Assert.assertEquals(100.0,
                percentileService.getPercentile(100, allScoresAscending)
                ,0.01);        
    }
    
}
