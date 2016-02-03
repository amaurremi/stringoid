package com.mopub.common;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class f
        extends FilterOutputStream {
    private f(DiskLruCache.Editor paramEditor, OutputStream paramOutputStream) {
        super(paramOutputStream);
    }

    public void close() {
        try {
            this.out.close();
            return;
        } catch (IOException localIOException) {
            DiskLruCache.Editor.a(this.a, true);
        }
    }

    public void flush() {
        try {
            this.out.flush();
            return;
        } catch (IOException localIOException) {
            DiskLruCache.Editor.a(this.a, true);
        }
    }

    public void write(int paramInt) {
        try {
            this.out.write(paramInt);
            return;
        } catch (IOException localIOException) {
            DiskLruCache.Editor.a(this.a, true);
        }
    }

    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {
        try {
            this.out.write(paramArrayOfByte, paramInt1, paramInt2);
            return;
        } catch (IOException paramArrayOfByte) {
            DiskLruCache.Editor.a(this.a, true);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */