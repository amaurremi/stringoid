package org.codehaus.jackson.map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.format.InputAccessor;
import org.codehaus.jackson.format.MatchStrength;

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
  {
    return hasJSONFormat(paramInputAccessor);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/MappingJsonFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */