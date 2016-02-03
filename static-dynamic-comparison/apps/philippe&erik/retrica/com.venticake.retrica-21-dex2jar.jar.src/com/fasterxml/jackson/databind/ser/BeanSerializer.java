package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.impl.BeanAsArraySerializer;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanSerializer;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;

public class BeanSerializer
  extends BeanSerializerBase
{
  public BeanSerializer(JavaType paramJavaType, BeanSerializerBuilder paramBeanSerializerBuilder, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter1, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter2)
  {
    super(paramJavaType, paramBeanSerializerBuilder, paramArrayOfBeanPropertyWriter1, paramArrayOfBeanPropertyWriter2);
  }
  
  protected BeanSerializer(BeanSerializerBase paramBeanSerializerBase, ObjectIdWriter paramObjectIdWriter)
  {
    super(paramBeanSerializerBase, paramObjectIdWriter);
  }
  
  protected BeanSerializer(BeanSerializerBase paramBeanSerializerBase, String[] paramArrayOfString)
  {
    super(paramBeanSerializerBase, paramArrayOfString);
  }
  
  public static BeanSerializer createDummy(JavaType paramJavaType)
  {
    return new BeanSerializer(paramJavaType, null, NO_PROPS, null);
  }
  
  protected BeanSerializerBase asArraySerializer()
  {
    Object localObject = this;
    if (this._objectIdWriter == null)
    {
      localObject = this;
      if (this._anyGetterWriter == null)
      {
        localObject = this;
        if (this._propertyFilterId == null) {
          localObject = new BeanAsArraySerializer(this);
        }
      }
    }
    return (BeanSerializerBase)localObject;
  }
  
  public String toString()
  {
    return "BeanSerializer for " + handledType().getName();
  }
  
  public JsonSerializer<Object> unwrappingSerializer(NameTransformer paramNameTransformer)
  {
    return new UnwrappingBeanSerializer(this, paramNameTransformer);
  }
  
  protected BeanSerializer withIgnorals(String[] paramArrayOfString)
  {
    return new BeanSerializer(this, paramArrayOfString);
  }
  
  public BeanSerializer withObjectIdWriter(ObjectIdWriter paramObjectIdWriter)
  {
    return new BeanSerializer(this, paramObjectIdWriter);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/ser/BeanSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */