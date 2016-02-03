package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class mk
        implements SafeParcelable {
    public static final re CREATOR = new re();
    final int a;
    private final String b;
    private final String c;

    mk(int paramInt, String paramString1, String paramString2) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramString2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public int describeContents() {
        re localre = CREATOR;
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (!(paramObject instanceof mk)) {
        }
        do {
            return false;
            paramObject = (mk) paramObject;
        } while ((!ad.a(this.b, ((mk) paramObject).b)) || (!ad.a(this.c, ((mk) paramObject).c)));
        return true;
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b, this.c});
    }

    public String toString() {
        return ad.a(this).a("mPlaceId", this.b).a("mTag", this.c).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        re localre = CREATOR;
        re.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/mk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */