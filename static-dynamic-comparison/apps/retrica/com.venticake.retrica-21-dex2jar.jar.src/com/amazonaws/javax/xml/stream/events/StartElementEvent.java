package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.namespace.NamespaceContext;
import com.amazonaws.javax.xml.namespace.QName;
import com.amazonaws.javax.xml.stream.util.ReadOnlyIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StartElementEvent
  extends DummyEvent
  implements StartElement
{
  private Map fAttributes;
  private NamespaceContext fNamespaceContext = null;
  private List fNamespaces;
  private QName fQName;
  
  public StartElementEvent(QName paramQName)
  {
    this.fQName = paramQName;
    init();
  }
  
  void addAttribute(Attribute paramAttribute)
  {
    if (paramAttribute.isNamespace())
    {
      this.fNamespaces.add(paramAttribute);
      return;
    }
    this.fAttributes.put(paramAttribute.getName(), paramAttribute);
  }
  
  void addNamespaceAttribute(Namespace paramNamespace)
  {
    if (paramNamespace == null) {
      return;
    }
    this.fNamespaces.add(paramNamespace);
  }
  
  public Iterator getAttributes()
  {
    if (this.fAttributes != null) {
      return new ReadOnlyIterator(this.fAttributes.values().iterator());
    }
    return new ReadOnlyIterator();
  }
  
  public QName getName()
  {
    return this.fQName;
  }
  
  protected void init()
  {
    setEventType(1);
    this.fAttributes = new HashMap();
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
  
  public void setNamespaceContext(NamespaceContext paramNamespaceContext)
  {
    this.fNamespaceContext = paramNamespaceContext;
  }
  
  public String toString()
  {
    Object localObject1 = "<" + nameAsString();
    Iterator localIterator;
    if (this.fAttributes != null)
    {
      localIterator = getAttributes();
      for (localObject2 = localObject1;; localObject2 = (String)localObject2 + " " + localObject1.toString())
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Attribute)localIterator.next();
      }
    }
    Object localObject2 = localObject1;
    if (this.fNamespaces != null)
    {
      localIterator = this.fNamespaces.iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (Namespace)localIterator.next();
        localObject1 = (String)localObject1 + " " + localObject2.toString();
      }
    }
    return (String)localObject2 + ">";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/StartElementEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */