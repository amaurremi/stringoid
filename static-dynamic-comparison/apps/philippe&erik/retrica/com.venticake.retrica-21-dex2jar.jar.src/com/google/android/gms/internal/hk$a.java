package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public final class hk$a
{
  private final List<String> GJ;
  private final Object GK;
  
  private hk$a(Object paramObject)
  {
    this.GK = hm.f(paramObject);
    this.GJ = new ArrayList();
  }
  
  public a a(String paramString, Object paramObject)
  {
    this.GJ.add((String)hm.f(paramString) + "=" + String.valueOf(paramObject));
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100).append(this.GK.getClass().getSimpleName()).append('{');
    int j = this.GJ.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((String)this.GJ.get(i));
      if (i < j - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    return '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/google/android/gms/internal/hk$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */