package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.stream.Location;

public class ProcessingInstructionEvent
  extends DummyEvent
  implements ProcessingInstruction
{
  private String fContent;
  private String fName;
  
  public ProcessingInstructionEvent()
  {
    init();
  }
  
  public ProcessingInstructionEvent(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null);
  }
  
  public ProcessingInstructionEvent(String paramString1, String paramString2, Location paramLocation)
  {
    init();
    this.fName = paramString1;
    this.fContent = paramString2;
    setLocation(paramLocation);
  }
  
  protected void init()
  {
    setEventType(3);
  }
  
  public String toString()
  {
    if ((this.fContent != null) && (this.fName != null)) {
      return "<?" + this.fName + " " + this.fContent + "?>";
    }
    if (this.fName != null) {
      return "<?" + this.fName + "?>";
    }
    if (this.fContent != null) {
      return "<?" + this.fContent + "?>";
    }
    return "<??>";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/ProcessingInstructionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */