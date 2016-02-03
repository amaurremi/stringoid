package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;

import java.util.ArrayList;

public final class ZInvitationCluster
        implements SafeParcelable, Invitation {
    public static final a CREATOR = new a();
    private final int a;
    private final ArrayList<InvitationEntity> b;

    ZInvitationCluster(int paramInt, ArrayList<InvitationEntity> paramArrayList) {
        this.a = paramInt;
        this.b = paramArrayList;
        m();
    }

    private void m() {
        if (!this.b.isEmpty()) {
        }
        for (boolean bool = true; ; bool = false) {
            b.a(bool);
            Invitation localInvitation1 = (Invitation) this.b.get(0);
            int j = this.b.size();
            int i = 1;
            while (i < j) {
                Invitation localInvitation2 = (Invitation) this.b.get(i);
                b.a(localInvitation1.f().equals(localInvitation2.f()), "All the invitations must be from the same inviter");
                i += 1;
            }
        }
    }

    public int b() {
        return this.a;
    }

    public ArrayList<Invitation> c() {
        return new ArrayList(this.b);
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return ((InvitationEntity) this.b.get(0)).e();
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof ZInvitationCluster)) {
            return false;
        }
        if (this == paramObject) {
            return true;
        }
        paramObject = (ZInvitationCluster) paramObject;
        if (((ZInvitationCluster) paramObject).b.size() != this.b.size()) {
            return false;
        }
        int j = this.b.size();
        int i = 0;
        while (i < j) {
            if (!((Invitation) this.b.get(i)).equals((Invitation) ((ZInvitationCluster) paramObject).b.get(i))) {
                return false;
            }
            i += 1;
        }
        return true;
    }

    public Participant f() {
        return ((InvitationEntity) this.b.get(0)).f();
    }

    public long g() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int h() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int hashCode() {
        return ad.a(this.b.toArray());
    }

    public int i() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int j() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Invitation k() {
        return this;
    }

    public ArrayList<Participant> l() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game s_() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/multiplayer/ZInvitationCluster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */