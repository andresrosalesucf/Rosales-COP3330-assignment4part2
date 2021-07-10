/*
 *  *  UCF COP3330 Summer 2021 Assignment 4
 *  *  Copyright 2021 Andres Rosales
 */
package ucf.assignments;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.beans.value.ObservableValue;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    //List of all ToDo Lists, from here all lists get retrieved for display
    List<ToDoList> MasterList = new LinkedList<>();

    //initialize a HashMap called Archive that matches filenames, and list names.
    //this will be to load lists in future.
    //gets saved to a .txt file whenever a save occurs
    HashMap<String, String> Archive = new HashMap<>();

    @FXML private TableView<ToDo> tableView;
    @FXML private CheckBox completedCheckbox;
    @FXML private CheckBox incompleteCheckbox;

    //Table view has an editable configuration which i will use,
    // hence no 'edit due date' or 'edit description' button
    @FXML
    public void addToDoListButton(ActionEvent actionEvent){
        ToDoList addedList = addToDoList();
        //append new ToDoList object to masterlist

    }

    private ToDoList addToDoList() {
        //initialize new List of Todo objects

        ToDoList addedList = new ToDoList();
        //get name from textfield controller.textField.getText()
        //if name exists tell them sorry name already exists.
        //initialize new titledpane with listname
        //set name, List, to ToDo object
        return addedList;
    }

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
    public void saveListsButton(ActionEvent actionEvent){
        saveLists();
    }

    public void saveLists() {
        //loop through MasterList,
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
    @FXML
    public void editTitleButton(ActionEvent actionEvent){
        ToDoList newToDo = editTitle();
    }

    private ToDoList editTitle() {
        //open window with text field for new title
        ToDoList newToDo;
        //modify ToDoList
        return newToDo = new ToDoList();
    }

    @FXML
    public void saveSingleListButton(ActionEvent actionEvent){
        ToDoList saveList = new ToDoList();
        //get ToDoList object from current titled pane window pass to savesinglelist function
        saveSingleList(saveList);
    }

    private void saveSingleList(ToDoList saveList) {
        //get ToDoList Object from opened titledpane
        //open prompt asking for filename
        //return ToDoList Object and filename to csvHandler.writeCSV
        //saveArchive()
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

    }
    
}
