package com.tapstream.sdk;

import java.io.PrintStream;
import java.lang.reflect.Method;

public class Logging {
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static Method formatMethod;
    private static Logger logger = new DefaultLogger(null);

    static {
        try {
            formatMethod = String.class.getDeclaredMethod("format", new Class[]{String.class, Object[].class});
            return;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    /* Error */
    public static void log(int paramInt, String paramString, Object... paramVarArgs) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: getstatic 30	com/tapstream/sdk/Logging:logger	Lcom/tapstream/sdk/Logger;
        //   6: ifnull +36 -> 42
        //   9: getstatic 44	com/tapstream/sdk/Logging:formatMethod	Ljava/lang/reflect/Method;
        //   12: aconst_null
        //   13: iconst_2
        //   14: anewarray 4	java/lang/Object
        //   17: dup
        //   18: iconst_0
        //   19: aload_1
        //   20: aastore
        //   21: dup
        //   22: iconst_1
        //   23: aload_2
        //   24: aastore
        //   25: invokevirtual 58	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   28: checkcast 32	java/lang/String
        //   31: astore_1
        //   32: getstatic 30	com/tapstream/sdk/Logging:logger	Lcom/tapstream/sdk/Logger;
        //   35: iload_0
        //   36: aload_1
        //   37: invokeinterface 63 3 0
        //   42: ldc 2
        //   44: monitorexit
        //   45: return
        //   46: astore_1
        //   47: aload_1
        //   48: invokevirtual 47	java/lang/Exception:printStackTrace	()V
        //   51: ldc 65
        //   53: astore_1
        //   54: goto -22 -> 32
        //   57: astore_1
        //   58: ldc 2
        //   60: monitorexit
        //   61: aload_1
        //   62: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	63	0	paramInt	int
        //   0	63	1	paramString	String
        //   0	63	2	paramVarArgs	Object[]
        // Exception table:
        //   from	to	target	type
        //   9	32	46	java/lang/Exception
        //   3	9	57	finally
        //   9	32	57	finally
        //   32	42	57	finally
        //   47	51	57	finally
    }

    public static void setLogger(Logger paramLogger) {
        try {
            logger = paramLogger;
            return;
        } finally {
            paramLogger =finally;
            throw paramLogger;
        }
    }

    private static class DefaultLogger
            implements Logger {
        public void log(int paramInt, String paramString) {
            System.out.println(paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/Logging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */