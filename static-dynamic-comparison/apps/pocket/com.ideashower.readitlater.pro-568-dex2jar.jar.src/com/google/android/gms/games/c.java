package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;

final class c
  extends f
{
  public PlayerEntity a(Parcel paramParcel)
  {
    Uri localUri = null;
    if ((PlayerEntity.a(PlayerEntity.i())) || (PlayerEntity.a(PlayerEntity.class.getCanonicalName()))) {
      return super.a(paramParcel);
    }
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    Object localObject = paramParcel.readString();
    String str3 = paramParcel.readString();
    if (localObject == null)
    {
      localObject = null;
      if (str3 != null) {
        break label89;
      }
    }
    for (;;)
    {
      return new PlayerEntity(1, str1, str2, (Uri)localObject, localUri, paramParcel.readLong());
      localObject = Uri.parse((String)localObject);
      break;
      label89:
      localUri = Uri.parse(str3);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */