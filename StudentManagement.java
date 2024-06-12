package MiniProject1;

import java.util.ArrayList;
import java.util.Scanner;

/** 학생 관리 프로그램
 * CRUD
 * + Create (생성) - 학생의 정보를 생성할 수 있는 기능 (학생의 정보를 입력받을 수 있는 기능 ?)
 * + Read (읽기) - 학생의 정보를 조회할 수 있는 기능 (원하는 학생의 정보만을 출력할 수 있는 기능?)
 * + Update (갱신) - 학생의 정보를 업데이트 할 수 있는 기능. (학생 정보의 수정이 가능한 기능?)
 * -- 컬렉션 프레임워크 해시맵 예시 참고 p. 648
 * + Delete (삭제) - 학생의 정보를 삭제할 수 있는 기능.
 * private 지정, Name (이름), StuNum (학번), Ban (반)
 * + 정렬기능 사용해보기 (Collection)
 * 학번과 이름은 배열로 생성, 배열에 입력하고 출력하기 .
 * getter vs setter
 * - Why use?
 * => private는 외부에서는 접근할 수 없기 때문에 꺼내는 것도, 값을 삽입하는 것도 메소드의 도움이 필요하다.
 * getter - private 를 외부로 꺼내는 메소드,
 * + 내부의 멤버변수에 저장된 값을 외부로 리턴한다. 매개변수는 없고, 리턴값만 있는 메소드로 정의한다.
 * setter - private 에 값을 넣는 메소드.
 * + 외부로부터 데이터를 전달받아 멤버변수에 저장. 매개변수만 존재하고 리턴값은 없는 메소드임.
 * 오버라이딩 - 조상클래스로부터 상속받은 메소드의 내용을 변경하는 것
 * 오버로딩 - 기존에 없는 새로운 메소드를 정의 (매개변수의 타입과 갯수는 달라야함)
 *
 * -------------
 * 1. 학생 정보 입력후 저장
 * **/

class Student { // 학생의 정보를 담고있는 Student class
    private String Name; // 이름
    private int StuNum;  // 학번
    private int Ban;     // 반
//    private int Height = (int)(Math.random() * 180) + 1; // 키
//    private int Weight = (int)(Math.random() * 100)+1; // 몸무게

    // 생성자 생성하기.
    public Student(String Name, int StuNum, int Ban) {
        this.Name = Name;
        this.StuNum = StuNum;
        this.Ban = Ban;
//        this.Height = (int)(Math.random() * 180) + 1;
//        this.Weight = (int)(Math.random() * 100) + 1;
    }
    // private로 지정되어 있으니 getter, setter 선언.
    String getName () {return Name;}
    public void setName (String Name) {this.Name = Name;}

    int getStuNum () {return StuNum;}
    public void setStuNum (int StuNum) {this.StuNum = StuNum;}

    int getBan () {return Ban;}
    void setBan (int ban) {this.Ban = Ban;}
//
//    int getHeight () {return Height;}
//    void setHeight (int height) {this.Height = height;}
//
//    int getWeight () {return Weight;}
//    void setWeight (int weight) {this.Weight = weight;}

    public String toString() {
        return "Student Info [name=" + Name + ", StuNum=" + StuNum + ", ban=" + Ban + "]";
    }
} // end of Student class

// CRUD 기능을 구현할 클래스.
public class StudentManagement {
    // 제네릭 클래스 호출.
    private StudentInfo<Student> studentlist = new StudentInfo<Student>();

    // 1. Create (생성) - 학생 정보를 생성하는 메소드
     public void CreateStudent(String name, int stuNum, int ban) {
        Student student = new Student(name, stuNum, ban);
        studentlist.add(student);
        System.out.println("Student info: " + student);
    } // end of create

    // 2. Read (읽기, 조회)
    public void ReadStudent() {
        if (studentlist.size() == 0) {
            System.out.println("Student info can't found");
            return;
        }
        for (Student student : studentlist.getList()){
            System.out.println(student);
        }
    } // end of Read

    // 3. Update (갱신, 수정)
    public void UpdateStudent(String newName, int StuNum, int newBan) {
        for(Student student : studentlist.getList()){
            if (student.getStuNum() == StuNum) {
                student.setName(newName);
                student.setBan(newBan);
                System.out.println("업데이트 할 학생의 정보를 입력: " + student);
                return;
            }
        }
        System.out.println("존재하지 않는 학번임. 다시입력 : " + StuNum);
    } // end of update

    // 4. Delete (삭제)
    // 이름과 반은 중복이 가능, 학번은 중복될 수 없다
    public void DeleteStudent(int StuNum) {
        for(Student student : studentlist.getList()){
            if (student.getStuNum() == StuNum) {
                studentlist.getList().remove(student);
                System.out.println("삭제할 학생의 학번 (stuNum)을 입력: " + StuNum);
                return ;
            }
        }
    } // end of delete

    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        System.out.printf(" - 수행할 작업의 번호를 선택 ) 1. 학생 정보 삽입     2. 학생 정보 조회     3. 학생 정보 수정     4. 학생 정보 삭제 : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        switch(n) {
            case 1: //삽입
                System.out.println("1. 학생정보 삽입으로 이동.");
                System.out.print("삽입할 학생의 이름을 입력: ");
                String name = sc.next();
                System.out.print("삽입할 학생의 학번을 입력: ");
                int stuNum = sc.nextInt();
                System.out.print("삽입할 학생의 반을 입력: ");
                int ban = sc.nextInt();
                studentManagement.CreateStudent(name, stuNum, ban);
                break;
            case 2: // 읽기
                System.out.println("2. 학생정보 조회로 이동");
                studentManagement.ReadStudent();
                break;
            case 3: // 수정
                System.out.println("3. 학생정보 수정으로 이동");
                System.out.print("수정할 학생의 이름을 입력: ");
                String newName = sc.next();
                System.out.print("수정할 학생의 학번을 입력: ");
                int updateStuNum = sc.nextInt();
                System.out.print("수정할 학생의 반을 입력: ");
                int updateBan = sc.nextInt();
                studentManagement.UpdateStudent(newName, updateStuNum, updateBan);
                break;
            case 4: // 삭제
                System.out.println("4. 학생 정보 삭제로 이동");
                System.out.print("삭제할 학생의 학번을 입력: ");
                int deleteStuNum = sc.nextInt();
                studentManagement.DeleteStudent(deleteStuNum);
                break;
            default:
                System.out.println("존재하지 않는 카테고리임. 다시 선택");
        } // end of switch

    } // end of main
} // end of class
// 제네릭스 사용
class StudentInfo <Student> {
    ArrayList<Student> list = new ArrayList<Student>();
    void add (Student item) {list.add (item);}
    Student get (int index) {return list.get(index);}
    ArrayList<Student> getList() {return list;}
    int size() {return list.size();}
    public String toString() { return list.toString(); }
}
