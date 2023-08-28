package hello;

import java.util.Random;

public class example_one {
    public static void main(String[] args) {
        System.out.println(createCode(5));
    }

    public static String createCode(int n){
        Random r =new Random();

        String code = "";
        for (int i = 1; i <= n; i++) {

            int type = r.nextInt(3);
            switch (type){
                case 0:
                    code += r.nextInt(10);
                    break;
                case 1:
                    char ch1= (char) (r.nextInt(26) +65);
                    code += ch1;
                    break;
                case 2:
                    char ch2 = (char) (r.nextInt(26)+97);
                    code +=ch2;
                    break;

            }
        }
        return code;
    }
}
