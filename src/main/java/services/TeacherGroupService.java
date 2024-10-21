package services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import models.entity.Student;
import models.entity.Subject;
import models.entity.Teacher;
import repository.dao.StudentRepository;
import repository.dao.SubjectRepository;
import repository.dao.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherGroupService {
    private StudentRepository studentRepository = StudentRepository.getInstance();
    private TeacherRepository teacherRepository = TeacherRepository.getInstance();
    private SubjectRepository subjectRepository = SubjectRepository.getInstance();
    private List<Teacher> teachers = teacherRepository.getList();

    public List<Subject> getTeacherSubjects(Teacher teacher) {
        List<Subject> subjectList = new ArrayList<>();
        for (Subject subject : teacherRepository.getSubjectList(teacher)) {
            subjectList.add(subjectRepository.getById(subject.getId()));
        }
        return subjectList;
    }
}
