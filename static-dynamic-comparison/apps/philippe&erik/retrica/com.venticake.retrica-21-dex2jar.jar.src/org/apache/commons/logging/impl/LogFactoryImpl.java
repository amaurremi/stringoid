package org.apache.commons.logging.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;

public class LogFactoryImpl
  extends LogFactory
{
  public static final String ALLOW_FLAWED_CONTEXT_PROPERTY = "org.apache.commons.logging.Log.allowFlawedContext";
  public static final String ALLOW_FLAWED_DISCOVERY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedDiscovery";
  public static final String ALLOW_FLAWED_HIERARCHY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedHierarchy";
  private static final String LOGGING_IMPL_JDK14_LOGGER = "org.apache.commons.logging.impl.Jdk14Logger";
  private static final String LOGGING_IMPL_LOG4J_LOGGER = "org.apache.commons.logging.impl.Log4JLogger";
  private static final String LOGGING_IMPL_LUMBERJACK_LOGGER = "org.apache.commons.logging.impl.Jdk13LumberjackLogger";
  private static final String LOGGING_IMPL_SIMPLE_LOGGER = "org.apache.commons.logging.impl.SimpleLog";
  public static final String LOG_PROPERTY = "org.apache.commons.logging.Log";
  protected static final String LOG_PROPERTY_OLD = "org.apache.commons.logging.log";
  private static final String PKG_IMPL = "org.apache.commons.logging.impl.";
  private static final int PKG_LEN = "org.apache.commons.logging.impl.".length();
  private static final String[] classesToDiscover = { "org.apache.commons.logging.impl.Log4JLogger", "org.apache.commons.logging.impl.Jdk14Logger", "org.apache.commons.logging.impl.Jdk13LumberjackLogger", "org.apache.commons.logging.impl.SimpleLog" };
  private boolean allowFlawedContext;
  private boolean allowFlawedDiscovery;
  private boolean allowFlawedHierarchy;
  protected Hashtable attributes = new Hashtable();
  private String diagnosticPrefix;
  protected Hashtable instances = new Hashtable();
  private String logClassName;
  protected Constructor logConstructor = null;
  protected Class[] logConstructorSignature;
  protected Method logMethod;
  protected Class[] logMethodSignature;
  private boolean useTCCL = true;
  
  public LogFactoryImpl()
  {
    Class localClass;
    if (class$java$lang$String == null)
    {
      localClass = class$("java.lang.String");
      class$java$lang$String = localClass;
      this.logConstructorSignature = new Class[] { localClass };
      this.logMethod = null;
      if (class$org$apache$commons$logging$LogFactory != null) {
        break label121;
      }
      localClass = class$("org.apache.commons.logging.LogFactory");
      class$org$apache$commons$logging$LogFactory = localClass;
    }
    for (;;)
    {
      this.logMethodSignature = new Class[] { localClass };
      initDiagnostics();
      if (isDiagnosticsEnabled()) {
        logDiagnostic("Instance created.");
      }
      return;
      localClass = class$java$lang$String;
      break;
      label121:
      localClass = class$org$apache$commons$logging$LogFactory;
    }
  }
  
  /* Error */
  private Log createLogFromClass(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 115	org/apache/commons/logging/impl/LogFactoryImpl:isDiagnosticsEnabled	()Z
    //   3: ifeq +31 -> 34
    //   6: aload_0
    //   7: new 149	java/lang/StringBuffer
    //   10: dup
    //   11: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   14: ldc -104
    //   16: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   19: aload_1
    //   20: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   23: ldc -98
    //   25: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   28: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   31: invokevirtual 121	org/apache/commons/logging/impl/LogFactoryImpl:logDiagnostic	(Ljava/lang/String;)V
    //   34: aload_0
    //   35: invokespecial 164	org/apache/commons/logging/impl/LogFactoryImpl:getBaseClassLoader	()Ljava/lang/ClassLoader;
    //   38: astore 8
    //   40: aconst_null
    //   41: astore 6
    //   43: aconst_null
    //   44: astore 5
    //   46: aload_0
    //   47: new 149	java/lang/StringBuffer
    //   50: dup
    //   51: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   54: ldc -90
    //   56: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   59: aload_1
    //   60: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   63: ldc -88
    //   65: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   68: aload 8
    //   70: invokestatic 172	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   73: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   76: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   79: invokevirtual 121	org/apache/commons/logging/impl/LogFactoryImpl:logDiagnostic	(Ljava/lang/String;)V
    //   82: invokestatic 115	org/apache/commons/logging/impl/LogFactoryImpl:isDiagnosticsEnabled	()Z
    //   85: ifeq +88 -> 173
    //   88: new 149	java/lang/StringBuffer
    //   91: dup
    //   92: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   95: aload_1
    //   96: bipush 46
    //   98: bipush 47
    //   100: invokevirtual 176	java/lang/String:replace	(CC)Ljava/lang/String;
    //   103: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   106: ldc -78
    //   108: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   111: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   114: astore 9
    //   116: aload 8
    //   118: ifnull +228 -> 346
    //   121: aload 8
    //   123: aload 9
    //   125: invokevirtual 184	java/lang/ClassLoader:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   128: astore 7
    //   130: aload 7
    //   132: ifnonnull +242 -> 374
    //   135: aload_0
    //   136: new 149	java/lang/StringBuffer
    //   139: dup
    //   140: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   143: ldc -70
    //   145: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   148: aload_1
    //   149: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   152: ldc -68
    //   154: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   157: aload 9
    //   159: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   162: ldc -66
    //   164: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   167: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   170: invokevirtual 121	org/apache/commons/logging/impl/LogFactoryImpl:logDiagnostic	(Ljava/lang/String;)V
    //   173: aload_1
    //   174: iconst_1
    //   175: aload 8
    //   177: invokestatic 193	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   180: astore 7
    //   182: aload 7
    //   184: aload_0
    //   185: getfield 100	org/apache/commons/logging/impl/LogFactoryImpl:logConstructorSignature	[Ljava/lang/Class;
    //   188: invokevirtual 197	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   191: astore 9
    //   193: aload 9
    //   195: astore 5
    //   197: aload 5
    //   199: iconst_1
    //   200: anewarray 199	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: aload_2
    //   206: aastore
    //   207: invokevirtual 205	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   210: astore 9
    //   212: aload 9
    //   214: instanceof 207
    //   217: istore 4
    //   219: iload 4
    //   221: ifeq +438 -> 659
    //   224: aload 9
    //   226: checkcast 207	org/apache/commons/logging/Log
    //   229: astore 9
    //   231: aload 7
    //   233: astore 6
    //   235: aload 9
    //   237: astore_2
    //   238: aload_2
    //   239: ifnull +105 -> 344
    //   242: iload_3
    //   243: ifeq +101 -> 344
    //   246: aload_0
    //   247: aload_1
    //   248: putfield 209	org/apache/commons/logging/impl/LogFactoryImpl:logClassName	Ljava/lang/String;
    //   251: aload_0
    //   252: aload 5
    //   254: putfield 88	org/apache/commons/logging/impl/LogFactoryImpl:logConstructor	Ljava/lang/reflect/Constructor;
    //   257: aload_0
    //   258: aload 6
    //   260: ldc -45
    //   262: aload_0
    //   263: getfield 108	org/apache/commons/logging/impl/LogFactoryImpl:logMethodSignature	[Ljava/lang/Class;
    //   266: invokevirtual 215	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   269: putfield 102	org/apache/commons/logging/impl/LogFactoryImpl:logMethod	Ljava/lang/reflect/Method;
    //   272: aload_0
    //   273: new 149	java/lang/StringBuffer
    //   276: dup
    //   277: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   280: ldc -39
    //   282: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   285: aload_1
    //   286: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   289: ldc -98
    //   291: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   294: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   297: invokevirtual 121	org/apache/commons/logging/impl/LogFactoryImpl:logDiagnostic	(Ljava/lang/String;)V
    //   300: aload_0
    //   301: new 149	java/lang/StringBuffer
    //   304: dup
    //   305: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   308: ldc -37
    //   310: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   313: aload_1
    //   314: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   317: ldc -88
    //   319: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   322: aload 6
    //   324: invokevirtual 222	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   327: invokestatic 172	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   330: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   333: ldc -32
    //   335: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   338: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   341: invokevirtual 121	org/apache/commons/logging/impl/LogFactoryImpl:logDiagnostic	(Ljava/lang/String;)V
    //   344: aload_2
    //   345: areturn
    //   346: new 149	java/lang/StringBuffer
    //   349: dup
    //   350: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   353: aload 9
    //   355: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   358: ldc -78
    //   360: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   363: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   366: invokestatic 227	java/lang/ClassLoader:getSystemResource	(Ljava/lang/String;)Ljava/net/URL;
    //   369: astore 7
    //   371: goto -241 -> 130
    //   374: aload_0
    //   375: new 149	java/lang/StringBuffer
    //   378: dup
    //   379: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   382: ldc -70
    //   384: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   387: aload_1
    //   388: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   391: ldc -27
    //   393: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   396: aload 7
    //   398: invokevirtual 232	java/lang/StringBuffer:append	(Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   401: ldc -98
    //   403: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   406: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   409: invokevirtual 121	org/apache/commons/logging/impl/LogFactoryImpl:logDiagnostic	(Ljava/lang/String;)V
    //   412: goto -239 -> 173
    //   415: astore 7
    //   417: aload 5
    //   419: astore_2
    //   420: aload 7
    //   422: astore 5
    //   424: new 149	java/lang/StringBuffer
    //   427: dup
    //   428: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   431: ldc -22
    //   433: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   436: aload 5
    //   438: invokevirtual 139	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   441: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   444: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   447: astore 5
    //   449: aload_0
    //   450: new 149	java/lang/StringBuffer
    //   453: dup
    //   454: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   457: ldc -20
    //   459: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   462: aload_1
    //   463: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   466: ldc -18
    //   468: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   471: aload 8
    //   473: invokestatic 172	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   476: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   479: ldc -16
    //   481: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   484: aload 5
    //   486: invokevirtual 243	java/lang/String:trim	()Ljava/lang/String;
    //   489: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   492: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   495: invokevirtual 121	org/apache/commons/logging/impl/LogFactoryImpl:logDiagnostic	(Ljava/lang/String;)V
    //   498: aload_2
    //   499: astore 5
    //   501: aconst_null
    //   502: astore_2
    //   503: goto -265 -> 238
    //   506: astore 7
    //   508: new 149	java/lang/StringBuffer
    //   511: dup
    //   512: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   515: ldc -22
    //   517: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   520: aload 7
    //   522: invokevirtual 139	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   525: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   528: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   531: astore 7
    //   533: aload_0
    //   534: new 149	java/lang/StringBuffer
    //   537: dup
    //   538: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   541: ldc -20
    //   543: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   546: aload_1
    //   547: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   550: ldc -11
    //   552: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   555: aload 8
    //   557: invokestatic 172	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   560: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   563: ldc -16
    //   565: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   568: aload 7
    //   570: invokevirtual 243	java/lang/String:trim	()Ljava/lang/String;
    //   573: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   576: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   579: invokevirtual 121	org/apache/commons/logging/impl/LogFactoryImpl:logDiagnostic	(Ljava/lang/String;)V
    //   582: aload_1
    //   583: invokestatic 131	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   586: astore 7
    //   588: goto -406 -> 182
    //   591: astore 7
    //   593: new 149	java/lang/StringBuffer
    //   596: dup
    //   597: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   600: ldc -22
    //   602: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   605: aload 7
    //   607: invokevirtual 139	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   610: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   613: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   616: astore 7
    //   618: aload_0
    //   619: new 149	java/lang/StringBuffer
    //   622: dup
    //   623: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   626: ldc -20
    //   628: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   631: aload_1
    //   632: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   635: ldc -9
    //   637: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   640: aload 7
    //   642: invokevirtual 243	java/lang/String:trim	()Ljava/lang/String;
    //   645: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   648: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   651: invokevirtual 121	org/apache/commons/logging/impl/LogFactoryImpl:logDiagnostic	(Ljava/lang/String;)V
    //   654: aconst_null
    //   655: astore_2
    //   656: goto -418 -> 238
    //   659: aload_0
    //   660: aload 8
    //   662: aload 7
    //   664: invokespecial 251	org/apache/commons/logging/impl/LogFactoryImpl:handleFlawedHierarchy	(Ljava/lang/ClassLoader;Ljava/lang/Class;)V
    //   667: aload 8
    //   669: ifnonnull +102 -> 771
    //   672: aconst_null
    //   673: astore_2
    //   674: goto -436 -> 238
    //   677: astore_2
    //   678: new 149	java/lang/StringBuffer
    //   681: dup
    //   682: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   685: ldc -22
    //   687: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   690: aload_2
    //   691: invokevirtual 139	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   694: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   697: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   700: astore_2
    //   701: aload_0
    //   702: new 149	java/lang/StringBuffer
    //   705: dup
    //   706: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   709: ldc -20
    //   711: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   714: aload_1
    //   715: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   718: ldc -3
    //   720: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   723: aload 8
    //   725: invokestatic 172	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   728: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   731: ldc -16
    //   733: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   736: aload_2
    //   737: invokevirtual 243	java/lang/String:trim	()Ljava/lang/String;
    //   740: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   743: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   746: invokevirtual 121	org/apache/commons/logging/impl/LogFactoryImpl:logDiagnostic	(Ljava/lang/String;)V
    //   749: aconst_null
    //   750: astore_2
    //   751: goto -513 -> 238
    //   754: astore_1
    //   755: aload_1
    //   756: athrow
    //   757: astore 7
    //   759: aload_0
    //   760: aload_1
    //   761: aload 8
    //   763: aload 7
    //   765: invokespecial 257	org/apache/commons/logging/impl/LogFactoryImpl:handleFlawedDiscovery	(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Throwable;)V
    //   768: goto -101 -> 667
    //   771: aload_0
    //   772: aload 8
    //   774: invokespecial 261	org/apache/commons/logging/impl/LogFactoryImpl:getParentClassLoader	(Ljava/lang/ClassLoader;)Ljava/lang/ClassLoader;
    //   777: astore 8
    //   779: goto -733 -> 46
    //   782: astore 5
    //   784: aload_0
    //   785: aconst_null
    //   786: putfield 102	org/apache/commons/logging/impl/LogFactoryImpl:logMethod	Ljava/lang/reflect/Method;
    //   789: aload_0
    //   790: new 149	java/lang/StringBuffer
    //   793: dup
    //   794: invokespecial 150	java/lang/StringBuffer:<init>	()V
    //   797: ldc_w 263
    //   800: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   803: aload_1
    //   804: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   807: ldc -88
    //   809: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   812: aload 8
    //   814: invokestatic 172	org/apache/commons/logging/LogFactory:objectId	(Ljava/lang/Object;)Ljava/lang/String;
    //   817: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   820: ldc_w 265
    //   823: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   826: ldc_w 267
    //   829: invokevirtual 156	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   832: invokevirtual 161	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   835: invokevirtual 121	org/apache/commons/logging/impl/LogFactoryImpl:logDiagnostic	(Ljava/lang/String;)V
    //   838: goto -538 -> 300
    //   841: astore 7
    //   843: goto -84 -> 759
    //   846: astore 9
    //   848: aload 7
    //   850: astore 6
    //   852: aload 9
    //   854: astore 7
    //   856: goto -97 -> 759
    //   859: astore_2
    //   860: goto -182 -> 678
    //   863: astore_2
    //   864: aload 7
    //   866: astore 6
    //   868: goto -190 -> 678
    //   871: astore 7
    //   873: aload 5
    //   875: astore_2
    //   876: aload 7
    //   878: astore 5
    //   880: goto -456 -> 424
    //   883: astore 9
    //   885: aload 7
    //   887: astore 6
    //   889: aload 5
    //   891: astore_2
    //   892: aload 9
    //   894: astore 5
    //   896: goto -472 -> 424
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	899	0	this	LogFactoryImpl
    //   0	899	1	paramString1	String
    //   0	899	2	paramString2	String
    //   0	899	3	paramBoolean	boolean
    //   217	3	4	bool	boolean
    //   44	456	5	localObject1	Object
    //   782	92	5	localThrowable1	Throwable
    //   878	17	5	localObject2	Object
    //   41	847	6	localObject3	Object
    //   128	269	7	localObject4	Object
    //   415	6	7	localNoClassDefFoundError1	NoClassDefFoundError
    //   506	15	7	localClassNotFoundException1	ClassNotFoundException
    //   531	56	7	localObject5	Object
    //   591	15	7	localClassNotFoundException2	ClassNotFoundException
    //   616	47	7	str	String
    //   757	7	7	localThrowable2	Throwable
    //   841	8	7	localThrowable3	Throwable
    //   854	11	7	localThrowable4	Throwable
    //   871	15	7	localNoClassDefFoundError2	NoClassDefFoundError
    //   38	775	8	localClassLoader	ClassLoader
    //   114	240	9	localObject6	Object
    //   846	7	9	localThrowable5	Throwable
    //   883	10	9	localNoClassDefFoundError3	NoClassDefFoundError
    // Exception table:
    //   from	to	target	type
    //   82	116	415	java/lang/NoClassDefFoundError
    //   121	130	415	java/lang/NoClassDefFoundError
    //   135	173	415	java/lang/NoClassDefFoundError
    //   173	182	415	java/lang/NoClassDefFoundError
    //   182	193	415	java/lang/NoClassDefFoundError
    //   346	371	415	java/lang/NoClassDefFoundError
    //   374	412	415	java/lang/NoClassDefFoundError
    //   508	582	415	java/lang/NoClassDefFoundError
    //   582	588	415	java/lang/NoClassDefFoundError
    //   593	654	415	java/lang/NoClassDefFoundError
    //   173	182	506	java/lang/ClassNotFoundException
    //   582	588	591	java/lang/ClassNotFoundException
    //   82	116	677	java/lang/ExceptionInInitializerError
    //   121	130	677	java/lang/ExceptionInInitializerError
    //   135	173	677	java/lang/ExceptionInInitializerError
    //   173	182	677	java/lang/ExceptionInInitializerError
    //   182	193	677	java/lang/ExceptionInInitializerError
    //   346	371	677	java/lang/ExceptionInInitializerError
    //   374	412	677	java/lang/ExceptionInInitializerError
    //   508	582	677	java/lang/ExceptionInInitializerError
    //   582	588	677	java/lang/ExceptionInInitializerError
    //   593	654	677	java/lang/ExceptionInInitializerError
    //   82	116	754	org/apache/commons/logging/LogConfigurationException
    //   121	130	754	org/apache/commons/logging/LogConfigurationException
    //   135	173	754	org/apache/commons/logging/LogConfigurationException
    //   173	182	754	org/apache/commons/logging/LogConfigurationException
    //   182	193	754	org/apache/commons/logging/LogConfigurationException
    //   197	219	754	org/apache/commons/logging/LogConfigurationException
    //   224	231	754	org/apache/commons/logging/LogConfigurationException
    //   346	371	754	org/apache/commons/logging/LogConfigurationException
    //   374	412	754	org/apache/commons/logging/LogConfigurationException
    //   508	582	754	org/apache/commons/logging/LogConfigurationException
    //   582	588	754	org/apache/commons/logging/LogConfigurationException
    //   593	654	754	org/apache/commons/logging/LogConfigurationException
    //   659	667	754	org/apache/commons/logging/LogConfigurationException
    //   82	116	757	java/lang/Throwable
    //   121	130	757	java/lang/Throwable
    //   135	173	757	java/lang/Throwable
    //   173	182	757	java/lang/Throwable
    //   182	193	757	java/lang/Throwable
    //   346	371	757	java/lang/Throwable
    //   374	412	757	java/lang/Throwable
    //   508	582	757	java/lang/Throwable
    //   582	588	757	java/lang/Throwable
    //   593	654	757	java/lang/Throwable
    //   257	300	782	java/lang/Throwable
    //   197	219	841	java/lang/Throwable
    //   659	667	841	java/lang/Throwable
    //   224	231	846	java/lang/Throwable
    //   197	219	859	java/lang/ExceptionInInitializerError
    //   659	667	859	java/lang/ExceptionInInitializerError
    //   224	231	863	java/lang/ExceptionInInitializerError
    //   197	219	871	java/lang/NoClassDefFoundError
    //   659	667	871	java/lang/NoClassDefFoundError
    //   224	231	883	java/lang/NoClassDefFoundError
  }
  
  private Log discoverLogImplementation(String paramString)
  {
    if (isDiagnosticsEnabled()) {
      logDiagnostic("Discovering a Log implementation...");
    }
    initConfiguration();
    Log localLog = null;
    String str = findUserSpecifiedLogClassName();
    if (str != null)
    {
      if (isDiagnosticsEnabled()) {
        logDiagnostic("Attempting to load user-specified log class '" + str + "'...");
      }
      localLog = createLogFromClass(str, paramString, true);
      paramString = localLog;
      if (localLog == null)
      {
        paramString = new StringBuffer("User-specified log class '");
        paramString.append(str);
        paramString.append("' cannot be found or is not useable.");
        if (str != null)
        {
          informUponSimilarName(paramString, str, "org.apache.commons.logging.impl.Log4JLogger");
          informUponSimilarName(paramString, str, "org.apache.commons.logging.impl.Jdk14Logger");
          informUponSimilarName(paramString, str, "org.apache.commons.logging.impl.Jdk13LumberjackLogger");
          informUponSimilarName(paramString, str, "org.apache.commons.logging.impl.SimpleLog");
        }
        throw new LogConfigurationException(paramString.toString());
      }
    }
    else
    {
      if (isDiagnosticsEnabled()) {
        logDiagnostic("No user-specified Log implementation; performing discovery using the standard supported logging implementations...");
      }
      int i = 0;
      while ((i < classesToDiscover.length) && (localLog == null))
      {
        localLog = createLogFromClass(classesToDiscover[i], paramString, true);
        i += 1;
      }
      paramString = localLog;
      if (localLog == null) {
        throw new LogConfigurationException("No suitable Log implementation");
      }
    }
    return paramString;
  }
  
  private String findUserSpecifiedLogClassName()
  {
    if (isDiagnosticsEnabled()) {
      logDiagnostic("Trying to get log class from attribute 'org.apache.commons.logging.Log'");
    }
    Object localObject2 = (String)getAttribute("org.apache.commons.logging.Log");
    if (localObject2 == null)
    {
      if (isDiagnosticsEnabled()) {
        logDiagnostic("Trying to get log class from attribute 'org.apache.commons.logging.log'");
      }
      localObject2 = (String)getAttribute("org.apache.commons.logging.log");
    }
    for (;;)
    {
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        if (isDiagnosticsEnabled()) {
          logDiagnostic("Trying to get log class from system property 'org.apache.commons.logging.Log'");
        }
      }
      try
      {
        localObject1 = getSystemProperty("org.apache.commons.logging.Log", null);
        if (localObject1 == null) {
          if (isDiagnosticsEnabled()) {
            logDiagnostic("Trying to get log class from system property 'org.apache.commons.logging.log'");
          }
        }
      }
      catch (SecurityException localSecurityException2)
      {
        label190:
        for (;;)
        {
          try
          {
            localObject2 = getSystemProperty("org.apache.commons.logging.log", null);
            localObject1 = localObject2;
            localObject2 = localObject1;
            if (localObject1 != null) {
              localObject2 = ((String)localObject1).trim();
            }
            return (String)localObject2;
          }
          catch (SecurityException localSecurityException1)
          {
            if (!isDiagnosticsEnabled()) {
              break label190;
            }
            logDiagnostic("No access allowed to system property 'org.apache.commons.logging.log' - " + localSecurityException1.getMessage());
          }
          localSecurityException2 = localSecurityException2;
          localObject1 = localObject2;
          if (isDiagnosticsEnabled())
          {
            logDiagnostic("No access allowed to system property 'org.apache.commons.logging.Log' - " + localSecurityException2.getMessage());
            localObject1 = localObject2;
          }
        }
      }
    }
  }
  
  private ClassLoader getBaseClassLoader()
  {
    Object localObject;
    if (class$org$apache$commons$logging$impl$LogFactoryImpl == null)
    {
      localObject = class$("org.apache.commons.logging.impl.LogFactoryImpl");
      class$org$apache$commons$logging$impl$LogFactoryImpl = (Class)localObject;
      localObject = getClassLoader((Class)localObject);
      if (this.useTCCL) {
        break label38;
      }
    }
    label38:
    ClassLoader localClassLoader1;
    do
    {
      ClassLoader localClassLoader2;
      do
      {
        return (ClassLoader)localObject;
        localObject = class$org$apache$commons$logging$impl$LogFactoryImpl;
        break;
        localClassLoader2 = getContextClassLoaderInternal();
        localClassLoader1 = getLowestClassLoader(localClassLoader2, (ClassLoader)localObject);
        if (localClassLoader1 == null)
        {
          if (this.allowFlawedContext)
          {
            if (isDiagnosticsEnabled()) {
              logDiagnostic("[WARNING] the context classloader is not part of a parent-child relationship with the classloader that loaded LogFactoryImpl.");
            }
            return localClassLoader2;
          }
          throw new LogConfigurationException("Bad classloader hierarchy; LogFactoryImpl was loaded via a classloader that is not related to the current context classloader.");
        }
        localObject = localClassLoader1;
      } while (localClassLoader1 == localClassLoader2);
      if (!this.allowFlawedContext) {
        break label117;
      }
      localObject = localClassLoader1;
    } while (!isDiagnosticsEnabled());
    logDiagnostic("Warning: the context classloader is an ancestor of the classloader that loaded LogFactoryImpl; it should be the same or a descendant. The application using commons-logging should ensure the context classloader is used correctly.");
    return localClassLoader1;
    label117:
    throw new LogConfigurationException("Bad classloader hierarchy; LogFactoryImpl was loaded via a classloader that is not related to the current context classloader.");
  }
  
  private boolean getBooleanConfiguration(String paramString, boolean paramBoolean)
  {
    paramString = getConfigurationValue(paramString);
    if (paramString == null) {
      return paramBoolean;
    }
    return Boolean.valueOf(paramString).booleanValue();
  }
  
  protected static ClassLoader getClassLoader(Class paramClass)
  {
    return LogFactory.getClassLoader(paramClass);
  }
  
  private String getConfigurationValue(String paramString)
  {
    if (isDiagnosticsEnabled()) {
      logDiagnostic("[ENV] Trying to get configuration for item " + paramString);
    }
    Object localObject = getAttribute(paramString);
    if (localObject != null)
    {
      if (isDiagnosticsEnabled()) {
        logDiagnostic("[ENV] Found LogFactory attribute [" + localObject + "] for " + paramString);
      }
      localObject = localObject.toString();
    }
    for (;;)
    {
      return (String)localObject;
      if (isDiagnosticsEnabled()) {
        logDiagnostic("[ENV] No LogFactory attribute found for " + paramString);
      }
      try
      {
        String str = getSystemProperty(paramString, null);
        if (str != null)
        {
          localObject = str;
          if (!isDiagnosticsEnabled()) {
            continue;
          }
          logDiagnostic("[ENV] Found system property [" + str + "] for " + paramString);
          return str;
        }
      }
      catch (SecurityException localSecurityException)
      {
        if (isDiagnosticsEnabled()) {
          logDiagnostic("[ENV] Security prevented reading system property " + paramString);
        }
      }
    }
    for (;;)
    {
      if (isDiagnosticsEnabled()) {
        logDiagnostic("[ENV] No configuration defined for item " + paramString);
      }
      return null;
      if (isDiagnosticsEnabled()) {
        logDiagnostic("[ENV] No system property found for property " + paramString);
      }
    }
  }
  
  protected static ClassLoader getContextClassLoader()
  {
    return LogFactory.getContextClassLoader();
  }
  
  private static ClassLoader getContextClassLoaderInternal()
  {
    return (ClassLoader)AccessController.doPrivileged(new LogFactoryImpl.1());
  }
  
  private ClassLoader getLowestClassLoader(ClassLoader paramClassLoader1, ClassLoader paramClassLoader2)
  {
    if (paramClassLoader1 == null) {
      return paramClassLoader2;
    }
    if (paramClassLoader2 == null) {
      return paramClassLoader1;
    }
    for (ClassLoader localClassLoader = paramClassLoader1; localClassLoader != null; localClassLoader = localClassLoader.getParent()) {
      if (localClassLoader == paramClassLoader2) {
        return paramClassLoader1;
      }
    }
    for (localClassLoader = paramClassLoader2;; localClassLoader = localClassLoader.getParent())
    {
      if (localClassLoader == null) {
        break label52;
      }
      if (localClassLoader == paramClassLoader1) {
        break;
      }
    }
    label52:
    return null;
  }
  
  private ClassLoader getParentClassLoader(ClassLoader paramClassLoader)
  {
    try
    {
      paramClassLoader = (ClassLoader)AccessController.doPrivileged(new LogFactoryImpl.3(this, paramClassLoader));
      return paramClassLoader;
    }
    catch (SecurityException paramClassLoader)
    {
      logDiagnostic("[SECURITY] Unable to obtain parent classloader");
    }
    return null;
  }
  
  private static String getSystemProperty(String paramString1, String paramString2)
  {
    return (String)AccessController.doPrivileged(new LogFactoryImpl.2(paramString1, paramString2));
  }
  
  private void handleFlawedDiscovery(String paramString, ClassLoader paramClassLoader, Throwable paramThrowable)
  {
    if (isDiagnosticsEnabled())
    {
      logDiagnostic("Could not instantiate Log '" + paramString + "' -- " + paramThrowable.getClass().getName() + ": " + paramThrowable.getLocalizedMessage());
      if ((paramThrowable instanceof InvocationTargetException))
      {
        paramString = ((InvocationTargetException)paramThrowable).getTargetException();
        if (paramString != null)
        {
          logDiagnostic("... InvocationTargetException: " + paramString.getClass().getName() + ": " + paramString.getLocalizedMessage());
          if ((paramString instanceof ExceptionInInitializerError))
          {
            paramString = ((ExceptionInInitializerError)paramString).getException();
            if (paramString != null) {
              logDiagnostic("... ExceptionInInitializerError: " + paramString.getClass().getName() + ": " + paramString.getLocalizedMessage());
            }
          }
        }
      }
    }
    if (!this.allowFlawedDiscovery) {
      throw new LogConfigurationException(paramThrowable);
    }
  }
  
  private void handleFlawedHierarchy(ClassLoader paramClassLoader, Class paramClass)
  {
    int k = 0;
    Object localObject;
    int i;
    if (class$org$apache$commons$logging$Log == null)
    {
      localObject = class$("org.apache.commons.logging.Log");
      class$org$apache$commons$logging$Log = (Class)localObject;
      localObject = ((Class)localObject).getName();
      Class[] arrayOfClass = paramClass.getInterfaces();
      i = 0;
      label36:
      int j = k;
      if (i < arrayOfClass.length)
      {
        if (!((String)localObject).equals(arrayOfClass[i].getName())) {
          break label266;
        }
        j = 1;
      }
      if (j == 0) {
        break label400;
      }
      if (!isDiagnosticsEnabled()) {}
    }
    for (;;)
    {
      try
      {
        if (class$org$apache$commons$logging$Log != null) {
          continue;
        }
        localObject = class$("org.apache.commons.logging.Log");
        class$org$apache$commons$logging$Log = (Class)localObject;
        localObject = getClassLoader((Class)localObject);
        logDiagnostic("Class '" + paramClass.getName() + "' was found in classloader " + LogFactory.objectId(paramClassLoader) + ". It is bound to a Log interface which is not" + " the one loaded from classloader " + LogFactory.objectId(localObject));
      }
      catch (Throwable paramClassLoader)
      {
        label266:
        logDiagnostic("Error while trying to output diagnostics about bad class '" + paramClass + "'");
        continue;
        paramClassLoader = class$org$apache$commons$logging$Log;
        continue;
      }
      if (this.allowFlawedHierarchy) {
        break label321;
      }
      paramClass = new StringBuffer();
      paramClass.append("Terminating logging for this context ");
      paramClass.append("due to bad log hierarchy. ");
      paramClass.append("You have more than one version of '");
      if (class$org$apache$commons$logging$Log != null) {
        continue;
      }
      paramClassLoader = class$("org.apache.commons.logging.Log");
      class$org$apache$commons$logging$Log = paramClassLoader;
      paramClass.append(paramClassLoader.getName());
      paramClass.append("' visible.");
      if (isDiagnosticsEnabled()) {
        logDiagnostic(paramClass.toString());
      }
      throw new LogConfigurationException(paramClass.toString());
      localObject = class$org$apache$commons$logging$Log;
      break;
      i += 1;
      break label36;
      localObject = class$org$apache$commons$logging$Log;
    }
    label321:
    if (isDiagnosticsEnabled())
    {
      paramClass = new StringBuffer();
      paramClass.append("Warning: bad log hierarchy. ");
      paramClass.append("You have more than one version of '");
      if (class$org$apache$commons$logging$Log != null) {
        break label393;
      }
      paramClassLoader = class$("org.apache.commons.logging.Log");
      class$org$apache$commons$logging$Log = paramClassLoader;
      paramClass.append(paramClassLoader.getName());
      paramClass.append("' visible.");
      logDiagnostic(paramClass.toString());
    }
    label393:
    label400:
    do
    {
      return;
      paramClassLoader = class$org$apache$commons$logging$Log;
      break;
      if (!this.allowFlawedDiscovery)
      {
        paramClassLoader = new StringBuffer();
        paramClassLoader.append("Terminating logging for this context. ");
        paramClassLoader.append("Log class '");
        paramClassLoader.append(paramClass.getName());
        paramClassLoader.append("' does not implement the Log interface.");
        if (isDiagnosticsEnabled()) {
          logDiagnostic(paramClassLoader.toString());
        }
        throw new LogConfigurationException(paramClassLoader.toString());
      }
    } while (!isDiagnosticsEnabled());
    paramClassLoader = new StringBuffer();
    paramClassLoader.append("[WARNING] Log class '");
    paramClassLoader.append(paramClass.getName());
    paramClassLoader.append("' does not implement the Log interface.");
    logDiagnostic(paramClassLoader.toString());
  }
  
  private void informUponSimilarName(StringBuffer paramStringBuffer, String paramString1, String paramString2)
  {
    if (paramString1.equals(paramString2)) {}
    while (!paramString1.regionMatches(true, 0, paramString2, 0, PKG_LEN + 5)) {
      return;
    }
    paramStringBuffer.append(" Did you mean '");
    paramStringBuffer.append(paramString2);
    paramStringBuffer.append("'?");
  }
  
  private void initConfiguration()
  {
    this.allowFlawedContext = getBooleanConfiguration("org.apache.commons.logging.Log.allowFlawedContext", true);
    this.allowFlawedDiscovery = getBooleanConfiguration("org.apache.commons.logging.Log.allowFlawedDiscovery", true);
    this.allowFlawedHierarchy = getBooleanConfiguration("org.apache.commons.logging.Log.allowFlawedHierarchy", true);
  }
  
  private void initDiagnostics()
  {
    Object localObject = getClassLoader(getClass());
    if (localObject == null) {
      localObject = "BOOTLOADER";
    }
    for (;;)
    {
      this.diagnosticPrefix = ("[LogFactoryImpl@" + System.identityHashCode(this) + " from " + (String)localObject + "] ");
      return;
      try
      {
        localObject = LogFactory.objectId(localObject);
      }
      catch (SecurityException localSecurityException)
      {
        String str = "UNKNOWN";
      }
    }
  }
  
  protected static boolean isDiagnosticsEnabled()
  {
    return LogFactory.isDiagnosticsEnabled();
  }
  
  private boolean isLogLibraryAvailable(String paramString1, String paramString2)
  {
    if (isDiagnosticsEnabled()) {
      logDiagnostic("Checking for '" + paramString1 + "'.");
    }
    try
    {
      if (createLogFromClass(paramString2, getClass().getName(), false) == null)
      {
        if (isDiagnosticsEnabled())
        {
          logDiagnostic("Did not find '" + paramString1 + "'.");
          return false;
        }
      }
      else
      {
        if (isDiagnosticsEnabled()) {
          logDiagnostic("Found '" + paramString1 + "'.");
        }
        return true;
      }
    }
    catch (LogConfigurationException paramString2)
    {
      if (isDiagnosticsEnabled()) {
        logDiagnostic("Logging system '" + paramString1 + "' is available but not useable.");
      }
    }
    return false;
  }
  
  public Object getAttribute(String paramString)
  {
    return this.attributes.get(paramString);
  }
  
  public String[] getAttributeNames()
  {
    Vector localVector = new Vector();
    Object localObject = this.attributes.keys();
    while (((Enumeration)localObject).hasMoreElements()) {
      localVector.addElement((String)((Enumeration)localObject).nextElement());
    }
    localObject = new String[localVector.size()];
    int i = 0;
    while (i < localObject.length)
    {
      localObject[i] = ((String)localVector.elementAt(i));
      i += 1;
    }
    return (String[])localObject;
  }
  
  public Log getInstance(Class paramClass)
  {
    return getInstance(paramClass.getName());
  }
  
  public Log getInstance(String paramString)
  {
    Log localLog2 = (Log)this.instances.get(paramString);
    Log localLog1 = localLog2;
    if (localLog2 == null)
    {
      localLog1 = newInstance(paramString);
      this.instances.put(paramString, localLog1);
    }
    return localLog1;
  }
  
  protected String getLogClassName()
  {
    if (this.logClassName == null) {
      discoverLogImplementation(getClass().getName());
    }
    return this.logClassName;
  }
  
  protected Constructor getLogConstructor()
  {
    if (this.logConstructor == null) {
      discoverLogImplementation(getClass().getName());
    }
    return this.logConstructor;
  }
  
  protected boolean isJdk13LumberjackAvailable()
  {
    return isLogLibraryAvailable("Jdk13Lumberjack", "org.apache.commons.logging.impl.Jdk13LumberjackLogger");
  }
  
  protected boolean isJdk14Available()
  {
    return isLogLibraryAvailable("Jdk14", "org.apache.commons.logging.impl.Jdk14Logger");
  }
  
  protected boolean isLog4JAvailable()
  {
    return isLogLibraryAvailable("Log4J", "org.apache.commons.logging.impl.Log4JLogger");
  }
  
  protected void logDiagnostic(String paramString)
  {
    if (isDiagnosticsEnabled()) {
      LogFactory.logRawDiagnostic(this.diagnosticPrefix + paramString);
    }
  }
  
  protected Log newInstance(String paramString)
  {
    try
    {
      if (this.logConstructor == null) {}
      for (paramString = discoverLogImplementation(paramString); this.logMethod != null; paramString = (Log)this.logConstructor.newInstance(new Object[] { paramString }))
      {
        this.logMethod.invoke(paramString, new Object[] { this });
        return paramString;
      }
      Throwable localThrowable;
      return paramString;
    }
    catch (LogConfigurationException paramString)
    {
      throw paramString;
    }
    catch (InvocationTargetException paramString)
    {
      localThrowable = paramString.getTargetException();
      if (localThrowable != null) {
        throw new LogConfigurationException(localThrowable);
      }
      throw new LogConfigurationException(paramString);
    }
    catch (Throwable paramString)
    {
      throw new LogConfigurationException(paramString);
    }
  }
  
  public void release()
  {
    logDiagnostic("Releasing all known loggers");
    this.instances.clear();
  }
  
  public void removeAttribute(String paramString)
  {
    this.attributes.remove(paramString);
  }
  
  public void setAttribute(String paramString, Object paramObject)
  {
    if (this.logConstructor != null) {
      logDiagnostic("setAttribute: call too late; configuration already performed.");
    }
    if (paramObject == null) {
      this.attributes.remove(paramString);
    }
    for (;;)
    {
      if (paramString.equals("use_tccl")) {
        this.useTCCL = Boolean.valueOf(paramObject.toString()).booleanValue();
      }
      return;
      this.attributes.put(paramString, paramObject);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/org/apache/commons/logging/impl/LogFactoryImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */