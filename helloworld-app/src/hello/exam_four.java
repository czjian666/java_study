package hello;


import javax.swing.plaf.synth.SynthOptionPaneUI;

public class exam_four {
    public static void main(String[] args) {
        int[] arr = {11,22,33};
        int[] arr2 = copy(arr);
        printArray(arr2);
    }

    private static void printArray(int[] arr2) {
        System.out.println("[");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(i== arr2.length -1 ? arr2[i]:arr2[i] +",");
//三元运算符
        }
        System.out.println(']');

    }

    public static int[] copy(int[]arr){

        int[] arr2 = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            arr2[i] = arr[i];
        }
        return arr2;
    }
}
