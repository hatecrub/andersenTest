package servlets;

import database.DBWorker;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    private ServletContext context = null;


    public void contextInitialized(ServletContextEvent servletContextEvent) {
        context = servletContextEvent.getServletContext();
        try {
            DBWorker dbWorker = new DBWorker();
            context.setAttribute("dbWorker", dbWorker);
        } catch (Exception ex) {
            System.out.println(
                    "Couldn’t connect to database: " + ex.getMessage());
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        context = servletContextEvent.getServletContext();
        DBWorker dbWorker = (DBWorker)context.getAttribute("dbWorker");
        dbWorker.remove();
        context.removeAttribute("bookDB");
    }
}
