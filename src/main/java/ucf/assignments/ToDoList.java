/*
 *  *  UCF COP3330 Summer 2021 Assignment 4
 *  *  Copyright 2021 Andres Rosales
 */
package ucf.assignments;

import java.util.LinkedList;
import java.util.List;

public class ToDoList {
    public List<ToDo> list;
    public String title;
    public String fileName;

    public ToDoList(){
        this(new LinkedList<ToDo>(), "", "");
    }

    public ToDoList(List initList, String initlistName, String initFileName){
        setlistName(initlistName);
        setfileName(initFileName);
    }

    private void setfileName(String initFileName) {
        this.fileName = initFileName;
    }

    private void setlistName(String initlistName) {
        this.title = initlistName;
    }

    public void addListElement(ToDo newToDo){
        list.add(newToDo);
    }

}
