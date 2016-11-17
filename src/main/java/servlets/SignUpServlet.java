package servlets;

import account.AccountService;

import javax.servlet.http.HttpServlet;

/**
 * Created by dima on 17.11.16.
 */
public class SignUpServlet extends HttpServlet {
    private  final AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }
}
