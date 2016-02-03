package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;
import java.io.InputStream;

public class ZephyrParserFactory
  extends XMLInputFactory
{
  boolean fPropertyChanged = false;
  private PropertyManager fPropertyManager = new PropertyManager(1);
  boolean fReuseInstance = false;
  private XMLReaderImpl fTempReader = null;
  
  public XMLEventReader createXMLEventReader(InputStream paramInputStream)
  {
    initEventReader();
    return new XMLEventReaderImpl(createXMLStreamReader(paramInputStream));
  }
  
  public XMLStreamReader createXMLStreamReader(InputStream paramInputStream)
  {
    return createXMLStreamReader(null, paramInputStream, null);
  }
  
  public XMLStreamReader createXMLStreamReader(String paramString1, InputStream paramInputStream, String paramString2)
  {
    return getXMLStreamReaderImpl(new XMLInputSource(null, paramString1, null, paramInputStream, paramString2));
  }
  
  XMLStreamReader getXMLStreamReaderImpl(XMLInputSource paramXMLInputSource)
  {
    if (this.fTempReader == null)
    {
      this.fPropertyChanged = false;
      paramXMLInputSource = new XMLReaderImpl(paramXMLInputSource, new PropertyManager(this.fPropertyManager));
      this.fTempReader = paramXMLInputSource;
      return paramXMLInputSource;
    }
    if ((this.fReuseInstance) && (this.fTempReader.canReuse()) && (!this.fPropertyChanged))
    {
      this.fTempReader.reset();
      this.fTempReader.setInputSource(paramXMLInputSource);
      this.fPropertyChanged = false;
      return this.fTempReader;
    }
    this.fPropertyChanged = false;
    paramXMLInputSource = new XMLReaderImpl(paramXMLInputSource, new PropertyManager(this.fPropertyManager));
    this.fTempReader = paramXMLInputSource;
    return paramXMLInputSource;
  }
  
  void initEventReader()
  {
    this.fPropertyChanged = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/ZephyrParserFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */