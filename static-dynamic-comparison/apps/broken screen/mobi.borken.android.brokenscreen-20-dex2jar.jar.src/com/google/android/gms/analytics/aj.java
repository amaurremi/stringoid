package com.google.android.gms.analytics;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

class aj
  implements j
{
  Map<String, String> xA = new HashMap();
  String xu;
  double xv = -1.0D;
  int xw = -1;
  int xx = -1;
  int xy = -1;
  int xz = -1;
  
  public String T(String paramString)
  {
    String str = (String)this.xA.get(paramString);
    if (str != null) {
      return str;
    }
    return paramString;
  }
  
  public String dA()
  {
    return this.xu;
  }
  
  public boolean dB()
  {
    return this.xv >= 0.0D;
  }
  
  public double dC()
  {
    return this.xv;
  }
  
  public boolean dD()
  {
    return this.xw >= 0;
  }
  
  public boolean dE()
  {
    return this.xx != -1;
  }
  
  public boolean dF()
  {
    return this.xx == 1;
  }
  
  public boolean dG()
  {
    return this.xy != -1;
  }
  
  public boolean dH()
  {
    return this.xy == 1;
  }
  
  public boolean dI()
  {
    return this.xz == 1;
  }
  
  public boolean dz()
  {
    return this.xu != null;
  }
  
  public int getSessionTimeout()
  {
    return this.xw;
  }
  
  public String j(Activity paramActivity)
  {
    return T(paramActivity.getClass().getCanonicalName());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/analytics/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */