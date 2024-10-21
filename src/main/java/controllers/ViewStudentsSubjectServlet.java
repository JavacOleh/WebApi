package controllers;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.JsonService;
import services.StudentGroupService;
import java.io.IOException;


@WebServlet(name = "ViewStudentsSubjectServlet", urlPatterns = {"/viewStSj"})
public class ViewStudentsSubjectServlet extends HttpServlet {
    private final JsonService jsonService = JsonService.getInstance(new ObjectMapper());
    private final transient StudentGroupService studentGroupService = new StudentGroupService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String jsonResponse = jsonService.toWriteJson(
                studentGroupService.getStudentSubjects(studentGroupService.getStudents().get(Integer.parseInt(req.getParameter("id")))));

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().write(jsonResponse);
    }
}
