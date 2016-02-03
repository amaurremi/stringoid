package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class DataHolder
        implements SafeParcelable {
    public static final g CREATOR = new g();
    private static final c l = new b(new String[0], null);
    Bundle a;
    int[] b;
    int c;
    boolean d = false;
    private final int e;
    private final String[] f;
    private final CursorWindow[] g;
    private final int h;
    private final Bundle i;
    private Object j;
    private boolean k = true;

    DataHolder(int paramInt1, String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt2, Bundle paramBundle) {
        this.e = paramInt1;
        this.f = paramArrayOfString;
        this.g = paramArrayOfCursorWindow;
        this.h = paramInt2;
        this.i = paramBundle;
    }

    private void a(String paramString, int paramInt) {
        if ((this.a == null) || (!this.a.containsKey(paramString))) {
            throw new IllegalArgumentException("No such column: " + paramString);
        }
        if (h()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if ((paramInt < 0) || (paramInt >= this.c)) {
            throw new CursorIndexOutOfBoundsException(paramInt, this.c);
        }
    }

    public int a(int paramInt) {
        int n = 0;
        boolean bool;
        if ((paramInt >= 0) && (paramInt < this.c)) {
            bool = true;
            ag.a(bool);
        }
        for (; ; ) {
            int m = n;
            if (n < this.b.length) {
                if (paramInt < this.b[n]) {
                    m = n - 1;
                }
            } else {
                paramInt = m;
                if (m == this.b.length) {
                    paramInt = m - 1;
                }
                return paramInt;
                bool = false;
                break;
            }
            n += 1;
        }
    }

    public long a(String paramString, int paramInt1, int paramInt2) {
        a(paramString, paramInt1);
        return this.g[paramInt2].getLong(paramInt1, this.a.getInt(paramString));
    }

    public void a() {
        int n = 0;
        this.a = new Bundle();
        int m = 0;
        while (m < this.f.length) {
            this.a.putInt(this.f[m], m);
            m += 1;
        }
        this.b = new int[this.g.length];
        int i1 = 0;
        m = n;
        n = i1;
        while (m < this.g.length) {
            this.b[m] = n;
            i1 = this.g[m].getStartPosition();
            n += this.g[m].getNumRows() - (n - i1);
            m += 1;
        }
        this.c = n;
    }

    public boolean a(String paramString) {
        return this.a.containsKey(paramString);
    }

    int b() {
        return this.e;
    }

    public int b(String paramString, int paramInt1, int paramInt2) {
        a(paramString, paramInt1);
        return this.g[paramInt2].getInt(paramInt1, this.a.getInt(paramString));
    }

    public String c(String paramString, int paramInt1, int paramInt2) {
        a(paramString, paramInt1);
        return this.g[paramInt2].getString(paramInt1, this.a.getInt(paramString));
    }

    String[] c() {
        return this.f;
    }

    public boolean d(String paramString, int paramInt1, int paramInt2) {
        a(paramString, paramInt1);
        return Long.valueOf(this.g[paramInt2].getLong(paramInt1, this.a.getInt(paramString))).longValue() == 1L;
    }

    CursorWindow[] d() {
        return this.g;
    }

    public int describeContents() {
        return 0;
    }

    public float e(String paramString, int paramInt1, int paramInt2) {
        a(paramString, paramInt1);
        return this.g[paramInt2].getFloat(paramInt1, this.a.getInt(paramString));
    }

    public int e() {
        return this.h;
    }

    public Bundle f() {
        return this.i;
    }

    public byte[] f(String paramString, int paramInt1, int paramInt2) {
        a(paramString, paramInt1);
        return this.g[paramInt2].getBlob(paramInt1, this.a.getInt(paramString));
    }

    /* Error */
    protected void finalize() {
        // Byte code:
        //   0: aload_0
        //   1: getfield 53	com/google/android/gms/common/data/DataHolder:k	Z
        //   4: ifeq +82 -> 86
        //   7: aload_0
        //   8: getfield 59	com/google/android/gms/common/data/DataHolder:g	[Landroid/database/CursorWindow;
        //   11: arraylength
        //   12: ifle +74 -> 86
        //   15: aload_0
        //   16: invokevirtual 93	com/google/android/gms/common/data/DataHolder:h	()Z
        //   19: ifne +67 -> 86
        //   22: aload_0
        //   23: getfield 171	com/google/android/gms/common/data/DataHolder:j	Ljava/lang/Object;
        //   26: ifnonnull +65 -> 91
        //   29: new 76	java/lang/StringBuilder
        //   32: dup
        //   33: invokespecial 77	java/lang/StringBuilder:<init>	()V
        //   36: ldc -83
        //   38: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   41: aload_0
        //   42: invokevirtual 174	java/lang/Object:toString	()Ljava/lang/String;
        //   45: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   48: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   51: astore_1
        //   52: ldc -80
        //   54: new 76	java/lang/StringBuilder
        //   57: dup
        //   58: invokespecial 77	java/lang/StringBuilder:<init>	()V
        //   61: ldc -78
        //   63: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   66: aload_1
        //   67: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   70: ldc -76
        //   72: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   75: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   78: invokestatic 185	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
        //   81: pop
        //   82: aload_0
        //   83: invokevirtual 187	com/google/android/gms/common/data/DataHolder:i	()V
        //   86: aload_0
        //   87: invokespecial 189	java/lang/Object:finalize	()V
        //   90: return
        //   91: aload_0
        //   92: getfield 171	com/google/android/gms/common/data/DataHolder:j	Ljava/lang/Object;
        //   95: invokevirtual 174	java/lang/Object:toString	()Ljava/lang/String;
        //   98: astore_1
        //   99: goto -47 -> 52
        //   102: astore_1
        //   103: aload_0
        //   104: invokespecial 189	java/lang/Object:finalize	()V
        //   107: aload_1
        //   108: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	109	0	this	DataHolder
        //   51	48	1	str	String
        //   102	6	1	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   0	52	102	finally
        //   52	86	102	finally
        //   91	99	102	finally
    }

    public int g() {
        return this.c;
    }

    public Uri g(String paramString, int paramInt1, int paramInt2) {
        paramString = c(paramString, paramInt1, paramInt2);
        if (paramString == null) {
            return null;
        }
        return Uri.parse(paramString);
    }

    public boolean h() {
        try {
            boolean bool = this.d;
            return bool;
        } finally {
        }
    }

    public boolean h(String paramString, int paramInt1, int paramInt2) {
        a(paramString, paramInt1);
        return this.g[paramInt2].isNull(paramInt1, this.a.getInt(paramString));
    }

    public void i() {
        try {
            if (!this.d) {
                this.d = true;
                int m = 0;
                while (m < this.g.length) {
                    this.g[m].close();
                    m += 1;
                }
            }
            return;
        } finally {
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        g.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/data/DataHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */