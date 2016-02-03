package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public final class ef
{
  public final int errorCode;
  public final bl nM;
  public final bu nN;
  public final String nO;
  public final bo nP;
  public final List<String> nt;
  public final List<String> nu;
  public final long nx;
  public final int orientation;
  public final ex oy;
  public final ai pX;
  public final String qa;
  public final long qf;
  public final boolean qg;
  public final long qh;
  public final List<String> qi;
  public final String ql;
  public final al rA;
  public final long rB;
  public final long rC;
  public final JSONObject ry;
  public final bm rz;
  
  public ef(ai paramai, ex paramex, List<String> paramList1, int paramInt1, List<String> paramList2, List<String> paramList3, int paramInt2, long paramLong1, String paramString1, boolean paramBoolean, bl parambl, bu parambu, String paramString2, bm parambm, bo parambo, long paramLong2, al paramal, long paramLong3, long paramLong4, long paramLong5, String paramString3, JSONObject paramJSONObject)
  {
    this.pX = paramai;
    this.oy = paramex;
    if (paramList1 != null)
    {
      paramai = Collections.unmodifiableList(paramList1);
      this.nt = paramai;
      this.errorCode = paramInt1;
      if (paramList2 == null) {
        break label168;
      }
      paramai = Collections.unmodifiableList(paramList2);
      label45:
      this.nu = paramai;
      if (paramList3 == null) {
        break label173;
      }
    }
    label168:
    label173:
    for (paramai = Collections.unmodifiableList(paramList3);; paramai = null)
    {
      this.qi = paramai;
      this.orientation = paramInt2;
      this.nx = paramLong1;
      this.qa = paramString1;
      this.qg = paramBoolean;
      this.nM = parambl;
      this.nN = parambu;
      this.nO = paramString2;
      this.rz = parambm;
      this.nP = parambo;
      this.qh = paramLong2;
      this.rA = paramal;
      this.qf = paramLong3;
      this.rB = paramLong4;
      this.rC = paramLong5;
      this.ql = paramString3;
      this.ry = paramJSONObject;
      return;
      paramai = null;
      break;
      paramai = null;
      break label45;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */