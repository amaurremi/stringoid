package org.codehaus.jackson.map.deser;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import org.codehaus.jackson.map.deser.std.AtomicBooleanDeserializer;
import org.codehaus.jackson.map.deser.std.CalendarDeserializer;
import org.codehaus.jackson.map.deser.std.ClassDeserializer;
import org.codehaus.jackson.map.deser.std.DateDeserializer;
import org.codehaus.jackson.map.deser.std.FromStringDeserializer;
import org.codehaus.jackson.map.deser.std.JavaTypeDeserializer;
import org.codehaus.jackson.map.deser.std.StdDeserializer;
import org.codehaus.jackson.map.deser.std.StdDeserializer.BigDecimalDeserializer;
import org.codehaus.jackson.map.deser.std.StdDeserializer.BigIntegerDeserializer;
import org.codehaus.jackson.map.deser.std.StdDeserializer.BooleanDeserializer;
import org.codehaus.jackson.map.deser.std.StdDeserializer.ByteDeserializer;
import org.codehaus.jackson.map.deser.std.StdDeserializer.CharacterDeserializer;
import org.codehaus.jackson.map.deser.std.StdDeserializer.DoubleDeserializer;
import org.codehaus.jackson.map.deser.std.StdDeserializer.FloatDeserializer;
import org.codehaus.jackson.map.deser.std.StdDeserializer.IntegerDeserializer;
import org.codehaus.jackson.map.deser.std.StdDeserializer.LongDeserializer;
import org.codehaus.jackson.map.deser.std.StdDeserializer.NumberDeserializer;
import org.codehaus.jackson.map.deser.std.StdDeserializer.ShortDeserializer;
import org.codehaus.jackson.map.deser.std.StdDeserializer.SqlDateDeserializer;
import org.codehaus.jackson.map.deser.std.StdDeserializer.StackTraceElementDeserializer;
import org.codehaus.jackson.map.deser.std.StringDeserializer;
import org.codehaus.jackson.map.deser.std.TimestampDeserializer;
import org.codehaus.jackson.map.deser.std.TokenBufferDeserializer;
import org.codehaus.jackson.map.deser.std.UntypedObjectDeserializer;
import org.codehaus.jackson.map.type.ClassKey;

class StdDeserializers
{
  final HashMap _deserializers = new HashMap();
  
  private StdDeserializers()
  {
    add(new UntypedObjectDeserializer());
    Object localObject = new StringDeserializer();
    add((StdDeserializer)localObject, String.class);
    add((StdDeserializer)localObject, CharSequence.class);
    add(new ClassDeserializer());
    add(new StdDeserializer.BooleanDeserializer(Boolean.class, null));
    add(new StdDeserializer.ByteDeserializer(Byte.class, null));
    add(new StdDeserializer.ShortDeserializer(Short.class, null));
    add(new StdDeserializer.CharacterDeserializer(Character.class, null));
    add(new StdDeserializer.IntegerDeserializer(Integer.class, null));
    add(new StdDeserializer.LongDeserializer(Long.class, null));
    add(new StdDeserializer.FloatDeserializer(Float.class, null));
    add(new StdDeserializer.DoubleDeserializer(Double.class, null));
    add(new StdDeserializer.BooleanDeserializer(Boolean.TYPE, Boolean.FALSE));
    add(new StdDeserializer.ByteDeserializer(Byte.TYPE, Byte.valueOf((byte)0)));
    add(new StdDeserializer.ShortDeserializer(Short.TYPE, Short.valueOf((short)0)));
    add(new StdDeserializer.CharacterDeserializer(Character.TYPE, Character.valueOf('\000')));
    add(new StdDeserializer.IntegerDeserializer(Integer.TYPE, Integer.valueOf(0)));
    add(new StdDeserializer.LongDeserializer(Long.TYPE, Long.valueOf(0L)));
    add(new StdDeserializer.FloatDeserializer(Float.TYPE, Float.valueOf(0.0F)));
    add(new StdDeserializer.DoubleDeserializer(Double.TYPE, Double.valueOf(0.0D)));
    add(new StdDeserializer.NumberDeserializer());
    add(new StdDeserializer.BigDecimalDeserializer());
    add(new StdDeserializer.BigIntegerDeserializer());
    add(new CalendarDeserializer());
    add(new DateDeserializer());
    add(new CalendarDeserializer(GregorianCalendar.class), GregorianCalendar.class);
    add(new StdDeserializer.SqlDateDeserializer());
    add(new TimestampDeserializer());
    localObject = FromStringDeserializer.all().iterator();
    while (((Iterator)localObject).hasNext()) {
      add((FromStringDeserializer)((Iterator)localObject).next());
    }
    add(new StdDeserializer.StackTraceElementDeserializer());
    add(new AtomicBooleanDeserializer());
    add(new TokenBufferDeserializer());
    add(new JavaTypeDeserializer());
  }
  
  private void add(StdDeserializer paramStdDeserializer)
  {
    add(paramStdDeserializer, paramStdDeserializer.getValueClass());
  }
  
  private void add(StdDeserializer paramStdDeserializer, Class paramClass)
  {
    this._deserializers.put(new ClassKey(paramClass), paramStdDeserializer);
  }
  
  public static HashMap constructAll()
  {
    return new StdDeserializers()._deserializers;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/deser/StdDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */