package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.r;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;

import java.util.List;

public class ListSubscriptionsResult
        implements r, SafeParcelable {
    public static final Parcelable.Creator<ListSubscriptionsResult> CREATOR = new e();
    private final int a;
    private final List<Subscription> b;
    private final Status c;

    ListSubscriptionsResult(int paramInt, List<Subscription> paramList, Status paramStatus) {
        this.a = paramInt;
        this.b = paramList;
        this.c = paramStatus;
    }

    private boolean a(ListSubscriptionsResult paramListSubscriptionsResult) {
        return (this.c.equals(paramListSubscriptionsResult.c)) && (ad.a(this.b, paramListSubscriptionsResult.b));
    }

    public Status a() {
        return this.c;
    }

    public List<Subscription> b() {
        return this.b;
    }

    int c() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        return (this == paramObject) || (((paramObject instanceof ListSubscriptionsResult)) && (a((ListSubscriptionsResult) paramObject)));
    }

    public int hashCode() {
        return ad.a(new Object[]{this.c, this.b});
    }

    public String toString() {
        return ad.a(this).a("status", this.c).a("dataSets", this.b).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        e.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/result/ListSubscriptionsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */