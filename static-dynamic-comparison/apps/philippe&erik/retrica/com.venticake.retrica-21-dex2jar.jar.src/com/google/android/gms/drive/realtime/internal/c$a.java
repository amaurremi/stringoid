package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;

public abstract class c$a
  extends Binder
  implements c
{
  public static c S(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
    if ((localIInterface != null) && ((localIInterface instanceof c))) {
      return (c)localIInterface;
    }
    return new r(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        D(bool);
        paramParcel2.writeNoException();
        return true;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IBooleanCallback");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = Status.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      o(paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/c$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */