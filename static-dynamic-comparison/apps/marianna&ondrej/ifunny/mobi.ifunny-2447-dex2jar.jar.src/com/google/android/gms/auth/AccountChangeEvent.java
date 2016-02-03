package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEvent
        implements SafeParcelable {
    public static final a CREATOR = new a();
    final int a;
    final long b;
    final String c;
    final int d;
    final int e;
    final String f;

    AccountChangeEvent(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, String paramString2) {
        this.a = paramInt1;
        this.b = paramLong;
        this.c = ((String) ag.a(paramString1));
        this.d = paramInt2;
        this.e = paramInt3;
        this.f = paramString2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof AccountChangeEvent)) {
                break;
            }
            paramObject = (AccountChangeEvent) paramObject;
        }
        while ((this.a == ((AccountChangeEvent) paramObject).a) && (this.b == ((AccountChangeEvent) paramObject).b) && (ad.a(this.c, ((AccountChangeEvent) paramObject).c)) && (this.d == ((AccountChangeEvent) paramObject).d) && (this.e == ((AccountChangeEvent) paramObject).e) && (ad.a(this.f, ((AccountChangeEvent) paramObject).f)));
        return false;
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{Integer.valueOf(this.a), Long.valueOf(this.b), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e), this.f});
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.d) {
        }
        for (; ; ) {
            return "AccountChangeEvent {accountName = " + this.c + ", changeType = " + str + ", changeData = " + this.f + ", eventIndex = " + this.e + "}";
            str = "ADDED";
            continue;
            str = "REMOVED";
            continue;
            str = "RENAMED_TO";
            continue;
            str = "RENAMED_FROM";
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        a.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/auth/AccountChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */