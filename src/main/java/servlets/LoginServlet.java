package servlets;

import database.DBWorker;
import database.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private DBWorker dbWorker;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dbWorker = (DBWorker)getServletContext().getAttribute("dbWorker");


        String username = request.getParameter("name");
        String password = request.getParameter("password");


        if(checkLogin(username, password, request)) {
            request.getSession().setAttribute("username", username);
            response.sendRedirect("/notes");
            //getServletContext().getRequestDispatcher("/notes").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    private boolean checkLogin(String username, String password, HttpServletRequest req) {
        ArrayList<User>users = dbWorker.selectUsers();

        boolean usernameFlag = false;
        boolean passwordFlag = false;

        for (User user : users) {
            if(username.equals(user.getUsername())){
                if(password.equals(user.getPassword())){

                    return true;
                } else {
                    passwordFlag = false;
                }
            } else {
                usernameFlag = false;
            }
        }

        if(!usernameFlag || !passwordFlag) {
            req.setAttribute("message", "Wrong login or password!");
            return false;
        } else {
            return true;
        }

    }
}
