package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public final class am
{
  private final List a;
  private final Object b;
  
  private am(Object paramObject)
  {
    this.b = an.a(paramObject);
    this.a = new ArrayList();
  }
  
  public am a(String paramString, Object paramObject)
  {
    this.a.add((String)an.a(paramString) + "=" + String.valueOf(paramObject));
    return this;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((String)this.a.get(i));
      if (i < j - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    return '}';
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/com/google/android/gms/internal/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */