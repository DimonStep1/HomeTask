package ua.itif.lms.controller;

import ua.itif.lms.dao.entity.User;
import ua.itif.lms.dao.repository.UserRepository;
import ua.itif.lms.view.IndexSingletonView;
import ua.itif.lms.view.LoginView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StartServlet", urlPatterns = {"/"})
public class StartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                out.println("<html><head><title>Servlet</title></ head><body>");
                out.write("<H1>Hello Servlet World!</H1>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();

            }
        IndexSingletonView indexSingletonView = IndexSingletonView.getInstance();
            out.println(indexSingletonView.getIndexHtml());

        LoginView loginView = new LoginView();
        if (request.getParameter("email") != null && request.getParameter("password") !=null) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            UserRepository userRepository = new UserRepository();
            User user = userRepository.getUserByEmailByPassword(email, password);
            out.println(LoginView.welcomUserPage(user));
        } else {
            out.println(LoginView.getLoginPage());
        }

            }
    @Override
    public void init() throws ServletException {
        super.init();
        String path = getServletContext().getRealPath("html/");
        IndexSingletonView indexSingletonView = IndexSingletonView.getInstance();
        indexSingletonView.setPath(path);
    }
}
