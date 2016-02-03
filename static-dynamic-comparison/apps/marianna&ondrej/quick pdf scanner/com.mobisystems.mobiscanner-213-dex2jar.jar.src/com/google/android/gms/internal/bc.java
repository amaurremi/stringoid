package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract interface bc
  extends IInterface
{
  public abstract cf b(cd paramcd);
  
  public static abstract class a
    extends Binder
    implements bc
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }
    
    public static bc u(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
      if ((localIInterface != null) && ((localIInterface instanceof bc))) {
        return (bc)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
      if (paramParcel1.readInt() != 0)
      {
        paramParcel1 = cd.Dz.an(paramParcel1);
        paramParcel1 = b(paramParcel1);
        paramParcel2.writeNoException();
        if (paramParcel1 == null) {
          break label99;
        }
        paramParcel2.writeInt(1);
        paramParcel1.writeToParcel(paramParcel2, 1);
      }
      for (;;)
      {
        return true;
        paramParcel1 = null;
        break;
        label99:
        paramParcel2.writeInt(0);
      }
    }
    
    private static class a
      implements bc
    {
      private IBinder tS;
      
      a(IBinder paramIBinder)
      {
        this.tS = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.tS;
      }
      
      public cf b(cd paramcd)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
            if (paramcd != null)
            {
              localParcel1.writeInt(1);
              paramcd.writeToParcel(localParcel1, 0);
              this.tS.transact(1, localParcel1, localParcel2, 0);
              localParcel2.readException();
              if (localParcel2.readInt() != 0)
              {
                paramcd = cf.DK.ao(localParcel2);
                return paramcd;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            paramcd = null;
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
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */