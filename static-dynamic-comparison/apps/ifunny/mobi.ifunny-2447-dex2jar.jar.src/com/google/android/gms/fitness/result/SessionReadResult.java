package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.q;

import java.util.Collections;
import java.util.List;

public class SessionReadResult
        implements r, SafeParcelable {
    public static final Parcelable.Creator<SessionReadResult> CREATOR = new f();
    private final int a;
    private final List<Session> b;
    private final List<q> c;
    private final Status d;

    SessionReadResult(int paramInt, List<Session> paramList, List<q> paramList1, Status paramStatus) {
        this.a = paramInt;
        this.b = paramList;
        this.c = Collections.unmodifiableList(paramList1);
        this.d = paramStatus;
    }

    private boolean a(SessionReadResult paramSessionReadResult) {
        return (this.d.equals(paramSessionReadResult.d)) && (ad.a(this.b, paramSessionReadResult.b)) && (ad.a(this.c, paramSessionReadResult.c));
    }

    public Status a() {
        return this.d;
    }

    public List<Session> b() {
        return this.b;
    }

    public List<q> c() {
        return this.c;
    }

    int d() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof SessionReadResult)) && (a((SessionReadResult) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.d, this.b, this.c});
    }

    public String toString() {
        return ad.a(this).a("status", this.d).a("sessions", this.b).a("sessionDataSets", this.c).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        f.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/result/SessionReadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */