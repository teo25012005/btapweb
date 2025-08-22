// src/main/java/murach/email/EmailListServlet.java
package murach.email;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import murach.business.User;
import murach.data.UserDB;

@WebServlet("/emailList")
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "join";

        String url;
        switch (action) {
            case "add":
                // Lấy dữ liệu từ form
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");

                // Tạo User + set vào request
                User user = new User(firstName, lastName, email);
                request.setAttribute("user", user);

                // Gọi "DB" để kiểm chứng (in ra console)
                UserDB.insert(user);

                // Sang trang cảm ơn: NHỚ tên file "thank.jsp"
                url = "/thank.jsp";
                break;

            case "join":
            default:
                // Về lại form nhập
                url = "/index.jsp";
                break;
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
