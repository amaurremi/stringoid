package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.text.DateFormat;
import java.util.Date;

public class DateDeserializers$DateDeserializer
  extends DateDeserializers.DateBasedDeserializer<Date>
{
  public DateDeserializers$DateDeserializer()
  {
    super(Date.class);
  }
  
  public DateDeserializers$DateDeserializer(DateDeserializer paramDateDeserializer, DateFormat paramDateFormat, String paramString)
  {
    super(paramDateDeserializer, paramDateFormat, paramString);
  }
  
  public Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    return _parseDate(paramJsonParser, paramDeserializationContext);
  }
  
  protected DateDeserializer withDateFormat(DateFormat paramDateFormat, String paramString)
  {
    return new DateDeserializer(this, paramDateFormat, paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/fasterxml/jackson/databind/deser/std/DateDeserializers$DateDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */