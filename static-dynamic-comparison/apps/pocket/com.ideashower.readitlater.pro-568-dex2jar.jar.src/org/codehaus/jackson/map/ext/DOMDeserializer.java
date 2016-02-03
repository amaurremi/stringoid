package org.codehaus.jackson.map.ext;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.std.FromStringDeserializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public abstract class DOMDeserializer
  extends FromStringDeserializer
{
  static final DocumentBuilderFactory _parserFactory = ;
  
  static
  {
    _parserFactory.setNamespaceAware(true);
  }
  
  protected DOMDeserializer(Class paramClass)
  {
    super(paramClass);
  }
  
  public abstract Object _deserialize(String paramString, DeserializationContext paramDeserializationContext);
  
  protected final Document parse(String paramString)
  {
    try
    {
      paramString = _parserFactory.newDocumentBuilder().parse(new InputSource(new StringReader(paramString)));
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new IllegalArgumentException("Failed to parse JSON String as XML: " + paramString.getMessage(), paramString);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/org/codehaus/jackson/map/ext/DOMDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */