package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.GameEntity;

import java.util.ArrayList;

public class b
        implements Parcelable.Creator<QuestEntity> {
    static void a(QuestEntity paramQuestEntity, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramQuestEntity.j(), paramInt, false);
        c.a(paramParcel, 2, paramQuestEntity.B_(), false);
        c.a(paramParcel, 3, paramQuestEntity.m());
        c.a(paramParcel, 4, paramQuestEntity.e(), paramInt, false);
        c.a(paramParcel, 5, paramQuestEntity.f(), false);
        c.a(paramParcel, 6, paramQuestEntity.d(), false);
        c.a(paramParcel, 7, paramQuestEntity.n());
        c.a(paramParcel, 8, paramQuestEntity.o());
        c.a(paramParcel, 9, paramQuestEntity.g(), paramInt, false);
        c.a(paramParcel, 10, paramQuestEntity.h(), false);
        c.a(paramParcel, 12, paramQuestEntity.c(), false);
        c.a(paramParcel, 13, paramQuestEntity.p());
        c.a(paramParcel, 14, paramQuestEntity.q());
        c.a(paramParcel, 15, paramQuestEntity.k());
        c.c(paramParcel, 17, paramQuestEntity.i(), false);
        c.a(paramParcel, 16, paramQuestEntity.l());
        c.a(paramParcel, 1000, paramQuestEntity.r());
        c.a(paramParcel, i);
    }

    public QuestEntity a(Parcel paramParcel) {
        int m = a.b(paramParcel);
        int k = 0;
        GameEntity localGameEntity = null;
        String str5 = null;
        long l5 = 0L;
        Uri localUri2 = null;
        String str4 = null;
        String str3 = null;
        long l4 = 0L;
        long l3 = 0L;
        Uri localUri1 = null;
        String str2 = null;
        String str1 = null;
        long l2 = 0L;
        long l1 = 0L;
        int j = 0;
        int i = 0;
        ArrayList localArrayList = null;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    localGameEntity = (GameEntity) a.a(paramParcel, n, GameEntity.CREATOR);
                    break;
                case 2:
                    str5 = a.o(paramParcel, n);
                    break;
                case 3:
                    l5 = a.i(paramParcel, n);
                    break;
                case 4:
                    localUri2 = (Uri) a.a(paramParcel, n, Uri.CREATOR);
                    break;
                case 5:
                    str4 = a.o(paramParcel, n);
                    break;
                case 6:
                    str3 = a.o(paramParcel, n);
                    break;
                case 7:
                    l4 = a.i(paramParcel, n);
                    break;
                case 8:
                    l3 = a.i(paramParcel, n);
                    break;
                case 9:
                    localUri1 = (Uri) a.a(paramParcel, n, Uri.CREATOR);
                    break;
                case 10:
                    str2 = a.o(paramParcel, n);
                    break;
                case 12:
                    str1 = a.o(paramParcel, n);
                    break;
                case 13:
                    l2 = a.i(paramParcel, n);
                    break;
                case 14:
                    l1 = a.i(paramParcel, n);
                    break;
                case 15:
                    j = a.g(paramParcel, n);
                    break;
                case 17:
                    localArrayList = a.c(paramParcel, n, MilestoneEntity.CREATOR);
                    break;
                case 16:
                    i = a.g(paramParcel, n);
                    break;
                case 1000:
                    k = a.g(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + m, paramParcel);
        }
        return new QuestEntity(k, localGameEntity, str5, l5, localUri2, str4, str3, l4, l3, localUri1, str2, str1, l2, l1, j, i, localArrayList);
    }

    public QuestEntity[] a(int paramInt) {
        return new QuestEntity[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/quest/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */