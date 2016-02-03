package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

class hf
        implements hc {
    private IBinder a;

    hf(IBinder paramIBinder) {
        this.a = paramIBinder;
    }

    public boolean a() {
        boolean bool = false;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
            this.a.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int i = localParcel2.readInt();
            if (i != 0) {
                bool = true;
            }
            return bool;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }

    public String b() {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
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
    public android.content.Intent c() {
        // Byte code:
        //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 25
        //   11: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 15	com/google/android/gms/internal/hf:a	Landroid/os/IBinder;
        //   18: iconst_2
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
        //   39: getstatic 60	android/content/Intent:CREATOR	Landroid/os/Parcelable$Creator;
        //   42: aload_3
        //   43: invokeinterface 66 2 0
        //   48: checkcast 56	android/content/Intent
        //   51: astore_1
        //   52: aload_3
        //   53: invokevirtual 45	android/os/Parcel:recycle	()V
        //   56: aload_2
        //   57: invokevirtual 45	android/os/Parcel:recycle	()V
        //   60: aload_1
        //   61: areturn
        //   62: aconst_null
        //   63: astore_1
        //   64: goto -12 -> 52
        //   67: astore_1
        //   68: aload_3
        //   69: invokevirtual 45	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 45	android/os/Parcel:recycle	()V
        //   76: aload_1
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	hf
        //   51	13	1	localIntent	android.content.Intent
        //   67	10	1	localObject	Object
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	52	67	finally
    }

    public int d() {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
            this.a.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            int i = localParcel2.readInt();
            return i;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }

    public void e() {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseResult");
            this.a.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
        } finally {
            localParcel2.recycle();
            localParcel1.recycle();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/hf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */