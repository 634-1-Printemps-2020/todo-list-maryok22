package main.java;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Task {

    private int id;
    private String description;
    private Date date;
    private Status status;
    private Resolution resolution;

    public Task(String description, String dateString) throws ParseException, tacheException {
        this.description = description;
        this.status = Status.open;
        this.resolution = Resolution.none;
        setDate(dateString);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String dateString) throws tacheException, ParseException {
        Date todayDate = new Date();
        Date taskDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        if(taskDate.compareTo(todayDate) > 0){
            this.date = taskDate;
            System.out.println("The task has been succesfully added.");
        }else{
            throw new tacheException("Can't add a Task with a negativ date");
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(description, task.description) &&
                Objects.equals(date, task.date) &&
                status == task.status &&
                resolution == task.resolution;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, date, status, resolution);
    }

    @Override
    public String toString() {
        return "Task : " + description +
                " " + date +
                " " + status +
                " " + resolution;
    }
}
