package com.sonar.byteupdate;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ByteUpdate {
    public static void main(String[] args) throws Exception {

        String classPath = "/Users/tyc/_.class";

        byte[] bytes = Files.readAllBytes(Paths.get(classPath));

        ClassReader cr = new ClassReader(bytes);
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);

        ClassVisitor cv = new ClassVisitor(Opcodes.ASM9, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String desc,
                                             String signature, String[] exceptions) {

                // 目标方法：boolean 鯥(R) 与 boolean 具(R)
                String fullName = name + desc;
                boolean match = fullName.equals("꿳(Lcom/sonarsource/j/J/c;[B)Z") || fullName.equals("佚(Lcom/sonarsource/j/J/c;[B)Z");

                MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);

                if (!match) return mv;

                System.out.println("正在修改方法：" + name + desc);

                // 重写方法体：直接 return true
                return new MethodVisitor(Opcodes.ASM9, mv) {
                    @Override
                    public void visitInsn(int opcode) {
                        // 在这里判断你想插入的位置，比如在返回前插入
                        if (opcode == Opcodes.IRETURN) {
                            // 插入POP和ICONST_1
                            mv.visitInsn(Opcodes.POP);
                            mv.visitInsn(Opcodes.ICONST_1);
                        }
                        super.visitInsn(opcode);
                    }
                };
            }
        };

        cr.accept(cv, 0);

        byte[] out = cw.toByteArray();
        Files.write(Paths.get("/Users/tyc/_.new.class"), out);

    }
}
