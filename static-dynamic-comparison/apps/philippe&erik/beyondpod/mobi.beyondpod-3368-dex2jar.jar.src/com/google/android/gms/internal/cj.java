package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

public final class cj
{
  public final int errorCode;
  public final List<String> fK;
  public final List<String> fL;
  public final long fO;
  public final cw gJ;
  public final at gb;
  public final bc gc;
  public final String gd;
  public final aw ge;
  public final List<String> hA;
  public final v hr;
  public final String hu;
  public final long hx;
  public final boolean hy;
  public final long hz;
  public final au is;
  public final x it;
  public final int orientation;
  
  public cj(v paramv, cw paramcw, List<String> paramList1, int paramInt1, List<String> paramList2, List<String> paramList3, int paramInt2, long paramLong1, String paramString1, boolean paramBoolean, at paramat, bc parambc, String paramString2, au paramau, aw paramaw, long paramLong2, x paramx, long paramLong3)
  {
    this.hr = paramv;
    this.gJ = paramcw;
    if (paramList1 != null)
    {
      paramv = Collections.unmodifiableList(paramList1);
      this.fK = paramv;
      this.errorCode = paramInt1;
      if (paramList2 == null) {
        break label144;
      }
      paramv = Collections.unmodifiableList(paramList2);
      label45:
      this.fL = paramv;
      if (paramList3 == null) {
        break label149;
      }
    }
    label144:
    label149:
    for (paramv = Collections.unmodifiableList(paramList3);; paramv = null)
    {
      this.hA = paramv;
      this.orientation = paramInt2;
      this.fO = paramLong1;
      this.hu = paramString1;
      this.hy = paramBoolean;
      this.gb = paramat;
      this.gc = parambc;
      this.gd = paramString2;
      this.is = paramau;
      this.ge = paramaw;
      this.hz = paramLong2;
      this.it = paramx;
      this.hx = paramLong3;
      return;
      paramv = null;
      break;
      paramv = null;
      break label45;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/com/google/android/gms/internal/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */