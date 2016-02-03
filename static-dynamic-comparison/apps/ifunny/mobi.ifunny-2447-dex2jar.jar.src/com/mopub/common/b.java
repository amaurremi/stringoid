package com.mopub.common;

import android.os.AsyncTask;

class b
        extends AsyncTask<Void, Void, byte[]> {
    private final CacheService.DiskLruCacheGetListener a;
    private final String b;

    b(String paramString, CacheService.DiskLruCacheGetListener paramDiskLruCacheGetListener) {
        this.a = paramDiskLruCacheGetListener;
        this.b = paramString;
    }

    protected void a(byte[] paramArrayOfByte) {
        if (isCancelled()) {
            onCancelled();
        }
        while (this.a == null) {
            return;
        }
        this.a.onComplete(this.b, paramArrayOfByte);
    }

    protected byte[] a(Void... paramVarArgs) {
        return CacheService.getFromDiskCache(this.b);
    }

    protected void onCancelled() {
        if (this.a != null) {
            this.a.onComplete(this.b, null);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */