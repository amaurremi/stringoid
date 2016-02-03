package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

import org.json.JSONObject;

@ii
public final class lc {
    public final av a;
    public final mz b;
    public final List<String> c;
    public final int d;
    public final List<String> e;
    public final List<String> f;
    public final int g;
    public final long h;
    public final String i;
    public final JSONObject j;
    public final boolean k;
    public final dh l;
    public final dx m;
    public final String n;
    public final di o;
    public final dl p;
    public final long q;
    public final ay r;
    public final long s;
    public final long t;
    public final long u;
    public final String v;
    public final bx w;

    public lc(av paramav, mz parammz, List<String> paramList1, int paramInt1, List<String> paramList2, List<String> paramList3, int paramInt2, long paramLong1, String paramString1, boolean paramBoolean, dh paramdh, dx paramdx, String paramString2, di paramdi, dl paramdl, long paramLong2, ay paramay, long paramLong3, long paramLong4, long paramLong5, String paramString3, JSONObject paramJSONObject, bx parambx) {
        this.a = paramav;
        this.b = parammz;
        if (paramList1 != null) {
            paramav = Collections.unmodifiableList(paramList1);
            this.c = paramav;
            this.d = paramInt1;
            if (paramList2 == null) {
                break label174;
            }
            paramav = Collections.unmodifiableList(paramList2);
            label45:
            this.e = paramav;
            if (paramList3 == null) {
                break label179;
            }
        }
        label174:
        label179:
        for (paramav = Collections.unmodifiableList(paramList3); ; paramav = null) {
            this.f = paramav;
            this.g = paramInt2;
            this.h = paramLong1;
            this.i = paramString1;
            this.k = paramBoolean;
            this.l = paramdh;
            this.m = paramdx;
            this.n = paramString2;
            this.o = paramdi;
            this.p = paramdl;
            this.q = paramLong2;
            this.r = paramay;
            this.s = paramLong3;
            this.t = paramLong4;
            this.u = paramLong5;
            this.v = paramString3;
            this.j = paramJSONObject;
            this.w = parambx;
            return;
            paramav = null;
            break;
            paramav = null;
            break label45;
        }
    }

    public lc(ld paramld, mz parammz, dh paramdh, dx paramdx, String paramString, dl paramdl, bx parambx) {
        this(paramld.a.c, parammz, paramld.b.d, paramld.e, paramld.b.f, paramld.b.j, paramld.b.l, paramld.b.k, paramld.a.i, paramld.b.h, paramdh, paramdx, paramString, paramld.c, paramdl, paramld.b.i, paramld.d, paramld.b.g, paramld.f, paramld.g, paramld.b.o, paramld.h, parambx);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/lc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */