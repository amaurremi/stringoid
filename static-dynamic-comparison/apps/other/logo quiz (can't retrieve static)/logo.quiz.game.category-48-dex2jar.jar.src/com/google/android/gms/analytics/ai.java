package com.google.android.gms.analytics;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

class ai
  implements i
{
  String BC;
  double BD = -1.0D;
  int BE = -1;
  int BF = -1;
  int BG = -1;
  int BH = -1;
  Map<String, String> BI = new HashMap();
  
  public String am(String paramString)
  {
    String str = (String)this.BI.get(paramString);
    if (str != null) {
      return str;
    }
    return paramString;
  }
  
  public boolean fa()
  {
    return this.BC != null;
  }
  
  public String fb()
  {
    return this.BC;
  }
  
  public boolean fc()
  {
    return this.BD >= 0.0D;
  }
  
  public double fd()
  {
    return this.BD;
  }
  
  public boolean fe()
  {
    return this.BE >= 0;
  }
  
  public boolean ff()
  {
    return this.BF != -1;
  }
  
  public boolean fg()
  {
    return this.BF == 1;
  }
  
  public boolean fh()
  {
    return this.BG != -1;
  }
  
  public boolean fi()
  {
    return this.BG == 1;
  }
  
  public boolean fj()
  {
    return this.BH == 1;
  }
  
  public int getSessionTimeout()
  {
    return this.BE;
  }
  
  public String k(Activity paramActivity)
  {
    return am(paramActivity.getClass().getCanonicalName());
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/google/android/gms/analytics/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */