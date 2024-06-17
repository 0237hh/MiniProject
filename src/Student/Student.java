package Student;

public class Student {
    private String Name; // 이름
    private int Id;  // 학번
    private int Ban;     // 반

    // 생성자 생성하기.
    public Student(String Name, int Id, int Ban) {
        this.Name = Name;
        this.Id = Id;
        this.Ban = Ban;
    }

    // getter, setter 선언.
    public String getName() { return Name; }
    public void setName(String Name) { this.Name = Name; }

    public int getId() { return Id; }
    public void setId(int Id) { this.Id = Id; }

    public int getBan() { return Ban; }
    public void setBan(int Ban) { this.Ban = Ban; }

    @Override
    public String toString() {
        return "Student Info [name=" + Name + ", Id=" + Id + ", ban=" + Ban + "]";
    }
}

