package com.aocate.presto.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IOnPitchAdjustmentAvailableChangedListenerCallback_0_8
  extends IInterface
{
  public abstract void onPitchAdjustmentAvailableChanged(boolean paramBoolean)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IOnPitchAdjustmentAvailableChangedListenerCallback_0_8
  {
    private static final String DESCRIPTOR = "com.aocate.presto.service.IOnPitchAdjustmentAvailableChangedListenerCallback_0_8";
    static final int TRANSACTION_onPitchAdjustmentAvailableChanged = 1;
    
    public Stub()
    {
      attachInterface(this, "com.aocate.presto.service.IOnPitchAdjustmentAvailableChangedListenerCallback_0_8");
    }
    
    public static IOnPitchAdjustmentAvailableChangedListenerCallback_0_8 asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.aocate.presto.service.IOnPitchAdjustmentAvailableChangedListenerCallback_0_8");
      if ((localIInterface != null) && ((localIInterface instanceof IOnPitchAdjustmentAvailableChangedListenerCallback_0_8))) {
        return (IOnPitchAdjustmentAvailableChangedListenerCallback_0_8)localIInterface;
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
        paramParcel2.writeString("com.aocate.presto.service.IOnPitchAdjustmentAvailableChangedListenerCallback_0_8");
        return true;
      }
      paramParcel1.enforceInterface("com.aocate.presto.service.IOnPitchAdjustmentAvailableChangedListenerCallback_0_8");
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        onPitchAdjustmentAvailableChanged(bool);
        paramParcel2.writeNoException();
        return true;
      }
    }
    
    private static class Proxy
      implements IOnPitchAdjustmentAvailableChangedListenerCallback_0_8
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
        return "com.aocate.presto.service.IOnPitchAdjustmentAvailableChangedListenerCallback_0_8";
      }
      
      /* Error */
      public void onPitchAdjustmentAvailableChanged(boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_3
        //   6: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   9: astore 4
        //   11: aload_3
        //   12: ldc 26
        //   14: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: iload_1
        //   18: ifeq +38 -> 56
        //   21: aload_3
        //   22: iload_2
        //   23: invokevirtual 44	android/os/Parcel:writeInt	(I)V
        //   26: aload_0
        //   27: getfield 19	com/aocate/presto/service/IOnPitchAdjustmentAvailableChangedListenerCallback_0_8$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   30: iconst_1
        //   31: aload_3
        //   32: aload 4
        //   34: iconst_0
        //   35: invokeinterface 50 5 0
        //   40: pop
        //   41: aload 4
        //   43: invokevirtual 53	android/os/Parcel:readException	()V
        //   46: aload 4
        //   48: invokevirtual 56	android/os/Parcel:recycle	()V
        //   51: aload_3
        //   52: invokevirtual 56	android/os/Parcel:recycle	()V
        //   55: return
        //   56: iconst_0
        //   57: istore_2
        //   58: goto -37 -> 21
        //   61: astore 5
        //   63: aload 4
        //   65: invokevirtual 56	android/os/Parcel:recycle	()V
        //   68: aload_3
        //   69: invokevirtual 56	android/os/Parcel:recycle	()V
        //   72: aload 5
        //   74: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	75	0	this	Proxy
        //   0	75	1	paramBoolean	boolean
        //   1	57	2	i	int
        //   5	64	3	localParcel1	Parcel
        //   9	55	4	localParcel2	Parcel
        //   61	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   11	17	61	finally
        //   21	46	61	finally
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/aocate/presto/service/IOnPitchAdjustmentAvailableChangedListenerCallback_0_8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */