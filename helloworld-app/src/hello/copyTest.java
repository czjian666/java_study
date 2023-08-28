package hello;

import java.io.*;

public class copyTest {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("D:\\date tatol\\test.jpg");

        OutputStream os = new FileOutputStream(
                "D:\\date tatol\\test2.jpg");
        byte[] buffer = new byte [1024];//1kb
        int len ;
        while ((len=is.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        os.close();
        is.close();
        System.out.println("复制成功");
    }
}
