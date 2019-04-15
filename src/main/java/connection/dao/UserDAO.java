package connection.dao;

import connection.model.User;

import java.net.ConnectException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDAO {

    private Connection connection;

    public UserDAO(Connection connection){
        this.connection=connection;
    }

    public List<User> getListUser(){
        List<User> userList = new LinkedList<>();

        String selectTableSQL = "Select * from TEST_USER order by user_id";

        try{
            try(Statement statement = connection.createStatement()){
                try(ResultSet rs = statement.executeQuery(selectTableSQL)){
                    while(rs.next()){
                        int id = (int) rs.getLong("user_id");
                        String fName = rs.getString("fname");
                        String lName = rs.getString("lname");

                        User user = new User((long) id, fName, lName);
                        userList.add(user);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public User getUser (int idd) {
        User user = null;

        String selectTableSQL = "Select * from TEST_USER where id=?";

        try {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(selectTableSQL)) {
                    while (resultSet.next()) {
                        int id = (int) resultSet.getLong("user_id");
                        String fName = resultSet.getString("fname");
                        String lName = resultSet.getString("lname");

                        user = new User((long) id, fName, lName);
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }return user;
    }

    public void deleteUser(int id){

        String SelectTableSQL = "Delete From TEST_USER where id=?";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SelectTableSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

    }catch (SQLException e){
        e.getErrorCode();}

    }


}
