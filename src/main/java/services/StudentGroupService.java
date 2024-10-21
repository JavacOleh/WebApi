package services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.entity.Student;
import models.entity.Subject;
import models.entity.Teacher;
import repository.dao.StudentRepository;
import repository.dao.SubjectRepository;
import repository.dao.TeacherRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentGroupService {
    private StudentRepository studentRepository = StudentRepository.getInstance();
    private TeacherRepository teacherRepository = TeacherRepository.getInstance();
    private SubjectRepository subjectRepository = SubjectRepository.getInstance();
    private Teacher curator;
    private List<Student> students = studentRepository.getList();

    public List<Subject> getStudentSubjects(Student student) {
        List<Subject> subjectList = new ArrayList<>();
        for (Subject subject : studentRepository.getSubjectList(student)) {
            subjectList.add(subjectRepository.getById(subject.getId()));
        }
        return subjectList;
    }
}
