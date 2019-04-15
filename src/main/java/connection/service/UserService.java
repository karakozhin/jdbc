package connection.service;

import connection.dao.UserDAO;
import connection.model.User;

import java.util.List;

public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO=userDAO;
    }

    public List<User> getUserList(){
        List<User> userList = this.userDAO.getListUser();
        return userList;
    }

    public User getUserById(int id){
        return (User) this.userDAO.getUser(id);
    }

    public void deleteUser(int id){
        this.userDAO.deleteUser(id);
    };


}
