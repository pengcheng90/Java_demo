package io.file;

import java.io.File;

public class FileDemo2 {
    public static void main(String[] agrs0) {

        printFileName(new File("J2SE/src"));/*使用相对路径*/
    }

    /**
     * 递归打印目录下所有文件及目录名
     *
     * @param file
     */
    public static void printFileName(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println(f.getName());
                printFileName(f);
            } else System.out.println("--" + f.getName());
        }

    }
}
