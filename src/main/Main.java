package main;

import main.java.Person;
import main.java.Task;
import main.java.TodoManager;
import main.java.tacheException;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException, tacheException {
        //Création Manager
        TodoManager manager = new TodoManager();

        Person person = new Person("Kajic", "Mario");
        Task task = new Task("Première tâche","02/05/2020");
        Task task1 = new Task("Deuxième tâche","06/05/2020");
        manager.addTodo(person,task);
        manager.addTodo(person,task1);

        Person person1 = new Person("Tokic", "Zoe");
        Task task2 = new Task("Coucou","20/06/2020");
        Task task3 = new Task("Cucustach","06/08/2020");
        manager.addTodo(person1,task2);
        manager.addTodo(person1,task3);

        manager.seeAll();

    }
}
