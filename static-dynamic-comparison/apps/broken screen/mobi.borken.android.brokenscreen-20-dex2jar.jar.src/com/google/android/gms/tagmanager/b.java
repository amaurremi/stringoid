package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class b
  extends aj
{
  private static final String ID = com.google.android.gms.internal.a.u.toString();
  private final a aeg;
  
  public b(Context paramContext)
  {
    this(a.J(paramContext));
  }
  
  b(a parama)
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
    paramMap = this.aeg.kY();
    if (paramMap == null) {
      return dh.mY();
    }
    return dh.r(paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */