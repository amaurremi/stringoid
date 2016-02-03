package com.flurry.org.codehaus.jackson.map;

import com.flurry.org.codehaus.jackson.JsonFactory;
import com.flurry.org.codehaus.jackson.format.InputAccessor;
import com.flurry.org.codehaus.jackson.format.MatchStrength;
import java.io.IOException;

public class MappingJsonFactory
  extends JsonFactory
{
  public MappingJsonFactory()
  {
    this(null);
  }
  
  public MappingJsonFactory(ObjectMapper paramObjectMapper)
  {
    super(paramObjectMapper);
    if (paramObjectMapper == null) {
      setCodec(new ObjectMapper(this));
    }
  }
  
  public final ObjectMapper getCodec()
  {
    return (ObjectMapper)this._objectCodec;
  }
  
  public String getFormatName()
  {
    return "JSON";
  }
  
  public MatchStrength hasFormat(InputAccessor paramInputAccessor)
    throws IOException
  {
    return hasJSONFormat(paramInputAccessor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/MappingJsonFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */