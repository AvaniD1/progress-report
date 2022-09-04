/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework;

import edu.abbey.coursework.model.Student;
import edu.abbey.coursework.model.Subject;
import edu.abbey.coursework.model.YearGroup;
import edu.abbey.coursework.service.StudentService;
import java.sql.SQLException;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 *
 * @author Avani Dwivedi
 */
public class StudentDataPopulater {
    
    private StudentService studentService = new StudentService();
    
    public void populateStudents(ComboBox<Student> studentCtl, SelectedData selectedData) throws SQLException {
        
        ObservableList <Student> observableStudentList =
                FXCollections.observableArrayList(studentService.getStudentsByYearGroup(selectedData.getYearGroupId()));
        studentCtl.setItems(observableStudentList);
        
        studentCtl.setCellFactory(new Callback<ListView<Student>, ListCell<Student>>() {
 
            @Override
            public ListCell<Student> call(ListView<Student> param) {
                final ListCell<Student> cell = new ListCell<Student>() {
 
                    @Override
                    protected void updateItem(Student item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getFirstName() + " " + item.getLastName());
                        } else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        });
        
        studentCtl.setButtonCell(new ListCell<Student>(){
            @Override
            protected void updateItem(Student item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setText(item.getFirstName() + " " + item.getLastName());
                } else {
                    setText(null);
                }
            }
        });
        studentCtl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                selectedData.setStudentId(newValue.getStudentId());
            }
        });
    }
    
    public void populateSubjects(ComboBox<Subject> subjectCtl, SelectedData selectedData) throws SQLException {
        
        ObservableList <Subject> observableSubjectList =
                FXCollections.observableArrayList(studentService.getStudentSubjectsByYearGroup(
                        selectedData.getStudentId(), selectedData.getYearGroupId()));
        subjectCtl.setItems(observableSubjectList);
        
        subjectCtl.setCellFactory(new Callback<ListView<Subject>, ListCell<Subject>>() {
 
            @Override
            public ListCell<Subject> call(ListView<Subject> param) {
                final ListCell<Subject> cell = new ListCell<Subject>() {
 
                    @Override
                    protected void updateItem(Subject item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item.getDisplayName());
                        } else {
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        });
        
        subjectCtl.setButtonCell(new ListCell<Subject>(){
            @Override
            protected void updateItem(Subject item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setText(item.getDisplayName());
                } else {
                    setText(null);
                }
            }
        });
        subjectCtl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Subject>() {
            @Override
            public void changed(ObservableValue<? extends Subject> observable, Subject oldValue, Subject newValue) {
                selectedData.setSubjectId(newValue.getSubjectId());
            }
        });
    }
    
}
