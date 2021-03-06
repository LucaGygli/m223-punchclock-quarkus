package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.ToDo;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ToDoService {
    @Inject
    private EntityManager toDoManager;

    public ToDo getToDoById(Long id) {
        return toDoManager.find(ToDo.class, id);
    }

    @Transactional
    public ToDo addToDo(ToDo toDo) {
        toDoManager.persist(toDo);
        return toDo;
    }

    @Transactional
    public void deleteToDo(Long id) {
        ToDo task = getToDoById(id);
        toDoManager.remove(task);
    }

    @Transactional
    public ToDo updateToDo(ToDo toDo) {
        toDoManager.merge(toDo);
        return toDo;
    }

    public List<ToDo> getAllToDos() {
        var query = toDoManager.createQuery("FROM ToDo");
        return query.getResultList();
    }

}
