package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class h$a
  extends Binder
  implements h
{
  public static h X(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
    if ((localIInterface != null) && ((localIInterface instanceof h))) {
      return (h)localIInterface;
    }
    return new w(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool2 = false;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IDocumentSaveStateEventCallback");
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramParcel1.readInt() != 0) {
        bool2 = true;
      }
      c(bool1, bool2);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/h$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */