package com.google.android.gms.maps.internal;

import android.os.IBinder;

class aq
  implements l
{
  private IBinder a;
  
  aq(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public boolean a(com.google.android.gms.maps.model.internal.f paramf)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore 4
    //   7: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   10: astore 5
    //   12: aload 4
    //   14: ldc 25
    //   16: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: ifnull +59 -> 79
    //   23: aload_1
    //   24: invokeinterface 35 1 0
    //   29: astore_1
    //   30: aload 4
    //   32: aload_1
    //   33: invokevirtual 38	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   36: aload_0
    //   37: getfield 15	com/google/android/gms/maps/internal/aq:a	Landroid/os/IBinder;
    //   40: iconst_1
    //   41: aload 4
    //   43: aload 5
    //   45: iconst_0
    //   46: invokeinterface 44 5 0
    //   51: pop
    //   52: aload 5
    //   54: invokevirtual 47	android/os/Parcel:readException	()V
    //   57: aload 5
    //   59: invokevirtual 51	android/os/Parcel:readInt	()I
    //   62: istore_2
    //   63: iload_2
    //   64: ifeq +20 -> 84
    //   67: aload 5
    //   69: invokevirtual 54	android/os/Parcel:recycle	()V
    //   72: aload 4
    //   74: invokevirtual 54	android/os/Parcel:recycle	()V
    //   77: iload_3
    //   78: ireturn
    //   79: aconst_null
    //   80: astore_1
    //   81: goto -51 -> 30
    //   84: iconst_0
    //   85: istore_3
    //   86: goto -19 -> 67
    //   89: astore_1
    //   90: aload 5
    //   92: invokevirtual 54	android/os/Parcel:recycle	()V
    //   95: aload 4
    //   97: invokevirtual 54	android/os/Parcel:recycle	()V
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	aq
    //   0	102	1	paramf	com.google.android.gms.maps.model.internal.f
    //   62	2	2	i	int
    //   1	85	3	bool	boolean
    //   5	91	4	localParcel1	android.os.Parcel
    //   10	81	5	localParcel2	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   12	19	89	finally
    //   23	30	89	finally
    //   30	63	89	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/internal/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */