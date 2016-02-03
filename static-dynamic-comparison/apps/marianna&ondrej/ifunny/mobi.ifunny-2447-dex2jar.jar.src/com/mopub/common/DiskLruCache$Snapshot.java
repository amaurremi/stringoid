package com.mopub.common;

import java.io.Closeable;
import java.io.InputStream;

public final class DiskLruCache$Snapshot
        implements Closeable {
    private final String b;
    private final long c;
    private final InputStream[] d;
    private final long[] e;

    private DiskLruCache$Snapshot(DiskLruCache paramDiskLruCache, String paramString, long paramLong, InputStream[] paramArrayOfInputStream, long[] paramArrayOfLong) {
        this.b = paramString;
        this.c = paramLong;
        this.d = paramArrayOfInputStream;
        this.e = paramArrayOfLong;
    }

    public void close() {
        InputStream[] arrayOfInputStream = this.d;
        int j = arrayOfInputStream.length;
        int i = 0;
        while (i < j) {
            DiskLruCacheUtil.a(arrayOfInputStream[i]);
            i += 1;
        }
    }

    public DiskLruCache.Editor edit() {
        return DiskLruCache.a(this.a, this.b, this.c);
    }

    public InputStream getInputStream(int paramInt) {
        return this.d[paramInt];
    }

    public long getLength(int paramInt) {
        return this.e[paramInt];
    }

    public String getString(int paramInt) {
        return DiskLruCache.a(getInputStream(paramInt));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/DiskLruCache$Snapshot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */