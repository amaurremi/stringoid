package com.vladium.emma.rt;

import com.vladium.emma.EMMARuntimeException;
import com.vladium.emma.IAppErrorCodes;
import com.vladium.emma.data.IMetaData;
import com.vladium.emma.filter.IInclExclFilter;
import com.vladium.emma.instr.InstrVisitor;
import com.vladium.emma.instr.InstrVisitor.InstrResult;
import com.vladium.jcd.cls.ClassDef;
import com.vladium.jcd.parser.ClassDefParser;
import com.vladium.logging.Logger;
import com.vladium.util.ByteArrayOStream;
import com.vladium.util.Files;
import com.vladium.util.IPathEnumerator;
import com.vladium.util.IPathEnumerator.Factory;
import com.vladium.util.IPathEnumerator.IPathHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class ClassPathProcessorST
  implements IPathEnumerator.IPathHandler, IAppErrorCodes
{
  private static final int BUF_SIZE = 32768;
  private File m_archiveFile;
  private ByteArrayOStream m_baos;
  private final Map m_cache;
  private final boolean m_canonical;
  private int m_classCount;
  private final IInclExclFilter m_coverageFilter;
  private final InstrVisitor.InstrResult m_instrResult;
  private final Logger m_log;
  private final IMetaData m_mdata;
  private final File[] m_path;
  private byte[] m_readbuf;
  private int m_readpos;
  private final InstrVisitor m_visitor;
  
  ClassPathProcessorST(File[] paramArrayOfFile, boolean paramBoolean, IMetaData paramIMetaData, IInclExclFilter paramIInclExclFilter, Map paramMap)
  {
    if (paramArrayOfFile == null) {
      throw new IllegalArgumentException("null input: path");
    }
    if (paramIMetaData == null) {
      throw new IllegalArgumentException("null input: mdata");
    }
    this.m_path = paramArrayOfFile;
    this.m_canonical = paramBoolean;
    this.m_mdata = paramIMetaData;
    this.m_coverageFilter = paramIInclExclFilter;
    this.m_cache = paramMap;
    this.m_visitor = new InstrVisitor(paramIMetaData.getOptions());
    this.m_instrResult = new InstrVisitor.InstrResult();
    this.m_log = Logger.getLogger();
  }
  
  private void ensureReadCapacity(int paramInt)
  {
    if (this.m_readbuf.length < paramInt)
    {
      int i = this.m_readbuf.length;
      this.m_readbuf = null;
      this.m_readbuf = new byte[Math.max(i << 1, paramInt)];
    }
  }
  
  /* Error */
  private void readFile(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 108	java/io/File:length	()J
    //   4: l2i
    //   5: istore_3
    //   6: aload_0
    //   7: iload_3
    //   8: invokespecial 110	com/vladium/emma/rt/ClassPathProcessorST:ensureReadCapacity	(I)V
    //   11: aconst_null
    //   12: astore 5
    //   14: new 112	java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 6
    //   24: iconst_0
    //   25: istore_2
    //   26: iload_2
    //   27: iload_3
    //   28: if_icmpge +31 -> 59
    //   31: aload 6
    //   33: aload_0
    //   34: getfield 90	com/vladium/emma/rt/ClassPathProcessorST:m_readbuf	[B
    //   37: iload_2
    //   38: iload_3
    //   39: iload_2
    //   40: isub
    //   41: invokevirtual 120	java/io/InputStream:read	([BII)I
    //   44: istore 4
    //   46: iload 4
    //   48: iflt +11 -> 59
    //   51: iload_2
    //   52: iload 4
    //   54: iadd
    //   55: istore_2
    //   56: goto -30 -> 26
    //   59: aload_0
    //   60: iload_2
    //   61: putfield 122	com/vladium/emma/rt/ClassPathProcessorST:m_readpos	I
    //   64: aload 6
    //   66: ifnull +8 -> 74
    //   69: aload 6
    //   71: invokevirtual 125	java/io/InputStream:close	()V
    //   74: return
    //   75: astore_1
    //   76: aload 5
    //   78: ifnull +8 -> 86
    //   81: aload 5
    //   83: invokevirtual 125	java/io/InputStream:close	()V
    //   86: aload_1
    //   87: athrow
    //   88: astore_1
    //   89: return
    //   90: astore 5
    //   92: goto -6 -> 86
    //   95: astore_1
    //   96: aload 6
    //   98: astore 5
    //   100: goto -24 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	ClassPathProcessorST
    //   0	103	1	paramFile	File
    //   25	36	2	i	int
    //   5	36	3	j	int
    //   44	11	4	k	int
    //   12	70	5	localObject1	Object
    //   90	1	5	localException	Exception
    //   98	1	5	localObject2	Object
    //   22	75	6	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   14	24	75	finally
    //   69	74	88	java/lang/Exception
    //   81	86	90	java/lang/Exception
    //   31	46	95	finally
    //   59	64	95	finally
  }
  
  private void readZipEntry(ZipInputStream paramZipInputStream, ZipEntry paramZipEntry)
    throws IOException
  {
    int j = (int)paramZipEntry.getSize();
    int i;
    if (j >= 0)
    {
      ensureReadCapacity(j);
      i = 0;
      while (i < j)
      {
        int k = paramZipInputStream.read(this.m_readbuf, i, j - i);
        if (k < 0) {
          break;
        }
        i += k;
      }
      this.m_readpos = i;
      return;
    }
    ensureReadCapacity(32768);
    this.m_baos.reset();
    for (;;)
    {
      i = paramZipInputStream.read(this.m_readbuf);
      if (i < 0) {
        break;
      }
      this.m_baos.write(this.m_readbuf, 0, i);
    }
    this.m_readbuf = this.m_baos.copyByteArray();
    this.m_readpos = this.m_readbuf.length;
  }
  
  public void handleArchiveEnd(File paramFile1, File paramFile2)
  {
    this.m_archiveFile = null;
  }
  
  /* Error */
  public void handleArchiveEntry(java.util.jar.JarInputStream paramJarInputStream, ZipEntry paramZipEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 85	com/vladium/emma/rt/ClassPathProcessorST:m_log	Lcom/vladium/logging/Logger;
    //   4: invokevirtual 166	com/vladium/logging/Logger:atTRACE2	()Z
    //   7: ifeq +39 -> 46
    //   10: aload_0
    //   11: getfield 85	com/vladium/emma/rt/ClassPathProcessorST:m_log	Lcom/vladium/logging/Logger;
    //   14: ldc -89
    //   16: new 169	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   23: ldc -84
    //   25: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_2
    //   29: invokevirtual 180	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   32: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc -74
    //   37: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokevirtual 189	com/vladium/logging/Logger:trace2	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_2
    //   47: invokevirtual 180	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   50: astore 7
    //   52: aload 7
    //   54: invokevirtual 194	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   57: ldc -60
    //   59: invokevirtual 200	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   62: ifeq +232 -> 294
    //   65: aload 7
    //   67: iconst_0
    //   68: aload 7
    //   70: invokevirtual 203	java/lang/String:length	()I
    //   73: bipush 6
    //   75: isub
    //   76: invokevirtual 207	java/lang/String:substring	(II)Ljava/lang/String;
    //   79: bipush 47
    //   81: bipush 46
    //   83: invokevirtual 211	java/lang/String:replace	(CC)Ljava/lang/String;
    //   86: astore 6
    //   88: aload_0
    //   89: getfield 57	com/vladium/emma/rt/ClassPathProcessorST:m_coverageFilter	Lcom/vladium/emma/filter/IInclExclFilter;
    //   92: ifnull +17 -> 109
    //   95: aload_0
    //   96: getfield 57	com/vladium/emma/rt/ClassPathProcessorST:m_coverageFilter	Lcom/vladium/emma/filter/IInclExclFilter;
    //   99: aload 6
    //   101: invokeinterface 216 2 0
    //   106: ifeq +188 -> 294
    //   109: aconst_null
    //   110: astore 5
    //   112: aload_0
    //   113: aload_1
    //   114: aload_2
    //   115: invokespecial 218	com/vladium/emma/rt/ClassPathProcessorST:readZipEntry	(Ljava/util/zip/ZipInputStream;Ljava/util/zip/ZipEntry;)V
    //   118: ldc -36
    //   120: aload_0
    //   121: getfield 158	com/vladium/emma/rt/ClassPathProcessorST:m_archiveFile	Ljava/io/File;
    //   124: invokevirtual 224	java/io/File:toURL	()Ljava/net/URL;
    //   127: invokevirtual 229	java/net/URL:toExternalForm	()Ljava/lang/String;
    //   130: invokevirtual 233	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   133: ldc -21
    //   135: invokevirtual 233	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   138: aload 7
    //   140: invokevirtual 233	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   143: astore_1
    //   144: iconst_0
    //   145: ifeq +11 -> 156
    //   148: new 237	java/lang/NullPointerException
    //   151: dup
    //   152: invokespecial 238	java/lang/NullPointerException:<init>	()V
    //   155: athrow
    //   156: aload_0
    //   157: getfield 90	com/vladium/emma/rt/ClassPathProcessorST:m_readbuf	[B
    //   160: aload_0
    //   161: getfield 122	com/vladium/emma/rt/ClassPathProcessorST:m_readpos	I
    //   164: invokestatic 244	com/vladium/jcd/parser/ClassDefParser:parseClass	([BI)Lcom/vladium/jcd/cls/ClassDef;
    //   167: astore_2
    //   168: aload_2
    //   169: invokevirtual 249	com/vladium/jcd/cls/ClassDef:isInterface	()Z
    //   172: ifne +13 -> 185
    //   175: aload_0
    //   176: aload_0
    //   177: getfield 251	com/vladium/emma/rt/ClassPathProcessorST:m_classCount	I
    //   180: iconst_1
    //   181: iadd
    //   182: putfield 251	com/vladium/emma/rt/ClassPathProcessorST:m_classCount	I
    //   185: aload_0
    //   186: getfield 72	com/vladium/emma/rt/ClassPathProcessorST:m_visitor	Lcom/vladium/emma/instr/InstrVisitor;
    //   189: aload_2
    //   190: iconst_0
    //   191: iconst_0
    //   192: iconst_1
    //   193: aload_0
    //   194: getfield 77	com/vladium/emma/rt/ClassPathProcessorST:m_instrResult	Lcom/vladium/emma/instr/InstrVisitor$InstrResult;
    //   197: invokevirtual 255	com/vladium/emma/instr/InstrVisitor:process	(Lcom/vladium/jcd/cls/ClassDef;ZZZLcom/vladium/emma/instr/InstrVisitor$InstrResult;)V
    //   200: iconst_1
    //   201: istore 4
    //   203: iload 4
    //   205: istore_3
    //   206: aload_0
    //   207: getfield 77	com/vladium/emma/rt/ClassPathProcessorST:m_instrResult	Lcom/vladium/emma/instr/InstrVisitor$InstrResult;
    //   210: getfield 259	com/vladium/emma/instr/InstrVisitor$InstrResult:m_descriptor	Lcom/vladium/emma/data/ClassDescriptor;
    //   213: ifnull +28 -> 241
    //   216: iload 4
    //   218: istore_3
    //   219: aload_0
    //   220: getfield 55	com/vladium/emma/rt/ClassPathProcessorST:m_mdata	Lcom/vladium/emma/data/IMetaData;
    //   223: aload_0
    //   224: getfield 77	com/vladium/emma/rt/ClassPathProcessorST:m_instrResult	Lcom/vladium/emma/instr/InstrVisitor$InstrResult;
    //   227: getfield 259	com/vladium/emma/instr/InstrVisitor$InstrResult:m_descriptor	Lcom/vladium/emma/data/ClassDescriptor;
    //   230: iconst_0
    //   231: invokeinterface 263 3 0
    //   236: ifne +5 -> 241
    //   239: iconst_0
    //   240: istore_3
    //   241: iload_3
    //   242: ifeq +52 -> 294
    //   245: aload_0
    //   246: getfield 59	com/vladium/emma/rt/ClassPathProcessorST:m_cache	Ljava/util/Map;
    //   249: ifnull +45 -> 294
    //   252: aload_0
    //   253: getfield 122	com/vladium/emma/rt/ClassPathProcessorST:m_readpos	I
    //   256: newarray <illegal type>
    //   258: astore_2
    //   259: aload_0
    //   260: getfield 90	com/vladium/emma/rt/ClassPathProcessorST:m_readbuf	[B
    //   263: iconst_0
    //   264: aload_2
    //   265: iconst_0
    //   266: aload_0
    //   267: getfield 122	com/vladium/emma/rt/ClassPathProcessorST:m_readpos	I
    //   270: invokestatic 269	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   273: aload_0
    //   274: getfield 59	com/vladium/emma/rt/ClassPathProcessorST:m_cache	Ljava/util/Map;
    //   277: aload 6
    //   279: new 271	com/vladium/emma/rt/ClassPathCacheEntry
    //   282: dup
    //   283: aload_2
    //   284: aload_1
    //   285: invokespecial 274	com/vladium/emma/rt/ClassPathCacheEntry:<init>	([BLjava/lang/String;)V
    //   288: invokeinterface 280 3 0
    //   293: pop
    //   294: return
    //   295: astore_1
    //   296: new 282	com/vladium/emma/EMMARuntimeException
    //   299: dup
    //   300: aload_1
    //   301: invokespecial 285	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   304: athrow
    //   305: astore_1
    //   306: aload 5
    //   308: astore_1
    //   309: iconst_0
    //   310: ifeq -154 -> 156
    //   313: new 237	java/lang/NullPointerException
    //   316: dup
    //   317: invokespecial 238	java/lang/NullPointerException:<init>	()V
    //   320: athrow
    //   321: astore_1
    //   322: new 282	com/vladium/emma/EMMARuntimeException
    //   325: dup
    //   326: aload_1
    //   327: invokespecial 285	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   330: athrow
    //   331: astore_1
    //   332: new 282	com/vladium/emma/EMMARuntimeException
    //   335: dup
    //   336: aload_1
    //   337: invokespecial 285	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   340: athrow
    //   341: astore_1
    //   342: iconst_0
    //   343: ifeq +11 -> 354
    //   346: new 237	java/lang/NullPointerException
    //   349: dup
    //   350: invokespecial 238	java/lang/NullPointerException:<init>	()V
    //   353: athrow
    //   354: aload_1
    //   355: athrow
    //   356: astore_1
    //   357: new 282	com/vladium/emma/EMMARuntimeException
    //   360: dup
    //   361: aload_1
    //   362: invokespecial 285	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   365: athrow
    //   366: astore_1
    //   367: new 282	com/vladium/emma/EMMARuntimeException
    //   370: dup
    //   371: aload_1
    //   372: invokespecial 285	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   375: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	ClassPathProcessorST
    //   0	376	1	paramJarInputStream	java.util.jar.JarInputStream
    //   0	376	2	paramZipEntry	ZipEntry
    //   205	37	3	i	int
    //   201	16	4	j	int
    //   110	197	5	localObject	Object
    //   86	192	6	str1	String
    //   50	89	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   148	156	295	java/lang/Exception
    //   112	144	305	java/io/FileNotFoundException
    //   313	321	321	java/lang/Exception
    //   112	144	331	java/io/IOException
    //   112	144	341	finally
    //   332	341	341	finally
    //   346	354	356	java/lang/Exception
    //   156	185	366	java/io/IOException
    //   185	200	366	java/io/IOException
    //   206	216	366	java/io/IOException
    //   219	239	366	java/io/IOException
    //   245	294	366	java/io/IOException
  }
  
  public void handleArchiveStart(File paramFile1, File paramFile2, Manifest paramManifest)
  {
    this.m_archiveFile = Files.newFile(paramFile1, paramFile2.getPath());
  }
  
  public void handleDirEnd(File paramFile1, File paramFile2) {}
  
  public void handleDirStart(File paramFile1, File paramFile2) {}
  
  public void handleFile(File paramFile1, File paramFile2)
  {
    if (this.m_log.atTRACE2()) {
      this.m_log.trace2("handleFile", "[" + paramFile1 + "] [" + paramFile2 + "]");
    }
    str1 = paramFile2.getPath();
    String str2;
    if (str1.toLowerCase().endsWith(".class"))
    {
      str2 = str1.substring(0, str1.length() - 6).replace(File.separatorChar, '.');
      if ((this.m_coverageFilter == null) || (this.m_coverageFilter.included(str2))) {
        str1 = null;
      }
    }
    for (;;)
    {
      try
      {
        paramFile1 = Files.newFile(paramFile1, paramFile2.getPath());
        readFile(paramFile1);
        paramFile1 = paramFile1.toURL().toExternalForm();
        if (0 == 0) {}
      }
      catch (FileNotFoundException paramFile1)
      {
        int j;
        int i;
        paramFile1 = str1;
      }
      catch (IOException paramFile1)
      {
        throw new EMMARuntimeException(paramFile1);
      }
      finally
      {
        if (0 == 0) {
          continue;
        }
        try
        {
          throw new NullPointerException();
        }
        catch (Exception paramFile1)
        {
          throw new EMMARuntimeException(paramFile1);
        }
      }
      try
      {
        throw new NullPointerException();
      }
      catch (Exception paramFile1)
      {
        try
        {
          paramFile2 = ClassDefParser.parseClass(this.m_readbuf, this.m_readpos);
          if (!paramFile2.isInterface()) {
            this.m_classCount += 1;
          }
          this.m_visitor.process(paramFile2, false, false, true, this.m_instrResult);
          j = 1;
          i = j;
          if (this.m_instrResult.m_descriptor != null)
          {
            i = j;
            if (!this.m_mdata.add(this.m_instrResult.m_descriptor, false)) {
              i = 0;
            }
          }
          if ((i != 0) && (this.m_cache != null))
          {
            paramFile2 = new byte[this.m_readpos];
            System.arraycopy(this.m_readbuf, 0, paramFile2, 0, this.m_readpos);
            this.m_cache.put(str2, new ClassPathCacheEntry(paramFile2, paramFile1));
          }
          return;
        }
        catch (IOException paramFile1)
        {
          throw new EMMARuntimeException(paramFile1);
        }
        paramFile1 = paramFile1;
        throw new EMMARuntimeException(paramFile1);
      }
    }
  }
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    IPathEnumerator localIPathEnumerator = IPathEnumerator.Factory.create(this.m_path, this.m_canonical, this);
    this.m_readbuf = new byte[32768];
    this.m_readpos = 0;
    this.m_baos = new ByteArrayOStream(32768);
    if (this.m_log.atINFO()) {
      this.m_log.info("processing classpath ...");
    }
    try
    {
      localIPathEnumerator.enumerate();
      if (this.m_log.atINFO())
      {
        long l2 = System.currentTimeMillis();
        this.m_log.info("[" + this.m_classCount + " class(es) processed in " + (l2 - l1) + " ms]");
      }
      return;
    }
    catch (IOException localIOException)
    {
      throw new EMMARuntimeException("INSTR_IO_FAILURE", localIOException);
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/rt/ClassPathProcessorST.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */