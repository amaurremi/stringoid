package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public abstract interface IRoomServiceCallbacks
  extends IInterface
{
  public abstract void a(ParcelFileDescriptor paramParcelFileDescriptor, int paramInt)
    throws RemoteException;
  
  public abstract void a(ConnectionInfo paramConnectionInfo)
    throws RemoteException;
  
  public abstract void a(String paramString, byte[] paramArrayOfByte, int paramInt)
    throws RemoteException;
  
  public abstract void a(String paramString, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void al(IBinder paramIBinder)
    throws RemoteException;
  
  public abstract void b(String paramString, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void bg(String paramString)
    throws RemoteException;
  
  public abstract void bh(String paramString)
    throws RemoteException;
  
  public abstract void bi(String paramString)
    throws RemoteException;
  
  public abstract void bj(String paramString)
    throws RemoteException;
  
  public abstract void bk(String paramString)
    throws RemoteException;
  
  public abstract void bl(String paramString)
    throws RemoteException;
  
  public abstract void bm(String paramString)
    throws RemoteException;
  
  public abstract void c(int paramInt1, int paramInt2, String paramString)
    throws RemoteException;
  
  public abstract void c(String paramString, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void ck(int paramInt)
    throws RemoteException;
  
  public abstract void d(String paramString, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void e(String paramString, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void f(String paramString, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void g(String paramString, String[] paramArrayOfString)
    throws RemoteException;
  
  public abstract void hE()
    throws RemoteException;
  
  public abstract void hF()
    throws RemoteException;
  
  public abstract void onP2PConnected(String paramString)
    throws RemoteException;
  
  public abstract void onP2PDisconnected(String paramString)
    throws RemoteException;
  
  public abstract void t(String paramString, int paramInt)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IRoomServiceCallbacks
  {
    public Stub()
    {
      attachInterface(this, "com.google.android.gms.games.internal.IRoomServiceCallbacks");
    }
    
    public static IRoomServiceCallbacks am(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof IRoomServiceCallbacks))) {
        return (IRoomServiceCallbacks)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject2 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        return true;
      case 1001: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        c(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
        return true;
      case 1002: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        a(paramParcel1.readString(), paramParcel1.createByteArray(), paramParcel1.readInt());
        return true;
      case 1003: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        bg(paramParcel1.readString());
        return true;
      case 1004: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        bh(paramParcel1.readString());
        return true;
      case 1005: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        bi(paramParcel1.readString());
        return true;
      case 1006: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        bj(paramParcel1.readString());
        return true;
      case 1007: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        bk(paramParcel1.readString());
        return true;
      case 1008: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        a(paramParcel1.readString(), paramParcel1.createStringArray());
        return true;
      case 1009: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        b(paramParcel1.readString(), paramParcel1.createStringArray());
        return true;
      case 1010: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        c(paramParcel1.readString(), paramParcel1.createStringArray());
        return true;
      case 1011: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        d(paramParcel1.readString(), paramParcel1.createStringArray());
        return true;
      case 1012: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        e(paramParcel1.readString(), paramParcel1.createStringArray());
        return true;
      case 1013: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        f(paramParcel1.readString(), paramParcel1.createStringArray());
        return true;
      case 1014: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        onP2PConnected(paramParcel1.readString());
        return true;
      case 1015: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        onP2PDisconnected(paramParcel1.readString());
        return true;
      case 1016: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        hE();
        return true;
      case 1017: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        g(paramParcel1.readString(), paramParcel1.createStringArray());
        return true;
      case 1018: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        bl(paramParcel1.readString());
        return true;
      case 1019: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        bm(paramParcel1.readString());
        return true;
      case 1020: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        ck(paramParcel1.readInt());
        return true;
      case 1021: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        al(paramParcel1.readStrongBinder());
        return true;
      case 1022: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        paramParcel2 = (Parcel)localObject1;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = ConnectionInfo.CREATOR.bf(paramParcel1);
        }
        a(paramParcel2);
        return true;
      case 1023: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        hF();
        return true;
      case 1024: 
        paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
        paramParcel2 = (Parcel)localObject2;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, paramParcel1.readInt());
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      t(paramParcel1.readString(), paramParcel1.readInt());
      return true;
    }
    
    private static class Proxy
      implements IRoomServiceCallbacks
    {
      private IBinder ko;
      
      Proxy(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      /* Error */
      public void a(ParcelFileDescriptor paramParcelFileDescriptor, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: aload_3
        //   5: ldc 32
        //   7: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +40 -> 51
        //   14: aload_3
        //   15: iconst_1
        //   16: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_3
        //   21: iconst_0
        //   22: invokevirtual 46	android/os/ParcelFileDescriptor:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_3
        //   26: iload_2
        //   27: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   30: aload_0
        //   31: getfield 19	com/google/android/gms/games/internal/IRoomServiceCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   34: sipush 1024
        //   37: aload_3
        //   38: aconst_null
        //   39: iconst_1
        //   40: invokeinterface 52 5 0
        //   45: pop
        //   46: aload_3
        //   47: invokevirtual 55	android/os/Parcel:recycle	()V
        //   50: return
        //   51: aload_3
        //   52: iconst_0
        //   53: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   56: goto -31 -> 25
        //   59: astore_1
        //   60: aload_3
        //   61: invokevirtual 55	android/os/Parcel:recycle	()V
        //   64: aload_1
        //   65: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	66	0	this	Proxy
        //   0	66	1	paramParcelFileDescriptor	ParcelFileDescriptor
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
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 30	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: aload_2
        //   5: ldc 32
        //   7: invokevirtual 36	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   10: aload_1
        //   11: ifnull +35 -> 46
        //   14: aload_2
        //   15: iconst_1
        //   16: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokevirtual 60	com/google/android/gms/games/internal/ConnectionInfo:writeToParcel	(Landroid/os/Parcel;I)V
        //   25: aload_0
        //   26: getfield 19	com/google/android/gms/games/internal/IRoomServiceCallbacks$Stub$Proxy:ko	Landroid/os/IBinder;
        //   29: sipush 1022
        //   32: aload_2
        //   33: aconst_null
        //   34: iconst_1
        //   35: invokeinterface 52 5 0
        //   40: pop
        //   41: aload_2
        //   42: invokevirtual 55	android/os/Parcel:recycle	()V
        //   45: return
        //   46: aload_2
        //   47: iconst_0
        //   48: invokevirtual 40	android/os/Parcel:writeInt	(I)V
        //   51: goto -26 -> 25
        //   54: astore_1
        //   55: aload_2
        //   56: invokevirtual 55	android/os/Parcel:recycle	()V
        //   59: aload_1
        //   60: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	61	0	this	Proxy
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
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          localParcel.writeByteArray(paramArrayOfByte);
          localParcel.writeInt(paramInt);
          this.ko.transact(1002, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(String paramString, String[] paramArrayOfString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          localParcel.writeStringArray(paramArrayOfString);
          this.ko.transact(1008, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void al(IBinder paramIBinder)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeStrongBinder(paramIBinder);
          this.ko.transact(1021, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
      
      public void b(String paramString, String[] paramArrayOfString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          localParcel.writeStringArray(paramArrayOfString);
          this.ko.transact(1009, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void bg(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          this.ko.transact(1003, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void bh(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          this.ko.transact(1004, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void bi(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          this.ko.transact(1005, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void bj(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          this.ko.transact(1006, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void bk(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          this.ko.transact(1007, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void bl(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          this.ko.transact(1018, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void bm(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          this.ko.transact(1019, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void c(int paramInt1, int paramInt2, String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeInt(paramInt1);
          localParcel.writeInt(paramInt2);
          localParcel.writeString(paramString);
          this.ko.transact(1001, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void c(String paramString, String[] paramArrayOfString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          localParcel.writeStringArray(paramArrayOfString);
          this.ko.transact(1010, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void ck(int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeInt(paramInt);
          this.ko.transact(1020, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void d(String paramString, String[] paramArrayOfString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          localParcel.writeStringArray(paramArrayOfString);
          this.ko.transact(1011, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void e(String paramString, String[] paramArrayOfString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          localParcel.writeStringArray(paramArrayOfString);
          this.ko.transact(1012, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void f(String paramString, String[] paramArrayOfString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          localParcel.writeStringArray(paramArrayOfString);
          this.ko.transact(1013, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void g(String paramString, String[] paramArrayOfString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          localParcel.writeStringArray(paramArrayOfString);
          this.ko.transact(1017, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void hE()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          this.ko.transact(1016, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void hF()
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          this.ko.transact(1023, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void onP2PConnected(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          this.ko.transact(1014, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void onP2PDisconnected(String paramString)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          this.ko.transact(1015, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void t(String paramString, int paramInt)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.games.internal.IRoomServiceCallbacks");
          localParcel.writeString(paramString);
          localParcel.writeInt(paramInt);
          this.ko.transact(1025, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/games/internal/IRoomServiceCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */