package edu.abbey.coursework.service;

import edu.abbey.coursework.dao.TeacherDao;
import java.sql.SQLException;

public class TeacherLogin extends Login{

    @Override
    protected String getPassworFromDB(String userName) throws SQLException {
        TeacherDao dao = new TeacherDao();
        try{
            return dao.getTeacherPassword(userName);
        }
        finally{
            if(dao != null)
                dao.closeConnection();
        }
    }
}
