package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.LaunchOptions;

public abstract class gl$a
  extends Binder
  implements gl
{
  public static gl H(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
    if ((localIInterface != null) && ((localIInterface instanceof gl))) {
      return (gl)localIInterface;
    }
    return new ok(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    double d1;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.cast.internal.ICastDeviceController");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
      disconnect();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
      paramParcel2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      e(paramParcel2, bool1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
      h(paramParcel1.readString(), paramParcel1.readString());
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
      ep();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
      am(paramParcel1.readString());
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
      eg();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
      d1 = paramParcel1.readDouble();
      double d2 = paramParcel1.readDouble();
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        a(d1, d2, bool1);
        return true;
      }
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
      if (paramParcel1.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        d1 = paramParcel1.readDouble();
        if (paramParcel1.readInt() != 0) {
          bool2 = true;
        }
        a(bool1, d1, bool2);
        return true;
      }
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
      a(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong());
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
      a(paramParcel1.readString(), paramParcel1.createByteArray(), paramParcel1.readLong());
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
      an(paramParcel1.readString());
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
      ao(paramParcel1.readString());
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.cast.internal.ICastDeviceController");
    paramParcel2 = paramParcel1.readString();
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (LaunchOptions)LaunchOptions.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(paramParcel2, paramParcel1);
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/gl$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */