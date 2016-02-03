package com.vladium.emma.rt;

import com.vladium.emma.EMMARuntimeException;
import com.vladium.emma.IAppConstants;
import com.vladium.emma.IAppErrorCodes;
import com.vladium.emma.Processor;
import com.vladium.emma.data.ICoverageData;
import com.vladium.emma.data.IMetaData;
import com.vladium.emma.filter.IInclExclFilter;
import com.vladium.emma.filter.IInclExclFilter.Factory;
import com.vladium.emma.report.AbstractReportGenerator;
import com.vladium.emma.report.IReportGenerator;
import com.vladium.emma.report.SourcePathCache;
import com.vladium.logging.Logger;
import com.vladium.util.Files;
import com.vladium.util.IConstants;
import com.vladium.util.IProperties;
import com.vladium.util.Strings;
import com.vladium.util.exception.Exceptions;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AppRunner
  extends Processor
  implements IAppErrorCodes
{
  protected static final String COMMA_DELIMITERS = ", \t\r\n";
  private static final Class[] EXPECTED_FAILURES = { EMMARuntimeException.class, IllegalArgumentException.class, IllegalStateException.class };
  private static final String[] FORCED_DELEGATION_FILTER_SPECS = { "+" + IAppConstants.APP_PACKAGE + ".*" };
  private static final boolean INIT_AT_LOAD_TIME = false;
  private static final int INIT_CACHE_CAPACITY = 2003;
  private static final Class[] MAIN_TYPE = { String[].class };
  protected static final String PATH_DELIMITERS = ",".concat(File.pathSeparator);
  private static final boolean SET_CURRENT_CONTEXT_LOADER = false;
  private static final int SOFT_CACHE_READ_CHK_FREQUENCY = 100;
  private static final int SOFT_CACHE_WRITE_CHK_FREQUENCY = 100;
  private static final boolean USE_SOFT_CACHE = true;
  private String[] m_appArgs;
  private String m_appClassName;
  private boolean m_canonical;
  private IInclExclFilter m_coverageFilter;
  private File[] m_coveragePath;
  private final ClassLoader m_delegate;
  private boolean m_dumpSessionData;
  private IReportGenerator[] m_reportGenerators;
  private boolean m_scanCoveragePath;
  private File m_sdataOutFile;
  private Boolean m_sdataOutMerge;
  private File[] m_sourcePath;
  
  private AppRunner(ClassLoader paramClassLoader)
  {
    this.m_delegate = paramClassLoader;
    this.m_coveragePath = IConstants.EMPTY_FILE_ARRAY;
  }
  
  public static AppRunner create(ClassLoader paramClassLoader)
  {
    return new AppRunner(paramClassLoader);
  }
  
  private static void joinNonDeamonThreads(ThreadGroup paramThreadGroup)
  {
    if (paramThreadGroup == null) {
      throw new IllegalArgumentException("null input: group");
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      localArrayList.clear();
      try
      {
        localObject2 = new Thread[paramThreadGroup.activeCount() << 1];
        int j = paramThreadGroup.enumerate((Thread[])localObject2, true);
        int i = 0;
        while (i < j)
        {
          if (!localObject2[i].isDaemon()) {
            localArrayList.add(localObject2[i]);
          }
          i += 1;
        }
        if (!((List)localObject1).isEmpty()) {
          break label101;
        }
      }
      finally {}
      return;
      label101:
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext()) {
        try
        {
          ((Thread)((Iterator)localObject2).next()).join();
        }
        catch (InterruptedException localInterruptedException) {}
      }
    }
  }
  
  private static RuntimeException wrapFailure(Throwable paramThrowable)
  {
    if (Exceptions.unexpectedFailure(paramThrowable, EXPECTED_FAILURES)) {
      return new EMMARuntimeException("UNEXPECTED_FAILURE", new Object[] { paramThrowable.toString(), "this private build is unsupported" }, paramThrowable);
    }
    if ((paramThrowable instanceof RuntimeException)) {
      return (RuntimeException)paramThrowable;
    }
    return new EMMARuntimeException(paramThrowable);
  }
  
  /* Error */
  protected void _run(IProperties paramIProperties)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 219	com/vladium/emma/rt/AppRunner:m_log	Lcom/vladium/logging/Logger;
    //   4: astore 10
    //   6: aload 10
    //   8: invokevirtual 224	com/vladium/logging/Logger:atVERBOSE	()Z
    //   11: istore_3
    //   12: iload_3
    //   13: ifeq +131 -> 144
    //   16: aload 10
    //   18: ldc -30
    //   20: invokevirtual 229	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   23: aload 10
    //   25: ldc -25
    //   27: invokevirtual 229	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   30: aload 10
    //   32: ldc -23
    //   34: invokevirtual 229	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   37: iconst_0
    //   38: istore_2
    //   39: iload_2
    //   40: aload_0
    //   41: getfield 118	com/vladium/emma/rt/AppRunner:m_coveragePath	[Ljava/io/File;
    //   44: arraylength
    //   45: if_icmpge +70 -> 115
    //   48: aload_0
    //   49: getfield 118	com/vladium/emma/rt/AppRunner:m_coveragePath	[Ljava/io/File;
    //   52: iload_2
    //   53: aaload
    //   54: astore 5
    //   56: aload 5
    //   58: invokevirtual 236	java/io/File:exists	()Z
    //   61: ifeq +47 -> 108
    //   64: ldc -18
    //   66: astore 4
    //   68: aload 10
    //   70: new 84	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   77: ldc -16
    //   79: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload 4
    //   84: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 5
    //   89: invokevirtual 243	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   92: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokevirtual 229	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   101: iload_2
    //   102: iconst_1
    //   103: iadd
    //   104: istore_2
    //   105: goto -66 -> 39
    //   108: ldc -11
    //   110: astore 4
    //   112: goto -44 -> 68
    //   115: aload 10
    //   117: ldc -9
    //   119: invokevirtual 229	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   122: aload_0
    //   123: getfield 249	com/vladium/emma/rt/AppRunner:m_sourcePath	[Ljava/io/File;
    //   126: ifnull +11 -> 137
    //   129: aload_0
    //   130: getfield 249	com/vladium/emma/rt/AppRunner:m_sourcePath	[Ljava/io/File;
    //   133: arraylength
    //   134: ifne +663 -> 797
    //   137: aload 10
    //   139: ldc -5
    //   141: invokevirtual 229	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield 253	com/vladium/emma/rt/AppRunner:m_sdataOutFile	Ljava/io/File;
    //   148: astore 4
    //   150: aload_0
    //   151: getfield 255	com/vladium/emma/rt/AppRunner:m_sdataOutMerge	Ljava/lang/Boolean;
    //   154: astore 5
    //   156: aload 4
    //   158: astore 6
    //   160: aload 4
    //   162: ifnonnull +24 -> 186
    //   165: new 63	java/io/File
    //   168: dup
    //   169: aload_1
    //   170: ldc_w 257
    //   173: ldc_w 259
    //   176: invokeinterface 265 3 0
    //   181: invokespecial 266	java/io/File:<init>	(Ljava/lang/String;)V
    //   184: astore 6
    //   186: aload 5
    //   188: astore 4
    //   190: aload 5
    //   192: ifnonnull +29 -> 221
    //   195: aload_1
    //   196: ldc_w 268
    //   199: getstatic 273	com/vladium/emma/EMMAProperties:DEFAULT_SESSION_DATA_OUT_MERGE	Ljava/lang/Boolean;
    //   202: invokevirtual 276	java/lang/Boolean:toString	()Ljava/lang/String;
    //   205: invokeinterface 265 3 0
    //   210: invokestatic 282	com/vladium/util/Property:toBoolean	(Ljava/lang/String;)Z
    //   213: ifeq +687 -> 900
    //   216: getstatic 285	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   219: astore 4
    //   221: iload_3
    //   222: ifeq +65 -> 287
    //   225: aload_0
    //   226: getfield 287	com/vladium/emma/rt/AppRunner:m_dumpSessionData	Z
    //   229: ifeq +58 -> 287
    //   232: aload 10
    //   234: new 84	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   241: ldc_w 289
    //   244: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload 6
    //   249: invokevirtual 243	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   252: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokevirtual 229	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   261: aload 10
    //   263: new 84	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 291
    //   273: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 4
    //   278: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokevirtual 229	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   287: aload_1
    //   288: ldc_w 296
    //   291: invokeinterface 298 2 0
    //   296: ldc 16
    //   298: getstatic 106	com/vladium/emma/rt/AppRunner:FORCED_DELEGATION_FILTER_SPECS	[Ljava/lang/String;
    //   301: invokestatic 303	com/vladium/emma/filter/IInclExclFilter$Factory:create	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/vladium/emma/filter/IInclExclFilter;
    //   304: astore 9
    //   306: aload_1
    //   307: ldc_w 305
    //   310: invokeinterface 298 2 0
    //   315: ldc 16
    //   317: aconst_null
    //   318: invokestatic 303	com/vladium/emma/filter/IInclExclFilter$Factory:create	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lcom/vladium/emma/filter/IInclExclFilter;
    //   321: astore 11
    //   323: aconst_null
    //   324: astore 5
    //   326: invokestatic 311	com/vladium/util/exit/ExitHookManager:getSingleton	()Lcom/vladium/util/exit/ExitHookManager;
    //   329: astore 7
    //   331: aload 7
    //   333: astore 5
    //   335: aconst_null
    //   336: astore 8
    //   338: aconst_null
    //   339: astore 7
    //   341: aload_0
    //   342: getfield 249	com/vladium/emma/rt/AppRunner:m_sourcePath	[Ljava/io/File;
    //   345: ifnull +17 -> 362
    //   348: new 313	com/vladium/emma/report/SourcePathCache
    //   351: dup
    //   352: aload_0
    //   353: getfield 249	com/vladium/emma/rt/AppRunner:m_sourcePath	[Ljava/io/File;
    //   356: iconst_1
    //   357: invokespecial 316	com/vladium/emma/report/SourcePathCache:<init>	([Ljava/io/File;Z)V
    //   360: astore 7
    //   362: invokestatic 322	com/vladium/emma/rt/RT:getCoverageData	()Lcom/vladium/emma/data/ICoverageData;
    //   365: astore 13
    //   367: aload_1
    //   368: invokestatic 327	com/vladium/emma/data/CoverageOptionsFactory:create	(Lcom/vladium/util/IProperties;)Lcom/vladium/emma/data/CoverageOptions;
    //   371: invokestatic 333	com/vladium/emma/data/DataFactory:newMetaData	(Lcom/vladium/emma/data/CoverageOptions;)Lcom/vladium/emma/data/IMetaData;
    //   374: astore 12
    //   376: new 8	com/vladium/emma/rt/AppRunner$AppRunnerExitHook
    //   379: dup
    //   380: aload 10
    //   382: aload_0
    //   383: getfield 287	com/vladium/emma/rt/AppRunner:m_dumpSessionData	Z
    //   386: aload 6
    //   388: aload 4
    //   390: invokevirtual 336	java/lang/Boolean:booleanValue	()Z
    //   393: aload 12
    //   395: aload 13
    //   397: aload_0
    //   398: getfield 338	com/vladium/emma/rt/AppRunner:m_reportGenerators	[Lcom/vladium/emma/report/IReportGenerator;
    //   401: aload 7
    //   403: aload_1
    //   404: invokespecial 341	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:<init>	(Lcom/vladium/logging/Logger;ZLjava/io/File;ZLcom/vladium/emma/data/IMetaData;Lcom/vladium/emma/data/ICoverageData;[Lcom/vladium/emma/report/IReportGenerator;Lcom/vladium/emma/report/SourcePathCache;Lcom/vladium/util/IProperties;)V
    //   407: astore 6
    //   409: aload 5
    //   411: ifnull +11 -> 422
    //   414: aload 5
    //   416: aload 6
    //   418: invokevirtual 345	com/vladium/util/exit/ExitHookManager:addExitHook	(Ljava/lang/Runnable;)Z
    //   421: pop
    //   422: aconst_null
    //   423: astore_1
    //   424: aload_0
    //   425: getfield 347	com/vladium/emma/rt/AppRunner:m_scanCoveragePath	Z
    //   428: ifeq +130 -> 558
    //   431: new 349	com/vladium/util/SoftValueMap
    //   434: dup
    //   435: sipush 2003
    //   438: ldc_w 350
    //   441: bipush 100
    //   443: bipush 100
    //   445: invokespecial 353	com/vladium/util/SoftValueMap:<init>	(IFII)V
    //   448: astore 4
    //   450: new 355	com/vladium/emma/rt/ClassPathProcessorST
    //   453: dup
    //   454: aload_0
    //   455: getfield 118	com/vladium/emma/rt/AppRunner:m_coveragePath	[Ljava/io/File;
    //   458: aload_0
    //   459: getfield 357	com/vladium/emma/rt/AppRunner:m_canonical	Z
    //   462: aload 12
    //   464: aload_0
    //   465: getfield 359	com/vladium/emma/rt/AppRunner:m_coverageFilter	Lcom/vladium/emma/filter/IInclExclFilter;
    //   468: aload 4
    //   470: invokespecial 362	com/vladium/emma/rt/ClassPathProcessorST:<init>	([Ljava/io/File;ZLcom/vladium/emma/data/IMetaData;Lcom/vladium/emma/filter/IInclExclFilter;Ljava/util/Map;)V
    //   473: invokevirtual 365	com/vladium/emma/rt/ClassPathProcessorST:run	()V
    //   476: aload 4
    //   478: astore_1
    //   479: aload 10
    //   481: invokevirtual 368	com/vladium/logging/Logger:atTRACE1	()Z
    //   484: ifeq +74 -> 558
    //   487: aload 10
    //   489: ldc_w 369
    //   492: new 84	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   499: ldc_w 371
    //   502: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: aload 4
    //   507: invokeinterface 376 1 0
    //   512: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   515: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokevirtual 383	com/vladium/logging/Logger:trace1	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: aload 10
    //   523: ldc_w 369
    //   526: new 84	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   533: ldc_w 385
    //   536: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload 12
    //   541: invokeinterface 388 1 0
    //   546: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   549: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokevirtual 383	com/vladium/logging/Logger:trace1	(Ljava/lang/String;Ljava/lang/String;)V
    //   555: aload 4
    //   557: astore_1
    //   558: new 390	com/vladium/emma/rt/InstrClassLoadHook
    //   561: dup
    //   562: aload_0
    //   563: getfield 359	com/vladium/emma/rt/AppRunner:m_coverageFilter	Lcom/vladium/emma/filter/IInclExclFilter;
    //   566: aload 12
    //   568: invokespecial 393	com/vladium/emma/rt/InstrClassLoadHook:<init>	(Lcom/vladium/emma/filter/IInclExclFilter;Lcom/vladium/emma/data/IMetaData;)V
    //   571: astore 4
    //   573: new 395	com/vladium/emma/rt/InstrClassLoader
    //   576: dup
    //   577: aload_0
    //   578: getfield 111	com/vladium/emma/rt/AppRunner:m_delegate	Ljava/lang/ClassLoader;
    //   581: aload_0
    //   582: getfield 118	com/vladium/emma/rt/AppRunner:m_coveragePath	[Ljava/io/File;
    //   585: aload 9
    //   587: aload 11
    //   589: aload 4
    //   591: aload_1
    //   592: invokespecial 398	com/vladium/emma/rt/InstrClassLoader:<init>	(Ljava/lang/ClassLoader;[Ljava/io/File;Lcom/vladium/emma/filter/IInclExclFilter;Lcom/vladium/emma/filter/IInclExclFilter;Lcom/vladium/emma/rt/IClassLoadHook;Ljava/util/Map;)V
    //   595: astore 11
    //   597: aconst_null
    //   598: astore 9
    //   600: aconst_null
    //   601: astore 7
    //   603: aload 9
    //   605: astore_1
    //   606: aload_0
    //   607: getfield 400	com/vladium/emma/rt/AppRunner:m_appClassName	Ljava/lang/String;
    //   610: iconst_0
    //   611: aload 11
    //   613: invokestatic 404	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   616: astore 4
    //   618: aload 9
    //   620: astore_1
    //   621: aload 4
    //   623: invokevirtual 408	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   626: astore 12
    //   628: aload 12
    //   630: aload 11
    //   632: if_acmpeq +444 -> 1076
    //   635: aload 12
    //   637: ifnull +431 -> 1068
    //   640: aload 9
    //   642: astore_1
    //   643: aload 12
    //   645: invokevirtual 412	java/lang/Object:getClass	()Ljava/lang/Class;
    //   648: invokevirtual 415	java/lang/Class:getName	()Ljava/lang/String;
    //   651: astore 4
    //   653: aload 9
    //   655: astore_1
    //   656: new 76	com/vladium/emma/EMMARuntimeException
    //   659: dup
    //   660: ldc_w 417
    //   663: iconst_3
    //   664: anewarray 68	java/lang/String
    //   667: dup
    //   668: iconst_0
    //   669: ldc_w 419
    //   672: aastore
    //   673: dup
    //   674: iconst_1
    //   675: aload_0
    //   676: getfield 400	com/vladium/emma/rt/AppRunner:m_appClassName	Ljava/lang/String;
    //   679: aastore
    //   680: dup
    //   681: iconst_2
    //   682: aload 4
    //   684: aastore
    //   685: invokespecial 422	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   688: athrow
    //   689: astore 4
    //   691: aload 7
    //   693: astore_1
    //   694: new 76	com/vladium/emma/EMMARuntimeException
    //   697: dup
    //   698: ldc_w 424
    //   701: iconst_1
    //   702: anewarray 68	java/lang/String
    //   705: dup
    //   706: iconst_0
    //   707: ldc_w 419
    //   710: aastore
    //   711: aload 4
    //   713: invokespecial 198	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   716: athrow
    //   717: astore 7
    //   719: aload_1
    //   720: astore 4
    //   722: aload 7
    //   724: astore_1
    //   725: aload 4
    //   727: ifnull +18 -> 745
    //   730: aload 4
    //   732: invokevirtual 427	java/lang/ThreadGroup:isDestroyed	()Z
    //   735: istore_3
    //   736: iload_3
    //   737: ifne +8 -> 745
    //   740: aload 4
    //   742: invokevirtual 430	java/lang/ThreadGroup:destroy	()V
    //   745: aload_1
    //   746: athrow
    //   747: astore 4
    //   749: aload 6
    //   751: astore_1
    //   752: iconst_0
    //   753: iconst_0
    //   754: invokestatic 434	com/vladium/emma/rt/RT:reset	(ZZ)Lcom/vladium/emma/data/ICoverageData;
    //   757: pop
    //   758: aload_1
    //   759: invokevirtual 435	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:run	()V
    //   762: aload 5
    //   764: ifnull +10 -> 774
    //   767: aload 5
    //   769: aload_1
    //   770: invokevirtual 438	com/vladium/util/exit/ExitHookManager:removeExitHook	(Ljava/lang/Runnable;)Z
    //   773: pop
    //   774: aload_1
    //   775: invokevirtual 442	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:getDataDumpFailure	()Ljava/lang/Throwable;
    //   778: astore 6
    //   780: aload_1
    //   781: invokevirtual 446	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:getReportFailures	()Ljava/util/List;
    //   784: astore 5
    //   786: aload 4
    //   788: ifnull +695 -> 1483
    //   791: aload 4
    //   793: invokestatic 448	com/vladium/emma/rt/AppRunner:wrapFailure	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   796: athrow
    //   797: aload 10
    //   799: ldc_w 450
    //   802: invokevirtual 229	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   805: aload 10
    //   807: ldc -23
    //   809: invokevirtual 229	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   812: iconst_0
    //   813: istore_2
    //   814: iload_2
    //   815: aload_0
    //   816: getfield 249	com/vladium/emma/rt/AppRunner:m_sourcePath	[Ljava/io/File;
    //   819: arraylength
    //   820: if_icmpge +70 -> 890
    //   823: aload_0
    //   824: getfield 249	com/vladium/emma/rt/AppRunner:m_sourcePath	[Ljava/io/File;
    //   827: iload_2
    //   828: aaload
    //   829: astore 5
    //   831: aload 5
    //   833: invokevirtual 236	java/io/File:exists	()Z
    //   836: ifeq +47 -> 883
    //   839: ldc -18
    //   841: astore 4
    //   843: aload 10
    //   845: new 84	java/lang/StringBuilder
    //   848: dup
    //   849: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   852: ldc -16
    //   854: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload 4
    //   859: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: aload 5
    //   864: invokevirtual 243	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   867: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokevirtual 229	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   876: iload_2
    //   877: iconst_1
    //   878: iadd
    //   879: istore_2
    //   880: goto -66 -> 814
    //   883: ldc -11
    //   885: astore 4
    //   887: goto -44 -> 843
    //   890: aload 10
    //   892: ldc -9
    //   894: invokevirtual 229	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   897: goto -753 -> 144
    //   900: getstatic 453	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   903: astore 4
    //   905: goto -684 -> 221
    //   908: astore 7
    //   910: aload 7
    //   912: getstatic 459	java/lang/System:out	Ljava/io/PrintStream;
    //   915: invokevirtual 463	java/lang/Exception:printStackTrace	(Ljava/io/PrintStream;)V
    //   918: goto -583 -> 335
    //   921: astore_1
    //   922: new 76	com/vladium/emma/EMMARuntimeException
    //   925: dup
    //   926: ldc_w 424
    //   929: iconst_1
    //   930: anewarray 68	java/lang/String
    //   933: dup
    //   934: iconst_0
    //   935: ldc_w 419
    //   938: aastore
    //   939: aload_1
    //   940: invokespecial 198	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   943: athrow
    //   944: astore_1
    //   945: iconst_0
    //   946: iconst_0
    //   947: invokestatic 434	com/vladium/emma/rt/RT:reset	(ZZ)Lcom/vladium/emma/data/ICoverageData;
    //   950: pop
    //   951: aload_1
    //   952: athrow
    //   953: astore_1
    //   954: new 76	com/vladium/emma/EMMARuntimeException
    //   957: dup
    //   958: aload_1
    //   959: invokespecial 203	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   962: athrow
    //   963: astore 4
    //   965: aload 9
    //   967: astore_1
    //   968: new 76	com/vladium/emma/EMMARuntimeException
    //   971: dup
    //   972: ldc_w 465
    //   975: iconst_1
    //   976: anewarray 68	java/lang/String
    //   979: dup
    //   980: iconst_0
    //   981: aload_0
    //   982: getfield 400	com/vladium/emma/rt/AppRunner:m_appClassName	Ljava/lang/String;
    //   985: aastore
    //   986: aload 4
    //   988: invokespecial 198	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   991: athrow
    //   992: astore 4
    //   994: aload 9
    //   996: astore_1
    //   997: aload 4
    //   999: invokevirtual 468	java/lang/ExceptionInInitializerError:getException	()Ljava/lang/Throwable;
    //   1002: astore 4
    //   1004: aload 9
    //   1006: astore_1
    //   1007: new 76	com/vladium/emma/EMMARuntimeException
    //   1010: dup
    //   1011: ldc_w 470
    //   1014: iconst_2
    //   1015: anewarray 68	java/lang/String
    //   1018: dup
    //   1019: iconst_0
    //   1020: aload_0
    //   1021: getfield 400	com/vladium/emma/rt/AppRunner:m_appClassName	Ljava/lang/String;
    //   1024: aastore
    //   1025: dup
    //   1026: iconst_1
    //   1027: aload 4
    //   1029: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1032: aastore
    //   1033: aload 4
    //   1035: invokespecial 198	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   1038: athrow
    //   1039: astore 4
    //   1041: aload 9
    //   1043: astore_1
    //   1044: new 76	com/vladium/emma/EMMARuntimeException
    //   1047: dup
    //   1048: ldc_w 465
    //   1051: iconst_1
    //   1052: anewarray 68	java/lang/String
    //   1055: dup
    //   1056: iconst_0
    //   1057: aload_0
    //   1058: getfield 400	com/vladium/emma/rt/AppRunner:m_appClassName	Ljava/lang/String;
    //   1061: aastore
    //   1062: aload 4
    //   1064: invokespecial 198	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   1067: athrow
    //   1068: ldc_w 472
    //   1071: astore 4
    //   1073: goto -420 -> 653
    //   1076: aload 9
    //   1078: astore_1
    //   1079: aload 4
    //   1081: ldc_w 474
    //   1084: getstatic 59	com/vladium/emma/rt/AppRunner:MAIN_TYPE	[Ljava/lang/Class;
    //   1087: invokevirtual 478	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1090: astore 4
    //   1092: aload 9
    //   1094: astore_1
    //   1095: new 11	com/vladium/emma/rt/AppRunner$Invoker
    //   1098: dup
    //   1099: aload 4
    //   1101: aconst_null
    //   1102: iconst_1
    //   1103: anewarray 190	java/lang/Object
    //   1106: dup
    //   1107: iconst_0
    //   1108: aload_0
    //   1109: getfield 480	com/vladium/emma/rt/AppRunner:m_appArgs	[Ljava/lang/String;
    //   1112: aastore
    //   1113: invokespecial 483	com/vladium/emma/rt/AppRunner$Invoker:<init>	(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)V
    //   1116: astore 12
    //   1118: aload 9
    //   1120: astore_1
    //   1121: new 141	java/lang/ThreadGroup
    //   1124: dup
    //   1125: new 84	java/lang/StringBuilder
    //   1128: dup
    //   1129: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   1132: ldc_w 485
    //   1135: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1138: aload_0
    //   1139: getfield 400	com/vladium/emma/rt/AppRunner:m_appClassName	Ljava/lang/String;
    //   1142: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: ldc_w 487
    //   1148: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1154: invokespecial 488	java/lang/ThreadGroup:<init>	(Ljava/lang/String;)V
    //   1157: astore 4
    //   1159: aload 4
    //   1161: iconst_1
    //   1162: invokevirtual 492	java/lang/ThreadGroup:setDaemon	(Z)V
    //   1165: new 147	java/lang/Thread
    //   1168: dup
    //   1169: aload 4
    //   1171: aload 12
    //   1173: ldc_w 494
    //   1176: invokespecial 497	java/lang/Thread:<init>	(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;)V
    //   1179: astore_1
    //   1180: aload_1
    //   1181: aload 11
    //   1183: invokevirtual 500	java/lang/Thread:setContextClassLoader	(Ljava/lang/ClassLoader;)V
    //   1186: aload_1
    //   1187: invokevirtual 503	java/lang/Thread:start	()V
    //   1190: aload_1
    //   1191: invokevirtual 178	java/lang/Thread:join	()V
    //   1194: aload 4
    //   1196: invokestatic 505	com/vladium/emma/rt/AppRunner:joinNonDeamonThreads	(Ljava/lang/ThreadGroup;)V
    //   1199: aload 10
    //   1201: invokevirtual 368	com/vladium/logging/Logger:atTRACE1	()Z
    //   1204: ifeq +24 -> 1228
    //   1207: aload 11
    //   1209: instanceof 395
    //   1212: ifeq +16 -> 1228
    //   1215: aload 11
    //   1217: checkcast 395	com/vladium/emma/rt/InstrClassLoader
    //   1220: aload 10
    //   1222: invokevirtual 509	com/vladium/logging/Logger:getWriter	()Ljava/io/PrintWriter;
    //   1225: invokevirtual 513	com/vladium/emma/rt/InstrClassLoader:debugDump	(Ljava/io/PrintWriter;)V
    //   1228: aload 12
    //   1230: invokevirtual 516	com/vladium/emma/rt/AppRunner$Invoker:getFailure	()Ljava/lang/Throwable;
    //   1233: astore_1
    //   1234: aload_1
    //   1235: ifnull +208 -> 1443
    //   1238: aload_1
    //   1239: instanceof 518
    //   1242: ifeq +82 -> 1324
    //   1245: aload_1
    //   1246: checkcast 518	java/lang/reflect/InvocationTargetException
    //   1249: invokevirtual 521	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
    //   1252: astore_1
    //   1253: new 76	com/vladium/emma/EMMARuntimeException
    //   1256: dup
    //   1257: ldc_w 523
    //   1260: iconst_2
    //   1261: anewarray 68	java/lang/String
    //   1264: dup
    //   1265: iconst_0
    //   1266: aload_0
    //   1267: getfield 400	com/vladium/emma/rt/AppRunner:m_appClassName	Ljava/lang/String;
    //   1270: aastore
    //   1271: dup
    //   1272: iconst_1
    //   1273: aload_1
    //   1274: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1277: aastore
    //   1278: aload_1
    //   1279: invokespecial 198	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   1282: athrow
    //   1283: astore 7
    //   1285: aload 4
    //   1287: astore_1
    //   1288: aload 7
    //   1290: astore 4
    //   1292: goto -598 -> 694
    //   1295: astore 4
    //   1297: aload 9
    //   1299: astore_1
    //   1300: new 76	com/vladium/emma/EMMARuntimeException
    //   1303: dup
    //   1304: ldc_w 525
    //   1307: iconst_1
    //   1308: anewarray 68	java/lang/String
    //   1311: dup
    //   1312: iconst_0
    //   1313: aload_0
    //   1314: getfield 400	com/vladium/emma/rt/AppRunner:m_appClassName	Ljava/lang/String;
    //   1317: aastore
    //   1318: aload 4
    //   1320: invokespecial 198	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   1323: athrow
    //   1324: aload_1
    //   1325: instanceof 215
    //   1328: ifeq +41 -> 1369
    //   1331: aload_1
    //   1332: checkcast 215	java/lang/ExceptionInInitializerError
    //   1335: invokevirtual 468	java/lang/ExceptionInInitializerError:getException	()Ljava/lang/Throwable;
    //   1338: astore_1
    //   1339: new 76	com/vladium/emma/EMMARuntimeException
    //   1342: dup
    //   1343: ldc_w 523
    //   1346: iconst_2
    //   1347: anewarray 68	java/lang/String
    //   1350: dup
    //   1351: iconst_0
    //   1352: aload_0
    //   1353: getfield 400	com/vladium/emma/rt/AppRunner:m_appClassName	Ljava/lang/String;
    //   1356: aastore
    //   1357: dup
    //   1358: iconst_1
    //   1359: aload_1
    //   1360: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1363: aastore
    //   1364: aload_1
    //   1365: invokespecial 198	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   1368: athrow
    //   1369: aload_1
    //   1370: instanceof 527
    //   1373: ifne +17 -> 1390
    //   1376: aload_1
    //   1377: instanceof 78
    //   1380: ifne +10 -> 1390
    //   1383: aload_1
    //   1384: instanceof 529
    //   1387: ifeq +26 -> 1413
    //   1390: new 76	com/vladium/emma/EMMARuntimeException
    //   1393: dup
    //   1394: ldc_w 525
    //   1397: iconst_1
    //   1398: anewarray 68	java/lang/String
    //   1401: dup
    //   1402: iconst_0
    //   1403: aload_0
    //   1404: getfield 400	com/vladium/emma/rt/AppRunner:m_appClassName	Ljava/lang/String;
    //   1407: aastore
    //   1408: aload_1
    //   1409: invokespecial 198	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   1412: athrow
    //   1413: new 76	com/vladium/emma/EMMARuntimeException
    //   1416: dup
    //   1417: ldc_w 523
    //   1420: iconst_2
    //   1421: anewarray 68	java/lang/String
    //   1424: dup
    //   1425: iconst_0
    //   1426: aload_0
    //   1427: getfield 400	com/vladium/emma/rt/AppRunner:m_appClassName	Ljava/lang/String;
    //   1430: aastore
    //   1431: dup
    //   1432: iconst_1
    //   1433: aload_1
    //   1434: invokevirtual 193	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1437: aastore
    //   1438: aload_1
    //   1439: invokespecial 198	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   1442: athrow
    //   1443: aload 4
    //   1445: ifnull +179 -> 1624
    //   1448: aload 4
    //   1450: invokevirtual 427	java/lang/ThreadGroup:isDestroyed	()Z
    //   1453: istore_3
    //   1454: iload_3
    //   1455: ifne +169 -> 1624
    //   1458: aload 4
    //   1460: invokevirtual 430	java/lang/ThreadGroup:destroy	()V
    //   1463: iconst_0
    //   1464: iconst_0
    //   1465: invokestatic 434	com/vladium/emma/rt/RT:reset	(ZZ)Lcom/vladium/emma/data/ICoverageData;
    //   1468: pop
    //   1469: aload 6
    //   1471: astore_1
    //   1472: aload 8
    //   1474: astore 4
    //   1476: goto -718 -> 758
    //   1479: astore_1
    //   1480: goto -17 -> 1463
    //   1483: aload 6
    //   1485: ifnonnull +8 -> 1493
    //   1488: aload 5
    //   1490: ifnull +122 -> 1612
    //   1493: aload 6
    //   1495: ifnull +14 -> 1509
    //   1498: aload 10
    //   1500: iconst_0
    //   1501: ldc_w 531
    //   1504: aload 6
    //   1506: invokevirtual 535	com/vladium/logging/Logger:log	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1509: aconst_null
    //   1510: astore 4
    //   1512: aconst_null
    //   1513: astore_1
    //   1514: aload 5
    //   1516: ifnull +65 -> 1581
    //   1519: aload 5
    //   1521: invokeinterface 166 1 0
    //   1526: astore 7
    //   1528: aload_1
    //   1529: astore 4
    //   1531: aload 7
    //   1533: invokeinterface 171 1 0
    //   1538: ifeq +43 -> 1581
    //   1541: aload 7
    //   1543: invokeinterface 175 1 0
    //   1548: checkcast 192	java/lang/Throwable
    //   1551: astore 5
    //   1553: aload_1
    //   1554: astore 4
    //   1556: aload_1
    //   1557: ifnonnull +7 -> 1564
    //   1560: aload 5
    //   1562: astore 4
    //   1564: aload 10
    //   1566: iconst_0
    //   1567: ldc_w 537
    //   1570: aload 5
    //   1572: invokevirtual 535	com/vladium/logging/Logger:log	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1575: aload 4
    //   1577: astore_1
    //   1578: goto -50 -> 1528
    //   1581: aload 6
    //   1583: ifnull +9 -> 1592
    //   1586: aload 6
    //   1588: invokestatic 448	com/vladium/emma/rt/AppRunner:wrapFailure	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   1591: athrow
    //   1592: aload 4
    //   1594: ifnull +18 -> 1612
    //   1597: aload 4
    //   1599: invokestatic 448	com/vladium/emma/rt/AppRunner:wrapFailure	(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;
    //   1602: athrow
    //   1603: astore_1
    //   1604: goto -410 -> 1194
    //   1607: astore 4
    //   1609: goto -864 -> 745
    //   1612: return
    //   1613: astore_1
    //   1614: goto -669 -> 945
    //   1617: astore 4
    //   1619: aconst_null
    //   1620: astore_1
    //   1621: goto -869 -> 752
    //   1624: goto -161 -> 1463
    //   1627: astore_1
    //   1628: goto -903 -> 725
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1631	0	this	AppRunner
    //   0	1631	1	paramIProperties	IProperties
    //   38	842	2	i	int
    //   11	1444	3	bool	boolean
    //   66	617	4	localObject1	Object
    //   689	23	4	localSecurityException1	SecurityException
    //   720	21	4	localIProperties	IProperties
    //   747	45	4	localRuntimeException1	RuntimeException
    //   841	63	4	localObject2	Object
    //   963	24	4	localClassNotFoundException	ClassNotFoundException
    //   992	6	4	localExceptionInInitializerError	ExceptionInInitializerError
    //   1002	32	4	localThrowable1	Throwable
    //   1039	24	4	localThrowable2	Throwable
    //   1071	220	4	localObject3	Object
    //   1295	164	4	localThrowable3	Throwable
    //   1474	124	4	localObject4	Object
    //   1607	1	4	localThrowable4	Throwable
    //   1617	1	4	localRuntimeException2	RuntimeException
    //   54	1517	5	localObject5	Object
    //   158	1429	6	localObject6	Object
    //   329	363	7	localObject7	Object
    //   717	6	7	localObject8	Object
    //   908	3	7	localException	Exception
    //   1283	6	7	localSecurityException2	SecurityException
    //   1526	16	7	localIterator	Iterator
    //   336	1137	8	localObject9	Object
    //   304	994	9	localIInclExclFilter	IInclExclFilter
    //   4	1561	10	localLogger	Logger
    //   321	895	11	localObject10	Object
    //   374	855	12	localObject11	Object
    //   365	31	13	localICoverageData	ICoverageData
    // Exception table:
    //   from	to	target	type
    //   606	618	689	java/lang/SecurityException
    //   621	628	689	java/lang/SecurityException
    //   643	653	689	java/lang/SecurityException
    //   656	689	689	java/lang/SecurityException
    //   968	992	689	java/lang/SecurityException
    //   997	1004	689	java/lang/SecurityException
    //   1007	1039	689	java/lang/SecurityException
    //   1044	1068	689	java/lang/SecurityException
    //   1079	1092	689	java/lang/SecurityException
    //   1095	1118	689	java/lang/SecurityException
    //   1121	1159	689	java/lang/SecurityException
    //   1300	1324	689	java/lang/SecurityException
    //   606	618	717	finally
    //   621	628	717	finally
    //   643	653	717	finally
    //   656	689	717	finally
    //   694	717	717	finally
    //   968	992	717	finally
    //   997	1004	717	finally
    //   1007	1039	717	finally
    //   1044	1068	717	finally
    //   1079	1092	717	finally
    //   1095	1118	717	finally
    //   1121	1159	717	finally
    //   1300	1324	717	finally
    //   414	422	747	java/lang/RuntimeException
    //   424	476	747	java/lang/RuntimeException
    //   479	555	747	java/lang/RuntimeException
    //   558	573	747	java/lang/RuntimeException
    //   573	597	747	java/lang/RuntimeException
    //   730	736	747	java/lang/RuntimeException
    //   740	745	747	java/lang/RuntimeException
    //   745	747	747	java/lang/RuntimeException
    //   922	944	747	java/lang/RuntimeException
    //   954	963	747	java/lang/RuntimeException
    //   1448	1454	747	java/lang/RuntimeException
    //   1458	1463	747	java/lang/RuntimeException
    //   326	331	908	java/lang/Exception
    //   573	597	921	java/lang/SecurityException
    //   414	422	944	finally
    //   424	476	944	finally
    //   479	555	944	finally
    //   558	573	944	finally
    //   573	597	944	finally
    //   730	736	944	finally
    //   740	745	944	finally
    //   745	747	944	finally
    //   922	944	944	finally
    //   954	963	944	finally
    //   1448	1454	944	finally
    //   1458	1463	944	finally
    //   573	597	953	java/net/MalformedURLException
    //   606	618	963	java/lang/ClassNotFoundException
    //   606	618	992	java/lang/ExceptionInInitializerError
    //   606	618	1039	java/lang/Throwable
    //   1159	1190	1283	java/lang/SecurityException
    //   1190	1194	1283	java/lang/SecurityException
    //   1194	1228	1283	java/lang/SecurityException
    //   1228	1234	1283	java/lang/SecurityException
    //   1238	1283	1283	java/lang/SecurityException
    //   1324	1369	1283	java/lang/SecurityException
    //   1369	1390	1283	java/lang/SecurityException
    //   1390	1413	1283	java/lang/SecurityException
    //   1413	1443	1283	java/lang/SecurityException
    //   1079	1092	1295	java/lang/Throwable
    //   1458	1463	1479	java/lang/Throwable
    //   1190	1194	1603	java/lang/InterruptedException
    //   740	745	1607	java/lang/Throwable
    //   341	362	1613	finally
    //   362	409	1613	finally
    //   341	362	1617	java/lang/RuntimeException
    //   362	409	1617	java/lang/RuntimeException
    //   1159	1190	1627	finally
    //   1190	1194	1627	finally
    //   1194	1228	1627	finally
    //   1228	1234	1627	finally
    //   1238	1283	1627	finally
    //   1324	1369	1627	finally
    //   1369	1390	1627	finally
    //   1390	1413	1627	finally
    //   1413	1443	1627	finally
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 540	com/vladium/emma/rt/AppRunner:validateState	()V
    //   6: iconst_0
    //   7: invokestatic 545	com/vladium/emma/rt/RTSettings:setStandaloneMode	(Z)V
    //   10: iconst_1
    //   11: iconst_0
    //   12: invokestatic 434	com/vladium/emma/rt/RT:reset	(ZZ)Lcom/vladium/emma/data/ICoverageData;
    //   15: pop
    //   16: invokestatic 549	com/vladium/emma/rt/RT:getAppProperties	()Lcom/vladium/util/IProperties;
    //   19: astore_2
    //   20: aload_2
    //   21: astore_1
    //   22: aload_2
    //   23: ifnonnull +7 -> 30
    //   26: invokestatic 550	com/vladium/emma/EMMAProperties:getAppProperties	()Lcom/vladium/util/IProperties;
    //   29: astore_1
    //   30: aload_0
    //   31: getfield 554	com/vladium/emma/rt/AppRunner:m_propertyOverrides	Lcom/vladium/util/IProperties;
    //   34: aload_1
    //   35: invokestatic 560	com/vladium/util/IProperties$Factory:combine	(Lcom/vladium/util/IProperties;Lcom/vladium/util/IProperties;)Lcom/vladium/util/IProperties;
    //   38: astore_1
    //   39: invokestatic 564	com/vladium/logging/Logger:getLogger	()Lcom/vladium/logging/Logger;
    //   42: astore_2
    //   43: aload_0
    //   44: getfield 567	com/vladium/emma/rt/AppRunner:m_appName	Ljava/lang/String;
    //   47: aload_1
    //   48: aload_2
    //   49: invokestatic 572	com/vladium/emma/AppLoggers:create	(Ljava/lang/String;Lcom/vladium/util/IProperties;Lcom/vladium/logging/Logger;)Lcom/vladium/logging/Logger;
    //   52: astore_2
    //   53: aload_2
    //   54: invokevirtual 368	com/vladium/logging/Logger:atTRACE1	()Z
    //   57: ifeq +23 -> 80
    //   60: aload_2
    //   61: ldc_w 369
    //   64: ldc_w 574
    //   67: invokevirtual 383	com/vladium/logging/Logger:trace1	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_1
    //   71: aload_2
    //   72: invokevirtual 509	com/vladium/logging/Logger:getWriter	()Ljava/io/PrintWriter;
    //   75: invokeinterface 577 2 0
    //   80: aload_2
    //   81: invokestatic 581	com/vladium/logging/Logger:push	(Lcom/vladium/logging/Logger;)V
    //   84: aload_0
    //   85: aload_2
    //   86: putfield 219	com/vladium/emma/rt/AppRunner:m_log	Lcom/vladium/logging/Logger;
    //   89: aload_0
    //   90: aload_1
    //   91: invokevirtual 583	com/vladium/emma/rt/AppRunner:_run	(Lcom/vladium/util/IProperties;)V
    //   94: aload_0
    //   95: getfield 219	com/vladium/emma/rt/AppRunner:m_log	Lcom/vladium/logging/Logger;
    //   98: ifnull +15 -> 113
    //   101: aload_0
    //   102: getfield 219	com/vladium/emma/rt/AppRunner:m_log	Lcom/vladium/logging/Logger;
    //   105: invokestatic 586	com/vladium/logging/Logger:pop	(Lcom/vladium/logging/Logger;)V
    //   108: aload_0
    //   109: aconst_null
    //   110: putfield 219	com/vladium/emma/rt/AppRunner:m_log	Lcom/vladium/logging/Logger;
    //   113: aload_0
    //   114: monitorexit
    //   115: return
    //   116: astore_1
    //   117: aload_0
    //   118: getfield 219	com/vladium/emma/rt/AppRunner:m_log	Lcom/vladium/logging/Logger;
    //   121: ifnull +15 -> 136
    //   124: aload_0
    //   125: getfield 219	com/vladium/emma/rt/AppRunner:m_log	Lcom/vladium/logging/Logger;
    //   128: invokestatic 586	com/vladium/logging/Logger:pop	(Lcom/vladium/logging/Logger;)V
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 219	com/vladium/emma/rt/AppRunner:m_log	Lcom/vladium/logging/Logger;
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	AppRunner
    //   21	70	1	localObject1	Object
    //   116	21	1	localObject2	Object
    //   138	4	1	localObject3	Object
    //   19	67	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   80	94	116	finally
    //   2	20	138	finally
    //   26	30	138	finally
    //   30	80	138	finally
    //   94	113	138	finally
    //   117	136	138	finally
    //   136	138	138	finally
  }
  
  public void setAppClass(String paramString, String[] paramArrayOfString)
  {
    if (paramString != null) {}
    int i;
    label115:
    try
    {
      if (paramString.length() == 0) {
        throw new IllegalArgumentException("null/empty input: className");
      }
    }
    finally
    {
      throw paramString;
      if (paramArrayOfString != null)
      {
        paramArrayOfString = (String[])paramArrayOfString.clone();
        i = 0;
        if (i < paramArrayOfString.length)
        {
          if (paramArrayOfString[i] != null) {
            break label115;
          }
          throw new IllegalArgumentException("null input: args[" + i + "]");
        }
      }
      for (this.m_appArgs = paramArrayOfString;; this.m_appArgs = IConstants.EMPTY_STRING_ARRAY)
      {
        this.m_appClassName = paramString;
        return;
      }
    }
  }
  
  /* Error */
  public void setCoveragePath(String[] paramArrayOfString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +8 -> 11
    //   6: aload_1
    //   7: arraylength
    //   8: ifne +18 -> 26
    //   11: aload_0
    //   12: getstatic 116	com/vladium/util/IConstants:EMPTY_FILE_ARRAY	[Ljava/io/File;
    //   15: putfield 118	com/vladium/emma/rt/AppRunner:m_coveragePath	[Ljava/io/File;
    //   18: aload_0
    //   19: iload_2
    //   20: putfield 357	com/vladium/emma/rt/AppRunner:m_canonical	Z
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: aload_1
    //   28: iload_2
    //   29: invokestatic 609	com/vladium/util/Files:pathToFiles	([Ljava/lang/String;Z)[Ljava/io/File;
    //   32: putfield 118	com/vladium/emma/rt/AppRunner:m_coveragePath	[Ljava/io/File;
    //   35: goto -17 -> 18
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	AppRunner
    //   0	43	1	paramArrayOfString	String[]
    //   0	43	2	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   6	11	38	finally
    //   11	18	38	finally
    //   18	23	38	finally
    //   26	35	38	finally
  }
  
  public void setDumpSessionData(boolean paramBoolean)
  {
    try
    {
      this.m_dumpSessionData = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void setInclExclFilter(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      try
      {
        this.m_coverageFilter = null;
        return;
      }
      finally {}
      this.m_coverageFilter = IInclExclFilter.Factory.create(paramArrayOfString);
    }
  }
  
  public void setReportTypes(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      try
      {
        throw new IllegalArgumentException("null input: types");
      }
      finally {}
    }
    paramArrayOfString = Strings.removeDuplicates(paramArrayOfString, true);
    if (paramArrayOfString.length == 0) {
      throw new IllegalArgumentException("empty input: types");
    }
    IReportGenerator[] arrayOfIReportGenerator = new IReportGenerator[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfIReportGenerator[i] = AbstractReportGenerator.create(paramArrayOfString[i]);
      i += 1;
    }
    this.m_reportGenerators = arrayOfIReportGenerator;
  }
  
  public void setScanCoveragePath(boolean paramBoolean)
  {
    try
    {
      this.m_scanCoveragePath = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void setSessionOutFile(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      try
      {
        this.m_sdataOutFile = null;
        return;
      }
      finally {}
      paramString = new File(paramString);
      if ((paramString.exists()) && (!paramString.isFile())) {
        throw new IllegalArgumentException("not a file: [" + paramString.getAbsolutePath() + "]");
      }
      this.m_sdataOutFile = paramString;
    }
  }
  
  public final void setSessionOutMerge(Boolean paramBoolean)
  {
    try
    {
      this.m_sdataOutMerge = paramBoolean;
      return;
    }
    finally
    {
      paramBoolean = finally;
      throw paramBoolean;
    }
  }
  
  public void setSourcePath(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      try
      {
        this.m_sourcePath = null;
        return;
      }
      finally {}
      this.m_sourcePath = Files.pathToFiles(paramArrayOfString, true);
    }
  }
  
  protected void validateState()
  {
    super.validateState();
    if ((this.m_appClassName == null) || (this.m_appClassName.length() == 0)) {
      throw new IllegalStateException("application class name not set");
    }
    if (this.m_appArgs == null) {
      throw new IllegalStateException("application arguments not set");
    }
    if (this.m_coveragePath == null) {
      throw new IllegalStateException("coverage path not set");
    }
    if ((this.m_reportGenerators == null) || (this.m_reportGenerators.length == 0)) {
      throw new IllegalStateException("report types not set");
    }
  }
  
  private static final class AppRunnerExitHook
    implements Runnable
  {
    private SourcePathCache m_cache;
    private ICoverageData m_cdata;
    private Throwable m_dataDumpFailure;
    private boolean m_done;
    private final boolean m_dumpRawData;
    private IReportGenerator[] m_generators;
    private final Logger m_log;
    private IMetaData m_mdata;
    private IProperties m_properties;
    private List m_reportFailures;
    private final File m_sdataOutFile;
    private final boolean m_sdataOutMerge;
    
    AppRunnerExitHook(Logger paramLogger, boolean paramBoolean1, File paramFile, boolean paramBoolean2, IMetaData paramIMetaData, ICoverageData paramICoverageData, IReportGenerator[] paramArrayOfIReportGenerator, SourcePathCache paramSourcePathCache, IProperties paramIProperties)
    {
      if (paramLogger == null) {
        throw new IllegalArgumentException("null input: log");
      }
      if ((paramArrayOfIReportGenerator == null) || (paramArrayOfIReportGenerator.length == 0)) {
        throw new IllegalArgumentException("null/empty input: generators");
      }
      if (paramIMetaData == null) {
        throw new IllegalArgumentException("null input: mdata");
      }
      if (paramICoverageData == null) {
        throw new IllegalArgumentException("null input: cdata");
      }
      if (paramIProperties == null) {
        throw new IllegalArgumentException("null input: properties");
      }
      this.m_log = paramLogger;
      this.m_dumpRawData = paramBoolean1;
      this.m_sdataOutFile = paramFile;
      this.m_sdataOutMerge = paramBoolean2;
      this.m_generators = ((IReportGenerator[])paramArrayOfIReportGenerator.clone());
      this.m_mdata = paramIMetaData;
      this.m_cdata = paramICoverageData;
      this.m_cache = paramSourcePathCache;
      this.m_properties = paramIProperties;
    }
    
    Throwable getDataDumpFailure()
    {
      try
      {
        Throwable localThrowable = this.m_dataDumpFailure;
        return localThrowable;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    List getReportFailures()
    {
      try
      {
        List localList = this.m_reportFailures;
        return localList;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 88	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_done	Z
      //   6: ifne +450 -> 456
      //   9: aload_0
      //   10: getfield 68	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_mdata	Lcom/vladium/emma/data/IMetaData;
      //   13: invokeinterface 94 1 0
      //   18: astore 8
      //   20: aload_0
      //   21: aconst_null
      //   22: putfield 68	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_mdata	Lcom/vladium/emma/data/IMetaData;
      //   25: aload_0
      //   26: getfield 70	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_cdata	Lcom/vladium/emma/data/ICoverageData;
      //   29: invokeinterface 99 1 0
      //   34: astore 9
      //   36: aload_0
      //   37: aconst_null
      //   38: putfield 70	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_cdata	Lcom/vladium/emma/data/ICoverageData;
      //   41: aload 8
      //   43: invokeinterface 103 1 0
      //   48: ifeq +45 -> 93
      //   51: aload_0
      //   52: getfield 53	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_log	Lcom/vladium/logging/Logger;
      //   55: ldc 105
      //   57: invokevirtual 110	com/vladium/logging/Logger:warning	(Ljava/lang/String;)V
      //   60: aload_0
      //   61: aconst_null
      //   62: putfield 66	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_generators	[Lcom/vladium/emma/report/IReportGenerator;
      //   65: aload_0
      //   66: aconst_null
      //   67: putfield 68	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_mdata	Lcom/vladium/emma/data/IMetaData;
      //   70: aload_0
      //   71: aconst_null
      //   72: putfield 70	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_cdata	Lcom/vladium/emma/data/ICoverageData;
      //   75: aload_0
      //   76: aconst_null
      //   77: putfield 74	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_properties	Lcom/vladium/util/IProperties;
      //   80: aload_0
      //   81: aconst_null
      //   82: putfield 72	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_cache	Lcom/vladium/emma/report/SourcePathCache;
      //   85: aload_0
      //   86: iconst_1
      //   87: putfield 88	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_done	Z
      //   90: aload_0
      //   91: monitorexit
      //   92: return
      //   93: aload 9
      //   95: invokeinterface 111 1 0
      //   100: ifeq +12 -> 112
      //   103: aload_0
      //   104: getfield 53	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_log	Lcom/vladium/logging/Logger;
      //   107: ldc 113
      //   109: invokevirtual 110	com/vladium/logging/Logger:warning	(Ljava/lang/String;)V
      //   112: new 115	com/vladium/emma/data/SessionData
      //   115: dup
      //   116: aload 8
      //   118: aload 9
      //   120: invokespecial 118	com/vladium/emma/data/SessionData:<init>	(Lcom/vladium/emma/data/IMetaData;Lcom/vladium/emma/data/ICoverageData;)V
      //   123: astore 7
      //   125: aload_0
      //   126: getfield 55	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_dumpRawData	Z
      //   129: ifeq +130 -> 259
      //   132: aload_0
      //   133: getfield 57	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_sdataOutFile	Ljava/io/File;
      //   136: astore 10
      //   138: aload 10
      //   140: ifnull +119 -> 259
      //   143: aload_0
      //   144: getfield 53	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_log	Lcom/vladium/logging/Logger;
      //   147: invokevirtual 121	com/vladium/logging/Logger:atINFO	()Z
      //   150: istore_2
      //   151: iload_2
      //   152: ifeq +171 -> 323
      //   155: invokestatic 127	java/lang/System:currentTimeMillis	()J
      //   158: lstore_3
      //   159: aload 7
      //   161: aload_0
      //   162: getfield 57	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_sdataOutFile	Ljava/io/File;
      //   165: aload_0
      //   166: getfield 59	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_sdataOutMerge	Z
      //   169: invokestatic 133	com/vladium/emma/data/DataFactory:persist	(Lcom/vladium/emma/data/ISessionData;Ljava/io/File;Z)V
      //   172: iload_2
      //   173: ifeq +86 -> 259
      //   176: invokestatic 127	java/lang/System:currentTimeMillis	()J
      //   179: lstore 5
      //   181: aload_0
      //   182: getfield 53	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_log	Lcom/vladium/logging/Logger;
      //   185: astore 10
      //   187: new 135	java/lang/StringBuilder
      //   190: dup
      //   191: invokespecial 136	java/lang/StringBuilder:<init>	()V
      //   194: ldc -118
      //   196: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   199: astore 11
      //   201: aload_0
      //   202: getfield 59	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_sdataOutMerge	Z
      //   205: ifeq +123 -> 328
      //   208: ldc -112
      //   210: astore 7
      //   212: aload 10
      //   214: aload 11
      //   216: aload 7
      //   218: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   221: ldc -110
      //   223: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   226: aload_0
      //   227: getfield 57	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_sdataOutFile	Ljava/io/File;
      //   230: invokevirtual 152	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   233: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   236: ldc -102
      //   238: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   241: lload 5
      //   243: lload_3
      //   244: lsub
      //   245: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   248: ldc -97
      //   250: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   253: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   256: invokevirtual 165	com/vladium/logging/Logger:info	(Ljava/lang/String;)V
      //   259: iconst_0
      //   260: istore_1
      //   261: iload_1
      //   262: aload_0
      //   263: getfield 66	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_generators	[Lcom/vladium/emma/report/IReportGenerator;
      //   266: arraylength
      //   267: if_icmpge +189 -> 456
      //   270: aload_0
      //   271: getfield 66	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_generators	[Lcom/vladium/emma/report/IReportGenerator;
      //   274: iload_1
      //   275: aaload
      //   276: astore 7
      //   278: aload 7
      //   280: ifnull +36 -> 316
      //   283: aload 7
      //   285: aload 8
      //   287: aload 9
      //   289: aload_0
      //   290: getfield 72	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_cache	Lcom/vladium/emma/report/SourcePathCache;
      //   293: aload_0
      //   294: getfield 74	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_properties	Lcom/vladium/util/IProperties;
      //   297: invokeinterface 171 5 0
      //   302: aload 7
      //   304: invokeinterface 174 1 0
      //   309: aload_0
      //   310: getfield 66	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_generators	[Lcom/vladium/emma/report/IReportGenerator;
      //   313: iload_1
      //   314: aconst_null
      //   315: aastore
      //   316: iload_1
      //   317: iconst_1
      //   318: iadd
      //   319: istore_1
      //   320: goto -59 -> 261
      //   323: lconst_0
      //   324: lstore_3
      //   325: goto -166 -> 159
      //   328: ldc -80
      //   330: astore 7
      //   332: goto -120 -> 212
      //   335: astore 7
      //   337: aload_0
      //   338: aload 7
      //   340: putfield 79	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_dataDumpFailure	Ljava/lang/Throwable;
      //   343: goto -84 -> 259
      //   346: astore 7
      //   348: aload_0
      //   349: aconst_null
      //   350: putfield 66	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_generators	[Lcom/vladium/emma/report/IReportGenerator;
      //   353: aload_0
      //   354: aconst_null
      //   355: putfield 68	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_mdata	Lcom/vladium/emma/data/IMetaData;
      //   358: aload_0
      //   359: aconst_null
      //   360: putfield 70	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_cdata	Lcom/vladium/emma/data/ICoverageData;
      //   363: aload_0
      //   364: aconst_null
      //   365: putfield 74	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_properties	Lcom/vladium/util/IProperties;
      //   368: aload_0
      //   369: aconst_null
      //   370: putfield 72	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_cache	Lcom/vladium/emma/report/SourcePathCache;
      //   373: aload_0
      //   374: iconst_1
      //   375: putfield 88	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_done	Z
      //   378: aload 7
      //   380: athrow
      //   381: astore 7
      //   383: aload_0
      //   384: monitorexit
      //   385: aload 7
      //   387: athrow
      //   388: astore 10
      //   390: aload_0
      //   391: getfield 83	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_reportFailures	Ljava/util/List;
      //   394: ifnonnull +14 -> 408
      //   397: aload_0
      //   398: new 178	java/util/ArrayList
      //   401: dup
      //   402: invokespecial 179	java/util/ArrayList:<init>	()V
      //   405: putfield 83	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_reportFailures	Ljava/util/List;
      //   408: aload_0
      //   409: getfield 83	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_reportFailures	Ljava/util/List;
      //   412: aload 10
      //   414: invokeinterface 185 2 0
      //   419: pop
      //   420: aload 7
      //   422: invokeinterface 174 1 0
      //   427: aload_0
      //   428: getfield 66	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_generators	[Lcom/vladium/emma/report/IReportGenerator;
      //   431: iload_1
      //   432: aconst_null
      //   433: aastore
      //   434: goto -118 -> 316
      //   437: astore 8
      //   439: aload 7
      //   441: invokeinterface 174 1 0
      //   446: aload_0
      //   447: getfield 66	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_generators	[Lcom/vladium/emma/report/IReportGenerator;
      //   450: iload_1
      //   451: aconst_null
      //   452: aastore
      //   453: aload 8
      //   455: athrow
      //   456: aload_0
      //   457: aconst_null
      //   458: putfield 66	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_generators	[Lcom/vladium/emma/report/IReportGenerator;
      //   461: aload_0
      //   462: aconst_null
      //   463: putfield 68	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_mdata	Lcom/vladium/emma/data/IMetaData;
      //   466: aload_0
      //   467: aconst_null
      //   468: putfield 70	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_cdata	Lcom/vladium/emma/data/ICoverageData;
      //   471: aload_0
      //   472: aconst_null
      //   473: putfield 74	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_properties	Lcom/vladium/util/IProperties;
      //   476: aload_0
      //   477: aconst_null
      //   478: putfield 72	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_cache	Lcom/vladium/emma/report/SourcePathCache;
      //   481: aload_0
      //   482: iconst_1
      //   483: putfield 88	com/vladium/emma/rt/AppRunner$AppRunnerExitHook:m_done	Z
      //   486: goto -396 -> 90
      //   489: astore 7
      //   491: goto -182 -> 309
      //   494: astore 7
      //   496: goto -69 -> 427
      //   499: astore 7
      //   501: goto -55 -> 446
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	504	0	this	AppRunnerExitHook
      //   260	191	1	i	int
      //   150	23	2	bool	boolean
      //   158	167	3	l1	long
      //   179	63	5	l2	long
      //   123	208	7	localObject1	Object
      //   335	4	7	localThrowable1	Throwable
      //   346	33	7	localObject2	Object
      //   381	59	7	localObject3	Object
      //   489	1	7	localThrowable2	Throwable
      //   494	1	7	localThrowable3	Throwable
      //   499	1	7	localThrowable4	Throwable
      //   18	268	8	localIMetaData	IMetaData
      //   437	17	8	localObject4	Object
      //   34	254	9	localICoverageData	ICoverageData
      //   136	77	10	localObject5	Object
      //   388	25	10	localThrowable5	Throwable
      //   199	16	11	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   143	151	335	java/lang/Throwable
      //   155	159	335	java/lang/Throwable
      //   159	172	335	java/lang/Throwable
      //   176	208	335	java/lang/Throwable
      //   212	259	335	java/lang/Throwable
      //   2	60	346	finally
      //   93	112	346	finally
      //   112	138	346	finally
      //   143	151	346	finally
      //   155	159	346	finally
      //   159	172	346	finally
      //   176	208	346	finally
      //   212	259	346	finally
      //   261	278	346	finally
      //   302	309	346	finally
      //   309	316	346	finally
      //   337	343	346	finally
      //   420	427	346	finally
      //   427	434	346	finally
      //   439	446	346	finally
      //   446	456	346	finally
      //   60	90	381	finally
      //   348	381	381	finally
      //   456	486	381	finally
      //   283	302	388	java/lang/Throwable
      //   283	302	437	finally
      //   390	408	437	finally
      //   408	420	437	finally
      //   302	309	489	java/lang/Throwable
      //   420	427	494	java/lang/Throwable
      //   439	446	499	java/lang/Throwable
    }
  }
  
  private static final class Invoker
    implements Runnable
  {
    private final Object[] m_args;
    private Throwable m_failure;
    private final Method m_method;
    private final Object m_target;
    
    Invoker(Method paramMethod, Object paramObject, Object[] paramArrayOfObject)
    {
      if (paramMethod == null) {
        throw new IllegalArgumentException("null input: method");
      }
      if (paramArrayOfObject == null) {
        throw new IllegalArgumentException("null input: args");
      }
      this.m_method = paramMethod;
      this.m_target = paramObject;
      this.m_args = paramArrayOfObject;
    }
    
    Throwable getFailure()
    {
      return this.m_failure;
    }
    
    public void run()
    {
      try
      {
        this.m_method.invoke(this.m_target, this.m_args);
        return;
      }
      catch (Throwable localThrowable)
      {
        this.m_failure = localThrowable;
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/rt/AppRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */