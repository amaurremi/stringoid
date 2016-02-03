package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.a.a;
import com.google.android.gms.a.b;

public abstract class an
  extends Binder
  implements am
{
  public an()
  {
    attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
  }
  
  public static am a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    if ((localIInterface != null) && ((localIInterface instanceof am))) {
      return (am)localIInterface;
    }
    return new ao(paramIBinder);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    a locala;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      locala = b.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = ak.CREATOR;
        localObject1 = n.a(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label198;
        }
        localObject2 = ah.CREATOR;
      }
      for (localObject2 = l.a(paramParcel1);; localObject2 = null)
      {
        a(locala, (ak)localObject1, (ah)localObject2, paramParcel1.readString(), aq.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      localObject2 = a();
      paramParcel2.writeNoException();
      paramParcel1 = (Parcel)localObject1;
      if (localObject2 != null) {
        paramParcel1 = ((a)localObject2).asBinder();
      }
      paramParcel2.writeStrongBinder(paramParcel1);
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      locala = b.a(paramParcel1.readStrongBinder());
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = ah.CREATOR;
        localObject1 = l.a(paramParcel1);
      }
      a(locala, (ah)localObject1, paramParcel1.readString(), aq.a(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      b();
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      c();
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      locala = b.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0)
      {
        localObject1 = ak.CREATOR;
        localObject1 = n.a(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label425;
        }
        localObject2 = ah.CREATOR;
      }
      for (localObject2 = l.a(paramParcel1);; localObject2 = null)
      {
        a(locala, (ak)localObject1, (ah)localObject2, paramParcel1.readString(), paramParcel1.readString(), aq.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
        localObject1 = null;
        break;
      }
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      localObject2 = b.a(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {
        localObject1 = ah.CREATOR;
      }
      for (localObject1 = l.a(paramParcel1);; localObject1 = null)
      {
        a((a)localObject2, (ah)localObject1, paramParcel1.readString(), paramParcel1.readString(), aq.a(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
    case 8: 
      label198:
      label425:
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
      d();
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    e();
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */