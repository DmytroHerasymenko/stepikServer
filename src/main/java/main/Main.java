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
import servlets.SignInServlet;
import servlets.SignUpServlet;
import servlets.UsersServlet;
import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

/**
 * Created by dima on 10.11.16.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        DBService dbService = new DBService();
        dbService.printConnectInfo();
        try {
            long userId = dbService.addUser("dmytro", "bart1");
            System.out.println("Added user id: " + userId);

            UsersDataSet dataSet = dbService.getUser(userId);
            System.out.println("User data set: " + dataSet);

        } catch (DBException e) {
            e.printStackTrace();
        }


        AccountService accServ = new AccountService();
        //accServ.addNewUser(new UserProfile("test"));
        //accServ.addNewUser(new UserProfile("admin"));

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new SignUpServlet(accServ)),"/signup");
        context.addServlet(new ServletHolder(new SignInServlet(accServ)),"/signin");

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
