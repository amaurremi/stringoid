package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.StatusCreator;

public abstract class k$a
  extends Binder
  implements k
{
  public static k aa(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
    if ((localIInterface != null) && ((localIInterface instanceof k))) {
      return (k)localIInterface;
    }
    return new z(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ParcelableIndexReference)ParcelableIndexReference.CREATOR.createFromParcel(paramParcel1);
      }
      a((ParcelableIndexReference)localObject1);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
    localObject1 = localObject2;
    if (paramParcel1.readInt() != 0) {
      localObject1 = Status.CREATOR.createFromParcel(paramParcel1);
    }
    o((Status)localObject1);
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/k$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */