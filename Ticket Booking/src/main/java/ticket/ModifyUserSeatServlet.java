import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ModifyUserSeatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String newSeat = request.getParameter("newSeat");
        DataStore.updateTicketSeat