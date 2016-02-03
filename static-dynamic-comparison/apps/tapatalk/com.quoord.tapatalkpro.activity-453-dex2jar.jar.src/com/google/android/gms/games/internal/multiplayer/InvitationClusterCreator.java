package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.games.multiplayer.InvitationEntity;

import java.util.ArrayList;

public class InvitationClusterCreator
        implements Parcelable.Creator<ZInvitationCluster> {
    static void a(ZInvitationCluster paramZInvitationCluster, Parcel paramParcel, int paramInt) {
        paramInt = b.p(paramParcel);
        b.b(paramParcel, 1, paramZInvitationCluster.ho(), false);
        b.c(paramParcel, 1000, paramZInvitationCluster.getVersionCode());
        b.F(paramParcel, paramInt);
    }

    public ZInvitationCluster as(Parcel paramParcel) {
        int j = a.o(paramParcel);
        int i = 0;
        ArrayList localArrayList = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.n(paramParcel);
            switch (a.R(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localArrayList = a.c(paramParcel, k, InvitationEntity.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new a.a("Overread allowed size end=" + j, paramParcel);
        }
        return new ZInvitationCluster(i, localArrayList);
    }

    public ZInvitationCluster[] bi(int paramInt) {
        return new ZInvitationCluster[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/games/internal/multiplayer/InvitationClusterCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */