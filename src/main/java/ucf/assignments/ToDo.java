/*
 *  *  UCF COP3330 Summer 2021 Assignment 4
 *  *  Copyright 2021 Andres Rosales
 */
package ucf.assignments;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.*;
public class ToDo {
    private final SimpleStringProperty dueDate = new SimpleStringProperty("");
    private final SimpleStringProperty description = new SimpleStringProperty("");
    private final SimpleStringProperty status = new SimpleStringProperty("");

    public ToDo(){
        this("","","I");
    }
    public ToDo(String dueDate, String description, String status){
        setDueDate(dueDate);
        setDescription(description);
        setStatus(status);
    }
    public void setDueDate(String duedate){
        dueDate.set(duedate);
    }
    public void setDescription(String descript){ description.set(descript);}
    public void setStatus(String stat){
        status.set(stat);
    }

    public SimpleStringProperty dueDateProperty(){
        return dueDate;
    }
    public SimpleStringProperty descriptionProperty(){
        return description;
    }
    public SimpleStringProperty statusProperty(){
        return status;
    }
}
