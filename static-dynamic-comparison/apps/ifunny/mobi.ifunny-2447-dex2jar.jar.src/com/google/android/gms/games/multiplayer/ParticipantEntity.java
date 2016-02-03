package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class ParticipantEntity
        extends GamesDowngradeableSafeParcel
        implements Participant {
    public static final Parcelable.Creator<ParticipantEntity> CREATOR = new c();
    private final int a;
    private final String b;
    private final String c;
    private final Uri d;
    private final Uri e;
    private final int f;
    private final String g;
    private final boolean h;
    private final PlayerEntity i;
    private final int j;
    private final ParticipantResult k;
    private final String l;
    private final String m;

    ParticipantEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, int paramInt2, String paramString3, boolean paramBoolean, PlayerEntity paramPlayerEntity, int paramInt3, ParticipantResult paramParticipantResult, String paramString4, String paramString5) {
        this.a = paramInt1;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramUri1;
        this.e = paramUri2;
        this.f = paramInt2;
        this.g = paramString3;
        this.h = paramBoolean;
        this.i = paramPlayerEntity;
        this.j = paramInt3;
        this.k = paramParticipantResult;
        this.l = paramString4;
        this.m = paramString5;
    }

    public ParticipantEntity(Participant paramParticipant) {
        this.a = 3;
        this.b = paramParticipant.k();
        this.c = paramParticipant.f();
        this.d = paramParticipant.g();
        this.e = paramParticipant.i();
        this.f = paramParticipant.t_();
        this.g = paramParticipant.u_();
        this.h = paramParticipant.e();
        Object localObject = paramParticipant.l();
        if (localObject == null) {
        }
        for (localObject = null; ; localObject = new PlayerEntity((Player) localObject)) {
            this.i = ((PlayerEntity) localObject);
            this.j = paramParticipant.v_();
            this.k = paramParticipant.m();
            this.l = paramParticipant.h();
            this.m = paramParticipant.j();
            return;
        }
    }

    static int a(Participant paramParticipant) {
        return ad.a(new Object[]{paramParticipant.l(), Integer.valueOf(paramParticipant.t_()), paramParticipant.u_(), Boolean.valueOf(paramParticipant.e()), paramParticipant.f(), paramParticipant.g(), paramParticipant.i(), Integer.valueOf(paramParticipant.v_()), paramParticipant.m(), paramParticipant.k()});
    }

    static boolean a(Participant paramParticipant, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof Participant)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramParticipant == paramObject);
            paramObject = (Participant) paramObject;
            if ((!ad.a(((Participant) paramObject).l(), paramParticipant.l())) || (!ad.a(Integer.valueOf(((Participant) paramObject).t_()), Integer.valueOf(paramParticipant.t_()))) || (!ad.a(((Participant) paramObject).u_(), paramParticipant.u_())) || (!ad.a(Boolean.valueOf(((Participant) paramObject).e()), Boolean.valueOf(paramParticipant.e()))) || (!ad.a(((Participant) paramObject).f(), paramParticipant.f())) || (!ad.a(((Participant) paramObject).g(), paramParticipant.g())) || (!ad.a(((Participant) paramObject).i(), paramParticipant.i())) || (!ad.a(Integer.valueOf(((Participant) paramObject).v_()), Integer.valueOf(paramParticipant.v_()))) || (!ad.a(((Participant) paramObject).m(), paramParticipant.m()))) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(((Participant) paramObject).k(), paramParticipant.k()));
        return false;
    }

    static String b(Participant paramParticipant) {
        return ad.a(paramParticipant).a("ParticipantId", paramParticipant.k()).a("Player", paramParticipant.l()).a("Status", Integer.valueOf(paramParticipant.t_())).a("ClientAddress", paramParticipant.u_()).a("ConnectedToRoom", Boolean.valueOf(paramParticipant.e())).a("DisplayName", paramParticipant.f()).a("IconImage", paramParticipant.g()).a("IconImageUrl", paramParticipant.h()).a("HiResImage", paramParticipant.i()).a("HiResImageUrl", paramParticipant.j()).a("Capabilities", Integer.valueOf(paramParticipant.v_())).a("Result", paramParticipant.m()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return this.h;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public String f() {
        if (this.i == null) {
            return this.c;
        }
        return this.i.h_();
    }

    public Uri g() {
        if (this.i == null) {
            return this.d;
        }
        return this.i.i_();
    }

    public String h() {
        if (this.i == null) {
            return this.l;
        }
        return this.i.e();
    }

    public int hashCode() {
        return a(this);
    }

    public Uri i() {
        if (this.i == null) {
            return this.e;
        }
        return this.i.f();
    }

    public String j() {
        if (this.i == null) {
            return this.m;
        }
        return this.i.g();
    }

    public String k() {
        return this.b;
    }

    public Player l() {
        return this.i;
    }

    public ParticipantResult m() {
        return this.k;
    }

    public int n() {
        return this.a;
    }

    public Participant o() {
        return this;
    }

    public int t_() {
        return this.f;
    }

    public String toString() {
        return b(this);
    }

    public String u_() {
        return this.g;
    }

    public int v_() {
        return this.j;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        Object localObject2 = null;
        int i1 = 0;
        if (!d()) {
            d.a(this, paramParcel, paramInt);
            return;
        }
        paramParcel.writeString(this.b);
        paramParcel.writeString(this.c);
        Object localObject1;
        if (this.d == null) {
            localObject1 = null;
            label46:
            paramParcel.writeString((String) localObject1);
            if (this.e != null) {
                break label143;
            }
            localObject1 = localObject2;
            label63:
            paramParcel.writeString((String) localObject1);
            paramParcel.writeInt(this.f);
            paramParcel.writeString(this.g);
            if (!this.h) {
                break label155;
            }
            n = 1;
            label94:
            paramParcel.writeInt(n);
            if (this.i != null) {
                break label160;
            }
        }
        label143:
        label155:
        label160:
        for (int n = i1; ; n = 1) {
            paramParcel.writeInt(n);
            if (this.i == null) {
                break;
            }
            this.i.writeToParcel(paramParcel, paramInt);
            return;
            localObject1 = this.d.toString();
            break label46;
            localObject1 = this.e.toString();
            break label63;
            n = 0;
            break label94;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */