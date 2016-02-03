package com.google.android.gms.internal;

import android.os.IBinder;

class dc
        implements da {
    private IBinder a;

    dc(IBinder paramIBinder) {
        this.a = paramIBinder;
    }

    /* Error */
    public android.os.Bundle a() {
        // Byte code:
        //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 25
        //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 15	com/google/android/gms/internal/dc:a	Landroid/os/IBinder;
        //   18: iconst_1
        //   19: aload_2
        //   20: aload_3
        //   21: iconst_0
        //   22: invokeinterface 35 5 0
        //   27: pop
        //   28: aload_3
        //   29: invokevirtual 38	android/os/Parcel:readException	()V
        //   32: aload_3
        //   33: invokevirtual 42	android/os/Parcel:readInt	()I
        //   36: ifeq +26 -> 62
        //   39: getstatic 48	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   42: aload_3
        //   43: invokeinterface 54 2 0
        //   48: checkcast 44	android/os/Bundle
        //   51: astore_1
        //   52: aload_3
        //   53: invokevirtual 57	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 57	android/os/Parcel:recycle	()V
        //   60: aload_1
        //   61: areturn
        //   62: aconst_null
        //   63: astore_1
        //   64: goto -12 -> 52
        //   67: astore_1
        //   68: aload_3
        //   69: invokevirtual 57	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 57	android/os/Parcel:recycle	()V
        //   76: aload_1
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	dc
        //   51	13	1	localBundle	android.os.Bundle
        //   67	10	1	localObject	Object
        //   3	70	2	localParcel1	android.os.Parcel
        //   7	62	3	localParcel2	android.os.Parcel
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
    }

    public IBinder asBinder() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */