package com.sonarsource.i.s;

import com.google.common.base.Strings;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.annotation.Nullable;

public record p(String 燧, @Nullable String Û, @Nullable String 竴) {
    public p(String 燧, @Nullable String Û, @Nullable String 竴) {
        if (燧.isBlank()) {
            throw new IllegalArgumentException("Feature name cannot be blank");
        } else {
            this.燧 = 燧;
            this.Û = Û;
            this.竴 = 竴;
        }
    }

    public p(String var1) {
        this(var1, (String)null, (String)null);
    }

    public String toString() {
        return "LicenseFeature{name='" + this.燧 + "', startDate='" + this.Û + "', endDate='" + this.竴 + "'}";
    }

    /*public boolean Û() {
        boolean var1 = Strings.isNullOrEmpty(this.Û) && Strings.isNullOrEmpty(this.竴);
        boolean var2 = Strings.isNullOrEmpty(this.Û) && this.具();
        boolean var3 = Strings.isNullOrEmpty(this.竴) && this.떼();
        boolean var4 = this.떼() && this.具();
        return var1 || var2 || var3 || var4;
    }*/

    private boolean 떼() {
        if (this.Û != null && !this.Û.isBlank()) {
            try {
                LocalDate var1 = LocalDate.parse(this.Û);
                return var1.isBefore(LocalDate.now()) || var1.isEqual(LocalDate.now());
            } catch (DateTimeParseException var2) {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean 具() {
        if (this.竴 != null && !this.竴.isBlank()) {
            try {
                LocalDate var1 = LocalDate.parse(this.竴);
                return var1.isAfter(LocalDate.now());
            } catch (DateTimeParseException var2) {
                return false;
            }
        } else {
            return false;
        }
    }

    public String 竴() {
        return this.燧;
    }

    @Nullable
    public String 鯥() {
        return this.Û;
    }

    @Nullable
    public String 燧() {
        return this.竴;
    }
}

