package CRUD_Student;

import Student.Student;
import StudentInfo.StudentInfo;

public class Read {
    private StudentInfo<Student> studentList;
    public Read(StudentInfo<Student> studentList) {
        this.studentList = studentList;
    }
    public String readStudent() {
        if (studentList.size() == 0) {
            System.out.println("No students found");
            return "error TnT" ;
        }
        for(Student student: studentList.getList()){
            System.out.println("read with " + student);
        }
        return "^0^";
    }
}
