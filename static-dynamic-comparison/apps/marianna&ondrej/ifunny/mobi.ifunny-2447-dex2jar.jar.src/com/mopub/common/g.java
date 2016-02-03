package com.mopub.common;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class g {
    private final String b;
    private final long[] c;
    private boolean d;
    private DiskLruCache.Editor e;
    private long f;

    private g(DiskLruCache paramDiskLruCache, String paramString) {
        this.b = paramString;
        this.c = new long[DiskLruCache.e(paramDiskLruCache)];
    }

    private void a(String[] paramArrayOfString) {
        if (paramArrayOfString.length != DiskLruCache.e(this.a)) {
            throw b(paramArrayOfString);
        }
        int i = 0;
        try {
            while (i < paramArrayOfString.length) {
                this.c[i] = Long.parseLong(paramArrayOfString[i]);
                i += 1;
            }
            return;
        } catch (NumberFormatException localNumberFormatException) {
            throw b(paramArrayOfString);
        }
    }

    private IOException b(String[] paramArrayOfString) {
        throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
    }

    public File getCleanFile(int paramInt) {
        return new File(DiskLruCache.f(this.a), this.b + "." + paramInt);
    }

    public File getDirtyFile(int paramInt) {
        return new File(DiskLruCache.f(this.a), this.b + "." + paramInt + ".tmp");
    }

    public String getLengths() {
        StringBuilder localStringBuilder = new StringBuilder();
        long[] arrayOfLong = this.c;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j) {
            long l = arrayOfLong[i];
            localStringBuilder.append(' ').append(l);
            i += 1;
        }
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */