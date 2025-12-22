package com.sonarsource.i.s;


import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;
import javax.annotation.CheckForNull;
import javax.annotation.Nullable;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public class R {
    public static final String 劍 = "Company";
    public static final String 꾫 = "Features";
    public static final String Û = "Digest";
    public static final String 具 = "Edition";
    public static final String 轼 = "EditionLabel";
    public static final String 崺 = "Expiration";
    public static final String 교 = "MaxLoc";
    public static final String 鄵 = "Plugins";
    public static final String 仒 = "ServerId";
    public static final String 莻 = "Support";
    public static final String 鯥 = "Type";
    public static final String 罶 = "EVALUATION";
    public static final String 鉚 = "PRODUCTION";
    public static final String 겸 = "TEST";
    private final String 懻;
    private final String 얭;
    private final String 肪;
    private final String 倫;
    private final String 竴;
    private final long 댑;
    private final List<String> 宁;
    private final List<p> 朒;
    private final String 黼;
    private final boolean ɣ;
    private final String 鶸;
    private final String 윕;
    private final String 떼;
    private final boolean 燧;
    private final boolean 剿;
    private final int ㅜ;
    private final Boolean 鼅;
    private final boolean 꾰;

    private R(_F var1) {
        this.懻 = var1.얭;
        this.얭 = var1.具;
        this.肪 = var1.朒;
        this.倫 = var1.ɣ;
        this.竴 = var1.燧;
        this.댑 = var1.莻;
        this.宁 = Collections.unmodifiableList(var1.鄵);
        this.朒 = Collections.unmodifiableList(var1.떼);
        this.黼 = var1.鉚;
        this.ɣ = var1.鶸;
        this.鶸 = var1.竴;
        this.윕 = var1.꾰;
        this.剿 = var1.겸;
        this.떼 = var1.鯥;
        this.燧 = var1.Û;
        this.ㅜ = var1.劍;
        this.鼅 = var1.崺;
        this.꾰 = var1.꾫;
    }

    public String 黼() {
        return this.倫;
    }

    public String 鄵() {
        return this.竴;
    }

    public LocalDate 겸() {
        try {
            return LocalDate.parse(this.倫);
        } catch (DateTimeParseException var2) {
            return LocalDate.MIN;
        }
    }

    public String ɣ() {
        return this.얭;
    }

    public String 꾰() {
        return this.肪;
    }

    public long 鯥() {
        return this.댑;
    }

    public String 교() {
        return this.黼;
    }

    public boolean 竴() {
        return this.ɣ;
    }

    public String 莻() {
        return this.鶸;
    }

    public String 鶸() {
        return this.윕;
    }

    public String 宁() {
        return this.떼;
    }

    public boolean 崺() {
        return this.燧;
    }

    public int 劍() {
        return this.ㅜ;
    }

    public boolean 具() {
        return this.꾰;
    }

    @CheckForNull
    public Boolean 朒() {
        return this.鼅;
    }

    public String 떼() throws IOException {
        Properties var1 = new Properties();
        var1.setProperty("Company", this.떼);
        var1.setProperty("Digest", this.懻);
        var1.setProperty("Edition", this.얭);
        var1.setProperty("EditionLabel", this.肪);
        var1.setProperty("Expiration", this.倫);
        var1.setProperty("MaxLoc", String.valueOf(this.댑));
        var1.setProperty("Plugins", String.join(",", this.宁));
        var1.setProperty("Features", (String)this.朒.stream().map(p::竴).collect(Collectors.joining(",")));
        var1.setProperty("ServerId", this.黼);
        var1.setProperty("Support", String.valueOf(this.ɣ));
        var1.setProperty("Type", this.鶸);
        StringWriter var2 = new StringWriter();
        var1.store(var2, "");
        return Base64.encodeBase64String(var2.toString().getBytes(StandardCharsets.UTF_8));
    }

    public String 얭() {
        ArrayList var1 = new ArrayList();
        var1.add(this.倫);
        var1.add(this.얭);
        var1.add(this.肪);
        var1.add(String.valueOf(this.댑));
        var1.addAll(this.宁);
        var1.add((String)this.朒.stream().map(p::竴).collect(Collectors.joining(",")));
        var1.add(this.黼);
        var1.add(String.valueOf(this.ɣ));
        var1.add(this.鶸);
        var1.add(this.떼);
        return (String)var1.stream().collect(Collectors.joining("|"));
    }

    public String 燧() {
        LocalDate var1 = LocalDate.parse(this.倫);
        String var2 = var1.atStartOfDay(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
        ArrayList var3 = new ArrayList();
        var3.add(this.黼);
        var3.add(this.윕);
        var3.add(var2);
        return (String)var3.stream().map(e -> ((String) e).toLowerCase()).collect(Collectors.joining("#"));
    }

    public String Û() {
        return this.懻;
    }

    public List<p> 꾫() {
        return this.朒;
    }

    public boolean 鉚() {
        return this.剿;
    }

    public static class _F {
        private String 얭;
        private String 具;
        private String 朒;
        private String ɣ;
        private String 燧;
        private long 莻;
        private List<String> 鄵 = new ArrayList();
        private List<p> 떼 = new ArrayList();
        private String 鉚;
        private boolean 鶸;
        private String 竴;
        private String 꾰;
        private Boolean 겸 = false;
        private String 鯥;
        private boolean Û;
        private int 劍;
        private Boolean 崺;
        private boolean 꾫;

        public _F() {
        }

        public _F Û(@Nullable p var1) {
            if (var1 == null) {
                return this;
            } else {
                this.떼.add(var1);
                return this;
            }
        }

        public _F 겸(String var1) {
            return this.Û(new p(var1));
        }

        public _F Û(String var1) {
            this.떼.clear();
            if (var1.isBlank()) {
                return this;
            } else {
                Arrays.stream(var1.split(",")).forEach((var1x) -> {
                    p var2 = new p(StringUtils.trimToNull(var1x));
                    this.떼.add(var2);
                });
                return this;
            }
        }

        public _F Û(List<p> var1) {
            this.떼.clear();
            var1.forEach(this::Û);
            return this;
        }

        public _F 鶸(@Nullable String var1) {
            this.얭 = StringUtils.trimToNull(var1);
            return this;
        }

        public _F 竴(@Nullable String var1) {
            this.ɣ = StringUtils.trimToNull(var1);
            return this;
        }

        public _F 鉚(@Nullable String var1) {
            this.燧 = StringUtils.trimToNull(var1);
            return this;
        }

        public _F Û(long var1) {
            this.莻 = var1;
            return this;
        }

        public _F 꾫(String var1) {
            this.鄵.add(StringUtils.trimToNull(var1));
            return this;
        }

        public _F 燧(List<String> var1) {
            this.鄵.clear();
            var1.forEach(this::꾫);
            return this;
        }

        public _F 莻(@Nullable String var1) {
            this.具 = StringUtils.trimToNull(var1);
            return this;
        }

        public _F 具(@Nullable String var1) {
            this.朒 = StringUtils.trimToNull(var1);
            return this;
        }

        public _F 떼(@Nullable String var1) {
            this.鉚 = StringUtils.trimToNull(var1);
            return this;
        }

        public _F 燧(boolean var1) {
            this.鶸 = var1;
            return this;
        }

        public _F 朒(@Nullable String var1) {
            this.竴 = StringUtils.trimToNull(var1);
            return this;
        }

        public _F 鄵(@Nullable String var1) {
            this.꾰 = StringUtils.trimToNull(var1);
            return this;
        }

        public _F Û(@NotNull Boolean var1) {
            this.겸 = var1;
            return this;
        }

        public _F 鯥(@Nullable String var1) {
            this.鯥 = StringUtils.trimToNull(var1);
            return this;
        }

        public _F Û(boolean var1) {
            this.Û = var1;
            return this;
        }

        public _F Û(int var1) {
            this.劍 = var1;
            return this;
        }

        public _F 燧(@Nullable Boolean var1) {
            this.崺 = var1;
            return this;
        }

        public _F 竴(boolean var1) {
            this.꾫 = var1;
            return this;
        }

        public Optional<R> Û() {
            return this.鯥 != null && this.具 != null && this.朒 != null && this.ɣ != null && this.竴 != null && this.얭 != null && this.鉚 != null && this.莻 > 0L ? Optional.of(new R(this)) : Optional.empty();
        }
    }
}

