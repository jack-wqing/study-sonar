package com.sonarsource.i.s;


import java.io.UnsupportedEncodingException;
import java.util.Random;

public final class ATest {
    private static final String 佚 = new String(new char[]{'U', 'T', 'F', '8'});
    private final String 꿳;

    public ATest(long[] var1) {
        int var2 = var1.length;
        byte[] var3 = new byte[8 * (var2 - 1)];
        long var4 = var1[0];
        Random var6 = new Random(var4);

        for(int var7 = 1; var7 < var2; ++var7) {
            long var8 = var6.nextLong();
            꿳(var1[var7] ^ var8, var3, 8 * (var7 - 1));
        }

        String var11;
        try {
            var11 = new String(var3, 佚);
        } catch (UnsupportedEncodingException var10) {
            throw new AssertionError(var10);
        }

        int var12 = var11.indexOf(0);
        this.꿳 = var12 != -1 ? var11.substring(0, var12) : var11;
    }

    private static void 꿳(long var0, byte[] var2, int var3) {
        long var4 = var0;
        int var6 = Math.min(var2.length, var3 + 8);

        for(int var7 = var3; var7 < var6; ++var7) {
            var2[var7] = (byte)((int)var4);
            var4 >>= 8;
        }

    }

    public String toString() {
        return this.꿳;
    }

}
