package com.tapjoy;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TJEventManager
{
  private static Map<String, TJEvent> eventsTable = new LinkedHashMap()
  {
    private static final long serialVersionUID = 5794666578643304105L;
    
    protected boolean removeEldestEntry(Map.Entry<String, TJEvent> paramAnonymousEntry)
    {
      return size() > 20;
    }
  };
  
  public static TJEvent get(String paramString)
  {
    return (TJEvent)eventsTable.get(paramString);
  }
  
  public static void put(String paramString, TJEvent paramTJEvent)
  {
    eventsTable.put(paramString, paramTJEvent);
  }
  
  public static void remove(String paramString)
  {
    eventsTable.remove(paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/tapjoy/TJEventManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */