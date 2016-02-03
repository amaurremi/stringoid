package org.codehaus.jackson.map.deser.std;

import java.lang.reflect.Array;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.util.ObjectBuffer;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public class ObjectArrayDeserializer
  extends ContainerDeserializerBase
{
  protected final JavaType _arrayType;
  protected final Class _elementClass;
  protected final JsonDeserializer _elementDeserializer;
  protected final TypeDeserializer _elementTypeDeserializer;
  protected final boolean _untyped;
  
  public ObjectArrayDeserializer(ArrayType paramArrayType, JsonDeserializer paramJsonDeserializer, TypeDeserializer paramTypeDeserializer)
  {
    super(Object[].class);
    this._arrayType = paramArrayType;
    this._elementClass = paramArrayType.getContentType().getRawClass();
    if (this._elementClass == Object.class) {}
    for (boolean bool = true;; bool = false)
    {
      this._untyped = bool;
      this._elementDeserializer = paramJsonDeserializer;
      this._elementTypeDeserializer = paramTypeDeserializer;
      return;
    }
  }
  
  private final Object[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) && (paramJsonParser.getText().length() == 0)) {
      return null;
    }
    if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY))
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (this._elementClass == Byte.class)) {
        return deserializeFromBase64(paramJsonParser, paramDeserializationContext);
      }
      throw paramDeserializationContext.mappingException(this._arrayType.getRawClass());
    }
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_NULL)
    {
      paramJsonParser = null;
      if (!this._untyped) {
        break label147;
      }
    }
    label147:
    for (paramDeserializationContext = new Object[1];; paramDeserializationContext = (Object[])Array.newInstance(this._elementClass, 1))
    {
      paramDeserializationContext[0] = paramJsonParser;
      return paramDeserializationContext;
      if (this._elementTypeDeserializer == null)
      {
        paramJsonParser = this._elementDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
        break;
      }
      paramJsonParser = this._elementDeserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, this._elementTypeDeserializer);
      break;
    }
  }
  
  public Object[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      return handleNonArray(paramJsonParser, paramDeserializationContext);
    }
    ObjectBuffer localObjectBuffer = paramDeserializationContext.leaseObjectBuffer();
    Object[] arrayOfObject = localObjectBuffer.resetAndStart();
    TypeDeserializer localTypeDeserializer = this._elementTypeDeserializer;
    int i = 0;
    Object localObject = paramJsonParser.nextToken();
    if (localObject != JsonToken.END_ARRAY) {
      if (localObject == JsonToken.VALUE_NULL)
      {
        localObject = null;
        label60:
        if (i < arrayOfObject.length) {
          break label170;
        }
        arrayOfObject = localObjectBuffer.appendCompletedChunk(arrayOfObject);
        i = 0;
      }
    }
    label170:
    for (;;)
    {
      int j = i + 1;
      arrayOfObject[i] = localObject;
      i = j;
      break;
      if (localTypeDeserializer == null)
      {
        localObject = this._elementDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
        break label60;
      }
      localObject = this._elementDeserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, localTypeDeserializer);
      break label60;
      if (this._untyped) {}
      for (paramJsonParser = localObjectBuffer.completeAndClearBuffer(arrayOfObject, i);; paramJsonParser = localObjectBuffer.completeAndClearBuffer(arrayOfObject, i, this._elementClass))
      {
        paramDeserializationContext.returnObjectBuffer(localObjectBuffer);
        return paramJsonParser;
      }
    }
  }
  
  protected Byte[] deserializeFromBase64(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    paramJsonParser = paramJsonParser.getBinaryValue(paramDeserializationContext.getBase64Variant());
    paramDeserializationContext = new Byte[paramJsonParser.length];
    int i = 0;
    int j = paramJsonParser.length;
    while (i < j)
    {
      paramDeserializationContext[i] = Byte.valueOf(paramJsonParser[i]);
      i += 1;
    }
    return paramDeserializationContext;
  }
  
  public Object[] deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
  {
    return (Object[])paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
  }
  
  public JsonDeserializer getContentDeserializer()
  {
    return this._elementDeserializer;
  }
  
  public JavaType getContentType()
  {
    return this._arrayType.getContentType();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/ObjectArrayDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */