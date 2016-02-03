package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public abstract class IRoomService$Stub
  extends Binder
  implements IRoomService
{
  public IRoomService$Stub()
  {
    attachInterface(this, "com.google.android.gms.games.internal.IRoomService");
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.games.internal.IRoomService");
      return true;
    case 1001: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
      a(paramParcel1.readStrongBinder(), IRoomServiceCallbacks.Stub.am(paramParcel1.readStrongBinder()));
      return true;
    case 1002: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
      hF();
      return true;
    case 1003: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
      hG();
      return true;
    case 1004: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
      c(paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readString());
      return true;
    case 1005: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
      hH();
      return true;
    case 1006: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel2 = DataHolder.CREATOR.x(paramParcel1);; paramParcel2 = null)
      {
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        a(paramParcel2, bool1);
        return true;
      }
    case 1007: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
      hI();
      return true;
    case 1008: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
      bool1 = bool2;
      if (paramParcel1.readInt() != 0) {
        bool1 = true;
      }
      G(bool1);
      return true;
    case 1009: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
      a(paramParcel1.createByteArray(), paramParcel1.readString(), paramParcel1.readInt());
      return true;
    case 1010: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
      a(paramParcel1.createByteArray(), paramParcel1.createStringArray());
      return true;
    case 1011: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
      r(paramParcel1.readString(), paramParcel1.readInt());
      return true;
    case 1012: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
      s(paramParcel1.readString(), paramParcel1.readInt());
      return true;
    case 1013: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
      be(paramParcel1.readString());
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomService");
    bf(paramParcel1.readString());
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/IRoomService$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */