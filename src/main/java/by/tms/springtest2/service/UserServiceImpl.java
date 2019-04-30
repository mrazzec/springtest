package by.tms.springtest2.service;

import by.tms.springtest2.dao.UserDaoImpl;
import by.tms.springtest2.entity.User;
import by.tms.springtest2.exceptions.UserAuthorizationException;
import by.tms.springtest2.exceptions.UserDoesntExistException;
import by.tms.springtest2.exceptions.UserFindServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = Logger.getLogger(UserDaoImpl.class.getName());

    @Autowired
    private UserDaoImpl userDao;

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public boolean findUser(User user,  HttpServletRequest request) throws UserFindServiceException {

        try {
            User currentUser = userDao.findUser(user);
            request.getSession().setAttribute("user", currentUser);
            logger.info(currentUser + "found and added in session");
            return true;
        } catch (UserAuthorizationException | UserDoesntExistException e) {
            throw new UserFindServiceException(e.getMessage());
        }
    }

    public List<User> findAll() {
        return userDao.findAllUsers();
    }
}
