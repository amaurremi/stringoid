package org.apache.commons.logging;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.security.AccessController;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

public abstract class LogFactory
{
  public static final String DIAGNOSTICS_DEST_PROPERTY = "org.apache.commons.logging.diagnostics.dest";
  public static final String FACTORY_DEFAULT = "org.apache.commons.logging.impl.LogFactoryImpl";
  public static final String FACTORY_PROPERTIES = "commons-logging.properties";
  public static final String FACTORY_PROPERTY = "org.apache.commons.logging.LogFactory";
  public static final String HASHTABLE_IMPLEMENTATION_PROPERTY = "org.apache.commons.logging.LogFactory.HashtableImpl";
  public static final String PRIORITY_KEY = "priority";
  protected static final String SERVICE_ID = "META-INF/services/org.apache.commons.logging.LogFactory";
  public static final String TCCL_KEY = "use_tccl";
  private static final String WEAK_HASHTABLE_CLASSNAME = "org.apache.commons.logging.impl.WeakHashtable";
  private static String diagnosticPrefix;
  private static PrintStream diagnosticsStream = null;
  protected static Hashtable factories = null;
  protected static LogFactory nullClassLoaderFactory = null;
  private static ClassLoader thisClassLoader;
  
  static
  {
    Class localClass;
    if (class$org$apache$commons$logging$LogFactory == null)
    {
      localClass = class$("org.apache.commons.logging.LogFactory");
      class$org$apache$commons$logging$LogFactory = localClass;
      thisClassLoader = getClassLoader(localClass);
      initDiagnostics();
      if (class$org$apache$commons$logging$LogFactory != null) {
        break label83;
      }
      localClass = class$("org.apache.commons.logging.LogFactory");
      class$org$apache$commons$logging$LogFactory = localClass;
    }
    for (;;)
    {
      logClassLoaderEnvironment(localClass);
      factories = createFactoryStore();
      if (isDiagnosticsEnabled()) {
        logDiagnostic("BOOTSTRAP COMPLETED");
      }
      return;
      localClass = class$org$apache$commons$logging$LogFactory;
      break;
      label83:
      localClass = class$org$apache$commons$logging$LogFactory;
    }
  }
  
  private static void cacheFactory(ClassLoader paramClassLoader, LogFactory paramLogFactory)
  {
    if (paramLogFactory != null)
    {
      if (paramClassLoader == null) {
        nullClassLoaderFactory = paramLogFactory;
      }
    }
    else {
      return;
    }
    factories.put(paramClassLoader, paramLogFactory);
  }
  
  /* Error */
  protected static Object createFactory(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_1
    //   13: ifnull +881 -> 894
    //   16: aload_1
    //   17: aload_0
    //   18: invokevirtual 126	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   21: astore 4
    //   23: aload 4
    //   25: astore 6
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: astore 7
    //   34: aload 4
    //   36: astore 5
    //   38: getstatic 54	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   41: ifnonnull +168 -> 209
    //   44: aload 4
    //   46: astore 6
    //   48: aload 4
    //   50: astore_3
    //   51: aload 4
    //   53: astore 7
    //   55: aload 4
    //   57: astore 5
    //   59: ldc 17
    //   61: invokestatic 58	org/apache/commons/logging/LogFactory:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   64: astore 8
    //   66: aload 4
    //   68: astore 6
    //   70: aload 4
    //   72: astore_3
    //   73: aload 4
    //   75: astore 7
    //   77: aload 4
    //   79: astore 5
    //   81: aload 8
    //   83: putstatic 54	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   86: aload 4
    //   88: astore 6
    //   90: aload 4
    //   92: astore_3
    //   93: aload 4
    //   95: astore 7
    //   97: aload 4
    //   99: astore 5
    //   101: aload 8
    //   103: aload 4
    //   105: invokevirtual 130	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   108: ifeq +124 -> 232
    //   111: aload 4
    //   113: astore 6
    //   115: aload 4
    //   117: astore_3
    //   118: aload 4
    //   120: astore 7
    //   122: aload 4
    //   124: astore 5
    //   126: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   129: ifeq +56 -> 185
    //   132: aload 4
    //   134: astore 6
    //   136: aload 4
    //   138: astore_3
    //   139: aload 4
    //   141: astore 7
    //   143: aload 4
    //   145: astore 5
    //   147: new 132	java/lang/StringBuffer
    //   150: dup
    //   151: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   154: ldc -121
    //   156: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   159: aload 4
    //   161: invokevirtual 142	java/lang/Class:getName	()Ljava/lang/String;
    //   164: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   167: ldc -112
    //   169: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   172: aload_1
    //   173: invokestatic 148	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   176: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   179: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   182: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   185: aload 4
    //   187: astore 6
    //   189: aload 4
    //   191: astore_3
    //   192: aload 4
    //   194: astore 7
    //   196: aload 4
    //   198: astore 5
    //   200: aload 4
    //   202: invokevirtual 155	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   205: checkcast 2	org/apache/commons/logging/LogFactory
    //   208: areturn
    //   209: aload 4
    //   211: astore 6
    //   213: aload 4
    //   215: astore_3
    //   216: aload 4
    //   218: astore 7
    //   220: aload 4
    //   222: astore 5
    //   224: getstatic 54	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   227: astore 8
    //   229: goto -143 -> 86
    //   232: aload 4
    //   234: astore 6
    //   236: aload 4
    //   238: astore_3
    //   239: aload 4
    //   241: astore 7
    //   243: aload 4
    //   245: astore 5
    //   247: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   250: ifeq -65 -> 185
    //   253: aload 4
    //   255: astore 6
    //   257: aload 4
    //   259: astore_3
    //   260: aload 4
    //   262: astore 7
    //   264: aload 4
    //   266: astore 5
    //   268: new 132	java/lang/StringBuffer
    //   271: dup
    //   272: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   275: ldc -99
    //   277: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   280: aload 4
    //   282: invokevirtual 142	java/lang/Class:getName	()Ljava/lang/String;
    //   285: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   288: ldc -97
    //   290: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   293: aload 4
    //   295: invokevirtual 162	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   298: invokestatic 148	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   301: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   304: ldc -92
    //   306: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   309: astore 9
    //   311: aload 4
    //   313: astore 6
    //   315: aload 4
    //   317: astore_3
    //   318: aload 4
    //   320: astore 7
    //   322: aload 4
    //   324: astore 5
    //   326: getstatic 54	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   329: ifnonnull +226 -> 555
    //   332: aload 4
    //   334: astore 6
    //   336: aload 4
    //   338: astore_3
    //   339: aload 4
    //   341: astore 7
    //   343: aload 4
    //   345: astore 5
    //   347: ldc 17
    //   349: invokestatic 58	org/apache/commons/logging/LogFactory:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   352: astore 8
    //   354: aload 4
    //   356: astore 6
    //   358: aload 4
    //   360: astore_3
    //   361: aload 4
    //   363: astore 7
    //   365: aload 4
    //   367: astore 5
    //   369: aload 8
    //   371: putstatic 54	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   374: aload 4
    //   376: astore 6
    //   378: aload 4
    //   380: astore_3
    //   381: aload 4
    //   383: astore 7
    //   385: aload 4
    //   387: astore 5
    //   389: aload 9
    //   391: aload 8
    //   393: invokevirtual 142	java/lang/Class:getName	()Ljava/lang/String;
    //   396: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   399: ldc -90
    //   401: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   404: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   407: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   410: aload 4
    //   412: astore 6
    //   414: aload 4
    //   416: astore_3
    //   417: aload 4
    //   419: astore 7
    //   421: aload 4
    //   423: astore 5
    //   425: ldc -88
    //   427: aload_1
    //   428: invokestatic 172	org/apache/commons/logging/LogFactory:logHierarchy	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   431: goto -246 -> 185
    //   434: astore 5
    //   436: aload 6
    //   438: astore_3
    //   439: aload 6
    //   441: astore 4
    //   443: aload_1
    //   444: getstatic 64	org/apache/commons/logging/LogFactory:thisClassLoader	Ljava/lang/ClassLoader;
    //   447: if_acmpne +447 -> 894
    //   450: aload 6
    //   452: astore_3
    //   453: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   456: ifeq +40 -> 496
    //   459: aload 6
    //   461: astore_3
    //   462: new 132	java/lang/StringBuffer
    //   465: dup
    //   466: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   469: ldc -82
    //   471: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   474: aload_0
    //   475: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   478: ldc -80
    //   480: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   483: aload_1
    //   484: invokestatic 148	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   487: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   490: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   493: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   496: aload 6
    //   498: astore_3
    //   499: aload 5
    //   501: athrow
    //   502: astore_0
    //   503: aload_3
    //   504: astore_1
    //   505: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   508: ifeq +8 -> 516
    //   511: ldc -78
    //   513: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   516: aload_1
    //   517: ifnull +446 -> 963
    //   520: getstatic 54	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   523: ifnonnull +433 -> 956
    //   526: ldc 17
    //   528: invokestatic 58	org/apache/commons/logging/LogFactory:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   531: astore_3
    //   532: aload_3
    //   533: putstatic 54	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   536: aload_3
    //   537: aload_1
    //   538: invokevirtual 130	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   541: ifne +422 -> 963
    //   544: new 180	org/apache/commons/logging/LogConfigurationException
    //   547: dup
    //   548: ldc -74
    //   550: aload_0
    //   551: invokespecial 185	org/apache/commons/logging/LogConfigurationException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   554: areturn
    //   555: aload 4
    //   557: astore 6
    //   559: aload 4
    //   561: astore_3
    //   562: aload 4
    //   564: astore 7
    //   566: aload 4
    //   568: astore 5
    //   570: getstatic 54	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   573: astore 8
    //   575: goto -201 -> 374
    //   578: astore 5
    //   580: aload 7
    //   582: astore_3
    //   583: aload 7
    //   585: astore 4
    //   587: aload_1
    //   588: getstatic 64	org/apache/commons/logging/LogFactory:thisClassLoader	Ljava/lang/ClassLoader;
    //   591: if_acmpne +303 -> 894
    //   594: aload 7
    //   596: astore_3
    //   597: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   600: ifeq +55 -> 655
    //   603: aload 7
    //   605: astore_3
    //   606: new 132	java/lang/StringBuffer
    //   609: dup
    //   610: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   613: ldc -69
    //   615: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   618: aload_0
    //   619: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   622: ldc -67
    //   624: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   627: ldc -65
    //   629: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   632: aload_1
    //   633: invokestatic 148	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   636: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   639: ldc -63
    //   641: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   644: ldc -61
    //   646: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   649: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   652: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   655: aload 7
    //   657: astore_3
    //   658: aload 5
    //   660: athrow
    //   661: astore_3
    //   662: aload 5
    //   664: astore_3
    //   665: aload 5
    //   667: astore 4
    //   669: aload_1
    //   670: getstatic 64	org/apache/commons/logging/LogFactory:thisClassLoader	Ljava/lang/ClassLoader;
    //   673: if_acmpne +221 -> 894
    //   676: aload 5
    //   678: astore_3
    //   679: aload 5
    //   681: invokestatic 198	org/apache/commons/logging/LogFactory:implementsLogFactory	(Ljava/lang/Class;)Z
    //   684: istore_2
    //   685: aload 5
    //   687: astore_3
    //   688: new 132	java/lang/StringBuffer
    //   691: dup
    //   692: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   695: ldc -56
    //   697: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   700: aload_0
    //   701: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   704: ldc -54
    //   706: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   709: astore_1
    //   710: aload 5
    //   712: astore_3
    //   713: getstatic 54	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   716: ifnonnull +142 -> 858
    //   719: aload 5
    //   721: astore_3
    //   722: ldc 17
    //   724: invokestatic 58	org/apache/commons/logging/LogFactory:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   727: astore_0
    //   728: aload 5
    //   730: astore_3
    //   731: aload_0
    //   732: putstatic 54	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   735: aload 5
    //   737: astore_3
    //   738: aload_1
    //   739: aload_0
    //   740: invokevirtual 142	java/lang/Class:getName	()Ljava/lang/String;
    //   743: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   746: ldc -52
    //   748: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   751: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   754: astore_0
    //   755: iload_2
    //   756: ifeq +112 -> 868
    //   759: aload 5
    //   761: astore_3
    //   762: new 132	java/lang/StringBuffer
    //   765: dup
    //   766: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   769: aload_0
    //   770: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   773: ldc -50
    //   775: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   778: ldc -48
    //   780: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   783: ldc -46
    //   785: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   788: ldc -44
    //   790: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   793: ldc -42
    //   795: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   798: ldc -40
    //   800: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   803: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   806: astore_0
    //   807: aload 5
    //   809: astore_3
    //   810: new 132	java/lang/StringBuffer
    //   813: dup
    //   814: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   817: aload_0
    //   818: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   821: ldc -38
    //   823: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   826: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   829: astore_0
    //   830: aload 5
    //   832: astore_3
    //   833: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   836: ifeq +10 -> 846
    //   839: aload 5
    //   841: astore_3
    //   842: aload_0
    //   843: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   846: aload 5
    //   848: astore_3
    //   849: new 119	java/lang/ClassCastException
    //   852: dup
    //   853: aload_0
    //   854: invokespecial 219	java/lang/ClassCastException:<init>	(Ljava/lang/String;)V
    //   857: athrow
    //   858: aload 5
    //   860: astore_3
    //   861: getstatic 54	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   864: astore_0
    //   865: goto -130 -> 735
    //   868: aload 5
    //   870: astore_3
    //   871: new 132	java/lang/StringBuffer
    //   874: dup
    //   875: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   878: aload_0
    //   879: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   882: ldc -35
    //   884: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   887: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   890: astore_0
    //   891: goto -84 -> 807
    //   894: aload 4
    //   896: astore_3
    //   897: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   900: ifeq +36 -> 936
    //   903: aload 4
    //   905: astore_3
    //   906: new 132	java/lang/StringBuffer
    //   909: dup
    //   910: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   913: ldc -33
    //   915: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   918: aload_1
    //   919: invokestatic 148	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   922: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   925: ldc -31
    //   927: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   930: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   933: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   936: aload 4
    //   938: astore_3
    //   939: aload_0
    //   940: invokestatic 105	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   943: astore_0
    //   944: aload_0
    //   945: astore_3
    //   946: aload_0
    //   947: invokevirtual 155	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   950: checkcast 2	org/apache/commons/logging/LogFactory
    //   953: astore_0
    //   954: aload_0
    //   955: areturn
    //   956: getstatic 54	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   959: astore_3
    //   960: goto -424 -> 536
    //   963: new 180	org/apache/commons/logging/LogConfigurationException
    //   966: dup
    //   967: aload_0
    //   968: invokespecial 228	org/apache/commons/logging/LogConfigurationException:<init>	(Ljava/lang/Throwable;)V
    //   971: areturn
    //   972: astore_0
    //   973: aconst_null
    //   974: astore_1
    //   975: goto -470 -> 505
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	978	0	paramString	String
    //   0	978	1	paramClassLoader	ClassLoader
    //   684	72	2	bool	boolean
    //   29	629	3	localObject1	Object
    //   661	1	3	localClassCastException	ClassCastException
    //   664	296	3	localObject2	Object
    //   7	930	4	localObject3	Object
    //   4	420	5	localObject4	Object
    //   434	66	5	localClassNotFoundException	ClassNotFoundException
    //   568	1	5	localObject5	Object
    //   578	291	5	localNoClassDefFoundError	NoClassDefFoundError
    //   10	548	6	localObject6	Object
    //   1	655	7	localObject7	Object
    //   64	510	8	localClass	Class
    //   309	81	9	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   16	23	434	java/lang/ClassNotFoundException
    //   38	44	434	java/lang/ClassNotFoundException
    //   59	66	434	java/lang/ClassNotFoundException
    //   81	86	434	java/lang/ClassNotFoundException
    //   101	111	434	java/lang/ClassNotFoundException
    //   126	132	434	java/lang/ClassNotFoundException
    //   147	185	434	java/lang/ClassNotFoundException
    //   200	209	434	java/lang/ClassNotFoundException
    //   224	229	434	java/lang/ClassNotFoundException
    //   247	253	434	java/lang/ClassNotFoundException
    //   268	311	434	java/lang/ClassNotFoundException
    //   326	332	434	java/lang/ClassNotFoundException
    //   347	354	434	java/lang/ClassNotFoundException
    //   369	374	434	java/lang/ClassNotFoundException
    //   389	410	434	java/lang/ClassNotFoundException
    //   425	431	434	java/lang/ClassNotFoundException
    //   570	575	434	java/lang/ClassNotFoundException
    //   38	44	502	java/lang/Exception
    //   59	66	502	java/lang/Exception
    //   81	86	502	java/lang/Exception
    //   101	111	502	java/lang/Exception
    //   126	132	502	java/lang/Exception
    //   147	185	502	java/lang/Exception
    //   200	209	502	java/lang/Exception
    //   224	229	502	java/lang/Exception
    //   247	253	502	java/lang/Exception
    //   268	311	502	java/lang/Exception
    //   326	332	502	java/lang/Exception
    //   347	354	502	java/lang/Exception
    //   369	374	502	java/lang/Exception
    //   389	410	502	java/lang/Exception
    //   425	431	502	java/lang/Exception
    //   443	450	502	java/lang/Exception
    //   453	459	502	java/lang/Exception
    //   462	496	502	java/lang/Exception
    //   499	502	502	java/lang/Exception
    //   570	575	502	java/lang/Exception
    //   587	594	502	java/lang/Exception
    //   597	603	502	java/lang/Exception
    //   606	655	502	java/lang/Exception
    //   658	661	502	java/lang/Exception
    //   669	676	502	java/lang/Exception
    //   679	685	502	java/lang/Exception
    //   688	710	502	java/lang/Exception
    //   713	719	502	java/lang/Exception
    //   722	728	502	java/lang/Exception
    //   731	735	502	java/lang/Exception
    //   738	755	502	java/lang/Exception
    //   762	807	502	java/lang/Exception
    //   810	830	502	java/lang/Exception
    //   833	839	502	java/lang/Exception
    //   842	846	502	java/lang/Exception
    //   849	858	502	java/lang/Exception
    //   861	865	502	java/lang/Exception
    //   871	891	502	java/lang/Exception
    //   897	903	502	java/lang/Exception
    //   906	936	502	java/lang/Exception
    //   939	944	502	java/lang/Exception
    //   946	954	502	java/lang/Exception
    //   16	23	578	java/lang/NoClassDefFoundError
    //   38	44	578	java/lang/NoClassDefFoundError
    //   59	66	578	java/lang/NoClassDefFoundError
    //   81	86	578	java/lang/NoClassDefFoundError
    //   101	111	578	java/lang/NoClassDefFoundError
    //   126	132	578	java/lang/NoClassDefFoundError
    //   147	185	578	java/lang/NoClassDefFoundError
    //   200	209	578	java/lang/NoClassDefFoundError
    //   224	229	578	java/lang/NoClassDefFoundError
    //   247	253	578	java/lang/NoClassDefFoundError
    //   268	311	578	java/lang/NoClassDefFoundError
    //   326	332	578	java/lang/NoClassDefFoundError
    //   347	354	578	java/lang/NoClassDefFoundError
    //   369	374	578	java/lang/NoClassDefFoundError
    //   389	410	578	java/lang/NoClassDefFoundError
    //   425	431	578	java/lang/NoClassDefFoundError
    //   570	575	578	java/lang/NoClassDefFoundError
    //   16	23	661	java/lang/ClassCastException
    //   38	44	661	java/lang/ClassCastException
    //   59	66	661	java/lang/ClassCastException
    //   81	86	661	java/lang/ClassCastException
    //   101	111	661	java/lang/ClassCastException
    //   126	132	661	java/lang/ClassCastException
    //   147	185	661	java/lang/ClassCastException
    //   200	209	661	java/lang/ClassCastException
    //   224	229	661	java/lang/ClassCastException
    //   247	253	661	java/lang/ClassCastException
    //   268	311	661	java/lang/ClassCastException
    //   326	332	661	java/lang/ClassCastException
    //   347	354	661	java/lang/ClassCastException
    //   369	374	661	java/lang/ClassCastException
    //   389	410	661	java/lang/ClassCastException
    //   425	431	661	java/lang/ClassCastException
    //   570	575	661	java/lang/ClassCastException
    //   16	23	972	java/lang/Exception
  }
  
  private static final Hashtable createFactoryStore()
  {
    try
    {
      Object localObject1 = getSystemProperty("org.apache.commons.logging.LogFactory.HashtableImpl", null);
      if (localObject1 == null)
      {
        localObject1 = "org.apache.commons.logging.impl.WeakHashtable";
        try
        {
          localObject3 = (Hashtable)Class.forName((String)localObject1).newInstance();
          localObject1 = localObject3;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Object localObject3;
            Object localObject2;
            if (!"org.apache.commons.logging.impl.WeakHashtable".equals(localObject2))
            {
              if (isDiagnosticsEnabled())
              {
                logDiagnostic("[ERROR] LogFactory: Load of custom hashtable failed");
                localObject2 = null;
              }
              else
              {
                System.err.println("[ERROR] LogFactory: Load of custom hashtable failed");
              }
            }
            else {
              localObject2 = null;
            }
          }
        }
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new Hashtable();
        }
        return (Hashtable)localObject3;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        localObject2 = null;
      }
    }
  }
  
  /* Error */
  protected static ClassLoader directGetContextClassLoader()
  {
    // Byte code:
    //   0: getstatic 262	org/apache/commons/logging/LogFactory:class$java$lang$Thread	Ljava/lang/Class;
    //   3: ifnonnull +43 -> 46
    //   6: ldc_w 264
    //   9: invokestatic 58	org/apache/commons/logging/LogFactory:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   12: astore_0
    //   13: aload_0
    //   14: putstatic 262	org/apache/commons/logging/LogFactory:class$java$lang$Thread	Ljava/lang/Class;
    //   17: aload_0
    //   18: ldc_w 266
    //   21: aconst_null
    //   22: checkcast 268	[Ljava/lang/Class;
    //   25: invokevirtual 272	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   28: astore_0
    //   29: aload_0
    //   30: invokestatic 278	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   33: aconst_null
    //   34: checkcast 280	[Ljava/lang/Object;
    //   37: invokevirtual 286	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 123	java/lang/ClassLoader
    //   43: astore_0
    //   44: aload_0
    //   45: areturn
    //   46: getstatic 262	org/apache/commons/logging/LogFactory:class$java$lang$Thread	Ljava/lang/Class;
    //   49: astore_0
    //   50: goto -33 -> 17
    //   53: astore_0
    //   54: new 180	org/apache/commons/logging/LogConfigurationException
    //   57: dup
    //   58: ldc_w 288
    //   61: aload_0
    //   62: invokespecial 185	org/apache/commons/logging/LogConfigurationException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   65: athrow
    //   66: astore_0
    //   67: getstatic 54	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   70: ifnonnull +46 -> 116
    //   73: ldc 17
    //   75: invokestatic 58	org/apache/commons/logging/LogFactory:class$	(Ljava/lang/String;)Ljava/lang/Class;
    //   78: astore_0
    //   79: aload_0
    //   80: putstatic 54	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   83: aload_0
    //   84: invokestatic 62	org/apache/commons/logging/LogFactory:getClassLoader	(Ljava/lang/Class;)Ljava/lang/ClassLoader;
    //   87: areturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 292	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   93: instanceof 230
    //   96: ifeq +5 -> 101
    //   99: aconst_null
    //   100: areturn
    //   101: new 180	org/apache/commons/logging/LogConfigurationException
    //   104: dup
    //   105: ldc_w 294
    //   108: aload_0
    //   109: invokevirtual 292	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   112: invokespecial 185	org/apache/commons/logging/LogConfigurationException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: athrow
    //   116: getstatic 54	org/apache/commons/logging/LogFactory:class$org$apache$commons$logging$LogFactory	Ljava/lang/Class;
    //   119: astore_0
    //   120: goto -37 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	38	0	localObject	Object
    //   53	9	0	localIllegalAccessException	IllegalAccessException
    //   66	1	0	localNoSuchMethodException	NoSuchMethodException
    //   78	6	0	localClass1	Class
    //   88	21	0	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   119	1	0	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   29	44	53	java/lang/IllegalAccessException
    //   0	17	66	java/lang/NoSuchMethodException
    //   17	29	66	java/lang/NoSuchMethodException
    //   29	44	66	java/lang/NoSuchMethodException
    //   46	50	66	java/lang/NoSuchMethodException
    //   54	66	66	java/lang/NoSuchMethodException
    //   89	99	66	java/lang/NoSuchMethodException
    //   101	116	66	java/lang/NoSuchMethodException
    //   29	44	88	java/lang/reflect/InvocationTargetException
  }
  
  private static LogFactory getCachedFactory(ClassLoader paramClassLoader)
  {
    if (paramClassLoader == null) {
      return nullClassLoaderFactory;
    }
    return (LogFactory)factories.get(paramClassLoader);
  }
  
  protected static ClassLoader getClassLoader(Class paramClass)
  {
    try
    {
      ClassLoader localClassLoader = paramClass.getClassLoader();
      return localClassLoader;
    }
    catch (SecurityException localSecurityException)
    {
      if (isDiagnosticsEnabled()) {
        logDiagnostic("Unable to get classloader for class '" + paramClass + "' due to security restrictions - " + localSecurityException.getMessage());
      }
      throw localSecurityException;
    }
  }
  
  private static final Properties getConfigurationFile(ClassLoader paramClassLoader, String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    double d1 = 0.0D;
    Object localObject2 = null;
    Object localObject4 = null;
    for (;;)
    {
      Object localObject5;
      try
      {
        Enumeration localEnumeration = getResources(paramClassLoader, paramString);
        paramClassLoader = (ClassLoader)localObject4;
        if (localEnumeration == null) {
          return null;
        }
        localObject2 = paramClassLoader;
        localObject3 = localObject1;
        localObject4 = paramClassLoader;
        localObject5 = localObject1;
        if (localEnumeration.hasMoreElements())
        {
          localObject2 = paramClassLoader;
          localObject3 = localObject1;
          localObject5 = (URL)localEnumeration.nextElement();
          localObject2 = paramClassLoader;
          localObject3 = localObject1;
          localObject4 = getProperties((URL)localObject5);
          if (localObject4 != null) {
            if (localObject1 != null) {}
          }
        }
      }
      catch (SecurityException paramClassLoader)
      {
        String str;
        localObject4 = localObject2;
        localObject5 = localObject3;
        if (isDiagnosticsEnabled())
        {
          logDiagnostic("SecurityException thrown while trying to find/read config files.");
          localObject5 = localObject3;
          localObject4 = localObject2;
        }
        if (!isDiagnosticsEnabled()) {
          continue;
        }
        if (localObject5 == null)
        {
          logDiagnostic("[LOOKUP] No properties file of name '" + paramString + "' found.");
          return (Properties)localObject5;
        }
        logDiagnostic("[LOOKUP] Properties file of name '" + paramString + "' found at '" + localObject4 + '"');
        return (Properties)localObject5;
        return (Properties)localObject5;
      }
      try
      {
        paramClassLoader = ((Properties)localObject4).getProperty("priority");
        d1 = 0.0D;
        if (paramClassLoader != null) {
          d1 = Double.parseDouble(paramClassLoader);
        }
        if (isDiagnosticsEnabled()) {
          logDiagnostic("[LOOKUP] Properties file found at '" + localObject5 + "'" + " with priority " + d1);
        }
        paramClassLoader = (ClassLoader)localObject4;
        localObject1 = localObject5;
        localObject2 = paramClassLoader;
        paramClassLoader = (ClassLoader)localObject1;
        localObject1 = localObject2;
      }
      catch (SecurityException paramClassLoader)
      {
        localObject2 = localObject5;
        localObject3 = localObject4;
        continue;
      }
      localObject2 = paramClassLoader;
      localObject3 = localObject1;
      str = ((Properties)localObject4).getProperty("priority");
      double d2 = 0.0D;
      if (str != null)
      {
        localObject2 = paramClassLoader;
        localObject3 = localObject1;
        d2 = Double.parseDouble(str);
      }
      if (d2 > d1)
      {
        localObject2 = paramClassLoader;
        localObject3 = localObject1;
        if (isDiagnosticsEnabled())
        {
          localObject2 = paramClassLoader;
          localObject3 = localObject1;
          logDiagnostic("[LOOKUP] Properties file at '" + localObject5 + "'" + " with priority " + d2 + " overrides file at '" + paramClassLoader + "'" + " with priority " + d1);
        }
      }
      else
      {
        localObject2 = paramClassLoader;
        localObject3 = localObject1;
        if (isDiagnosticsEnabled())
        {
          localObject2 = paramClassLoader;
          localObject3 = localObject1;
          logDiagnostic("[LOOKUP] Properties file at '" + localObject5 + "'" + " with priority " + d2 + " does not override file at '" + paramClassLoader + "'" + " with priority " + d1);
        }
        localObject2 = localObject1;
        localObject1 = paramClassLoader;
        paramClassLoader = (ClassLoader)localObject2;
        continue;
      }
      d1 = d2;
      paramClassLoader = (ClassLoader)localObject4;
      localObject1 = localObject5;
    }
  }
  
  protected static ClassLoader getContextClassLoader()
  {
    return directGetContextClassLoader();
  }
  
  private static ClassLoader getContextClassLoaderInternal()
  {
    return (ClassLoader)AccessController.doPrivileged(new LogFactory.1());
  }
  
  /* Error */
  public static LogFactory getFactory()
  {
    // Byte code:
    //   0: invokestatic 387	org/apache/commons/logging/LogFactory:getContextClassLoaderInternal	()Ljava/lang/ClassLoader;
    //   3: astore_3
    //   4: aload_3
    //   5: ifnonnull +15 -> 20
    //   8: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   11: ifeq +9 -> 20
    //   14: ldc_w 389
    //   17: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   20: aload_3
    //   21: invokestatic 391	org/apache/commons/logging/LogFactory:getCachedFactory	(Ljava/lang/ClassLoader;)Lorg/apache/commons/logging/LogFactory;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +7 -> 33
    //   29: aload_0
    //   30: astore_1
    //   31: aload_1
    //   32: areturn
    //   33: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   36: ifeq +36 -> 72
    //   39: new 132	java/lang/StringBuffer
    //   42: dup
    //   43: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   46: ldc_w 393
    //   49: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   52: aload_3
    //   53: invokestatic 148	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   56: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   59: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   62: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   65: ldc_w 395
    //   68: aload_3
    //   69: invokestatic 172	org/apache/commons/logging/LogFactory:logHierarchy	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   72: aload_3
    //   73: ldc 14
    //   75: invokestatic 397	org/apache/commons/logging/LogFactory:getConfigurationFile	(Ljava/lang/ClassLoader;Ljava/lang/String;)Ljava/util/Properties;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnull +646 -> 728
    //   85: aload 4
    //   87: ldc 29
    //   89: invokevirtual 333	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +634 -> 728
    //   97: aload_1
    //   98: invokestatic 403	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   101: invokevirtual 406	java/lang/Boolean:booleanValue	()Z
    //   104: ifne +624 -> 728
    //   107: getstatic 64	org/apache/commons/logging/LogFactory:thisClassLoader	Ljava/lang/ClassLoader;
    //   110: astore_2
    //   111: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   114: ifeq +9 -> 123
    //   117: ldc_w 408
    //   120: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   123: ldc 17
    //   125: aconst_null
    //   126: invokestatic 234	org/apache/commons/logging/LogFactory:getSystemProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +358 -> 489
    //   134: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   137: ifeq +37 -> 174
    //   140: new 132	java/lang/StringBuffer
    //   143: dup
    //   144: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   147: ldc_w 410
    //   150: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   153: aload_1
    //   154: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   157: ldc_w 412
    //   160: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   163: ldc 17
    //   165: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   168: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   171: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   174: aload_1
    //   175: aload_2
    //   176: aload_3
    //   177: invokestatic 416	org/apache/commons/logging/LogFactory:newFactory	(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/ClassLoader;)Lorg/apache/commons/logging/LogFactory;
    //   180: astore_1
    //   181: aload_1
    //   182: astore_0
    //   183: aload_1
    //   184: ifnonnull +139 -> 323
    //   187: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   190: ifeq +9 -> 199
    //   193: ldc_w 418
    //   196: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   199: aload_3
    //   200: ldc 26
    //   202: invokestatic 422	org/apache/commons/logging/LogFactory:getResourceAsStream	(Ljava/lang/ClassLoader;Ljava/lang/String;)Ljava/io/InputStream;
    //   205: astore 5
    //   207: aload 5
    //   209: ifnull +466 -> 675
    //   212: new 424	java/io/BufferedReader
    //   215: dup
    //   216: new 426	java/io/InputStreamReader
    //   219: dup
    //   220: aload 5
    //   222: ldc_w 428
    //   225: invokespecial 431	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   228: invokespecial 434	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   231: astore_0
    //   232: aload_0
    //   233: invokevirtual 437	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   236: astore 5
    //   238: aload_0
    //   239: invokevirtual 440	java/io/BufferedReader:close	()V
    //   242: aload_1
    //   243: astore_0
    //   244: aload 5
    //   246: ifnull +77 -> 323
    //   249: aload_1
    //   250: astore_0
    //   251: ldc_w 442
    //   254: aload 5
    //   256: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   259: ifne +64 -> 323
    //   262: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   265: ifeq +50 -> 315
    //   268: new 132	java/lang/StringBuffer
    //   271: dup
    //   272: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   275: ldc_w 444
    //   278: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   281: aload 5
    //   283: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   286: ldc_w 446
    //   289: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   292: ldc 26
    //   294: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   297: ldc_w 448
    //   300: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   303: ldc_w 450
    //   306: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   309: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   312: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   315: aload 5
    //   317: aload_2
    //   318: aload_3
    //   319: invokestatic 416	org/apache/commons/logging/LogFactory:newFactory	(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/ClassLoader;)Lorg/apache/commons/logging/LogFactory;
    //   322: astore_0
    //   323: aload_0
    //   324: astore_1
    //   325: aload_0
    //   326: ifnonnull +76 -> 402
    //   329: aload 4
    //   331: ifnull +378 -> 709
    //   334: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   337: ifeq +9 -> 346
    //   340: ldc_w 452
    //   343: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   346: aload 4
    //   348: ldc 17
    //   350: invokevirtual 333	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   353: astore_1
    //   354: aload_1
    //   355: ifnull +339 -> 694
    //   358: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   361: ifeq +32 -> 393
    //   364: new 132	java/lang/StringBuffer
    //   367: dup
    //   368: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   371: ldc_w 454
    //   374: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   377: aload_1
    //   378: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   381: ldc_w 343
    //   384: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   387: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   390: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   393: aload_1
    //   394: aload_2
    //   395: aload_3
    //   396: invokestatic 416	org/apache/commons/logging/LogFactory:newFactory	(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/ClassLoader;)Lorg/apache/commons/logging/LogFactory;
    //   399: astore_0
    //   400: aload_0
    //   401: astore_1
    //   402: aload_1
    //   403: astore_0
    //   404: aload_1
    //   405: ifnonnull +25 -> 430
    //   408: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   411: ifeq +9 -> 420
    //   414: ldc_w 456
    //   417: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   420: ldc 11
    //   422: getstatic 64	org/apache/commons/logging/LogFactory:thisClassLoader	Ljava/lang/ClassLoader;
    //   425: aload_3
    //   426: invokestatic 416	org/apache/commons/logging/LogFactory:newFactory	(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/ClassLoader;)Lorg/apache/commons/logging/LogFactory;
    //   429: astore_0
    //   430: aload_0
    //   431: astore_1
    //   432: aload_0
    //   433: ifnull -402 -> 31
    //   436: aload_3
    //   437: aload_0
    //   438: invokestatic 458	org/apache/commons/logging/LogFactory:cacheFactory	(Ljava/lang/ClassLoader;Lorg/apache/commons/logging/LogFactory;)V
    //   441: aload_0
    //   442: astore_1
    //   443: aload 4
    //   445: ifnull -414 -> 31
    //   448: aload 4
    //   450: invokevirtual 462	java/util/Properties:propertyNames	()Ljava/util/Enumeration;
    //   453: astore_2
    //   454: aload_0
    //   455: astore_1
    //   456: aload_2
    //   457: invokeinterface 318 1 0
    //   462: ifeq -431 -> 31
    //   465: aload_2
    //   466: invokeinterface 321 1 0
    //   471: checkcast 237	java/lang/String
    //   474: astore_1
    //   475: aload_0
    //   476: aload_1
    //   477: aload 4
    //   479: aload_1
    //   480: invokevirtual 333	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   483: invokevirtual 466	org/apache/commons/logging/LogFactory:setAttribute	(Ljava/lang/String;Ljava/lang/Object;)V
    //   486: goto -32 -> 454
    //   489: aload_0
    //   490: astore_1
    //   491: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   494: ifeq -313 -> 181
    //   497: ldc_w 468
    //   500: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   503: aload_0
    //   504: astore_1
    //   505: goto -324 -> 181
    //   508: astore 5
    //   510: aload_0
    //   511: astore_1
    //   512: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   515: ifeq -334 -> 181
    //   518: new 132	java/lang/StringBuffer
    //   521: dup
    //   522: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   525: ldc_w 470
    //   528: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   531: aload 5
    //   533: invokevirtual 113	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   536: invokestatic 473	org/apache/commons/logging/LogFactory:trim	(Ljava/lang/String;)Ljava/lang/String;
    //   539: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   542: ldc_w 475
    //   545: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   548: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   551: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   554: aload_0
    //   555: astore_1
    //   556: goto -375 -> 181
    //   559: astore_0
    //   560: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   563: ifeq +38 -> 601
    //   566: new 132	java/lang/StringBuffer
    //   569: dup
    //   570: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   573: ldc_w 477
    //   576: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   579: aload_0
    //   580: invokevirtual 113	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   583: invokestatic 473	org/apache/commons/logging/LogFactory:trim	(Ljava/lang/String;)Ljava/lang/String;
    //   586: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   589: ldc_w 479
    //   592: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   595: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   598: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   601: aload_0
    //   602: athrow
    //   603: astore_0
    //   604: new 424	java/io/BufferedReader
    //   607: dup
    //   608: new 426	java/io/InputStreamReader
    //   611: dup
    //   612: aload 5
    //   614: invokespecial 482	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   617: invokespecial 434	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   620: astore_0
    //   621: goto -389 -> 232
    //   624: astore 5
    //   626: aload_1
    //   627: astore_0
    //   628: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   631: ifeq -308 -> 323
    //   634: new 132	java/lang/StringBuffer
    //   637: dup
    //   638: invokespecial 133	java/lang/StringBuffer:<init>	()V
    //   641: ldc_w 470
    //   644: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   647: aload 5
    //   649: invokevirtual 113	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   652: invokestatic 473	org/apache/commons/logging/LogFactory:trim	(Ljava/lang/String;)Ljava/lang/String;
    //   655: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   658: ldc_w 475
    //   661: invokevirtual 139	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   664: invokevirtual 151	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   667: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   670: aload_1
    //   671: astore_0
    //   672: goto -349 -> 323
    //   675: aload_1
    //   676: astore_0
    //   677: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   680: ifeq -357 -> 323
    //   683: ldc_w 484
    //   686: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   689: aload_1
    //   690: astore_0
    //   691: goto -368 -> 323
    //   694: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   697: ifeq +9 -> 706
    //   700: ldc_w 486
    //   703: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   706: goto -306 -> 400
    //   709: aload_0
    //   710: astore_1
    //   711: invokestatic 79	org/apache/commons/logging/LogFactory:isDiagnosticsEnabled	()Z
    //   714: ifeq -312 -> 402
    //   717: ldc_w 488
    //   720: invokestatic 85	org/apache/commons/logging/LogFactory:logDiagnostic	(Ljava/lang/String;)V
    //   723: aload_0
    //   724: astore_1
    //   725: goto -323 -> 402
    //   728: aload_3
    //   729: astore_2
    //   730: goto -619 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   24	531	0	localObject1	Object
    //   559	43	0	localRuntimeException	RuntimeException
    //   603	1	0	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   620	104	0	localObject2	Object
    //   30	695	1	localObject3	Object
    //   110	620	2	localObject4	Object
    //   3	726	3	localClassLoader	ClassLoader
    //   78	400	4	localProperties	Properties
    //   205	111	5	localObject5	Object
    //   508	105	5	localSecurityException	SecurityException
    //   624	24	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   123	130	508	java/lang/SecurityException
    //   134	174	508	java/lang/SecurityException
    //   174	181	508	java/lang/SecurityException
    //   491	503	508	java/lang/SecurityException
    //   123	130	559	java/lang/RuntimeException
    //   134	174	559	java/lang/RuntimeException
    //   174	181	559	java/lang/RuntimeException
    //   491	503	559	java/lang/RuntimeException
    //   212	232	603	java/io/UnsupportedEncodingException
    //   199	207	624	java/lang/Exception
    //   212	232	624	java/lang/Exception
    //   232	242	624	java/lang/Exception
    //   251	315	624	java/lang/Exception
    //   315	323	624	java/lang/Exception
    //   604	621	624	java/lang/Exception
    //   677	689	624	java/lang/Exception
  }
  
  public static Log getLog(Class paramClass)
  {
    return getFactory().getInstance(paramClass);
  }
  
  public static Log getLog(String paramString)
  {
    return getFactory().getInstance(paramString);
  }
  
  private static Properties getProperties(URL paramURL)
  {
    return (Properties)AccessController.doPrivileged(new LogFactory.5(paramURL));
  }
  
  private static InputStream getResourceAsStream(ClassLoader paramClassLoader, String paramString)
  {
    return (InputStream)AccessController.doPrivileged(new LogFactory.3(paramClassLoader, paramString));
  }
  
  private static Enumeration getResources(ClassLoader paramClassLoader, String paramString)
  {
    return (Enumeration)AccessController.doPrivileged(new LogFactory.4(paramClassLoader, paramString));
  }
  
  private static String getSystemProperty(String paramString1, String paramString2)
  {
    return (String)AccessController.doPrivileged(new LogFactory.6(paramString1, paramString2));
  }
  
  private static boolean implementsLogFactory(Class paramClass)
  {
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramClass != null)
    {
      boolean bool3 = bool2;
      boolean bool4 = bool5;
      bool1 = bool6;
      try
      {
        ClassLoader localClassLoader = paramClass.getClassLoader();
        if (localClassLoader == null)
        {
          bool3 = bool2;
          bool4 = bool5;
          bool1 = bool6;
          logDiagnostic("[CUSTOM LOG FACTORY] was loaded by the boot classloader");
          return false;
        }
        bool3 = bool2;
        bool4 = bool5;
        bool1 = bool6;
        logHierarchy("[CUSTOM LOG FACTORY] ", localClassLoader);
        bool3 = bool2;
        bool4 = bool5;
        bool1 = bool6;
        bool2 = Class.forName("org.apache.commons.logging.LogFactory", false, localClassLoader).isAssignableFrom(paramClass);
        if (bool2)
        {
          bool3 = bool2;
          bool4 = bool2;
          bool1 = bool2;
          logDiagnostic("[CUSTOM LOG FACTORY] " + paramClass.getName() + " implements LogFactory but was loaded by an incompatible classloader.");
          return bool2;
        }
      }
      catch (SecurityException paramClass)
      {
        logDiagnostic("[CUSTOM LOG FACTORY] SecurityException thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: " + paramClass.getMessage());
        return bool3;
        bool3 = bool2;
        bool4 = bool2;
        bool1 = bool2;
        logDiagnostic("[CUSTOM LOG FACTORY] " + paramClass.getName() + " does not implement LogFactory.");
        return bool2;
      }
      catch (LinkageError paramClass)
      {
        logDiagnostic("[CUSTOM LOG FACTORY] LinkageError thrown whilst trying to determine whether the compatibility was caused by a classloader conflict: " + paramClass.getMessage());
        return bool4;
      }
      catch (ClassNotFoundException paramClass)
      {
        logDiagnostic("[CUSTOM LOG FACTORY] LogFactory class cannot be loaded by classloader which loaded the custom LogFactory implementation. Is the custom factory in the right classloader?");
      }
    }
    return bool1;
  }
  
  private static void initDiagnostics()
  {
    try
    {
      Object localObject = getSystemProperty("org.apache.commons.logging.diagnostics.dest", null);
      if (localObject == null) {
        return;
      }
      if (((String)localObject).equals("STDOUT")) {
        diagnosticsStream = System.out;
      }
      for (;;)
      {
        try
        {
          localObject = thisClassLoader;
          if (thisClassLoader != null) {
            continue;
          }
          localObject = "BOOTLOADER";
        }
        catch (SecurityException localSecurityException1)
        {
          String str1;
          String str2 = "UNKNOWN";
          continue;
        }
        diagnosticPrefix = "[LogFactory from " + (String)localObject + "] ";
        return;
        if (((String)localObject).equals("STDERR"))
        {
          diagnosticsStream = System.err;
        }
        else
        {
          try
          {
            diagnosticsStream = new PrintStream(new FileOutputStream((String)localObject, true));
          }
          catch (IOException localIOException)
          {
            return;
          }
          str1 = objectId(localIOException);
        }
      }
      return;
    }
    catch (SecurityException localSecurityException2) {}
  }
  
  protected static boolean isDiagnosticsEnabled()
  {
    return diagnosticsStream != null;
  }
  
  private static void logClassLoaderEnvironment(Class paramClass)
  {
    if (!isDiagnosticsEnabled()) {
      return;
    }
    try
    {
      logDiagnostic("[ENV] Extension directories (java.ext.dir): " + System.getProperty("java.ext.dir"));
      logDiagnostic("[ENV] Application classpath (java.class.path): " + System.getProperty("java.class.path"));
      str = paramClass.getName();
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        try
        {
          String str;
          paramClass = getClassLoader(paramClass);
          logDiagnostic("[ENV] Class " + str + " was loaded via classloader " + objectId(paramClass));
          logHierarchy("[ENV] Ancestry of classloader which loaded " + str + " is ", paramClass);
          return;
        }
        catch (SecurityException paramClass)
        {
          logDiagnostic("[ENV] Security forbids determining the classloader for " + localSecurityException);
        }
        localSecurityException = localSecurityException;
        logDiagnostic("[ENV] Security setting prevent interrogation of system classpaths.");
      }
    }
  }
  
  private static final void logDiagnostic(String paramString)
  {
    if (diagnosticsStream != null)
    {
      diagnosticsStream.print(diagnosticPrefix);
      diagnosticsStream.println(paramString);
      diagnosticsStream.flush();
    }
  }
  
  private static void logHierarchy(String paramString, ClassLoader paramClassLoader)
  {
    if (!isDiagnosticsEnabled()) {
      return;
    }
    Object localObject;
    if (paramClassLoader != null)
    {
      localObject = paramClassLoader.toString();
      logDiagnostic(paramString + objectId(paramClassLoader) + " == '" + (String)localObject + "'");
    }
    for (;;)
    {
      StringBuffer localStringBuffer;
      try
      {
        localObject = ClassLoader.getSystemClassLoader();
        if (paramClassLoader == null) {
          break;
        }
        localStringBuffer = new StringBuffer(paramString + "ClassLoader tree:");
        localStringBuffer.append(objectId(paramClassLoader));
        if (paramClassLoader == localObject) {
          localStringBuffer.append(" (SYSTEM) ");
        }
      }
      catch (SecurityException paramClassLoader)
      {
        logDiagnostic(paramString + "Security forbids determining the system classloader.");
        return;
      }
      try
      {
        paramString = paramClassLoader.getParent();
        localStringBuffer.append(" --> ");
        paramClassLoader = paramString;
        if (paramString == null) {
          localStringBuffer.append("BOOT");
        }
      }
      catch (SecurityException paramString)
      {
        localStringBuffer.append(" --> SECRET");
      }
    }
    logDiagnostic(localStringBuffer.toString());
  }
  
  protected static final void logRawDiagnostic(String paramString)
  {
    if (diagnosticsStream != null)
    {
      diagnosticsStream.println(paramString);
      diagnosticsStream.flush();
    }
  }
  
  protected static LogFactory newFactory(String paramString, ClassLoader paramClassLoader)
  {
    return newFactory(paramString, paramClassLoader, null);
  }
  
  protected static LogFactory newFactory(String paramString, ClassLoader paramClassLoader1, ClassLoader paramClassLoader2)
  {
    paramString = AccessController.doPrivileged(new LogFactory.2(paramString, paramClassLoader1));
    if ((paramString instanceof LogConfigurationException))
    {
      paramString = (LogConfigurationException)paramString;
      if (isDiagnosticsEnabled()) {
        logDiagnostic("An error occurred while loading the factory class:" + paramString.getMessage());
      }
      throw paramString;
    }
    if (isDiagnosticsEnabled()) {
      logDiagnostic("Created object " + objectId(paramString) + " to manage classloader " + objectId(paramClassLoader2));
    }
    return (LogFactory)paramString;
  }
  
  public static String objectId(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    return paramObject.getClass().getName() + "@" + System.identityHashCode(paramObject);
  }
  
  public static void release(ClassLoader paramClassLoader)
  {
    if (isDiagnosticsEnabled()) {
      logDiagnostic("Releasing factory for classloader " + objectId(paramClassLoader));
    }
    localHashtable = factories;
    if (paramClassLoader == null) {}
    for (;;)
    {
      try
      {
        if (nullClassLoaderFactory != null)
        {
          nullClassLoaderFactory.release();
          nullClassLoaderFactory = null;
        }
        return;
      }
      finally {}
      LogFactory localLogFactory = (LogFactory)factories.get(paramClassLoader);
      if (localLogFactory != null)
      {
        localLogFactory.release();
        factories.remove(paramClassLoader);
      }
    }
  }
  
  public static void releaseAll()
  {
    if (isDiagnosticsEnabled()) {
      logDiagnostic("Releasing factory for all classloaders.");
    }
    synchronized (factories)
    {
      Enumeration localEnumeration = factories.elements();
      if (localEnumeration.hasMoreElements()) {
        ((LogFactory)localEnumeration.nextElement()).release();
      }
    }
    factories.clear();
    if (nullClassLoaderFactory != null)
    {
      nullClassLoaderFactory.release();
      nullClassLoaderFactory = null;
    }
  }
  
  private static String trim(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.trim();
  }
  
  public abstract Object getAttribute(String paramString);
  
  public abstract String[] getAttributeNames();
  
  public abstract Log getInstance(Class paramClass);
  
  public abstract Log getInstance(String paramString);
  
  public abstract void release();
  
  public abstract void removeAttribute(String paramString);
  
  public abstract void setAttribute(String paramString, Object paramObject);
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/LogFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */