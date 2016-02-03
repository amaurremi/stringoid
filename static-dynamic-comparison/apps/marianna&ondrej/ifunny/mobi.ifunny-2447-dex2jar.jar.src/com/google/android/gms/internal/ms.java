package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class ms
        implements SafeParcelable {
    public static final ri CREATOR = new ri();
    public static final ms a = a("test_type", 1);
    public static final ms b = a("trellis_store", 2);
    public static final ms c = a("labeled_place", 6);
    public static final Set<ms> d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new ms[]{a, b, c})));
    final int e;
    final String f;
    final int g;

    ms(int paramInt1, String paramString, int paramInt2) {
        ag.a(paramString);
        this.e = paramInt1;
        this.f = paramString;
        this.g = paramInt2;
    }

    private static ms a(String paramString, int paramInt) {
        return new ms(0, paramString, paramInt);
    }

    public int describeContents() {
        ri localri = CREATOR;
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof ms)) {
                return false;
            }
            paramObject = (ms) paramObject;
        } while ((this.f.equals(((ms) paramObject).f)) && (this.g == ((ms) paramObject).g));
        return false;
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public String toString() {
        return this.f;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ri localri = CREATOR;
        ri.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */