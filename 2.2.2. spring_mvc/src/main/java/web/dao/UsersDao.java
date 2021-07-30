package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Component
@Transactional
public class UsersDao implements UsersDaoInterface{

    @PersistenceContext
    private EntityManager entityManager;
//    private List<User> userList;
//    private static int UpId;
//    {
//        userList = new ArrayList<>();
//        User user = new User(++UpId, "Mike", "s");
//        User user1 = new User(++UpId, "Jack", "a");
//        User user2 = new User(++UpId, "Bob", "b");
//        User user3 = new User(++UpId, "Gabe", "Newel");
//        userList.add(user);
//        userList.add(user1);
//        userList.add(user2);
//        userList.add(user3);
//    }

    public List<User> getUserList() {
//        session.beginTransaction();
//        List<User> userList = session.createQuery("from User").list();
//        session.getTransaction().commit();
        return entityManager.createQuery("from User").getResultList();
    }

    public User getUserById(int id) {
//        session.beginTransaction();
//        User user = session.get(User.class, id);
//        session.getTransaction().commit();
         TypedQuery<User> u = entityManager.createQuery("select u User where u.id = :id", User.class);
         u.setParameter("id", id);
        return u.getResultList().stream().findAny().orElse(null);

    }


    public void save(User user) {
//        session.beginTransaction();
//        session.save(user);
//        session.getTransaction().commit();

        entityManager.persist(user);
    }

    public void update(int id, User user) {
//        session.beginTransaction();
//        User userToUpdate = session.get(User.class, id);
//        userToUpdate.setSureName(user.getSureName());
//        userToUpdate.setName(user.getName());
//        session.saveOrUpdate(userToUpdate);
//        session.getTransaction().commit();
    }

    public void delete(int id) {
        User manage = entityManager.find(User.class, id);
        entityManager.remove(manage);
    }
}
