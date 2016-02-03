package com.amazonaws.javax.xml.stream.events;

public class CommentEvent
  extends DummyEvent
  implements Comment
{
  private String fText;
  
  public CommentEvent()
  {
    init();
  }
  
  public CommentEvent(String paramString)
  {
    init();
    this.fText = paramString;
  }
  
  public String getText()
  {
    return this.fText;
  }
  
  protected void init()
  {
    setEventType(5);
  }
  
  public String toString()
  {
    return "<!--" + getText() + "-->";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/CommentEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */