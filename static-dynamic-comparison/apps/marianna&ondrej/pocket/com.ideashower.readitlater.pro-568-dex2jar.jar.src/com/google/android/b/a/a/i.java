package com.google.android.b.a.a;

import android.os.IBinder;
import android.os.Parcel;

final class i
  implements g
{
  private IBinder a;
  
  i(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public final void a(String paramString, IBinder paramIBinder)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("com.google.android.youtube.player.internal.IConnectionCallbacks");
      localParcel1.writeString(paramString);
      localParcel1.writeStrongBinder(paramIBinder);
      this.a.transact(1, localParcel1, localParcel2, 0);
      localParcel2.readException();
      return;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */