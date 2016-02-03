package com.google.android.gms.common.annotation;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IGooglePlayServicesRocks
  extends IInterface
{
  public static abstract class Stub
    extends Binder
    implements IGooglePlayServicesRocks
  {
    public Stub()
    {
      attachInterface(this, "com.google.android.gms.common.annotation.IGooglePlayServicesRocks");
    }
    
    public static IGooglePlayServicesRocks asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.annotation.IGooglePlayServicesRocks");
      if ((localIInterface != null) && ((localIInterface instanceof IGooglePlayServicesRocks))) {
        return (IGooglePlayServicesRocks)localIInterface;
      }
      return new a(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.common.annotation.IGooglePlayServicesRocks");
      return true;
    }
    
    private static class a
      implements IGooglePlayServicesRocks
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/common/annotation/IGooglePlayServicesRocks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */