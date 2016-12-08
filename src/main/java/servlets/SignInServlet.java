package servlets;

import account.AccountService;
import account.UserProfile;
import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dima on 17.11.16.
 */
public class SignInServlet extends HttpServlet{
    public final AccountService accountService;
    public DBService dbService;

    public SignInServlet(AccountService accountService, DBService dbService) {
        this.accountService = accountService;
        this.dbService = dbService;
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        //accountService.getUserByLogin(login);


        response.setStatus(HttpServletResponse.SC_OK);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        /*UsersDataSet user = null;
        try {
            user = dbService.getUserByLogin(login);
        } catch (DBException e) {
            e.printStackTrace();
        }*/
        //accountService.getUserByLogin(user.getName());
            //UserProfile profile = accountService.getUserByLogin(login);
        UserProfile userProfile = null;
        try {
            userProfile = accountService.getUserByLogin(dbService.getUserByLogin(login).getName());
        } catch (DBException e) {
            e.printStackTrace();
        }
        if (!userProfile.getLogin().isEmpty()) {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("Authorized: " + login);
                response.setStatus(HttpServletResponse.SC_OK);
                return;
            } else{
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().println("Unauthorized");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }





    }
}
