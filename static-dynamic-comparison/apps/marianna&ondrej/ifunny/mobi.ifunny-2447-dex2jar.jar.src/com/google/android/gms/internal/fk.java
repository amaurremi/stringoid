package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.Collections;
import java.util.List;

@ii
public final class fk
        implements SafeParcelable {
    public static final ke CREATOR = new ke();
    public final int a;
    public final String b;
    public final String c;
    public final List<String> d;
    public final int e;
    public final List<String> f;
    public final long g;
    public final boolean h;
    public final long i;
    public final List<String> j;
    public final long k;
    public final int l;
    public final String m;
    public final long n;
    public final String o;
    public final boolean p;
    public final String q;
    public final String r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public final boolean v;

    public fk(int paramInt) {
        this(10, null, null, null, paramInt, null, -1L, false, -1L, null, -1L, -1, null, -1L, null, false, null, null, false, false, false, false);
    }

    public fk(int paramInt, long paramLong) {
        this(10, null, null, null, paramInt, null, -1L, false, -1L, null, paramLong, -1, null, -1L, null, false, null, null, false, false, false, false);
    }

    fk(int paramInt1, String paramString1, String paramString2, List<String> paramList1, int paramInt2, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt3, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
        this.a = paramInt1;
        this.b = paramString1;
        this.c = paramString2;
        if (paramList1 != null) {
            paramString1 = Collections.unmodifiableList(paramList1);
            this.d = paramString1;
            this.e = paramInt2;
            if (paramList2 == null) {
                break label169;
            }
            paramString1 = Collections.unmodifiableList(paramList2);
            label52:
            this.f = paramString1;
            this.g = paramLong1;
            this.h = paramBoolean1;
            this.i = paramLong2;
            if (paramList3 == null) {
                break label174;
            }
        }
        label169:
        label174:
        for (paramString1 = Collections.unmodifiableList(paramList3); ; paramString1 = null) {
            this.j = paramString1;
            this.k = paramLong3;
            this.l = paramInt3;
            this.m = paramString3;
            this.n = paramLong4;
            this.o = paramString4;
            this.p = paramBoolean2;
            this.q = paramString5;
            this.r = paramString6;
            this.s = paramBoolean3;
            this.t = paramBoolean4;
            this.u = paramBoolean5;
            this.v = paramBoolean6;
            return;
            paramString1 = null;
            break;
            paramString1 = null;
            break label52;
        }
    }

    public fk(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, String paramString5, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) {
        this(10, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, false, null, paramString5, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
    }

    public fk(String paramString1, String paramString2, List<String> paramList1, List<String> paramList2, long paramLong1, boolean paramBoolean1, long paramLong2, List<String> paramList3, long paramLong3, int paramInt, String paramString3, long paramLong4, String paramString4, boolean paramBoolean2, String paramString5, String paramString6, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6) {
        this(10, paramString1, paramString2, paramList1, -2, paramList2, paramLong1, paramBoolean1, paramLong2, paramList3, paramLong3, paramInt, paramString3, paramLong4, paramString4, paramBoolean2, paramString5, paramString6, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        ke.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */