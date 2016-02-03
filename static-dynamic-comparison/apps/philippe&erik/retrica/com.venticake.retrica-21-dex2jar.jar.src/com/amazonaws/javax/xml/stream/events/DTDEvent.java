package com.amazonaws.javax.xml.stream.events;

import java.util.List;

public class DTDEvent
  extends DummyEvent
  implements DTD
{
  private String fDoctypeDeclaration;
  private List fEntities;
  private List fNotations;
  
  public DTDEvent()
  {
    init();
  }
  
  public DTDEvent(String paramString)
  {
    init();
    this.fDoctypeDeclaration = paramString;
  }
  
  protected void init()
  {
    setEventType(11);
  }
  
  public void setEntities(List paramList)
  {
    this.fEntities = paramList;
  }
  
  public void setNotations(List paramList)
  {
    this.fNotations = paramList;
  }
  
  public String toString()
  {
    return this.fDoctypeDeclaration;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/DTDEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */