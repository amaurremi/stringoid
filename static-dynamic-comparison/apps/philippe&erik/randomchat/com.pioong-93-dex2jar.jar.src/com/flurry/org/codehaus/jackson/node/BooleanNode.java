package com.flurry.org.codehaus.jackson.node;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import java.io.IOException;

public final class BooleanNode
  extends ValueNode
{
  public static final BooleanNode FALSE = new BooleanNode();
  public static final BooleanNode TRUE = new BooleanNode();
  
  public static BooleanNode getFalse()
  {
    return FALSE;
  }
  
  public static BooleanNode getTrue()
  {
    return TRUE;
  }
  
  public static BooleanNode valueOf(boolean paramBoolean)
  {
    if (paramBoolean) {
      return TRUE;
    }
    return FALSE;
  }
  
  public boolean asBoolean()
  {
    return this == TRUE;
  }
  
  public boolean asBoolean(boolean paramBoolean)
  {
    return this == TRUE;
  }
  
  public double asDouble(double paramDouble)
  {
    if (this == TRUE) {
      return 1.0D;
    }
    return 0.0D;
  }
  
  public int asInt(int paramInt)
  {
    if (this == TRUE) {
      return 1;
    }
    return 0;
  }
  
  public long asLong(long paramLong)
  {
    if (this == TRUE) {
      return 1L;
    }
    return 0L;
  }
  
  public String asText()
  {
    if (this == TRUE) {
      return "true";
    }
    return "false";
  }
  
  public JsonToken asToken()
  {
    if (this == TRUE) {
      return JsonToken.VALUE_TRUE;
    }
    return JsonToken.VALUE_FALSE;
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject == this;
  }
  
  public boolean getBooleanValue()
  {
    return this == TRUE;
  }
  
  public boolean isBoolean()
  {
    return true;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    if (this == TRUE) {}
    for (boolean bool = true;; bool = false)
    {
      paramJsonGenerator.writeBoolean(bool);
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/node/BooleanNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */