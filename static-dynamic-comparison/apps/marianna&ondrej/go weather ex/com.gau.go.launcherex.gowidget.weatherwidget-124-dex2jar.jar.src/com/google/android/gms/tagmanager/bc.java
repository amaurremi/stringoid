package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Locale;
import java.util.Map;

class bc
  extends aj
{
  private static final String ID = a.L.toString();
  
  public bc()
  {
    super(ID, new String[0]);
  }
  
  public boolean jX()
  {
    return false;
  }
  
  public d.a x(Map<String, d.a> paramMap)
  {
    paramMap = Locale.getDefault();
    if (paramMap == null) {
      return dh.lT();
    }
    paramMap = paramMap.getLanguage();
    if (paramMap == null) {
      return dh.lT();
    }
    return dh.r(paramMap.toLowerCase());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/tagmanager/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */