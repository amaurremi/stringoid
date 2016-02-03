package com.bfs.papertoss.platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Evt
{
  public static final String DEFAULT_EVENT = "DEFAULT_EVENT";
  private static Evt m_instance = null;
  private HashMap<String, ArrayList<EvtListener>> m_listeners = null;
  
  public static Evt getInstance()
  {
    if (m_instance == null) {
      m_instance = new Evt();
    }
    return m_instance;
  }
  
  public void publish(String paramString)
  {
    publish(paramString, null);
  }
  
  public void publish(String paramString, Object paramObject)
  {
    synchronized (this.m_listeners)
    {
      if (this.m_listeners.containsKey(paramString))
      {
        paramString = ((ArrayList)this.m_listeners.get(paramString)).iterator();
        if (paramString.hasNext()) {
          ((EvtListener)paramString.next()).run(paramObject);
        }
      }
    }
  }
  
  public void subscribe(String paramString, EvtListener paramEvtListener)
  {
    for (;;)
    {
      ArrayList localArrayList;
      synchronized (this.m_listeners)
      {
        if (this.m_listeners.containsKey(paramString))
        {
          paramString = (ArrayList)this.m_listeners.get(paramString);
          paramString.add(paramEvtListener);
          return;
        }
        localArrayList = new ArrayList();
      }
      try
      {
        this.m_listeners.put(paramString, localArrayList);
        paramString = localArrayList;
      }
      finally {}
    }
    paramString = finally;
    throw paramString;
  }
  
  public void unsubscribe(String paramString, EvtListener paramEvtListener)
  {
    synchronized (this.m_listeners)
    {
      if (this.m_listeners.containsKey(paramString))
      {
        ArrayList localArrayList = (ArrayList)this.m_listeners.get(paramString);
        localArrayList.remove(paramEvtListener);
        if (localArrayList.size() == 0) {
          this.m_listeners.remove(paramString);
        }
      }
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/paper toss/com.bfs.papertoss-7005-dex2jar.jar!/com/bfs/papertoss/platform/Evt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */