package CRUD_Student;

import Student.Student;
import StudentInfo.StudentInfo;

public class Update {
    private StudentInfo<Student> studentList;

    public Update(StudentInfo<Student> studentList) {
        this.studentList = studentList;
    }
    public String UpdateStudent(String newName, int id, int newBan) {
        for(Student student : studentList.getList()) {
            if(student.getId() == id) {
                student.setName(newName);
                student.setBan(newBan);
                System.out.println("Update Student Info " + student);
                return "^0^";
            }
        }
        return "^0^";
    }
}
