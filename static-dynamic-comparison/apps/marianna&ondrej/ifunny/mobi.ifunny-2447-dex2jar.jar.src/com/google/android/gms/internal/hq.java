package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class hq
        implements SafeParcelable {
    public static final oh CREATOR = new oh();
    final int a;
    public final String b;
    public final String c;
    public final boolean d;
    public final int e;
    public final boolean f;
    public final String g;
    public final hk[] h;
    final int[] i;
    public final String j;

    hq(int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString3, hk[] paramArrayOfhk, int[] paramArrayOfInt, String paramString4) {
        this.a = paramInt1;
        this.b = paramString1;
        this.c = paramString2;
        this.d = paramBoolean1;
        this.e = paramInt2;
        this.f = paramBoolean2;
        this.g = paramString3;
        this.h = paramArrayOfhk;
        this.i = paramArrayOfInt;
        this.j = paramString4;
    }

    hq(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, boolean paramBoolean2, String paramString3, hk[] paramArrayOfhk, int[] paramArrayOfInt, String paramString4) {
        this(2, paramString1, paramString2, paramBoolean1, paramInt, paramBoolean2, paramString3, paramArrayOfhk, paramArrayOfInt, paramString4);
    }

    public int describeContents() {
        oh localoh = CREATOR;
        return 0;
    }

    public boolean equals(Object paramObject) {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if ((paramObject instanceof hq)) {
            paramObject = (hq) paramObject;
            bool1 = bool2;
            if (this.b.equals(((hq) paramObject).b)) {
                bool1 = bool2;
                if (this.c.equals(((hq) paramObject).c)) {
                    bool1 = bool2;
                    if (this.d == ((hq) paramObject).d) {
                        bool1 = true;
                    }
                }
            }
        }
        return bool1;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        oh localoh = CREATOR;
        oh.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/hq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */