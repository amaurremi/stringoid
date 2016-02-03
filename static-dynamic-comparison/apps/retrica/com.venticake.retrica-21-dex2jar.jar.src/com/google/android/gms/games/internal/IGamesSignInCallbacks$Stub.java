package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public abstract class IGamesSignInCallbacks$Stub
  extends Binder
  implements IGamesSignInCallbacks
{
  public IGamesSignInCallbacks$Stub()
  {
    attachInterface(this, "com.google.android.gms.games.internal.IGamesSignInCallbacks");
  }
  
  public static IGamesSignInCallbacks ak(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof IGamesSignInCallbacks))) {
      return (IGamesSignInCallbacks)localIInterface;
    }
    return new dn(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.games.internal.IGamesSignInCallbacks");
      return true;
    case 5001: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
      paramInt1 = paramParcel1.readInt();
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Intent)Intent.CREATOR.createFromParcel(paramParcel1);
      }
      b(paramInt1, (Intent)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 5002: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = DataHolder.CREATOR.x(paramParcel1);
      }
      S((DataHolder)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 5003: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0) {
        localObject1 = DataHolder.CREATOR.x(paramParcel1);
      }
      T((DataHolder)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 5004: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
      ci(paramParcel1.readInt());
      paramParcel2.writeNoException();
      return true;
    case 5005: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0) {
        localObject1 = DataHolder.CREATOR.x(paramParcel1);
      }
      g((DataHolder)localObject1);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInCallbacks");
    cj(paramParcel1.readInt());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/IGamesSignInCallbacks$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */