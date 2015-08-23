package servlets;

import database.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 24.08.2015.
 */
@WebServlet("/allNotes")
public class AllNotesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBWorker dbWorker = (DBWorker)getServletContext().getAttribute("dbWorker");
        String username = (String)request.getSession().getAttribute("username");

        if(username != null){
            request.setAttribute("allNotes", dbWorker.selectAllNotes(username));
            getServletContext().getRequestDispatcher("/allNotes.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "You are not logged in!");
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }

    }
}
