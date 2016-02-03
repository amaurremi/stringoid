package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

public abstract class j$a
  extends Binder
  implements j
{
  public static j Z(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
    if ((localIInterface != null) && ((localIInterface instanceof j))) {
      return (j)localIInterface;
    }
    return new y(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IEventCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ParcelableEventList)ParcelableEventList.CREATOR.createFromParcel(paramParcel1);
      }
      a((ParcelableEventList)localObject1);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IEventCallback");
    localObject1 = localObject2;
    if (paramParcel1.readInt() != 0) {
      localObject1 = Status.CREATOR.createFromParcel(paramParcel1);
    }
    o((Status)localObject1);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/j$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */