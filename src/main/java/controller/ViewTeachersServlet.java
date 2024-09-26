package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;
import model.Teacher;
import model.dao.StudentDAO;
import model.dao.TeacherDAO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewTeachersServlet", urlPatterns = {"/viewTeachers"})
public class ViewTeachersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Получаем список студентов
        List<Teacher> studentList = new TeacherDAO().getList();

        // Преобразуем список студентов в JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(studentList);

        // Устанавливаем тип контента как JSON
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Отправляем JSON-ответ
        resp.getWriter().write(jsonResponse);
    }
}
