package com.hiroshi.cimoc.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Hiroshi on 2016/7/25.
 */
public class FileUtils {

    public static String getPath(String... filename) {
        StringBuilder builder = new StringBuilder();
        for (String name : filename) {
            builder.append(name).append(File.separator);
        }
        return builder.toString();
    }


    public static void deleteDir(File dir) {
        if (dir.exists() && dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                if (!file.isDirectory() || file.listFiles().length == 0) {
                    file.delete();
                } else {
                    deleteDir(file);
                }
            }
            dir.delete();
        }
    }

    public static void deleteDir(String dirPath) {
        deleteDir(new File(dirPath));
    }

    public static boolean writeStringToFile(File file, String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            writer.write(data);
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean writeStringToFile(String dirPath, String name, String data) {
        return writeStringToFile(new File(dirPath, name), data);
    }

    public static String readSingleLineFromFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String result = reader.readLine();
            reader.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String readSingleLineFromFile(String dirPath, String name) {
        return readSingleLineFromFile(new File(dirPath, name));
    }

    public static String[] listFilesNameHaveSuffix(File dir, final String suffix) {
        if (dir.exists() && dir.isDirectory()) {
            return dir.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String filename) {
                    return filename.endsWith(suffix);
                }
            });
        }
        return null;
    }

    public static String[] listFilesNameHaveSuffix(String dirPath, String suffix) {
        return listFilesNameHaveSuffix(new File(dirPath), suffix);
    }

    public static boolean writeToBinaryFile(String path, String filename, InputStream byteStream) {
        try {
            FileOutputStream out = new FileOutputStream(new File(path, filename), false);
            int length;
            byte[] buffer = new byte[1024];
            while ((length = byteStream.read(buffer)) != -1){
                out.write(buffer, 0, length);
            }
            out.flush();
            out.close();
            byteStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
