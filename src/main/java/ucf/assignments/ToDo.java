/*
 *  *  UCF COP3330 Summer 2021 Assignment 4
 *  *  Copyright 2021 Andres Rosales
 */
package ucf.assignments;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

public class ToDo {
    private final SimpleStringProperty dueDate = new SimpleStringProperty("");
    private final SimpleStringProperty description = new SimpleStringProperty("");
    private final SimpleStringProperty status = new SimpleStringProperty("");
    final static String DATE_FORMAT = "YYYY-MM-DD";

    public ToDo(){
        this("","","I");
    }
    public ToDo(String dueDate, String description){
        this(dueDate,description,"I");
    }
    public ToDo(String dueDate, String description, String status){
        setDueDate(dueDate);
        setDescription(description);
        setStatus(status);
    }
    public void setDueDate(String duedate){
        Boolean dateFormatCond = isValidFormat("yyyy-MM-dd", duedate);
        if(dateFormatCond){
            dueDate.set(duedate);
        }else{
            dueDate.set("YYYY-MM-DD");
        }
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

    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }
}
