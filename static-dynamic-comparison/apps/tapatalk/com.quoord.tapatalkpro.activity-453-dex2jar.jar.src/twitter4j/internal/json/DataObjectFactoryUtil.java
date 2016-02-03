package twitter4j.internal.json;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import twitter4j.json.DataObjectFactory;

public class DataObjectFactoryUtil {
    private static final Method CLEAR_THREAD_LOCAL_MAP;
    private static final Method REGISTER_JSON_OBJECT;

    static {
        Method[] arrayOfMethod = DataObjectFactory.class.getDeclaredMethods();
        Object localObject1 = null;
        Object localObject2 = null;
        int j = arrayOfMethod.length;
        int i = 0;
        if (i < j) {
            Method localMethod = arrayOfMethod[i];
            Object localObject3;
            if (localMethod.getName().equals("clearThreadLocalMap")) {
                localObject3 = localMethod;
                ((Method) localObject3).setAccessible(true);
            }
            for (; ; ) {
                i += 1;
                localObject1 = localObject3;
                break;
                localObject3 = localObject1;
                if (localMethod.getName().equals("registerJSONObject")) {
                    localObject2 = localMethod;
                    ((Method) localObject2).setAccessible(true);
                    localObject3 = localObject1;
                }
            }
        }
        if ((localObject1 == null) || (localObject2 == null)) {
            throw new AssertionError();
        }
        CLEAR_THREAD_LOCAL_MAP = (Method) localObject1;
        REGISTER_JSON_OBJECT = (Method) localObject2;
    }

    private DataObjectFactoryUtil() {
        throw new AssertionError("not intended to be instantiated.");
    }

    public static void clearThreadLocalMap() {
        try {
            CLEAR_THREAD_LOCAL_MAP.invoke(null, new Object[0]);
            return;
        } catch (IllegalAccessException localIllegalAccessException) {
            throw new AssertionError(localIllegalAccessException);
        } catch (InvocationTargetException localInvocationTargetException) {
            throw new AssertionError(localInvocationTargetException);
        }
    }

    public static <T> T registerJSONObject(T paramT, Object paramObject) {
        try {
            paramT = REGISTER_JSON_OBJECT.invoke(null, new Object[]{paramT, paramObject});
            return paramT;
        } catch (IllegalAccessException paramT) {
            throw new AssertionError(paramT);
        } catch (InvocationTargetException paramT) {
            throw new AssertionError(paramT);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/json/DataObjectFactoryUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */