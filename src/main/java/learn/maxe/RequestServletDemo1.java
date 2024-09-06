package learn.maxe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author : MaxeCT
 * @apiNote : note
 * @since : 2024/9/6
 **/
@WebServlet("/requestDemo1")
public class RequestServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String referer = req.getHeader("referer");
        // 防盗链
        if (referer != null) {
            if (referer.contains("demo")) {
                System.out.println("允许访问");
            } else {
                System.out.println("需要授权");
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String line = null;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
