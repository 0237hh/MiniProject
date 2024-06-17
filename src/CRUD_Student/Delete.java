package CRUD_Student;

import Student.Student;
import StudentInfo.StudentInfo;

public class Delete {
    private StudentInfo<Student> studentList;
    public Delete(StudentInfo<Student> studentList) {
        this.studentList = studentList;
    }
    public String deleteStudent (int id){
        for(Student student : studentList.getList()){
            if(student.getId() == id){
                studentList.getList().remove(student);
                System.out.println("Deleted student with Student's id: " + id);
                System.out.println("student info: " + student);
                return "^0^";
            }
        }
        System.out.println("Student not found ! re? : " + id);
        return "Error TnT ";
    }
}
