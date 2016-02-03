package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hi
        implements SafeParcelable {
    public static final ob CREATOR = new ob();
    public static final int a = Integer.parseInt("-1");
    private static final hq g = new og("SsbContext").a(true).a("blob").a();
    final int b;
    public final String c;
    final hq d;
    public final int e;
    public final byte[] f;

    hi(int paramInt1, String paramString, hq paramhq, int paramInt2, byte[] paramArrayOfByte) {
        if ((paramInt2 == a) || (of.a(paramInt2) != null)) {
        }
        for (boolean bool = true; ; bool = false) {
            ag.b(bool, "Invalid section type " + paramInt2);
            this.b = paramInt1;
            this.c = paramString;
            this.d = paramhq;
            this.e = paramInt2;
            this.f = paramArrayOfByte;
            paramString = a();
            if (paramString == null) {
                break;
            }
            throw new IllegalArgumentException(paramString);
        }
    }

    public String a() {
        if ((this.e != a) && (of.a(this.e) == null)) {
            return "Invalid section type " + this.e;
        }
        if ((this.c != null) && (this.f != null)) {
            return "Both content and blobContent set";
        }
        return null;
    }

    public int describeContents() {
        ob localob = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ob localob = CREATOR;
        ob.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/hi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */