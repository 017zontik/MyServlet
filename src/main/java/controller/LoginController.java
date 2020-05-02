package controller;

import entity.User;
import repository.UserRepository;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {

   UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user =  UserService.getInstance().login(login, password);
        if(user == null){
            getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);



            //redirect to registration form
        }else{
            request.setAttribute("login", request.getParameter("login"));
            request.setAttribute("password", request.getParameter("password"));
            request.setAttribute("username",user.getUsername());
            request.setAttribute("user",user);
            getServletContext().getRequestDispatcher("/helloUser.jsp").forward(request, response);
        }


    }

//    public void init(ServletConfig config) throws ServletException {
//                super.init(config);
//                       // You can define your initial parameter in web.xml file.
//        String initialParameter = config.getInitParameter("initialParameter");
//        // Do some stuff with initial parameters
//
//    }
}
