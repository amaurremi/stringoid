package com.j256.ormlite.android.apptools;

import android.content.Context;
import android.content.res.Resources;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import java.lang.reflect.ParameterizedType;

public class OpenHelperManager
{
  private static final String HELPER_CLASS_RESOURCE_NAME = "open_helper_classname";
  private static volatile OrmLiteSqliteOpenHelper helper;
  private static Class<? extends OrmLiteSqliteOpenHelper> helperClass;
  private static int instanceCount = 0;
  private static Logger logger = LoggerFactory.getLogger(OpenHelperManager.class);
  private static boolean wasClosed;
  
  static
  {
    helperClass = null;
    helper = null;
    wasClosed = false;
  }
  
  /* Error */
  private static OrmLiteSqliteOpenHelper constructHelper(Context paramContext, Class<? extends OrmLiteSqliteOpenHelper> paramClass)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: anewarray 47	java/lang/Class
    //   5: dup
    //   6: iconst_0
    //   7: ldc 49
    //   9: aastore
    //   10: invokevirtual 53	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   13: astore_2
    //   14: aload_2
    //   15: iconst_1
    //   16: anewarray 4	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: aload_0
    //   22: aastore
    //   23: invokevirtual 59	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast 61	com/j256/ormlite/android/apptools/OrmLiteSqliteOpenHelper
    //   29: astore_0
    //   30: aload_0
    //   31: areturn
    //   32: astore_0
    //   33: new 63	java/lang/IllegalStateException
    //   36: dup
    //   37: new 65	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   44: ldc 68
    //   46: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: aload_0
    //   57: invokespecial 82	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   60: athrow
    //   61: astore_0
    //   62: new 63	java/lang/IllegalStateException
    //   65: dup
    //   66: new 65	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   73: ldc 84
    //   75: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: aload_0
    //   86: invokespecial 82	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramContext	Context
    //   0	90	1	paramClass	Class<? extends OrmLiteSqliteOpenHelper>
    //   13	2	2	localConstructor	java.lang.reflect.Constructor
    // Exception table:
    //   from	to	target	type
    //   0	14	32	java/lang/Exception
    //   14	30	61	java/lang/Exception
  }
  
  @Deprecated
  public static OrmLiteSqliteOpenHelper getHelper(Context paramContext)
  {
    try
    {
      if (helperClass != null) {
        break label43;
      }
      if (paramContext == null) {
        throw new IllegalArgumentException("context argument is null");
      }
    }
    finally {}
    innerSetHelperClass(lookupHelperClass(paramContext.getApplicationContext(), paramContext.getClass()));
    label43:
    paramContext = loadHelper(paramContext, helperClass);
    return paramContext;
  }
  
  public static <T extends OrmLiteSqliteOpenHelper> T getHelper(Context paramContext, Class<T> paramClass)
  {
    if (paramClass == null) {
      try
      {
        throw new IllegalArgumentException("openHelperClass argument is null");
      }
      finally {}
    }
    innerSetHelperClass(paramClass);
    paramContext = loadHelper(paramContext, paramClass);
    return paramContext;
  }
  
  private static void innerSetHelperClass(Class<? extends OrmLiteSqliteOpenHelper> paramClass)
  {
    if (paramClass == null) {
      throw new IllegalStateException("Helper class was trying to be reset to null");
    }
    if (helperClass == null) {
      helperClass = paramClass;
    }
    while (helperClass == paramClass) {
      return;
    }
    throw new IllegalStateException("Helper class was " + helperClass + " but is trying to be reset to " + paramClass);
  }
  
  private static <T extends OrmLiteSqliteOpenHelper> T loadHelper(Context paramContext, Class<T> paramClass)
  {
    if (helper == null)
    {
      if (wasClosed) {
        logger.info("helper was already closed and is being re-opened");
      }
      if (paramContext == null) {
        throw new IllegalArgumentException("context argument is null");
      }
      helper = constructHelper(paramContext.getApplicationContext(), paramClass);
      logger.trace("zero instances, created helper {}", helper);
      BaseDaoImpl.clearAllInternalObjectCaches();
      DaoManager.clearDaoCache();
      instanceCount = 0;
    }
    instanceCount += 1;
    logger.trace("returning helper {}, instance count = {} ", helper, Integer.valueOf(instanceCount));
    return helper;
  }
  
  private static Class<? extends OrmLiteSqliteOpenHelper> lookupHelperClass(Context paramContext, Class<?> paramClass)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("open_helper_classname", "string", paramContext.getPackageName());
    if (i != 0)
    {
      paramContext = ((Resources)localObject).getString(i);
      try
      {
        paramClass = Class.forName(paramContext);
        return paramClass;
      }
      catch (Exception paramClass)
      {
        throw new IllegalStateException("Could not create helper instance for class " + paramContext, paramClass);
      }
    }
    paramContext = paramClass;
    if (paramContext != null)
    {
      localObject = paramContext.getGenericSuperclass();
      if ((localObject == null) || (!(localObject instanceof ParameterizedType))) {}
      do
      {
        paramContext = paramContext.getSuperclass();
        break;
        localObject = ((ParameterizedType)localObject).getActualTypeArguments();
      } while ((localObject == null) || (localObject.length == 0));
      int j = localObject.length;
      i = 0;
      label129:
      Class localClass;
      if (i < j)
      {
        localClass = localObject[i];
        if ((localClass instanceof Class)) {
          break label155;
        }
      }
      label155:
      do
      {
        i += 1;
        break label129;
        break;
        localClass = (Class)localClass;
      } while (!OrmLiteSqliteOpenHelper.class.isAssignableFrom(localClass));
      return localClass;
    }
    throw new IllegalStateException("Could not find OpenHelperClass because none of the generic parameters of class " + paramClass + " extends OrmLiteSqliteOpenHelper.  You should use getHelper(Context, Class) instead.");
  }
  
  @Deprecated
  public static void release() {}
  
  public static void releaseHelper()
  {
    try
    {
      instanceCount -= 1;
      logger.trace("releasing helper {}, instance count = {}", helper, Integer.valueOf(instanceCount));
      if (instanceCount <= 0)
      {
        if (helper != null)
        {
          logger.trace("zero instances, closing helper {}", helper);
          helper.close();
          helper = null;
          wasClosed = true;
        }
        if (instanceCount < 0) {
          logger.error("too many calls to release helper, instance count = {}", Integer.valueOf(instanceCount));
        }
      }
      return;
    }
    finally {}
  }
  
  public static void setHelper(OrmLiteSqliteOpenHelper paramOrmLiteSqliteOpenHelper)
  {
    try
    {
      helper = paramOrmLiteSqliteOpenHelper;
      return;
    }
    finally
    {
      paramOrmLiteSqliteOpenHelper = finally;
      throw paramOrmLiteSqliteOpenHelper;
    }
  }
  
  public static void setOpenHelperClass(Class<? extends OrmLiteSqliteOpenHelper> paramClass)
  {
    if (paramClass == null) {}
    for (;;)
    {
      try
      {
        helperClass = null;
        return;
      }
      finally {}
      innerSetHelperClass(paramClass);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/com/j256/ormlite/android/apptools/OpenHelperManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */