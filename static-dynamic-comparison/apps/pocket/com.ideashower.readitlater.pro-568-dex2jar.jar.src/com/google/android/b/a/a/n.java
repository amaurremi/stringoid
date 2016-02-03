package com.google.android.b.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class n
  extends Binder
  implements m
{
  public n()
  {
    attachInterface(this, "com.google.android.youtube.player.internal.IOnFullscreenListener");
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
      paramParcel2.writeString("com.google.android.youtube.player.internal.IOnFullscreenListener");
      return true;
    }
    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IOnFullscreenListener");
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */