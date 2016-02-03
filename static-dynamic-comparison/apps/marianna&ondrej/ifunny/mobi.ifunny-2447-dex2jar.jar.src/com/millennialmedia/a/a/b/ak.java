package com.millennialmedia.a.a.b;

import java.io.Writer;

final class ak
        extends Writer {
    private final Appendable a;
    private final al b = new al();

    private ak(Appendable paramAppendable) {
        this.a = paramAppendable;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(int paramInt) {
        this.a.append((char) paramInt);
    }

    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2) {
        this.b.a = paramArrayOfChar;
        this.a.append(this.b, paramInt1, paramInt1 + paramInt2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/a/a/b/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */