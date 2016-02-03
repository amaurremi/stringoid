package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngCreator;

public abstract class b$a
  extends Binder
  implements b
{
  public static b aY(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
    if ((localIInterface != null) && ((localIInterface instanceof b))) {
      return (b)localIInterface;
    }
    return new l(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i = 0;
    int j = 0;
    boolean bool = false;
    float f;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.maps.model.internal.ICircleDelegate");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      remove();
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      paramParcel1 = getId();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = LatLng.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        setCenter(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      paramParcel1 = getCenter();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      setRadius(paramParcel1.readDouble());
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      double d = getRadius();
      paramParcel2.writeNoException();
      paramParcel2.writeDouble(d);
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      setStrokeWidth(paramParcel1.readFloat());
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      f = getStrokeWidth();
      paramParcel2.writeNoException();
      paramParcel2.writeFloat(f);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      setStrokeColor(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      paramInt1 = getStrokeColor();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      setFillColor(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      paramInt1 = getFillColor();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      setZIndex(paramParcel1.readFloat());
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      f = getZIndex();
      paramParcel2.writeNoException();
      paramParcel2.writeFloat(f);
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      if (paramParcel1.readInt() != 0) {
        bool = true;
      }
      setVisible(bool);
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      bool = isVisible();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
      bool = a(aY(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
    paramInt1 = hashCodeRemote();
    paramParcel2.writeNoException();
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/internal/b$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */