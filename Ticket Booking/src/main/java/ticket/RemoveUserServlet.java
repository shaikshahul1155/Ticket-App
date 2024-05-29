import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RemoveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        DataStore.removeTicket(email);
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println("{\"status\": \"success\", \"message\": \"User removed successfully\"}");
    }
}