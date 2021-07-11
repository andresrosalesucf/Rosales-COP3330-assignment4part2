/*
 *  *  UCF COP3330 Summer 2021 Assignment 4
 *  *  Copyright 2021 Andres Rosales
 */
package ucf.assignments;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static ucf.assignments.csvHandler.*;

public class AppController implements Initializable {



    @FXML private TableView<ToDo> tableView;
    @FXML private CheckBox completedCheckbox;
    @FXML private CheckBox incompleteCheckbox;
    @FXML private TableColumn description;
    @FXML private TextField fileName;
    //Table view has an editable configuration which i will use,
    // hence no 'edit due date' or 'edit description' button


    @FXML
    public void removeToDoListButton(ActionEvent actionEvent){
        removeToDoList();
    }

    private void removeToDoList() {
        //retrieve List filename, delete from directory
        //delete  List object
    }

    @FXML
    public void loadListButton(ActionEvent actionEvent){
        loadList();
    }

    private void loadList() {
        //check Archive for listname, return filename
        //call readCSVList with filename
        //return a ToDoList, append to MasterList
    }

    @FXML
    protected void saveListButton(javafx.event.ActionEvent actionEvent){
        saveList();
    }

    public void saveList() {
        //loop through MasterList,
        csvHandler.writeCSV(tableView.getItems(), fileName.getText());
        // check if ToDoList has filename != ""
        //if empty ask user for filename, then add it to Object param
        // call writeCSV with ToDoList object
        //saveArchive()

    }

    @FXML
    public void addToDoButton(ActionEvent actionEvent){
        addToDo();
    }

    public void addToDo() {
        //init ToDo object
        //use text field duedate and description to populate ToDo
        //append to existing ToDoList
    }
    @FXML
    public void removeToDoButton(ActionEvent actionEvent){
        removeToDo();
    }

    public void removeToDo() {
        //get name of list from currently opened titledpane in accordian
        //use remove(name) to remove a list from MasterList
        //update scene
    }

    //here I will add listener for checkboxes, completed and incomplete
    //when unchecked, i will loop through list and if status matches unselected item, it is removed from list
    //redisplay tableview
    public void saveArchive(){
        //loop through Archive, save to .txt as csv

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //for display purposes only
        ObservableList<ToDo> todos = tableView.getItems();
        todos.add(new ToDo("12-05-2000","things", "C"));
        todos.add(new ToDo("1-11-2222","gotta go", "C"));
        todos.add(new ToDo("5-5-3000","eat ketchup", "C"));
        todos.add(new ToDo("4-20-2022","buy camera", "I"));
        todos.add(new ToDo("05-09-2002","watch dogs", "I"));
        description.setCellFactory(TextFieldTableCell.forTableColumn());
        description.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<ToDo, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<ToDo, String> event) {
                        ((ToDo) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())
                        ).setDescription(event.getNewValue());
                    }

                }
        );
    }


}
