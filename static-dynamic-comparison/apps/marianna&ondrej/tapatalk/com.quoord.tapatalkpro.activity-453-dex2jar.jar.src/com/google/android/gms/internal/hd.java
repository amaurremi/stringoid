package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;

import java.util.Locale;

public class hd
        implements SafeParcelable, Geofence {
    public static final he CREATOR = new he();
    private final String Jo;
    private final int NU;
    private final short NW;
    private final double NX;
    private final double NY;
    private final float NZ;
    private final int Oa;
    private final int Ob;
    private final long Oz;
    private final int xH;

    public hd(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4) {
        aY(paramString);
        b(paramFloat);
        a(paramDouble1, paramDouble2);
        paramInt2 = bB(paramInt2);
        this.xH = paramInt1;
        this.NW = paramShort;
        this.Jo = paramString;
        this.NX = paramDouble1;
        this.NY = paramDouble2;
        this.NZ = paramFloat;
        this.Oz = paramLong;
        this.NU = paramInt2;
        this.Oa = paramInt3;
        this.Ob = paramInt4;
    }

    public hd(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3) {
        this(1, paramString, paramInt1, paramShort, paramDouble1, paramDouble2, paramFloat, paramLong, paramInt2, paramInt3);
    }

    private static void a(double paramDouble1, double paramDouble2) {
        if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D)) {
            throw new IllegalArgumentException("invalid latitude: " + paramDouble1);
        }
        if ((paramDouble2 > 180.0D) || (paramDouble2 < -180.0D)) {
            throw new IllegalArgumentException("invalid longitude: " + paramDouble2);
        }
    }

    private static void aY(String paramString) {
        if ((paramString == null) || (paramString.length() > 100)) {
            throw new IllegalArgumentException("requestId is null or too long: " + paramString);
        }
    }

    private static void b(float paramFloat) {
        if (paramFloat <= 0.0F) {
            throw new IllegalArgumentException("invalid radius: " + paramFloat);
        }
    }

    private static int bB(int paramInt) {
        int i = paramInt & 0x7;
        if (i == 0) {
            throw new IllegalArgumentException("No supported transition specified: " + paramInt);
        }
        return i;
    }

    private static String bC(int paramInt) {
        switch (paramInt) {
            default:
                return null;
        }
        return "CIRCLE";
    }

    public static hd h(byte[] paramArrayOfByte) {
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
        localParcel.setDataPosition(0);
        paramArrayOfByte = CREATOR.aC(localParcel);
        localParcel.recycle();
        return paramArrayOfByte;
    }

    public int describeContents() {
        he localhe = CREATOR;
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (paramObject == null) {
                return false;
            }
            if (!(paramObject instanceof hd)) {
                return false;
            }
            paramObject = (hd) paramObject;
            if (this.NZ != ((hd) paramObject).NZ) {
                return false;
            }
            if (this.NX != ((hd) paramObject).NX) {
                return false;
            }
            if (this.NY != ((hd) paramObject).NY) {
                return false;
            }
        } while (this.NW == ((hd) paramObject).NW);
        return false;
    }

    public long getExpirationTime() {
        return this.Oz;
    }

    public double getLatitude() {
        return this.NX;
    }

    public double getLongitude() {
        return this.NY;
    }

    public int getNotificationResponsiveness() {
        return this.Oa;
    }

    public String getRequestId() {
        return this.Jo;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public short hS() {
        return this.NW;
    }

    public float hT() {
        return this.NZ;
    }

    public int hU() {
        return this.NU;
    }

    public int hV() {
        return this.Ob;
    }

    public int hashCode() {
        long l = Double.doubleToLongBits(this.NX);
        int i = (int) (l ^ l >>> 32);
        l = Double.doubleToLongBits(this.NY);
        return ((((i + 31) * 31 + (int) (l ^ l >>> 32)) * 31 + Float.floatToIntBits(this.NZ)) * 31 + this.NW) * 31 + this.NU;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{bC(this.NW), this.Jo, Integer.valueOf(this.NU), Double.valueOf(this.NX), Double.valueOf(this.NY), Float.valueOf(this.NZ), Integer.valueOf(this.Oa / 1000), Integer.valueOf(this.Ob), Long.valueOf(this.Oz)});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        he localhe = CREATOR;
        he.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/hd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */