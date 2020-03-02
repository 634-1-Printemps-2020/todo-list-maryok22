package test;

import main.java.*;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;

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
}