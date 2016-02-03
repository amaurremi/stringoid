package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public final class eg
{
  public final int errorCode;
  public final bm nK;
  public final bv nL;
  public final String nM;
  public final bp nN;
  public final List<String> nr;
  public final List<String> ns;
  public final long nv;
  public final int orientation;
  public final ey ow;
  public final aj pV;
  public final String pY;
  public final long qc;
  public final boolean qd;
  public final long qe;
  public final List<String> qf;
  public final String qi;
  public final JSONObject rv;
  public final bn rw;
  public final am rx;
  public final long ry;
  public final long rz;
  
  public eg(aj paramaj, ey paramey, List<String> paramList1, int paramInt1, List<String> paramList2, List<String> paramList3, int paramInt2, long paramLong1, String paramString1, boolean paramBoolean, bm parambm, bv parambv, String paramString2, bn parambn, bp parambp, long paramLong2, am paramam, long paramLong3, long paramLong4, long paramLong5, String paramString3, JSONObject paramJSONObject)
  {
    this.pV = paramaj;
    this.ow = paramey;
    if (paramList1 != null)
    {
      paramaj = Collections.unmodifiableList(paramList1);
      this.nr = paramaj;
      this.errorCode = paramInt1;
      if (paramList2 == null) {
        break label168;
      }
      paramaj = Collections.unmodifiableList(paramList2);
      label45:
      this.ns = paramaj;
      if (paramList3 == null) {
        break label173;
      }
    }
    label168:
    label173:
    for (paramaj = Collections.unmodifiableList(paramList3);; paramaj = null)
    {
      this.qf = paramaj;
      this.orientation = paramInt2;
      this.nv = paramLong1;
      this.pY = paramString1;
      this.qd = paramBoolean;
      this.nK = parambm;
      this.nL = parambv;
      this.nM = paramString2;
      this.rw = parambn;
      this.nN = parambp;
      this.qe = paramLong2;
      this.rx = paramam;
      this.qc = paramLong3;
      this.ry = paramLong4;
      this.rz = paramLong5;
      this.qi = paramString3;
      this.rv = paramJSONObject;
      return;
      paramaj = null;
      break;
      paramaj = null;
      break label45;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/internal/eg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */