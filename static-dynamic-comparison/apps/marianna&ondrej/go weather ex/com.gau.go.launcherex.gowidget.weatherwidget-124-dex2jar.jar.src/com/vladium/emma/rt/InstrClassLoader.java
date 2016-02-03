package com.vladium.emma.rt;

import com.vladium.emma.filter.IInclExclFilter;
import com.vladium.logging.Logger;
import com.vladium.util.ByteArrayOStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;
import java.security.cert.Certificate;
import java.util.Map;

public final class InstrClassLoader
  extends URLClassLoader
{
  private static final int BAOS_INIT_SIZE = 32768;
  private static final int BAOS_MAX_SIZE = 1048576;
  private static final int BAOS_POOL_SIZE = 8;
  private static final URL[] EMPTY_URL_ARRAY = new URL[0];
  public static final String PROPERTY_FORCED_DELEGATION_FILTER = "clsload.forced_delegation_filter";
  public static final String PROPERTY_THROUGH_DELEGATION_FILTER = "clsload.through_delegation_filter";
  private final PoolEntry[] m_bufPool;
  private final Map m_cache;
  private int m_cacheHits;
  private int m_cacheMisses;
  private final IInclExclFilter m_forcedDelegationFilter;
  private final IClassLoadHook m_hook;
  private final Logger m_log;
  private int m_nestLevel;
  private final ClassLoader m_parent;
  private final IInclExclFilter m_throughDelegationFilter;
  
  public InstrClassLoader(ClassLoader paramClassLoader, File[] paramArrayOfFile, IInclExclFilter paramIInclExclFilter1, IInclExclFilter paramIInclExclFilter2, IClassLoadHook paramIClassLoadHook, Map paramMap)
    throws MalformedURLException
  {
    super(filesToURLs(paramArrayOfFile), null);
    this.m_hook = paramIClassLoadHook;
    this.m_cache = paramMap;
    this.m_forcedDelegationFilter = paramIInclExclFilter1;
    this.m_throughDelegationFilter = paramIInclExclFilter2;
    this.m_parent = paramClassLoader;
    this.m_bufPool = new PoolEntry[8];
    this.m_log = Logger.getLogger();
  }
  
  private PoolEntry acquirePoolEntry()
  {
    PoolEntry localPoolEntry;
    if (this.m_nestLevel >= 8) {
      localPoolEntry = new PoolEntry(32768, 32768);
    }
    for (;;)
    {
      this.m_nestLevel += 1;
      return localPoolEntry;
      localPoolEntry = this.m_bufPool[this.m_nestLevel];
      if (localPoolEntry == null)
      {
        localPoolEntry = new PoolEntry(32768, 32768);
        this.m_bufPool[this.m_nestLevel] = localPoolEntry;
      }
      else
      {
        localPoolEntry.m_baos.reset();
      }
    }
  }
  
  private Class defineClass(String paramString, byte[] paramArrayOfByte, int paramInt, URL paramURL)
  {
    CodeSource localCodeSource = new CodeSource(paramURL, (Certificate[])null);
    int i = paramString.lastIndexOf('.');
    if (i >= 0)
    {
      String str = paramString.substring(0, i);
      if (getPackage(str) == null) {
        definePackage(str, "EMMA", "0.0", "(C) Vladimir Roubtsov", "EMMA", "0.0", "(C) Vladimir Roubtsov", paramURL);
      }
    }
    return defineClass(paramString, paramArrayOfByte, 0, paramInt, localCodeSource);
  }
  
  private static URL[] filesToURLs(File[] paramArrayOfFile)
    throws MalformedURLException
  {
    Object localObject;
    if ((paramArrayOfFile == null) || (paramArrayOfFile.length == 0))
    {
      localObject = EMPTY_URL_ARRAY;
      return (URL[])localObject;
    }
    URL[] arrayOfURL = new URL[paramArrayOfFile.length];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfURL;
      if (i >= arrayOfURL.length) {
        break;
      }
      arrayOfURL[i] = paramArrayOfFile[i].toURL();
      i += 1;
    }
  }
  
  private static void readFully(InputStream paramInputStream, ByteArrayOStream paramByteArrayOStream, byte[] paramArrayOfByte)
    throws IOException
  {
    for (;;)
    {
      int i = paramInputStream.read(paramArrayOfByte);
      if (i < 0) {
        break;
      }
      paramByteArrayOStream.write(paramArrayOfByte, 0, i);
    }
  }
  
  private void releasePoolEntry(PoolEntry paramPoolEntry)
  {
    int i = this.m_nestLevel - 1;
    this.m_nestLevel = i;
    if (i < 8) {
      paramPoolEntry.trim(32768, 1048576);
    }
  }
  
  public void debugDump(PrintWriter paramPrintWriter)
  {
    if (paramPrintWriter != null) {
      paramPrintWriter.println(this + ": " + this.m_cacheHits + " class cache hits, " + this.m_cacheMisses + " misses");
    }
  }
  
  /* Error */
  protected final Class findClass(String paramString)
    throws ClassNotFoundException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 77	com/vladium/emma/rt/InstrClassLoader:m_log	Lcom/vladium/logging/Logger;
    //   4: invokevirtual 201	com/vladium/logging/Logger:atTRACE1	()Z
    //   7: istore 4
    //   9: iload 4
    //   11: ifeq +43 -> 54
    //   14: aload_0
    //   15: getfield 77	com/vladium/emma/rt/InstrClassLoader:m_log	Lcom/vladium/logging/Logger;
    //   18: ldc -54
    //   20: new 159	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   27: ldc -52
    //   29: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc -50
    //   38: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: getfield 82	com/vladium/emma/rt/InstrClassLoader:m_nestLevel	I
    //   45: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokevirtual 210	com/vladium/logging/Logger:trace1	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 61	com/vladium/emma/rt/InstrClassLoader:m_cache	Ljava/util/Map;
    //   58: ifnull +294 -> 352
    //   61: iconst_1
    //   62: istore_2
    //   63: iload_2
    //   64: ifeq +293 -> 357
    //   67: aload_0
    //   68: getfield 61	com/vladium/emma/rt/InstrClassLoader:m_cache	Ljava/util/Map;
    //   71: aload_1
    //   72: invokeinterface 216 2 0
    //   77: checkcast 218	com/vladium/emma/rt/ClassPathCacheEntry
    //   80: astore 8
    //   82: aconst_null
    //   83: astore 9
    //   85: aload 8
    //   87: ifnull +375 -> 462
    //   90: aload_0
    //   91: aload_0
    //   92: getfield 172	com/vladium/emma/rt/InstrClassLoader:m_cacheHits	I
    //   95: iconst_1
    //   96: iadd
    //   97: putfield 172	com/vladium/emma/rt/InstrClassLoader:m_cacheHits	I
    //   100: new 43	java/net/URL
    //   103: dup
    //   104: aload 8
    //   106: getfield 221	com/vladium/emma/rt/ClassPathCacheEntry:m_srcURL	Ljava/lang/String;
    //   109: invokespecial 223	java/net/URL:<init>	(Ljava/lang/String;)V
    //   112: astore 5
    //   114: aload 5
    //   116: astore 9
    //   118: aconst_null
    //   119: astore 6
    //   121: aconst_null
    //   122: astore 5
    //   124: aload_0
    //   125: invokespecial 225	com/vladium/emma/rt/InstrClassLoader:acquirePoolEntry	()Lcom/vladium/emma/rt/InstrClassLoader$PoolEntry;
    //   128: astore 7
    //   130: aload 7
    //   132: astore 5
    //   134: aload 7
    //   136: astore 6
    //   138: aload 7
    //   140: getfield 89	com/vladium/emma/rt/InstrClassLoader$PoolEntry:m_baos	Lcom/vladium/util/ByteArrayOStream;
    //   143: astore 11
    //   145: aload 7
    //   147: astore 5
    //   149: aload 7
    //   151: astore 6
    //   153: aload 8
    //   155: getfield 229	com/vladium/emma/rt/ClassPathCacheEntry:m_bytes	[B
    //   158: astore 10
    //   160: aload 7
    //   162: astore 5
    //   164: aload 7
    //   166: astore 6
    //   168: aload 10
    //   170: arraylength
    //   171: istore_3
    //   172: aload 7
    //   174: astore 5
    //   176: aload 7
    //   178: astore 6
    //   180: aload_0
    //   181: getfield 59	com/vladium/emma/rt/InstrClassLoader:m_hook	Lcom/vladium/emma/rt/IClassLoadHook;
    //   184: ifnull +179 -> 363
    //   187: aload 7
    //   189: astore 5
    //   191: aload 7
    //   193: astore 6
    //   195: aload_0
    //   196: getfield 59	com/vladium/emma/rt/InstrClassLoader:m_hook	Lcom/vladium/emma/rt/IClassLoadHook;
    //   199: aload_1
    //   200: aload 10
    //   202: iload_3
    //   203: aload 11
    //   205: invokeinterface 235 5 0
    //   210: ifeq +153 -> 363
    //   213: aload 7
    //   215: astore 5
    //   217: aload 7
    //   219: astore 6
    //   221: aload 11
    //   223: invokevirtual 239	com/vladium/util/ByteArrayOStream:getByteArray	()[B
    //   226: astore 10
    //   228: aload 7
    //   230: astore 5
    //   232: aload 7
    //   234: astore 6
    //   236: aload 11
    //   238: invokevirtual 243	com/vladium/util/ByteArrayOStream:size	()I
    //   241: istore_3
    //   242: aload 10
    //   244: astore 8
    //   246: iload_3
    //   247: istore_2
    //   248: iload 4
    //   250: ifeq +59 -> 309
    //   253: aload 7
    //   255: astore 5
    //   257: aload 7
    //   259: astore 6
    //   261: aload_0
    //   262: getfield 77	com/vladium/emma/rt/InstrClassLoader:m_log	Lcom/vladium/logging/Logger;
    //   265: ldc -54
    //   267: new 159	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   274: ldc -11
    //   276: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload_1
    //   280: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc -9
    //   285: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: iload_3
    //   289: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: ldc -7
    //   294: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokevirtual 210	com/vladium/logging/Logger:trace1	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: iload_3
    //   304: istore_2
    //   305: aload 10
    //   307: astore 8
    //   309: aload 7
    //   311: astore 5
    //   313: aload 7
    //   315: astore 6
    //   317: aload_0
    //   318: aload_1
    //   319: aload 8
    //   321: iload_2
    //   322: aload 9
    //   324: invokespecial 251	com/vladium/emma/rt/InstrClassLoader:defineClass	(Ljava/lang/String;[BILjava/net/URL;)Ljava/lang/Class;
    //   327: astore 8
    //   329: aload 8
    //   331: astore 5
    //   333: aload 5
    //   335: astore_1
    //   336: aload 7
    //   338: ifnull +12 -> 350
    //   341: aload_0
    //   342: aload 7
    //   344: invokespecial 253	com/vladium/emma/rt/InstrClassLoader:releasePoolEntry	(Lcom/vladium/emma/rt/InstrClassLoader$PoolEntry;)V
    //   347: aload 5
    //   349: astore_1
    //   350: aload_1
    //   351: areturn
    //   352: iconst_0
    //   353: istore_2
    //   354: goto -291 -> 63
    //   357: aconst_null
    //   358: astore 8
    //   360: goto -278 -> 82
    //   363: aload 10
    //   365: astore 8
    //   367: iload_3
    //   368: istore_2
    //   369: iload 4
    //   371: ifeq -62 -> 309
    //   374: aload 7
    //   376: astore 5
    //   378: aload 7
    //   380: astore 6
    //   382: aload_0
    //   383: getfield 77	com/vladium/emma/rt/InstrClassLoader:m_log	Lcom/vladium/logging/Logger;
    //   386: ldc -54
    //   388: new 159	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   395: ldc -1
    //   397: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_1
    //   401: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: ldc -9
    //   406: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: iload_3
    //   410: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   413: ldc -7
    //   415: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokevirtual 210	com/vladium/logging/Logger:trace1	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: aload 10
    //   426: astore 8
    //   428: iload_3
    //   429: istore_2
    //   430: goto -121 -> 309
    //   433: astore 6
    //   435: aload 5
    //   437: astore 6
    //   439: new 195	java/lang/ClassNotFoundException
    //   442: dup
    //   443: aload_1
    //   444: invokespecial 256	java/lang/ClassNotFoundException:<init>	(Ljava/lang/String;)V
    //   447: athrow
    //   448: astore_1
    //   449: aload 6
    //   451: ifnull +9 -> 460
    //   454: aload_0
    //   455: aload 6
    //   457: invokespecial 253	com/vladium/emma/rt/InstrClassLoader:releasePoolEntry	(Lcom/vladium/emma/rt/InstrClassLoader$PoolEntry;)V
    //   460: aload_1
    //   461: athrow
    //   462: iload_2
    //   463: ifeq +13 -> 476
    //   466: aload_0
    //   467: aload_0
    //   468: getfield 179	com/vladium/emma/rt/InstrClassLoader:m_cacheMisses	I
    //   471: iconst_1
    //   472: iadd
    //   473: putfield 179	com/vladium/emma/rt/InstrClassLoader:m_cacheMisses	I
    //   476: aload_0
    //   477: new 159	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   484: aload_1
    //   485: bipush 46
    //   487: bipush 47
    //   489: invokevirtual 260	java/lang/String:replace	(CC)Ljava/lang/String;
    //   492: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: ldc_w 262
    //   498: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokevirtual 266	com/vladium/emma/rt/InstrClassLoader:getResource	(Ljava/lang/String;)Ljava/net/URL;
    //   507: astore 14
    //   509: iload 4
    //   511: ifeq +48 -> 559
    //   514: aload 14
    //   516: ifnull +43 -> 559
    //   519: aload_0
    //   520: getfield 77	com/vladium/emma/rt/InstrClassLoader:m_log	Lcom/vladium/logging/Logger;
    //   523: ldc -54
    //   525: new 159	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 268
    //   535: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload_1
    //   539: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: ldc_w 270
    //   545: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: aload 14
    //   550: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   553: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokevirtual 210	com/vladium/logging/Logger:trace1	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: aload 14
    //   561: ifnonnull +12 -> 573
    //   564: new 195	java/lang/ClassNotFoundException
    //   567: dup
    //   568: aload_1
    //   569: invokespecial 256	java/lang/ClassNotFoundException:<init>	(Ljava/lang/String;)V
    //   572: athrow
    //   573: aconst_null
    //   574: astore 6
    //   576: aconst_null
    //   577: astore 5
    //   579: aconst_null
    //   580: astore 11
    //   582: aconst_null
    //   583: astore 9
    //   585: aload 9
    //   587: astore 7
    //   589: aload 11
    //   591: astore 8
    //   593: aload 14
    //   595: invokevirtual 274	java/net/URL:openStream	()Ljava/io/InputStream;
    //   598: astore 10
    //   600: aload 9
    //   602: astore 7
    //   604: aload 10
    //   606: astore 5
    //   608: aload 11
    //   610: astore 8
    //   612: aload 10
    //   614: astore 6
    //   616: aload_0
    //   617: invokespecial 225	com/vladium/emma/rt/InstrClassLoader:acquirePoolEntry	()Lcom/vladium/emma/rt/InstrClassLoader$PoolEntry;
    //   620: astore 9
    //   622: aload 9
    //   624: astore 7
    //   626: aload 10
    //   628: astore 5
    //   630: aload 9
    //   632: astore 8
    //   634: aload 10
    //   636: astore 6
    //   638: aload 9
    //   640: getfield 89	com/vladium/emma/rt/InstrClassLoader$PoolEntry:m_baos	Lcom/vladium/util/ByteArrayOStream;
    //   643: astore 15
    //   645: aload 9
    //   647: astore 7
    //   649: aload 10
    //   651: astore 5
    //   653: aload 9
    //   655: astore 8
    //   657: aload 10
    //   659: astore 6
    //   661: aload 10
    //   663: aload 15
    //   665: aload 9
    //   667: getfield 277	com/vladium/emma/rt/InstrClassLoader$PoolEntry:m_buf	[B
    //   670: invokestatic 279	com/vladium/emma/rt/InstrClassLoader:readFully	(Ljava/io/InputStream;Lcom/vladium/util/ByteArrayOStream;[B)V
    //   673: aload 9
    //   675: astore 7
    //   677: aload 10
    //   679: astore 5
    //   681: aload 9
    //   683: astore 8
    //   685: aload 10
    //   687: astore 6
    //   689: aload 10
    //   691: invokevirtual 282	java/io/InputStream:close	()V
    //   694: aconst_null
    //   695: astore 12
    //   697: aconst_null
    //   698: astore 11
    //   700: aload 9
    //   702: astore 7
    //   704: aload 11
    //   706: astore 5
    //   708: aload 9
    //   710: astore 8
    //   712: aload 12
    //   714: astore 6
    //   716: aload 15
    //   718: invokevirtual 239	com/vladium/util/ByteArrayOStream:getByteArray	()[B
    //   721: astore 13
    //   723: aload 9
    //   725: astore 7
    //   727: aload 11
    //   729: astore 5
    //   731: aload 9
    //   733: astore 8
    //   735: aload 12
    //   737: astore 6
    //   739: aload 15
    //   741: invokevirtual 243	com/vladium/util/ByteArrayOStream:size	()I
    //   744: istore_3
    //   745: aload 9
    //   747: astore 7
    //   749: aload 11
    //   751: astore 5
    //   753: aload 9
    //   755: astore 8
    //   757: aload 12
    //   759: astore 6
    //   761: aload 15
    //   763: invokevirtual 94	com/vladium/util/ByteArrayOStream:reset	()V
    //   766: aload 9
    //   768: astore 7
    //   770: aload 11
    //   772: astore 5
    //   774: aload 9
    //   776: astore 8
    //   778: aload 12
    //   780: astore 6
    //   782: aload_0
    //   783: getfield 59	com/vladium/emma/rt/InstrClassLoader:m_hook	Lcom/vladium/emma/rt/IClassLoadHook;
    //   786: ifnull +220 -> 1006
    //   789: aload 9
    //   791: astore 7
    //   793: aload 11
    //   795: astore 5
    //   797: aload 9
    //   799: astore 8
    //   801: aload 12
    //   803: astore 6
    //   805: aload_0
    //   806: getfield 59	com/vladium/emma/rt/InstrClassLoader:m_hook	Lcom/vladium/emma/rt/IClassLoadHook;
    //   809: aload_1
    //   810: aload 13
    //   812: iload_3
    //   813: aload 15
    //   815: invokeinterface 235 5 0
    //   820: ifeq +186 -> 1006
    //   823: aload 9
    //   825: astore 7
    //   827: aload 11
    //   829: astore 5
    //   831: aload 9
    //   833: astore 8
    //   835: aload 12
    //   837: astore 6
    //   839: aload 15
    //   841: invokevirtual 239	com/vladium/util/ByteArrayOStream:getByteArray	()[B
    //   844: astore 13
    //   846: aload 9
    //   848: astore 7
    //   850: aload 11
    //   852: astore 5
    //   854: aload 9
    //   856: astore 8
    //   858: aload 12
    //   860: astore 6
    //   862: aload 15
    //   864: invokevirtual 243	com/vladium/util/ByteArrayOStream:size	()I
    //   867: istore_3
    //   868: aload 13
    //   870: astore 10
    //   872: iload_3
    //   873: istore_2
    //   874: iload 4
    //   876: ifeq +68 -> 944
    //   879: aload 9
    //   881: astore 7
    //   883: aload 11
    //   885: astore 5
    //   887: aload 9
    //   889: astore 8
    //   891: aload 12
    //   893: astore 6
    //   895: aload_0
    //   896: getfield 77	com/vladium/emma/rt/InstrClassLoader:m_log	Lcom/vladium/logging/Logger;
    //   899: ldc -54
    //   901: new 159	java/lang/StringBuilder
    //   904: dup
    //   905: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   908: ldc_w 284
    //   911: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: aload_1
    //   915: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: ldc -9
    //   920: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: iload_3
    //   924: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   927: ldc -7
    //   929: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   935: invokevirtual 210	com/vladium/logging/Logger:trace1	(Ljava/lang/String;Ljava/lang/String;)V
    //   938: iload_3
    //   939: istore_2
    //   940: aload 13
    //   942: astore 10
    //   944: aload 9
    //   946: astore 7
    //   948: aload 11
    //   950: astore 5
    //   952: aload 9
    //   954: astore 8
    //   956: aload 12
    //   958: astore 6
    //   960: aload_0
    //   961: aload_1
    //   962: aload 10
    //   964: iload_2
    //   965: aload 14
    //   967: invokespecial 251	com/vladium/emma/rt/InstrClassLoader:defineClass	(Ljava/lang/String;[BILjava/net/URL;)Ljava/lang/Class;
    //   970: astore 10
    //   972: aload 10
    //   974: astore 5
    //   976: aload 9
    //   978: ifnull +9 -> 987
    //   981: aload_0
    //   982: aload 9
    //   984: invokespecial 253	com/vladium/emma/rt/InstrClassLoader:releasePoolEntry	(Lcom/vladium/emma/rt/InstrClassLoader$PoolEntry;)V
    //   987: aload 5
    //   989: astore_1
    //   990: iconst_0
    //   991: ifeq -641 -> 350
    //   994: new 286	java/lang/NullPointerException
    //   997: dup
    //   998: invokespecial 287	java/lang/NullPointerException:<init>	()V
    //   1001: athrow
    //   1002: astore_1
    //   1003: aload 5
    //   1005: areturn
    //   1006: aload 13
    //   1008: astore 10
    //   1010: iload_3
    //   1011: istore_2
    //   1012: iload 4
    //   1014: ifeq -70 -> 944
    //   1017: aload 9
    //   1019: astore 7
    //   1021: aload 11
    //   1023: astore 5
    //   1025: aload 9
    //   1027: astore 8
    //   1029: aload 12
    //   1031: astore 6
    //   1033: aload_0
    //   1034: getfield 77	com/vladium/emma/rt/InstrClassLoader:m_log	Lcom/vladium/logging/Logger;
    //   1037: ldc -54
    //   1039: new 159	java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   1046: ldc_w 289
    //   1049: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: aload_1
    //   1053: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: ldc -9
    //   1058: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: iload_3
    //   1062: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1065: ldc -7
    //   1067: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1073: invokevirtual 210	com/vladium/logging/Logger:trace1	(Ljava/lang/String;Ljava/lang/String;)V
    //   1076: aload 13
    //   1078: astore 10
    //   1080: iload_3
    //   1081: istore_2
    //   1082: goto -138 -> 944
    //   1085: astore 6
    //   1087: aload 7
    //   1089: astore 8
    //   1091: aload 5
    //   1093: astore 6
    //   1095: new 195	java/lang/ClassNotFoundException
    //   1098: dup
    //   1099: aload_1
    //   1100: invokespecial 256	java/lang/ClassNotFoundException:<init>	(Ljava/lang/String;)V
    //   1103: athrow
    //   1104: astore_1
    //   1105: aload 8
    //   1107: ifnull +9 -> 1116
    //   1110: aload_0
    //   1111: aload 8
    //   1113: invokespecial 253	com/vladium/emma/rt/InstrClassLoader:releasePoolEntry	(Lcom/vladium/emma/rt/InstrClassLoader$PoolEntry;)V
    //   1116: aload 6
    //   1118: ifnull +8 -> 1126
    //   1121: aload 6
    //   1123: invokevirtual 282	java/io/InputStream:close	()V
    //   1126: aload_1
    //   1127: athrow
    //   1128: astore 5
    //   1130: goto -4 -> 1126
    //   1133: astore 5
    //   1135: goto -1017 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1138	0	this	InstrClassLoader
    //   0	1138	1	paramString	String
    //   62	1020	2	i	int
    //   171	910	3	j	int
    //   7	1006	4	bool	boolean
    //   112	980	5	localObject1	Object
    //   1128	1	5	localException	Exception
    //   1133	1	5	localMalformedURLException	MalformedURLException
    //   119	262	6	localObject2	Object
    //   433	1	6	localIOException1	IOException
    //   437	595	6	localObject3	Object
    //   1085	1	6	localIOException2	IOException
    //   1093	29	6	localObject4	Object
    //   128	960	7	localObject5	Object
    //   80	1032	8	localObject6	Object
    //   83	943	9	localObject7	Object
    //   158	921	10	localObject8	Object
    //   143	879	11	localByteArrayOStream1	ByteArrayOStream
    //   695	335	12	localObject9	Object
    //   721	356	13	arrayOfByte	byte[]
    //   507	459	14	localURL	URL
    //   643	220	15	localByteArrayOStream2	ByteArrayOStream
    // Exception table:
    //   from	to	target	type
    //   124	130	433	java/io/IOException
    //   138	145	433	java/io/IOException
    //   153	160	433	java/io/IOException
    //   168	172	433	java/io/IOException
    //   180	187	433	java/io/IOException
    //   195	213	433	java/io/IOException
    //   221	228	433	java/io/IOException
    //   236	242	433	java/io/IOException
    //   261	303	433	java/io/IOException
    //   317	329	433	java/io/IOException
    //   382	424	433	java/io/IOException
    //   124	130	448	finally
    //   138	145	448	finally
    //   153	160	448	finally
    //   168	172	448	finally
    //   180	187	448	finally
    //   195	213	448	finally
    //   221	228	448	finally
    //   236	242	448	finally
    //   261	303	448	finally
    //   317	329	448	finally
    //   382	424	448	finally
    //   439	448	448	finally
    //   994	1002	1002	java/lang/Exception
    //   593	600	1085	java/io/IOException
    //   616	622	1085	java/io/IOException
    //   638	645	1085	java/io/IOException
    //   661	673	1085	java/io/IOException
    //   689	694	1085	java/io/IOException
    //   716	723	1085	java/io/IOException
    //   739	745	1085	java/io/IOException
    //   761	766	1085	java/io/IOException
    //   782	789	1085	java/io/IOException
    //   805	823	1085	java/io/IOException
    //   839	846	1085	java/io/IOException
    //   862	868	1085	java/io/IOException
    //   895	938	1085	java/io/IOException
    //   960	972	1085	java/io/IOException
    //   1033	1076	1085	java/io/IOException
    //   593	600	1104	finally
    //   616	622	1104	finally
    //   638	645	1104	finally
    //   661	673	1104	finally
    //   689	694	1104	finally
    //   716	723	1104	finally
    //   739	745	1104	finally
    //   761	766	1104	finally
    //   782	789	1104	finally
    //   805	823	1104	finally
    //   839	846	1104	finally
    //   862	868	1104	finally
    //   895	938	1104	finally
    //   960	972	1104	finally
    //   1033	1076	1104	finally
    //   1095	1104	1104	finally
    //   1121	1126	1128	java/lang/Exception
    //   100	114	1133	java/net/MalformedURLException
  }
  
  public final URL getResource(String paramString)
  {
    boolean bool = this.m_log.atTRACE1();
    if (bool) {
      this.m_log.trace1("getResource", "(" + paramString + "): nest level " + this.m_nestLevel);
    }
    URL localURL = super.getResource(paramString);
    if ((bool) && (localURL != null)) {
      this.m_log.trace1("loadClass", "[" + paramString + "] found in " + localURL);
    }
    return localURL;
  }
  
  public final Class loadClass(String paramString, boolean paramBoolean)
    throws ClassNotFoundException
  {
    boolean bool;
    Object localObject3;
    Object localObject1;
    try
    {
      bool = this.m_log.atTRACE1();
      if (bool) {
        this.m_log.trace1("loadClass", "(" + paramString + ", " + paramBoolean + "): nest level " + this.m_nestLevel);
      }
      Object localObject4 = findLoadedClass(paramString);
      localObject3 = localObject4;
      Object localObject5;
      Object localObject2;
      if (localObject4 == null)
      {
        localObject5 = null;
        localObject1 = null;
        localObject3 = this.m_parent;
        localObject2 = localObject4;
        if (localObject3 != null) {
          localObject3 = localObject4;
        }
      }
      try
      {
        Class localClass = this.m_parent.loadClass(paramString);
        localObject3 = localObject4;
        localObject5 = localClass;
        if (localClass.getClassLoader() == this.m_parent)
        {
          localObject3 = localObject4;
          localObject5 = localClass;
          if (this.m_forcedDelegationFilter != null)
          {
            localObject2 = localObject4;
            localObject1 = localClass;
            localObject3 = localObject4;
            localObject5 = localClass;
            if (!this.m_forcedDelegationFilter.included(paramString)) {
              break label251;
            }
          }
        }
        localObject4 = localClass;
        localObject2 = localObject4;
        localObject1 = localClass;
        if (bool)
        {
          localObject3 = localObject4;
          localObject5 = localClass;
          this.m_log.trace1("loadClass", "using parent's version for [" + paramString + "]");
          localObject1 = localClass;
          localObject2 = localObject4;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        label251:
        do
        {
          if (this.m_forcedDelegationFilter == null) {
            break;
          }
          localObject2 = localObject3;
          localObject1 = localObject5;
        } while (!this.m_forcedDelegationFilter.included(paramString));
        throw localClassNotFoundException2;
      }
      localObject3 = localObject2;
      if (localObject2 == null) {}
      if (this.m_throughDelegationFilter == null) {
        break label426;
      }
    }
    finally
    {
      try
      {
        localObject3 = findClass(paramString);
        if (localObject3 != null) {
          break label411;
        }
        throw new ClassNotFoundException(paramString);
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        if (localObject1 == null) {
          break label408;
        }
      }
      paramString = finally;
    }
    if (this.m_throughDelegationFilter.included(paramString)) {
      break label426;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject3 = localObject1;
        if (!bool) {
          break;
        }
        this.m_log.trace1("loadClass", "[delegation filter] using parent's version for [" + paramString + "]");
        localObject3 = localObject1;
        break;
      }
      throw localClassNotFoundException1;
      label408:
      throw localClassNotFoundException1;
      label411:
      if (paramBoolean) {
        resolveClass((Class)localObject3);
      }
      return (Class)localObject3;
      label426:
      int i = 1;
      continue;
      i = 0;
    }
  }
  
  private static final class PoolEntry
  {
    ByteArrayOStream m_baos;
    final byte[] m_buf;
    
    PoolEntry(int paramInt1, int paramInt2)
    {
      this.m_baos = new ByteArrayOStream(paramInt1);
      this.m_buf = new byte[paramInt2];
    }
    
    void trim(int paramInt1, int paramInt2)
    {
      if (this.m_baos.capacity() > paramInt2) {
        this.m_baos = new ByteArrayOStream(paramInt1);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/rt/InstrClassLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */