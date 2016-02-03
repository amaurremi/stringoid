package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.c;

public abstract class ad$a
  extends Binder
  implements ad
{
  public static ad by(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
    if ((localIInterface != null) && ((localIInterface instanceof ad))) {
      return (ad)localIInterface;
    }
    return new ax(paramIBinder);
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    ab localab1 = null;
    ab localab2 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject1 = null;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.gms.wearable.internal.IWearableService");
      return true;
    case 2: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localab1 = ab.a.bw(paramParcel1.readStrongBinder());
      if (paramParcel1.readInt() != 0) {
        localObject1 = (c)c.CREATOR.createFromParcel(paramParcel1);
      }
      a(localab1, (c)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 3: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      a(ab.a.bw(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 4: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      b(ab.a.bw(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 5: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      c(ab.a.bw(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 6: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localab2 = ab.a.bw(paramParcel1.readStrongBinder());
      localObject1 = localab1;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (PutDataRequest)PutDataRequest.CREATOR.createFromParcel(paramParcel1);
      }
      a(localab2, (PutDataRequest)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 7: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localab1 = ab.a.bw(paramParcel1.readStrongBinder());
      localObject1 = localab2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
      }
      a(localab1, (Uri)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 8: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      d(ab.a.bw(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 9: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localab1 = ab.a.bw(paramParcel1.readStrongBinder());
      localObject1 = localObject2;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
      }
      b(localab1, (Uri)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 11: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localab1 = ab.a.bw(paramParcel1.readStrongBinder());
      localObject1 = localObject3;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Uri)Uri.CREATOR.createFromParcel(paramParcel1);
      }
      c(localab1, (Uri)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 12: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      a(ab.a.bw(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.createByteArray());
      paramParcel2.writeNoException();
      return true;
    case 13: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localab1 = ab.a.bw(paramParcel1.readStrongBinder());
      localObject1 = localObject4;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (Asset)Asset.CREATOR.createFromParcel(paramParcel1);
      }
      a(localab1, (Asset)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 14: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      e(ab.a.bw(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 15: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      f(ab.a.bw(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    case 16: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localab1 = ab.a.bw(paramParcel1.readStrongBinder());
      localObject1 = localObject5;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (b)b.CREATOR.createFromParcel(paramParcel1);
      }
      a(localab1, (b)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 17: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      localab1 = ab.a.bw(paramParcel1.readStrongBinder());
      localObject1 = localObject6;
      if (paramParcel1.readInt() != 0) {
        localObject1 = (ao)ao.CREATOR.createFromParcel(paramParcel1);
      }
      a(localab1, (ao)localObject1);
      paramParcel2.writeNoException();
      return true;
    case 18: 
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
      g(ab.a.bw(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableService");
    h(ab.a.bw(paramParcel1.readStrongBinder()));
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/wearable/internal/ad$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */