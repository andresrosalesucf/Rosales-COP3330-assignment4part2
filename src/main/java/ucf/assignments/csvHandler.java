/*
 *  *  UCF COP3330 Summer 2021 Assignment 4
 *  *  Copyright 2021 Andres Rosales
 */
package ucf.assignments;

import java.util.*;

public class csvHandler {


    public ToDoList readCSVList(String filename){
        ToDoList retrievedToDoList = new ToDoList();
        //try and open file
        //if not existent return empty List
        //use csv parser to create todos List until empty String
        //format listname, duedate, description, completion status
        // give listname to Map key, value ToDo Object
        return retrievedToDoList;
    }

    public void writeCSV(ToDoList SavethisList, String fileName){

        //check if file exists
        //if does, ask user if they would like to overwrite
        //if file doesnt exist or if yes, create file
        //save list Name first line
        //every line after that loops through list of ToDos, param
    }
    public void createFile(String fileName){
        //try and create new file
        //if file success print file created
        //if not print file already exists
        //catch ioexception print error
    }
}
