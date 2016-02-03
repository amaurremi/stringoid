package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GenericData
  extends AbstractMap<String, Object>
  implements Cloneable
{
  final h abf;
  Map<String, Object> adP = a.yC();
  
  public GenericData()
  {
    this(EnumSet.noneOf(Flags.class));
  }
  
  public GenericData(EnumSet<Flags> paramEnumSet)
  {
    this.abf = h.a(getClass(), paramEnumSet.contains(Flags.adV));
  }
  
  public GenericData clone()
  {
    try
    {
      GenericData localGenericData = (GenericData)super.clone();
      i.i(this, localGenericData);
      localGenericData.adP = ((Map)i.clone(this.adP));
      return localGenericData;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new IllegalStateException(localCloneNotSupportedException);
    }
  }
  
  public Set<Map.Entry<String, Object>> entrySet()
  {
    return new b();
  }
  
  public final Object get(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      return null;
    }
    String str = (String)paramObject;
    paramObject = this.abf.cs(str);
    if (paramObject != null) {
      return ((l)paramObject).aj(this);
    }
    paramObject = str;
    if (this.abf.yH()) {
      paramObject = str.toLowerCase();
    }
    return this.adP.get(paramObject);
  }
  
  public final h getClassInfo()
  {
    return this.abf;
  }
  
  public final Map<String, Object> getUnknownKeys()
  {
    return this.adP;
  }
  
  public final Object put(String paramString, Object paramObject)
  {
    Object localObject = this.abf.cs(paramString);
    if (localObject != null)
    {
      paramString = ((l)localObject).aj(this);
      ((l)localObject).j(this, paramObject);
      return paramString;
    }
    localObject = paramString;
    if (this.abf.yH()) {
      localObject = paramString.toLowerCase();
    }
    return this.adP.put(localObject, paramObject);
  }
  
  public final void putAll(Map<? extends String, ?> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      set((String)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public final Object remove(Object paramObject)
  {
    if (!(paramObject instanceof String)) {
      return null;
    }
    String str = (String)paramObject;
    if (this.abf.cs(str) != null) {
      throw new UnsupportedOperationException();
    }
    paramObject = str;
    if (this.abf.yH()) {
      paramObject = str.toLowerCase();
    }
    return this.adP.remove(paramObject);
  }
  
  public GenericData set(String paramString, Object paramObject)
  {
    Object localObject = this.abf.cs(paramString);
    if (localObject != null)
    {
      ((l)localObject).j(this, paramObject);
      return this;
    }
    localObject = paramString;
    if (this.abf.yH()) {
      localObject = paramString.toLowerCase();
    }
    this.adP.put(localObject, paramObject);
    return this;
  }
  
  public final void setUnknownKeys(Map<String, Object> paramMap)
  {
    this.adP = paramMap;
  }
  
  public static enum Flags
  {
    private Flags() {}
  }
  
  final class a
    implements Iterator<Map.Entry<String, Object>>
  {
    private boolean adQ;
    private final Iterator<Map.Entry<String, Object>> adR;
    private final Iterator<Map.Entry<String, Object>> adS;
    
    a(j.c paramc)
    {
      this.adR = paramc.yK();
      this.adS = GenericData.this.adP.entrySet().iterator();
    }
    
    public boolean hasNext()
    {
      return (this.adR.hasNext()) || (this.adS.hasNext());
    }
    
    public Map.Entry<String, Object> r()
    {
      if (!this.adQ)
      {
        if (this.adR.hasNext()) {
          return (Map.Entry)this.adR.next();
        }
        this.adQ = true;
      }
      return (Map.Entry)this.adS.next();
    }
    
    public void remove()
    {
      if (this.adQ) {
        this.adS.remove();
      }
      this.adR.remove();
    }
  }
  
  final class b
    extends AbstractSet<Map.Entry<String, Object>>
  {
    private final j.c adU = new j(GenericData.this, GenericData.this.abf.yH()).yJ();
    
    b() {}
    
    public void clear()
    {
      GenericData.this.adP.clear();
      this.adU.clear();
    }
    
    public Iterator<Map.Entry<String, Object>> iterator()
    {
      return new GenericData.a(GenericData.this, this.adU);
    }
    
    public int size()
    {
      return GenericData.this.adP.size() + this.adU.size();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/quick pdf scanner/com.mobisystems.mobiscanner-213-dex2jar.jar!/com/google/api/client/util/GenericData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */