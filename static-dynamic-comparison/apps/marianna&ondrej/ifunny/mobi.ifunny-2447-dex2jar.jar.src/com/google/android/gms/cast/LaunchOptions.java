package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.op;

import java.util.Locale;

public class LaunchOptions
        implements SafeParcelable {
    public static final Parcelable.Creator<LaunchOptions> CREATOR = new c();
    private final int a;
    private boolean b;
    private String c;

    public LaunchOptions() {
        this(1, false, op.a(Locale.getDefault()));
    }

    LaunchOptions(int paramInt, boolean paramBoolean, String paramString) {
        this.a = paramInt;
        this.b = paramBoolean;
        this.c = paramString;
    }

    int a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            return true;
            if (!(paramObject instanceof LaunchOptions)) {
                return false;
            }
            paramObject = (LaunchOptions) paramObject;
        } while ((this.b == ((LaunchOptions) paramObject).b) && (op.a(this.c, ((LaunchOptions) paramObject).c)));
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{Boolean.valueOf(this.b), this.c});
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", new Object[]{Boolean.valueOf(this.b), this.c});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        c.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/cast/LaunchOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */