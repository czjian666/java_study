package interface_example;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        File file = new File("D:\\date tatol");
        deleteDir(file);

    }
    public static void deleteDir(File dir){
        if(dir == null || !dir.exists()){
            return;
        }
        if(dir.isFile()){
            dir.delete();
            return;
        }
        File[] files = dir.listFiles();
        if(files ==null){
            return;
        }
        if(files.length ==0){
            dir.delete();
            return;
        }
        for (File file : files) {
            if(file.isFile()){
                file.delete();
            }else {
                deleteDir(file);
            }

        }
//        dir.delete();
    }
}
