package com.google.android.b.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class az
  extends Binder
  implements ay
{
  public az()
  {
    attachInterface(this, "com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
  }
  
  public static ay a(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
    if ((localIInterface != null) && ((localIInterface instanceof ay))) {
      return (ay)localIInterface;
    }
    return new ba(paramIBinder);
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
    }
    paramParcel2.writeString("com.google.android.youtube.player.internal.dynamic.IObjectWrapper");
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */