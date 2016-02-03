package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class c
        implements SafeParcelable {
    public static final g CREATOR = new g();
    int a;
    int b;
    long c;
    private final int d;

    c(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
        this.d = paramInt1;
        this.a = paramInt2;
        this.b = paramInt3;
        this.c = paramLong;
    }

    private String a(int paramInt) {
        switch (paramInt) {
            case 1:
            default:
                return "STATUS_UNKNOWN";
            case 0:
                return "STATUS_SUCCESSFUL";
            case 2:
                return "STATUS_TIMED_OUT_ON_SCAN";
            case 3:
                return "STATUS_NO_INFO_IN_DATABASE";
            case 4:
                return "STATUS_INVALID_SCAN";
            case 5:
                return "STATUS_UNABLE_TO_QUERY_DATABASE";
            case 6:
                return "STATUS_SCANS_DISABLED_IN_SETTINGS";
            case 7:
                return "STATUS_LOCATION_DISABLED_IN_SETTINGS";
        }
        return "STATUS_IN_PROGRESS";
    }

    int a() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof c)) {
        }
        do {
            return false;
            paramObject = (c) paramObject;
        } while ((this.a != ((c) paramObject).a) || (this.b != ((c) paramObject).b) || (this.c != ((c) paramObject).c));
        return true;
    }

    public int hashCode() {
        return ad.a(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b), Long.valueOf(this.c)});
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LocationStatus[cell status: ").append(a(this.a));
        localStringBuilder.append(", wifi status: ").append(a(this.b));
        localStringBuilder.append(", elapsed realtime ns: ").append(this.c);
        localStringBuilder.append(']');
        return localStringBuilder.toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        g.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/location/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */