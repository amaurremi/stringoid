package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class c
  extends aj
{
  private static final String ID = com.google.android.gms.internal.a.v.toString();
  private final a Wz;
  
  public c(Context paramContext)
  {
    this(a.E(paramContext));
  }
  
  c(a parama)
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
    if (!this.Wz.isLimitAdTrackingEnabled()) {}
    for (boolean bool = true;; bool = false) {
      return dh.r(Boolean.valueOf(bool));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */