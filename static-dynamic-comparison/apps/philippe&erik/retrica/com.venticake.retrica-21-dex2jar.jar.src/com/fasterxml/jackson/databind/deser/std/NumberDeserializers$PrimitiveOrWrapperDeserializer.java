package com.fasterxml.jackson.databind.deser.std;

public abstract class NumberDeserializers$PrimitiveOrWrapperDeserializer<T>
  extends StdScalarDeserializer<T>
{
  protected final T _nullValue;
  
  protected NumberDeserializers$PrimitiveOrWrapperDeserializer(Class<T> paramClass, T paramT)
  {
    super(paramClass);
    this._nullValue = paramT;
  }
  
  public final T getNullValue()
  {
    return (T)this._nullValue;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/NumberDeserializers$PrimitiveOrWrapperDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */