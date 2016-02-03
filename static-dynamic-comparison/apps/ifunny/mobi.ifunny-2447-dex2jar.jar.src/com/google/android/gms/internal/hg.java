package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hg
        implements SafeParcelable {
    public static final oa CREATOR = new oa();
    final int a;
    final String b;
    final String c;
    final String d;

    hg(int paramInt, String paramString1, String paramString2, String paramString3) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramString3;
    }

    public int describeContents() {
        oa localoa = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[]{this.b, this.c, this.d});
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        oa localoa = CREATOR;
        oa.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/hg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */