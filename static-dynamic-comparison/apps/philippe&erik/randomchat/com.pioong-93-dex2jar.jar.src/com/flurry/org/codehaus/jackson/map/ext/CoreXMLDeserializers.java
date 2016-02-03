package com.flurry.org.codehaus.jackson.map.ext;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.deser.std.FromStringDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.StdScalarDeserializer;
import com.flurry.org.codehaus.jackson.map.util.Provider;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

public class CoreXMLDeserializers
  implements Provider<StdDeserializer<?>>
{
  static final DatatypeFactory _dataTypeFactory;
  
  static
  {
    try
    {
      _dataTypeFactory = DatatypeFactory.newInstance();
      return;
    }
    catch (DatatypeConfigurationException localDatatypeConfigurationException)
    {
      throw new RuntimeException(localDatatypeConfigurationException);
    }
  }
  
  public Collection<StdDeserializer<?>> provide()
  {
    return Arrays.asList(new StdDeserializer[] { new DurationDeserializer(), new GregorianCalendarDeserializer(), new QNameDeserializer() });
  }
  
  public static class DurationDeserializer
    extends FromStringDeserializer<Duration>
  {
    public DurationDeserializer()
    {
      super();
    }
    
    protected Duration _deserialize(String paramString, DeserializationContext paramDeserializationContext)
      throws IllegalArgumentException
    {
      return CoreXMLDeserializers._dataTypeFactory.newDuration(paramString);
    }
  }
  
  public static class GregorianCalendarDeserializer
    extends StdScalarDeserializer<XMLGregorianCalendar>
  {
    public GregorianCalendarDeserializer()
    {
      super();
    }
    
    public XMLGregorianCalendar deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      paramJsonParser = _parseDate(paramJsonParser, paramDeserializationContext);
      if (paramJsonParser == null) {
        return null;
      }
      paramDeserializationContext = new GregorianCalendar();
      paramDeserializationContext.setTime(paramJsonParser);
      return CoreXMLDeserializers._dataTypeFactory.newXMLGregorianCalendar(paramDeserializationContext);
    }
  }
  
  public static class QNameDeserializer
    extends FromStringDeserializer<QName>
  {
    public QNameDeserializer()
    {
      super();
    }
    
    protected QName _deserialize(String paramString, DeserializationContext paramDeserializationContext)
      throws IllegalArgumentException
    {
      return QName.valueOf(paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/flurry/org/codehaus/jackson/map/ext/CoreXMLDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */