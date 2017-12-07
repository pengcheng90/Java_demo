package io;


import java.io.*;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        testInput2();
    }
    public static void testInut(){
        InputStream in=null;

        try {
            in=new FileInputStream(new File("/Users/Xiebaobiao/IdeaProjects/JAVA_Demo/a.txt"));
            int i = in.read();
            System.out.println(i);
            System.out.println((char)i);//通过ascii转换成字母
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一次读byte[]个字节
     */
    public static void testInput1() {
        InputStream in = null;
        try {
            in = new FileInputStream("a.txt");
            byte[] bs = new byte[1024];
            int len=in.read(bs);
            System.out.println(len+"个字节");
            System.out.println(new String(bs,0,len));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void testInput2(){
        InputStream in=null;
        try {
            in = new FileInputStream("a.txt");
            byte [] bs=new byte[1024];
            //TODO
            //注意！：此处从输入流读取3个字节（0-3），放入到数组的1-3下标下
            int len = in.read(bs, 1, 3);
            System.out.println(new String(bs,0,3));//读取错误
            System.out.println(new String(bs,1,3));//从数组下标1读取正确

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
