package com.google.android.gms.internal;

import android.os.IBinder;

class ov
  implements hj
{
  private IBinder a;
  
  ov(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public com.google.android.gms.dynamic.d a(com.google.android.gms.dynamic.d paramd, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore 4
    //   5: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 5
    //   10: aload 4
    //   12: ldc 25
    //   14: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: ifnull +70 -> 88
    //   21: aload_1
    //   22: invokeinterface 35 1 0
    //   27: astore_1
    //   28: aload 4
    //   30: aload_1
    //   31: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   34: aload 4
    //   36: iload_2
    //   37: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   40: aload 4
    //   42: iload_3
    //   43: invokevirtual 42	android/os/Parcel:writeInt	(I)V
    //   46: aload_0
    //   47: getfield 15	com/google/android/gms/internal/ov:a	Landroid/os/IBinder;
    //   50: iconst_1
    //   51: aload 4
    //   53: aload 5
    //   55: iconst_0
    //   56: invokeinterface 48 5 0
    //   61: pop
    //   62: aload 5
    //   64: invokevirtual 51	android/os/Parcel:readException	()V
    //   67: aload 5
    //   69: invokevirtual 54	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
    //   72: invokestatic 60	com/google/android/gms/dynamic/d$a:ag	(Landroid/os/IBinder;)Lcom/google/android/gms/dynamic/d;
    //   75: astore_1
    //   76: aload 5
    //   78: invokevirtual 63	android/os/Parcel:recycle	()V
    //   81: aload 4
    //   83: invokevirtual 63	android/os/Parcel:recycle	()V
    //   86: aload_1
    //   87: areturn
    //   88: aconst_null
    //   89: astore_1
    //   90: goto -62 -> 28
    //   93: astore_1
    //   94: aload 5
    //   96: invokevirtual 63	android/os/Parcel:recycle	()V
    //   99: aload 4
    //   101: invokevirtual 63	android/os/Parcel:recycle	()V
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	ov
    //   0	106	1	paramd	com.google.android.gms.dynamic.d
    //   0	106	2	paramInt1	int
    //   0	106	3	paramInt2	int
    //   3	97	4	localParcel1	android.os.Parcel
    //   8	87	5	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   10	17	93	finally
    //   21	28	93	finally
    //   28	76	93	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ov.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */