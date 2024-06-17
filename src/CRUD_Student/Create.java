package CRUD_Student;

import Student.Student;
import StudentInfo.StudentInfo;

public class Create {
    private StudentInfo<Student> studentList;
    public Create(StudentInfo<Student> studentList) {
        this.studentList = studentList;
    }
    public String createStudent(String name, int id, int ban) {
        Student student = new Student(name, id, ban);
        studentList.add(student);
        System.out.println("Student info: " + student);
        return "^0^";
    }
}
