package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;

import java.util.ArrayList;

public final class GameRequestCluster
        implements SafeParcelable, GameRequest {
    public static final a CREATOR = new a();
    private final int a;
    private final ArrayList<GameRequestEntity> b;

    GameRequestCluster(int paramInt, ArrayList<GameRequestEntity> paramArrayList) {
        this.a = paramInt;
        this.b = paramArrayList;
        o();
    }

    private void o() {
        GameRequest localGameRequest1;
        int i;
        label39:
        GameRequest localGameRequest2;
        if (!this.b.isEmpty()) {
            bool = true;
            b.a(bool);
            localGameRequest1 = (GameRequest) this.b.get(0);
            int j = this.b.size();
            i = 1;
            if (i >= j) {
                return;
            }
            localGameRequest2 = (GameRequest) this.b.get(i);
            if (localGameRequest1.i() != localGameRequest2.i()) {
                break label116;
            }
        }
        label116:
        for (boolean bool = true; ; bool = false) {
            b.a(bool, "All the requests must be of the same type");
            b.a(localGameRequest1.f().equals(localGameRequest2.f()), "All the requests must be from the same sender");
            i += 1;
            break label39;
            bool = false;
            break;
        }
    }

    public int a_(String paramString) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int b() {
        return this.a;
    }

    public ArrayList<GameRequest> c() {
        return new ArrayList(this.b);
    }

    public String d() {
        return ((GameRequestEntity) this.b.get(0)).d();
    }

    public int describeContents() {
        return 0;
    }

    public Game e() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof GameRequestCluster)) {
            return false;
        }
        if (this == paramObject) {
            return true;
        }
        paramObject = (GameRequestCluster) paramObject;
        if (((GameRequestCluster) paramObject).b.size() != this.b.size()) {
            return false;
        }
        int j = this.b.size();
        int i = 0;
        while (i < j) {
            if (!((GameRequest) this.b.get(i)).equals((GameRequest) ((GameRequestCluster) paramObject).b.get(i))) {
                return false;
            }
            i += 1;
        }
        return true;
    }

    public Player f() {
        return ((GameRequestEntity) this.b.get(0)).f();
    }

    public ArrayList<Player> g() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public byte[] h() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int hashCode() {
        return ad.a(this.b.toArray());
    }

    public int i() {
        return ((GameRequestEntity) this.b.get(0)).i();
    }

    public long j() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long k() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int l() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public GameRequest m() {
        return this;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/internal/request/GameRequestCluster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */