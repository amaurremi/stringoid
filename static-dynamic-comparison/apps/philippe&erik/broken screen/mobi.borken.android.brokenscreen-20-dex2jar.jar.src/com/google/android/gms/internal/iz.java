package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.identity.intents.UserAddressRequest;

public abstract interface iz
  extends IInterface
{
  public abstract void a(iy paramiy, UserAddressRequest paramUserAddressRequest, Bundle paramBundle)
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements iz
  {
    public static iz ap(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.identity.intents.internal.IAddressService");
      if ((localIInterface != null) && ((localIInterface instanceof iz))) {
        return (iz)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.identity.intents.internal.IAddressService");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.identity.intents.internal.IAddressService");
      iy localiy = iy.a.ao(paramParcel1.readStrongBinder());
      UserAddressRequest localUserAddressRequest;
      if (paramParcel1.readInt() != 0)
      {
        localUserAddressRequest = (UserAddressRequest)UserAddressRequest.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label123;
        }
      }
      label123:
      for (paramParcel1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; paramParcel1 = null)
      {
        a(localiy, localUserAddressRequest, paramParcel1);
        paramParcel2.writeNoException();
        return true;
        localUserAddressRequest = null;
        break;
      }
    }
    
    private static class a
      implements iz
    {
      private IBinder ko;
      
      a(IBinder paramIBinder)
      {
        this.ko = paramIBinder;
      }
      
      public void a(iy paramiy, UserAddressRequest paramUserAddressRequest, Bundle paramBundle)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        label127:
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.identity.intents.internal.IAddressService");
            if (paramiy != null)
            {
              paramiy = paramiy.asBinder();
              localParcel1.writeStrongBinder(paramiy);
              if (paramUserAddressRequest != null)
              {
                localParcel1.writeInt(1);
                paramUserAddressRequest.writeToParcel(localParcel1, 0);
                if (paramBundle == null) {
                  break label127;
                }
                localParcel1.writeInt(1);
                paramBundle.writeToParcel(localParcel1, 0);
                this.ko.transact(2, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              paramiy = null;
              continue;
            }
            localParcel1.writeInt(0);
            continue;
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public IBinder asBinder()
      {
        return this.ko;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/iz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */