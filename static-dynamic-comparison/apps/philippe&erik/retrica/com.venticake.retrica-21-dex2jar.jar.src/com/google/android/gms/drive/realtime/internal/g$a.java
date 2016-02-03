package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

public abstract class g$a
  extends Binder
  implements g
{
  public static g W(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
    if ((localIInterface != null) && ((localIInterface instanceof g))) {
      return (g)localIInterface;
    }
    return new v(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
      if (paramParcel1.readInt() != 0)
      {
        localObject = DataHolder.CREATOR.x(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label119;
        }
      }
      label119:
      for (paramParcel1 = (ParcelableEventList)ParcelableEventList.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((DataHolder)localObject, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
      }
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IDataHolderEventCallback");
    if (paramParcel1.readInt() != 0) {
      localObject = Status.CREATOR.createFromParcel(paramParcel1);
    }
    o((Status)localObject);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/g$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */