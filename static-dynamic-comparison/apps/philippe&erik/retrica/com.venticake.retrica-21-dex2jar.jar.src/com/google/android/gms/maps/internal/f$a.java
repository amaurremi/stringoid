package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.internal.d.a;

public abstract class f$a
  extends Binder
  implements f
{
  public f$a()
  {
    attachInterface(this, "com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
  }
  
  public static f aE(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
    if ((localIInterface != null) && ((localIInterface instanceof f))) {
      return (f)localIInterface;
    }
    return new ak(paramIBinder);
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
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
      onIndoorBuildingFocused();
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
    a(d.a.ba(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/internal/f$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */