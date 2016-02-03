package org.codehaus.jackson.map.deser.std;

public abstract class StdDeserializer$PrimitiveOrWrapperDeserializer
  extends StdScalarDeserializer
{
  final Object _nullValue;
  
  protected StdDeserializer$PrimitiveOrWrapperDeserializer(Class paramClass, Object paramObject)
  {
    super(paramClass);
    this._nullValue = paramObject;
  }
  
  public final Object getNullValue()
  {
    return this._nullValue;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/std/StdDeserializer$PrimitiveOrWrapperDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */