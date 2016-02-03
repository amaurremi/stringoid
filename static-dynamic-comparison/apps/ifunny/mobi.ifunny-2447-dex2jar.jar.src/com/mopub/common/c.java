package com.mopub.common;

import android.os.AsyncTask;

class c
        extends AsyncTask<Void, Void, Void> {
    private final String a;
    private final byte[] b;

    c(String paramString, byte[] paramArrayOfByte) {
        this.a = paramString;
        this.b = paramArrayOfByte;
    }

    protected Void a(Void... paramVarArgs) {
        CacheService.putToDiskCache(this.a, this.b);
        return null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */