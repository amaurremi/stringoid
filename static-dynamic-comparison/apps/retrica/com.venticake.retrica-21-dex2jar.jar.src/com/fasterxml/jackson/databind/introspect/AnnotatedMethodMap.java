package com.fasterxml.jackson.databind.introspect;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public final class AnnotatedMethodMap
  implements Iterable<AnnotatedMethod>
{
  protected LinkedHashMap<MemberKey, AnnotatedMethod> _methods;
  
  public void add(AnnotatedMethod paramAnnotatedMethod)
  {
    if (this._methods == null) {
      this._methods = new LinkedHashMap();
    }
    this._methods.put(new MemberKey(paramAnnotatedMethod.getAnnotated()), paramAnnotatedMethod);
  }
  
  public AnnotatedMethod find(String paramString, Class<?>[] paramArrayOfClass)
  {
    if (this._methods == null) {
      return null;
    }
    return (AnnotatedMethod)this._methods.get(new MemberKey(paramString, paramArrayOfClass));
  }
  
  public AnnotatedMethod find(Method paramMethod)
  {
    if (this._methods == null) {
      return null;
    }
    return (AnnotatedMethod)this._methods.get(new MemberKey(paramMethod));
  }
  
  public boolean isEmpty()
  {
    return (this._methods == null) || (this._methods.size() == 0);
  }
  
  public Iterator<AnnotatedMethod> iterator()
  {
    if (this._methods != null) {
      return this._methods.values().iterator();
    }
    return Collections.emptyList().iterator();
  }
  
  public AnnotatedMethod remove(Method paramMethod)
  {
    if (this._methods != null) {
      return (AnnotatedMethod)this._methods.remove(new MemberKey(paramMethod));
    }
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/introspect/AnnotatedMethodMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */