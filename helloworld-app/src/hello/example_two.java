package hello;

import java.util.Scanner;

public class example_two {
    public static void main(String[] args) {
        System.out.println("平均分为："+getAverageScore(6));
    }
    public static double getAverageScore(int number){
        int[] scores = new int[number];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++) {
            System.out.println("请您录入" + (i+1)+ "评委的分数");
            int score =sc.nextInt();
            scores[i] = score;


        }
        int sum = 0 ;
        int max = scores[0];
        int min = scores[0];

//        System.out.println(max);

        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            sum +=score;

            if (score > max) {
                max = score;
            }

            if (score <min) {
                min = score;

            }
        }
        return ((double) (sum - min - max) /(number-2));
    }


}
