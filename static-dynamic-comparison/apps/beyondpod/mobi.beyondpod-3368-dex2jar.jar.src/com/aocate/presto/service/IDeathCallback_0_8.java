package com.aocate.presto.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IDeathCallback_0_8
  extends IInterface
{
  public static abstract class Stub
    extends Binder
    implements IDeathCallback_0_8
  {
    private static final String DESCRIPTOR = "com.aocate.presto.service.IDeathCallback_0_8";
    
    public Stub()
    {
      attachInterface(this, "com.aocate.presto.service.IDeathCallback_0_8");
    }
    
    public static IDeathCallback_0_8 asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.aocate.presto.service.IDeathCallback_0_8");
      if ((localIInterface != null) && ((localIInterface instanceof IDeathCallback_0_8))) {
        return (IDeathCallback_0_8)localIInterface;
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
      }
      paramParcel2.writeString("com.aocate.presto.service.IDeathCallback_0_8");
      return true;
    }
    
    private static class Proxy
      implements IDeathCallback_0_8
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
        return "com.aocate.presto.service.IDeathCallback_0_8";
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/aocate/presto/service/IDeathCallback_0_8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */