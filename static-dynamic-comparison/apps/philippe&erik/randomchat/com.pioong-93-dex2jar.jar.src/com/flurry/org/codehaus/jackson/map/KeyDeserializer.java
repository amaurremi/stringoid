package com.flurry.org.codehaus.jackson.map;

import com.flurry.org.codehaus.jackson.JsonProcessingException;
import java.io.IOException;

public abstract class KeyDeserializer
{
  public abstract Object deserializeKey(String paramString, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException;
  
  public static abstract class None
    extends KeyDeserializer
  {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/KeyDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */