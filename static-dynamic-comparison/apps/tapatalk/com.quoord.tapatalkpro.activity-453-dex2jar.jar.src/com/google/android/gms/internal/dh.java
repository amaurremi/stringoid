package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

import org.json.JSONObject;

public final class dh {
    public final int errorCode;
    public final bl nA;
    public final List<String> ne;
    public final List<String> nf;
    public final long ni;
    public final bi nx;
    public final br ny;
    public final String nz;
    public final dz oj;
    public final int orientation;
    public final ah pg;
    public final String pj;
    public final long pn;
    public final boolean po;
    public final long pp;
    public final List<String> pq;
    public final String pt;
    public final JSONObject qs;
    public final bj qt;
    public final ak qu;
    public final long qv;
    public final long qw;

    public dh(ah paramah, dz paramdz, List<String> paramList1, int paramInt1, List<String> paramList2, List<String> paramList3, int paramInt2, long paramLong1, String paramString1, boolean paramBoolean, bi parambi, br parambr, String paramString2, bj parambj, bl parambl, long paramLong2, ak paramak, long paramLong3, long paramLong4, long paramLong5, String paramString3, JSONObject paramJSONObject) {
        this.pg = paramah;
        this.oj = paramdz;
        if (paramList1 != null) {
            paramah = Collections.unmodifiableList(paramList1);
            this.ne = paramah;
            this.errorCode = paramInt1;
            if (paramList2 == null) {
                break label168;
            }
            paramah = Collections.unmodifiableList(paramList2);
            label45:
            this.nf = paramah;
            if (paramList3 == null) {
                break label173;
            }
        }
        label168:
        label173:
        for (paramah = Collections.unmodifiableList(paramList3); ; paramah = null) {
            this.pq = paramah;
            this.orientation = paramInt2;
            this.ni = paramLong1;
            this.pj = paramString1;
            this.po = paramBoolean;
            this.nx = parambi;
            this.ny = parambr;
            this.nz = paramString2;
            this.qt = parambj;
            this.nA = parambl;
            this.pp = paramLong2;
            this.qu = paramak;
            this.pn = paramLong3;
            this.qv = paramLong4;
            this.qw = paramLong5;
            this.pt = paramString3;
            this.qs = paramJSONObject;
            return;
            paramah = null;
            break;
            paramah = null;
            break label45;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */