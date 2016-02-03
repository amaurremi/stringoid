package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class h$a
  extends Binder
  implements h
{
  public static h bf(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
    if ((localIInterface != null) && ((localIInterface instanceof h))) {
      return (h)localIInterface;
    }
    return new r(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i = 0;
    int j = 0;
    boolean bool2 = false;
    int k = 0;
    boolean bool1 = false;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      remove();
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      clearTileCache();
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      paramParcel1 = getId();
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      setZIndex(paramParcel1.readFloat());
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      float f = getZIndex();
      paramParcel2.writeNoException();
      paramParcel2.writeFloat(f);
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      setVisible(bool1);
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      bool1 = isVisible();
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      bool1 = a(bf(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      paramInt1 = j;
      if (bool1) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      paramInt1 = hashCodeRemote();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
      bool1 = bool2;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      setFadeIn(bool1);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
    bool1 = getFadeIn();
    paramParcel2.writeNoException();
    paramInt1 = k;
    if (bool1) {
      paramInt1 = 1;
    }
    paramParcel2.writeInt(paramInt1);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/maps/model/internal/h$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */