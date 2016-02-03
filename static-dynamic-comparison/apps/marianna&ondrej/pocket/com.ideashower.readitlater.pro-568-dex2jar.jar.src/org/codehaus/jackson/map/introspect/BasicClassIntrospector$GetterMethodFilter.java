package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Method;
import org.codehaus.jackson.map.util.ClassUtil;

@Deprecated
public class BasicClassIntrospector$GetterMethodFilter
  implements MethodFilter
{
  public boolean includeMethod(Method paramMethod)
  {
    return ClassUtil.hasGetterSignature(paramMethod);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/introspect/BasicClassIntrospector$GetterMethodFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */