package main;

import account.AccountService;
import account.UserProfile;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SessionsServlet;
import servlets.UsersServlet;

/**
 * Created by dima on 10.11.16.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AccountService accServ = new AccountService();
        accServ.addNewUser(new UserProfile("test"));
        accServ.addNewUser(new UserProfile("admin"));


        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new UsersServlet(accServ)),"/api/v1/users");
        context.addServlet(new ServletHolder(new SessionsServlet(accServ)),"/api/v1/sessions");

        ResourceHandler resHandler = new ResourceHandler();
        resHandler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resHandler,context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        server.join();
    }
}
