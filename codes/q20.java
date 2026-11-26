/*
 * Q20: Student Registration Form Using a Servlet (Servlet)
 * Question: Process client input from an HTML registration form using a Java HttpServlet via HttpServletRequest and HttpServletResponse.
 */

// File 2: StudentServlet.java
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Maps this Servlet to URL /StudentServlet (matches form action in student.html)
@WebServlet("/StudentServlet")
public class q20 extends HttpServlet {
    // Handles HTTP POST requests from the registration form
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Tell the browser the response is HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Extract submitted form values using input 'name' attributes
        String name = request.getParameter("studentName");
        String email = request.getParameter("studentEmail");
        String course = request.getParameter("course");

        // Write dynamic HTML response back to the client
        out.println("<html><body>");
        out.println("<h2>Registration Confirmation</h2>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Course:</strong> " + course + "</p>");
        out.println("</body></html>");
    }
}
