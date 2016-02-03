package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.Parcel;

public abstract class IGamesSignInService$Stub
  extends Binder
  implements IGamesSignInService
{
  public IGamesSignInService$Stub()
  {
    attachInterface(this, "com.google.android.gms.games.internal.IGamesSignInService");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.games.internal.IGamesSignInService");
      return true;
    case 5001: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
      paramParcel1 = bc(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 5002: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
      paramParcel1 = bd(paramParcel1.readString());
      paramParcel2.writeNoException();
      paramParcel2.writeString(paramParcel1);
      return true;
    case 5009: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
      String str = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramParcel1 = f(str, bool);
        paramParcel2.writeNoException();
        paramParcel2.writeString(paramParcel1);
        return true;
      }
    case 5003: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
      a(IGamesSignInCallbacks.Stub.ak(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5004: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
      a(IGamesSignInCallbacks.Stub.ak(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    case 5005: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
      a(IGamesSignInCallbacks.Stub.ak(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5006: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
      a(IGamesSignInCallbacks.Stub.ak(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5007: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
      b(IGamesSignInCallbacks.Stub.ak(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5008: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
      b(IGamesSignInCallbacks.Stub.ak(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createStringArray());
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.games.internal.IGamesSignInService");
    o(paramParcel1.readString(), paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/IGamesSignInService$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */