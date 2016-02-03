package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

public final class bi
{
  public final dd CQ;
  public final y Ck;
  public final aj Cl;
  public final String Cm;
  public final ad Cn;
  public final z DB;
  public final String DG;
  public final long DM;
  public final boolean DN;
  public final long DO;
  public final List<String> DP;
  public final aa EI;
  public final ab EJ;
  public final long EK;
  public final long EL;
  public final int errorCode;
  public final int orientation;
  public final List<String> yi;
  public final List<String> yj;
  public final long ym;
  
  public bi(z paramz, dd paramdd, List<String> paramList1, int paramInt1, List<String> paramList2, List<String> paramList3, int paramInt2, long paramLong1, String paramString1, boolean paramBoolean, y paramy, aj paramaj, String paramString2, aa paramaa, ad paramad, long paramLong2, ab paramab, long paramLong3, long paramLong4, long paramLong5)
  {
    this.DB = paramz;
    this.CQ = paramdd;
    if (paramList1 != null)
    {
      paramz = Collections.unmodifiableList(paramList1);
      this.yi = paramz;
      this.errorCode = paramInt1;
      if (paramList2 == null) {
        break label156;
      }
      paramz = Collections.unmodifiableList(paramList2);
      label45:
      this.yj = paramz;
      if (paramList3 == null) {
        break label161;
      }
    }
    label156:
    label161:
    for (paramz = Collections.unmodifiableList(paramList3);; paramz = null)
    {
      this.DP = paramz;
      this.orientation = paramInt2;
      this.ym = paramLong1;
      this.DG = paramString1;
      this.DN = paramBoolean;
      this.Ck = paramy;
      this.Cl = paramaj;
      this.Cm = paramString2;
      this.EI = paramaa;
      this.Cn = paramad;
      this.DO = paramLong2;
      this.EJ = paramab;
      this.DM = paramLong3;
      this.EK = paramLong4;
      this.EL = paramLong5;
      return;
      paramz = null;
      break;
      paramz = null;
      break label45;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/internal/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */