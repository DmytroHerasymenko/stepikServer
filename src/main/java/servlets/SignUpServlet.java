package servlets;

import account.AccountService;
import account.UserProfile;
import dbService.DBException;
import dbService.DBService;

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
    private DBService dbService;


    public SignUpServlet(AccountService accountService, DBService dbService) {
        this.accountService = accountService;
        this.dbService = dbService;
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
            try {
                accountService.addNewUser(new UserProfile(login, pass));
                long userId = dbService.addUser(accountService.getUserByLogin(login).getLogin(),accountService.getUserByLogin(login).getPassword());
                //UsersDataSet user = dbServiceImpl.getUser(userId);
                //accountService.addNewUser(new UserProfile(user.getName(), user.getPassword()));
                response.getWriter().println("signUp: " + dbService.getUser(userId));
            } catch (DBException e) {
                e.printStackTrace();}

            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            //response.sendRedirect(request.getContextPath()+"/signIn.html");

        }
    }


}
