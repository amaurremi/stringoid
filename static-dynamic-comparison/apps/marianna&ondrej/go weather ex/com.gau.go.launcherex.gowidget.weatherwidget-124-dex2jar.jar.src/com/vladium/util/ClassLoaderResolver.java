package com.vladium.util;

public abstract class ClassLoaderResolver
{
  private static final CallerResolver CALLER_RESOLVER;
  private static final int CALL_CONTEXT_OFFSET = 2;
  private static IClassLoadStrategy s_strategy = new DefaultClassLoadStrategy(null);
  
  static
  {
    Object localObject = null;
    try
    {
      CallerResolver localCallerResolver = new CallerResolver(null);
      localObject = localCallerResolver;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    CALLER_RESOLVER = (CallerResolver)localObject;
  }
  
  public static Class getCallerClass(int paramInt)
  {
    if (CALLER_RESOLVER == null) {
      return null;
    }
    return CALLER_RESOLVER.getClassContext()[(paramInt + 2)];
  }
  
  public static ClassLoader getClassLoader()
  {
    try
    {
      Object localObject1 = new ClassLoadContext(getCallerClass(1));
      localObject1 = s_strategy.getClassLoader((ClassLoadContext)localObject1);
      return (ClassLoader)localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public static ClassLoader getClassLoader(Class paramClass)
  {
    try
    {
      paramClass = new ClassLoadContext(paramClass);
      paramClass = s_strategy.getClassLoader(paramClass);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public static IClassLoadStrategy getStrategy()
  {
    try
    {
      IClassLoadStrategy localIClassLoadStrategy = s_strategy;
      return localIClassLoadStrategy;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean isChild(ClassLoader paramClassLoader1, ClassLoader paramClassLoader2)
  {
    if (paramClassLoader1 == paramClassLoader2) {}
    do
    {
      return true;
      if (paramClassLoader2 == null) {
        return false;
      }
    } while (paramClassLoader1 == null);
    for (;;)
    {
      if (paramClassLoader2 == null) {
        break label34;
      }
      if (paramClassLoader2 == paramClassLoader1) {
        break;
      }
      paramClassLoader2 = paramClassLoader2.getParent();
    }
    label34:
    return false;
  }
  
  public static IClassLoadStrategy setStrategy(IClassLoadStrategy paramIClassLoadStrategy)
  {
    if (paramIClassLoadStrategy == null) {
      try
      {
        throw new IllegalArgumentException("null input: strategy");
      }
      finally {}
    }
    IClassLoadStrategy localIClassLoadStrategy = s_strategy;
    s_strategy = paramIClassLoadStrategy;
    return localIClassLoadStrategy;
  }
  
  private static final class CallerResolver
    extends SecurityManager
  {
    protected Class[] getClassContext()
    {
      return super.getClassContext();
    }
  }
  
  private static final class DefaultClassLoadStrategy
    implements IClassLoadStrategy
  {
    public ClassLoader getClassLoader(ClassLoadContext paramClassLoadContext)
    {
      if (paramClassLoadContext == null) {
        throw new IllegalArgumentException("null input: ctx");
      }
      Object localObject = paramClassLoadContext.getCallerClass();
      paramClassLoadContext = Thread.currentThread().getContextClassLoader();
      if (localObject == null) {}
      for (;;)
      {
        ClassLoader localClassLoader = ClassLoader.getSystemClassLoader();
        localObject = paramClassLoadContext;
        if (ClassLoaderResolver.isChild(paramClassLoadContext, localClassLoader)) {
          localObject = localClassLoader;
        }
        return (ClassLoader)localObject;
        localObject = ((Class)localObject).getClassLoader();
        if (!ClassLoaderResolver.isChild((ClassLoader)localObject, paramClassLoadContext)) {
          paramClassLoadContext = (ClassLoadContext)localObject;
        }
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/ClassLoaderResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */