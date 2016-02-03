package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class ah
  extends aj
{
  private static final String ID = a.I.toString();
  private final cs aes;
  
  public ah(cs paramcs)
  {
    super(ID, new String[0]);
    this.aes = paramcs;
  }
  
  public boolean lc()
  {
    return false;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    paramMap = this.aes.mC();
    if (paramMap == null) {
      return dh.mY();
    }
    return dh.r(paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */