package com.amazonaws.javax.xml.stream.events;

public class NamespaceImpl
  extends AttributeImpl
  implements Namespace
{
  public NamespaceImpl()
  {
    init();
  }
  
  public NamespaceImpl(String paramString1, String paramString2)
  {
    super("xmlns", "http://www.w3.org/2000/xmlns/", paramString1, paramString2, null);
    init();
  }
  
  public int getEventType()
  {
    return 13;
  }
  
  protected void init()
  {
    setEventType(13);
  }
  
  public boolean isNamespace()
  {
    return true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/NamespaceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */