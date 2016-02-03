package com.amazon.inapp.purchasing;

import java.util.HashMap;
import java.util.Map;

final class KiwiImplementationRegistry
  implements ImplementationRegistry
{
  private static final Map<Class, Class> classMap = new HashMap();
  
  static
  {
    classMap.put(RequestHandler.class, KiwiRequestHandler.class);
    classMap.put(ResponseHandler.class, KiwiResponseHandler.class);
    classMap.put(LogHandler.class, KiwiLogHandler.class);
  }
  
  public <T> Class<T> getImplementation(Class<T> paramClass)
  {
    return (Class)classMap.get(paramClass);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/KiwiImplementationRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */