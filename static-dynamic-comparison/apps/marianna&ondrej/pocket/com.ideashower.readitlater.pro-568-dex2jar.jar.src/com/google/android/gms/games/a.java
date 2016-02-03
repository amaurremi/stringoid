package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;

final class a
  extends e
{
  public GameEntity a(Parcel paramParcel)
  {
    if ((GameEntity.a(GameEntity.s())) || (GameEntity.a(GameEntity.class.getCanonicalName()))) {
      return super.a(paramParcel);
    }
    String str1 = paramParcel.readString();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    String str4 = paramParcel.readString();
    String str5 = paramParcel.readString();
    String str6 = paramParcel.readString();
    Object localObject1 = paramParcel.readString();
    Object localObject2;
    label90:
    Object localObject3;
    label104:
    boolean bool1;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = paramParcel.readString();
      if (localObject2 != null) {
        break label177;
      }
      localObject2 = null;
      localObject3 = paramParcel.readString();
      if (localObject3 != null) {
        break label187;
      }
      localObject3 = null;
      if (paramParcel.readInt() <= 0) {
        break label197;
      }
      bool1 = true;
      label113:
      if (paramParcel.readInt() <= 0) {
        break label202;
      }
    }
    label177:
    label187:
    label197:
    label202:
    for (boolean bool2 = true;; bool2 = false)
    {
      return new GameEntity(1, str1, str2, str3, str4, str5, str6, (Uri)localObject1, (Uri)localObject2, (Uri)localObject3, bool1, bool2, paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt());
      localObject1 = Uri.parse((String)localObject1);
      break;
      localObject2 = Uri.parse((String)localObject2);
      break label90;
      localObject3 = Uri.parse((String)localObject3);
      break label104;
      bool1 = false;
      break label113;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/games/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */