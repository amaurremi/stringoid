package com.flurry.sdk;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class at
        extends as {
    private final File a;
    private OutputStream b;

    public at(File paramFile) {
        this.a = paramFile;
    }

    protected OutputStream f()
            throws IOException {
        if (this.b != null) {
            return this.b;
        }
        if (this.a == null) {
            throw new IOException("No file specified");
        }
        this.b = new FileOutputStream(this.a);
        return this.b;
    }

    protected void g() {
        fe.a(this.b);
        this.b = null;
    }

    protected void h() {
        if (this.a == null) {
            return;
        }
        this.a.delete();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */