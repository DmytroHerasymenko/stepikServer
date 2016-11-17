package servlets;

import account.AccountService;

import javax.servlet.http.HttpServlet;

/**
 * Created by dima on 17.11.16.
 */
public class SignInServlet extends HttpServlet{
    public final AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }
}
