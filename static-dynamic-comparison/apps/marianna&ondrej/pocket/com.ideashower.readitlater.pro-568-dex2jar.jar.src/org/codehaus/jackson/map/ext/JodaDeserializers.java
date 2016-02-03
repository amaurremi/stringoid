package org.codehaus.jackson.map.ext;

import java.util.Arrays;
import java.util.Collection;
import org.codehaus.jackson.map.deser.std.StdDeserializer;
import org.codehaus.jackson.map.util.Provider;
import org.joda.time.DateTime;
import org.joda.time.ReadableDateTime;
import org.joda.time.ReadableInstant;

public class JodaDeserializers
  implements Provider
{
  public Collection provide()
  {
    return Arrays.asList(new StdDeserializer[] { new JodaDeserializers.DateTimeDeserializer(DateTime.class), new JodaDeserializers.DateTimeDeserializer(ReadableDateTime.class), new JodaDeserializers.DateTimeDeserializer(ReadableInstant.class), new JodaDeserializers.LocalDateDeserializer(), new JodaDeserializers.LocalDateTimeDeserializer(), new JodaDeserializers.DateMidnightDeserializer(), new JodaDeserializers.PeriodDeserializer() });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/JodaDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */