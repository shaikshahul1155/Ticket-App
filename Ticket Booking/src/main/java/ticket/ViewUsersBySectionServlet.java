import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ViewUsersBySectionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String section = request.getParameter("section");
        Collection<Ticket> tickets = DataStore.getAllTickets();
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("[");
        boolean first = true;
        for (Ticket ticket : tickets) {
            if (ticket.getSeat().contains(section)) {
                if (!first) {
                    out.print(",");
                }
                out.print("{\"firstName\": \"" + ticket.getUser().getFirstName() + "\", \"lastName\": \"" + ticket.getUser().getLastName() + "\", \"email\": \"" + ticket.getUser().getEmail() + "\", \"seat\": \"" + ticket.getSeat() + "\"}");
                first = false;
            }
        }
        out.print("]");
    }
}