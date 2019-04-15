package connection;

import connection.dao.UserDAO;
import connection.db.OracleJDBC;
import connection.model.User;
import connection.service.UserService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection connection = new OracleJDBC().getConnection();

        UserDAO userDAO = new UserDAO(connection);

        UserService userService = new UserService(userDAO);

        List<User> userList = userService.getUserList();

        for (User user: userList){
            System.out.println(user.getfName());
        }



    }
}
