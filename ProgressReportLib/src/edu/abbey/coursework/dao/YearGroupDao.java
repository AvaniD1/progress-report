/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework.dao;

import edu.abbey.coursework.model.YearGroup;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Avani Dwivedi
 */
public class YearGroupDao extends BaseDao {
    
    public YearGroupDao() throws SQLException {
        super();
    }
    
    public List<YearGroup> getAllYearGroups() throws SQLException {
        try{
            String query = "SELECT year_group_id , display_name , description from year_groups";
            ResultSet resultSet = dbConnection.createStatement().executeQuery(query);
            List<YearGroup> yearGroups = new ArrayList<>();
            
            while(resultSet.next()){
                YearGroup yearGroup = new YearGroup();
                yearGroup.setYearGroupId(resultSet.getString("year_group_id"));
                yearGroup.setDisplayName(resultSet.getString("display_name"));
                yearGroup.setDescription(resultSet.getString("description"));
                yearGroups.add(yearGroup);
            }
            
            return yearGroups;
        }
        catch(SQLException ex){
            logSQLError(ex);
            throw ex;
        }       
    }    
}
