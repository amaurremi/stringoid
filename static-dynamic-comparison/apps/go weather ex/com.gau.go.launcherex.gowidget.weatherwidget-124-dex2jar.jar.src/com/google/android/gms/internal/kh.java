package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.DataHolderCreator;

public abstract interface kh
  extends IInterface
{
  public abstract void M(DataHolder paramDataHolder)
    throws RemoteException;
  
  public abstract void a(ki paramki)
    throws RemoteException;
  
  public abstract void a(kk paramkk)
    throws RemoteException;
  
  public abstract void b(kk paramkk)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements kh
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.wearable.internal.IWearableListener");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = (Parcel)localObject1;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = DataHolder.CREATOR.createFromParcel(paramParcel1);
        }
        M(paramParcel2);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = (Parcel)localObject2;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (ki)ki.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
        paramParcel2 = (Parcel)localObject3;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (kk)kk.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2);
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.wearable.internal.IWearableListener");
      paramParcel2 = (Parcel)localObject4;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (kk)kk.CREATOR.createFromParcel(paramParcel1);
      }
      b(paramParcel2);
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/internal/kh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */