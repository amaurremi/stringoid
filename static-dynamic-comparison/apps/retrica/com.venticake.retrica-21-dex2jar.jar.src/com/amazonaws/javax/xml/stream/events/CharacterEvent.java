package com.amazonaws.javax.xml.stream.events;

public class CharacterEvent
  extends DummyEvent
  implements Characters
{
  private boolean fCheckIfSpaceNeeded = true;
  private String fData;
  private boolean fIsCData;
  private boolean fIsIgnorableWhitespace;
  private boolean fIsSpace = false;
  
  public CharacterEvent()
  {
    this.fIsCData = false;
    init();
  }
  
  public CharacterEvent(String paramString)
  {
    this.fIsCData = false;
    init();
    this.fData = paramString;
  }
  
  public CharacterEvent(String paramString, boolean paramBoolean)
  {
    init();
    this.fData = paramString;
    this.fIsCData = paramBoolean;
  }
  
  public CharacterEvent(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    init();
    this.fData = paramString;
    this.fIsCData = paramBoolean1;
    this.fIsIgnorableWhitespace = paramBoolean2;
  }
  
  public String getData()
  {
    return this.fData;
  }
  
  protected void init()
  {
    setEventType(4);
  }
  
  public String toString()
  {
    if (this.fIsCData) {
      return "<![CDATA[" + getData() + "]]>";
    }
    return this.fData;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/CharacterEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */