package main.java;

import java.text.ParseException;
import java.util.*;

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

    public void closeTask(Person person, Task task) {
        if (todolst.get(person).contains(task)) {
            Task taskToModify = todolst.get(person).get(todolst.get(person).indexOf(task));
            taskToModify.setStatus(Status.closed);
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

    public void seeAll(){
        Iterator it = todolst.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }

        for (Integer key : map.keySet()) {
            System.out.println("Key = " + key);

    }

    @Override
    public String toString() {
        return "TodoManager{" +
                "todolst=" + todolst +
                '}';
    }

}
