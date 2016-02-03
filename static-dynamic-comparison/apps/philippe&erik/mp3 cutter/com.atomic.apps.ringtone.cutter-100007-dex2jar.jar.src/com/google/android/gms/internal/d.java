package com.google.android.gms.internal;

import com.atomic.apps.ringtone.cutter.aa;
import java.util.Map;

final class d
  implements R
{
  d(a parama) {}
  
  public final void a(bW parambW, Map paramMap)
  {
    if ((paramMap.containsKey("pingType")) && ("unloadPing".equals(paramMap.get("pingType"))))
    {
      parambW = this.a;
      a.a(a.a(this.a));
      aa.c("Unregistered GMSG handlers for: " + a.b(this.a).d());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/mp3 cutter/com.atomic.apps.ringtone.cutter-100007-dex2jar.jar!/com/google/android/gms/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */