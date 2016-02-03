package com.aocate.presto.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IOnInfoListenerCallback_0_8
  extends IInterface
{
  public abstract boolean onInfo(int paramInt1, int paramInt2)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IOnInfoListenerCallback_0_8
  {
    private static final String DESCRIPTOR = "com.aocate.presto.service.IOnInfoListenerCallback_0_8";
    static final int TRANSACTION_onInfo = 1;
    
    public Stub()
    {
      attachInterface(this, "com.aocate.presto.service.IOnInfoListenerCallback_0_8");
    }
    
    public static IOnInfoListenerCallback_0_8 asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.aocate.presto.service.IOnInfoListenerCallback_0_8");
      if ((localIInterface != null) && ((localIInterface instanceof IOnInfoListenerCallback_0_8))) {
        return (IOnInfoListenerCallback_0_8)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.aocate.presto.service.IOnInfoListenerCallback_0_8");
        return true;
      }
      paramParcel1.enforceInterface("com.aocate.presto.service.IOnInfoListenerCallback_0_8");
      boolean bool = onInfo(paramParcel1.readInt(), paramParcel1.readInt());
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    }
    
    private static class Proxy
      implements IOnInfoListenerCallback_0_8
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.aocate.presto.service.IOnInfoListenerCallback_0_8";
      }
      
      /* Error */
      public boolean onInfo(int paramInt1, int paramInt2)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore 4
        //   7: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   10: astore 5
        //   12: aload 4
        //   14: ldc 26
        //   16: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   19: aload 4
        //   21: iload_1
        //   22: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   25: aload 4
        //   27: iload_2
        //   28: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   31: aload_0
        //   32: getfield 19	com/aocate/presto/service/IOnInfoListenerCallback_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   35: iconst_1
        //   36: aload 4
        //   38: aload 5
        //   40: iconst_0
        //   41: invokeinterface 50 5 0
        //   46: pop
        //   47: aload 5
        //   49: invokevirtual 53	android/os/Parcel:readException	()V
        //   52: aload 5
        //   54: invokevirtual 57	android/os/Parcel:readInt	()I
        //   57: istore_1
        //   58: iload_1
        //   59: ifeq +15 -> 74
        //   62: aload 5
        //   64: invokevirtual 60	android/os/Parcel:recycle	()V
        //   67: aload 4
        //   69: invokevirtual 60	android/os/Parcel:recycle	()V
        //   72: iload_3
        //   73: ireturn
        //   74: iconst_0
        //   75: istore_3
        //   76: goto -14 -> 62
        //   79: astore 6
        //   81: aload 5
        //   83: invokevirtual 60	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: invokevirtual 60	android/os/Parcel:recycle	()V
        //   91: aload 6
        //   93: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	94	0	this	Proxy
        //   0	94	1	paramInt1	int
        //   0	94	2	paramInt2	int
        //   1	75	3	bool	boolean
        //   5	82	4	localParcel1	Parcel
        //   10	72	5	localParcel2	Parcel
        //   79	13	6	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   12	58	79	finally
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/aocate/presto/service/IOnInfoListenerCallback_0_8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */