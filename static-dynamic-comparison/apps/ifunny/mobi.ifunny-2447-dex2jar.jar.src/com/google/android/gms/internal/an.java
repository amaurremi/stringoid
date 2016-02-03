package com.google.android.gms.internal;

import java.security.MessageDigest;

public class an
        extends ai {
    private MessageDigest b;

    public byte[] a(String arg1) {
        byte[] arrayOfByte1 = a( ???.split(" "));
        this.b = a();
        for (; ; ) {
            synchronized (this.a) {
                if (this.b == null) {
                    return new byte[0];
                }
                this.b.reset();
                this.b.update(arrayOfByte1);
                arrayOfByte1 = this.b.digest();
                i = 4;
                if (arrayOfByte1.length > 4) {
                    byte[] arrayOfByte2 = new byte[i];
                    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
                    return arrayOfByte2;
                }
            }
            int i = localObject.length;
        }
    }

    byte[] a(String[] paramArrayOfString) {
        byte[] arrayOfByte = new byte[paramArrayOfString.length];
        int i = 0;
        while (i < paramArrayOfString.length) {
            arrayOfByte[i] = ((byte) (am.a(paramArrayOfString[i]) & 0xFF));
            i += 1;
        }
        return arrayOfByte;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */