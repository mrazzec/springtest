package by.tms.springtest2.dao;

import by.tms.springtest2.entity.User;
import by.tms.springtest2.exceptions.UserAuthorizationException;
import by.tms.springtest2.exceptions.UserDoesntExistException;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Logger logger = Logger.getLogger(UserDaoImpl.class.getName());

    public void saveUser(User user) {
        logger.info("save user" + user);
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public List<User> findAllUsers() {
        logger.info("find users findAllUsers");
        return new ArrayList<>();
    }

    @Override
    public User findUser(User user) throws UserAuthorizationException, UserDoesntExistException {

        List<User> users = new ArrayList<>();

        users = sessionFactory.getCurrentSession()
                .createQuery("from User where email=?1")
                .setParameter(1, user.getEmail())
                .list();

        if (users.size() > 0) {
            for (User userFromDb : users) {
                if (userFromDb.getPass().equals(user.getPass())) {
                    return userFromDb;
                }
            }
            throw new UserAuthorizationException("incorrect password");
        } else {
            logger.info("user email: " + user.getEmail() + " doesnt exist in db");
            throw new UserDoesntExistException("email doesnt exist");
        }
    }

    private User md5User(User user) {
        String s = DigestUtils.md5DigestAsHex((user.getEmail() + user.getPass()).getBytes()) + "@qQ1";
        user.setPass(s);
        return user;
    }
}
