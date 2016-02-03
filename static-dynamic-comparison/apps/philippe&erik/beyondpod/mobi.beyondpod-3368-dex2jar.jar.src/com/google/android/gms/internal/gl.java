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
import com.google.android.gms.location.LocationRequestCreator;
import com.google.android.gms.location.a;
import com.google.android.gms.location.b;
import com.google.android.gms.location.c;
import com.google.android.gms.location.c.a;
import com.google.android.gms.location.d;
import com.google.android.gms.location.f;
import com.google.android.gms.location.g;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.LatLngBoundsCreator;
import com.google.android.gms.maps.model.LatLngCreator;
import java.util.List;

public abstract interface gl
  extends IInterface
{
  public abstract void a(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(PendingIntent paramPendingIntent, gk paramgk, String paramString)
    throws RemoteException;
  
  public abstract void a(Location paramLocation, int paramInt)
    throws RemoteException;
  
  public abstract void a(gk paramgk, String paramString)
    throws RemoteException;
  
  public abstract void a(gt paramgt, hi paramhi, gz paramgz)
    throws RemoteException;
  
  public abstract void a(gv paramgv, hi paramhi, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(hi paramhi, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(LocationRequest paramLocationRequest, c paramc)
    throws RemoteException;
  
  public abstract void a(LocationRequest paramLocationRequest, c paramc, String paramString)
    throws RemoteException;
  
  public abstract void a(c paramc)
    throws RemoteException;
  
  public abstract void a(LatLng paramLatLng, gt paramgt, hi paramhi, gz paramgz)
    throws RemoteException;
  
  public abstract void a(LatLngBounds paramLatLngBounds, int paramInt, gt paramgt, hi paramhi, gz paramgz)
    throws RemoteException;
  
  public abstract void a(String paramString, gh paramgh, gj paramgj)
    throws RemoteException;
  
  public abstract void a(String paramString, gj paramgj)
    throws RemoteException;
  
  public abstract void a(String paramString, hi paramhi, gz paramgz)
    throws RemoteException;
  
  public abstract void a(String paramString, a parama, gj paramgj)
    throws RemoteException;
  
  public abstract void a(String paramString, f paramf, gj paramgj)
    throws RemoteException;
  
  public abstract void a(String paramString1, String paramString2, hi paramhi)
    throws RemoteException;
  
  public abstract void a(String paramString, boolean paramBoolean, gj paramgj)
    throws RemoteException;
  
  public abstract void a(List<hd.a> paramList)
    throws RemoteException;
  
  public abstract void a(List<go> paramList, PendingIntent paramPendingIntent, gk paramgk, String paramString)
    throws RemoteException;
  
  public abstract void a(String[] paramArrayOfString, gk paramgk, String paramString)
    throws RemoteException;
  
  public abstract Location an(String paramString)
    throws RemoteException;
  
  public abstract d ao(String paramString)
    throws RemoteException;
  
  public abstract void b(String paramString, gj paramgj)
    throws RemoteException;
  
  public abstract void b(String paramString, f paramf, gj paramgj)
    throws RemoteException;
  
  public abstract Location dH()
    throws RemoteException;
  
  public abstract void removeActivityUpdates(PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void setMockLocation(Location paramLocation)
    throws RemoteException;
  
  public abstract void setMockMode(boolean paramBoolean)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements gl
  {
    public static gl L(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if ((localIInterface != null) && ((localIInterface instanceof gl))) {
        return (gl)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool2 = false;
      boolean bool3 = false;
      boolean bool1 = false;
      Object localObject13 = null;
      Object localObject14 = null;
      Object localObject15 = null;
      Object localObject16 = null;
      Object localObject2 = null;
      Object localObject17 = null;
      Object localObject18 = null;
      Object localObject8 = null;
      Object localObject3 = null;
      Object localObject5 = null;
      Object localObject4 = null;
      Object localObject6 = null;
      Object localObject19 = null;
      Object localObject1 = null;
      Object localObject20 = null;
      Object localObject9 = null;
      Object localObject10 = null;
      Object localObject11 = null;
      Object localObject12 = null;
      Object localObject7 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject2 = paramParcel1.createTypedArrayList(go.CREATOR);
        localObject1 = localObject7;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        a((List)localObject2, (PendingIntent)localObject1, gk.a.K(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject1 = localObject13;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        a((PendingIntent)localObject1, gk.a.K(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(paramParcel1.createStringArray(), gk.a.K(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(gk.a.K(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        long l = paramParcel1.readLong();
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        localObject1 = localObject14;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        a(l, bool1, (PendingIntent)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject1 = localObject15;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        removeActivityUpdates((PendingIntent)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        paramParcel1 = dH();
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
        localObject1 = localObject16;
        if (paramParcel1.readInt() != 0) {
          localObject1 = LocationRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((LocationRequest)localObject1, c.a.I(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = LocationRequest.CREATOR.createFromParcel(paramParcel1);; localObject1 = null)
        {
          if (paramParcel1.readInt() != 0) {
            localObject2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
          }
          a((LocationRequest)localObject1, (PendingIntent)localObject2);
          paramParcel2.writeNoException();
          return true;
        }
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(c.a.I(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject1 = localObject17;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
        }
        a((PendingIntent)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        bool1 = bool2;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        setMockMode(bool1);
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject1 = localObject18;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Location)Location.CREATOR.createFromParcel(paramParcel1);
        }
        setMockLocation((Location)localObject1);
        paramParcel2.writeNoException();
        return true;
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = LatLngBounds.CREATOR.createFromParcel(paramParcel1);
          paramInt1 = paramParcel1.readInt();
          if (paramParcel1.readInt() == 0) {
            break label1022;
          }
          localObject2 = gt.CREATOR.aj(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1028;
          }
        }
        for (localObject3 = hi.CREATOR.aq(paramParcel1);; localObject3 = null)
        {
          a((LatLngBounds)localObject1, paramInt1, (gt)localObject2, (hi)localObject3, gz.a.N(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
          localObject2 = null;
          break label976;
        }
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject2 = paramParcel1.readString();
        localObject1 = localObject8;
        if (paramParcel1.readInt() != 0) {
          localObject1 = hi.CREATOR.aq(paramParcel1);
        }
        a((String)localObject2, (hi)localObject1, gz.a.N(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = LatLng.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1170;
          }
        }
        for (localObject2 = gt.CREATOR.aj(paramParcel1);; localObject2 = null)
        {
          if (paramParcel1.readInt() != 0) {
            localObject3 = hi.CREATOR.aq(paramParcel1);
          }
          a((LatLng)localObject1, (gt)localObject2, (hi)localObject3, gz.a.N(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = gt.CREATOR.aj(paramParcel1);; localObject1 = null)
        {
          localObject2 = localObject5;
          if (paramParcel1.readInt() != 0) {
            localObject2 = hi.CREATOR.aq(paramParcel1);
          }
          a((gt)localObject1, (hi)localObject2, gz.a.N(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
        }
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0)
        {
          localObject1 = gv.CREATOR.ak(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1330;
          }
        }
        for (localObject2 = hi.CREATOR.aq(paramParcel1);; localObject2 = null)
        {
          localObject3 = localObject4;
          if (paramParcel1.readInt() != 0) {
            localObject3 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
          }
          a((gv)localObject1, (hi)localObject2, (PendingIntent)localObject3);
          paramParcel2.writeNoException();
          return true;
          localObject1 = null;
          break;
        }
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (localObject1 = hi.CREATOR.aq(paramParcel1);; localObject1 = null)
        {
          localObject2 = localObject6;
          if (paramParcel1.readInt() != 0) {
            localObject2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);
          }
          a((hi)localObject1, (PendingIntent)localObject2);
          paramParcel2.writeNoException();
          return true;
        }
      case 20: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject1 = localObject19;
        if (paramParcel1.readInt() != 0) {
          localObject1 = LocationRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a((LocationRequest)localObject1, c.a.I(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 21: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        paramParcel1 = an(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (paramParcel1 != null)
        {
          paramParcel2.writeInt(1);
          paramParcel1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(paramParcel1.createTypedArrayList(hd.a.CREATOR));
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject2 = paramParcel1.readString();
        localObject3 = paramParcel1.readString();
        paramParcel2 = (Parcel)localObject1;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = hi.CREATOR.aq(paramParcel1);
        }
        a((String)localObject2, (String)localObject3, paramParcel2);
        return true;
      case 26: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject1 = localObject20;
        if (paramParcel1.readInt() != 0) {
          localObject1 = (Location)Location.CREATOR.createFromParcel(paramParcel1);
        }
        a((Location)localObject1, paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject2 = paramParcel1.readString();
        localObject1 = localObject9;
        if (paramParcel1.readInt() != 0) {
          localObject1 = a.CREATOR.ae(paramParcel1);
        }
        a((String)localObject2, (a)localObject1, gj.a.J(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject2 = paramParcel1.readString();
        localObject1 = localObject10;
        if (paramParcel1.readInt() != 0) {
          localObject1 = gh.CREATOR.ah(paramParcel1);
        }
        a((String)localObject2, (gh)localObject1, gj.a.J(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(paramParcel1.readString(), gj.a.J(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 30: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject2 = paramParcel1.readString();
        localObject1 = localObject11;
        if (paramParcel1.readInt() != 0) {
          localObject1 = f.CREATOR.ag(paramParcel1);
        }
        a((String)localObject2, (f)localObject1, gj.a.J(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 31: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject2 = paramParcel1.readString();
        localObject1 = localObject12;
        if (paramParcel1.readInt() != 0) {
          localObject1 = f.CREATOR.ag(paramParcel1);
        }
        b((String)localObject2, (f)localObject1, gj.a.J(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 32: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        localObject1 = paramParcel1.readString();
        bool1 = bool3;
        if (paramParcel1.readInt() != 0) {
          bool1 = true;
        }
        a((String)localObject1, bool1, gj.a.J(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 33: 
        label976:
        label1022:
        label1028:
        label1170:
        label1330:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        b(paramParcel1.readString(), gj.a.J(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      paramParcel1 = ao(paramParcel1.readString());
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
    
    private static class a
      implements gl
    {
      private IBinder dU;
      
      a(IBinder paramIBinder)
      {
        this.dU = paramIBinder;
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
        //   57: getfield 18	com/google/android/gms/internal/gl$a$a:dU	Landroid/os/IBinder;
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
        //   30: getfield 18	com/google/android/gms/internal/gl$a$a:dU	Landroid/os/IBinder;
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
      
      public void a(PendingIntent paramPendingIntent, gk paramgk, String paramString)
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
              if (paramgk != null)
              {
                paramPendingIntent = paramgk.asBinder();
                localParcel1.writeStrongBinder(paramPendingIntent);
                localParcel1.writeString(paramString);
                this.dU.transact(2, localParcel1, localParcel2, 0);
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
        //   36: getfield 18	com/google/android/gms/internal/gl$a$a:dU	Landroid/os/IBinder;
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
      public void a(gk paramgk, String paramString)
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
        //   37: getfield 18	com/google/android/gms/internal/gl$a$a:dU	Landroid/os/IBinder;
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
        //   0	83	1	paramgk	gk
        //   0	83	2	paramString	String
        //   3	75	3	localParcel1	Parcel
        //   7	66	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	15	71	finally
        //   19	26	71	finally
        //   26	56	71	finally
      }
      
      public void a(gt paramgt, hi paramhi, gz paramgz)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramgt != null)
            {
              localParcel1.writeInt(1);
              paramgt.writeToParcel(localParcel1, 0);
              if (paramhi != null)
              {
                localParcel1.writeInt(1);
                paramhi.writeToParcel(localParcel1, 0);
                if (paramgz == null) {
                  break label132;
                }
                paramgt = paramgz.asBinder();
                localParcel1.writeStrongBinder(paramgt);
                this.dU.transact(17, localParcel1, localParcel2, 0);
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
          paramgt = null;
        }
      }
      
      public void a(gv paramgv, hi paramhi, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramgv != null)
            {
              localParcel1.writeInt(1);
              paramgv.writeToParcel(localParcel1, 0);
              if (paramhi != null)
              {
                localParcel1.writeInt(1);
                paramhi.writeToParcel(localParcel1, 0);
                if (paramPendingIntent == null) {
                  break label132;
                }
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.dU.transact(18, localParcel1, localParcel2, 0);
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
      
      public void a(hi paramhi, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramhi != null)
            {
              localParcel1.writeInt(1);
              paramhi.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.dU.transact(19, localParcel1, localParcel2, 0);
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
                this.dU.transact(9, localParcel1, localParcel2, 0);
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
      
      public void a(LocationRequest paramLocationRequest, c paramc)
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
              if (paramc != null)
              {
                paramLocationRequest = paramc.asBinder();
                localParcel1.writeStrongBinder(paramLocationRequest);
                this.dU.transact(8, localParcel1, localParcel2, 0);
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
      
      public void a(LocationRequest paramLocationRequest, c paramc, String paramString)
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
              if (paramc != null)
              {
                paramLocationRequest = paramc.asBinder();
                localParcel1.writeStrongBinder(paramLocationRequest);
                localParcel1.writeString(paramString);
                this.dU.transact(20, localParcel1, localParcel2, 0);
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
      public void a(c paramc)
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
        //   19: invokeinterface 103 1 0
        //   24: astore_1
        //   25: aload_2
        //   26: aload_1
        //   27: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   30: aload_0
        //   31: getfield 18	com/google/android/gms/internal/gl$a$a:dU	Landroid/os/IBinder;
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
        //   0	74	1	paramc	c
        //   3	66	2	localParcel1	Parcel
        //   7	58	3	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   8	14	63	finally
        //   18	25	63	finally
        //   25	49	63	finally
      }
      
      public void a(LatLng paramLatLng, gt paramgt, hi paramhi, gz paramgz)
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
              if (paramgt != null)
              {
                localParcel1.writeInt(1);
                paramgt.writeToParcel(localParcel1, 0);
                if (paramhi == null) {
                  break label151;
                }
                localParcel1.writeInt(1);
                paramhi.writeToParcel(localParcel1, 0);
                if (paramgz == null) {
                  break label160;
                }
                paramLatLng = paramgz.asBinder();
                localParcel1.writeStrongBinder(paramLatLng);
                this.dU.transact(16, localParcel1, localParcel2, 0);
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
      
      public void a(LatLngBounds paramLatLngBounds, int paramInt, gt paramgt, hi paramhi, gz paramgz)
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
              if (paramgt != null)
              {
                localParcel1.writeInt(1);
                paramgt.writeToParcel(localParcel1, 0);
                if (paramhi == null) {
                  break label159;
                }
                localParcel1.writeInt(1);
                paramhi.writeToParcel(localParcel1, 0);
                if (paramgz == null) {
                  break label168;
                }
                paramLatLngBounds = paramgz.asBinder();
                localParcel1.writeStrongBinder(paramLatLngBounds);
                this.dU.transact(14, localParcel1, localParcel2, 0);
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
      
      public void a(String paramString, gh paramgh, gj paramgj)
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
            if (paramgh != null)
            {
              localParcel1.writeInt(1);
              paramgh.writeToParcel(localParcel1, 0);
              if (paramgj != null)
              {
                paramString = paramgj.asBinder();
                localParcel1.writeStrongBinder(paramString);
                this.dU.transact(28, localParcel1, localParcel2, 0);
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
      public void a(String paramString, gj paramgj)
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
        //   15: aload_3
        //   16: aload_1
        //   17: invokevirtual 75	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   20: aload_2
        //   21: ifnull +46 -> 67
        //   24: aload_2
        //   25: invokeinterface 120 1 0
        //   30: astore_1
        //   31: aload_3
        //   32: aload_1
        //   33: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload_0
        //   37: getfield 18	com/google/android/gms/internal/gl$a$a:dU	Landroid/os/IBinder;
        //   40: bipush 29
        //   42: aload_3
        //   43: aload 4
        //   45: iconst_0
        //   46: invokeinterface 54 5 0
        //   51: pop
        //   52: aload 4
        //   54: invokevirtual 57	android/os/Parcel:readException	()V
        //   57: aload 4
        //   59: invokevirtual 60	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 60	android/os/Parcel:recycle	()V
        //   66: return
        //   67: aconst_null
        //   68: astore_1
        //   69: goto -38 -> 31
        //   72: astore_1
        //   73: aload 4
        //   75: invokevirtual 60	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: invokevirtual 60	android/os/Parcel:recycle	()V
        //   82: aload_1
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramString	String
        //   0	84	2	paramgj	gj
        //   3	76	3	localParcel1	Parcel
        //   7	67	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	20	72	finally
        //   24	31	72	finally
        //   31	57	72	finally
      }
      
      public void a(String paramString, hi paramhi, gz paramgz)
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
            if (paramhi != null)
            {
              localParcel1.writeInt(1);
              paramhi.writeToParcel(localParcel1, 0);
              if (paramgz != null)
              {
                paramString = paramgz.asBinder();
                localParcel1.writeStrongBinder(paramString);
                this.dU.transact(15, localParcel1, localParcel2, 0);
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
      
      public void a(String paramString, a parama, gj paramgj)
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
            if (parama != null)
            {
              localParcel1.writeInt(1);
              parama.writeToParcel(localParcel1, 0);
              if (paramgj != null)
              {
                paramString = paramgj.asBinder();
                localParcel1.writeStrongBinder(paramString);
                this.dU.transact(27, localParcel1, localParcel2, 0);
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
      
      public void a(String paramString, f paramf, gj paramgj)
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
            if (paramf != null)
            {
              localParcel1.writeInt(1);
              paramf.writeToParcel(localParcel1, 0);
              if (paramgj != null)
              {
                paramString = paramgj.asBinder();
                localParcel1.writeStrongBinder(paramString);
                this.dU.transact(30, localParcel1, localParcel2, 0);
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
      public void a(String paramString1, String paramString2, hi paramhi)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: aload 4
        //   7: ldc 30
        //   9: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   12: aload 4
        //   14: aload_1
        //   15: invokevirtual 75	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   18: aload 4
        //   20: aload_2
        //   21: invokevirtual 75	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   24: aload_3
        //   25: ifnull +38 -> 63
        //   28: aload 4
        //   30: iconst_1
        //   31: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   34: aload_3
        //   35: aload 4
        //   37: iconst_0
        //   38: invokevirtual 87	com/google/android/gms/internal/hi:writeToParcel	(Landroid/os/Parcel;I)V
        //   41: aload_0
        //   42: getfield 18	com/google/android/gms/internal/gl$a$a:dU	Landroid/os/IBinder;
        //   45: bipush 25
        //   47: aload 4
        //   49: aconst_null
        //   50: iconst_1
        //   51: invokeinterface 54 5 0
        //   56: pop
        //   57: aload 4
        //   59: invokevirtual 60	android/os/Parcel:recycle	()V
        //   62: return
        //   63: aload 4
        //   65: iconst_0
        //   66: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   69: goto -28 -> 41
        //   72: astore_1
        //   73: aload 4
        //   75: invokevirtual 60	android/os/Parcel:recycle	()V
        //   78: aload_1
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	a
        //   0	80	1	paramString1	String
        //   0	80	2	paramString2	String
        //   0	80	3	paramhi	hi
        //   3	71	4	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   5	24	72	finally
        //   28	41	72	finally
        //   41	57	72	finally
        //   63	69	72	finally
      }
      
      /* Error */
      public void a(String paramString, boolean paramBoolean, gj paramgj)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 4
        //   3: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 5
        //   8: invokestatic 28	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 6
        //   13: aload 5
        //   15: ldc 30
        //   17: invokevirtual 34	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 5
        //   22: aload_1
        //   23: invokevirtual 75	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   26: iload_2
        //   27: ifeq +6 -> 33
        //   30: iconst_1
        //   31: istore 4
        //   33: aload 5
        //   35: iload 4
        //   37: invokevirtual 42	android/os/Parcel:writeInt	(I)V
        //   40: aload_3
        //   41: ifnull +49 -> 90
        //   44: aload_3
        //   45: invokeinterface 120 1 0
        //   50: astore_1
        //   51: aload 5
        //   53: aload_1
        //   54: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   57: aload_0
        //   58: getfield 18	com/google/android/gms/internal/gl$a$a:dU	Landroid/os/IBinder;
        //   61: bipush 32
        //   63: aload 5
        //   65: aload 6
        //   67: iconst_0
        //   68: invokeinterface 54 5 0
        //   73: pop
        //   74: aload 6
        //   76: invokevirtual 57	android/os/Parcel:readException	()V
        //   79: aload 6
        //   81: invokevirtual 60	android/os/Parcel:recycle	()V
        //   84: aload 5
        //   86: invokevirtual 60	android/os/Parcel:recycle	()V
        //   89: return
        //   90: aconst_null
        //   91: astore_1
        //   92: goto -41 -> 51
        //   95: astore_1
        //   96: aload 6
        //   98: invokevirtual 60	android/os/Parcel:recycle	()V
        //   101: aload 5
        //   103: invokevirtual 60	android/os/Parcel:recycle	()V
        //   106: aload_1
        //   107: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	108	0	this	a
        //   0	108	1	paramString	String
        //   0	108	2	paramBoolean	boolean
        //   0	108	3	paramgj	gj
        //   1	35	4	i	int
        //   6	96	5	localParcel1	Parcel
        //   11	86	6	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   13	26	95	finally
        //   33	40	95	finally
        //   44	51	95	finally
        //   51	79	95	finally
      }
      
      public void a(List<hd.a> paramList)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        try
        {
          localParcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          localParcel.writeTypedList(paramList);
          this.dU.transact(24, localParcel, null, 1);
          return;
        }
        finally
        {
          localParcel.recycle();
        }
      }
      
      public void a(List<go> paramList, PendingIntent paramPendingIntent, gk paramgk, String paramString)
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
              if (paramgk != null)
              {
                paramList = paramgk.asBinder();
                localParcel1.writeStrongBinder(paramList);
                localParcel1.writeString(paramString);
                this.dU.transact(1, localParcel1, localParcel2, 0);
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
      public void a(String[] paramArrayOfString, gk paramgk, String paramString)
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
        //   20: invokevirtual 145	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
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
        //   47: getfield 18	com/google/android/gms/internal/gl$a$a:dU	Landroid/os/IBinder;
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
        //   0	96	2	paramgk	gk
        //   0	96	3	paramString	String
        //   3	87	4	localParcel1	Parcel
        //   8	77	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	23	83	finally
        //   27	34	83	finally
        //   34	67	83	finally
      }
      
      /* Error */
      public Location an(String paramString)
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
        //   20: getfield 18	com/google/android/gms/internal/gl$a$a:dU	Landroid/os/IBinder;
        //   23: bipush 21
        //   25: aload_2
        //   26: aload_3
        //   27: iconst_0
        //   28: invokeinterface 54 5 0
        //   33: pop
        //   34: aload_3
        //   35: invokevirtual 57	android/os/Parcel:readException	()V
        //   38: aload_3
        //   39: invokevirtual 151	android/os/Parcel:readInt	()I
        //   42: ifeq +26 -> 68
        //   45: getstatic 155	android/location/Location:CREATOR	Landroid/os/Parcelable$Creator;
        //   48: aload_3
        //   49: invokeinterface 161 2 0
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
      public d ao(String paramString)
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
        //   20: getfield 18	com/google/android/gms/internal/gl$a$a:dU	Landroid/os/IBinder;
        //   23: bipush 34
        //   25: aload_2
        //   26: aload_3
        //   27: iconst_0
        //   28: invokeinterface 54 5 0
        //   33: pop
        //   34: aload_3
        //   35: invokevirtual 57	android/os/Parcel:readException	()V
        //   38: aload_3
        //   39: invokevirtual 151	android/os/Parcel:readInt	()I
        //   42: ifeq +21 -> 63
        //   45: getstatic 168	com/google/android/gms/location/d:CREATOR	Lcom/google/android/gms/location/e;
        //   48: aload_3
        //   49: invokevirtual 174	com/google/android/gms/location/e:af	(Landroid/os/Parcel;)Lcom/google/android/gms/location/d;
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
      
      public IBinder asBinder()
      {
        return this.dU;
      }
      
      /* Error */
      public void b(String paramString, gj paramgj)
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
        //   15: aload_3
        //   16: aload_1
        //   17: invokevirtual 75	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   20: aload_2
        //   21: ifnull +46 -> 67
        //   24: aload_2
        //   25: invokeinterface 120 1 0
        //   30: astore_1
        //   31: aload_3
        //   32: aload_1
        //   33: invokevirtual 72	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload_0
        //   37: getfield 18	com/google/android/gms/internal/gl$a$a:dU	Landroid/os/IBinder;
        //   40: bipush 33
        //   42: aload_3
        //   43: aload 4
        //   45: iconst_0
        //   46: invokeinterface 54 5 0
        //   51: pop
        //   52: aload 4
        //   54: invokevirtual 57	android/os/Parcel:readException	()V
        //   57: aload 4
        //   59: invokevirtual 60	android/os/Parcel:recycle	()V
        //   62: aload_3
        //   63: invokevirtual 60	android/os/Parcel:recycle	()V
        //   66: return
        //   67: aconst_null
        //   68: astore_1
        //   69: goto -38 -> 31
        //   72: astore_1
        //   73: aload 4
        //   75: invokevirtual 60	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: invokevirtual 60	android/os/Parcel:recycle	()V
        //   82: aload_1
        //   83: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	84	0	this	a
        //   0	84	1	paramString	String
        //   0	84	2	paramgj	gj
        //   3	76	3	localParcel1	Parcel
        //   7	67	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	20	72	finally
        //   24	31	72	finally
        //   31	57	72	finally
      }
      
      public void b(String paramString, f paramf, gj paramgj)
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
            if (paramf != null)
            {
              localParcel1.writeInt(1);
              paramf.writeToParcel(localParcel1, 0);
              if (paramgj != null)
              {
                paramString = paramgj.asBinder();
                localParcel1.writeStrongBinder(paramString);
                this.dU.transact(31, localParcel1, localParcel2, 0);
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
      public Location dH()
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
        //   15: getfield 18	com/google/android/gms/internal/gl$a$a:dU	Landroid/os/IBinder;
        //   18: bipush 7
        //   20: aload_2
        //   21: aload_3
        //   22: iconst_0
        //   23: invokeinterface 54 5 0
        //   28: pop
        //   29: aload_3
        //   30: invokevirtual 57	android/os/Parcel:readException	()V
        //   33: aload_3
        //   34: invokevirtual 151	android/os/Parcel:readInt	()I
        //   37: ifeq +26 -> 63
        //   40: getstatic 155	android/location/Location:CREATOR	Landroid/os/Parcelable$Creator;
        //   43: aload_3
        //   44: invokeinterface 161 2 0
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
        //   30: getfield 18	com/google/android/gms/internal/gl$a$a:dU	Landroid/os/IBinder;
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
        //   30: getfield 18	com/google/android/gms/internal/gl$a$a:dU	Landroid/os/IBinder;
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
          this.dU.transact(12, localParcel1, localParcel2, 0);
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/gl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */