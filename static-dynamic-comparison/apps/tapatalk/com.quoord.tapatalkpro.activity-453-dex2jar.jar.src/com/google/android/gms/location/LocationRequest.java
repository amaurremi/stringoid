package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;

public final class LocationRequest
        implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    long NV;
    long Oc;
    long Od;
    boolean Oe;
    int Of;
    float Og;
    int mPriority;
    private final int xH;

    public LocationRequest() {
        this.xH = 1;
        this.mPriority = 102;
        this.Oc = 3600000L;
        this.Od = 600000L;
        this.Oe = false;
        this.NV = Long.MAX_VALUE;
        this.Of = Integer.MAX_VALUE;
        this.Og = 0.0F;
    }

    LocationRequest(int paramInt1, int paramInt2, long paramLong1, long paramLong2, boolean paramBoolean, long paramLong3, int paramInt3, float paramFloat) {
        this.xH = paramInt1;
        this.mPriority = paramInt2;
        this.Oc = paramLong1;
        this.Od = paramLong2;
        this.Oe = paramBoolean;
        this.NV = paramLong3;
        this.Of = paramInt3;
        this.Og = paramFloat;
    }

    private static void a(float paramFloat) {
        if (paramFloat < 0.0F) {
            throw new IllegalArgumentException("invalid displacement: " + paramFloat);
        }
    }

    private static void bw(int paramInt) {
        switch (paramInt) {
            case 101:
            case 103:
            default:
                throw new IllegalArgumentException("invalid quality: " + paramInt);
        }
    }

    public static String bx(int paramInt) {
        switch (paramInt) {
            case 101:
            case 103:
            default:
                return "???";
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case 104:
                return "PRIORITY_LOW_POWER";
        }
        return "PRIORITY_NO_POWER";
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void s(long paramLong) {
        if (paramLong < 0L) {
            throw new IllegalArgumentException("invalid interval: " + paramLong);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof LocationRequest)) {
                return false;
            }
            paramObject = (LocationRequest) paramObject;
        }
        while ((this.mPriority == ((LocationRequest) paramObject).mPriority) && (this.Oc == ((LocationRequest) paramObject).Oc) && (this.Od == ((LocationRequest) paramObject).Od) && (this.Oe == ((LocationRequest) paramObject).Oe) && (this.NV == ((LocationRequest) paramObject).NV) && (this.Of == ((LocationRequest) paramObject).Of) && (this.Og == ((LocationRequest) paramObject).Og));
        return false;
    }

    public long getExpirationTime() {
        return this.NV;
    }

    public long getFastestInterval() {
        return this.Od;
    }

    public long getInterval() {
        return this.Oc;
    }

    public int getNumUpdates() {
        return this.Of;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.Og;
    }

    int getVersionCode() {
        return this.xH;
    }

    public int hashCode() {
        return fo.hashCode(new Object[]{Integer.valueOf(this.mPriority), Long.valueOf(this.Oc), Long.valueOf(this.Od), Boolean.valueOf(this.Oe), Long.valueOf(this.NV), Integer.valueOf(this.Of), Float.valueOf(this.Og)});
    }

    public LocationRequest setExpirationDuration(long paramLong) {
        long l = SystemClock.elapsedRealtime();
        if (paramLong > Long.MAX_VALUE - l) {
        }
        for (this.NV = Long.MAX_VALUE; ; this.NV = (l + paramLong)) {
            if (this.NV < 0L) {
                this.NV = 0L;
            }
            return this;
        }
    }

    public LocationRequest setExpirationTime(long paramLong) {
        this.NV = paramLong;
        if (this.NV < 0L) {
            this.NV = 0L;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long paramLong) {
        s(paramLong);
        this.Oe = true;
        this.Od = paramLong;
        return this;
    }

    public LocationRequest setInterval(long paramLong) {
        s(paramLong);
        this.Oc = paramLong;
        if (!this.Oe) {
            this.Od = ((this.Oc / 6.0D));
        }
        return this;
    }

    public LocationRequest setNumUpdates(int paramInt) {
        if (paramInt <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + paramInt);
        }
        this.Of = paramInt;
        return this;
    }

    public LocationRequest setPriority(int paramInt) {
        bw(paramInt);
        this.mPriority = paramInt;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float paramFloat) {
        a(paramFloat);
        this.Og = paramFloat;
        return this;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Request[").append(bx(this.mPriority));
        if (this.mPriority != 105) {
            localStringBuilder.append(" requested=");
            localStringBuilder.append(this.Oc + "ms");
        }
        localStringBuilder.append(" fastest=");
        localStringBuilder.append(this.Od + "ms");
        if (this.NV != Long.MAX_VALUE) {
            long l1 = this.NV;
            long l2 = SystemClock.elapsedRealtime();
            localStringBuilder.append(" expireIn=");
            localStringBuilder.append(l1 - l2 + "ms");
        }
        if (this.Of != Integer.MAX_VALUE) {
            localStringBuilder.append(" num=").append(this.Of);
        }
        localStringBuilder.append(']');
        return localStringBuilder.toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        LocationRequestCreator.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/location/LocationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */