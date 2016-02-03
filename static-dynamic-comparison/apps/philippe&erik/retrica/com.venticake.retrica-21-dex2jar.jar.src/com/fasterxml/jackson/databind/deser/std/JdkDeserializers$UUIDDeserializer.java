package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.UUID;

public class JdkDeserializers$UUIDDeserializer
  extends FromStringDeserializer<UUID>
{
  public JdkDeserializers$UUIDDeserializer()
  {
    super(UUID.class);
  }
  
  protected UUID _deserialize(String paramString, DeserializationContext paramDeserializationContext)
  {
    return UUID.fromString(paramString);
  }
  
  protected UUID _deserializeEmbedded(Object paramObject, DeserializationContext paramDeserializationContext)
  {
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      if (paramObject.length != 16) {
        paramDeserializationContext.mappingException("Can only construct UUIDs from 16 byte arrays; got " + paramObject.length + " bytes");
      }
      paramObject = new DataInputStream(new ByteArrayInputStream((byte[])paramObject));
      return new UUID(((DataInputStream)paramObject).readLong(), ((DataInputStream)paramObject).readLong());
    }
    super._deserializeEmbedded(paramObject, paramDeserializationContext);
    return null;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/JdkDeserializers$UUIDDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */