package com.flurry.org.codehaus.jackson.map.ext;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.StdScalarDeserializer;
import com.flurry.org.codehaus.jackson.map.util.Provider;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.joda.time.ReadableDateTime;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePeriod;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class JodaDeserializers
  implements Provider<StdDeserializer<?>>
{
  public Collection<StdDeserializer<?>> provide()
  {
    return Arrays.asList(new StdDeserializer[] { new DateTimeDeserializer(DateTime.class), new DateTimeDeserializer(ReadableDateTime.class), new DateTimeDeserializer(ReadableInstant.class), new LocalDateDeserializer(), new LocalDateTimeDeserializer(), new DateMidnightDeserializer(), new PeriodDeserializer() });
  }
  
  public static class DateMidnightDeserializer
    extends JodaDeserializers.JodaDeserializer<DateMidnight>
  {
    public DateMidnightDeserializer()
    {
      super();
    }
    
    public DateMidnight deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (paramJsonParser.isExpectedStartArrayToken())
      {
        paramJsonParser.nextToken();
        int i = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int j = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int k = paramJsonParser.getIntValue();
        if (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
          throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "after DateMidnight ints");
        }
        return new DateMidnight(i, j, k);
      }
      switch (JodaDeserializers.1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
      {
      default: 
        throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.START_ARRAY, "expected JSON Array, Number or String");
      case 1: 
        return new DateMidnight(paramJsonParser.getLongValue());
      }
      paramJsonParser = parseLocal(paramJsonParser);
      if (paramJsonParser == null) {
        return null;
      }
      return paramJsonParser.toDateMidnight();
    }
  }
  
  public static class DateTimeDeserializer<T extends ReadableInstant>
    extends JodaDeserializers.JodaDeserializer<T>
  {
    public DateTimeDeserializer(Class<T> paramClass)
    {
      super();
    }
    
    public T deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      JsonToken localJsonToken = paramJsonParser.getCurrentToken();
      if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
        return new DateTime(paramJsonParser.getLongValue(), DateTimeZone.UTC);
      }
      if (localJsonToken == JsonToken.VALUE_STRING)
      {
        paramJsonParser = paramJsonParser.getText().trim();
        if (paramJsonParser.length() == 0) {
          return null;
        }
        return new DateTime(paramJsonParser, DateTimeZone.UTC);
      }
      throw paramDeserializationContext.mappingException(getValueClass());
    }
  }
  
  static abstract class JodaDeserializer<T>
    extends StdScalarDeserializer<T>
  {
    static final DateTimeFormatter _localDateTimeFormat = ;
    
    protected JodaDeserializer(Class<T> paramClass)
    {
      super();
    }
    
    protected DateTime parseLocal(JsonParser paramJsonParser)
      throws IOException, JsonProcessingException
    {
      paramJsonParser = paramJsonParser.getText().trim();
      if (paramJsonParser.length() == 0) {
        return null;
      }
      return _localDateTimeFormat.parseDateTime(paramJsonParser);
    }
  }
  
  public static class LocalDateDeserializer
    extends JodaDeserializers.JodaDeserializer<LocalDate>
  {
    public LocalDateDeserializer()
    {
      super();
    }
    
    public LocalDate deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (paramJsonParser.isExpectedStartArrayToken())
      {
        paramJsonParser.nextToken();
        int i = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int j = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int k = paramJsonParser.getIntValue();
        if (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
          throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "after LocalDate ints");
        }
        return new LocalDate(i, j, k);
      }
      switch (JodaDeserializers.1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
      {
      default: 
        throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.START_ARRAY, "expected JSON Array, String or Number");
      case 1: 
        return new LocalDate(paramJsonParser.getLongValue());
      }
      paramJsonParser = parseLocal(paramJsonParser);
      if (paramJsonParser == null) {
        return null;
      }
      return paramJsonParser.toLocalDate();
    }
  }
  
  public static class LocalDateTimeDeserializer
    extends JodaDeserializers.JodaDeserializer<LocalDateTime>
  {
    public LocalDateTimeDeserializer()
    {
      super();
    }
    
    public LocalDateTime deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      if (paramJsonParser.isExpectedStartArrayToken())
      {
        paramJsonParser.nextToken();
        int j = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int k = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int m = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int n = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int i1 = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
        int i2 = paramJsonParser.getIntValue();
        int i = 0;
        if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
        {
          i = paramJsonParser.getIntValue();
          paramJsonParser.nextToken();
        }
        if (paramJsonParser.getCurrentToken() != JsonToken.END_ARRAY) {
          throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "after LocalDateTime ints");
        }
        return new LocalDateTime(j, k, m, n, i1, i2, i);
      }
      switch (JodaDeserializers.1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
      {
      default: 
        throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.START_ARRAY, "expected JSON Array or Number");
      case 1: 
        return new LocalDateTime(paramJsonParser.getLongValue());
      }
      paramJsonParser = parseLocal(paramJsonParser);
      if (paramJsonParser == null) {
        return null;
      }
      return paramJsonParser.toLocalDateTime();
    }
  }
  
  public static class PeriodDeserializer
    extends JodaDeserializers.JodaDeserializer<ReadablePeriod>
  {
    public PeriodDeserializer()
    {
      super();
    }
    
    public ReadablePeriod deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      switch (JodaDeserializers.1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
      {
      default: 
        throw paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.START_ARRAY, "expected JSON Number or String");
      case 1: 
        return new Period(paramJsonParser.getLongValue());
      }
      return new Period(paramJsonParser.getText());
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ext/JodaDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */