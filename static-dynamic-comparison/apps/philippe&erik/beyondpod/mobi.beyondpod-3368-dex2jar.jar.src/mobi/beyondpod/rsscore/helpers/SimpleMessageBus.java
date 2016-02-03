package mobi.beyondpod.rsscore.helpers;

import android.os.Handler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class SimpleMessageBus
{
  private static final String TAG = SimpleMessageBus.class.getSimpleName();
  private Handler _Handler;
  private final ConcurrentMap<Class<?>, ConcurrentMap<Class<?>, Object>> _HandlerMap = new ConcurrentHashMap();
  private final ConcurrentMap<Class<?>, String> _MethodNameCache = new ConcurrentHashMap();
  
  public SimpleMessageBus(Handler paramHandler)
  {
    this._Handler = paramHandler;
  }
  
  private Method GetMethodHandlerFor(Object paramObject, Class<?> paramClass)
  {
    Object localObject = (String)this._MethodNameCache.get(paramClass);
    if (localObject == null)
    {
      paramObject = SearchForMethodHandlerFor(paramObject, paramClass);
      if (paramObject != null) {
        this._MethodNameCache.put(paramClass, ((Method)paramObject).getName());
      }
      return (Method)paramObject;
    }
    try
    {
      localObject = paramObject.getClass().getMethod((String)localObject, new Class[] { paramClass });
      return (Method)localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
    return SearchForMethodHandlerFor(paramObject, paramClass);
  }
  
  private void PublishEvent(EventObject paramEventObject, boolean paramBoolean)
  {
    if (paramEventObject == null) {
      return;
    }
    if (paramBoolean)
    {
      this._Handler.post(new Publisher(paramEventObject));
      return;
    }
    new Publisher(paramEventObject).run();
  }
  
  private Method SearchForMethodHandlerFor(Object paramObject, Class<?> paramClass)
  {
    paramObject = paramObject.getClass().getDeclaredMethods();
    int j = paramObject.length;
    int i = 0;
    for (;;)
    {
      if (i == j) {
        return null;
      }
      Class[] arrayOfClass = paramObject[i].getParameterTypes();
      if ((arrayOfClass.length == 1) && (arrayOfClass[0].equals(paramClass))) {
        return paramObject[i];
      }
      i += 1;
    }
  }
  
  public void PublishEvent(EventObject paramEventObject)
  {
    PublishEvent(paramEventObject, false);
  }
  
  public void PublishEventAsync(EventObject paramEventObject)
  {
    PublishEvent(paramEventObject, true);
  }
  
  public void Subscribe(Object paramObject, Class<?> paramClass)
  {
    ConcurrentMap localConcurrentMap = (ConcurrentMap)this._HandlerMap.get(paramClass);
    Object localObject = localConcurrentMap;
    if (localConcurrentMap == null)
    {
      localObject = new ConcurrentHashMap();
      this._HandlerMap.put(paramClass, localObject);
    }
    ((ConcurrentMap)localObject).put(paramObject.getClass(), paramObject);
  }
  
  public void Unsubscribe(Object paramObject, Class<?> paramClass)
  {
    paramClass = (ConcurrentMap)this._HandlerMap.get(paramClass);
    if (paramClass == null) {
      return;
    }
    paramClass.remove(paramObject.getClass());
  }
  
  public void clear()
  {
    this._HandlerMap.clear();
    this._MethodNameCache.clear();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this._HandlerMap.keySet().iterator();
    if (!localIterator1.hasNext()) {
      return localStringBuilder.toString();
    }
    Class localClass1 = (Class)localIterator1.next();
    localStringBuilder.append("Event: " + localClass1.getSimpleName() + "\n");
    if (((ConcurrentMap)this._HandlerMap.get(localClass1)).keySet().size() == 0) {
      localStringBuilder.append("            No Subscribers!");
    }
    for (;;)
    {
      localStringBuilder.append("\n");
      break;
      Iterator localIterator2 = ((ConcurrentMap)this._HandlerMap.get(localClass1)).keySet().iterator();
      while (localIterator2.hasNext())
      {
        Class localClass2 = (Class)localIterator2.next();
        localStringBuilder.append("            " + localClass2 + " -> " + GetMethodHandlerFor(((ConcurrentMap)this._HandlerMap.get(localClass1)).get(localClass2), localClass1).getName() + "\n");
      }
    }
  }
  
  private final class Publisher
    implements Runnable
  {
    private final EventObject _Event;
    private final Class<?> _MessageType;
    
    public Publisher(EventObject paramEventObject)
    {
      this._Event = paramEventObject;
      this._MessageType = this._Event.getClass();
    }
    
    public void run()
    {
      Object localObject1 = (ConcurrentMap)SimpleMessageBus.this._HandlerMap.get(this._MessageType);
      if (localObject1 == null)
      {
        localObject1 = Collections.emptyList();
        if (localObject1 != null) {
          break label43;
        }
      }
      for (;;)
      {
        return;
        localObject1 = ((ConcurrentMap)localObject1).values();
        break;
        label43:
        localObject1 = ((Collection)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = ((Iterator)localObject1).next();
          try
          {
            Method localMethod = SimpleMessageBus.this.GetMethodHandlerFor(localObject2, this._MessageType);
            if (localMethod != null) {
              localMethod.invoke(localObject2, new Object[] { this._Event });
            }
          }
          catch (Exception localException)
          {
            CoreHelper.LogException(SimpleMessageBus.TAG, "Publishing Failed", localException);
          }
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/helpers/SimpleMessageBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */