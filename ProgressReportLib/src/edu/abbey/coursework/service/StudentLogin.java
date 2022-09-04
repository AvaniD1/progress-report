package edu.abbey.coursework.service;

import edu.abbey.coursework.dao.StudentDao;
import java.sql.SQLException;

public class StudentLogin extends Login {

    @Override
    protected  String getPassworFromDB(String userName) throws SQLException {
        StudentDao dao = new StudentDao();
        try{
            return dao.getStudentPassword(userName);
        }
        finally{
            if(dao != null)
                dao.closeConnection();
        }
    }
}
