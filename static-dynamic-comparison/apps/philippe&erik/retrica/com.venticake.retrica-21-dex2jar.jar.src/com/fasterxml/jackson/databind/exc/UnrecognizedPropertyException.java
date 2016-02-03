package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Collection;
import java.util.Iterator;

public class UnrecognizedPropertyException
  extends JsonMappingException
{
  protected transient String _propertiesAsString;
  protected final Collection<Object> _propertyIds;
  protected final Class<?> _referringClass;
  protected final String _unrecognizedPropertyName;
  
  public UnrecognizedPropertyException(String paramString1, JsonLocation paramJsonLocation, Class<?> paramClass, String paramString2, Collection<Object> paramCollection)
  {
    super(paramString1, paramJsonLocation);
    this._referringClass = paramClass;
    this._unrecognizedPropertyName = paramString2;
    this._propertyIds = paramCollection;
  }
  
  public static UnrecognizedPropertyException from(JsonParser paramJsonParser, Object paramObject, String paramString, Collection<Object> paramCollection)
  {
    if (paramObject == null) {
      throw new IllegalArgumentException();
    }
    if ((paramObject instanceof Class)) {}
    for (Class localClass = (Class)paramObject;; localClass = paramObject.getClass())
    {
      paramJsonParser = new UnrecognizedPropertyException("Unrecognized field \"" + paramString + "\" (class " + localClass.getName() + "), not marked as ignorable", paramJsonParser.getCurrentLocation(), localClass, paramString, paramCollection);
      paramJsonParser.prependPath(paramObject, paramString);
      return paramJsonParser;
    }
  }
  
  public String getMessageSuffix()
  {
    Object localObject2 = this._propertiesAsString;
    Object localObject1 = localObject2;
    int i;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (this._propertyIds != null)
      {
        localObject1 = new StringBuilder(100);
        i = this._propertyIds.size();
        if (i != 1) {
          break label100;
        }
        ((StringBuilder)localObject1).append(" (one known property: \"");
        ((StringBuilder)localObject1).append(String.valueOf(this._propertyIds.iterator().next()));
        ((StringBuilder)localObject1).append('"');
        break label126;
      }
    }
    for (;;)
    {
      ((StringBuilder)localObject1).append("])");
      localObject1 = ((StringBuilder)localObject1).toString();
      this._propertiesAsString = ((String)localObject1);
      return (String)localObject1;
      label100:
      ((StringBuilder)localObject1).append(" (").append(i).append(" known properties: ");
      localObject2 = this._propertyIds.iterator();
      label126:
      if (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject1).append(", \"");
        ((StringBuilder)localObject1).append(String.valueOf(((Iterator)localObject2).next()));
        ((StringBuilder)localObject1).append('"');
        if (((StringBuilder)localObject1).length() <= 200) {
          break;
        }
        ((StringBuilder)localObject1).append(" [truncated]");
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/exc/UnrecognizedPropertyException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */