package com.google.android.b.a.a;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class ac
  extends Binder
  implements ab
{
  public IBinder asBinder()
  {
    return this;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    switch (paramInt1)
    {
    default: 
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902: 
      paramParcel2.writeString("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
      return true;
    case 1: 
      paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
      String str;
      if (paramParcel1.readInt() != 0)
      {
        localObject = (Bitmap)Bitmap.CREATOR.createFromParcel(paramParcel1);
        str = paramParcel1.readString();
        if (paramParcel1.readInt() == 0) {
          break label135;
        }
      }
      label135:
      for (bool1 = true;; bool1 = false)
      {
        if (paramParcel1.readInt() != 0) {
          bool2 = true;
        }
        a((Bitmap)localObject, str, bool1, bool2);
        paramParcel2.writeNoException();
        return true;
        localObject = null;
        break;
      }
    }
    paramParcel1.enforceInterface("com.google.android.youtube.player.internal.IThumbnailLoaderClient");
    Object localObject = paramParcel1.readString();
    if (paramParcel1.readInt() != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool3;
      if (paramParcel1.readInt() != 0) {
        bool2 = true;
      }
      a((String)localObject, bool1, bool2);
      paramParcel2.writeNoException();
      return true;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/b/a/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */