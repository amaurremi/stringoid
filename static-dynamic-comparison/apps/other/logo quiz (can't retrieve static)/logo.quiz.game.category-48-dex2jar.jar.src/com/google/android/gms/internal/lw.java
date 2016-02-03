package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.a;
import com.google.android.gms.location.a.a;
import com.google.android.gms.location.b;
import com.google.android.gms.location.c;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.g;
import com.google.android.gms.maps.model.i;
import java.util.List;

public abstract interface lw
  extends IInterface
{
  public abstract void a(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(PendingIntent paramPendingIntent, lv paramlv, String paramString)
    throws RemoteException;
  
  public abstract void a(Location paramLocation, int paramInt)
    throws RemoteException;
  
  public abstract void a(lv paramlv, String paramString)
    throws RemoteException;
  
  public abstract void a(lz paramlz, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(lz paramlz, a parama)
    throws RemoteException;
  
  public abstract void a(mg parammg, mw parammw, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(mi parammi, mw parammw, mu parammu)
    throws RemoteException;
  
  public abstract void a(mk parammk, mw parammw)
    throws RemoteException;
  
  public abstract void a(mm parammm, mw parammw, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(mq parammq, mw parammw, mu parammu)
    throws RemoteException;
  
  public abstract void a(ms paramms, LatLngBounds paramLatLngBounds, List<String> paramList, mw parammw, mu parammu)
    throws RemoteException;
  
  public abstract void a(mw parammw, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(LocationRequest paramLocationRequest, a parama)
    throws RemoteException;
  
  public abstract void a(LocationRequest paramLocationRequest, a parama, String paramString)
    throws RemoteException;
  
  public abstract void a(a parama)
    throws RemoteException;
  
  public abstract void a(LatLng paramLatLng, mi parammi, mw parammw, mu parammu)
    throws RemoteException;
  
  public abstract void a(LatLngBounds paramLatLngBounds, int paramInt, mi parammi, mw parammw, mu parammu)
    throws RemoteException;
  
  public abstract void a(LatLngBounds paramLatLngBounds, int paramInt, String paramString, mi parammi, mw parammw, mu parammu)
    throws RemoteException;
  
  public abstract void a(String paramString, mw parammw, mu parammu)
    throws RemoteException;
  
  public abstract void a(String paramString, LatLngBounds paramLatLngBounds, me paramme, mw parammw, mu parammu)
    throws RemoteException;
  
  public abstract void a(List<mb> paramList, PendingIntent paramPendingIntent, lv paramlv, String paramString)
    throws RemoteException;
  
  public abstract void a(String[] paramArrayOfString, lv paramlv, String paramString)
    throws RemoteException;
  
  public abstract void b(mw parammw, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void b(String paramString, mw parammw, mu parammu)
    throws RemoteException;
  
  public abstract Location bT(String paramString)
    throws RemoteException;
  
  public abstract c bU(String paramString)
    throws RemoteException;
  
  public abstract Location lT()
    throws RemoteException;
  
  public abstract IBinder lU()
    throws RemoteException;
  
  public abstract IBinder lV()
    throws RemoteException;
  
  public abstract void removeActivityUpdates(PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void setMockLocation(Location paramLocation)
    throws RemoteException;
  
  public abstract void setMockMode(boolean paramBoolean)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements lw
  {
    public static lw aK(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if ((localIInterface != null) && ((localIInterface instanceof lw))) {
        return (lw)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool = false;
      Object localObject9 = null;
      Object localObject10 = null;
      Object localObject3 = null;
      Object localObject6 = null;
      Object localObject4 = null;
      Object localObject2 = null;
      Object localObject7 = null;
      Object localObject5 = null;
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
        localObject2 = paramParcel1.createTypedArrayList(mb.CREATOR);
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
        {
          a((List)localObject2, (PendingIntent)localObject1, lv.a.aJ(paramParcel1.readStrongBinder()), paramParcel1.readString());
          paramParcel2.writeNoException();
          return true;
        }
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
        {
          a((PendingIntent)localObject1, lv.a.aJ(paramParcel1.readStrongBinder()), paramParcel1.readString());
          paramParcel2.writeNoException();
          return true;
        }
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(paramParcel1.createStringArray(), lv.a.aJ(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(lv.a.aJ(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        long l = paramParcel1.readLong();
        if (paramParcel1.readInt() != 0)
        {
          bool = true;
          if (paramParcel1.readInt() == 0) {
            break label594;
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
        paramParcel1 = lT();
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
          localObject1 = LocationRequest.CREATOR.cs(paramParcel1);
        }
        a((LocationRequest)localObject1, a.a.aI(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject1 = localObject9;
        if (paramParcel1.readInt() != 0) {
          localObject1 = LocationRequest.CREATOR.cs(paramParcel1);
        }
        a((LocationRequest)localObject1, a.a.aI(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = LocationRequest.CREATOR.cs(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label835;
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
      case 52: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject1 = localObject10;
        if (paramParcel1.readInt() != 0) {
          localObject1 = lz.CREATOR.cv(paramParcel1);
        }
        a((lz)localObject1, a.a.aI(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 53: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = lz.CREATOR.cv(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label946;
          }
        }
        for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          a((lz)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(a.a.aI(paramParcel1.readStrongBinder()));
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
          localObject1 = LatLngBounds.CREATOR.cL(paramParcel1);
          paramInt1 = paramParcel1.readInt();
          if (paramParcel1.readInt() == 0) {
            break label1175;
          }
          localObject2 = mi.CREATOR.cz(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1181;
          }
        }
        for (localObject3 = mw.CREATOR.cF(paramParcel1);; localObject3 = null)
        {
          a((LatLngBounds)localObject1, paramInt1, (mi)localObject2, (mw)localObject3, mu.a.aM(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
          localObject2 = null;
          break label1129;
        }
      case 47: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = LatLngBounds.CREATOR.cL(paramParcel1);
          paramInt1 = paramParcel1.readInt();
          localObject4 = paramParcel1.readString();
          if (paramParcel1.readInt() == 0) {
            break label1284;
          }
        }
        for (localObject2 = mi.CREATOR.cz(paramParcel1);; localObject2 = null)
        {
          if (paramParcel1.readInt() != 0) {
            localObject3 = mw.CREATOR.cF(paramParcel1);
          }
          a((LatLngBounds)localObject1, paramInt1, (String)localObject4, (mi)localObject2, (mw)localObject3, mu.a.aM(paramParcel1.readStrongBinder()));
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
          localObject1 = mw.CREATOR.cF(paramParcel1);
        }
        a((String)localObject2, (mw)localObject1, mu.a.aM(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = LatLng.CREATOR.cM(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1430;
          }
        }
        for (localObject2 = mi.CREATOR.cz(paramParcel1);; localObject2 = null)
        {
          localObject3 = localObject4;
          if (paramParcel1.readInt() != 0) {
            localObject3 = mw.CREATOR.cF(paramParcel1);
          }
          a((LatLng)localObject1, (mi)localObject2, (mw)localObject3, mu.a.aM(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = mi.CREATOR.cz(paramParcel1);; localObject1 = null)
        {
          if (paramParcel1.readInt() != 0) {
            localObject2 = mw.CREATOR.cF(paramParcel1);
          }
          a((mi)localObject1, (mw)localObject2, mu.a.aM(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
        }
      case 42: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject2 = paramParcel1.readString();
        localObject1 = localObject7;
        if (paramParcel1.readInt() != 0) {
          localObject1 = mw.CREATOR.cF(paramParcel1);
        }
        b((String)localObject2, (mw)localObject1, mu.a.aM(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 50: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = ms.CREATOR.cE(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1645;
          }
          localObject2 = LatLngBounds.CREATOR.cL(paramParcel1);
          localObject4 = paramParcel1.createStringArrayList();
          if (paramParcel1.readInt() == 0) {
            break label1651;
          }
        }
        for (localObject3 = mw.CREATOR.cF(paramParcel1);; localObject3 = null)
        {
          a((ms)localObject1, (LatLngBounds)localObject2, (List)localObject4, (mw)localObject3, mu.a.aM(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
          localObject2 = null;
          break label1592;
        }
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = mm.CREATOR.cB(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1736;
          }
          localObject2 = mw.CREATOR.cF(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1742;
          }
        }
        for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          a((mm)localObject1, (mw)localObject2, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
          localObject2 = null;
          break label1695;
        }
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = mw.CREATOR.cF(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1808;
          }
        }
        for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          a((mw)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 48: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = mg.CREATOR.cy(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1892;
          }
          localObject2 = mw.CREATOR.cF(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1898;
          }
        }
        for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          a((mg)localObject1, (mw)localObject2, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
          localObject2 = null;
          break label1851;
        }
      case 49: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = mw.CREATOR.cF(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1964;
          }
        }
        for (paramParcel1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
        {
          b((mw)localObject1, paramParcel1);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 55: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject4 = paramParcel1.readString();
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = LatLngBounds.CREATOR.cL(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label2060;
          }
          localObject2 = me.CREATOR.cx(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label2066;
          }
        }
        for (localObject3 = mw.CREATOR.cF(paramParcel1);; localObject3 = null)
        {
          a((String)localObject4, (LatLngBounds)localObject1, (me)localObject2, (mw)localObject3, mu.a.aM(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
          localObject2 = null;
          break label2013;
        }
      case 46: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = (mq)mq.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
        {
          localObject2 = localObject5;
          if (paramParcel1.readInt() != 0) {
            localObject2 = mw.CREATOR.cF(paramParcel1);
          }
          a((mq)localObject1, (mw)localObject2, mu.a.aM(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
        }
      case 21: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        paramParcel1 = bT(paramParcel1.readString());
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
        for (paramParcel2 = mk.CREATOR.cA(paramParcel1);; paramParcel2 = null)
        {
          if (paramParcel1.readInt() != 0) {
            localObject1 = mw.CREATOR.cF(paramParcel1);
          }
          a(paramParcel2, (mw)localObject1);
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
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        paramParcel1 = bU(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 51: 
        label594:
        label835:
        label946:
        label1129:
        label1175:
        label1181:
        label1284:
        label1430:
        label1592:
        label1645:
        label1651:
        label1695:
        label1736:
        label1742:
        label1808:
        label1851:
        label1892:
        label1898:
        label1964:
        label2013:
        label2060:
        label2066:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        paramParcel1 = lU();
        paramParcel2.writeNoException();
        paramParcel2.writeStrongBinder(paramParcel1);
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      paramParcel1 = lV();
      paramParcel2.writeNoException();
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    }
    
    private static class a
      implements lw
    {
      private IBinder lb;
      
      a(IBinder paramIBinder)
      {
        this.lb = paramIBinder;
      }
      
      /* Error */
      public void a(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 5
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 6
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 6
        //   22: lload_1
        //   23: invokevirtual 38	android/os/Parcel:writeLong	(J)V
        //   26: iload_3
        //   27: ifeq +61 -> 88
        //   30: aload 6
        //   32: iload 5
        //   34: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   37: aload 4
        //   39: ifnull +55 -> 94
        //   42: aload 6
        //   44: iconst_1
        //   45: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   48: aload 4
        //   50: aload 6
        //   52: iconst_0
        //   53: invokevirtual 48	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
        //   56: aload_0
        //   57: getfield 18	com/google/android/gms/internal/lw$a$a:lb	Landroid/os/IBinder;
        //   60: iconst_5
        //   61: aload 6
        //   63: aload 7
        //   65: iconst_0
        //   66: invokeinterface 54 5 0
        //   71: pop
        //   72: aload 7
        //   74: invokevirtual 57	android/os/Parcel:readException	()V
        //   77: aload 7
        //   79: invokevirtual 60	android/os/Parcel:recycle	()V
        //   82: aload 6
        //   84: invokevirtual 60	android/os/Parcel:recycle	()V
        //   87: return
        //   88: iconst_0
        //   89: istore 5
        //   91: goto -61 -> 30
        //   94: aload 6
        //   96: iconst_0
        //   97: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   100: goto -44 -> 56
        //   103: astore 4
        //   105: aload 7
        //   107: invokevirtual 60	android/os/Parcel:recycle	()V
        //   110: aload 6
        //   112: invokevirtual 60	android/os/Parcel:recycle	()V
        //   115: aload 4
        //   117: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	118	0	this	a
        //   0	118	1	paramLong	long
        //   0	118	3	paramBoolean	boolean
        //   0	118	4	paramPendingIntent	PendingIntent
        //   1	89	5	i	int
        //   6	105	6	localParcel1	Parcel
        //   11	95	7	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	26	103	finally
        //   30	37	103	finally
        //   42	56	103	finally
        //   56	77	103	finally
        //   94	100	103	finally
      }
      
      /* Error */
      public void a(PendingIntent paramPendingIntent)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 48	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/internal/lw$a$a:lb	Landroid/os/IBinder;
        //   33: bipush 11
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 54 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 57	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 60	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 60	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore_1
        //   66: aload_3
        //   67: invokevirtual 60	android/os/Parcel:recycle	()V
        //   70: aload_2
        //   71: invokevirtual 60	android/os/Parcel:recycle	()V
        //   74: aload_1
        //   75: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	76	0	this	a
        //   0	76	1	paramPendingIntent	PendingIntent
        //   3	68	2	localParcel1	Parcel
        //   7	60	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	29	65	finally
        //   29	48	65	finally
        //   57	62	65	finally
      }
      
      public void a(PendingIntent paramPendingIntent, lv paramlv, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramPendingIntent != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              if (paramlv != null)
              {
                paramPendingIntent = paramlv.asBinder();
                localParcel1.writeStrongBinder(paramPendingIntent);
                localParcel1.writeString(paramString);
                this.lb.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramPendingIntent = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void a(Location paramLocation, int paramInt)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +50 -> 66
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 79	android/location/Location:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_3
        //   31: iload_2
        //   32: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/internal/lw$a$a:lb	Landroid/os/IBinder;
        //   39: bipush 26
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 54 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 57	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 60	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 60	android/os/Parcel:recycle	()V
        //   65: return
        //   66: aload_3
        //   67: iconst_0
        //   68: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   71: goto -41 -> 30
        //   74: astore_1
        //   75: aload 4
        //   77: invokevirtual 60	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: invokevirtual 60	android/os/Parcel:recycle	()V
        //   84: aload_1
        //   85: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	86	0	this	a
        //   0	86	1	paramLocation	Location
        //   0	86	2	paramInt	int
        //   3	78	3	localParcel1	Parcel
        //   7	69	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	74	finally
        //   19	30	74	finally
        //   30	56	74	finally
        //   66	71	74	finally
      }
      
      /* Error */
      public void a(lv paramlv, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 30
        //   12: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +50 -> 66
        //   19: aload_1
        //   20: invokeinterface 69 1 0
        //   25: astore_1
        //   26: aload_3
        //   27: aload_1
        //   28: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   31: aload_3
        //   32: aload_2
        //   33: invokevirtual 75	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   36: aload_0
        //   37: getfield 18	com/google/android/gms/internal/lw$a$a:lb	Landroid/os/IBinder;
        //   40: iconst_4
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 54 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 57	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 60	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 60	android/os/Parcel:recycle	()V
        //   65: return
        //   66: aconst_null
        //   67: astore_1
        //   68: goto -42 -> 26
        //   71: astore_1
        //   72: aload 4
        //   74: invokevirtual 60	android/os/Parcel:recycle	()V
        //   77: aload_3
        //   78: invokevirtual 60	android/os/Parcel:recycle	()V
        //   81: aload_1
        //   82: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	83	0	this	a
        //   0	83	1	paramlv	lv
        //   0	83	2	paramString	String
        //   3	75	3	localParcel1	Parcel
        //   7	66	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	71	finally
        //   19	26	71	finally
        //   26	56	71	finally
      }
      
      public void a(lz paramlz, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramlz != null)
            {
              localParcel1.writeInt(1);
              paramlz.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.lb.transact(53, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(lz paramlz, a parama)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramlz != null)
            {
              localParcel1.writeInt(1);
              paramlz.writeToParcel(localParcel1, 0);
              if (parama != null)
              {
                paramlz = parama.asBinder();
                localParcel1.writeStrongBinder(paramlz);
                this.lb.transact(52, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramlz = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(mg parammg, mw parammw, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (parammg != null)
            {
              localParcel1.writeInt(1);
              parammg.writeToParcel(localParcel1, 0);
              if (parammw != null)
              {
                localParcel1.writeInt(1);
                parammw.writeToParcel(localParcel1, 0);
                if (paramPendingIntent == null) {
                  break label132;
                }
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.lb.transact(48, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label132:
          localParcel1.writeInt(0);
        }
      }
      
      public void a(mi parammi, mw parammw, mu parammu)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (parammi != null)
            {
              localParcel1.writeInt(1);
              parammi.writeToParcel(localParcel1, 0);
              if (parammw != null)
              {
                localParcel1.writeInt(1);
                parammw.writeToParcel(localParcel1, 0);
                if (parammu == null) {
                  break label132;
                }
                parammi = parammu.asBinder();
                localParcel1.writeStrongBinder(parammi);
                this.lb.transact(17, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label132:
          parammi = null;
        }
      }
      
      public void a(mk parammk, mw parammw)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (parammk != null)
            {
              localParcel.writeInt(1);
              parammk.writeToParcel(localParcel, 0);
              if (parammw != null)
              {
                localParcel.writeInt(1);
                parammw.writeToParcel(localParcel, 0);
                this.lb.transact(25, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      public void a(mm parammm, mw parammw, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (parammm != null)
            {
              localParcel1.writeInt(1);
              parammm.writeToParcel(localParcel1, 0);
              if (parammw != null)
              {
                localParcel1.writeInt(1);
                parammw.writeToParcel(localParcel1, 0);
                if (paramPendingIntent == null) {
                  break label132;
                }
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.lb.transact(18, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label132:
          localParcel1.writeInt(0);
        }
      }
      
      public void a(mq parammq, mw parammw, mu parammu)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (parammq != null)
            {
              localParcel1.writeInt(1);
              parammq.writeToParcel(localParcel1, 0);
              if (parammw != null)
              {
                localParcel1.writeInt(1);
                parammw.writeToParcel(localParcel1, 0);
                if (parammu == null) {
                  break label132;
                }
                parammq = parammu.asBinder();
                localParcel1.writeStrongBinder(parammq);
                this.lb.transact(46, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label132:
          parammq = null;
        }
      }
      
      public void a(ms paramms, LatLngBounds paramLatLngBounds, List<String> paramList, mw parammw, mu parammu)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramms != null)
            {
              localParcel1.writeInt(1);
              paramms.writeToParcel(localParcel1, 0);
              if (paramLatLngBounds != null)
              {
                localParcel1.writeInt(1);
                paramLatLngBounds.writeToParcel(localParcel1, 0);
                localParcel1.writeStringList(paramList);
                if (parammw == null) {
                  break label159;
                }
                localParcel1.writeInt(1);
                parammw.writeToParcel(localParcel1, 0);
                if (parammu == null) {
                  break label168;
                }
                paramms = parammu.asBinder();
                localParcel1.writeStrongBinder(paramms);
                this.lb.transact(50, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label159:
          localParcel1.writeInt(0);
          continue;
          label168:
          paramms = null;
        }
      }
      
      public void a(mw parammw, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (parammw != null)
            {
              localParcel1.writeInt(1);
              parammw.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.lb.transact(19, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLocationRequest != null)
            {
              localParcel1.writeInt(1);
              paramLocationRequest.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.lb.transact(9, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(LocationRequest paramLocationRequest, a parama)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLocationRequest != null)
            {
              localParcel1.writeInt(1);
              paramLocationRequest.writeToParcel(localParcel1, 0);
              if (parama != null)
              {
                paramLocationRequest = parama.asBinder();
                localParcel1.writeStrongBinder(paramLocationRequest);
                this.lb.transact(8, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramLocationRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(LocationRequest paramLocationRequest, a parama, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLocationRequest != null)
            {
              localParcel1.writeInt(1);
              paramLocationRequest.writeToParcel(localParcel1, 0);
              if (parama != null)
              {
                paramLocationRequest = parama.asBinder();
                localParcel1.writeStrongBinder(paramLocationRequest);
                localParcel1.writeString(paramString);
                this.lb.transact(20, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramLocationRequest = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void a(a parama)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +43 -> 58
        //   18: aload_1
        //   19: invokeinterface 88 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/internal/lw$a$a:lb	Landroid/os/IBinder;
        //   34: bipush 10
        //   36: aload_2
        //   37: aload_3
        //   38: iconst_0
        //   39: invokeinterface 54 5 0
        //   44: pop
        //   45: aload_3
        //   46: invokevirtual 57	android/os/Parcel:readException	()V
        //   49: aload_3
        //   50: invokevirtual 60	android/os/Parcel:recycle	()V
        //   53: aload_2
        //   54: invokevirtual 60	android/os/Parcel:recycle	()V
        //   57: return
        //   58: aconst_null
        //   59: astore_1
        //   60: goto -35 -> 25
        //   63: astore_1
        //   64: aload_3
        //   65: invokevirtual 60	android/os/Parcel:recycle	()V
        //   68: aload_2
        //   69: invokevirtual 60	android/os/Parcel:recycle	()V
        //   72: aload_1
        //   73: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	74	0	this	a
        //   0	74	1	parama	a
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      public void a(LatLng paramLatLng, mi parammi, mw parammw, mu parammu)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLatLng != null)
            {
              localParcel1.writeInt(1);
              paramLatLng.writeToParcel(localParcel1, 0);
              if (parammi != null)
              {
                localParcel1.writeInt(1);
                parammi.writeToParcel(localParcel1, 0);
                if (parammw == null) {
                  break label151;
                }
                localParcel1.writeInt(1);
                parammw.writeToParcel(localParcel1, 0);
                if (parammu == null) {
                  break label160;
                }
                paramLatLng = parammu.asBinder();
                localParcel1.writeStrongBinder(paramLatLng);
                this.lb.transact(16, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label151:
          localParcel1.writeInt(0);
          continue;
          label160:
          paramLatLng = null;
        }
      }
      
      public void a(LatLngBounds paramLatLngBounds, int paramInt, mi parammi, mw parammw, mu parammu)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLatLngBounds != null)
            {
              localParcel1.writeInt(1);
              paramLatLngBounds.writeToParcel(localParcel1, 0);
              localParcel1.writeInt(paramInt);
              if (parammi != null)
              {
                localParcel1.writeInt(1);
                parammi.writeToParcel(localParcel1, 0);
                if (parammw == null) {
                  break label159;
                }
                localParcel1.writeInt(1);
                parammw.writeToParcel(localParcel1, 0);
                if (parammu == null) {
                  break label168;
                }
                paramLatLngBounds = parammu.asBinder();
                localParcel1.writeStrongBinder(paramLatLngBounds);
                this.lb.transact(14, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label159:
          localParcel1.writeInt(0);
          continue;
          label168:
          paramLatLngBounds = null;
        }
      }
      
      public void a(LatLngBounds paramLatLngBounds, int paramInt, String paramString, mi parammi, mw parammw, mu parammu)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLatLngBounds != null)
            {
              localParcel1.writeInt(1);
              paramLatLngBounds.writeToParcel(localParcel1, 0);
              localParcel1.writeInt(paramInt);
              localParcel1.writeString(paramString);
              if (parammi != null)
              {
                localParcel1.writeInt(1);
                parammi.writeToParcel(localParcel1, 0);
                if (parammw == null) {
                  break label167;
                }
                localParcel1.writeInt(1);
                parammw.writeToParcel(localParcel1, 0);
                if (parammu == null) {
                  break label176;
                }
                paramLatLngBounds = parammu.asBinder();
                localParcel1.writeStrongBinder(paramLatLngBounds);
                this.lb.transact(47, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label167:
          localParcel1.writeInt(0);
          continue;
          label176:
          paramLatLngBounds = null;
        }
      }
      
      public void a(String paramString, mw parammw, mu parammu)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeString(paramString);
            if (parammw != null)
            {
              localParcel1.writeInt(1);
              parammw.writeToParcel(localParcel1, 0);
              if (parammu != null)
              {
                paramString = parammu.asBinder();
                localParcel1.writeStrongBinder(paramString);
                this.lb.transact(15, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void a(String paramString, LatLngBounds paramLatLngBounds, me paramme, mw parammw, mu parammu)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeString(paramString);
            if (paramLatLngBounds != null)
            {
              localParcel1.writeInt(1);
              paramLatLngBounds.writeToParcel(localParcel1, 0);
              if (paramme != null)
              {
                localParcel1.writeInt(1);
                paramme.writeToParcel(localParcel1, 0);
                if (parammw == null) {
                  break label159;
                }
                localParcel1.writeInt(1);
                parammw.writeToParcel(localParcel1, 0);
                if (parammu == null) {
                  break label168;
                }
                paramString = parammu.asBinder();
                localParcel1.writeStrongBinder(paramString);
                this.lb.transact(55, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
          continue;
          label159:
          localParcel1.writeInt(0);
          continue;
          label168:
          paramString = null;
        }
      }
      
      public void a(List<mb> paramList, PendingIntent paramPendingIntent, lv paramlv, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeTypedList(paramList);
            if (paramPendingIntent != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              if (paramlv != null)
              {
                paramList = paramlv.asBinder();
                localParcel1.writeStrongBinder(paramList);
                localParcel1.writeString(paramString);
                this.lb.transact(1, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramList = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void a(String[] paramArrayOfString, lv paramlv, String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 30
        //   14: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: aload_1
        //   20: invokevirtual 156	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   23: aload_2
        //   24: ifnull +54 -> 78
        //   27: aload_2
        //   28: invokeinterface 69 1 0
        //   33: astore_1
        //   34: aload 4
        //   36: aload_1
        //   37: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   40: aload 4
        //   42: aload_3
        //   43: invokevirtual 75	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/internal/lw$a$a:lb	Landroid/os/IBinder;
        //   50: iconst_3
        //   51: aload 4
        //   53: aload 5
        //   55: iconst_0
        //   56: invokeinterface 54 5 0
        //   61: pop
        //   62: aload 5
        //   64: invokevirtual 57	android/os/Parcel:readException	()V
        //   67: aload 5
        //   69: invokevirtual 60	android/os/Parcel:recycle	()V
        //   72: aload 4
        //   74: invokevirtual 60	android/os/Parcel:recycle	()V
        //   77: return
        //   78: aconst_null
        //   79: astore_1
        //   80: goto -46 -> 34
        //   83: astore_1
        //   84: aload 5
        //   86: invokevirtual 60	android/os/Parcel:recycle	()V
        //   89: aload 4
        //   91: invokevirtual 60	android/os/Parcel:recycle	()V
        //   94: aload_1
        //   95: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	96	0	this	a
        //   0	96	1	paramArrayOfString	String[]
        //   0	96	2	paramlv	lv
        //   0	96	3	paramString	String
        //   3	87	4	localParcel1	Parcel
        //   8	77	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	83	finally
        //   27	34	83	finally
        //   34	67	83	finally
      }
      
      public IBinder asBinder()
      {
        return this.lb;
      }
      
      public void b(mw parammw, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (parammw != null)
            {
              localParcel1.writeInt(1);
              parammw.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.lb.transact(49, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public void b(String paramString, mw parammw, mu parammu)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeString(paramString);
            if (parammw != null)
            {
              localParcel1.writeInt(1);
              parammw.writeToParcel(localParcel1, 0);
              if (parammu != null)
              {
                paramString = parammu.asBinder();
                localParcel1.writeStrongBinder(paramString);
                this.lb.transact(42, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramString = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public Location bT(String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 75	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 18	com/google/android/gms/internal/lw$a$a:lb	Landroid/os/IBinder;
        //   23: bipush 21
        //   25: aload_2
        //   26: aload_3
        //   27: iconst_0
        //   28: invokeinterface 54 5 0
        //   33: pop
        //   34: aload_3
        //   35: invokevirtual 57	android/os/Parcel:readException	()V
        //   38: aload_3
        //   39: invokevirtual 163	android/os/Parcel:readInt	()I
        //   42: ifeq +26 -> 68
        //   45: getstatic 167	android/location/Location:CREATOR	Landroid/os/Parcelable$Creator;
        //   48: aload_3
        //   49: invokeinterface 173 2 0
        //   54: checkcast 78	android/location/Location
        //   57: astore_1
        //   58: aload_3
        //   59: invokevirtual 60	android/os/Parcel:recycle	()V
        //   62: aload_2
        //   63: invokevirtual 60	android/os/Parcel:recycle	()V
        //   66: aload_1
        //   67: areturn
        //   68: aconst_null
        //   69: astore_1
        //   70: goto -12 -> 58
        //   73: astore_1
        //   74: aload_3
        //   75: invokevirtual 60	android/os/Parcel:recycle	()V
        //   78: aload_2
        //   79: invokevirtual 60	android/os/Parcel:recycle	()V
        //   82: aload_1
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramString	String
        //   3	76	2	localParcel1	Parcel
        //   7	68	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	58	73	finally
      }
      
      /* Error */
      public c bU(String paramString)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 75	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 18	com/google/android/gms/internal/lw$a$a:lb	Landroid/os/IBinder;
        //   23: bipush 34
        //   25: aload_2
        //   26: aload_3
        //   27: iconst_0
        //   28: invokeinterface 54 5 0
        //   33: pop
        //   34: aload_3
        //   35: invokevirtual 57	android/os/Parcel:readException	()V
        //   38: aload_3
        //   39: invokevirtual 163	android/os/Parcel:readInt	()I
        //   42: ifeq +21 -> 63
        //   45: getstatic 180	com/google/android/gms/location/c:CREATOR	Lcom/google/android/gms/location/d;
        //   48: aload_3
        //   49: invokevirtual 186	com/google/android/gms/location/d:ct	(Landroid/os/Parcel;)Lcom/google/android/gms/location/c;
        //   52: astore_1
        //   53: aload_3
        //   54: invokevirtual 60	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 60	android/os/Parcel:recycle	()V
        //   61: aload_1
        //   62: areturn
        //   63: aconst_null
        //   64: astore_1
        //   65: goto -12 -> 53
        //   68: astore_1
        //   69: aload_3
        //   70: invokevirtual 60	android/os/Parcel:recycle	()V
        //   73: aload_2
        //   74: invokevirtual 60	android/os/Parcel:recycle	()V
        //   77: aload_1
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramString	String
        //   3	71	2	localParcel1	Parcel
        //   7	63	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	53	68	finally
      }
      
      /* Error */
      public Location lT()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 18	com/google/android/gms/internal/lw$a$a:lb	Landroid/os/IBinder;
        //   18: bipush 7
        //   20: aload_2
        //   21: aload_3
        //   22: iconst_0
        //   23: invokeinterface 54 5 0
        //   28: pop
        //   29: aload_3
        //   30: invokevirtual 57	android/os/Parcel:readException	()V
        //   33: aload_3
        //   34: invokevirtual 163	android/os/Parcel:readInt	()I
        //   37: ifeq +26 -> 63
        //   40: getstatic 167	android/location/Location:CREATOR	Landroid/os/Parcelable$Creator;
        //   43: aload_3
        //   44: invokeinterface 173 2 0
        //   49: checkcast 78	android/location/Location
        //   52: astore_1
        //   53: aload_3
        //   54: invokevirtual 60	android/os/Parcel:recycle	()V
        //   57: aload_2
        //   58: invokevirtual 60	android/os/Parcel:recycle	()V
        //   61: aload_1
        //   62: areturn
        //   63: aconst_null
        //   64: astore_1
        //   65: goto -12 -> 53
        //   68: astore_1
        //   69: aload_3
        //   70: invokevirtual 60	android/os/Parcel:recycle	()V
        //   73: aload_2
        //   74: invokevirtual 60	android/os/Parcel:recycle	()V
        //   77: aload_1
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   52	13	1	localLocation	Location
        //   68	10	1	localObject	Object
        //   3	71	2	localParcel1	Parcel
        //   7	63	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	53	68	finally
      }
      
      public IBinder lU()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          this.lb.transact(51, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IBinder localIBinder = localParcel2.readStrongBinder();
          return localIBinder;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public IBinder lV()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          this.lb.transact(54, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IBinder localIBinder = localParcel2.readStrongBinder();
          return localIBinder;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void removeActivityUpdates(PendingIntent paramPendingIntent)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 48	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/internal/lw$a$a:lb	Landroid/os/IBinder;
        //   33: bipush 6
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 54 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 57	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 60	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 60	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore_1
        //   66: aload_3
        //   67: invokevirtual 60	android/os/Parcel:recycle	()V
        //   70: aload_2
        //   71: invokevirtual 60	android/os/Parcel:recycle	()V
        //   74: aload_1
        //   75: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	76	0	this	a
        //   0	76	1	paramPendingIntent	PendingIntent
        //   3	68	2	localParcel1	Parcel
        //   7	60	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	29	65	finally
        //   29	48	65	finally
        //   57	62	65	finally
      }
      
      /* Error */
      public void setMockLocation(Location paramLocation)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 30
        //   11: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 79	android/location/Location:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 18	com/google/android/gms/internal/lw$a$a:lb	Landroid/os/IBinder;
        //   33: bipush 13
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 54 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 57	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 60	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 60	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore_1
        //   66: aload_3
        //   67: invokevirtual 60	android/os/Parcel:recycle	()V
        //   70: aload_2
        //   71: invokevirtual 60	android/os/Parcel:recycle	()V
        //   74: aload_1
        //   75: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	76	0	this	a
        //   0	76	1	paramLocation	Location
        //   3	68	2	localParcel1	Parcel
        //   7	60	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	29	65	finally
        //   29	48	65	finally
        //   57	62	65	finally
      }
      
      public void setMockMode(boolean paramBoolean)
        throws RemoteException
      {
        int i = 0;
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.lb.transact(12, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/lw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */