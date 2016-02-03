package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.d;

public abstract class aq$a
  extends Binder
  implements aq
{
  public aq$a()
  {
    attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
  }
  
  public static aq f(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
    if ((localIInterface != null) && ((localIInterface instanceof aq))) {
      return (aq)localIInterface;
    }
    return new n(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    d locald = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 0;
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
      locald = U();
      paramParcel2.writeNoException();
      paramParcel1 = (Parcel)localObject1;
      if (locald != null) {
        paramParcel1 = locald.asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      destroy();
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      bool = isReady();
      paramParcel2.writeNoException();
      if (bool) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramParcel2.writeInt(paramInt1);
        return true;
      }
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      localObject1 = locald;
      if (paramParcel1.readInt() != 0) {
        localObject1 = ai.CREATOR.b(paramParcel1);
      }
      bool = a((ai)localObject1);
      paramParcel2.writeNoException();
      paramInt1 = i;
      if (bool) {
        paramInt1 = 1;
      }
      paramParcel2.writeInt(paramInt1);
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      pause();
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      resume();
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      a(ap.a.e(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      a(as.a.h(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      showInterstitial();
      paramParcel2.writeNoException();
      return true;
    case 10: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      stopLoading();
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      ag();
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      paramParcel1 = V();
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
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = al.CREATOR.c(paramParcel1);
      }
      a((al)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
      a(dc.a.q(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdManager");
    a(dg.a.u(paramParcel1.readStrongBinder()), paramParcel1.readString());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/aq$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */