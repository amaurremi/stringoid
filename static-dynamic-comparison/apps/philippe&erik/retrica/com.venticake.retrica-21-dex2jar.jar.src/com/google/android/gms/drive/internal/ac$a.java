package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class ac$a
  extends Binder
  implements ac
{
  public ac$a()
  {
    attachInterface(this, "com.google.android.gms.drive.internal.IEventCallback");
  }
  
  public static ac R(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.internal.IEventCallback");
    if ((localIInterface != null) && ((localIInterface instanceof ac))) {
      return (ac)localIInterface;
    }
    return new ba(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.drive.internal.IEventCallback");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.internal.IEventCallback");
    if (paramParcel1.readInt() != 0) {}
    for (paramParcel1 = (OnEventResponse)OnEventResponse.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
    {
      a(paramParcel1);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/internal/ac$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */