package com.google.android.gms.games.internal;

import android.os.IBinder;
import android.os.Parcel;

class do
  implements IRoomServiceCallbacks
{
  private IBinder a;
  
  do(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  /* Error */
  public void a(android.os.ParcelFileDescriptor paramParcelFileDescriptor, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_3
    //   4: aload_3
    //   5: ldc 25
    //   7: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +40 -> 51
    //   14: aload_3
    //   15: iconst_1
    //   16: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_3
    //   21: iconst_0
    //   22: invokevirtual 39	android/os/ParcelFileDescriptor:writeToParcel	(Landroid/os/Parcel;I)V
    //   25: aload_3
    //   26: iload_2
    //   27: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   30: aload_0
    //   31: getfield 15	com/google/android/gms/games/internal/do:a	Landroid/os/IBinder;
    //   34: sipush 1024
    //   37: aload_3
    //   38: aconst_null
    //   39: iconst_1
    //   40: invokeinterface 45 5 0
    //   45: pop
    //   46: aload_3
    //   47: invokevirtual 48	android/os/Parcel:recycle	()V
    //   50: return
    //   51: aload_3
    //   52: iconst_0
    //   53: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   56: goto -31 -> 25
    //   59: astore_1
    //   60: aload_3
    //   61: invokevirtual 48	android/os/Parcel:recycle	()V
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	do
    //   0	66	1	paramParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   0	66	2	paramInt	int
    //   3	58	3	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   4	10	59	finally
    //   14	25	59	finally
    //   25	46	59	finally
    //   51	56	59	finally
  }
  
  /* Error */
  public void a(ConnectionInfo paramConnectionInfo)
  {
    // Byte code:
    //   0: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc 25
    //   7: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: ifnull +35 -> 46
    //   14: aload_2
    //   15: iconst_1
    //   16: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   19: aload_1
    //   20: aload_2
    //   21: iconst_0
    //   22: invokevirtual 52	com/google/android/gms/games/internal/ConnectionInfo:writeToParcel	(Landroid/os/Parcel;I)V
    //   25: aload_0
    //   26: getfield 15	com/google/android/gms/games/internal/do:a	Landroid/os/IBinder;
    //   29: sipush 1022
    //   32: aload_2
    //   33: aconst_null
    //   34: iconst_1
    //   35: invokeinterface 45 5 0
    //   40: pop
    //   41: aload_2
    //   42: invokevirtual 48	android/os/Parcel:recycle	()V
    //   45: return
    //   46: aload_2
    //   47: iconst_0
    //   48: invokevirtual 33	android/os/Parcel:writeInt	(I)V
    //   51: goto -26 -> 25
    //   54: astore_1
    //   55: aload_2
    //   56: invokevirtual 48	android/os/Parcel:recycle	()V
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	do
    //   0	61	1	paramConnectionInfo	ConnectionInfo
    //   3	53	2	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   4	10	54	finally
    //   14	25	54	finally
    //   25	41	54	finally
    //   46	51	54	finally
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      localParcel.writeByteArray(paramArrayOfByte);
      localParcel.writeInt(paramInt);
      this.a.transact(1002, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void a(String paramString, String[] paramArrayOfString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      localParcel.writeStringArray(paramArrayOfString);
      this.a.transact(1008, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void al(IBinder paramIBinder)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeStrongBinder(paramIBinder);
      this.a.transact(1021, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public void b(String paramString, String[] paramArrayOfString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      localParcel.writeStringArray(paramArrayOfString);
      this.a.transact(1009, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void bg(String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      this.a.transact(1003, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void bh(String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      this.a.transact(1004, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void bi(String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      this.a.transact(1005, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void bj(String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      this.a.transact(1006, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void bk(String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      this.a.transact(1007, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void bl(String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      this.a.transact(1018, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void bm(String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      this.a.transact(1019, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void c(int paramInt1, int paramInt2, String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeInt(paramInt1);
      localParcel.writeInt(paramInt2);
      localParcel.writeString(paramString);
      this.a.transact(1001, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void c(String paramString, String[] paramArrayOfString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      localParcel.writeStringArray(paramArrayOfString);
      this.a.transact(1010, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void ck(int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeInt(paramInt);
      this.a.transact(1020, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void d(String paramString, String[] paramArrayOfString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      localParcel.writeStringArray(paramArrayOfString);
      this.a.transact(1011, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void e(String paramString, String[] paramArrayOfString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      localParcel.writeStringArray(paramArrayOfString);
      this.a.transact(1012, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void f(String paramString, String[] paramArrayOfString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      localParcel.writeStringArray(paramArrayOfString);
      this.a.transact(1013, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void g(String paramString, String[] paramArrayOfString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      localParcel.writeStringArray(paramArrayOfString);
      this.a.transact(1017, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void hJ()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      this.a.transact(1016, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void hK()
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      this.a.transact(1023, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void onP2PConnected(String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      this.a.transact(1014, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void onP2PDisconnected(String paramString)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      this.a.transact(1015, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void t(String paramString, int paramInt)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      localParcel.writeString(paramString);
      localParcel.writeInt(paramInt);
      this.a.transact(1025, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */