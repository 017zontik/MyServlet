package repository;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> userList = new ArrayList<>();

    public UserRepository() {
        userList.add(new User("login1", "123456", "Vasia"));
        userList.add(new User("login2", "234567", "Petia"));
        userList.add(new User("login3", "345678", "Tanya"));

    }

    public User addUser(User user) {
        userList.add(user);
        return user;
    }


    public User getUser(String login) {

        for (User user : userList) {

            if (user.getLogin().equals(login)) {
                return user;
            }
            //найти юзера в списке с таким логином или вернуть null если его не существует
        }
        return null;

    }
}