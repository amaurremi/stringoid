package com.flurry.sdk;

import java.io.Writer;

public final class il
        extends Writer {
    protected final sp a;

    public il(si paramsi) {
        this.a = new sp(paramsi);
    }

    public String a() {
        String str = this.a.f();
        this.a.a();
        return str;
    }

    public Writer append(char paramChar) {
        write(paramChar);
        return this;
    }

    public Writer append(CharSequence paramCharSequence) {
        paramCharSequence = paramCharSequence.toString();
        this.a.a(paramCharSequence, 0, paramCharSequence.length());
        return this;
    }

    public Writer append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
        paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2).toString();
        this.a.a(paramCharSequence, 0, paramCharSequence.length());
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(int paramInt) {
        this.a.a((char) paramInt);
    }

    public void write(String paramString) {
        this.a.a(paramString, 0, paramString.length());
    }

    public void write(String paramString, int paramInt1, int paramInt2) {
        this.a.a(paramString, 0, paramString.length());
    }

    public void write(char[] paramArrayOfChar) {
        this.a.c(paramArrayOfChar, 0, paramArrayOfChar.length);
    }

    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2) {
        this.a.c(paramArrayOfChar, paramInt1, paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */