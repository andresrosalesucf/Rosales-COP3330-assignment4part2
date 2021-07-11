/*
 *  *  UCF COP3330 Summer 2021 Assignment 4
 *  *  Copyright 2021 Andres Rosales
 */
package ucf.assignments;

import javafx.beans.Observable;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
public class csvHandler {


    public static List readCSVList(String filename){
        //initialize list to be returned
        LinkedList<ToDo> retrievedToDoList =  new LinkedList<>();
        filename = filename + ".csv";
        //try and open file
        try{
            //create input stream so csvparser can read
            InputStream inputStream       = new FileInputStream(filename);
            CSVParser csvParser = CSVFormat.DEFAULT.parse(new InputStreamReader(inputStream));
            int i = 0;
            for (CSVRecord record : csvParser) {
                //add new ToDo object to list
                retrievedToDoList.add(new ToDo(record.get(0), record.get(1), record.get(2)));
                i++;
            }
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred, file not found.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return retrievedToDoList;
    }

    public static void writeCSV(ObservableList<ToDo> SavethisList, String fileName){
        createFile(fileName);
        try (FileWriter listWriter = new FileWriter(fileName + ".csv")) {
           //loop through todolist and append to file //listWriter.write(String)
            for(int i=0; i<SavethisList.size(); i++){
                listWriter.write( SavethisList.get(i).dueDateProperty().get());
                listWriter.write(",");
                listWriter.write( SavethisList.get(i).descriptionProperty().get());
                listWriter.write(",");
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
