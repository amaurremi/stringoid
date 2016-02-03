package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class DataLayer
{
  static final int MAX_QUEUE_DEPTH = 500;
  public static final Object OBJECT_NOT_PRESENT = new Object();
  private final ConcurrentHashMap<Listener, Integer> mListeners = new ConcurrentHashMap();
  private final Map<Object, Object> mModel = new HashMap();
  private final ReentrantLock mPushLock = new ReentrantLock();
  private final LinkedList<Map<Object, Object>> mUpdateQueue = new LinkedList();
  
  public static List<Object> listOf(Object... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  public static Map<Object, Object> mapOf(Object... paramVarArgs)
  {
    if (paramVarArgs.length % 2 != 0) {
      throw new IllegalArgumentException("expected even number of key-value pairs");
    }
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localHashMap.put(paramVarArgs[i], paramVarArgs[(i + 1)]);
      i += 2;
    }
    return localHashMap;
  }
  
  private void notifyListeners(Map<Object, Object> paramMap)
  {
    Iterator localIterator = this.mListeners.keySet().iterator();
    while (localIterator.hasNext()) {
      ((Listener)localIterator.next()).changed(paramMap);
    }
  }
  
  private void processQueuedUpdates()
  {
    int i = 0;
    int j;
    do
    {
      Map localMap = (Map)this.mUpdateQueue.poll();
      if (localMap == null) {
        break;
      }
      processUpdate(localMap);
      j = i + 1;
      i = j;
    } while (j <= 500);
    this.mUpdateQueue.clear();
    throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
  }
  
  private void processUpdate(Map<Object, Object> paramMap)
  {
    synchronized (this.mModel)
    {
      Iterator localIterator = paramMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        mergeMap(expandKeyValue(localObject, paramMap.get(localObject)), this.mModel);
      }
    }
    notifyListeners(paramMap);
  }
  
  @VisibleForTesting
  Map<Object, Object> expandKeyValue(Object paramObject1, Object paramObject2)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = localHashMap;
    String[] arrayOfString = paramObject1.toString().split("\\.");
    int i = 0;
    while (i < arrayOfString.length - 1)
    {
      paramObject1 = new HashMap();
      ((Map)localObject).put(arrayOfString[i], paramObject1);
      localObject = paramObject1;
      i += 1;
    }
    ((Map)localObject).put(arrayOfString[(arrayOfString.length - 1)], paramObject2);
    return localHashMap;
  }
  
  public Object get(String paramString)
  {
    for (;;)
    {
      int i;
      synchronized (this.mModel)
      {
        Map localMap1 = this.mModel;
        String[] arrayOfString = paramString.split("\\.");
        int j = arrayOfString.length;
        i = 0;
        paramString = localMap1;
        if (i < j)
        {
          localMap1 = arrayOfString[i];
          if (!(paramString instanceof Map)) {
            return null;
          }
          paramString = ((Map)paramString).get(localMap1);
          if (paramString == null) {
            return null;
          }
        }
        else
        {
          return paramString;
        }
      }
      i += 1;
    }
  }
  
  @VisibleForTesting
  void mergeList(List<Object> paramList1, List<Object> paramList2)
  {
    while (paramList2.size() < paramList1.size()) {
      paramList2.add(null);
    }
    int i = 0;
    if (i < paramList1.size())
    {
      Object localObject = paramList1.get(i);
      if ((localObject instanceof List))
      {
        if (!(paramList2.get(i) instanceof List)) {
          paramList2.set(i, new ArrayList());
        }
        mergeList((List)localObject, (List)paramList2.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof Map))
        {
          if (!(paramList2.get(i) instanceof Map)) {
            paramList2.set(i, new HashMap());
          }
          mergeMap((Map)localObject, (Map)paramList2.get(i));
        }
        else if (localObject != OBJECT_NOT_PRESENT)
        {
          paramList2.set(i, localObject);
        }
      }
    }
  }
  
  @VisibleForTesting
  void mergeMap(Map<Object, Object> paramMap1, Map<Object, Object> paramMap2)
  {
    Iterator localIterator = paramMap1.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramMap1.get(localObject1);
      if ((localObject2 instanceof List))
      {
        if (!(paramMap2.get(localObject1) instanceof List)) {
          paramMap2.put(localObject1, new ArrayList());
        }
        mergeList((List)localObject2, (List)paramMap2.get(localObject1));
      }
      else if ((localObject2 instanceof Map))
      {
        if (!(paramMap2.get(localObject1) instanceof Map)) {
          paramMap2.put(localObject1, new HashMap());
        }
        mergeMap((Map)localObject2, (Map)paramMap2.get(localObject1));
      }
      else
      {
        paramMap2.put(localObject1, localObject2);
      }
    }
  }
  
  public void push(Object paramObject1, Object paramObject2)
  {
    push(expandKeyValue(paramObject1, paramObject2));
  }
  
  public void push(Map<Object, Object> paramMap)
  {
    this.mPushLock.lock();
    try
    {
      this.mUpdateQueue.offer(paramMap);
      if (this.mPushLock.getHoldCount() == 1) {
        processQueuedUpdates();
      }
      return;
    }
    finally
    {
      this.mPushLock.unlock();
    }
  }
  
  void registerListener(Listener paramListener)
  {
    this.mListeners.put(paramListener, Integer.valueOf(0));
  }
  
  void unregisterListener(Listener paramListener)
  {
    this.mListeners.remove(paramListener);
  }
  
  static abstract interface Listener
  {
    public abstract void changed(Map<Object, Object> paramMap);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/google/tagmanager/DataLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */