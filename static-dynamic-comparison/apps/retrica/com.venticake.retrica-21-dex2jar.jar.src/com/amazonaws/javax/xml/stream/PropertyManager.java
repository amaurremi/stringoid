package com.amazonaws.javax.xml.stream;

import java.util.HashMap;

public class PropertyManager
{
  HashMap supportedProps = new HashMap();
  
  public PropertyManager(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      initConfigurableReaderProperties();
      return;
    }
    initWriterProps();
  }
  
  public PropertyManager(PropertyManager paramPropertyManager)
  {
    paramPropertyManager = paramPropertyManager.getProperties();
    this.supportedProps.putAll(paramPropertyManager);
  }
  
  private HashMap getProperties()
  {
    return this.supportedProps;
  }
  
  private void initConfigurableReaderProperties()
  {
    this.supportedProps.put("com.amazonaws.javax.xml.stream.isNamespaceAware", Boolean.TRUE);
    this.supportedProps.put("com.amazonaws.javax.xml.stream.isValidating", Boolean.FALSE);
    this.supportedProps.put("com.amazonaws.javax.xml.stream.isReplacingEntityReferences", Boolean.TRUE);
    this.supportedProps.put("com.amazonaws.javax.xml.stream.isSupportingExternalEntities", Boolean.TRUE);
    this.supportedProps.put("com.amazonaws.javax.xml.stream.isCoalescing", Boolean.FALSE);
    this.supportedProps.put("com.amazonaws.javax.xml.stream.supportDTD", Boolean.TRUE);
    this.supportedProps.put("com.amazonaws.javax.xml.stream.reporter", null);
    this.supportedProps.put("com.amazonaws.javax.xml.stream.resolver", null);
    this.supportedProps.put("com.amazonaws.javax.xml.stream.allocator", null);
    this.supportedProps.put("com.amazonaws.javax.xml.stream.notations", null);
    this.supportedProps.put("http://xml.org/sax/features/string-interning", Boolean.TRUE);
    this.supportedProps.put("http://apache.org/xml/features/allow-java-encodings", Boolean.TRUE);
    this.supportedProps.put("reuse-instance", Boolean.FALSE);
    this.supportedProps.put("http://java.sun.com/xml/stream/properties/report-cdata-event", Boolean.FALSE);
    this.supportedProps.put("http://java.sun.com/xml/stream/properties/ignore-external-dtd", Boolean.FALSE);
    this.supportedProps.put("http://apache.org/xml/features/validation/warn-on-duplicate-attdef", Boolean.FALSE);
    this.supportedProps.put("http://apache.org/xml/features/warn-on-duplicate-entitydef", Boolean.FALSE);
    this.supportedProps.put("http://apache.org/xml/features/validation/warn-on-undeclared-elemdef", Boolean.FALSE);
    this.supportedProps.put("http://java.sun.com/xml/stream/properties/implementation-name", "sjsxp");
  }
  
  private void initWriterProps()
  {
    this.supportedProps.put("com.amazonaws.javax.xml.stream.isRepairingNamespaces", Boolean.FALSE);
    this.supportedProps.put("escapeCharacters", Boolean.TRUE);
    this.supportedProps.put("reuse-instance", Boolean.FALSE);
    this.supportedProps.put("http://java.sun.com/xml/stream/properties/implementation-name", "sjsxp");
    this.supportedProps.put("http://java.sun.com/xml/stream/properties/outputstream", null);
  }
  
  public Object getProperty(String paramString)
  {
    return this.supportedProps.get(paramString);
  }
  
  public void setProperty(String paramString, Object paramObject)
  {
    if ((paramString == "com.amazonaws.javax.xml.stream.isNamespaceAware") || (paramString.equals("com.amazonaws.javax.xml.stream.isNamespaceAware"))) {}
    for (String str = "http://apache.org/xml/features/namespaces";; str = null)
    {
      this.supportedProps.put(paramString, paramObject);
      if (str != null) {
        this.supportedProps.put(str, paramObject);
      }
      return;
      if ((paramString == "com.amazonaws.javax.xml.stream.isValidating") || (paramString.equals("com.amazonaws.javax.xml.stream.isValidating")))
      {
        if (((paramObject instanceof Boolean)) && (((Boolean)paramObject).booleanValue())) {
          throw new IllegalArgumentException("true value of isValidating not supported");
        }
      }
      else if ((paramString == "http://xml.org/sax/features/string-interning") || (paramString.equals("http://xml.org/sax/features/string-interning")))
      {
        if (((paramObject instanceof Boolean)) && (!((Boolean)paramObject).booleanValue())) {
          throw new IllegalArgumentException("false value of http://xml.org/sax/features/string-interningfeature is not supported");
        }
      }
      else if ((paramString == "com.amazonaws.javax.xml.stream.resolver") || (paramString.equals("com.amazonaws.javax.xml.stream.resolver"))) {
        this.supportedProps.put("http://apache.org/xml/properties/internal/stax-entity-resolver", new StaxEntityResolverWrapper((XMLResolver)paramObject));
      }
    }
  }
  
  public String toString()
  {
    return this.supportedProps.toString();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/PropertyManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */