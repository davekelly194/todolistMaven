package com.todolist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class TaskService {
    ObjectMapper mapper = new ObjectMapper();

    public String convertTaskListToJson(List<Task> taskList){
        try {
            return mapper.writeValueAsString(taskList);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public Task decodeTaskFromJson(String taskJson){
        System.out.println(taskJson);
        try {
            return mapper.readValue(taskJson, Task.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public Task getTask(String id){
        for (Task taskIt : TodolistApplication.taskList) {
            if (taskIt.getId().equals(id)) {
                return taskIt;
            }
        }
        return null;
    }

    public List<Task> getAllTasks(){
        return TodolistApplication.taskList;
    }

    public boolean deleteTask(String id){
        return TodolistApplication.taskList.remove(getTask(id));
    }

    public boolean saveTask(Task task){
        try{
           return TodolistApplication.taskList.add(task);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
