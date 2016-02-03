package com.amazon.inapp.purchasing;

final class ImplementationFactory
{
  private static volatile ImplementationRegistry IMPLEMENTATION_REGISTRY;
  private static volatile boolean IS_SANDBOX_MODE;
  private static volatile boolean IS_SANDBOX_MODE_CHECKED;
  private static volatile LogHandler LOG_HANDLER_INSTANCE;
  private static volatile RequestHandler REQUEST_HANDLER_INSTANCE;
  private static volatile ResponseHandler RESPONSE_HANDLER_INSTANCE;
  
  /* Error */
  private static ImplementationRegistry getImplementationRegistry()
  {
    // Byte code:
    //   0: getstatic 24	com/amazon/inapp/purchasing/ImplementationFactory:IMPLEMENTATION_REGISTRY	Lcom/amazon/inapp/purchasing/ImplementationRegistry;
    //   3: ifnonnull +31 -> 34
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 24	com/amazon/inapp/purchasing/ImplementationFactory:IMPLEMENTATION_REGISTRY	Lcom/amazon/inapp/purchasing/ImplementationRegistry;
    //   12: ifnonnull +19 -> 31
    //   15: invokestatic 28	com/amazon/inapp/purchasing/ImplementationFactory:isSandboxMode	()Z
    //   18: ifeq +20 -> 38
    //   21: new 30	com/amazon/inapp/purchasing/SandboxImplementationRegistry
    //   24: dup
    //   25: invokespecial 31	com/amazon/inapp/purchasing/SandboxImplementationRegistry:<init>	()V
    //   28: putstatic 24	com/amazon/inapp/purchasing/ImplementationFactory:IMPLEMENTATION_REGISTRY	Lcom/amazon/inapp/purchasing/ImplementationRegistry;
    //   31: ldc 2
    //   33: monitorexit
    //   34: getstatic 24	com/amazon/inapp/purchasing/ImplementationFactory:IMPLEMENTATION_REGISTRY	Lcom/amazon/inapp/purchasing/ImplementationRegistry;
    //   37: areturn
    //   38: new 33	com/amazon/inapp/purchasing/KiwiImplementationRegistry
    //   41: dup
    //   42: invokespecial 34	com/amazon/inapp/purchasing/KiwiImplementationRegistry:<init>	()V
    //   45: putstatic 24	com/amazon/inapp/purchasing/ImplementationFactory:IMPLEMENTATION_REGISTRY	Lcom/amazon/inapp/purchasing/ImplementationRegistry;
    //   48: goto -17 -> 31
    //   51: astore_0
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   51	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	31	51	finally
    //   31	34	51	finally
    //   38	48	51	finally
    //   52	55	51	finally
  }
  
  /* Error */
  private static <T> T getInstance(Class<T> paramClass, T paramT)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +42 -> 43
    //   4: ldc 2
    //   6: monitorenter
    //   7: aload_1
    //   8: astore_2
    //   9: aload_1
    //   10: ifnonnull +16 -> 26
    //   13: invokestatic 40	com/amazon/inapp/purchasing/ImplementationFactory:getImplementationRegistry	()Lcom/amazon/inapp/purchasing/ImplementationRegistry;
    //   16: aload_0
    //   17: invokeinterface 46 2 0
    //   22: invokevirtual 52	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   25: astore_2
    //   26: ldc 2
    //   28: monitorexit
    //   29: aload_2
    //   30: areturn
    //   31: astore_0
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: astore_0
    //   38: aload_1
    //   39: astore_2
    //   40: goto -14 -> 26
    //   43: aload_1
    //   44: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	paramClass	Class<T>
    //   0	45	1	paramT	T
    //   8	32	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	26	31	finally
    //   26	29	31	finally
    //   32	35	31	finally
    //   13	26	37	java/lang/Exception
  }
  
  static LogHandler getLogHandler()
  {
    if (LOG_HANDLER_INSTANCE != null) {
      return LOG_HANDLER_INSTANCE;
    }
    return (LogHandler)getInstance(LogHandler.class, LOG_HANDLER_INSTANCE);
  }
  
  static RequestHandler getRequestHandler()
  {
    if (REQUEST_HANDLER_INSTANCE != null) {
      return REQUEST_HANDLER_INSTANCE;
    }
    return (RequestHandler)getInstance(RequestHandler.class, REQUEST_HANDLER_INSTANCE);
  }
  
  static ResponseHandler getResponseHandler()
  {
    if (RESPONSE_HANDLER_INSTANCE != null) {
      return RESPONSE_HANDLER_INSTANCE;
    }
    return (ResponseHandler)getInstance(ResponseHandler.class, RESPONSE_HANDLER_INSTANCE);
  }
  
  static boolean isSandboxMode()
  {
    if (IS_SANDBOX_MODE_CHECKED) {
      return IS_SANDBOX_MODE;
    }
    try
    {
      if (IS_SANDBOX_MODE_CHECKED)
      {
        boolean bool = IS_SANDBOX_MODE;
        return bool;
      }
    }
    finally {}
    try
    {
      ImplementationFactory.class.getClassLoader().loadClass("com.amazon.android.Kiwi");
      IS_SANDBOX_MODE = false;
      IS_SANDBOX_MODE_CHECKED = true;
      return IS_SANDBOX_MODE;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        IS_SANDBOX_MODE = true;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazon/inapp/purchasing/ImplementationFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */