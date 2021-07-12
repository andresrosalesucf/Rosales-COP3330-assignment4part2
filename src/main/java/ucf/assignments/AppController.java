/*
 *  *  UCF COP3330 Summer 2021 Assignment 4
 *  *  Copyright 2021 Andres Rosales
 */
package ucf.assignments;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class AppController implements Initializable {



    @FXML private TableView<ToDo> tableView;
    @FXML private CheckBox completedCheckbox;
    @FXML private CheckBox incompleteCheckbox;
    @FXML private TableColumn descriptionColumn;
    @FXML private TableColumn dueDateColumn;
    @FXML private TableColumn statusColumn;
    @FXML private TextField fileName;
    @FXML private TextField loadList;
    @FXML private TextField duedateTextField;
    @FXML private TextField descriptionTextField;

    //Table view has an editable configuration which i will use,
    // hence no 'edit due date' or 'edit description' button


    @FXML
    public void loadListButton(javafx.event.ActionEvent actionEvent){
        loadList();
    }

    private void loadList() {
        ObservableList<ToDo> todos = tableView.getItems();
        /*try {
            Popup popup = new Popup();
            CustomController controller = new CustomController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoadContinue.fxml"));
            loader.setController(controller);
            popup.getContent().add((Parent)loader.load());
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/
        //get filename from textfield, pass to csvHandler to read from.
        //output is a list of ToDos
        todos.clear();
        todos.addAll(csvHandler.readCSVList(loadList.getText()));
    }

    @FXML
    protected void saveListButton(javafx.event.ActionEvent actionEvent){
        saveList();
    }

    public void saveList() {
        //make sure filename isn't empty before saving to file.
        if(fileName.getText() == ""){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid Filename");
            alert.setHeaderText("Filename cannot be empty!");
            alert.show();
        }else {
            //call csvHandler for turning list into a .csv file.
            csvHandler.writeCSV(tableView.getItems(), fileName.getText());
        }
    }

    @FXML
    public void addToDoButton(javafx.event.ActionEvent actionEvent){
        addToDo();
    }

    public void addToDo() {
        //init observable list from tableview
        ObservableList<ToDo> todos = tableView.getItems();
        //cut description field to 256 characters
        String newDescription;
        if(descriptionTextField.getText().length() > 256) {
            newDescription = descriptionTextField.getText().substring(0, 256);
        }else{
            newDescription = descriptionTextField.getText();
        }
        //check date entered is valid format
        ToDo addTodo = new ToDo(duedateTextField.getText(), newDescription);
        todos.add(addTodo);
    }
    @FXML
    public void removeToDoButton(javafx.event.ActionEvent actionEvent){
        removeToDo();
    }

    public void removeToDo() {
        //get name of list from currently opened titledpane in accordian
        //use remove(name) to remove a list from MasterList
        //update scene
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
    }
    public void clearListButton(javafx.event.ActionEvent actionEvent) {
        clearList();
    }
    public void clearList(){
        ObservableList<ToDo> todos = tableView.getItems();
        todos.clear();
    }
    //here I will add listener for checkboxes, completed and incomplete
    //when unchecked, i will loop through list and if status matches unselected item, it is removed from list
    //redisplay tableview



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<ToDo> todos = tableView.getItems();

        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<ToDo, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<ToDo, String> event) {
                        ((ToDo) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())
                        ).setDescription(event.getNewValue());
                    }
                }
        );
        dueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        /*textField.setOnAction(event -> {
                    commitEdit(textField.getText());
                    event.consume();
                }
                textField.setOnKeyPressed(event -> {
                            if (event.getCode() == KeyCode.ESCAPE) {
                                cancelEdit();
                                event.consume();
                            }
                        }*/
        dueDateColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<ToDo, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<ToDo, String> event) {
                        ((ToDo) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())
                        ).setDueDate(event.getNewValue());
                    }
                }
        );
        statusColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        statusColumn.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<ToDo, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<ToDo, String> event) {
                        ((ToDo) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())
                        ).setStatus(event.getNewValue());
                    }
                }
        );
        duedateTextField.setText("2021-12-13");
        descriptionTextField.setText("What what in the butt?");
        for(int i=0; i<100; i++){

            addToDo();
        }
    }

}
