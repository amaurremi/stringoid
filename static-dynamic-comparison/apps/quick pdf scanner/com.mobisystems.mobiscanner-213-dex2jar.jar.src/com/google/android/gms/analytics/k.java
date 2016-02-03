package com.google.android.gms.analytics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class k
{
  private final Map<String, Integer> mQ = new HashMap();
  private final Map<String, String> mR = new HashMap();
  private final boolean mS;
  private final String mT;
  
  k(String paramString, boolean paramBoolean)
  {
    this.mS = paramBoolean;
    this.mT = paramString;
  }
  
  void a(String paramString, int paramInt)
  {
    if (!this.mS) {
      return;
    }
    Integer localInteger2 = (Integer)this.mQ.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    this.mQ.put(paramString, Integer.valueOf(localInteger1.intValue() + paramInt));
  }
  
  String kP()
  {
    if (!this.mS) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mT);
    Iterator localIterator = this.mQ.keySet().iterator();
    String str;
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder.append("&").append(str).append("=").append(this.mQ.get(str));
    }
    localIterator = this.mR.keySet().iterator();
    while (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      localStringBuilder.append("&").append(str).append("=").append((String)this.mR.get(str));
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/android/gms/analytics/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */