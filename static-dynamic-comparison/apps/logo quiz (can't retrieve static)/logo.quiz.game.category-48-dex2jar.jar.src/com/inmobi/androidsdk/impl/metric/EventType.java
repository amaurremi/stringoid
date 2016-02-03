package com.inmobi.androidsdk.impl.metric;

public enum EventType
{
  private int a;
  
  static
  {
    CONNECT_ERROR = new EventType("CONNECT_ERROR", 2, 2);
    RESPONSE_ERROR = new EventType("RESPONSE_ERROR", 3, 3);
  }
  
  private EventType(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int getValue()
  {
    return this.a;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/inmobi/androidsdk/impl/metric/EventType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */