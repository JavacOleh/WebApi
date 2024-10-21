package models;

import lombok.*;
import models.entity.Student;
import models.entity.Subject;
import models.entity.Teacher;
import repository.dao.StudentRepository;
import repository.dao.SubjectRepository;
import repository.dao.TeacherRepository;

import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class Department {
    private final StudentRepository studentRepository = StudentRepository.getInstance();
    private final TeacherRepository teacherRepository = TeacherRepository.getInstance();
    private final SubjectRepository subjectRepository = SubjectRepository.getInstance();

    private String name;

    private List<Subject> subjects = subjectRepository.getList();
    private List<Teacher> teachers = teacherRepository.getList();
    private List<Student> students = studentRepository.getList();

}
