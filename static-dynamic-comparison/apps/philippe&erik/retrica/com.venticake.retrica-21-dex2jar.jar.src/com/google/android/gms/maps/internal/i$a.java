package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngCreator;

public abstract class i$a
  extends Binder
  implements i
{
  public i$a()
  {
    attachInterface(this, "com.google.android.gms.maps.internal.IOnMapClickListener");
  }
  
  public static i aH(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
    if ((localIInterface != null) && ((localIInterface instanceof i))) {
      return (i)localIInterface;
    }
    return new an(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.maps.internal.IOnMapClickListener");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IOnMapClickListener");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = LatLng.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      onMapClick(paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/internal/i$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */