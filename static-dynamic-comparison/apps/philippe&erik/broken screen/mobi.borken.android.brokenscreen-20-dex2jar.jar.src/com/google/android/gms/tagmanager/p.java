package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class p
  extends aj
{
  private static final String ID = a.D.toString();
  private final String aeR;
  
  public p(String paramString)
  {
    super(ID, new String[0]);
    this.aeR = paramString;
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    if (this.aeR == null) {
      return dh.mY();
    }
    return dh.r(this.aeR);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */