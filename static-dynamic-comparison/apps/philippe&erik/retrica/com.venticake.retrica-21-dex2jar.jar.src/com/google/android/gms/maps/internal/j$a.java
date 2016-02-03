package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class j$a
  extends Binder
  implements j
{
  public j$a()
  {
    attachInterface(this, "com.google.android.gms.maps.internal.IOnMapLoadedCallback");
  }
  
  public static j aI(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
    if ((localIInterface != null) && ((localIInterface instanceof j))) {
      return (j)localIInterface;
    }
    return new ao(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMapLoadedCallback");
    onMapLoaded();
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/internal/j$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */