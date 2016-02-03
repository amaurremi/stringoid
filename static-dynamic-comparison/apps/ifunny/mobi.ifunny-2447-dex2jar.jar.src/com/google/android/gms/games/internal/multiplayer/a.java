package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.games.multiplayer.InvitationEntity;

import java.util.ArrayList;

public class a
        implements Parcelable.Creator<ZInvitationCluster> {
    static void a(ZInvitationCluster paramZInvitationCluster, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.c(paramParcel, 1, paramZInvitationCluster.c(), false);
        c.a(paramParcel, 1000, paramZInvitationCluster.b());
        c.a(paramParcel, paramInt);
    }

    public ZInvitationCluster a(Parcel paramParcel) {
        int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int i = 0;
        ArrayList localArrayList = null;
        while (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
                    break;
                case 1:
                    localArrayList = com.google.android.gms.common.internal.safeparcel.a.c(paramParcel, k, InvitationEntity.CREATOR);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new ZInvitationCluster(i, localArrayList);
    }

    public ZInvitationCluster[] a(int paramInt) {
        return new ZInvitationCluster[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/multiplayer/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */