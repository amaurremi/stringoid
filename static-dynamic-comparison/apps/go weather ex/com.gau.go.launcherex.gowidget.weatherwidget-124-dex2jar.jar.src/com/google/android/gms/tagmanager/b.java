package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class b
  extends aj
{
  private static final String ID = com.google.android.gms.internal.a.u.toString();
  private final a Wz;
  
  public b(Context paramContext)
  {
    this(a.E(paramContext));
  }
  
  b(a parama)
  {
    super(ID, new String[0]);
    this.Wz = parama;
  }
  
  public boolean jX()
  {
    return false;
  }
  
  public d.a x(Map<String, d.a> paramMap)
  {
    paramMap = this.Wz.jT();
    if (paramMap == null) {
      return dh.lT();
    }
    return dh.r(paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */