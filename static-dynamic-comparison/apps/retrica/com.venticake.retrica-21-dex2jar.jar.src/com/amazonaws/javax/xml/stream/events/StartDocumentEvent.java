package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.stream.Location;

public class StartDocumentEvent
  extends DummyEvent
  implements StartDocument
{
  protected String fEncodingScheam;
  private boolean fEncodingSchemeSet = false;
  protected boolean fStandalone;
  private boolean fStandaloneSet = false;
  protected String fVersion;
  private boolean nestedCall = false;
  
  public StartDocumentEvent()
  {
    init("UTF-8", "1.0", true, null);
  }
  
  protected void init(String paramString1, String paramString2, boolean paramBoolean, Location paramLocation)
  {
    setEventType(7);
    this.fEncodingScheam = paramString1;
    this.fVersion = paramString2;
    this.fStandalone = paramBoolean;
    if ((paramString1 != null) && (!paramString1.equals(""))) {
      this.fEncodingSchemeSet = true;
    }
    for (;;)
    {
      this.fLocation = paramLocation;
      return;
      this.fEncodingSchemeSet = false;
      this.fEncodingScheam = "UTF-8";
    }
  }
  
  public boolean isStartDocument()
  {
    return true;
  }
  
  void setDeclaredEncoding(boolean paramBoolean)
  {
    this.fEncodingSchemeSet = paramBoolean;
  }
  
  public void setEncoding(String paramString)
  {
    this.fEncodingScheam = paramString;
  }
  
  public void setStandalone(boolean paramBoolean)
  {
    this.fStandaloneSet = true;
    this.fStandalone = paramBoolean;
  }
  
  public void setVersion(String paramString)
  {
    this.fVersion = paramString;
  }
  
  public String toString()
  {
    String str = "<?xml version=\"" + this.fVersion + "\"";
    str = str + " encoding='" + this.fEncodingScheam + "'";
    if (this.fStandaloneSet)
    {
      if (this.fStandalone) {
        return str + " standalone='yes'?>";
      }
      return str + " standalone='no'?>";
    }
    return str + "?>";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/javax/xml/stream/events/StartDocumentEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */