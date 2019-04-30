package by.tms.springtest2.service;

import by.tms.springtest2.entity.User;
import by.tms.springtest2.exceptions.UserFindServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

    public void saveUser(User user);

    public boolean findUser(User user,  HttpServletRequest request) throws UserFindServiceException;

    public List<User> findAll();
}
