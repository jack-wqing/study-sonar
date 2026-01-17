package com.sonar.byteupdate;

import org.objectweb.asm.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.objectweb.asm.Opcodes.*;

public class ClassMethodClear {

    public static void main(String[] args) throws IOException {
        String classFilePath = "/Users/tyc/v.class"; // 原 class 文件
        String outputFilePath = "/Users/tyc/vnew.class"; // 输出 class 文件

        // 读取 class 文件
        FileInputStream fis = new FileInputStream(classFilePath);
        ClassReader classReader = new ClassReader(fis);

        // 修改 class
        ClassWriter classWriter = new ClassWriter(classReader, 0);
        ClassVisitor classVisitor = new ClassVisitor(ASM9, classWriter) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);

                // 匹配方法名称和签名
                if (name.equals("verifyIntegrity") && descriptor.equals("(I)V")) {
                    System.out.println("Found method: " + name + " " + descriptor);

                    // 返回一个空实现的 MethodVisitor
                    return new MethodVisitor(ASM9, mv) {
                        @Override
                        public void visitCode() {
                            // 开始方法体
                            super.visitCode();
                            // 直接返回 (因为是 void)
                            super.visitInsn(RETURN);
                            super.visitMaxs(0, 0); // 自动计算栈和局部变量
                            super.visitEnd();
                        }
                    };
                }

                return mv;
            }
        };

        classReader.accept(classVisitor, 0);
        fis.close();

        // 写入修改后的 class 文件
        FileOutputStream fos = new FileOutputStream(outputFilePath);
        fos.write(classWriter.toByteArray());
        fos.close();

        System.out.println("Modified class written to: " + outputFilePath);
    }
}
