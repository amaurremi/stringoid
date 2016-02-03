package com.vladium.util.exit;

import com.vladium.util.IJREVersion;
import com.vladium.util.Property;
import java.util.HashMap;
import java.util.Map;

public abstract class ExitHookManager
  implements IJREVersion
{
  private static ExitHookManager s_singleton;
  
  public static ExitHookManager getSingleton()
  {
    try
    {
      if (s_singleton == null)
      {
        if (JRE_1_3_PLUS) {
          s_singleton = new JRE13ExitHookManager();
        }
      }
      else
      {
        ExitHookManager localExitHookManager = s_singleton;
        return localExitHookManager;
      }
      throw new UnsupportedOperationException("no shutdown hook manager available [JVM: " + Property.getSystemFingerprint() + "]");
    }
    finally {}
  }
  
  public abstract boolean addExitHook(Runnable paramRunnable);
  
  public abstract boolean removeExitHook(Runnable paramRunnable);
  
  private static final class JRE13ExitHookManager
    extends ExitHookManager
  {
    private final Map m_exitThreadMap = new HashMap();
    
    /* Error */
    public boolean addExitHook(Runnable paramRunnable)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: ifnull +68 -> 71
      //   6: aload_0
      //   7: getfield 16	com/vladium/util/exit/ExitHookManager$JRE13ExitHookManager:m_exitThreadMap	Ljava/util/Map;
      //   10: aload_1
      //   11: invokeinterface 27 2 0
      //   16: ifne +55 -> 71
      //   19: new 29	java/lang/Thread
      //   22: dup
      //   23: aload_1
      //   24: ldc 31
      //   26: invokespecial 34	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
      //   29: astore_3
      //   30: invokestatic 40	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
      //   33: aload_3
      //   34: invokevirtual 44	java/lang/Runtime:addShutdownHook	(Ljava/lang/Thread;)V
      //   37: aload_0
      //   38: getfield 16	com/vladium/util/exit/ExitHookManager$JRE13ExitHookManager:m_exitThreadMap	Ljava/util/Map;
      //   41: aload_1
      //   42: aload_3
      //   43: invokeinterface 48 3 0
      //   48: pop
      //   49: iconst_1
      //   50: istore_2
      //   51: aload_0
      //   52: monitorexit
      //   53: iload_2
      //   54: ireturn
      //   55: astore_1
      //   56: getstatic 54	java/lang/System:out	Ljava/io/PrintStream;
      //   59: ldc 56
      //   61: invokevirtual 62	java/io/PrintStream:println	(Ljava/lang/String;)V
      //   64: aload_1
      //   65: getstatic 54	java/lang/System:out	Ljava/io/PrintStream;
      //   68: invokevirtual 66	java/lang/Exception:printStackTrace	(Ljava/io/PrintStream;)V
      //   71: iconst_0
      //   72: istore_2
      //   73: goto -22 -> 51
      //   76: astore_1
      //   77: aload_0
      //   78: monitorexit
      //   79: aload_1
      //   80: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	81	0	this	JRE13ExitHookManager
      //   0	81	1	paramRunnable	Runnable
      //   50	23	2	bool	boolean
      //   29	14	3	localThread	Thread
      // Exception table:
      //   from	to	target	type
      //   30	49	55	java/lang/Exception
      //   6	30	76	finally
      //   30	49	76	finally
      //   56	71	76	finally
    }
    
    /* Error */
    public boolean removeExitHook(Runnable paramRunnable)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_1
      //   3: ifnull +62 -> 65
      //   6: aload_0
      //   7: getfield 16	com/vladium/util/exit/ExitHookManager$JRE13ExitHookManager:m_exitThreadMap	Ljava/util/Map;
      //   10: aload_1
      //   11: invokeinterface 71 2 0
      //   16: checkcast 29	java/lang/Thread
      //   19: astore_3
      //   20: aload_3
      //   21: ifnull +44 -> 65
      //   24: invokestatic 40	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
      //   27: aload_3
      //   28: invokevirtual 75	java/lang/Runtime:removeShutdownHook	(Ljava/lang/Thread;)Z
      //   31: pop
      //   32: aload_0
      //   33: getfield 16	com/vladium/util/exit/ExitHookManager$JRE13ExitHookManager:m_exitThreadMap	Ljava/util/Map;
      //   36: aload_1
      //   37: invokeinterface 78 2 0
      //   42: pop
      //   43: iconst_1
      //   44: istore_2
      //   45: aload_0
      //   46: monitorexit
      //   47: iload_2
      //   48: ireturn
      //   49: astore_1
      //   50: getstatic 54	java/lang/System:out	Ljava/io/PrintStream;
      //   53: ldc 80
      //   55: invokevirtual 62	java/io/PrintStream:println	(Ljava/lang/String;)V
      //   58: aload_1
      //   59: getstatic 54	java/lang/System:out	Ljava/io/PrintStream;
      //   62: invokevirtual 66	java/lang/Exception:printStackTrace	(Ljava/io/PrintStream;)V
      //   65: iconst_0
      //   66: istore_2
      //   67: goto -22 -> 45
      //   70: astore_1
      //   71: aload_0
      //   72: monitorexit
      //   73: aload_1
      //   74: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	75	0	this	JRE13ExitHookManager
      //   0	75	1	paramRunnable	Runnable
      //   44	23	2	bool	boolean
      //   19	9	3	localThread	Thread
      // Exception table:
      //   from	to	target	type
      //   24	43	49	java/lang/Exception
      //   6	20	70	finally
      //   24	43	70	finally
      //   50	65	70	finally
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/util/exit/ExitHookManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */