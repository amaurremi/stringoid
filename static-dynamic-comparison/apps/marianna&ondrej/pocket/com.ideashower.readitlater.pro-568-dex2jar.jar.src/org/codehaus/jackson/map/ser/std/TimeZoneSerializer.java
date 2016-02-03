package org.codehaus.jackson.map.ser.std;

import java.util.TimeZone;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;

public class TimeZoneSerializer
  extends ScalarSerializerBase
{
  public static final TimeZoneSerializer instance = new TimeZoneSerializer();
  
  public TimeZoneSerializer()
  {
    super(TimeZone.class);
  }
  
  public void serialize(TimeZone paramTimeZone, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
  {
    paramJsonGenerator.writeString(paramTimeZone.getID());
  }
  
  public void serializeWithType(TimeZone paramTimeZone, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
  {
    paramTypeSerializer.writeTypePrefixForScalar(paramTimeZone, paramJsonGenerator, TimeZone.class);
    serialize(paramTimeZone, paramJsonGenerator, paramSerializerProvider);
    paramTypeSerializer.writeTypeSuffixForScalar(paramTimeZone, paramJsonGenerator);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ser/std/TimeZoneSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */