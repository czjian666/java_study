package hello;

import static java.util.Collections.reverse;


public class exam_thr {
    public static void main(String[] args) {
        System.out.println("结果是"+encrypt(8346));
    }

    public static String encrypt(int number){

        int[] numbers = split(number);


        for (int i = 0; i < numbers.length; i++) {
            numbers[i]=(numbers[i]+5)%10;
        }
            reverse(numbers);

        String data = "";
        for (int i = 0; i < numbers.length; i++) {
            data += numbers[i];
        }
        return data;
    }

    private static void reverse(int[] numbers) {
        for (int i=0,j = numbers.length -1;i<j;i++,j--){
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }

    }

    private static int[] split(int number) {
        int[] numbers = new int[4];
        numbers[0] = number/1000;
        numbers[1] = (number/100)%10;
        numbers[2] = (number/10)%10;
        numbers[3] = number % 10;

        return numbers;
    }

}
