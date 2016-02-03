package com.flurry.org.codehaus.jackson.map.deser;

import java.util.HashMap;

@Deprecated
public final class EnumResolver<T extends Enum<T>>
  extends com.flurry.org.codehaus.jackson.map.util.EnumResolver<T>
{
  private EnumResolver(Class<T> paramClass, T[] paramArrayOfT, HashMap<String, T> paramHashMap)
  {
    super(paramClass, paramArrayOfT, paramHashMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/deser/EnumResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */