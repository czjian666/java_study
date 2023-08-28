
package hello;

public class HelloWorld {

    public static void main(String[] args) {
//        int num=20;
//        byte b = (byte) num;
//        boolean a = true;
////        byte short char 都是直接转成int来计算的
//        System.out.println(num = 10);
//        System.out.println(a);
//        System.out.println("Hello World");
        double a = 9.5;
        double b = 520;
        a += b;
        double size = 6.8;
        int storage = 16;
        boolean rs = size>=6.98 && storage>=8;
        System.out.println(rs);
        boolean rs2 = size>=6.98 || storage>=8;
        System.out.println(rs2);
        System.out.println(a);
        int i= 10;
        int j =20;
        System.out.println(i>100&& ++j>99);
        System.out.println(i>j ? j:i);
        System.out.println(j);


    }
}


















