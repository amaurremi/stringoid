package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationRequestCreator;
import com.google.android.gms.location.a.a;
import com.google.android.gms.location.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.LatLngBoundsCreator;
import com.google.android.gms.maps.model.LatLngCreator;
import java.util.List;

public abstract class je$a
  extends Binder
  implements je
{
  public static je as(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
    if ((localIInterface != null) && ((localIInterface instanceof je))) {
      return (je)localIInterface;
    }
    return new pe(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool = false;
    Object localObject3 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject7 = null;
    Object localObject5 = null;
    Object localObject9 = null;
    Object localObject1 = null;
    Object localObject8 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      localObject2 = paramParcel1.createTypedArrayList(jh.CREATOR);
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        a((List)localObject2, (PendingIntent)localObject1, jd.a.ar(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        a((PendingIntent)localObject1, jd.a.ar(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      }
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      a(paramParcel1.createStringArray(), jd.a.ar(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      a(jd.a.ar(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      long l = paramParcel1.readLong();
      if (paramParcel1.readInt() != 0)
      {
        bool = true;
        if (paramParcel1.readInt() == 0) {
          break label566;
        }
      }
      for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(l, bool, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        bool = false;
        break;
      }
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        removeActivityUpdates(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      paramParcel1 = iW();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      localObject1 = localObject8;
      if (paramParcel1.readInt() != 0) {
        localObject1 = LocationRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((LocationRequest)localObject1, a.a.aq(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = LocationRequest.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label758;
        }
      }
      for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((LocationRequest)localObject1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      a(a.a.aq(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {
        bool = true;
      }
      setMockMode(bool);
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel1 = (Location)Location.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        setMockLocation(paramParcel1);
        paramParcel2.writeNoException();
        return true;
      }
    case 14: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = LatLngBounds.CREATOR.createFromParcel(paramParcel1);
        paramInt1 = paramParcel1.readInt();
        if (paramParcel1.readInt() == 0) {
          break label987;
        }
        localObject2 = jm.CREATOR.bv(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label993;
        }
      }
      for (localObject3 = ka.CREATOR.bB(paramParcel1);; localObject3 = null)
      {
        a((LatLngBounds)localObject1, paramInt1, (jm)localObject2, (ka)localObject3, jy.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
        localObject2 = null;
        break label941;
      }
    case 47: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = LatLngBounds.CREATOR.createFromParcel(paramParcel1);
        paramInt1 = paramParcel1.readInt();
        localObject4 = paramParcel1.readString();
        if (paramParcel1.readInt() == 0) {
          break label1096;
        }
      }
      for (localObject2 = jm.CREATOR.bv(paramParcel1);; localObject2 = null)
      {
        if (paramParcel1.readInt() != 0) {
          localObject3 = ka.CREATOR.bB(paramParcel1);
        }
        a((LatLngBounds)localObject1, paramInt1, (String)localObject4, (jm)localObject2, (ka)localObject3, jy.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 15: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      localObject2 = paramParcel1.readString();
      localObject1 = localObject6;
      if (paramParcel1.readInt() != 0) {
        localObject1 = ka.CREATOR.bB(paramParcel1);
      }
      a((String)localObject2, (ka)localObject1, jy.a.au(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = LatLng.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label1242;
        }
      }
      for (localObject2 = jm.CREATOR.bv(paramParcel1);; localObject2 = null)
      {
        localObject3 = localObject4;
        if (paramParcel1.readInt() != 0) {
          localObject3 = ka.CREATOR.bB(paramParcel1);
        }
        a((LatLng)localObject1, (jm)localObject2, (ka)localObject3, jy.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 17: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = jm.CREATOR.bv(paramParcel1);; localObject1 = null)
      {
        if (paramParcel1.readInt() != 0) {
          localObject2 = ka.CREATOR.bB(paramParcel1);
        }
        a((jm)localObject1, (ka)localObject2, jy.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    case 42: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      localObject2 = paramParcel1.readString();
      localObject1 = localObject7;
      if (paramParcel1.readInt() != 0) {
        localObject1 = ka.CREATOR.bB(paramParcel1);
      }
      b((String)localObject2, (ka)localObject1, jy.a.au(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 50: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      localObject2 = paramParcel1.readString();
      localObject3 = paramParcel1.createStringArrayList();
      localObject4 = paramParcel1.createTypedArrayList(jw.CREATOR);
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = ka.CREATOR.bB(paramParcel1);; localObject1 = null)
      {
        a((String)localObject2, (List)localObject3, (List)localObject4, (ka)localObject1, jy.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    case 18: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = jq.CREATOR.bx(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label1519;
        }
        localObject2 = ka.CREATOR.bB(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label1525;
        }
      }
      for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((jq)localObject1, (ka)localObject2, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
        localObject2 = null;
        break label1478;
      }
    case 19: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = ka.CREATOR.bB(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label1591;
        }
      }
      for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((ka)localObject1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 48: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = jk.CREATOR.bu(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label1675;
        }
        localObject2 = ka.CREATOR.bB(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label1681;
        }
      }
      for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a((jk)localObject1, (ka)localObject2, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
        localObject2 = null;
        break label1634;
      }
    case 49: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = ka.CREATOR.bB(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label1747;
        }
      }
      for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        b((ka)localObject1, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 45: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      localObject4 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = LatLngBounds.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label1843;
        }
        localObject2 = jm.CREATOR.bv(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label1849;
        }
      }
      for (localObject3 = ka.CREATOR.bB(paramParcel1);; localObject3 = null)
      {
        a((String)localObject4, (LatLngBounds)localObject1, (jm)localObject2, (ka)localObject3, jy.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
        localObject2 = null;
        break label1796;
      }
    case 46: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (ju)ju.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        localObject2 = localObject5;
        if (paramParcel1.readInt() != 0) {
          localObject2 = ka.CREATOR.bB(paramParcel1);
        }
        a((ju)localObject1, (ka)localObject2, jy.a.au(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    case 20: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      localObject1 = localObject9;
      if (paramParcel1.readInt() != 0) {
        localObject1 = LocationRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a((LocationRequest)localObject1, a.a.aq(paramParcel1.readStrongBinder()), paramParcel1.readString());
      paramParcel2.writeNoException();
      return true;
    case 21: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      paramParcel1 = bo(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 25: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (paramParcel2 = jo.CREATOR.bw(paramParcel1);; paramParcel2 = null)
      {
        if (paramParcel1.readInt() != 0) {
          localObject1 = ka.CREATOR.bB(paramParcel1);
        }
        a(paramParcel2, (ka)localObject1);
        return true;
      }
    case 26: 
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if (paramParcel1.readInt() != 0) {}
      for (localObject1 = (Location)Location.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
      {
        a((Location)localObject1, paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      }
    case 34: 
      label566:
      label758:
      label941:
      label987:
      label993:
      label1096:
      label1242:
      label1478:
      label1519:
      label1525:
      label1591:
      label1634:
      label1675:
      label1681:
      label1747:
      label1796:
      label1843:
      label1849:
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      paramParcel1 = bp(paramParcel1.readString());
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
    paramParcel1 = iX();
    paramParcel2.writeNoException();
    paramParcel2.writeStrongBinder(paramParcel1);
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/je$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */