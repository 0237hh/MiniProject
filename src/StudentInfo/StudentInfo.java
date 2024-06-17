package StudentInfo;

import java.util.ArrayList;

public class StudentInfo<T> {
    private ArrayList<T> list = new ArrayList<>();
    public void add(T item) { list.add(item); }
    public T get(int index) { return list.get(index); }
    public ArrayList<T> getList() { return list; }
    public int size() { return list.size(); }
    @Override
    public String toString() { return list.toString(); }
}

