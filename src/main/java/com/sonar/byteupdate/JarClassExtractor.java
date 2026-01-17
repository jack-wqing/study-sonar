package com.sonar.byteupdate;

import java.io.*;
import java.util.*;
import java.util.jar.*;

public class JarClassExtractor {

    /**
     * 从 JAR 文件中提取指定 class 文件并写入目标文件
     *
     * @param jarFilePath JAR 文件路径
     * @param className   指定的 class 文件名（例如 "com/example/MyClass.class"）
     * @param outputPath  输出文件路径
     * @throws IOException
     */
    public static void extractClassFile(String jarFilePath, String className, String outputPath) throws IOException {
        try (JarFile jarFile = new JarFile(jarFilePath)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            boolean found = false;

            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                String entryName = entry.getName();

                if (entryName.equals(className)) {
                    found = true;
                    try (InputStream inputStream = jarFile.getInputStream(entry);
                         FileOutputStream fos = new FileOutputStream(outputPath)) {

                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            fos.write(buffer, 0, bytesRead);
                        }
                        System.out.println("Class file extracted successfully to: " + outputPath);
                    }
                    break; // 找到目标文件后退出循环
                }
            }

            if (!found) {
                System.out.println("Class file " + className + " not found in the JAR file.");
            }
        }
    }

    public static void main(String[] args) {
        // 设置要读取的 JAR 文件路径
        String jarFilePath = "/Users/tyc/sonar-application-2025.4.4.119049.jar";

        // 设置要读取的 class 文件名（例如：com/example/MyClass.class）
        String className = "com/sonarsource/j/_/v.class";

        // 输出文件路径
        String outputPath = "/Users/tyc/v.class";

        try {
            extractClassFile(jarFilePath, className, outputPath);
        } catch (IOException e) {
            System.err.println("Error extracting class file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
