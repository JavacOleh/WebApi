package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import repository.dao.StudentRepository;
import services.JsonService;

import java.io.IOException;

@WebServlet(name = "ViewStudentByParamServlet", urlPatterns = {"/viewStudentByParams"})
public class ViewStudentByParamServlet extends HttpServlet {
    private final transient StudentRepository studentRepository = StudentRepository.getInstance();
    private final transient JsonService jsonService = JsonService.getInstance(new ObjectMapper());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("param");
        String lookParam = req.getParameter("lookParam");
        String result = jsonService.toWriteJson(studentRepository.getByString(param, lookParam).toString());

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(result);
    }
}
