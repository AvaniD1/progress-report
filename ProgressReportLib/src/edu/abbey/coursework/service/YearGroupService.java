/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework.service;

import edu.abbey.coursework.dao.YearGroupDao;
import edu.abbey.coursework.model.YearGroup;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Avani Dwivedi
 */
public class YearGroupService {
    
    public List<YearGroup> getAllYearGroups() throws SQLException {
        YearGroupDao dao = new YearGroupDao();
        try{
            return dao.getAllYearGroups();
        }
        finally{
            if(dao != null)
                dao.closeConnection();
        }
    }
}
