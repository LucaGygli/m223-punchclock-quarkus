package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.ToDo;
import ch.zli.m223.punchclock.service.ToDoService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;



@Path("/todos")
public class ToDoController {

    @Inject
    ToDoService toDoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ToDo> list() {
        return toDoService.findAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ToDo addToDo(ToDo todo){
        return toDoService.createToDo(todo);
    }
}
