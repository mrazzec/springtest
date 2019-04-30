package by.tms.springtest2.dao;

import by.tms.springtest2.entity.User;
import by.tms.springtest2.exceptions.UserAuthorizationException;
import by.tms.springtest2.exceptions.UserDoesntExistException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private List<User> userList = new ArrayList<>();
    private Logger logger = Logger.getLogger(UserDaoImpl.class.getName());

    public void saveUser(User user) {
        logger.info("save user" + user);
        userList.add(user);
    }

    public List<User> findAllUsers() {
        logger.info("find users findAllUsers");
        return userList;
    }

    @Override
    public User findUser(User user) throws UserAuthorizationException, UserDoesntExistException {

        for (User currentUser : userList) {

            if (currentUser.getEmail().equals(user.getEmail())) {
                if (currentUser.getPass().equals(user.getPass())) {
                    return currentUser;
                } else {
                    logger.info(currentUser + " password incorrect");
                    throw new UserAuthorizationException("password incorrect");
                }
            }
        }
        logger.info("user email: " + user.getEmail() + " doesnt exist in db");
        throw new UserDoesntExistException("email doesnt exist");
    }
}
