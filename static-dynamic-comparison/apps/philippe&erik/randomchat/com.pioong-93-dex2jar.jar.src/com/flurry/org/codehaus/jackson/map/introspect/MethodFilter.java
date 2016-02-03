package com.flurry.org.codehaus.jackson.map.introspect;

import java.lang.reflect.Method;

public abstract interface MethodFilter
{
  public abstract boolean includeMethod(Method paramMethod);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/introspect/MethodFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */