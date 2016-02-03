package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class EndElementEvent
  extends DummyEvent
  implements EndElement
{
  List fNamespaces = null;
  QName fQName;
  
  public EndElementEvent()
  {
    init();
  }
  
  public EndElementEvent(QName paramQName)
  {
    this.fQName = paramQName;
    init();
  }
  
  void addNamespace(Namespace paramNamespace)
  {
    if (paramNamespace != null) {
      this.fNamespaces.add(paramNamespace);
    }
  }
  
  protected void init()
  {
    setEventType(2);
    this.fNamespaces = new ArrayList();
  }
  
  public String nameAsString()
  {
    if ("".equals(this.fQName.getNamespaceURI())) {
      return this.fQName.getLocalPart();
    }
    if (this.fQName.getPrefix() != null) {
      return "['" + this.fQName.getNamespaceURI() + "']:" + this.fQName.getPrefix() + ":" + this.fQName.getLocalPart();
    }
    return "['" + this.fQName.getNamespaceURI() + "']:" + this.fQName.getLocalPart();
  }
  
  public String toString()
  {
    String str = "</" + nameAsString();
    return str + ">";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/EndElementEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */