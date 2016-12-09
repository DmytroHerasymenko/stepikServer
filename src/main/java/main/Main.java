package main;

import account.AccountService;
import dbService.DBService;
import dbService.DBServiceImpl;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInServlet;
import servlets.SignUpServlet;

/**
 * Created by dima on 10.11.16.
 */
public class Main {
    public static void main(String[] args) throws Exception {

        AccountService accServ = new AccountService();
        DBService dbService = new DBServiceImpl();
        //accServ.addNewUser(new UserProfile("test"));
        //accServ.addNewUser(new UserProfile("admin"));

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new SignUpServlet(accServ, dbService)),"/signup");
        context.addServlet(new ServletHolder(new SignInServlet(accServ, dbService)),"/signin");

        ResourceHandler resHandler = new ResourceHandler();
        resHandler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resHandler,context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.start();
        java.util.logging.Logger.getGlobal().info("Server started");
        //dbServiceImpl = new DBServiceImpl();
        /*DBServiceImpl dbServiceImpl = new DBServiceImpl();
        dbServiceImpl.printConnectInfo();
        try {
            long userId = dbServiceImpl.addUser("dmytro", "bart1");
            System.out.println("Added user id: " + userId);

            UsersDataSet dataSet = dbServiceImpl.getUser(userId);
            System.out.println("User data set: " + dataSet);

        } catch (DBException e) {
            e.printStackTrace();
        }*/
        server.join();
    }
}
