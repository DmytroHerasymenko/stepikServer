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
public class SignUpServlet extends HttpServlet {
    private  final AccountService accountService;

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
            accountService.addNewUser(new UserProfile(login, pass, ""));
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }


}
