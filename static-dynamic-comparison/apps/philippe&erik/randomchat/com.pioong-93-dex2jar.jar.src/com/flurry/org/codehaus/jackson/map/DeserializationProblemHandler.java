package com.flurry.org.codehaus.jackson.map;

import com.flurry.org.codehaus.jackson.JsonProcessingException;
import java.io.IOException;

public abstract class DeserializationProblemHandler
{
  public boolean handleUnknownProperty(DeserializationContext paramDeserializationContext, JsonDeserializer<?> paramJsonDeserializer, Object paramObject, String paramString)
    throws IOException, JsonProcessingException
  {
    return false;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/DeserializationProblemHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */