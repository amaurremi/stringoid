package org.codehaus.jackson.map.exc;

import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;

public class UnrecognizedPropertyException
  extends JsonMappingException
{
  private static final long serialVersionUID = 1L;
  protected final Class _referringClass;
  protected final String _unrecognizedPropertyName;
  
  public UnrecognizedPropertyException(String paramString1, JsonLocation paramJsonLocation, Class paramClass, String paramString2)
  {
    super(paramString1, paramJsonLocation);
    this._referringClass = paramClass;
    this._unrecognizedPropertyName = paramString2;
  }
  
  public static UnrecognizedPropertyException from(JsonParser paramJsonParser, Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException();
    }
    if ((paramObject instanceof Class)) {}
    for (Class localClass = (Class)paramObject;; localClass = paramObject.getClass())
    {
      paramJsonParser = new UnrecognizedPropertyException("Unrecognized field \"" + paramString + "\" (Class " + localClass.getName() + "), not marked as ignorable", paramJsonParser.getCurrentLocation(), localClass, paramString);
      paramJsonParser.prependPath(paramObject, paramString);
      return paramJsonParser;
    }
  }
  
  public Class getReferringClass()
  {
    return this._referringClass;
  }
  
  public String getUnrecognizedPropertyName()
  {
    return this._unrecognizedPropertyName;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/exc/UnrecognizedPropertyException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */