package hello;

import java.io.File;

public class RecursionTest {
    public static void main(String[] args) {
        searchFile(new File("D:/"),"QQ.exe");
    }
    /**去目录搜索某个文件
     * 递归查找文件
     * @param dir 目录
     * @param fileName 要搜索的文件名称
     */
    public static void searchFile(File dir,String fileName){
        if (dir == null || !dir.exists() ||dir.isFile()){
            return;
        }

        File[] files = dir.listFiles();
        if(files !=null && files.length>0){
            for (File file : files) {
                if(file.isFile()){
                    if(file.getName().contains(fileName)){
                        System.out.println(file.getAbsolutePath());
                        Runtime runtime = Runtime.getRuntime();
                        try {
                            runtime.exec(file.getAbsolutePath());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }else{
                    searchFile(file,fileName);
                }

            }
        }

    }
}
