package org.codehaus.jackson.map.deser.std;

import org.codehaus.jackson.map.DeserializationContext;

final class StdKeyDeserializer$StringKD
  extends StdKeyDeserializer
{
  private static final StringKD sObject = new StringKD(Object.class);
  private static final StringKD sString = new StringKD(String.class);
  
  private StdKeyDeserializer$StringKD(Class paramClass)
  {
    super(paramClass);
  }
  
  public static StringKD forType(Class paramClass)
  {
    if (paramClass == String.class) {
      return sString;
    }
    if (paramClass == Object.class) {
      return sObject;
    }
    return new StringKD(paramClass);
  }
  
  public String _parse(String paramString, DeserializationContext paramDeserializationContext)
  {
    return paramString;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdKeyDeserializer$StringKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */