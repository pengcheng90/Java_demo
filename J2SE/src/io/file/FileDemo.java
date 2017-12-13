package io.file;

import java.io.File;
import java.io.IOException;

/**
 * FileDemo
 * Created by xiebaobiao on 2017/12/12
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
       delete();
    }

    /**
     * 创建文件
     *
     * @throws IOException
     */
    public static void createFile() throws IOException {
        File file = new File("test.xml");
        //创建文件，仅当改目录下此文件不存在时才会创建成功
        boolean isNewFile = file.createNewFile();
        System.out.println("文件创建是否成功：" + isNewFile);
    }

    /**
     * 创建目录
     */
    public static void mkDir() {
        File file = new File("J2SE/src/io/file/a");
        boolean mkdir = file.mkdir();
        System.out.println("目录创建是否成功：" + mkdir);
    }

    /**
     * 创建多级目录
     */
    public static void mkDirs() {
        File file = new File("a/b");
        boolean isMkdirs = file.mkdirs();
        System.out.println("多级目录是否创建成功：" + isMkdirs);
    }

    /**
     * 文件删除
     */
    public static void delete() throws IOException {
        File file=new File("test.txt");
        boolean newFile = file.createNewFile();
        System.out.println("文件创建是否成功："+newFile);
        boolean delete = file.delete();
        System.out.println("文件是否删除成功："+delete);
    }
}
