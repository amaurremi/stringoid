package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MilestoneEntity
        implements SafeParcelable, Milestone {
    public static final a CREATOR = new a();
    private final int a;
    private final String b;
    private final long c;
    private final long d;
    private final byte[] e;
    private final int f;
    private final String g;

    MilestoneEntity(int paramInt1, String paramString1, long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt2, String paramString2) {
        this.a = paramInt1;
        this.b = paramString1;
        this.c = paramLong1;
        this.d = paramLong2;
        this.e = paramArrayOfByte;
        this.f = paramInt2;
        this.g = paramString2;
    }

    public MilestoneEntity(Milestone paramMilestone) {
        this.a = 4;
        this.b = paramMilestone.A_();
        this.c = paramMilestone.c();
        this.d = paramMilestone.f();
        this.f = paramMilestone.e();
        this.g = paramMilestone.d();
        paramMilestone = paramMilestone.g();
        if (paramMilestone == null) {
            this.e = null;
            return;
        }
        this.e = new byte[paramMilestone.length];
        System.arraycopy(paramMilestone, 0, this.e, 0, paramMilestone.length);
    }

    static int a(Milestone paramMilestone) {
        return ad.a(new Object[]{paramMilestone.A_(), Long.valueOf(paramMilestone.c()), Long.valueOf(paramMilestone.f()), Integer.valueOf(paramMilestone.e()), paramMilestone.d()});
    }

    static boolean a(Milestone paramMilestone, Object paramObject) {
        boolean bool2 = true;
        boolean bool1;
        if (!(paramObject instanceof Milestone)) {
            bool1 = false;
        }
        do {
            do {
                return bool1;
                bool1 = bool2;
            } while (paramMilestone == paramObject);
            paramObject = (Milestone) paramObject;
            if ((!ad.a(((Milestone) paramObject).A_(), paramMilestone.A_())) || (!ad.a(Long.valueOf(((Milestone) paramObject).c()), Long.valueOf(paramMilestone.c()))) || (!ad.a(Long.valueOf(((Milestone) paramObject).f()), Long.valueOf(paramMilestone.f()))) || (!ad.a(Integer.valueOf(((Milestone) paramObject).e()), Integer.valueOf(paramMilestone.e())))) {
                break;
            }
            bool1 = bool2;
        } while (ad.a(((Milestone) paramObject).d(), paramMilestone.d()));
        return false;
    }

    static String b(Milestone paramMilestone) {
        return ad.a(paramMilestone).a("MilestoneId", paramMilestone.A_()).a("CurrentProgress", Long.valueOf(paramMilestone.c())).a("TargetProgress", Long.valueOf(paramMilestone.f())).a("State", Integer.valueOf(paramMilestone.e())).a("CompletionRewardData", paramMilestone.g()).a("EventId", paramMilestone.d()).toString();
    }

    public String A_() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public String d() {
        return this.g;
    }

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f;
    }

    public boolean equals(Object paramObject) {
        return a(this, paramObject);
    }

    public long f() {
        return this.d;
    }

    public byte[] g() {
        return this.e;
    }

    public int h() {
        return this.a;
    }

    public int hashCode() {
        return a(this);
    }

    public Milestone i() {
        return this;
    }

    public String toString() {
        return b(this);
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/quest/MilestoneEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */