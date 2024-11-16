package models;

import lombok.*;
import repository.dao.StudentRepository;
import repository.dao.SubjectRepository;
import repository.dao.TeacherRepository;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
public class Department {
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;
    private SubjectRepository subjectRepository;
    private String name;
}
