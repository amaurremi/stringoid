package com.google.android.gms.internal;

import android.os.IBinder;

class hz
        implements hx {
    private IBinder a;

    hz(IBinder paramIBinder) {
        this.a = paramIBinder;
    }

    /* Error */
    public void a(hu paramhu) {
        // Byte code:
        //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 25
        //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_1
        //   19: invokeinterface 35 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 15	com/google/android/gms/internal/hz:a	Landroid/os/IBinder;
        //   34: iconst_2
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 44 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 47	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 50	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 50	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aconst_null
        //   58: astore_1
        //   59: goto -34 -> 25
        //   62: astore_1
        //   63: aload_3
        //   64: invokevirtual 50	android/os/Parcel:recycle	()V
        //   67: aload_2
        //   68: invokevirtual 50	android/os/Parcel:recycle	()V
        //   71: aload_1
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	hz
        //   0	73	1	paramhu	hu
        //   3	65	2	localParcel1	android.os.Parcel
        //   7	57	3	localParcel2	android.os.Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	62	finally
        //   18	25	62	finally
        //   25	48	62	finally
    }

    /* Error */
    public boolean a(String paramString1, String paramString2) {
        // Byte code:
        //   0: iconst_1
        //   1: istore 4
        //   3: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 25
        //   17: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 5
        //   22: aload_1
        //   23: invokevirtual 54	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   26: aload 5
        //   28: aload_2
        //   29: invokevirtual 54	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/internal/hz:a	Landroid/os/IBinder;
        //   36: iconst_1
        //   37: aload 5
        //   39: aload 6
        //   41: iconst_0
        //   42: invokeinterface 44 5 0
        //   47: pop
        //   48: aload 6
        //   50: invokevirtual 47	android/os/Parcel:readException	()V
        //   53: aload 6
        //   55: invokevirtual 58	android/os/Parcel:readInt	()I
        //   58: istore_3
        //   59: iload_3
        //   60: ifeq +16 -> 76
        //   63: aload 6
        //   65: invokevirtual 50	android/os/Parcel:recycle	()V
        //   68: aload 5
        //   70: invokevirtual 50	android/os/Parcel:recycle	()V
        //   73: iload 4
        //   75: ireturn
        //   76: iconst_0
        //   77: istore 4
        //   79: goto -16 -> 63
        //   82: astore_1
        //   83: aload 6
        //   85: invokevirtual 50	android/os/Parcel:recycle	()V
        //   88: aload 5
        //   90: invokevirtual 50	android/os/Parcel:recycle	()V
        //   93: aload_1
        //   94: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	95	0	this	hz
        //   0	95	1	paramString1	String
        //   0	95	2	paramString2	String
        //   58	2	3	i	int
        //   1	77	4	bool	boolean
        //   6	83	5	localParcel1	android.os.Parcel
        //   11	73	6	localParcel2	android.os.Parcel
        // Exception table:
        //   from	to	target	type
        //   13	59	82	finally
    }

    public IBinder asBinder() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/hz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */