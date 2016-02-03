package com.umeng.analytics.a;

import android.content.Context;
import com.umeng.a.a.a.m;
import com.umeng.analytics.d.n;
import com.umeng.analytics.d.o;
import com.umeng.common.util.h;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class f {
    private static final String a = ".imprint";
    private static final byte[] b = "pbl0".getBytes();
    private n c = null;
    private Context d;

    public f(Context paramContext) {
        this.d = paramContext;
    }

    private n a(n paramn1, n paramn2) {
        if (paramn2 == null) {
            return paramn1;
        }
        Map localMap = paramn1.d();
        Iterator localIterator = paramn2.d().entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            if (((o) localEntry.getValue()).e()) {
                localMap.put(localEntry.getKey(), localEntry.getValue());
            } else {
                localMap.remove(localEntry.getKey());
            }
        }
        paramn1.a(paramn2.h());
        paramn1.a(a(paramn1));
        return paramn1;
    }

    private boolean c(n paramn) {
        if (!paramn.k().equals(a(paramn))) {
            return false;
        }
        paramn = paramn.d().values().iterator();
        while (paramn.hasNext()) {
            Object localObject = (o) paramn.next();
            byte[] arrayOfByte = c.b(((o) localObject).j());
            localObject = a((o) localObject);
            int i = 0;
            while (i < 4) {
                if (arrayOfByte[i] != localObject[i]) {
                    return false;
                }
                i += 1;
            }
        }
        return true;
    }

    public n a() {
        try {
            n localn = this.c;
            return localn;
        } finally {
            localObject =finally;
            throw ((Throwable) localObject);
        }
    }

    public String a(n paramn) {
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = new TreeMap(paramn.d()).entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            localStringBuilder.append((String) localEntry.getKey());
            localStringBuilder.append(((o) localEntry.getValue()).c());
            localStringBuilder.append(((o) localEntry.getValue()).f());
            localStringBuilder.append(((o) localEntry.getValue()).j());
        }
        localStringBuilder.append(paramn.b);
        return h.a(localStringBuilder.toString()).toLowerCase(Locale.US);
    }

    public byte[] a(o paramo) {
        Object localObject = ByteBuffer.allocate(8);
        ((ByteBuffer) localObject).order(null);
        ((ByteBuffer) localObject).putLong(paramo.f());
        paramo = ((ByteBuffer) localObject).array();
        localObject = b;
        byte[] arrayOfByte = new byte[4];
        int i = 0;
        while (i < 4) {
            arrayOfByte[i] = ((byte) (paramo[i] ^ localObject[i]));
            i += 1;
        }
        return arrayOfByte;
    }

    /* Error */
    public void b() {
        // Byte code:
        //   0: aconst_null
        //   1: astore_2
        //   2: aconst_null
        //   3: astore 4
        //   5: new 191	java/io/File
        //   8: dup
        //   9: aload_0
        //   10: getfield 35	com/umeng/analytics/a/f:d	Landroid/content/Context;
        //   13: invokevirtual 197	android/content/Context:getFilesDir	()Ljava/io/File;
        //   16: ldc 8
        //   18: invokespecial 200	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
        //   21: invokevirtual 203	java/io/File:exists	()Z
        //   24: ifne +4 -> 28
        //   27: return
        //   28: aload_0
        //   29: getfield 35	com/umeng/analytics/a/f:d	Landroid/content/Context;
        //   32: ldc 8
        //   34: invokevirtual 207	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
        //   37: astore_1
        //   38: aload_1
        //   39: astore_2
        //   40: aload_1
        //   41: invokestatic 210	com/umeng/common/util/h:b	(Ljava/io/InputStream;)[B
        //   44: astore_3
        //   45: aload_3
        //   46: astore_2
        //   47: aload_1
        //   48: invokestatic 213	com/umeng/common/util/h:c	(Ljava/io/InputStream;)V
        //   51: aload_2
        //   52: ifnull -25 -> 27
        //   55: new 38	com/umeng/analytics/d/n
        //   58: dup
        //   59: invokespecial 214	com/umeng/analytics/d/n:<init>	()V
        //   62: astore_1
        //   63: new 216	com/umeng/a/a/a/g
        //   66: dup
        //   67: invokespecial 217	com/umeng/a/a/a/g:<init>	()V
        //   70: aload_1
        //   71: aload_2
        //   72: invokevirtual 220	com/umeng/a/a/a/g:a	(Lcom/umeng/a/a/a/d;[B)V
        //   75: aload_0
        //   76: aload_1
        //   77: putfield 33	com/umeng/analytics/a/f:c	Lcom/umeng/analytics/d/n;
        //   80: return
        //   81: astore_1
        //   82: aload_1
        //   83: invokevirtual 223	java/lang/Exception:printStackTrace	()V
        //   86: return
        //   87: astore_3
        //   88: aconst_null
        //   89: astore_1
        //   90: aload_1
        //   91: astore_2
        //   92: aload_3
        //   93: invokevirtual 223	java/lang/Exception:printStackTrace	()V
        //   96: aload_1
        //   97: invokestatic 213	com/umeng/common/util/h:c	(Ljava/io/InputStream;)V
        //   100: aload 4
        //   102: astore_2
        //   103: goto -52 -> 51
        //   106: astore_1
        //   107: aload_2
        //   108: invokestatic 213	com/umeng/common/util/h:c	(Ljava/io/InputStream;)V
        //   111: aload_1
        //   112: athrow
        //   113: astore_1
        //   114: goto -7 -> 107
        //   117: astore_3
        //   118: goto -28 -> 90
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	121	0	this	f
        //   37	40	1	localObject1	Object
        //   81	2	1	localException1	Exception
        //   89	8	1	localInputStream	java.io.InputStream
        //   106	6	1	localObject2	Object
        //   113	1	1	localObject3	Object
        //   1	107	2	localObject4	Object
        //   44	2	3	arrayOfByte	byte[]
        //   87	6	3	localException2	Exception
        //   117	1	3	localException3	Exception
        //   3	98	4	localObject5	Object
        // Exception table:
        //   from	to	target	type
        //   55	80	81	java/lang/Exception
        //   28	38	87	java/lang/Exception
        //   28	38	106	finally
        //   40	45	113	finally
        //   92	96	113	finally
        //   40	45	117	java/lang/Exception
    }

    public void b(n paramn) {
        if (paramn == null) {
        }
        while (!c(paramn)) {
            return;
        }
        for (; ; ) {
            n localn;
            try {
                localn = this.c;
                if (localn == null) {
                    this.c = paramn;
                    return;
                }
            } finally {
            }
            paramn = a(localn, paramn);
        }
    }

    public void c() {
        if (this.c == null) {
            return;
        }
        try {
            byte[] arrayOfByte = new m().a(this.c);
            h.a(new File(this.d.getFilesDir(), ".imprint"), arrayOfByte);
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public boolean d() {
        return new File(this.d.getFilesDir(), ".imprint").delete();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/umeng/analytics/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */