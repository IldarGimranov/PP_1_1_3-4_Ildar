package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

import static jm.task.core.jdbc.util.Util.closeConnection;

public class Main {
    private static final User user1 = new User("Sasha", "Alexandrov", (byte) 13);
    private static final User user2 = new User("Pasha", "Petrov", (byte) 3);
    private static final User user3 = new User("Misha", "Ksandrov", (byte) 21);
    private static final User user4 = new User("Dasha", "Ivanova", (byte) 55);

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        System.out.println("User с именем — " + user1.getName() + " добавлен в базу данных");
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        System.out.println("User с именем — " + user2.getName() + " добавлен в базу данных");
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        System.out.println("User с именем — " + user3.getName() + " добавлен в базу данных");
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        System.out.println("User с именем — " + user4.getName() + " добавлен в базу данных");
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        userService.removeUserById(1);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
        closeConnection();// реализуйте алгоритм здесь
    }
}
