package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

class my
  implements dw
{
  private IBinder a;
  
  my(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
  
  public du b(ds paramds)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (paramds != null)
        {
          localParcel1.writeInt(1);
          paramds.writeToParcel(localParcel1, 0);
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramds = du.CREATOR.i(localParcel2);
            return paramds;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramds = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/my.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */