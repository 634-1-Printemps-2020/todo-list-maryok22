package main.java;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TodoManager {

    private HashMap<Person, List<Task>> todolst = new HashMap<>();

    public TodoManager() {
        this.todolst = new HashMap<>();
    }

    public List<Task> getTaskUser(Person person){
        return todolst.get(person);
    }

    public void addTodo(Person person, Task task){
        if (!todolst.containsKey(person)){
            List<Task> list = new ArrayList<>();
            todolst.put(person,list);
        }
        todolst.get(person).add(task); //Ajout de la tâche
    }

    //On par du principe que le Task en paramètre est une copie
    //Sinon le Task.set() aurait suffit
    public void cancelTask(Person person, Task task){
        if (todolst.get(person).contains(task)){
            Task taskToModify = todolst.get(person).get(todolst.get(person).indexOf(task));
            taskToModify.setStatus(Status.canceled);
        }
    }

    public void closeTask(Person person, Task task){
        if (todolst.get(person).contains(task)){
            Task taskToModify = todolst.get(person).get(todolst.get(person).indexOf(task));
            taskToModify.setStatus(Status.closed);
        }
    }

    public void openTask(Person person, Task task){
        if (todolst.get(person).contains(task)){
            Task taskToModify = todolst.get(person).get(todolst.get(person).indexOf(task));
            taskToModify.setStatus(Status.open);
        }
    }

    public void editTaskDescription(Person person, Task task, String description){
        if (todolst.get(person).contains(task)){
            Task taskToModify = todolst.get(person).get(todolst.get(person).indexOf(task));
            taskToModify.setDescription(description);
        }
    }

    public void editTaskDate(Person person, Task task, String date) throws ParseException, tacheException {
        if (todolst.get(person).contains(task)){
            Task taskToModify = todolst.get(person).get(todolst.get(person).indexOf(task));
            taskToModify.setDate(date);
        }
    }


    @Override
    public String toString() {
        return "TodoManager{" +
                "todolst=" + todolst +
                '}';
    }
}
