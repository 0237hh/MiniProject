package StudentManagement;

import CRUD_Student.Create;
import CRUD_Student.Delete;
import CRUD_Student.Read;
import CRUD_Student.Update;
import StudentInfo.StudentInfo;

import java.util.Scanner;

public class StudentManagement {
    private static StudentInfo studentList = new StudentInfo();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Create create = new Create(studentList);
        Read read = new Read(studentList);
        Update update = new Update(studentList);
        Delete delete = new Delete(studentList);

        while(true) {
            System.out.println("작업할 번호를 선택)     1. 학생 정보 삽입      2. 학생 정보 조회    " +
                                    "3. 학생 정보 갱신     4. 학생 정보 삭제     5. 종료");
            int n = sc.nextInt();

            switch(n) {
                case 1:
                    System.out.printf("삽입할 학생의 이름을 입력: ");
                    String name = sc.next();
                    System.out.printf("삽입할 학생의 학번을 입력: ");
                    int id = sc.nextInt();
                    System.out.printf("삽입할 학생의 반을 입력: ");
                    int ban = sc.nextInt();
                    create.createStudent(name, id, ban);
                    break;
                case 2:
                    System.out.println("학생 정보 조회로 넘어갑니다. ");
                    read.readStudent();
                    break;
                case 3:
                    System.out.printf("갱신, 수정할 학생의 학번을 입력 : ");
                    int updateid = sc.nextInt();
                    System.out.printf("갱신, 수정할 학생의 이름을 입력 : ");
                    String newname = sc.next();
                    System.out.printf("갱신, 수정할 학생의 반을 입력 : ");
                    int newban = sc.nextInt();
                    update.UpdateStudent(newname, updateid, newban );
                    break;
                case 4:
                    System.out.printf("삭제할 학생의 학번을 입력 : ");
                    int deleteid = sc.nextInt();
                    delete.deleteStudent(deleteid);
                    break;
                case 5:
                    System.out.println("종료합니당");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("존재하지 않는 번호입니다. 다시 입력하세요 ");
            }
        }

    }

}
