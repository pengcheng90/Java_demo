package io;

import java.io.*;

/**
 * FileIo  Demo
 */
public class FileIO {
    public static void main(String[] args) {
        testWrite4();
        testIn2();

    }

    /**
     * 写一个字节
     */
    public static void testWrite(){
        try {
//            FileOutputStream fos=new FileOutputStream(new File("a.txt"));
            FileOutputStream fos=new FileOutputStream("a.txt");//效果同上
            fos.write((byte)'i');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 一个写byte[]个字节
     */
    public static void testWrite2(){
        try {
            FileOutputStream fos=new FileOutputStream("a2.txt");
            String s="Write byte array";
            byte[] bytes = s.getBytes();
            fos.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void testWrite3(){
        try {
            FileOutputStream fos=new FileOutputStream("a3.txt");
            String s="写指定长度的字节数组";
            byte[] bytes = s.getBytes();
            fos.write(bytes,0,15);//一次写0-15 个字节
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void testWrite4(){
        try {
            FileOutputStream fos=
                    new FileOutputStream("a1.txt",true);//第二个参数为是否追加写入
            fos.write("abc".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void testIn2(){
        try {
            FileInputStream is=new FileInputStream("a2.txt");
            int i;
            while ((i=is.read())!=-1){
                System.out.print((char) i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
