package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class m
  extends aj
{
  private static final String ID = a.A.toString();
  private static final String VALUE = b.ew.toString();
  
  public m()
  {
    super(ID, new String[] { VALUE });
  }
  
  public static String lf()
  {
    return ID;
  }
  
  public static String lg()
  {
    return VALUE;
  }
  
  public boolean lc()
  {
    return true;
  }
  
  public d.a w(Map<String, d.a> paramMap)
  {
    return (d.a)paramMap.get(VALUE);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/tagmanager/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */