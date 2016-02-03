package com.mongodb.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ThreadUtil
{
  private static final Map<Long, FastStack<String>> _threads = Collections.synchronizedMap(new HashMap());
  
  public static void clearStatus()
  {
    clearStatus(Thread.currentThread());
  }
  
  public static void clearStatus(Thread paramThread)
  {
    getStatus(paramThread).clear();
  }
  
  public static FastStack<String> getStatus()
  {
    return getStatus(Thread.currentThread());
  }
  
  public static FastStack<String> getStatus(Thread paramThread)
  {
    FastStack localFastStack2 = (FastStack)_threads.get(Long.valueOf(paramThread.getId()));
    FastStack localFastStack1 = localFastStack2;
    if (localFastStack2 == null)
    {
      localFastStack1 = new FastStack();
      _threads.put(Long.valueOf(paramThread.getId()), localFastStack1);
    }
    return localFastStack1;
  }
  
  public static void printStackTrace()
  {
    Exception localException = new Exception();
    localException.fillInStackTrace();
    localException.printStackTrace();
  }
  
  public static void pushStatus(String paramString)
  {
    pushStatus(Thread.currentThread(), paramString);
  }
  
  public static void pushStatus(Thread paramThread, String paramString)
  {
    getStatus(paramThread).push(paramString);
  }
  
  public static void sleep(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/randomchat/com.pioong-93-dex2jar.jar!/com/mongodb/util/ThreadUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */