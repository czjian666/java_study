package jichen;

public class test {
    public static void main(String[] args) {
        Student S1 =new Student("陈柯",23);

        System.out.println(S1.toString());
        Student S2 =new Student("陈柯",23);
        System.out.println(S2.equals(S1));
    }
}
