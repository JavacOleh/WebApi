package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.DaoRepository;
import repository.dao.FabricRepository;
import services.JsonService;
import services.logger.ConsoleLogStrategy;
import services.logger.LogStrategy;

import java.io.IOException;

@WebServlet(name = "ViewTeachersServlet", urlPatterns = {"/viewTeachers"})
public class ViewTeachersServlet extends HttpServlet {
    private final transient LogStrategy logStrategy = new ConsoleLogStrategy();
    private final transient DaoRepository<?> teacherRepository = new FabricRepository(logStrategy).createRepository("teacher");
    private final JsonService jsonService = JsonService.getInstance(new ObjectMapper());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String jsonResponse = jsonService.toWriteJson(teacherRepository.getList());

        resp.setContentType("application/json");

        resp.setCharacterEncoding("UTF-8");

        resp.getWriter().write(jsonResponse);
    }
}
