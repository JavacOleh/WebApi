package services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
public class TeacherGroupService implements GroupService<Subject, Teacher> {
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private SubjectRepository subjectRepository;

    public List<Subject> getSubjects(Teacher teacher) {
        List<Subject> subjectList = new ArrayList<>();
        for (Subject subject : teacherRepository.getSubjectList(teacher)) {
            subjectList.add(subjectRepository.getById(subject.getId()));
        }
        return subjectList;
    }
}
