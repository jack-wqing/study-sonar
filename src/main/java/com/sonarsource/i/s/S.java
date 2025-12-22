package com.sonarsource.i.s;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;

public class S {
    public S() {
    }

    public Optional<R> Û(@Nullable String var1) {
        return var1 != null && !var1.isEmpty() ? this.竴(new String(Base64.decodeBase64(var1.trim().getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8)) : Optional.empty();
    }


    Optional<R> 竴(String var1) {
        try {
            Properties var2 = new Properties();
            var2.load(new StringReader(var1));
            return (new R._F()).鯥(var2.getProperty("Company")).鶸(var2.getProperty("Digest")).莻(var2.getProperty("Edition")).具(var2.getProperty("EditionLabel")).竴(var2.getProperty("Expiration")).Û(Long.parseLong(var2.getProperty("MaxLoc"))).燧(Arrays.asList(StringUtils.split(var2.getProperty("Plugins"), ","))).Û(var2.getProperty("Features")).떼(var2.getProperty("ServerId")).燧(Boolean.parseBoolean(var2.getProperty("Support"))).朒(var2.getProperty("Type")).Û(true).鄵((String)null).Û();
        } catch (Exception var3) {
            return Optional.empty();
        }
    }
}
