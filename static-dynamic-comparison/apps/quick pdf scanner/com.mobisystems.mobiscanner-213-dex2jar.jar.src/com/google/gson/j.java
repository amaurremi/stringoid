package com.google.gson;

import com.google.gson.internal.a;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class j
  extends h
{
  private final Map<String, h> aeO = new LinkedHashMap();
  
  public void a(String paramString, h paramh)
  {
    Object localObject = paramh;
    if (paramh == null) {
      localObject = i.aeN;
    }
    this.aeO.put(a.ad(paramString), localObject);
  }
  
  public Set<Map.Entry<String, h>> entrySet()
  {
    return this.aeO.entrySet();
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof j)) && (((j)paramObject).aeO.equals(this.aeO)));
  }
  
  public int hashCode()
  {
    return this.aeO.hashCode();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/gson/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */