package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Task;
import ch.zli.m223.punchclock.domain.ToDo;
import ch.zli.m223.punchclock.service.TaskService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tasks")
public class TaskController {

    @Inject
    TaskService taskService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> list() {
        return taskService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Task addTask(Task task){
        return taskService.createTask(task);
    }
}
