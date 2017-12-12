package io;

import java.io.*;

public class CopyFileDemo {
    public static void main(String[] args) {
        copyPic();
    }

    public static void copyFile() {
        InputStream in = null;
        OutputStream os = null;

        try {
            in = new FileInputStream("/Users/Xiebaobiao/IdeaProjects/JAVA_Demo/J2SE/src/io/FileInputStreamDemo.java");
            os = new FileOutputStream("copyeFile.java");
            byte[] bs = new byte[1024];
            int len = -1;
            while ((len = in.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//关闭流，先关输出流，后关输入流
            try {
                if (os != null)
                    os.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void copyPic() {
        InputStream in = null;
        OutputStream os = null;

        try {
            in = new FileInputStream
                    ("/Users/Xiebaobiao/IdeaProjects/JAVA_Demo/J2SE/src/io/1.JPG");
            os = new FileOutputStream
                    ("/Users/Xiebaobiao/IdeaProjects/JAVA_Demo/J2SE/src/io/2.JPG");
            byte[] bs = new byte[1024];
            int len = -1;
            while ((len = in.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//关闭流，先关输出流，后关输入流
            try {
                if (os != null)
                    os.close();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
