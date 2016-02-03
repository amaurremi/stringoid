package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

public class DateDeserializers$TimestampDeserializer
  extends DateDeserializers.DateBasedDeserializer<Timestamp>
{
  public DateDeserializers$TimestampDeserializer()
  {
    super(Timestamp.class);
  }
  
  public DateDeserializers$TimestampDeserializer(TimestampDeserializer paramTimestampDeserializer, DateFormat paramDateFormat, String paramString)
  {
    super(paramTimestampDeserializer, paramDateFormat, paramString);
  }
  
  public Timestamp deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    return new Timestamp(_parseDate(paramJsonParser, paramDeserializationContext).getTime());
  }
  
  protected TimestampDeserializer withDateFormat(DateFormat paramDateFormat, String paramString)
  {
    return new TimestampDeserializer(this, paramDateFormat, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/DateDeserializers$TimestampDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */