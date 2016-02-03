package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;

import java.util.ArrayList;

public final class RoomEntity
        extends GamesDowngradeableSafeParcel
        implements Room {
    public static final Parcelable.Creator<RoomEntity> CREATOR = new c();
    private final int a;
    private final String b;
    private final String c;
    private final long d;
    private final int e;
    private final String f;
    private final int g;
    private final Bundle h;
    private final ArrayList<ParticipantEntity> i;
    private final int j;

    RoomEntity(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, String paramString3, int paramInt3, Bundle paramBundle, ArrayList<ParticipantEntity> paramArrayList, int paramInt4) {
        this.a = paramInt1;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramLong;
        this.e = paramInt2;
        this.f = paramString3;
        this.g = paramInt3;
        this.h = paramBundle;
        this.i = paramArrayList;
        this.j = paramInt4;
    }

    public RoomEntity(Room paramRoom) {
        this.a = 2;
        this.b = paramRoom.w_();
        this.c = paramRoom.x_();
        this.d = paramRoom.y_();
        this.e = paramRoom.e();
        this.f = paramRoom.f();
        this.g = paramRoom.g();
        this.h = paramRoom.h();
        ArrayList localArrayList = paramRoom.l();
        int m = localArrayList.size();
        this.i = new ArrayList(m);
        int k = 0;
        while (k < m) {
            this.i.add((ParticipantEntity) ((Participant) localArrayList.get(k)).a());
            k += 1;
        }
        this.j = paramRoom.i();
    }

    static int a(Room paramRoom) {
        return ad.a(new Object[]{paramRoom.w_(), paramRoom.x_(), Long.valueOf(paramRoom.y_()), Integer.valueOf(paramRoom.e()), paramRoom.f(), Integer.valueOf(paramRoom.g()), paramRoom.h(), paramRoom.l(), Integer.valueOf(paramRoom.i())});
    }

    static boolean a(Room paramRoom, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof Room)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramRoom == paramObject);
            paramObject = (Room) paramObject;
            if ((!ad.a(((Room) paramObject).w_(), paramRoom.w_())) || (!ad.a(((Room) paramObject).x_(), paramRoom.x_())) || (!ad.a(Long.valueOf(((Room) paramObject).y_()), Long.valueOf(paramRoom.y_()))) || (!ad.a(Integer.valueOf(((Room) paramObject).e()), Integer.valueOf(paramRoom.e()))) || (!ad.a(((Room) paramObject).f(), paramRoom.f())) || (!ad.a(Integer.valueOf(((Room) paramObject).g()), Integer.valueOf(paramRoom.g()))) || (!ad.a(((Room) paramObject).h(), paramRoom.h())) || (!ad.a(((Room) paramObject).l(), paramRoom.l()))) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(Integer.valueOf(((Room) paramObject).i()), Integer.valueOf(paramRoom.i())));
        return false;
    }

    static String b(Room paramRoom) {
        return ad.a(paramRoom).a("RoomId", paramRoom.w_()).a("CreatorId", paramRoom.x_()).a("CreationTimestamp", Long.valueOf(paramRoom.y_())).a("RoomStatus", Integer.valueOf(paramRoom.e())).a("Description", paramRoom.f()).a("Variant", Integer.valueOf(paramRoom.g())).a("AutoMatchCriteria", paramRoom.h()).a("Participants", paramRoom.l()).a("AutoMatchWaitEstimateSeconds", Integer.valueOf(paramRoom.i())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.e;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public String f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public Bundle h() {
        return this.h;
    }

    public int hashCode() {
        return a(this);
    }

    public int i() {
        return this.j;
    }

    public int j() {
        return this.a;
    }

    public Room k() {
        return this;
    }

    public ArrayList<Participant> l() {
        return new ArrayList(this.i);
    }

    public String toString() {
        return b(this);
    }

    public String w_() {
        return this.b;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        if (!d()) {
            d.a(this, paramParcel, paramInt);
        }
        for (; ; ) {
            return;
            paramParcel.writeString(this.b);
            paramParcel.writeString(this.c);
            paramParcel.writeLong(this.d);
            paramParcel.writeInt(this.e);
            paramParcel.writeString(this.f);
            paramParcel.writeInt(this.g);
            paramParcel.writeBundle(this.h);
            int m = this.i.size();
            paramParcel.writeInt(m);
            int k = 0;
            while (k < m) {
                ((ParticipantEntity) this.i.get(k)).writeToParcel(paramParcel, paramInt);
                k += 1;
            }
        }
    }

    public String x_() {
        return this.c;
    }

    public long y_() {
        return this.d;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */