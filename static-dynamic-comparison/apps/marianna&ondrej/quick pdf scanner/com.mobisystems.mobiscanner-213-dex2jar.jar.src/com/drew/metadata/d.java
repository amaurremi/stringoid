package com.drew.metadata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  private final Map<Class<? extends b>, b> fX = new HashMap();
  private final Collection<b> fY = new ArrayList();
  
  public <T extends b> T a(Class<T> paramClass)
  {
    if (this.fX.containsKey(paramClass)) {
      return (b)this.fX.get(paramClass);
    }
    try
    {
      b localb = (b)paramClass.newInstance();
      this.fX.put(paramClass, localb);
      this.fY.add(localb);
      return localb;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Cannot instantiate provided Directory type: " + paramClass.toString());
    }
  }
  
  public Iterable<b> aC()
  {
    return this.fY;
  }
  
  public <T extends b> T b(Class<T> paramClass)
  {
    return (b)this.fX.get(paramClass);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/drew/metadata/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */