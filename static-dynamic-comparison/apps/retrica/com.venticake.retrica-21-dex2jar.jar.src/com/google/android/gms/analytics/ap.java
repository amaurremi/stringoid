package com.google.android.gms.analytics;

import com.google.android.gms.internal.fd;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ap
{
  private final Map<String, String> a;
  private final long b;
  private final String c;
  private final List<fd> d;
  
  public ap(Map<String, String> paramMap, long paramLong, String paramString, List<fd> paramList)
  {
    this.a = paramMap;
    this.b = paramLong;
    this.c = paramString;
    this.d = paramList;
  }
  
  public Map<String, String> a()
  {
    return this.a;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public List<fd> d()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PATH: ");
    localStringBuilder.append(this.c);
    if (this.a != null)
    {
      localStringBuilder.append("  PARAMS: ");
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append((String)localEntry.getValue());
        localStringBuilder.append(",  ");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/analytics/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */