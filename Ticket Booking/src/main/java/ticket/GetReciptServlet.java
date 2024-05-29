import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class GetReceiptServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        Ticket ticket = DataStore.getTicket(email);
        
        if (ticket != null) {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.println("{\"from\": \"" + ticket.getFrom() + "\", \"to\": \"" + ticket.getTo() + "\", \"user\": {\"firstName\": \"" + ticket.getUser().getFirstName() + "\", \"lastName\": \"" + ticket.getUser().getLastName() + "\", \"email\": \"" + ticket.getUser().getEmail() + "\", \"address\": \"" + ticket.getUser().getAddress() + "\"}, \"pricePaid\": " + ticket.getPricePaid() + ", \"seat\": \"" + ticket.getSeat() + "\"}");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Ticket not found");
        }
    }
}