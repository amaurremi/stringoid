package com.google.android.gms.analytics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class ab
{
  private final Map<String, Integer> wI = new HashMap();
  private final Map<String, String> wJ = new HashMap();
  private final boolean wK;
  private final String wL;
  
  ab(String paramString, boolean paramBoolean)
  {
    this.wK = paramBoolean;
    this.wL = paramString;
  }
  
  void c(String paramString, int paramInt)
  {
    if (!this.wK) {
      return;
    }
    Integer localInteger2 = (Integer)this.wI.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    this.wI.put(paramString, Integer.valueOf(localInteger1.intValue() + paramInt));
  }
  
  String dl()
  {
    if (!this.wK) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.wL);
    Iterator localIterator = this.wI.keySet().iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder.append("&").append(str).append("=").append(this.wI.get(str));
    }
    localIterator = this.wJ.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder.append("&").append(str).append("=").append((String)this.wJ.get(str));
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/android/gms/analytics/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */