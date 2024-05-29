import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class PurchaseTicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        
        User user = new User(firstName, lastName, email, address);
        String seat = DataStore.allocateSeat();
        Ticket ticket = new Ticket(from, to, user, 20.0, seat);
        
        DataStore.addTicket(ticket);
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println("{\"status\": \"success\", \"message\": \"Ticket purchased successfully\", \"seat\": \"" + seat + "\"}");
    }
}