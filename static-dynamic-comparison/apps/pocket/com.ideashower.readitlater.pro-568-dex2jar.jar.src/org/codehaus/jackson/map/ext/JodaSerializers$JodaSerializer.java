package org.codehaus.jackson.map.ext;

import org.codehaus.jackson.map.ser.std.SerializerBase;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public abstract class JodaSerializers$JodaSerializer
  extends SerializerBase
{
  static final DateTimeFormatter _localDateFormat = ISODateTimeFormat.date();
  static final DateTimeFormatter _localDateTimeFormat = ;
  
  protected JodaSerializers$JodaSerializer(Class paramClass)
  {
    super(paramClass);
  }
  
  protected String printLocalDate(ReadableInstant paramReadableInstant)
  {
    return _localDateFormat.print(paramReadableInstant);
  }
  
  protected String printLocalDate(ReadablePartial paramReadablePartial)
  {
    return _localDateFormat.print(paramReadablePartial);
  }
  
  protected String printLocalDateTime(ReadablePartial paramReadablePartial)
  {
    return _localDateTimeFormat.print(paramReadablePartial);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/JodaSerializers$JodaSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */