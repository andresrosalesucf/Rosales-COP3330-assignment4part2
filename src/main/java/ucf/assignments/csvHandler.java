/*
 *  *  UCF COP3330 Summer 2021 Assignment 4
 *  *  Copyright 2021 Andres Rosales
 */
package ucf.assignments;

import javafx.beans.Observable;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class csvHandler {


    public List readCSVList(String filename){
        LinkedList<ToDo> retrievedToDoList =  new LinkedList<>();
        //try and open file
        //if not existent return empty List
        //use csv parser to create todos List until empty String
        //format listname, duedate, description, completion status
        // give listname to Map key, value ToDo Object
        return retrievedToDoList;
    }

    public static void writeCSV(ObservableList<ToDo> SavethisList, String fileName){

        createFile(fileName);
        try (FileWriter listWriter = new FileWriter(fileName + ".csv")) {
           //loop through todolist and append to file //listWriter.write(String)
            for(int i=0; i<SavethisList.size(); i++){
                listWriter.write( SavethisList.get(i).dueDateProperty().get());
                listWriter.write(", ");
                listWriter.write( SavethisList.get(i).descriptionProperty().get());
                listWriter.write(", ");
                listWriter.write( SavethisList.get(i).statusProperty().get());
                listWriter.write("\n");
            }
        }catch (IOException e) {
            System.out.println("An error occurred writing to file.");
            e.printStackTrace();
        }
    }
    public static void createFile(String fileName){
        try {
            File myObj = new File(fileName + ".csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred creating file.");
            e.printStackTrace();
        }
    }
}
