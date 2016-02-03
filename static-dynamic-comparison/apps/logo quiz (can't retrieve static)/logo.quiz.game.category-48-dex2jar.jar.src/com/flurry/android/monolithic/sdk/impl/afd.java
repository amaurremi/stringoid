package com.flurry.android.monolithic.sdk.impl;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class afd
  extends aet
{
  protected LinkedHashMap<String, ou> c = null;
  
  public afd(aez paramaez)
  {
    super(paramaez);
  }
  
  private final ou b(String paramString, ou paramou)
  {
    if (this.c == null) {
      this.c = new LinkedHashMap();
    }
    return (ou)this.c.put(paramString, paramou);
  }
  
  public ou a(String paramString)
  {
    if (this.c != null) {
      return (ou)this.c.get(paramString);
    }
    return null;
  }
  
  public ou a(String paramString, ou paramou)
  {
    Object localObject = paramou;
    if (paramou == null) {
      localObject = r();
    }
    return b(paramString, (ou)localObject);
  }
  
  public final void a(or paramor, ru paramru)
    throws IOException, oz
  {
    paramor.d();
    if (this.c != null)
    {
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramor.a((String)localEntry.getKey());
        ((aep)localEntry.getValue()).a(paramor, paramru);
      }
    }
    paramor.e();
  }
  
  public void a(or paramor, ru paramru, rx paramrx)
    throws IOException, oz
  {
    paramrx.b(this, paramor);
    if (this.c != null)
    {
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramor.a((String)localEntry.getKey());
        ((aep)localEntry.getValue()).a(paramor, paramru);
      }
    }
    paramrx.e(this, paramor);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    paramObject = (afd)paramObject;
    if (((afd)paramObject).o() != o()) {
      return false;
    }
    if (this.c != null)
    {
      Iterator localIterator = this.c.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        Object localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (ou)((Map.Entry)localObject2).getValue();
        localObject1 = ((afd)paramObject).a((String)localObject1);
        if ((localObject1 == null) || (!((ou)localObject1).equals(localObject2))) {
          return false;
        }
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    if (this.c == null) {
      return -1;
    }
    return this.c.hashCode();
  }
  
  public int o()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.size();
  }
  
  public Iterator<ou> p()
  {
    if (this.c == null) {
      return aeu.a();
    }
    return this.c.values().iterator();
  }
  
  public Iterator<String> q()
  {
    if (this.c == null) {
      return aev.a();
    }
    return this.c.keySet().iterator();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder((o() << 4) + 32);
    localStringBuilder.append("{");
    if (this.c != null)
    {
      Iterator localIterator = this.c.entrySet().iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (i > 0) {
          localStringBuilder.append(",");
        }
        aff.a(localStringBuilder, (String)localEntry.getKey());
        localStringBuilder.append(':');
        localStringBuilder.append(((ou)localEntry.getValue()).toString());
        i += 1;
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/flurry/android/monolithic/sdk/impl/afd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */