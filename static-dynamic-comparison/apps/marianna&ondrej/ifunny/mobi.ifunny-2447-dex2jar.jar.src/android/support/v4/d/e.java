package android.support.v4.d;

import android.util.Log;

import java.io.Writer;

public class e
        extends Writer {
    private final String a;
    private StringBuilder b = new StringBuilder(128);

    public e(String paramString) {
        this.a = paramString;
    }

    private void a() {
        if (this.b.length() > 0) {
            Log.d(this.a, this.b.toString());
            this.b.delete(0, this.b.length());
        }
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2) {
        int i = 0;
        if (i < paramInt2) {
            char c = paramArrayOfChar[(paramInt1 + i)];
            if (c == '\n') {
                a();
            }
            for (; ; ) {
                i += 1;
                break;
                this.b.append(c);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/android/support/v4/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */