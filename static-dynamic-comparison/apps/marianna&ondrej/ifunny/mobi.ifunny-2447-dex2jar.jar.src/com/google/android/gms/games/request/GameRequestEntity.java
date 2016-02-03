package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity
        implements SafeParcelable, GameRequest {
    public static final a CREATOR = new a();
    private final int a;
    private final GameEntity b;
    private final PlayerEntity c;
    private final byte[] d;
    private final String e;
    private final ArrayList<PlayerEntity> f;
    private final int g;
    private final long h;
    private final long i;
    private final Bundle j;
    private final int k;

    GameRequestEntity(int paramInt1, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, byte[] paramArrayOfByte, String paramString, ArrayList<PlayerEntity> paramArrayList, int paramInt2, long paramLong1, long paramLong2, Bundle paramBundle, int paramInt3) {
        this.a = paramInt1;
        this.b = paramGameEntity;
        this.c = paramPlayerEntity;
        this.d = paramArrayOfByte;
        this.e = paramString;
        this.f = paramArrayList;
        this.g = paramInt2;
        this.h = paramLong1;
        this.i = paramLong2;
        this.j = paramBundle;
        this.k = paramInt3;
    }

    public GameRequestEntity(GameRequest paramGameRequest) {
        this.a = 2;
        this.b = new GameEntity(paramGameRequest.e());
        this.c = new PlayerEntity(paramGameRequest.f());
        this.e = paramGameRequest.d();
        this.g = paramGameRequest.i();
        this.h = paramGameRequest.j();
        this.i = paramGameRequest.k();
        this.k = paramGameRequest.l();
        Object localObject = paramGameRequest.h();
        if (localObject == null) {
            this.d = null;
        }
        for (; ; ) {
            localObject = paramGameRequest.n();
            int n = ((List) localObject).size();
            this.f = new ArrayList(n);
            this.j = new Bundle();
            int m = 0;
            while (m < n) {
                Player localPlayer = (Player) ((Player) ((List) localObject).get(m)).a();
                String str = localPlayer.g_();
                this.f.add((PlayerEntity) localPlayer);
                this.j.putInt(str, paramGameRequest.a_(str));
                m += 1;
            }
            this.d = new byte[localObject.length];
            System.arraycopy(localObject, 0, this.d, 0, localObject.length);
        }
    }

    static int a(GameRequest paramGameRequest) {
        return ad.a(new Object[]{paramGameRequest.e(), paramGameRequest.n(), paramGameRequest.d(), paramGameRequest.f(), c(paramGameRequest), Integer.valueOf(paramGameRequest.i()), Long.valueOf(paramGameRequest.j()), Long.valueOf(paramGameRequest.k())});
    }

    static boolean a(GameRequest paramGameRequest, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof GameRequest)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramGameRequest == paramObject);
            paramObject = (GameRequest) paramObject;
            if ((!ad.a(((GameRequest) paramObject).e(), paramGameRequest.e())) || (!ad.a(((GameRequest) paramObject).n(), paramGameRequest.n())) || (!ad.a(((GameRequest) paramObject).d(), paramGameRequest.d())) || (!ad.a(((GameRequest) paramObject).f(), paramGameRequest.f())) || (!Arrays.equals(c((GameRequest) paramObject), c(paramGameRequest))) || (!ad.a(Integer.valueOf(((GameRequest) paramObject).i()), Integer.valueOf(paramGameRequest.i()))) || (!ad.a(Long.valueOf(((GameRequest) paramObject).j()), Long.valueOf(paramGameRequest.j())))) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(Long.valueOf(((GameRequest) paramObject).k()), Long.valueOf(paramGameRequest.k())));
        return false;
    }

    static String b(GameRequest paramGameRequest) {
        return ad.a(paramGameRequest).a("Game", paramGameRequest.e()).a("Sender", paramGameRequest.f()).a("Recipients", paramGameRequest.n()).a("Data", paramGameRequest.h()).a("RequestId", paramGameRequest.d()).a("Type", Integer.valueOf(paramGameRequest.i())).a("CreationTimestamp", Long.valueOf(paramGameRequest.j())).a("ExpirationTimestamp", Long.valueOf(paramGameRequest.k())).toString();
    }

    private static int[] c(GameRequest paramGameRequest) {
        List localList = paramGameRequest.n();
        int n = localList.size();
        int[] arrayOfInt = new int[n];
        int m = 0;
        while (m < n) {
            arrayOfInt[m] = paramGameRequest.a_(((Player) localList.get(m)).g_());
            m += 1;
        }
        return arrayOfInt;
    }

    public int a_(String paramString) {
        return this.j.getInt(paramString, 0);
    }

    public int b() {
        return this.a;
    }

    public Bundle c() {
        return this.j;
    }

    public String d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public Game e() {
        return this.b;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public Player f() {
        return this.c;
    }

    public GameRequest g() {
        return this;
    }

    public byte[] h() {
        return this.d;
    }

    public int hashCode() {
        return a(this);
    }

    public int i() {
        return this.g;
    }

    public long j() {
        return this.h;
    }

    public long k() {
        return this.i;
    }

    public int l() {
        return this.k;
    }

    public List<Player> n() {
        return new ArrayList(this.f);
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/request/GameRequestEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */