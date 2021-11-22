package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.service.UserService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.UserService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/user")
public class UserController {
    @Inject
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets List of Users")
    public List<User> list(){
        return userService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Gets single User")
    public User getSingleUser(@PathParam Long id){
        return userService.getUserById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Adds User")
    @PermitAll
    public User addUser(User user){
        return userService.createUser(user);
    }

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Deletes User")
    public void deleteUser(@PathParam Long id){
        userService.delete(id);
    }

    @PUT
    @Operation(summary = "Update User")
    public void updateUser(User user){
        userService.updateUser(user);
    }
}
