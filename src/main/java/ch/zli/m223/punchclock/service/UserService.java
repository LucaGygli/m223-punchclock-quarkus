package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {
    @Inject
    private EntityManager userManager;

    @Transactional
    public User createUser(User user){
        userManager.persist(user);
        return user;
    }

    public List<User> findAll(){
        var query = userManager.createQuery("FROM User");
        return query.getResultList();
    }

    public User getUserById(Long Id){
        return userManager.find(User.class, Id);
    }

    @Transactional
    public void delete(Long id){
        User user = getUserById(id);
        userManager.remove(user);
    }

    @Transactional
    public User updateUser(User user){
        userManager.merge(user);
        return user;
    }
}