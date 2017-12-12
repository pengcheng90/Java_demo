package io;

import java.io.*;

public class BufferStreamDemo {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        testByteByArray();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "毫秒");
    }

    /**
     * 耗时：898毫秒
     * 使用高速缓冲区单个字节读写
     */
    public static void testBuffer() {
        InputStream in = null;
        OutputStream os = null;
        try {
            in = new BufferedInputStream(
                    new FileInputStream("/Users/Xiebaobiao/IdeaProjects/JAVA_Demo/J2SE/testDirectory/testCopy.dmg"));
            os = new BufferedOutputStream(
                    new FileOutputStream("/Users/Xiebaobiao/IdeaProjects/JAVA_Demo/J2SE/testDirectory/CopyResult.dmg"));
            int i = -1;
            while ((i = in.read()) != -1) {
                os.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) os.close();
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 耗时：99毫秒
     * 高速缓冲区一次copy  byte数组个字节
     */
    public static void testBufferArray() {
        InputStream in = null;
        OutputStream os = null;
        try {
            in = new BufferedInputStream(
                    new FileInputStream("/Users/Xiebaobiao/IdeaProjects/JAVA_Demo/J2SE/testDirectory/testCopy.dmg"));
            os = new BufferedOutputStream(
                    new FileOutputStream("/Users/Xiebaobiao/IdeaProjects/JAVA_Demo/J2SE/testDirectory/CopyResult.dmg"));
            byte[] bs = new byte[1024];
            int len = -1;
            while ((len = in.read(bs)) != -1) {
                os.write(bs, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) os.close();
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 耗时：63351毫秒
     * 通过单个字节方式copy
     */
    public static void testByte() {
        InputStream in = null;
        OutputStream os = null;
        try {
            in = new FileInputStream(
                    new File("/Users/Xiebaobiao/IdeaProjects/JAVA_Demo/J2SE/testDirectory/testCopy.dmg"));
            os = new FileOutputStream("/Users/Xiebaobiao/IdeaProjects/JAVA_Demo/J2SE/testDirectory/CopyResult.dmg");
            int i = -1;
            while ((i = in.read()) != -1) {
                os.write(i);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 耗时：221毫秒
     * 通过字节方式一次一个byte[]copy
     */
    public static void testByteByArray() {
        FileInputStream in = null;
        OutputStream os = null;
        try {
            in = new FileInputStream("/Users/Xiebaobiao/IdeaProjects/JAVA_Demo/J2SE/testDirectory/testCopy.dmg");
            os = new FileOutputStream("/Users/Xiebaobiao/IdeaProjects/JAVA_Demo/J2SE/testDirectory/CopyResult.dmg");
            byte[] bs = new byte[1024];
            int len = -1;
            while ((len = in.read(bs)) != -1) {
                os.write(bs, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) os.close();
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
