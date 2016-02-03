package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.f;

public abstract class m$a
  extends Binder
  implements m
{
  public static m ac(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
    if ((localIInterface != null) && ((localIInterface instanceof m))) {
      return (m)localIInterface;
    }
    return new ab(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    String str1 = null;
    String str2 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), n.a.ad(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(c.a.S(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(o.a.ae(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 33: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      b(c.a.S(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 35: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      b(o.a.ae(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readString(), f.a.V(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), l.a.ab(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      str1 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {
        localObject1 = DataHolder.CREATOR.x(paramParcel1);
      }
      a(str1, (DataHolder)localObject1, j.a.Z(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), j.a.Z(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 20: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), f.a.V(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readString(), g.a.W(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      b(paramParcel1.readString(), l.a.ab(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      b(paramParcel1.readString(), n.a.ad(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString(), j.a.Z(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), j.a.Z(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readString(), j.a.Z(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      b(paramParcel1.readString(), f.a.V(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      c(paramParcel1.readString(), l.a.ab(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      str2 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      localObject1 = str1;
      if (paramParcel1.readInt() != 0) {
        localObject1 = DataHolder.CREATOR.x(paramParcel1);
      }
      a(str2, paramInt1, (DataHolder)localObject1, j.a.Z(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      str1 = paramParcel1.readString();
      paramInt1 = paramParcel1.readInt();
      localObject1 = str2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = DataHolder.CREATOR.x(paramParcel1);
      }
      a(str1, paramInt1, (DataHolder)localObject1, g.a.W(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readInt(), g.a.W(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 37: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readInt(), paramParcel1.readString(), paramParcel1.readInt(), j.a.Z(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (BeginCompoundOperationRequest)BeginCompoundOperationRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((BeginCompoundOperationRequest)localObject1, o.a.ae(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 19: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (EndCompoundOperationRequest)EndCompoundOperationRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((EndCompoundOperationRequest)localObject1, o.a.ae(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 22: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(j.a.Z(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 23: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      b(j.a.Z(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 24: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      c(c.a.S(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 25: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      d(c.a.S(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 26: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ParcelableIndexReference)ParcelableIndexReference.CREATOR.createFromParcel(paramParcel1);
      }
      a((ParcelableIndexReference)localObject1, n.a.ad(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 27: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), k.a.aa(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 28: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), paramParcel1.readInt(), o.a.ae(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 29: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(l.a.ab(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 30: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readInt(), j.a.Z(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 31: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(e.a.U(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 32: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(d.a.T(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 34: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(i.a.Y(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 36: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(h.a.X(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 38: 
      paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
      a(paramParcel1.readString(), o.a.ae(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
    b(paramParcel1.readString(), o.a.ae(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/m$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */