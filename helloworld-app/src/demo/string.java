package demo;

import java.time.temporal.ChronoField;
import java.util.Random;

public class  string {
    public static void main(String[] args) {
        System.out.println(createCOde(5));

    }
    public static String createCOde(int n ){
        String code = "";
        String data = "qwertyuiopasdgfhgklzmcbnbvg123456789";
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int index = r.nextInt(data.length());

            code += data.charAt(index);

        }
        return code;
    }
}
