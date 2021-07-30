package web.services;

import web.dao.UsersDao;
import web.dao.UsersDaoInterface;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UsersDaoInterface usersDaoInterface = new UsersDao();
    @Override
    @Transactional
    public List<User> getUserList() {

        return usersDaoInterface.getUserList();
    }

    @Override
    public User getUserById(int id) {
        return usersDaoInterface.getUserById(id);
    }

    @Override
    public void save(User user) {
        usersDaoInterface.save(user);
    }

    @Override
    public void update(int id, User user) {
        usersDaoInterface.update(id, user);
    }

    @Override
    public void delete(int id) {
        usersDaoInterface.delete(id);

    }
}
