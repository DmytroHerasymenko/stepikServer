package servlets;

import account.AccountService;
import account.UserProfile;
import com.google.gson.Gson;

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

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        /*String login = request.getParameter("login");
        String pass = request.getParameter("password");
        accountService.getUserByLogin(login);*/


        response.setStatus(HttpServletResponse.SC_OK);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        //UserProfile profile = accountService.getUserByLogin(login);

        UserProfile profile = new UserProfile(login,pass, "");


        if (profile.getLogin().equals(accountService)) {
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
