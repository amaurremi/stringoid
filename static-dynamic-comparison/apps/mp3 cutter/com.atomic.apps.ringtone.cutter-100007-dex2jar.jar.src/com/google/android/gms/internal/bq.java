package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

final class bq
  implements bo
{
  private IBinder a;
  
  bq(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public final cz a(cx paramcx)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (paramcx != null)
        {
          localParcel1.writeInt(1);
          paramcx.writeToParcel(localParcel1, 0);
          this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          if (localParcel2.readInt() != 0)
          {
            paramcx = cz.CREATOR;
            paramcx = bn.a(localParcel2);
            return paramcx;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
        paramcx = null;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
  
  public final IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */