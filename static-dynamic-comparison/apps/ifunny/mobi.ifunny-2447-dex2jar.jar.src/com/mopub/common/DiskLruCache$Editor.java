package com.mopub.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public final class DiskLruCache$Editor {
    private final g b;
    private final boolean[] c;
    private boolean d;
    private boolean e;

    private DiskLruCache$Editor(DiskLruCache paramDiskLruCache, g paramg) {
        this.b = paramg;
        if (g.d(paramg)) {
        }
        for (paramDiskLruCache = null; ; paramDiskLruCache = new boolean[DiskLruCache.e(paramDiskLruCache)]) {
            this.c = paramDiskLruCache;
            return;
        }
    }

    public void abort() {
        DiskLruCache.a(this.a, this, false);
    }

    public void abortUnlessCommitted() {
        if (!this.e) {
        }
        try {
            abort();
            return;
        } catch (IOException localIOException) {
        }
    }

    public void commit() {
        if (this.d) {
            DiskLruCache.a(this.a, this, false);
            this.a.remove(g.c(this.b));
        }
        for (; ; ) {
            this.e = true;
            return;
            DiskLruCache.a(this.a, this, true);
        }
    }

    public String getString(int paramInt) {
        InputStream localInputStream = newInputStream(paramInt);
        if (localInputStream != null) {
            return DiskLruCache.a(localInputStream);
        }
        return null;
    }

    public InputStream newInputStream(int paramInt) {
        synchronized (this.a) {
            if (g.a(this.b) != this) {
                throw new IllegalStateException();
            }
        }
        if (!g.d(this.b)) {
            return null;
        }
        try {
            FileInputStream localFileInputStream = new FileInputStream(this.b.getCleanFile(paramInt));
            return localFileInputStream;
        } catch (FileNotFoundException localFileNotFoundException) {
        }
        return null;
    }

    public OutputStream newOutputStream(int paramInt) {
        synchronized (this.a) {
            if (g.a(this.b) != this) {
                throw new IllegalStateException();
            }
        }
        if (!g.d(this.b)) {
            this.c[paramInt] = true;
        }
        File localFile = this.b.getDirtyFile(paramInt);
        try {
            Object localObject2 = new FileOutputStream(localFile);
            localObject2 = new f(this, (OutputStream) localObject2, null);
            return (OutputStream) localObject2;
        } catch (FileNotFoundException localFileNotFoundException1) {
            for (; ; ) {
                DiskLruCache.f(this.a).mkdirs();
                try {
                    FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
                } catch (FileNotFoundException localFileNotFoundException2) {
                    OutputStream localOutputStream = DiskLruCache.a();
                    return localOutputStream;
                }
            }
        }
    }

    public void set(int paramInt, String paramString) {
        try {
            OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(newOutputStream(paramInt), DiskLruCacheUtil.b);
            DiskLruCacheUtil.a(localOutputStreamWriter);
        } finally {
            try {
                localOutputStreamWriter.write(paramString);
                DiskLruCacheUtil.a(localOutputStreamWriter);
                return;
            } finally {
            }
            paramString =finally;
            localOutputStreamWriter = null;
        }
        throw paramString;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/DiskLruCache$Editor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */