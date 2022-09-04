/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.abbey.coursework;

import edu.abbey.coursework.model.YearGroup;
import edu.abbey.coursework.service.YearGroupService;
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
public class YearGroupDataPopulater {
    
    private YearGroupService yearGroupService = new YearGroupService();
    
    public void populate(ComboBox<YearGroup> yearGroupCtl, SelectedData selectedData) throws SQLException {
        List<YearGroup> yearGroupList = yearGroupService.getAllYearGroups();
        
        ObservableList <YearGroup> observableYearGroupList =
                FXCollections.observableArrayList(yearGroupList);
        yearGroupCtl.setItems(observableYearGroupList);
        
        yearGroupCtl.setCellFactory(new Callback<ListView<YearGroup>, ListCell<YearGroup>>() {
 
            @Override
            public ListCell<YearGroup> call(ListView<YearGroup> param) {
                final ListCell<YearGroup> cell = new ListCell<YearGroup>() {
 
                    @Override
                    protected void updateItem(YearGroup item, boolean empty) {
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
        
        yearGroupCtl.setButtonCell(new ListCell<YearGroup>(){
            @Override
            protected void updateItem(YearGroup item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setText(item.getDisplayName());
                } else {
                    setText(null);
                }
            }
        });
        yearGroupCtl.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<YearGroup>() {
            @Override
            public void changed(ObservableValue<? extends YearGroup> observable, YearGroup oldValue, YearGroup newValue) {
                selectedData.setYearGroupId(newValue.getYearGroupId());
            }
        });
    }
}
