package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;

public abstract interface lj
  extends IInterface
{
  public abstract void a(FitnessSensorServiceRequest paramFitnessSensorServiceRequest, ks paramks)
    throws RemoteException;
  
  public abstract void a(lf paramlf, km paramkm)
    throws RemoteException;
  
  public abstract void a(lh paramlh, ks paramks)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements lj
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
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
      Object localObject1 = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        paramParcel2 = (Parcel)localObject1;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (lf)lf.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, km.a.aq(paramParcel1.readStrongBinder()));
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        paramParcel2 = (Parcel)localObject2;
        if (paramParcel1.readInt() != 0) {
          paramParcel2 = (FitnessSensorServiceRequest)FitnessSensorServiceRequest.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramParcel2, ks.a.aw(paramParcel1.readStrongBinder()));
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
      paramParcel2 = (Parcel)localObject3;
      if (paramParcel1.readInt() != 0) {
        paramParcel2 = (lh)lh.CREATOR.createFromParcel(paramParcel1);
      }
      a(paramParcel2, ks.a.aw(paramParcel1.readStrongBinder()));
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/internal/lj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */