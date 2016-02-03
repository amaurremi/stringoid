package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class ai {
    private static MessageDigest b = null;
    protected Object a = new Object();

    protected MessageDigest a() {
        for (; ; ) {
            MessageDigest localMessageDigest;
            int i;
            synchronized (this.a) {
                if (b != null) {
                    localMessageDigest = b;
                    return localMessageDigest;
                }
                i = 0;
                if (i >= 2) {
                }
            }
            try {
                b = MessageDigest.getInstance("MD5");
                i += 1;
                continue;
                localMessageDigest = b;
                return localMessageDigest;
                localObject2 =finally;
                throw ((Throwable) localObject2);
            } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
                for (; ; ) {
                }
            }
        }
    }

    abstract byte[] a(String paramString);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */