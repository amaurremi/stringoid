package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;

public abstract class i$a
  extends Binder
  implements i
{
  public static i Y(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IErrorCallback");
    if ((localIInterface != null) && ((localIInterface instanceof i))) {
      return (i)localIInterface;
    }
    return new x(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IErrorCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IErrorCallback");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = Status.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      o(paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/i$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */