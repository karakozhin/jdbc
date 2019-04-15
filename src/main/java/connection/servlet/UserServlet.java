package connection.servlet;


import connection.dao.UserDAO;
import connection.db.OracleJDBC;
import connection.model.User;
import connection.service.UserService;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserServlet extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    OracleJDBC oracleJDBC = new OracleJDBC();
    UserDAO userDAO = null;
    try {
        userDAO = new UserDAO(oracleJDBC.getConnection());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    UserService userService = new UserService(userDAO);
    userService.getUserList();

    List<User> userList = this.getUserService();
    request.setAttribute("users", userList);
    request.getRequestDispatcher("users.jsp").forward(request, response);
}

    private List<User> getUserService() {
        OracleJDBC oracleJDBC = new OracleJDBC();
        UserDAO userDAO = null;
        try {
            userDAO = new UserDAO(oracleJDBC.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        userDAO.getListUser();

        UserService userService = new UserService(userDAO);
        return userService.getUserList();
    }

@Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String strId = request.getParameter("id");
    int id = Integer.valueOf(strId);

    OracleJDBC oracleJDBC = new OracleJDBC();
    UserDAO userDAO = null;
    try {
        userDAO = new UserDAO(oracleJDBC.getConnection());
    } catch (SQLException e) {
        e.printStackTrace();
    }
    UserService userService = new UserService(userDAO);
    userService.deleteUser(id);

    List<User> userList = this.getUserService();
    request.setAttribute("users", userList);
    request.getRequestDispatcher("users.jsp").forward(request, response);
}
}
