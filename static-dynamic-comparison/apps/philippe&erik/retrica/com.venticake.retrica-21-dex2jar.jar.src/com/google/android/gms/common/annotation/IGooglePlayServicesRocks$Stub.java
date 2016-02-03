package com.google.android.gms.common.annotation;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class IGooglePlayServicesRocks$Stub
  extends Binder
  implements IGooglePlayServicesRocks
{
  public IGooglePlayServicesRocks$Stub()
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
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    paramParcel2.writeString("com.google.android.gms.common.annotation.IGooglePlayServicesRocks");
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/common/annotation/IGooglePlayServicesRocks$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */