package servlets;

import account.AccountService;
import account.UserProfile;
import com.google.gson.Gson;
import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;
import main.Main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dima on 17.11.16.
 */
public class SignUpServlet extends HttpServlet {
    private  final AccountService accountService;
    //private DBService dbService = new DBService();

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

            response.setStatus(HttpServletResponse.SC_OK);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        if(!login.isEmpty() || !pass.isEmpty()) {
            /*try {
                long userId = dbService.addUser(login, pass);
                UsersDataSet user = dbService.getUser(userId);
                accountService.addNewUser(new UserProfile(user.getName(),user.getPassword(), ""));
            } catch (DBException e) {
                e.printStackTrace();
            }*/

            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }


}
