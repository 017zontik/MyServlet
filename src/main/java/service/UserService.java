package service;

import entity.User;
import repository.UserRepository;

import javax.servlet.http.HttpServletRequest;

public class UserService {
    private static final UserService instance = new UserService();
    private final UserRepository userRepository;


    private UserService() {
        userRepository = new UserRepository();
    }

    public User login (String login, String password) {

        User user = userRepository.getUser(login);
        if(user != null && user.getPassword().equals(password)){
            return user;
        }
       return null;
    }

    public User addUser(String login,String password, String username) {

        User user = new User(login, password, username);
        userRepository.addUser(user);
        return user;
    }

    public static UserService getInstance(){
        return instance;
    }


}
