package web;

import main.Main;
import services.TMService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Ion Olaru
 *         Date: 2014/02/10 - 16:23
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Works...");
        resp.getWriter().print("<h1>Hello.</h1>");

        TMService tmService = Main.getTMService();
        List<String> list = tmService.loadAll();
        resp.getWriter().print("<ol>");
        for (String s: list) {
            resp.getWriter().print("<li>" + s + "</li>");
        }
        resp.getWriter().print("</ol>");
    }
}
