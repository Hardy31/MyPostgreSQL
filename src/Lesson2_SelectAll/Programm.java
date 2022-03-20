package Lesson2_SelectAll;

import java.sql.*;

;

public class Programm {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/sammy";
//    static final String DB_URL = "jdbc:postgresql://localhost/sammy";
    static final String USER = "sammy";
    static final String PASS = "12345";


    public static void main(String[] args) throws SQLException {

        final Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);

        try(PreparedStatement statement = connection.prepareStatement("SELECT *FROM users WHERE id = (?)")){

            statement.setInt(1,7);

            final ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                String byName = "login: " + resultSet.getString("login");
                String byIdex = ", password: " + resultSet.getString(3) + " ;";
                System.out.print (byName);
                System.out.println(byIdex);
            }
        }finally {
            connection.close();
        }


    }
}
