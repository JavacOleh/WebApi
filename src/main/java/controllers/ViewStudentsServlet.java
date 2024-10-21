package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.dao.StudentRepository;
import services.JsonService;

import java.io.IOException;

@WebServlet(name = "ViewStudentsServlet", urlPatterns = {"/viewStudents"})
public class ViewStudentsServlet extends HttpServlet {
    private final transient StudentRepository studentRepository = StudentRepository.getInstance();
    private final JsonService jsonService = JsonService.getInstance(new ObjectMapper());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonResponse = jsonService.toWriteJson(studentRepository.getList());


        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().write(jsonResponse);
    }
}
