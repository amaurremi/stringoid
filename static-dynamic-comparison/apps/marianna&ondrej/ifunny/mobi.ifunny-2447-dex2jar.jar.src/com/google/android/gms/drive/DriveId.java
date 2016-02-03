package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.aj;
import com.google.android.gms.drive.internal.e;
import com.google.android.gms.internal.ss;

public class DriveId
        implements SafeParcelable {
    public static final Parcelable.Creator<DriveId> CREATOR = new b();
    final int a;
    final String b;
    final long c;
    final long d;
    private volatile String e = null;

    DriveId(int paramInt, String paramString, long paramLong1, long paramLong2) {
        this.a = paramInt;
        this.b = paramString;
        if (!"".equals(paramString)) {
        }
        for (boolean bool1 = true; ; bool1 = false) {
            ag.b(bool1);
            if (paramString == null) {
                bool1 = bool2;
                if (paramLong1 == -1L) {
                }
            } else {
                bool1 = true;
            }
            ag.b(bool1);
            this.c = paramLong1;
            this.d = paramLong2;
            return;
        }
    }

    public final String a() {
        if (this.e == null) {
            String str = Base64.encodeToString(b(), 10);
            this.e = ("DriveId:" + str);
        }
        return this.e;
    }

    final byte[] b() {
        e locale = new e();
        locale.a = this.a;
        if (this.b == null) {
        }
        for (String str = ""; ; str = this.b) {
            locale.b = str;
            locale.c = this.c;
            locale.d = this.d;
            return ss.a(locale);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof DriveId)) {
        }
        do {
            return false;
            paramObject = (DriveId) paramObject;
            if (((DriveId) paramObject).d != this.d) {
                aj.a("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
                return false;
            }
            if ((((DriveId) paramObject).c == -1L) && (this.c == -1L)) {
                return ((DriveId) paramObject).b.equals(this.b);
            }
        } while (((DriveId) paramObject).c != this.c);
        return true;
    }

    public int hashCode() {
        if (this.c == -1L) {
            return this.b.hashCode();
        }
        return (String.valueOf(this.d) + String.valueOf(this.c)).hashCode();
    }

    public String toString() {
        return a();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        b.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/DriveId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */