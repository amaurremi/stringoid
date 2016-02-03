package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.a.a;

public final class ParticipantResult
        implements SafeParcelable {
    public static final e CREATOR = new e();
    private final int a;
    private final String b;
    private final int c;
    private final int d;

    public ParticipantResult(int paramInt1, String paramString, int paramInt2, int paramInt3) {
        this.a = paramInt1;
        this.b = ((String) ag.a(paramString));
        ag.a(a.a(paramInt2));
        this.c = paramInt2;
        this.d = paramInt3;
    }

    public ParticipantResult(String paramString, int paramInt1, int paramInt2) {
        this(1, paramString, paramInt1, paramInt2);
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        e.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */