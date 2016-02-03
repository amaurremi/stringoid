package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class c
  extends aj
{
  private static final String ID = com.google.android.gms.internal.a.v.toString();
  private final a aeg;
  
  public c(Context paramContext)
  {
    this(a.J(paramContext));
  }
  
  c(a parama)
  {
    super(ID, new String[0]);
    this.aeg = parama;
  }
  
  public boolean lc()
  {
    return false;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    if (!this.aeg.isLimitAdTrackingEnabled()) {}
    for (boolean bool = true;; bool = false) {
      return dh.r(Boolean.valueOf(bool));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */