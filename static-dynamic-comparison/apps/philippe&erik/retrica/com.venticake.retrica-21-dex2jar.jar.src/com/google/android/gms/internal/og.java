package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

class og
  implements gb
{
  private IBinder a;
  
  og(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void L(int paramInt)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
      localParcel1.writeInt(paramInt);
      this.a.transact(5005, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public void a(int paramInt, com.google.android.gms.common.data.DataHolder paramDataHolder)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore 4
    //   9: aload_3
    //   10: ldc 26
    //   12: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   15: aload_3
    //   16: iload_1
    //   17: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   20: aload_2
    //   21: ifnull +46 -> 67
    //   24: aload_3
    //   25: iconst_1
    //   26: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   29: aload_2
    //   30: aload_3
    //   31: iconst_0
    //   32: invokevirtual 52	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
    //   35: aload_0
    //   36: getfield 15	com/google/android/gms/internal/og:a	Landroid/os/IBinder;
    //   39: sipush 5001
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: invokeinterface 39 5 0
    //   51: pop
    //   52: aload 4
    //   54: invokevirtual 42	android/os/Parcel:readException	()V
    //   57: aload 4
    //   59: invokevirtual 45	android/os/Parcel:recycle	()V
    //   62: aload_3
    //   63: invokevirtual 45	android/os/Parcel:recycle	()V
    //   66: return
    //   67: aload_3
    //   68: iconst_0
    //   69: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   72: goto -37 -> 35
    //   75: astore_2
    //   76: aload 4
    //   78: invokevirtual 45	android/os/Parcel:recycle	()V
    //   81: aload_3
    //   82: invokevirtual 45	android/os/Parcel:recycle	()V
    //   85: aload_2
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	og
    //   0	87	1	paramInt	int
    //   0	87	2	paramDataHolder	com.google.android.gms.common.data.DataHolder
    //   3	79	3	localParcel1	Parcel
    //   7	70	4	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   9	20	75	finally
    //   24	35	75	finally
    //   35	57	75	finally
    //   67	72	75	finally
  }
  
  /* Error */
  public void a(com.google.android.gms.common.data.DataHolder paramDataHolder)
  {
    // Byte code:
    //   0: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: invokestatic 24	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   7: astore_3
    //   8: aload_2
    //   9: ldc 26
    //   11: invokevirtual 30	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   14: aload_1
    //   15: ifnull +43 -> 58
    //   18: aload_2
    //   19: iconst_1
    //   20: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   23: aload_1
    //   24: aload_2
    //   25: iconst_0
    //   26: invokevirtual 52	com/google/android/gms/common/data/DataHolder:writeToParcel	(Landroid/os/Parcel;I)V
    //   29: aload_0
    //   30: getfield 15	com/google/android/gms/internal/og:a	Landroid/os/IBinder;
    //   33: sipush 5002
    //   36: aload_2
    //   37: aload_3
    //   38: iconst_0
    //   39: invokeinterface 39 5 0
    //   44: pop
    //   45: aload_3
    //   46: invokevirtual 42	android/os/Parcel:readException	()V
    //   49: aload_3
    //   50: invokevirtual 45	android/os/Parcel:recycle	()V
    //   53: aload_2
    //   54: invokevirtual 45	android/os/Parcel:recycle	()V
    //   57: return
    //   58: aload_2
    //   59: iconst_0
    //   60: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   63: goto -34 -> 29
    //   66: astore_1
    //   67: aload_3
    //   68: invokevirtual 45	android/os/Parcel:recycle	()V
    //   71: aload_2
    //   72: invokevirtual 45	android/os/Parcel:recycle	()V
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	og
    //   0	77	1	paramDataHolder	com.google.android.gms.common.data.DataHolder
    //   3	69	2	localParcel1	Parcel
    //   7	61	3	localParcel2	Parcel
    // Exception table:
    //   from	to	target	type
    //   8	14	66	finally
    //   18	29	66	finally
    //   29	49	66	finally
    //   58	63	66	finally
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
      localParcel1.writeInt(paramInt1);
      localParcel1.writeInt(paramInt2);
      this.a.transact(5003, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public void dT()
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
      this.a.transact(5004, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/og.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */