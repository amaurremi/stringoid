package com.google.android.gms.internal;

public class sl {
    private final byte[] a = new byte['Ā'];
    private int b;
    private int c;

    public sl(byte[] paramArrayOfByte) {
        int j = 0;
        while (j < 256) {
            this.a[j] = ((byte) j);
            j += 1;
        }
        int k = 0;
        j = 0;
        while (j < 256) {
            k = k + this.a[j] + paramArrayOfByte[(j % paramArrayOfByte.length)] & 0xFF;
            int i = this.a[j];
            this.a[j] = this.a[k];
            this.a[k] = i;
            j += 1;
        }
        this.b = 0;
        this.c = 0;
    }

    public void a(byte[] paramArrayOfByte) {
        int m = this.b;
        int k = this.c;
        int j = 0;
        while (j < paramArrayOfByte.length) {
            m = m + 1 & 0xFF;
            k = k + this.a[m] & 0xFF;
            int i = this.a[m];
            this.a[m] = this.a[k];
            this.a[k] = i;
            paramArrayOfByte[j] = ((byte) (paramArrayOfByte[j] ^ this.a[(this.a[m] + this.a[k] & 0xFF)]));
            j += 1;
        }
        this.b = m;
        this.c = k;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/sl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */