package com.vladium.emma.rt;

import com.vladium.emma.data.ICoverageData;
import java.io.File;

final class RTExitHook
  implements Runnable
{
  private static final String CLOSURE_RESOURCE = "RTExitHook.closure";
  private Class m_RT;
  private ICoverageData m_cdata;
  private final boolean m_merge;
  private final File m_outFile;
  
  RTExitHook(Class paramClass, ICoverageData paramICoverageData, File paramFile, boolean paramBoolean)
  {
    this.m_RT = paramClass;
    this.m_cdata = paramICoverageData;
    this.m_outFile = paramFile;
    this.m_merge = paramBoolean;
  }
  
  /* Error */
  public static void createClassLoaderClosure()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: aconst_null
    //   3: astore_2
    //   4: ldc 2
    //   6: ldc 10
    //   8: invokevirtual 43	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull +49 -> 62
    //   16: aload_1
    //   17: astore_2
    //   18: aload_1
    //   19: astore_0
    //   20: new 45	java/util/Properties
    //   23: dup
    //   24: invokespecial 46	java/util/Properties:<init>	()V
    //   27: astore_3
    //   28: aload_3
    //   29: aload_1
    //   30: invokevirtual 50	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   33: aload_1
    //   34: ifnull +7 -> 41
    //   37: aload_1
    //   38: invokevirtual 55	java/io/InputStream:close	()V
    //   41: aload_3
    //   42: ldc 57
    //   44: invokevirtual 61	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnonnull +100 -> 149
    //   52: new 63	java/lang/Error
    //   55: dup
    //   56: ldc 65
    //   58: invokespecial 68	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   61: athrow
    //   62: aload_1
    //   63: astore_2
    //   64: aload_1
    //   65: astore_0
    //   66: new 63	java/lang/Error
    //   69: dup
    //   70: ldc 70
    //   72: invokespecial 68	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   75: athrow
    //   76: astore_0
    //   77: aload_2
    //   78: astore_1
    //   79: aload_0
    //   80: astore_2
    //   81: aload_1
    //   82: astore_0
    //   83: aload_2
    //   84: getstatic 76	java/lang/System:out	Ljava/io/PrintStream;
    //   87: invokevirtual 80	java/lang/Exception:printStackTrace	(Ljava/io/PrintStream;)V
    //   90: aload_1
    //   91: astore_0
    //   92: new 63	java/lang/Error
    //   95: dup
    //   96: new 82	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   103: ldc 85
    //   105: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_2
    //   109: invokevirtual 93	java/lang/Exception:toString	()Ljava/lang/String;
    //   112: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 68	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: ifnull +7 -> 131
    //   127: aload_0
    //   128: invokevirtual 55	java/io/InputStream:close	()V
    //   131: aload_1
    //   132: athrow
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   138: goto -97 -> 41
    //   141: astore_0
    //   142: aload_0
    //   143: invokevirtual 96	java/io/IOException:printStackTrace	()V
    //   146: goto -15 -> 131
    //   149: ldc 2
    //   151: invokevirtual 100	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   154: astore_0
    //   155: new 102	java/util/StringTokenizer
    //   158: dup
    //   159: aload_1
    //   160: ldc 104
    //   162: invokespecial 107	java/util/StringTokenizer:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: astore_2
    //   166: aload_2
    //   167: invokevirtual 111	java/util/StringTokenizer:hasMoreTokens	()Z
    //   170: ifeq +63 -> 233
    //   173: aload_2
    //   174: invokevirtual 114	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   177: astore_1
    //   178: aload_1
    //   179: iconst_1
    //   180: aload_0
    //   181: invokestatic 118	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   184: pop
    //   185: goto -19 -> 166
    //   188: astore_0
    //   189: new 63	java/lang/Error
    //   192: dup
    //   193: new 82	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   200: ldc 120
    //   202: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 122
    //   211: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_0
    //   215: invokevirtual 93	java/lang/Exception:toString	()Ljava/lang/String;
    //   218: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc 124
    //   223: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokespecial 68	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   232: athrow
    //   233: return
    //   234: astore_2
    //   235: aload_1
    //   236: astore_0
    //   237: aload_2
    //   238: astore_1
    //   239: goto -116 -> 123
    //   242: astore_2
    //   243: goto -162 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	65	0	localObject1	Object
    //   76	4	0	localException1	Exception
    //   82	46	0	localObject2	Object
    //   133	2	0	localIOException1	java.io.IOException
    //   141	2	0	localIOException2	java.io.IOException
    //   154	27	0	localClassLoader	ClassLoader
    //   188	27	0	localException2	Exception
    //   236	1	0	localObject3	Object
    //   11	80	1	localObject4	Object
    //   122	38	1	str	String
    //   177	62	1	localObject5	Object
    //   3	171	2	localObject6	Object
    //   234	4	2	localObject7	Object
    //   242	1	2	localException3	Exception
    //   27	15	3	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   4	12	76	java/lang/Exception
    //   20	28	76	java/lang/Exception
    //   66	76	76	java/lang/Exception
    //   4	12	122	finally
    //   20	28	122	finally
    //   66	76	122	finally
    //   83	90	122	finally
    //   92	122	122	finally
    //   37	41	133	java/io/IOException
    //   127	131	141	java/io/IOException
    //   178	185	188	java/lang/Exception
    //   28	33	234	finally
    //   28	33	242	java/lang/Exception
  }
  
  public void run()
  {
    try
    {
      if (this.m_cdata != null)
      {
        RTCoverageDataPersister.dumpCoverageData(this.m_cdata, true, this.m_outFile, this.m_merge);
        this.m_RT = null;
        this.m_cdata = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/rt/RTExitHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */