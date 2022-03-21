package Lesson3_DAO;

import Lesson3_DAO.jdbc.UserDAO;
import Lesson3_DAO.model.User;
import java.sql.*;


public class Programm {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/sammy";
//    static final String DB_URL = "jdbc:postgresql://localhost/sammy";
    static final String USER = "sammy";
    static final String PASS = "12345";


    public static void main(String[] args) throws SQLException {

        final Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

        User newUser = new User();
        newUser.setLogin("newDaoUser");
        newUser.setPassword("98789");
        newUser. setRole(new User.Role(1, "admin"));
        System.out.println(" До записи в БД - id - " +newUser.getId() +  ", login - " + newUser.getLogin() +  ", Пароль - " + newUser.getPassword()+  ", Роль - " + newUser.getRole().getName()  );
        new UserDAO(connection).create(newUser);

        User userF = new UserDAO(connection).read("newDaoUser");
        System.out.println("id - " +userF.getId()  +  ", login - " + userF.getLogin()+  ", Пароль - " + userF.getPassword()+  ", Роль - " + userF.getRole(). getName()  );

        userF.setPassword("112211");

        if (new UserDAO(connection).update(userF)){
            System.out.println("Обновление проведено");
        };

        User userRead = new UserDAO(connection).read("newDaoUser");
        System.out.println("id - " +userRead.getId()  +  ", login - " + userRead.getLogin()+  ", Пароль - " + userRead.getPassword()+  ", Роль - " + userRead.getRole(). getName()  );


//        if (new UserDAO(connection).delete(userRead)){      //работает
//            System.out.println("Юзер удален");
//        };


    }

}
