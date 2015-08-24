package servlets;

import database.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/notes")
public class NotesServlet extends HttpServlet {

    DBWorker dbWorker;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("username") != null){
            updatePage(request, response);
        } else {
            request.setAttribute("message", "You are not logged in!");
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("username") != null){
            updatePage(request, response);
        } else {
            request.setAttribute("message", "You are not logged in!");
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }


    private void updatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        dbWorker = (DBWorker)getServletContext().getAttribute("dbWorker");

        //System.out.println(request.getParameter("name"));
        //System.out.println(request.getParameter("password"));

        String username = (String)request.getSession().getAttribute("username");

        //String password = request.getParameter("password");
        String newNote = request.getParameter("newNote");
        String radio = request.getParameter("number");
        String addButton = request.getParameter("addButton");
        String applyButton = request.getParameter("applyButton");
        String removeButton = request.getParameter("removeButton");
        String editButton = request.getParameter("editButton");
        String allNotesButton = request.getParameter("allNotesButton");

        if(radio != null) {

            request.setAttribute("activeRadio", Integer.parseInt(radio));
        }
        if(newNote != null && addButton != null){
            dbWorker.insertNote(username, newNote);
        }
        if(radio != null && removeButton != null) {
            dbWorker.removeNote(Integer.parseInt(radio));
        }

        if(radio != null && editButton != null) {
            request.setAttribute("editNote", dbWorker.selectNote(Integer.parseInt(radio)));
        }

        if(newNote != null && applyButton != null && radio != null){
            dbWorker.updateNote(newNote, Integer.parseInt(radio));
        }

        request.setAttribute("lastNotes", dbWorker.selectLastNotes(username));

        getServletContext().getRequestDispatcher("/notes.jsp").forward(request, response);
    }
}
