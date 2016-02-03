package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class GameEntityCreator
        implements Parcelable.Creator<GameEntity> {
    static void a(GameEntity paramGameEntity, Parcel paramParcel, int paramInt) {
        int i = b.p(paramParcel);
        b.a(paramParcel, 1, paramGameEntity.getApplicationId(), false);
        b.a(paramParcel, 2, paramGameEntity.getDisplayName(), false);
        b.a(paramParcel, 3, paramGameEntity.getPrimaryCategory(), false);
        b.a(paramParcel, 4, paramGameEntity.getSecondaryCategory(), false);
        b.a(paramParcel, 5, paramGameEntity.getDescription(), false);
        b.a(paramParcel, 6, paramGameEntity.getDeveloperName(), false);
        b.a(paramParcel, 7, paramGameEntity.getIconImageUri(), paramInt, false);
        b.a(paramParcel, 8, paramGameEntity.getHiResImageUri(), paramInt, false);
        b.a(paramParcel, 9, paramGameEntity.getFeaturedImageUri(), paramInt, false);
        b.a(paramParcel, 10, paramGameEntity.gb());
        b.a(paramParcel, 11, paramGameEntity.gd());
        b.a(paramParcel, 12, paramGameEntity.ge(), false);
        b.c(paramParcel, 13, paramGameEntity.gf());
        b.c(paramParcel, 14, paramGameEntity.getAchievementTotalCount());
        b.c(paramParcel, 15, paramGameEntity.getLeaderboardCount());
        b.a(paramParcel, 17, paramGameEntity.isTurnBasedMultiplayerEnabled());
        b.a(paramParcel, 16, paramGameEntity.isRealTimeMultiplayerEnabled());
        b.c(paramParcel, 1000, paramGameEntity.getVersionCode());
        b.a(paramParcel, 19, paramGameEntity.getHiResImageUrl(), false);
        b.a(paramParcel, 18, paramGameEntity.getIconImageUrl(), false);
        b.a(paramParcel, 21, paramGameEntity.isMuted());
        b.a(paramParcel, 20, paramGameEntity.getFeaturedImageUrl(), false);
        b.a(paramParcel, 22, paramGameEntity.gc());
        b.F(paramParcel, i);
    }

    public GameEntity[] aS(int paramInt) {
        return new GameEntity[paramInt];
    }

    public GameEntity an(Parcel paramParcel) {
        int n = a.o(paramParcel);
        int m = 0;
        String str10 = null;
        String str9 = null;
        String str8 = null;
        String str7 = null;
        String str6 = null;
        String str5 = null;
        Uri localUri3 = null;
        Uri localUri2 = null;
        Uri localUri1 = null;
        boolean bool6 = false;
        boolean bool5 = false;
        String str4 = null;
        int k = 0;
        int j = 0;
        int i = 0;
        boolean bool4 = false;
        boolean bool3 = false;
        String str3 = null;
        String str2 = null;
        String str1 = null;
        boolean bool2 = false;
        boolean bool1 = false;
        while (paramParcel.dataPosition() < n) {
            int i1 = a.n(paramParcel);
            switch (a.R(i1)) {
                default:
                    a.b(paramParcel, i1);
                    break;
                case 1:
                    str10 = a.n(paramParcel, i1);
                    break;
                case 2:
                    str9 = a.n(paramParcel, i1);
                    break;
                case 3:
                    str8 = a.n(paramParcel, i1);
                    break;
                case 4:
                    str7 = a.n(paramParcel, i1);
                    break;
                case 5:
                    str6 = a.n(paramParcel, i1);
                    break;
                case 6:
                    str5 = a.n(paramParcel, i1);
                    break;
                case 7:
                    localUri3 = (Uri) a.a(paramParcel, i1, Uri.CREATOR);
                    break;
                case 8:
                    localUri2 = (Uri) a.a(paramParcel, i1, Uri.CREATOR);
                    break;
                case 9:
                    localUri1 = (Uri) a.a(paramParcel, i1, Uri.CREATOR);
                    break;
                case 10:
                    bool6 = a.c(paramParcel, i1);
                    break;
                case 11:
                    bool5 = a.c(paramParcel, i1);
                    break;
                case 12:
                    str4 = a.n(paramParcel, i1);
                    break;
                case 13:
                    k = a.g(paramParcel, i1);
                    break;
                case 14:
                    j = a.g(paramParcel, i1);
                    break;
                case 15:
                    i = a.g(paramParcel, i1);
                    break;
                case 17:
                    bool3 = a.c(paramParcel, i1);
                    break;
                case 16:
                    bool4 = a.c(paramParcel, i1);
                    break;
                case 1000:
                    m = a.g(paramParcel, i1);
                    break;
                case 19:
                    str2 = a.n(paramParcel, i1);
                    break;
                case 18:
                    str3 = a.n(paramParcel, i1);
                    break;
                case 21:
                    bool2 = a.c(paramParcel, i1);
                    break;
                case 20:
                    str1 = a.n(paramParcel, i1);
                    break;
                case 22:
                    bool1 = a.c(paramParcel, i1);
            }
        }
        if (paramParcel.dataPosition() != n) {
            throw new a.a("Overread allowed size end=" + n, paramParcel);
        }
        return new GameEntity(m, str10, str9, str8, str7, str6, str5, localUri3, localUri2, localUri1, bool6, bool5, str4, k, j, i, bool4, bool3, str3, str2, str1, bool2, bool1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/GameEntityCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */