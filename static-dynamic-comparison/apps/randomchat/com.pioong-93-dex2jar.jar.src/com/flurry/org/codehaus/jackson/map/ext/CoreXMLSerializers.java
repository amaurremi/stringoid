package com.flurry.org.codehaus.jackson.map.ext;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.ser.std.CalendarSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.SerializerBase;
import com.flurry.org.codehaus.jackson.map.ser.std.ToStringSerializer;
import com.flurry.org.codehaus.jackson.map.util.Provider;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

public class CoreXMLSerializers
  implements Provider<Map.Entry<Class<?>, JsonSerializer<?>>>
{
  static final HashMap<Class<?>, JsonSerializer<?>> _serializers = new HashMap();
  
  static
  {
    ToStringSerializer localToStringSerializer = ToStringSerializer.instance;
    _serializers.put(Duration.class, localToStringSerializer);
    _serializers.put(XMLGregorianCalendar.class, new XMLGregorianCalendarSerializer());
    _serializers.put(QName.class, localToStringSerializer);
  }
  
  public Collection<Map.Entry<Class<?>, JsonSerializer<?>>> provide()
  {
    return _serializers.entrySet();
  }
  
  public static class XMLGregorianCalendarSerializer
    extends SerializerBase<XMLGregorianCalendar>
  {
    public XMLGregorianCalendarSerializer()
    {
      super();
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
      throws JsonMappingException
    {
      return CalendarSerializer.instance.getSchema(paramSerializerProvider, paramType);
    }
    
    public void serialize(XMLGregorianCalendar paramXMLGregorianCalendar, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      CalendarSerializer.instance.serialize(paramXMLGregorianCalendar.toGregorianCalendar(), paramJsonGenerator, paramSerializerProvider);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ext/CoreXMLSerializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */