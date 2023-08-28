package interface_example;

import java.util.ArrayList;

public class ClassManager {
    private ArrayList<Student> students = new ArrayList<>();



    public  ClassManager(){
        students.add(new Student("迪丽热巴",'女',99));
    }
}
