package com.google.android.gms.internal;

import android.os.RemoteException;

@ii
public abstract class jy
        extends lo {
    private final fi a;
    private final jx b;

    public jy(fi paramfi, jx paramjx) {
        this.a = paramfi;
        this.b = paramjx;
    }

    private static fk a(kf paramkf, fi paramfi) {
        try {
            paramkf = paramkf.a(paramfi);
            return paramkf;
        } catch (RemoteException paramkf) {
            mx.d("Could not fetch ad response from ad request service.", paramkf);
            return null;
        } catch (NullPointerException paramkf) {
            mx.d("Could not fetch ad response from ad request service due to an Exception.", paramkf);
            return null;
        } catch (SecurityException paramkf) {
            mx.d("Could not fetch ad response from ad request service due to an Exception.", paramkf);
            return null;
        } catch (Throwable paramkf) {
            lj.a(paramkf);
        }
        return null;
    }

    /* Error */
    public final void a() {
        // Byte code:
        //   0: aload_0
        //   1: invokevirtual 51	com/google/android/gms/internal/jy:d	()Lcom/google/android/gms/internal/kf;
        //   4: astore_1
        //   5: aload_1
        //   6: ifnonnull +27 -> 33
        //   9: new 53	com/google/android/gms/internal/fk
        //   12: dup
        //   13: iconst_0
        //   14: invokespecial 56	com/google/android/gms/internal/fk:<init>	(I)V
        //   17: astore_1
        //   18: aload_0
        //   19: invokevirtual 59	com/google/android/gms/internal/jy:c	()V
        //   22: aload_0
        //   23: getfield 18	com/google/android/gms/internal/jy:b	Lcom/google/android/gms/internal/jx;
        //   26: aload_1
        //   27: invokeinterface 64 2 0
        //   32: return
        //   33: aload_1
        //   34: aload_0
        //   35: getfield 16	com/google/android/gms/internal/jy:a	Lcom/google/android/gms/internal/fi;
        //   38: invokestatic 66	com/google/android/gms/internal/jy:a	(Lcom/google/android/gms/internal/kf;Lcom/google/android/gms/internal/fi;)Lcom/google/android/gms/internal/fk;
        //   41: astore_2
        //   42: aload_2
        //   43: astore_1
        //   44: aload_2
        //   45: ifnonnull -27 -> 18
        //   48: new 53	com/google/android/gms/internal/fk
        //   51: dup
        //   52: iconst_0
        //   53: invokespecial 56	com/google/android/gms/internal/fk:<init>	(I)V
        //   56: astore_1
        //   57: goto -39 -> 18
        //   60: astore_1
        //   61: aload_0
        //   62: invokevirtual 59	com/google/android/gms/internal/jy:c	()V
        //   65: aload_1
        //   66: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	67	0	this	jy
        //   4	53	1	localObject1	Object
        //   60	6	1	localObject2	Object
        //   41	4	2	localfk	fk
        // Exception table:
        //   from	to	target	type
        //   0	5	60	finally
        //   9	18	60	finally
        //   33	42	60	finally
        //   48	57	60	finally
    }

    public final void b() {
        c();
    }

    public abstract void c();

    public abstract kf d();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/jy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */