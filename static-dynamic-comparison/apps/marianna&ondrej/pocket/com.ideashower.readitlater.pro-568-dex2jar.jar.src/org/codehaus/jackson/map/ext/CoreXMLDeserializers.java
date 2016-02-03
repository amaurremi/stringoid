package org.codehaus.jackson.map.ext;

import java.util.Arrays;
import java.util.Collection;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import org.codehaus.jackson.map.deser.std.StdDeserializer;
import org.codehaus.jackson.map.util.Provider;

public class CoreXMLDeserializers
  implements Provider
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
  
  public Collection provide()
  {
    return Arrays.asList(new StdDeserializer[] { new CoreXMLDeserializers.DurationDeserializer(), new CoreXMLDeserializers.GregorianCalendarDeserializer(), new CoreXMLDeserializers.QNameDeserializer() });
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/CoreXMLDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */