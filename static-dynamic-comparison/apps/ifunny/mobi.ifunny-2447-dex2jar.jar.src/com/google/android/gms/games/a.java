package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;

final class a
        extends b {
    public GameEntity a(Parcel paramParcel) {
        if ((GameEntity.a(GameEntity.B())) || (GameEntity.b(GameEntity.class.getCanonicalName()))) {
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
        if (localObject1 == null) {
            localObject1 = null;
            localObject2 = paramParcel.readString();
            if (localObject2 != null) {
                break label186;
            }
            localObject2 = null;
            localObject3 = paramParcel.readString();
            if (localObject3 != null) {
                break label196;
            }
            localObject3 = null;
            if (paramParcel.readInt() <= 0) {
                break label206;
            }
            bool1 = true;
            label113:
            if (paramParcel.readInt() <= 0) {
                break label211;
            }
        }
        label186:
        label196:
        label206:
        label211:
        for (boolean bool2 = true; ; bool2 = false) {
            return new GameEntity(5, str1, str2, str3, str4, str5, str6, (Uri) localObject1, (Uri) localObject2, (Uri) localObject3, bool1, bool2, paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), false, false, null, null, null, false, false, false, null);
            localObject1 = Uri.parse((String) localObject1);
            break;
            localObject2 = Uri.parse((String) localObject2);
            break label90;
            localObject3 = Uri.parse((String) localObject3);
            break label104;
            bool1 = false;
            break label113;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */