package com.jumptap.adtag.events;

public class JtEvent
{
  private String date;
  private EventType eventType;
  private int id;
  private String url;
  
  public JtEvent()
  {
    initEvent(-1, null, null, null);
  }
  
  public JtEvent(int paramInt, String paramString1, EventType paramEventType, String paramString2)
  {
    initEvent(paramInt, paramString1, paramEventType, paramString2);
  }
  
  public JtEvent(String paramString1, EventType paramEventType, String paramString2)
  {
    initEvent(-1, paramString1, paramEventType, paramString2);
  }
  
  private void initEvent(int paramInt, String paramString1, EventType paramEventType, String paramString2)
  {
    this.id = paramInt;
    this.url = paramString1;
    this.eventType = paramEventType;
    this.date = paramString2;
  }
  
  public String getDate()
  {
    return this.date;
  }
  
  public EventType getEventType()
  {
    return this.eventType;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setDate(String paramString)
  {
    this.date = paramString;
  }
  
  public void setEventType(EventType paramEventType)
  {
    this.eventType = paramEventType;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public String toString()
  {
    return "id=" + this.id + " ,eventType=" + this.eventType + " ,date=" + this.date + " ,url=" + this.url;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/events/JtEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */