package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.a.a;

public abstract class s
  extends Binder
  implements r
{
  public s()
  {
    attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
  }
  
  public static r a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
    if ((localIInterface != null) && ((localIInterface instanceof r))) {
      return (r)localIInterface;
    }
    return new t(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    int i = 0;
    Object localObject4 = null;
    a locala = null;
    Object localObject2 = null;
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    boolean bool;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.ads.internal.client.IAdManager");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      locala = a();
      paramParcel2.writeNoException();
      paramParcel1 = (Parcel)localObject1;
      if (locala != null) {
        paramParcel1 = locala.asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      b();
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      bool = c();
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = ah.CREATOR;
        localObject1 = l.a(paramParcel1);
      }
      bool = a((ah)localObject1);
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      d();
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      e();
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = locala;
      }
      for (;;)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
        if ((localObject1 != null) && ((localObject1 instanceof o))) {
          paramParcel1 = (o)localObject1;
        } else {
          paramParcel1 = new q(paramParcel1);
        }
      }
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null) {
        paramParcel1 = (Parcel)localObject2;
      }
      for (;;)
      {
        a(paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        if ((localObject1 != null) && ((localObject1 instanceof x))) {
          paramParcel1 = (x)localObject1;
        } else {
          paramParcel1 = new z(paramParcel1);
        }
      }
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      f();
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      g();
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      h();
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      paramParcel1 = i();
      paramParcel2.writeNoException();
      if (paramParcel1 != null)
      {
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
        return true;
      }
      paramParcel2.writeInt(0);
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      localObject1 = localObject5;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = ak.CREATOR;
        localObject1 = n.a(paramParcel1);
      }
      a((ak)localObject1);
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
    paramParcel1 = paramParcel1.readStrongBinder();
    if (paramParcel1 == null) {
      paramParcel1 = (Parcel)localObject3;
    }
    for (;;)
    {
      a(paramParcel1);
      paramParcel2.writeNoException();
      return true;
      localObject1 = paramParcel1.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
      if ((localObject1 != null) && ((localObject1 instanceof aU))) {
        paramParcel1 = (aU)localObject1;
      } else {
        paramParcel1 = new aW(paramParcel1);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */