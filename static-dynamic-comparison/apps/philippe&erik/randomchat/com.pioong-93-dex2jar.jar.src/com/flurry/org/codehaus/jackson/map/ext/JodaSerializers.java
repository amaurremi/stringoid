package com.flurry.org.codehaus.jackson.map.ext;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.SerializationConfig.Feature;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.ser.std.SerializerBase;
import com.flurry.org.codehaus.jackson.map.ser.std.ToStringSerializer;
import com.flurry.org.codehaus.jackson.map.util.Provider;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import org.joda.time.DateMidnight;
import org.joda.time.DateMidnight.Property;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDate.Property;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalDateTime.Property;
import org.joda.time.Period;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class JodaSerializers
  implements Provider<Map.Entry<Class<?>, JsonSerializer<?>>>
{
  static final HashMap<Class<?>, JsonSerializer<?>> _serializers = new HashMap();
  
  static
  {
    _serializers.put(DateTime.class, new DateTimeSerializer());
    _serializers.put(LocalDateTime.class, new LocalDateTimeSerializer());
    _serializers.put(LocalDate.class, new LocalDateSerializer());
    _serializers.put(DateMidnight.class, new DateMidnightSerializer());
    _serializers.put(Period.class, ToStringSerializer.instance);
  }
  
  public Collection<Map.Entry<Class<?>, JsonSerializer<?>>> provide()
  {
    return _serializers.entrySet();
  }
  
  public static final class DateMidnightSerializer
    extends JodaSerializers.JodaSerializer<DateMidnight>
  {
    public DateMidnightSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS)) {}
      for (paramSerializerProvider = "array";; paramSerializerProvider = "string") {
        return createSchemaNode(paramSerializerProvider, true);
      }
    }
    
    public void serialize(DateMidnight paramDateMidnight, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS))
      {
        paramJsonGenerator.writeStartArray();
        paramJsonGenerator.writeNumber(paramDateMidnight.year().get());
        paramJsonGenerator.writeNumber(paramDateMidnight.monthOfYear().get());
        paramJsonGenerator.writeNumber(paramDateMidnight.dayOfMonth().get());
        paramJsonGenerator.writeEndArray();
        return;
      }
      paramJsonGenerator.writeString(printLocalDate(paramDateMidnight));
    }
  }
  
  public static final class DateTimeSerializer
    extends JodaSerializers.JodaSerializer<DateTime>
  {
    public DateTimeSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS)) {}
      for (paramSerializerProvider = "number";; paramSerializerProvider = "string") {
        return createSchemaNode(paramSerializerProvider, true);
      }
    }
    
    public void serialize(DateTime paramDateTime, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS))
      {
        paramJsonGenerator.writeNumber(paramDateTime.getMillis());
        return;
      }
      paramJsonGenerator.writeString(paramDateTime.toString());
    }
  }
  
  protected static abstract class JodaSerializer<T>
    extends SerializerBase<T>
  {
    static final DateTimeFormatter _localDateFormat = ISODateTimeFormat.date();
    static final DateTimeFormatter _localDateTimeFormat = ;
    
    protected JodaSerializer(Class<T> paramClass)
    {
      super();
    }
    
    protected String printLocalDate(ReadableInstant paramReadableInstant)
      throws IOException, JsonProcessingException
    {
      return _localDateFormat.print(paramReadableInstant);
    }
    
    protected String printLocalDate(ReadablePartial paramReadablePartial)
      throws IOException, JsonProcessingException
    {
      return _localDateFormat.print(paramReadablePartial);
    }
    
    protected String printLocalDateTime(ReadablePartial paramReadablePartial)
      throws IOException, JsonProcessingException
    {
      return _localDateTimeFormat.print(paramReadablePartial);
    }
  }
  
  public static final class LocalDateSerializer
    extends JodaSerializers.JodaSerializer<LocalDate>
  {
    public LocalDateSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS)) {}
      for (paramSerializerProvider = "array";; paramSerializerProvider = "string") {
        return createSchemaNode(paramSerializerProvider, true);
      }
    }
    
    public void serialize(LocalDate paramLocalDate, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS))
      {
        paramJsonGenerator.writeStartArray();
        paramJsonGenerator.writeNumber(paramLocalDate.year().get());
        paramJsonGenerator.writeNumber(paramLocalDate.monthOfYear().get());
        paramJsonGenerator.writeNumber(paramLocalDate.dayOfMonth().get());
        paramJsonGenerator.writeEndArray();
        return;
      }
      paramJsonGenerator.writeString(printLocalDate(paramLocalDate));
    }
  }
  
  public static final class LocalDateTimeSerializer
    extends JodaSerializers.JodaSerializer<LocalDateTime>
  {
    public LocalDateTimeSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    {
      if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS)) {}
      for (paramSerializerProvider = "array";; paramSerializerProvider = "string") {
        return createSchemaNode(paramSerializerProvider, true);
      }
    }
    
    public void serialize(LocalDateTime paramLocalDateTime, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      if (paramSerializerProvider.isEnabled(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS))
      {
        paramJsonGenerator.writeStartArray();
        paramJsonGenerator.writeNumber(paramLocalDateTime.year().get());
        paramJsonGenerator.writeNumber(paramLocalDateTime.monthOfYear().get());
        paramJsonGenerator.writeNumber(paramLocalDateTime.dayOfMonth().get());
        paramJsonGenerator.writeNumber(paramLocalDateTime.hourOfDay().get());
        paramJsonGenerator.writeNumber(paramLocalDateTime.minuteOfHour().get());
        paramJsonGenerator.writeNumber(paramLocalDateTime.secondOfMinute().get());
        paramJsonGenerator.writeNumber(paramLocalDateTime.millisOfSecond().get());
        paramJsonGenerator.writeEndArray();
        return;
      }
      paramJsonGenerator.writeString(printLocalDateTime(paramLocalDateTime));
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ext/JodaSerializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */