package twitter4j.internal.json;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import twitter4j.json.DataObjectFactory;

public class DataObjectFactoryUtil
{
  private static final Method CLEAR_THREAD_LOCAL_MAP;
  private static final Method REGISTER_JSON_OBJECT;
  
  static
  {
    Method[] arrayOfMethod = DataObjectFactory.class.getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    Method localMethod;
    if (i < j)
    {
      localMethod = arrayOfMethod[i];
      if (localMethod.getName().equals("clearThreadLocalMap"))
      {
        localMethod.setAccessible(true);
        localObject1 = localMethod;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (localMethod.getName().equals("registerJSONObject"))
      {
        localMethod.setAccessible(true);
        localObject2 = localMethod;
        continue;
        if ((localObject1 == null) || (localObject2 == null)) {
          throw new AssertionError();
        }
        CLEAR_THREAD_LOCAL_MAP = (Method)localObject1;
        REGISTER_JSON_OBJECT = (Method)localObject2;
        return;
      }
    }
  }
  
  private DataObjectFactoryUtil()
  {
    throw new AssertionError("not intended to be instantiated.");
  }
  
  public static void clearThreadLocalMap()
  {
    try
    {
      CLEAR_THREAD_LOCAL_MAP.invoke(null, new Object[0]);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new AssertionError(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new AssertionError(localInvocationTargetException);
    }
  }
  
  public static Object registerJSONObject(Object paramObject1, Object paramObject2)
  {
    try
    {
      paramObject1 = REGISTER_JSON_OBJECT.invoke(null, new Object[] { paramObject1, paramObject2 });
      return paramObject1;
    }
    catch (IllegalAccessException paramObject1)
    {
      throw new AssertionError(paramObject1);
    }
    catch (InvocationTargetException paramObject1)
    {
      throw new AssertionError(paramObject1);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/pocket/com.ideashower.readitlater.pro-568-dex2jar.jar!/twitter4j/internal/json/DataObjectFactoryUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */