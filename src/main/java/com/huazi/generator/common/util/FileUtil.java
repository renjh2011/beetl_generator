package com.huazi.generator.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    public static void output(String path,String content) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            fos.write(content.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean isDirectory(String path){
        File file=new File(path);
        if(file.exists() && file.isDirectory()){
            return true;
        }
        return false;
    }
    public static boolean isFile(String path){
        File file=new File(path);
        if(file.exists() && file.isFile()){
            return true;
        }
        return false;
    }

    public static boolean createFile(String path) throws IOException {
        File file=new File(path);
        return file.createNewFile();
    }
    public static void main(String[] args) throws IOException {
        output("d:/test.text","456");
    }
}
