package com.flurry.org.codehaus.jackson.map.ser.impl;

import com.flurry.org.codehaus.jackson.map.ser.BeanPropertyFilter;
import com.flurry.org.codehaus.jackson.map.ser.FilterProvider;
import java.util.HashMap;
import java.util.Map;

public class SimpleFilterProvider
  extends FilterProvider
{
  protected boolean _cfgFailOnUnknownId = true;
  protected BeanPropertyFilter _defaultFilter;
  protected final Map<String, BeanPropertyFilter> _filtersById;
  
  public SimpleFilterProvider()
  {
    this(new HashMap());
  }
  
  public SimpleFilterProvider(Map<String, BeanPropertyFilter> paramMap)
  {
    this._filtersById = paramMap;
  }
  
  public SimpleFilterProvider addFilter(String paramString, BeanPropertyFilter paramBeanPropertyFilter)
  {
    this._filtersById.put(paramString, paramBeanPropertyFilter);
    return this;
  }
  
  public BeanPropertyFilter findFilter(Object paramObject)
  {
    BeanPropertyFilter localBeanPropertyFilter2 = (BeanPropertyFilter)this._filtersById.get(paramObject);
    BeanPropertyFilter localBeanPropertyFilter1 = localBeanPropertyFilter2;
    if (localBeanPropertyFilter2 == null)
    {
      localBeanPropertyFilter2 = this._defaultFilter;
      localBeanPropertyFilter1 = localBeanPropertyFilter2;
      if (localBeanPropertyFilter2 == null)
      {
        localBeanPropertyFilter1 = localBeanPropertyFilter2;
        if (this._cfgFailOnUnknownId) {
          throw new IllegalArgumentException("No filter configured with id '" + paramObject + "' (type " + paramObject.getClass().getName() + ")");
        }
      }
    }
    return localBeanPropertyFilter1;
  }
  
  public BeanPropertyFilter getDefaultFilter()
  {
    return this._defaultFilter;
  }
  
  public BeanPropertyFilter removeFilter(String paramString)
  {
    return (BeanPropertyFilter)this._filtersById.remove(paramString);
  }
  
  public SimpleFilterProvider setDefaultFilter(BeanPropertyFilter paramBeanPropertyFilter)
  {
    this._defaultFilter = paramBeanPropertyFilter;
    return this;
  }
  
  public SimpleFilterProvider setFailOnUnknownId(boolean paramBoolean)
  {
    this._cfgFailOnUnknownId = paramBoolean;
    return this;
  }
  
  public boolean willFailOnUnknownId()
  {
    return this._cfgFailOnUnknownId;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ser/impl/SimpleFilterProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */