package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

class hw
        implements hu {
    private IBinder a;

    hw(IBinder paramIBinder) {
        this.a = paramIBinder;
    }

    public String a() {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
            this.a.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            String str = localParcel2.readString();
            return str;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }

    /* Error */
    public void a(com.google.android.gms.b.a parama) {
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
        //   19: invokeinterface 51 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 54	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 15	com/google/android/gms/internal/hw:a	Landroid/os/IBinder;
        //   34: iconst_3
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 35 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 38	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 44	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 44	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aconst_null
        //   58: astore_1
        //   59: goto -34 -> 25
        //   62: astore_1
        //   63: aload_3
        //   64: invokevirtual 44	android/os/Parcel:recycle	()V
        //   67: aload_2
        //   68: invokevirtual 44	android/os/Parcel:recycle	()V
        //   71: aload_1
        //   72: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	73	0	this	hw
        //   0	73	1	parama	com.google.android.gms.b.a
        //   3	65	2	localParcel1	Parcel
        //   7	57	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	62	finally
        //   18	25	62	finally
        //   25	48	62	finally
    }

    public IBinder asBinder() {
        return this.a;
    }

    public String b() {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
            this.a.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            String str = localParcel2.readString();
            return str;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }

    public void c() {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
            this.a.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }

    public void d() {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.rawhtmlad.client.IRawHtmlAd");
            this.a.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/hw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */