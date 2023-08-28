package hello;

import java.util.Random;
import java.util.Scanner;

public class systemin {
    public static void main(String[] args) {
//        Scanner sc =new Scanner(System.in);
//        System.out.println("age:");
//        int age = sc.nextInt();

//        double t = 37.5;
//        if(t>37){
//            System.out.println("shuchu");
//        String week ="周三";
//        switch (week){
//            case "周一":
//                System.out.println("mtkd");
//                break;
//            case "周三":
//                System.out.println("eat");
//                break;
//            default:
//                System.out.println("no exit");
//        for (int i = 0;i<3; i++){
//            System.out.println("hello world");
//        }
//        Random r = new Random();
//        int number = r.nextInt(10);
//
//        System.out.println("随机生成了"+number);
//        int [] ages2 = {12, 13, 14};
//        System.out.println(ages2.length);//变量名里存储的是ages的地址
//        int [] ages = new int[3];
//        System.out.println(ages[1]);
//
//        double[] scores = new double[6];
//
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < scores.length; i++) {
//            System.out.print("第" + (i + 1) + "个");
//            double score = sc.nextDouble();
//            scores[i] = score;

         sum(10,20);

        printfhello(10);
//        }
//        double sum = 0;
//        for (int i = 0; i < scores.length; i++) {
//            sum += scores[i];
//        }
//        System.out.println("得分：" + sum / scores.length);

    }

    public static void sum(int a,int b) {
        int c = a+b;
        System.out.println(c);
    }
    public static void printfhello( int k){
        for(int i =0;i<=k;i++){
            System.out.println("shuai");
        }
    }
}

