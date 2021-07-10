/*
 *  *  UCF COP3330 Summer 2021 Assignment 4
 *  *  Copyright 2021 Andres Rosales
 */

import ucf.assignments.AppController;
import ucf.assignments.App;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class AppControllerTest {

    @Test
    public void testAddToDoList(){
        //instantiate 2 lists, one with target item missing
        //run addtodo on list with one short
        //compare 2 lists
    }
    @Test
    public void test_removeToDoList(){
        //instantiate 2 lists, one with target item missing
        //run removeToDoList with item name
        //compare lists for equality.
    }
    @Test
    public void test_addToDo(){
        //init a new List
        //set text to textfield
        //run addToDo
        //check that List contains new ToDo item
    }
    @Test
    public void editTitle(){
        //init a ToDoList
        // init a similar ToDoList only with a different title
        //run editTitle(object)
        //compare two objects for equality
    }

}
