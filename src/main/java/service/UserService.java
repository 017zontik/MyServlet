package service;

import entity.User;
import repository.UserRepository;

import javax.servlet.http.HttpServletRequest;

public class UserService {
    private static final UserService instance = new UserService();
    private UserRepository userRepository = new UserRepository();


    public User login (String login, String password) {


        User user = userRepository.getUser(login);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
       return null;
    }

    public User addUser(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        User user = userRepository.addUser(new User(login,password,username));
        return user;
    }

    public static UserService getInstance(){
        return instance;
    }


}
