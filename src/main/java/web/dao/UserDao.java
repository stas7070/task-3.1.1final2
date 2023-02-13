package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void createUser(User user);

    User getUserById(Long id);

    void updateUser(Long id, User updateUser);

    void deleteUser(Long id);

    List<User> getAllUser();
}
