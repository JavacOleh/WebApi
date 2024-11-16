package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.dao.StudentRepository;
import repository.dao.SubjectRepository;
import repository.dao.TeacherRepository;
import services.JsonService;
import services.TeacherGroupService;

import java.io.IOException;


@WebServlet(name = "ViewTeachersSubjectServlet", urlPatterns = {"/viewTrSj"})
public class ViewTeachersSubjectServlet extends HttpServlet {
    private final JsonService jsonService = JsonService.getInstance(new ObjectMapper());
    private final transient TeacherGroupService teacherGroupService = new TeacherGroupService(new StudentRepository(), new TeacherRepository(), new SubjectRepository());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonResponse = jsonService.toWriteJson(
                teacherGroupService.getSubjects(teacherGroupService.getTeacherRepository().getList().get(Integer.parseInt(req.getParameter("id")))));

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().write(jsonResponse);
    }
}
