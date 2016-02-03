package com.amazonaws.javax.xml.stream.events;

public class EndDocumentEvent
  extends DummyEvent
  implements EndDocument
{
  public EndDocumentEvent()
  {
    init();
  }
  
  protected void init()
  {
    setEventType(8);
  }
  
  public String toString()
  {
    return "ENDDOCUMENT";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/EndDocumentEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */