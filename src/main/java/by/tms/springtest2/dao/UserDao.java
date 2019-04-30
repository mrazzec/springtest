package by.tms.springtest2.dao;

import by.tms.springtest2.entity.User;
import by.tms.springtest2.exceptions.UserAuthorizationException;
import by.tms.springtest2.exceptions.UserDoesntExistException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserDao {

    public void saveUser(User user);

    public List<User> findAllUsers();

    public User findUser(User user) throws UserAuthorizationException, UserDoesntExistException;
}
