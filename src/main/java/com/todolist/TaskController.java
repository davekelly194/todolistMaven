package com.todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    TaskService taskService = new TaskService();

    @RequestMapping(method=RequestMethod.GET, value="/getTasks")
    public @ResponseBody String getTask(@RequestParam(value="id", required=false) String id) {
        List<Task> listToReturn = new ArrayList<Task>();
        if(id!=null && id.length() > 0){
            listToReturn.add(taskService.getTask(id));
        }
        else{
            listToReturn.addAll(taskService.getAllTasks());
        }
        return taskService.convertTaskListToJson(listToReturn);
    }

    @RequestMapping(method = RequestMethod.POST, value="/addTasks")
    public void postTask(@RequestBody Task task) {
        taskService.saveTask(task);
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/deleteTask")
    public @ResponseBody void deleteTask(@RequestParam(value="id", required=true) String id) {
        taskService.deleteTask(id);
    }

}