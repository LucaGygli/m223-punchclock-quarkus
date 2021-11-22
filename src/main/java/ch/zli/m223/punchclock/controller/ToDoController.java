package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.ToDo;
import ch.zli.m223.punchclock.service.ToDoService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;



@Path("/todos")
public class ToDoController {

    @Inject
    ToDoService toDoService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "gets Single ToDo by its Id")
    public ToDo getSingleToDo(@PathParam Long id) {
        return toDoService.getToDoById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Adds Todo")
    public ToDo addToDo(ToDo todo){
        return toDoService.addToDo(todo);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete Todo")
    public void deleteToDo(@PathParam Long id){
        toDoService.deleteToDo(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets List of all ToDos")
    public List<ToDo> list() {
        return toDoService.getAllToDos();
    }
    @PUT
    @Operation(summary = "Updates TODO")
    public void updateToDO(ToDo toDo){
        toDoService.updateToDo(toDo);
    }
}
