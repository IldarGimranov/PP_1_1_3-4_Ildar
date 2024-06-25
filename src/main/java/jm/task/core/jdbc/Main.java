package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    private static final User user1 = new User("Sasha", "Alexandrov", (byte) 13);
    private static final User user2 = new User("Pasha", "Petrov", (byte) 3);
    private static final User user3 = new User("Misha", "Ksandrov", (byte) 21);
    private static final User user4 = new User("Dasha", "Ivanova", (byte) 55);
    public static void main(String[] args) {
        Util.getConnect();
        //UserDao userDao = new UserDaoJDBCImpl();
        UserService userDao = new UserServiceImpl();

        userDao.createUsersTable();

//        userDao.saveUser("Name1", "LastName1", (byte) 20);
//        userDao.saveUser("Name2", "LastName2", (byte) 25);
//        userDao.saveUser("Name3", "LastName3", (byte) 31);
//        userDao.saveUser("Name4", "LastName4", (byte) 38);

        userDao.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userDao.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userDao.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userDao.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            System.out.println("User с именем — " + user.getName() + " добавлен в базу данных");
        }
        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();// реализуйте алгоритм здесь
    }
}
