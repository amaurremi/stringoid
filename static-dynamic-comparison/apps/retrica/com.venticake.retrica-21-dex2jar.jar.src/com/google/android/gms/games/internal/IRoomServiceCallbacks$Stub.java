package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;

public abstract class IRoomServiceCallbacks$Stub
  extends Binder
  implements IRoomServiceCallbacks
{
  public IRoomServiceCallbacks$Stub()
  {
    attachInterface(this, "com.google.android.gms.games.internal.IRoomServiceCallbacks");
  }
  
  public static IRoomServiceCallbacks am(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
    if ((localIInterface != null) && ((localIInterface instanceof IRoomServiceCallbacks))) {
      return (IRoomServiceCallbacks)localIInterface;
    }
    return new do(paramIBinder);
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
      paramParcel2.writeString("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      return true;
    case 1001: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      c(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readString());
      return true;
    case 1002: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      a(paramParcel1.readString(), paramParcel1.createByteArray(), paramParcel1.readInt());
      return true;
    case 1003: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      bg(paramParcel1.readString());
      return true;
    case 1004: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      bh(paramParcel1.readString());
      return true;
    case 1005: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      bi(paramParcel1.readString());
      return true;
    case 1006: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      bj(paramParcel1.readString());
      return true;
    case 1007: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      bk(paramParcel1.readString());
      return true;
    case 1008: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      a(paramParcel1.readString(), paramParcel1.createStringArray());
      return true;
    case 1009: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      b(paramParcel1.readString(), paramParcel1.createStringArray());
      return true;
    case 1010: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      c(paramParcel1.readString(), paramParcel1.createStringArray());
      return true;
    case 1011: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      d(paramParcel1.readString(), paramParcel1.createStringArray());
      return true;
    case 1012: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      e(paramParcel1.readString(), paramParcel1.createStringArray());
      return true;
    case 1013: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      f(paramParcel1.readString(), paramParcel1.createStringArray());
      return true;
    case 1014: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      onP2PConnected(paramParcel1.readString());
      return true;
    case 1015: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      onP2PDisconnected(paramParcel1.readString());
      return true;
    case 1016: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      hJ();
      return true;
    case 1017: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      g(paramParcel1.readString(), paramParcel1.createStringArray());
      return true;
    case 1018: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      bl(paramParcel1.readString());
      return true;
    case 1019: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      bm(paramParcel1.readString());
      return true;
    case 1020: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      ck(paramParcel1.readInt());
      return true;
    case 1021: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      al(paramParcel1.readStrongBinder());
      return true;
    case 1022: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      paramParcel2 = (Parcel)localObject1;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = ConnectionInfo.CREATOR.bf(paramParcel1);
      }
      a(paramParcel2);
      return true;
    case 1023: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      hK();
      return true;
    case 1024: 
      paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
      paramParcel2 = (Parcel)localObject2;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(paramParcel1);
      }
      a(paramParcel2, paramParcel1.readInt());
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.games.internal.IRoomServiceCallbacks");
    t(paramParcel1.readString(), paramParcel1.readInt());
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/games/internal/IRoomServiceCallbacks$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */