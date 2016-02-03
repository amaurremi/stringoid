package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.concurrent.TimeUnit;

public final class hk
        implements SafeParcelable {
    public static final hl CREATOR = new hl();
    static final long OF = TimeUnit.HOURS.toMillis(1L);
    private final hg OG;
    private final long Oc;
    private final int mPriority;
    final int xH;

    public hk(int paramInt1, hg paramhg, long paramLong, int paramInt2) {
        this.xH = paramInt1;
        this.OG = paramhg;
        this.Oc = paramLong;
        this.mPriority = paramInt2;
    }

    public int describeContents() {
        hl localhl = CREATOR;
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof hk)) {
                return false;
            }
            paramObject = (hk) paramObject;
        }
        while ((this.OG.equals(((hk) paramObject).OG)) && (this.Oc == ((hk) paramObject).Oc) && (this.mPriority == ((hk) paramObject).mPriority));
        return false;
    }

    public long getInterval() {
        return this.Oc;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public hg hZ() {
        return this.OG;
    }

    public int hashCode() {
        return fo.hashCode(new Object[]{this.OG, Long.valueOf(this.Oc), Integer.valueOf(this.mPriority)});
    }

    public String toString() {
        return fo.e(this).a("filter", this.OG).a("interval", Long.valueOf(this.Oc)).a("priority", Integer.valueOf(this.mPriority)).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        hl localhl = CREATOR;
        hl.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/hk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */