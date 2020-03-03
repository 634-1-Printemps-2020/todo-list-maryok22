package test;

import main.java.*;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class TodoManagerTest {

    @org.junit.Test
    public void getTaskUser() throws ParseException, tacheException {
        TodoManager manager = new TodoManager();
        Person person = new Person("Kajic", "Mario");
        Task task = new Task("Première tâche","31/04/2020");
        manager.addTodo(person,task);
        //Test
        Assert.assertTrue(manager.getTaskUser(person).contains(task));
    }

    @Test
    public void cancelTask() throws ParseException, tacheException {
        TodoManager manager = new TodoManager();
        Person person = new Person("Kajic", "Mario");
        Task task = new Task("Première tâche","02/05/2020");
        manager.addTodo(person,task);
        manager.cancelTask(person,task);
        //Test
        Assert.assertEquals(Status.canceled, task.getStatus());
        System.out.println(task);
    }

    @Test
    public void editTaskDescription() throws ParseException, tacheException {
        TodoManager manager = new TodoManager();
        Person person = new Person("Kajic", "Mario");
        Task task = new Task("Première tâche","02/05/2020");
        manager.addTodo(person,task);
        manager.editTaskDescription(person,task,"NOUVEAUUUU");
        //Test
        Assert.assertEquals("NOUVEAUUUU", task.getDescription());
        System.out.println(task);
    }

    @Test
    public void closeTask() throws ParseException, tacheException {
        TodoManager manager = new TodoManager();
        Person person = new Person("Kajic", "Mario");
        Task task = new Task("Première tâche","02/05/2020");
        manager.addTodo(person,task);
        manager.closeTask(person,task);
        //Test
        Assert.assertEquals(Status.closed, task.getStatus());
        System.out.println(task);
    }

    @Test
    public void editTaskDate() throws ParseException, tacheException {
        TodoManager manager = new TodoManager();
        Person person = new Person("Kajic", "Mario");
        Task task = new Task("Première tâche","02/05/2020");
        manager.addTodo(person,task);
        manager.editTaskDate(person,task,"02/08/2020");
        //Test
        Date taskDate = new SimpleDateFormat("dd/MM/yyyy").parse("02/08/2020");
        Assert.assertEquals(taskDate, task.getDate());
        System.out.println(task);
    }

}