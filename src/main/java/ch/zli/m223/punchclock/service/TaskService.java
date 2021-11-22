package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TaskService {
    @Inject
    private EntityManager taskManager;

    @Transactional
    public Task createTask(Task task) {
        taskManager.persist(task);
        return task;
    }

    public List<Task> findAll() {
        var query = taskManager.createQuery("FROM Task");
        return query.getResultList();
    }

    public Task getTaskById(Long id) {
        return taskManager.find(Task.class, id);
    }

    @Transactional
    public void delete(Long id) {
        Task task = getTaskById(id);
        taskManager.remove(task);
    }

    @Transactional
    public Task updateTask(Task task) {
        taskManager.merge(task);
        return task;
    }
}
