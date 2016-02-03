package com.google.android.gms.analytics;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

class aj
  implements j
{
  String wh;
  double wi = -1.0D;
  int wj = -1;
  int wk = -1;
  int wl = -1;
  int wm = -1;
  Map<String, String> wn = new HashMap();
  
  public String M(String paramString)
  {
    String str = (String)this.wn.get(paramString);
    if (str != null) {
      return str;
    }
    return paramString;
  }
  
  public boolean dj()
  {
    return this.wh != null;
  }
  
  public String dk()
  {
    return this.wh;
  }
  
  public boolean dl()
  {
    return this.wi >= 0.0D;
  }
  
  public double dm()
  {
    return this.wi;
  }
  
  public boolean dn()
  {
    return this.wj >= 0;
  }
  
  public boolean jdMethod_do()
  {
    return this.wk != -1;
  }
  
  public boolean dp()
  {
    return this.wk == 1;
  }
  
  public boolean dq()
  {
    return this.wl != -1;
  }
  
  public boolean dr()
  {
    return this.wl == 1;
  }
  
  public boolean ds()
  {
    return this.wm == 1;
  }
  
  public int getSessionTimeout()
  {
    return this.wj;
  }
  
  public String h(Activity paramActivity)
  {
    return M(paramActivity.getClass().getCanonicalName());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/google/android/gms/analytics/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */