package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class fu$a
  extends Binder
  implements fu
{
  public static fu A(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
    if ((localIInterface != null) && ((localIInterface instanceof fu))) {
      return (fu)localIInterface;
    }
    return new ns(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
      a(fv.a.B(paramParcel1.readStrongBinder()), paramParcel1.readString(), (fr[])paramParcel1.createTypedArray(fr.CREATOR));
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
      a(fv.a.B(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
      b(fv.a.B(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
    fv localfv = fv.a.B(paramParcel1.readStrongBinder());
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(localfv, bool);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/fu$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */