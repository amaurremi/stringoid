package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;

class w
        implements s {
    private IBinder a;

    w(IBinder paramIBinder) {
        this.a = paramIBinder;
    }

    public void a() {
        Parcel localParcel = Parcel.obtain();
        try {
            localParcel.writeInterfaceToken("com.google.android.gms.fitness.request.IBleScanCallback");
            this.a.transact(2, localParcel, null, 1);
            return;
        } finally {
            localParcel.recycle();
        }
    }

    /* Error */
    public void a(com.google.android.gms.fitness.data.BleDevice paramBleDevice) {
        // Byte code:
        //   0: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 24
        //   7: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +33 -> 44
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 48	com/google/android/gms/fitness/data/BleDevice:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 15	com/google/android/gms/fitness/request/w:a	Landroid/os/IBinder;
        //   29: iconst_1
        //   30: aload_2
        //   31: aconst_null
        //   32: iconst_1
        //   33: invokeinterface 34 5 0
        //   38: pop
        //   39: aload_2
        //   40: invokevirtual 37	android/os/Parcel:recycle	()V
        //   43: return
        //   44: aload_2
        //   45: iconst_0
        //   46: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   49: goto -24 -> 25
        //   52: astore_1
        //   53: aload_2
        //   54: invokevirtual 37	android/os/Parcel:recycle	()V
        //   57: aload_1
        //   58: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	59	0	this	w
        //   0	59	1	paramBleDevice	com.google.android.gms.fitness.data.BleDevice
        //   3	51	2	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   4	10	52	finally
        //   14	25	52	finally
        //   25	39	52	finally
        //   44	49	52	finally
    }

    public IBinder asBinder() {
        return this.a;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */