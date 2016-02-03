package com.google.android.gms.internal;

import com.atomic.apps.ringtone.cutter.aa;
import java.util.Map;

final class bx
  implements R
{
  bx(bv parambv) {}
  
  public final void a(bW parambW, Map paramMap)
  {
    synchronized (bv.a(this.a))
    {
      String str2 = (String)paramMap.get("url");
      if (str2 == null)
      {
        aa.e("URL missing in loadAdUrl GMSG.");
        return;
      }
      String str1 = str2;
      if (str2.contains("%40mediation_adapters%40"))
      {
        str1 = str2.replaceAll("%40mediation_adapters%40", bH.a(parambW.getContext(), (String)paramMap.get("check_adapters"), bv.b(this.a)));
        aa.d("Ad request URL modified to " + str1);
      }
      bv.a(this.a, str1);
      bv.a(this.a).notify();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */