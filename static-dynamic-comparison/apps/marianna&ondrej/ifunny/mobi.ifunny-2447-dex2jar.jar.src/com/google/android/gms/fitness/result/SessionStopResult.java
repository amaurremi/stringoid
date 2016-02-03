package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;

import java.util.Collections;
import java.util.List;

public class SessionStopResult
        implements r, SafeParcelable {
    public static final Parcelable.Creator<SessionStopResult> CREATOR = new g();
    private final int a;
    private final Status b;
    private final List<Session> c;

    SessionStopResult(int paramInt, Status paramStatus, List<Session> paramList) {
        this.a = paramInt;
        this.b = paramStatus;
        this.c = Collections.unmodifiableList(paramList);
    }

    private boolean a(SessionStopResult paramSessionStopResult) {
        return (this.b.equals(paramSessionStopResult.b)) && (ad.a(this.c, paramSessionStopResult.c));
    }

    public Status a() {
        return this.b;
    }

    public List<Session> b() {
        return this.c;
    }

    int c() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof SessionStopResult)) && (a((SessionStopResult) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b, this.c});
    }

    public String toString() {
        return ad.a(this).a("status", this.b).a("sessions", this.c).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        g.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/result/SessionStopResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */