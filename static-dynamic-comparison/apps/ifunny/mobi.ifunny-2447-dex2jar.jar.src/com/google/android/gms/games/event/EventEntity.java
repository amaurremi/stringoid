package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

public final class EventEntity
        implements SafeParcelable, Event {
    public static final a CREATOR = new a();
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final Uri e;
    private final String f;
    private final PlayerEntity g;
    private final long h;
    private final String i;
    private final boolean j;

    EventEntity(int paramInt, String paramString1, String paramString2, String paramString3, Uri paramUri, String paramString4, Player paramPlayer, long paramLong, String paramString5, boolean paramBoolean) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramString3;
        this.e = paramUri;
        this.f = paramString4;
        this.g = new PlayerEntity(paramPlayer);
        this.h = paramLong;
        this.i = paramString5;
        this.j = paramBoolean;
    }

    public EventEntity(Event paramEvent) {
        this.a = 1;
        this.b = paramEvent.k_();
        this.c = paramEvent.c();
        this.d = paramEvent.d();
        this.e = paramEvent.e();
        this.f = paramEvent.f();
        this.g = ((PlayerEntity) paramEvent.g().a());
        this.h = paramEvent.h();
        this.i = paramEvent.i();
        this.j = paramEvent.j();
    }

    static int a(Event paramEvent) {
        return ad.a(new Object[]{paramEvent.k_(), paramEvent.c(), paramEvent.d(), paramEvent.e(), paramEvent.f(), paramEvent.g(), Long.valueOf(paramEvent.h()), paramEvent.i(), Boolean.valueOf(paramEvent.j())});
    }

    static boolean a(Event paramEvent, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof Event)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramEvent == paramObject);
            paramObject = (Event) paramObject;
            if ((!ad.a(((Event) paramObject).k_(), paramEvent.k_())) || (!ad.a(((Event) paramObject).c(), paramEvent.c())) || (!ad.a(((Event) paramObject).d(), paramEvent.d())) || (!ad.a(((Event) paramObject).e(), paramEvent.e())) || (!ad.a(((Event) paramObject).f(), paramEvent.f())) || (!ad.a(((Event) paramObject).g(), paramEvent.g())) || (!ad.a(Long.valueOf(((Event) paramObject).h()), Long.valueOf(paramEvent.h()))) || (!ad.a(((Event) paramObject).i(), paramEvent.i()))) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(Boolean.valueOf(((Event) paramObject).j()), Boolean.valueOf(paramEvent.j())));
        return false;
    }

    static String b(Event paramEvent) {
        return ad.a(paramEvent).a("Id", paramEvent.k_()).a("Name", paramEvent.c()).a("Description", paramEvent.d()).a("IconImageUri", paramEvent.e()).a("IconImageUrl", paramEvent.f()).a("Player", paramEvent.g()).a("Value", Long.valueOf(paramEvent.h())).a("FormattedValue", paramEvent.i()).a("isVisible", Boolean.valueOf(paramEvent.j())).toString();
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public Uri e() {
        return this.e;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public String f() {
        return this.f;
    }

    public Player g() {
        return this.g;
    }

    public long h() {
        return this.h;
    }

    public int hashCode() {
        return a(this);
    }

    public String i() {
        return this.i;
    }

    public boolean j() {
        return this.j;
    }

    public int k() {
        return this.a;
    }

    public String k_() {
        return this.b;
    }

    public Event l() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/event/EventEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */