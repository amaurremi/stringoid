package com.google.android.gms.internal;

import com.atomic.apps.ringtone.cutter.aa;
import java.util.Map;

final class bw
  implements R
{
  bw(bv parambv) {}
  
  public final void a(bW arg1, Map paramMap)
  {
    synchronized (bv.a(this.a))
    {
      String str = (String)paramMap.get("type");
      paramMap = (String)paramMap.get("errors");
      aa.e("Invalid " + str + " request error: " + paramMap);
      bv.a(this.a, 1);
      bv.a(this.a).notify();
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */