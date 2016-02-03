package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

class pn
  implements ke
{
  private IBinder a;
  
  pn(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public void a(kd paramkd, Uri paramUri, Bundle paramBundle, boolean paramBoolean)
  {
    IBinder localIBinder = null;
    int i = 1;
    Parcel localParcel = Parcel.obtain();
    for (;;)
    {
      try
      {
        localParcel.writeInterfaceToken("com.google.android.gms.panorama.internal.IPanoramaService");
        if (paramkd != null) {
          localIBinder = paramkd.asBinder();
        }
        localParcel.writeStrongBinder(localIBinder);
        if (paramUri != null)
        {
          localParcel.writeInt(1);
          paramUri.writeToParcel(localParcel, 0);
          if (paramBundle != null)
          {
            localParcel.writeInt(1);
            paramBundle.writeToParcel(localParcel, 0);
            break label134;
            localParcel.writeInt(i);
            this.a.transact(1, localParcel, null, 1);
          }
        }
        else
        {
          localParcel.writeInt(0);
          continue;
        }
        localParcel.writeInt(0);
      }
      finally
      {
        localParcel.recycle();
      }
      label134:
      while (!paramBoolean)
      {
        i = 0;
        break;
      }
    }
  }
  
  public IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/pn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */