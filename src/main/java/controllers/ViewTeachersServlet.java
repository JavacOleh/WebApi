package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.entity.Teacher;
import repository.dao.TeacherRepository;
import services.JsonService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewTeachersServlet", urlPatterns = {"/viewTeachers"})
public class ViewTeachersServlet extends HttpServlet {
    private final transient TeacherRepository teacherRepository = TeacherRepository.getInstance();
    private final JsonService jsonService = JsonService.getInstance(new ObjectMapper());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String jsonResponse = jsonService.toWriteJson(teacherRepository.getList());

        resp.setContentType("application/json");

        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().write(jsonResponse);
    }
}
