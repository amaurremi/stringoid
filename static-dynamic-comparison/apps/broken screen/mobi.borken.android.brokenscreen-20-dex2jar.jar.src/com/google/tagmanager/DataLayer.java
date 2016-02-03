package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataLayer
{
  static final String LIFETIME_KEY = "gtm.lifetime";
  static final String[] LIFETIME_KEY_COMPONENTS = "gtm.lifetime".toString().split("\\.");
  private static final Pattern LIFETIME_PATTERN = Pattern.compile("(\\d+)\\s*([smhd]?)");
  static final int MAX_QUEUE_DEPTH = 500;
  public static final Object OBJECT_NOT_PRESENT = new Object();
  private final ConcurrentHashMap<Listener, Integer> mListeners;
  private final Map<Object, Object> mModel;
  private final PersistentStore mPersistentStore;
  private final CountDownLatch mPersistentStoreLoaded;
  private final ReentrantLock mPushLock;
  private final LinkedList<Map<Object, Object>> mUpdateQueue;
  
  @VisibleForTesting
  DataLayer()
  {
    this(new PersistentStore()
    {
      public void clearKeysWithPrefix(String paramAnonymousString) {}
      
      public void loadSaved(DataLayer.PersistentStore.Callback paramAnonymousCallback)
      {
        paramAnonymousCallback.onKeyValuesLoaded(new ArrayList());
      }
      
      public void saveKeyValues(List<DataLayer.KeyValue> paramAnonymousList, long paramAnonymousLong) {}
    });
  }
  
  DataLayer(PersistentStore paramPersistentStore)
  {
    this.mPersistentStore = paramPersistentStore;
    this.mListeners = new ConcurrentHashMap();
    this.mModel = new HashMap();
    this.mPushLock = new ReentrantLock();
    this.mUpdateQueue = new LinkedList();
    this.mPersistentStoreLoaded = new CountDownLatch(1);
    loadSavedMaps();
  }
  
  private List<KeyValue> flattenMap(Map<Object, Object> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    flattenMapHelper(paramMap, "", localArrayList);
    return localArrayList;
  }
  
  private void flattenMapHelper(Map<Object, Object> paramMap, String paramString, Collection<KeyValue> paramCollection)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder().append(paramString);
      if (paramString.length() == 0) {}
      for (paramMap = "";; paramMap = ".")
      {
        paramMap = paramMap + localEntry.getKey();
        if (!(localEntry.getValue() instanceof Map)) {
          break label116;
        }
        flattenMapHelper((Map)localEntry.getValue(), paramMap, paramCollection);
        break;
      }
      label116:
      if (!paramMap.equals("gtm.lifetime")) {
        paramCollection.add(new KeyValue(paramMap, localEntry.getValue()));
      }
    }
  }
  
  private Object getLifetimeObject(Map<Object, Object> paramMap)
  {
    String[] arrayOfString = LIFETIME_KEY_COMPONENTS;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      Object localObject = paramMap;
      if (i < j)
      {
        localObject = arrayOfString[i];
        if (!(paramMap instanceof Map)) {
          localObject = null;
        }
      }
      else
      {
        return localObject;
      }
      paramMap = ((Map)paramMap).get(localObject);
      i += 1;
    }
  }
  
  private Long getLifetimeValue(Map<Object, Object> paramMap)
  {
    paramMap = getLifetimeObject(paramMap);
    if (paramMap == null) {
      return null;
    }
    return parseLifetime(paramMap.toString());
  }
  
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
  
  private void loadSavedMaps()
  {
    this.mPersistentStore.loadSaved(new DataLayer.PersistentStore.Callback()
    {
      public void onKeyValuesLoaded(List<DataLayer.KeyValue> paramAnonymousList)
      {
        paramAnonymousList = paramAnonymousList.iterator();
        while (paramAnonymousList.hasNext())
        {
          DataLayer.KeyValue localKeyValue = (DataLayer.KeyValue)paramAnonymousList.next();
          DataLayer.this.pushWithoutWaitingForSaved(DataLayer.this.expandKeyValue(localKeyValue.mKey, localKeyValue.mValue));
        }
        DataLayer.this.mPersistentStoreLoaded.countDown();
      }
    });
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
  
  @VisibleForTesting
  static Long parseLifetime(String paramString)
  {
    Object localObject = LIFETIME_PATTERN.matcher(paramString);
    if (!((Matcher)localObject).matches())
    {
      Log.i("unknown _lifetime: " + paramString);
      return null;
    }
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(((Matcher)localObject).group(1));
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Log.w("illegal number in _lifetime value: " + paramString);
      }
      localObject = ((Matcher)localObject).group(2);
      if (((String)localObject).length() != 0) {
        break label136;
      }
      return Long.valueOf(l1);
      switch (((String)localObject).charAt(0))
      {
      default: 
        Log.w("unknown units in _lifetime: " + paramString);
        return null;
      }
    }
    if (l1 <= 0L)
    {
      Log.i("non-positive _lifetime: " + paramString);
      return null;
    }
    label136:
    return Long.valueOf(l1 * 1000L);
    return Long.valueOf(l1 * 1000L * 60L);
    return Long.valueOf(l1 * 1000L * 60L * 60L);
    return Long.valueOf(l1 * 1000L * 60L * 60L * 24L);
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
  
  private void pushWithoutWaitingForSaved(Map<Object, Object> paramMap)
  {
    this.mPushLock.lock();
    try
    {
      this.mUpdateQueue.offer(paramMap);
      if (this.mPushLock.getHoldCount() == 1) {
        processQueuedUpdates();
      }
      savePersistentlyIfNeeded(paramMap);
      return;
    }
    finally
    {
      this.mPushLock.unlock();
    }
  }
  
  private void savePersistentlyIfNeeded(Map<Object, Object> paramMap)
  {
    Long localLong = getLifetimeValue(paramMap);
    if (localLong == null) {
      return;
    }
    paramMap = flattenMap(paramMap);
    paramMap.remove("gtm.lifetime");
    this.mPersistentStore.saveKeyValues(paramMap, localLong.longValue());
  }
  
  void clearPersistentKeysWithPrefix(String paramString)
  {
    push(paramString, null);
    this.mPersistentStore.clearKeysWithPrefix(paramString);
  }
  
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
    try
    {
      this.mPersistentStoreLoaded.await();
      pushWithoutWaitingForSaved(paramMap);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Log.w("DataLayer.push: unexpected InterruptedException");
      }
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
  
  static final class KeyValue
  {
    public final String mKey;
    public final Object mValue;
    
    KeyValue(String paramString, Object paramObject)
    {
      this.mKey = paramString;
      this.mValue = paramObject;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof KeyValue)) {}
      do
      {
        return false;
        paramObject = (KeyValue)paramObject;
      } while ((!this.mKey.equals(((KeyValue)paramObject).mKey)) || (!this.mValue.equals(((KeyValue)paramObject).mValue)));
      return true;
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(new Integer[] { Integer.valueOf(this.mKey.hashCode()), Integer.valueOf(this.mValue.hashCode()) });
    }
    
    public String toString()
    {
      return "Key: " + this.mKey + " value: " + this.mValue.toString();
    }
  }
  
  static abstract interface Listener
  {
    public abstract void changed(Map<Object, Object> paramMap);
  }
  
  static abstract interface PersistentStore
  {
    public abstract void clearKeysWithPrefix(String paramString);
    
    public abstract void loadSaved(Callback paramCallback);
    
    public abstract void saveKeyValues(List<DataLayer.KeyValue> paramList, long paramLong);
    
    public static abstract interface Callback
    {
      public abstract void onKeyValuesLoaded(List<DataLayer.KeyValue> paramList);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/broken screen/mobi.borken.android.brokenscreen-20-dex2jar.jar!/com/google/tagmanager/DataLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */