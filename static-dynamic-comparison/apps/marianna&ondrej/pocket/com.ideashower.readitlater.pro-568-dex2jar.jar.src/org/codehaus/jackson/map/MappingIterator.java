package org.codehaus.jackson.map;

import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.type.JavaType;

public class MappingIterator
  implements Iterator
{
  protected static final MappingIterator EMPTY_ITERATOR = new MappingIterator(null, null, null, null, false, null);
  protected final boolean _closeParser;
  protected final DeserializationContext _context;
  protected final JsonDeserializer _deserializer;
  protected boolean _hasNextChecked;
  protected JsonParser _parser;
  protected final JavaType _type;
  protected final Object _updatedValue;
  
  protected MappingIterator(JavaType paramJavaType, JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonDeserializer paramJsonDeserializer)
  {
    this(paramJavaType, paramJsonParser, paramDeserializationContext, paramJsonDeserializer, true, null);
  }
  
  protected MappingIterator(JavaType paramJavaType, JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, JsonDeserializer paramJsonDeserializer, boolean paramBoolean, Object paramObject)
  {
    this._type = paramJavaType;
    this._parser = paramJsonParser;
    this._context = paramDeserializationContext;
    this._deserializer = paramJsonDeserializer;
    if ((paramJsonParser != null) && (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) && (!paramJsonParser.getParsingContext().inRoot())) {
      paramJsonParser.clearCurrentToken();
    }
    this._closeParser = paramBoolean;
    if (paramObject == null)
    {
      this._updatedValue = null;
      return;
    }
    this._updatedValue = paramObject;
  }
  
  protected static MappingIterator emptyIterator()
  {
    return EMPTY_ITERATOR;
  }
  
  public boolean hasNext()
  {
    try
    {
      boolean bool = hasNextValue();
      return bool;
    }
    catch (JsonMappingException localJsonMappingException)
    {
      throw new RuntimeJsonMappingException(localJsonMappingException.getMessage(), localJsonMappingException);
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException.getMessage(), localIOException);
    }
  }
  
  public boolean hasNextValue()
  {
    if (this._parser == null) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        if (this._hasNextChecked) {
          break label75;
        }
        localObject = this._parser.getCurrentToken();
        this._hasNextChecked = true;
        if (localObject != null) {
          break label75;
        }
        localObject = this._parser.nextToken();
        if (localObject != null) {
          break;
        }
        localObject = this._parser;
        this._parser = null;
      } while (!this._closeParser);
      ((JsonParser)localObject).close();
      return false;
    } while (localObject == JsonToken.END_ARRAY);
    label75:
    return true;
  }
  
  public Object next()
  {
    try
    {
      Object localObject = nextValue();
      return localObject;
    }
    catch (JsonMappingException localJsonMappingException)
    {
      throw new RuntimeJsonMappingException(localJsonMappingException.getMessage(), localJsonMappingException);
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException.getMessage(), localIOException);
    }
  }
  
  public Object nextValue()
  {
    if ((!this._hasNextChecked) && (!hasNextValue())) {
      throw new NoSuchElementException();
    }
    if (this._parser == null) {
      throw new NoSuchElementException();
    }
    this._hasNextChecked = false;
    if (this._updatedValue == null) {}
    for (Object localObject = this._deserializer.deserialize(this._parser, this._context);; localObject = this._updatedValue)
    {
      this._parser.clearCurrentToken();
      return localObject;
      this._deserializer.deserialize(this._parser, this._context, this._updatedValue);
    }
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/MappingIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */