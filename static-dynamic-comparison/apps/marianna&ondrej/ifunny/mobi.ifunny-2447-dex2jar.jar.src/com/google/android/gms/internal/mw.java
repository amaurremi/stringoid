package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class mw
        implements SafeParcelable {
    public static final rj CREATOR = new rj();
    public final int a;
    public final String b;
    public final String c;
    public final String d;

    public mw(int paramInt, String paramString1, String paramString2, String paramString3) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramString3;
    }

    public int describeContents() {
        rj localrj = CREATOR;
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if ((paramObject == null) || (!(paramObject instanceof mw))) {
                return false;
            }
            paramObject = (mw) paramObject;
        }
        while ((this.c.equals(((mw) paramObject).c)) && (this.b.equals(((mw) paramObject).b)) && (ad.a(this.d, ((mw) paramObject).d)));
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{this.b, this.c, this.d});
    }

    public String toString() {
        return ad.a(this).a("clientPackageName", this.b).a("locale", this.c).a("accountName", this.d).toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        rj localrj = CREATOR;
        rj.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/mw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */