package services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import models.entity.Student;
import models.entity.Subject;
import repository.dao.StudentRepository;
import repository.dao.SubjectRepository;
import repository.dao.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class StudentGroupService implements GroupService<Subject, Student> {
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private SubjectRepository subjectRepository;

    public List<Subject> getSubjects(Student student) {
        List<Subject> subjectList = new ArrayList<>();
        for (Subject subject : studentRepository.getSubjectList(student)) {
            subjectList.add(subjectRepository.getById(subject.getId()));
        }
        return subjectList;
    }
}
