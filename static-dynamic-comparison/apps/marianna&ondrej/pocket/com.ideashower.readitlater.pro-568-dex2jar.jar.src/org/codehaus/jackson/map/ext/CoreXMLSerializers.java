package org.codehaus.jackson.map.ext;

import java.util.Collection;
import java.util.HashMap;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.codehaus.jackson.map.ser.std.ToStringSerializer;
import org.codehaus.jackson.map.util.Provider;

public class CoreXMLSerializers
  implements Provider
{
  static final HashMap _serializers = new HashMap();
  
  static
  {
    ToStringSerializer localToStringSerializer = ToStringSerializer.instance;
    _serializers.put(Duration.class, localToStringSerializer);
    _serializers.put(XMLGregorianCalendar.class, new CoreXMLSerializers.XMLGregorianCalendarSerializer());
    _serializers.put(QName.class, localToStringSerializer);
  }
  
  public Collection provide()
  {
    return _serializers.entrySet();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/CoreXMLSerializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */