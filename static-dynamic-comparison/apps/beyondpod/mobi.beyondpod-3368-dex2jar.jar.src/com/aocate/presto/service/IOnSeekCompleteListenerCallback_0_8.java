package com.aocate.presto.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IOnSeekCompleteListenerCallback_0_8
  extends IInterface
{
  public abstract void onSeekComplete()
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IOnSeekCompleteListenerCallback_0_8
  {
    private static final String DESCRIPTOR = "com.aocate.presto.service.IOnSeekCompleteListenerCallback_0_8";
    static final int TRANSACTION_onSeekComplete = 1;
    
    public Stub()
    {
      attachInterface(this, "com.aocate.presto.service.IOnSeekCompleteListenerCallback_0_8");
    }
    
    public static IOnSeekCompleteListenerCallback_0_8 asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.aocate.presto.service.IOnSeekCompleteListenerCallback_0_8");
      if ((localIInterface != null) && ((localIInterface instanceof IOnSeekCompleteListenerCallback_0_8))) {
        return (IOnSeekCompleteListenerCallback_0_8)localIInterface;
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
        paramParcel2.writeString("com.aocate.presto.service.IOnSeekCompleteListenerCallback_0_8");
        return true;
      }
      paramParcel1.enforceInterface("com.aocate.presto.service.IOnSeekCompleteListenerCallback_0_8");
      onSeekComplete();
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class Proxy
      implements IOnSeekCompleteListenerCallback_0_8
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
        return "com.aocate.presto.service.IOnSeekCompleteListenerCallback_0_8";
      }
      
      public void onSeekComplete()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.aocate.presto.service.IOnSeekCompleteListenerCallback_0_8");
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
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
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/aocate/presto/service/IOnSeekCompleteListenerCallback_0_8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */