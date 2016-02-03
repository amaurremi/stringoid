package com.google.android.gms.drive.realtime.internal;

import android.os.IBinder;

class w
  implements h
{
  private IBinder a;
  
  w(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  /* Error */
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   6: astore 5
    //   8: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   11: astore 6
    //   13: aload 5
    //   15: ldc 28
    //   17: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   20: iload_1
    //   21: ifeq +56 -> 77
    //   24: iconst_1
    //   25: istore_3
    //   26: aload 5
    //   28: iload_3
    //   29: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   32: iload_2
    //   33: ifeq +49 -> 82
    //   36: iload 4
    //   38: istore_3
    //   39: aload 5
    //   41: iload_3
    //   42: invokevirtual 36	android/os/Parcel:writeInt	(I)V
    //   45: aload_0
    //   46: getfield 15	com/google/android/gms/drive/realtime/internal/w:a	Landroid/os/IBinder;
    //   49: iconst_1
    //   50: aload 5
    //   52: aload 6
    //   54: iconst_0
    //   55: invokeinterface 42 5 0
    //   60: pop
    //   61: aload 6
    //   63: invokevirtual 45	android/os/Parcel:readException	()V
    //   66: aload 6
    //   68: invokevirtual 48	android/os/Parcel:recycle	()V
    //   71: aload 5
    //   73: invokevirtual 48	android/os/Parcel:recycle	()V
    //   76: return
    //   77: iconst_0
    //   78: istore_3
    //   79: goto -53 -> 26
    //   82: iconst_0
    //   83: istore_3
    //   84: goto -45 -> 39
    //   87: astore 7
    //   89: aload 6
    //   91: invokevirtual 48	android/os/Parcel:recycle	()V
    //   94: aload 5
    //   96: invokevirtual 48	android/os/Parcel:recycle	()V
    //   99: aload 7
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	w
    //   0	102	1	paramBoolean1	boolean
    //   0	102	2	paramBoolean2	boolean
    //   25	59	3	i	int
    //   1	36	4	j	int
    //   6	89	5	localParcel1	android.os.Parcel
    //   11	79	6	localParcel2	android.os.Parcel
    //   87	13	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	20	87	finally
    //   26	32	87	finally
    //   39	66	87	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */