package com.vladium.emma.instr;

import com.vladium.emma.EMMARuntimeException;
import com.vladium.emma.IAppErrorCodes;
import com.vladium.emma.data.IMetaData;
import com.vladium.emma.filter.IInclExclFilter;
import com.vladium.jcd.cls.ClassDef;
import com.vladium.jcd.compiler.ClassWriter;
import com.vladium.jcd.parser.ClassDefParser;
import com.vladium.logging.Logger;
import com.vladium.util.ByteArrayOStream;
import com.vladium.util.Descriptors;
import com.vladium.util.Files;
import com.vladium.util.Property;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.jar.Attributes;
import java.util.jar.Attributes.Name;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

final class InstrProcessorST
  extends InstrProcessor
  implements IAppErrorCodes
{
  private static final int BUF_SIZE = 32768;
  private static final boolean CLEANUP_TEMP_ARCHIVE_ON_ERRORS = true;
  private static final boolean DO_DEPENDS_CHECKING = true;
  private static final boolean DO_RAF_EXTENSION = true;
  private static final Class[] EXPECTED_FAILURES = { EMMARuntimeException.class, IllegalArgumentException.class, IllegalStateException.class };
  private static final int JOB_QUEUE_SIZE = 128;
  private JarOutputStream m_archiveOut;
  private ByteArrayOStream m_baos;
  private long m_currentArchiveTS;
  private final InstrVisitor.InstrResult m_instrResult = new InstrVisitor.InstrResult();
  private int m_jobPos;
  private final Job[] m_jobs = new Job[''];
  private IMetaData m_mdata;
  private File m_origArchiveFile;
  private byte[] m_readbuf;
  private int m_readpos;
  private File m_tempArchiveFile;
  private long m_timeStamp;
  private InstrVisitor m_visitor;
  
  private void addJob(Job paramJob)
    throws FileNotFoundException, IOException
  {
    if (this.m_jobPos == 128) {
      drainJobQueue();
    }
    Job[] arrayOfJob = this.m_jobs;
    int i = this.m_jobPos;
    this.m_jobPos = (i + 1);
    arrayOfJob[i] = paramJob;
  }
  
  private void drainJobQueue()
    throws IOException
  {
    int i = 0;
    while (i < this.m_jobPos)
    {
      Job localJob = this.m_jobs[i];
      if (localJob != null)
      {
        this.m_jobs[i] = null;
        localJob.run();
      }
      i += 1;
    }
    this.m_jobPos = 0;
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
    //   1: invokevirtual 109	java/io/File:length	()J
    //   4: l2i
    //   5: istore_3
    //   6: aload_0
    //   7: iload_3
    //   8: invokespecial 111	com/vladium/emma/instr/InstrProcessorST:ensureReadCapacity	(I)V
    //   11: aconst_null
    //   12: astore 5
    //   14: new 113	java/io/FileInputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 115	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 6
    //   24: iconst_0
    //   25: istore_2
    //   26: iload_2
    //   27: iload_3
    //   28: if_icmpge +31 -> 59
    //   31: aload 6
    //   33: aload_0
    //   34: getfield 93	com/vladium/emma/instr/InstrProcessorST:m_readbuf	[B
    //   37: iload_2
    //   38: iload_3
    //   39: iload_2
    //   40: isub
    //   41: invokevirtual 121	java/io/InputStream:read	([BII)I
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
    //   61: putfield 123	com/vladium/emma/instr/InstrProcessorST:m_readpos	I
    //   64: aload 6
    //   66: ifnull +8 -> 74
    //   69: aload 6
    //   71: invokevirtual 126	java/io/InputStream:close	()V
    //   74: return
    //   75: astore_1
    //   76: aload 5
    //   78: ifnull +8 -> 86
    //   81: aload 5
    //   83: invokevirtual 126	java/io/InputStream:close	()V
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
    //   0	103	0	this	InstrProcessorST
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
  
  static void writeFile(byte[] paramArrayOfByte, File paramFile, boolean paramBoolean)
    throws IOException
  {
    Object localObject1 = null;
    if (paramBoolean) {}
    try
    {
      File localFile = paramFile.getParentFile();
      if (localFile != null) {
        localFile.mkdirs();
      }
      paramFile = new RandomAccessFile(paramFile, "rw");
      if (paramArrayOfByte == null) {
        break label66;
      }
    }
    finally
    {
      try
      {
        paramFile.setLength(paramArrayOfByte.length);
        paramFile.write(paramArrayOfByte);
        if (paramFile != null) {
          paramFile.close();
        }
        return;
      }
      finally
      {
        paramArrayOfByte = paramFile;
        paramFile = (File)localObject2;
      }
      paramFile = finally;
      paramArrayOfByte = (byte[])localObject1;
    }
    paramArrayOfByte.close();
    label66:
    throw paramFile;
  }
  
  static void writeZipEntry(byte[] paramArrayOfByte, ZipOutputStream paramZipOutputStream, ZipEntry paramZipEntry, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
    {
      paramZipOutputStream.putNextEntry(paramZipEntry);
      try
      {
        paramZipOutputStream.write(paramArrayOfByte);
        return;
      }
      finally
      {
        paramZipOutputStream.closeEntry();
      }
    }
    ZipEntry localZipEntry = new ZipEntry(paramZipEntry.getName());
    localZipEntry.setTime(paramZipEntry.getTime());
    localZipEntry.setMethod(0);
    localZipEntry.setSize(paramArrayOfByte.length);
    localZipEntry.setCompressedSize(paramArrayOfByte.length);
    paramZipEntry = new CRC32();
    paramZipEntry.update(paramArrayOfByte);
    localZipEntry.setCrc(paramZipEntry.getValue());
    paramZipOutputStream.putNextEntry(localZipEntry);
    try
    {
      paramZipOutputStream.write(paramArrayOfByte);
      return;
    }
    finally
    {
      paramZipOutputStream.closeEntry();
    }
  }
  
  /* Error */
  protected void _run(com.vladium.util.IProperties paramIProperties)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 235	com/vladium/emma/instr/InstrProcessorST:m_log	Lcom/vladium/logging/Logger;
    //   4: astore 12
    //   6: aload 12
    //   8: invokevirtual 240	com/vladium/logging/Logger:atVERBOSE	()Z
    //   11: istore_3
    //   12: iload_3
    //   13: ifeq +653 -> 666
    //   16: aload 12
    //   18: ldc -14
    //   20: invokevirtual 245	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   23: aload 12
    //   25: ldc -9
    //   27: invokevirtual 245	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   30: aload 12
    //   32: ldc -7
    //   34: invokevirtual 245	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   37: iconst_0
    //   38: istore_2
    //   39: iload_2
    //   40: aload_0
    //   41: getfield 253	com/vladium/emma/instr/InstrProcessorST:m_instrPath	[Ljava/io/File;
    //   44: arraylength
    //   45: if_icmpge +73 -> 118
    //   48: aload_0
    //   49: getfield 253	com/vladium/emma/instr/InstrProcessorST:m_instrPath	[Ljava/io/File;
    //   52: iload_2
    //   53: aaload
    //   54: astore 9
    //   56: aload 9
    //   58: invokevirtual 256	java/io/File:exists	()Z
    //   61: ifeq +49 -> 110
    //   64: ldc_w 258
    //   67: astore 8
    //   69: aload 12
    //   71: new 260	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 263
    //   81: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 8
    //   86: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 9
    //   91: invokevirtual 270	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   94: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokevirtual 245	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   103: iload_2
    //   104: iconst_1
    //   105: iadd
    //   106: istore_2
    //   107: goto -68 -> 39
    //   110: ldc_w 275
    //   113: astore 8
    //   115: goto -46 -> 69
    //   118: aload 12
    //   120: ldc_w 277
    //   123: invokevirtual 245	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   126: aload 12
    //   128: new 260	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 279
    //   138: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 283	com/vladium/emma/instr/InstrProcessorST:m_outMode	Lcom/vladium/emma/instr/InstrProcessor$OutMode;
    //   145: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokevirtual 245	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   154: aconst_null
    //   155: astore 10
    //   157: invokestatic 291	java/lang/System:currentTimeMillis	()J
    //   160: lstore 4
    //   162: aload_0
    //   163: lload 4
    //   165: putfield 293	com/vladium/emma/instr/InstrProcessorST:m_timeStamp	J
    //   168: aload_0
    //   169: getfield 253	com/vladium/emma/instr/InstrProcessorST:m_instrPath	[Ljava/io/File;
    //   172: aload_0
    //   173: getfield 296	com/vladium/emma/instr/InstrProcessorST:m_canonical	Z
    //   176: aload_0
    //   177: invokestatic 302	com/vladium/util/IPathEnumerator$Factory:create	([Ljava/io/File;ZLcom/vladium/util/IPathEnumerator$IPathHandler;)Lcom/vladium/util/IPathEnumerator;
    //   180: astore 13
    //   182: aload_0
    //   183: getfield 283	com/vladium/emma/instr/InstrProcessorST:m_outMode	Lcom/vladium/emma/instr/InstrProcessor$OutMode;
    //   186: getstatic 307	com/vladium/emma/instr/InstrProcessor$OutMode:OUT_MODE_OVERWRITE	Lcom/vladium/emma/instr/InstrProcessor$OutMode;
    //   189: if_acmpeq +12 -> 201
    //   192: aload_0
    //   193: aload_0
    //   194: getfield 310	com/vladium/emma/instr/InstrProcessorST:m_outDir	Ljava/io/File;
    //   197: iconst_1
    //   198: invokevirtual 314	com/vladium/emma/instr/InstrProcessorST:createDir	(Ljava/io/File;Z)V
    //   201: aload_0
    //   202: getfield 283	com/vladium/emma/instr/InstrProcessorST:m_outMode	Lcom/vladium/emma/instr/InstrProcessor$OutMode;
    //   205: getstatic 317	com/vladium/emma/instr/InstrProcessor$OutMode:OUT_MODE_FULLCOPY	Lcom/vladium/emma/instr/InstrProcessor$OutMode;
    //   208: if_acmpne +33 -> 241
    //   211: aload_0
    //   212: aload_0
    //   213: getfield 310	com/vladium/emma/instr/InstrProcessorST:m_outDir	Ljava/io/File;
    //   216: ldc_w 319
    //   219: invokestatic 325	com/vladium/util/Files:newFile	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   222: iconst_0
    //   223: invokevirtual 314	com/vladium/emma/instr/InstrProcessorST:createDir	(Ljava/io/File;Z)V
    //   226: aload_0
    //   227: aload_0
    //   228: getfield 310	com/vladium/emma/instr/InstrProcessorST:m_outDir	Ljava/io/File;
    //   231: ldc_w 327
    //   234: invokestatic 325	com/vladium/util/Files:newFile	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   237: iconst_0
    //   238: invokevirtual 314	com/vladium/emma/instr/InstrProcessorST:createDir	(Ljava/io/File;Z)V
    //   241: aload_0
    //   242: getfield 330	com/vladium/emma/instr/InstrProcessorST:m_mdataOutFile	Ljava/io/File;
    //   245: astore 8
    //   247: aload_0
    //   248: getfield 334	com/vladium/emma/instr/InstrProcessorST:m_mdataOutMerge	Ljava/lang/Boolean;
    //   251: astore 11
    //   253: aload 8
    //   255: astore 9
    //   257: aload 8
    //   259: ifnonnull +24 -> 283
    //   262: new 105	java/io/File
    //   265: dup
    //   266: aload_1
    //   267: ldc_w 336
    //   270: ldc_w 338
    //   273: invokeinterface 344 3 0
    //   278: invokespecial 345	java/io/File:<init>	(Ljava/lang/String;)V
    //   281: astore 9
    //   283: aload 11
    //   285: astore 8
    //   287: aload 11
    //   289: ifnonnull +29 -> 318
    //   292: aload_1
    //   293: ldc_w 347
    //   296: getstatic 352	com/vladium/emma/EMMAProperties:DEFAULT_META_DATA_OUT_MERGE	Ljava/lang/Boolean;
    //   299: invokevirtual 355	java/lang/Boolean:toString	()Ljava/lang/String;
    //   302: invokeinterface 344 3 0
    //   307: invokestatic 361	com/vladium/util/Property:toBoolean	(Ljava/lang/String;)Z
    //   310: ifeq +367 -> 677
    //   313: getstatic 364	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   316: astore 8
    //   318: iload_3
    //   319: ifeq +58 -> 377
    //   322: aload 12
    //   324: new 260	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   331: ldc_w 366
    //   334: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload 9
    //   339: invokevirtual 270	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   342: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokevirtual 245	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   351: aload 12
    //   353: new 260	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   360: ldc_w 368
    //   363: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload 8
    //   368: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokevirtual 245	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   377: aload_0
    //   378: ldc 20
    //   380: newarray <illegal type>
    //   382: putfield 93	com/vladium/emma/instr/InstrProcessorST:m_readbuf	[B
    //   385: aload_0
    //   386: iconst_0
    //   387: putfield 123	com/vladium/emma/instr/InstrProcessorST:m_readpos	I
    //   390: aload_0
    //   391: new 140	com/vladium/util/ByteArrayOStream
    //   394: dup
    //   395: ldc 20
    //   397: invokespecial 370	com/vladium/util/ByteArrayOStream:<init>	(I)V
    //   400: putfield 138	com/vladium/emma/instr/InstrProcessorST:m_baos	Lcom/vladium/util/ByteArrayOStream;
    //   403: aload_0
    //   404: iconst_0
    //   405: putfield 82	com/vladium/emma/instr/InstrProcessorST:m_jobPos	I
    //   408: aload_0
    //   409: ldc2_w 371
    //   412: putfield 374	com/vladium/emma/instr/InstrProcessorST:m_currentArchiveTS	J
    //   415: aload_1
    //   416: invokestatic 379	com/vladium/emma/data/CoverageOptionsFactory:create	(Lcom/vladium/util/IProperties;)Lcom/vladium/emma/data/CoverageOptions;
    //   419: astore_1
    //   420: aload_0
    //   421: new 381	com/vladium/emma/instr/InstrVisitor
    //   424: dup
    //   425: aload_1
    //   426: invokespecial 384	com/vladium/emma/instr/InstrVisitor:<init>	(Lcom/vladium/emma/data/CoverageOptions;)V
    //   429: putfield 386	com/vladium/emma/instr/InstrProcessorST:m_visitor	Lcom/vladium/emma/instr/InstrVisitor;
    //   432: aload_0
    //   433: aload_1
    //   434: invokestatic 392	com/vladium/emma/data/DataFactory:newMetaData	(Lcom/vladium/emma/data/CoverageOptions;)Lcom/vladium/emma/data/IMetaData;
    //   437: putfield 394	com/vladium/emma/instr/InstrProcessorST:m_mdata	Lcom/vladium/emma/data/IMetaData;
    //   440: aload 13
    //   442: invokeinterface 399 1 0
    //   447: aload_0
    //   448: invokespecial 85	com/vladium/emma/instr/InstrProcessorST:drainJobQueue	()V
    //   451: aload 12
    //   453: invokevirtual 402	com/vladium/logging/Logger:atINFO	()Z
    //   456: ifeq +90 -> 546
    //   459: invokestatic 291	java/lang/System:currentTimeMillis	()J
    //   462: lstore 6
    //   464: aload 12
    //   466: new 260	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 404
    //   476: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: lload 6
    //   481: lload 4
    //   483: lsub
    //   484: invokevirtual 407	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   487: ldc_w 409
    //   490: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokevirtual 412	com/vladium/logging/Logger:info	(Ljava/lang/String;)V
    //   499: aload 12
    //   501: new 260	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   508: ldc_w 414
    //   511: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload_0
    //   515: getfield 417	com/vladium/emma/instr/InstrProcessorST:m_classInstrs	I
    //   518: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   521: ldc_w 422
    //   524: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload_0
    //   528: getfield 425	com/vladium/emma/instr/InstrProcessorST:m_classCopies	I
    //   531: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   534: ldc_w 427
    //   537: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokevirtual 412	com/vladium/logging/Logger:info	(Ljava/lang/String;)V
    //   546: iload_3
    //   547: ifeq +49 -> 596
    //   550: aload_0
    //   551: getfield 394	com/vladium/emma/instr/InstrProcessorST:m_mdata	Lcom/vladium/emma/data/IMetaData;
    //   554: ifnull +42 -> 596
    //   557: aload 12
    //   559: new 260	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   566: ldc_w 429
    //   569: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload_0
    //   573: getfield 394	com/vladium/emma/instr/InstrProcessorST:m_mdata	Lcom/vladium/emma/data/IMetaData;
    //   576: invokeinterface 435 1 0
    //   581: invokevirtual 420	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   584: ldc_w 437
    //   587: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokevirtual 245	com/vladium/logging/Logger:verbose	(Ljava/lang/String;)V
    //   596: aload_0
    //   597: getfield 394	com/vladium/emma/instr/InstrProcessorST:m_mdata	Lcom/vladium/emma/data/IMetaData;
    //   600: invokeinterface 440 1 0
    //   605: ifeq +123 -> 728
    //   608: aload 12
    //   610: ldc_w 442
    //   613: invokevirtual 412	com/vladium/logging/Logger:info	(Ljava/lang/String;)V
    //   616: aload_0
    //   617: invokevirtual 443	com/vladium/emma/instr/InstrProcessorST:reset	()V
    //   620: aload 10
    //   622: astore_1
    //   623: aload_1
    //   624: ifnull +263 -> 887
    //   627: aload_1
    //   628: getstatic 63	com/vladium/emma/instr/InstrProcessorST:EXPECTED_FAILURES	[Ljava/lang/Class;
    //   631: invokestatic 449	com/vladium/util/exception/Exceptions:unexpectedFailure	(Ljava/lang/Throwable;[Ljava/lang/Class;)Z
    //   634: ifeq +251 -> 885
    //   637: new 57	com/vladium/emma/EMMARuntimeException
    //   640: dup
    //   641: ldc_w 451
    //   644: iconst_2
    //   645: anewarray 453	java/lang/Object
    //   648: dup
    //   649: iconst_0
    //   650: aload_1
    //   651: invokevirtual 454	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   654: aastore
    //   655: dup
    //   656: iconst_1
    //   657: ldc_w 456
    //   660: aastore
    //   661: aload_1
    //   662: invokespecial 459	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   665: athrow
    //   666: aload 12
    //   668: ldc_w 461
    //   671: invokevirtual 412	com/vladium/logging/Logger:info	(Ljava/lang/String;)V
    //   674: goto -520 -> 154
    //   677: getstatic 464	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   680: astore 8
    //   682: goto -364 -> 318
    //   685: astore_1
    //   686: new 57	com/vladium/emma/EMMARuntimeException
    //   689: dup
    //   690: ldc_w 466
    //   693: aload_1
    //   694: invokespecial 469	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   697: athrow
    //   698: astore_1
    //   699: new 57	com/vladium/emma/EMMARuntimeException
    //   702: dup
    //   703: ldc_w 471
    //   706: iconst_1
    //   707: anewarray 473	java/lang/String
    //   710: dup
    //   711: iconst_0
    //   712: ldc_w 475
    //   715: aastore
    //   716: aload_1
    //   717: invokespecial 459	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   720: astore_1
    //   721: aload_0
    //   722: invokevirtual 443	com/vladium/emma/instr/InstrProcessorST:reset	()V
    //   725: goto -102 -> 623
    //   728: invokestatic 291	java/lang/System:currentTimeMillis	()J
    //   731: lstore 4
    //   733: aload_0
    //   734: getfield 394	com/vladium/emma/instr/InstrProcessorST:m_mdata	Lcom/vladium/emma/data/IMetaData;
    //   737: aload 9
    //   739: aload 8
    //   741: invokevirtual 478	java/lang/Boolean:booleanValue	()Z
    //   744: invokestatic 482	com/vladium/emma/data/DataFactory:persist	(Lcom/vladium/emma/data/IMetaData;Ljava/io/File;Z)V
    //   747: invokestatic 291	java/lang/System:currentTimeMillis	()J
    //   750: lstore 6
    //   752: aload 12
    //   754: invokevirtual 402	com/vladium/logging/Logger:atINFO	()Z
    //   757: ifeq -141 -> 616
    //   760: new 260	java/lang/StringBuilder
    //   763: dup
    //   764: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   767: ldc_w 484
    //   770: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: astore 11
    //   775: aload 8
    //   777: invokevirtual 478	java/lang/Boolean:booleanValue	()Z
    //   780: ifeq +91 -> 871
    //   783: ldc_w 486
    //   786: astore_1
    //   787: aload 12
    //   789: aload 11
    //   791: aload_1
    //   792: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: ldc_w 488
    //   798: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: aload 9
    //   803: invokevirtual 270	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   806: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: ldc_w 490
    //   812: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: lload 6
    //   817: lload 4
    //   819: lsub
    //   820: invokevirtual 407	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   823: ldc_w 492
    //   826: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: invokevirtual 273	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokevirtual 412	com/vladium/logging/Logger:info	(Ljava/lang/String;)V
    //   835: goto -219 -> 616
    //   838: astore_1
    //   839: new 57	com/vladium/emma/EMMARuntimeException
    //   842: dup
    //   843: ldc_w 494
    //   846: iconst_1
    //   847: anewarray 453	java/lang/Object
    //   850: dup
    //   851: iconst_0
    //   852: aload 9
    //   854: invokevirtual 270	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   857: aastore
    //   858: aload_1
    //   859: invokespecial 459	com/vladium/emma/EMMARuntimeException:<init>	(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   862: athrow
    //   863: astore_1
    //   864: aload_0
    //   865: invokevirtual 443	com/vladium/emma/instr/InstrProcessorST:reset	()V
    //   868: goto -245 -> 623
    //   871: ldc_w 496
    //   874: astore_1
    //   875: goto -88 -> 787
    //   878: astore_1
    //   879: aload_0
    //   880: invokevirtual 443	com/vladium/emma/instr/InstrProcessorST:reset	()V
    //   883: aload_1
    //   884: athrow
    //   885: aload_1
    //   886: athrow
    //   887: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	888	0	this	InstrProcessorST
    //   0	888	1	paramIProperties	com.vladium.util.IProperties
    //   38	69	2	i	int
    //   11	536	3	bool	boolean
    //   160	658	4	l1	long
    //   462	354	6	l2	long
    //   67	709	8	localObject1	Object
    //   54	799	9	localObject2	Object
    //   155	466	10	localObject3	Object
    //   251	539	11	localObject4	Object
    //   4	784	12	localLogger	Logger
    //   180	261	13	localIPathEnumerator	com.vladium.util.IPathEnumerator
    // Exception table:
    //   from	to	target	type
    //   440	451	685	java/io/IOException
    //   157	201	698	java/lang/SecurityException
    //   201	241	698	java/lang/SecurityException
    //   241	253	698	java/lang/SecurityException
    //   262	283	698	java/lang/SecurityException
    //   292	318	698	java/lang/SecurityException
    //   322	377	698	java/lang/SecurityException
    //   377	440	698	java/lang/SecurityException
    //   440	451	698	java/lang/SecurityException
    //   451	546	698	java/lang/SecurityException
    //   550	596	698	java/lang/SecurityException
    //   596	616	698	java/lang/SecurityException
    //   677	682	698	java/lang/SecurityException
    //   686	698	698	java/lang/SecurityException
    //   728	783	698	java/lang/SecurityException
    //   787	835	698	java/lang/SecurityException
    //   839	863	698	java/lang/SecurityException
    //   550	596	838	java/io/IOException
    //   596	616	838	java/io/IOException
    //   728	783	838	java/io/IOException
    //   787	835	838	java/io/IOException
    //   157	201	863	java/lang/RuntimeException
    //   201	241	863	java/lang/RuntimeException
    //   241	253	863	java/lang/RuntimeException
    //   262	283	863	java/lang/RuntimeException
    //   292	318	863	java/lang/RuntimeException
    //   322	377	863	java/lang/RuntimeException
    //   377	440	863	java/lang/RuntimeException
    //   440	451	863	java/lang/RuntimeException
    //   451	546	863	java/lang/RuntimeException
    //   550	596	863	java/lang/RuntimeException
    //   596	616	863	java/lang/RuntimeException
    //   677	682	863	java/lang/RuntimeException
    //   686	698	863	java/lang/RuntimeException
    //   728	783	863	java/lang/RuntimeException
    //   787	835	863	java/lang/RuntimeException
    //   839	863	863	java/lang/RuntimeException
    //   157	201	878	finally
    //   201	241	878	finally
    //   241	253	878	finally
    //   262	283	878	finally
    //   292	318	878	finally
    //   322	377	878	finally
    //   377	440	878	finally
    //   440	451	878	finally
    //   451	546	878	finally
    //   550	596	878	finally
    //   596	616	878	finally
    //   677	682	878	finally
    //   686	698	878	finally
    //   699	721	878	finally
    //   728	783	878	finally
    //   787	835	878	finally
    //   839	863	878	finally
  }
  
  public final void handleArchiveEnd(File paramFile1, File paramFile2)
  {
    Logger localLogger = this.m_log;
    if (localLogger.atTRACE2()) {
      localLogger.trace2("handleArchiveEnd", "[" + paramFile1 + "] [" + paramFile2 + "]");
    }
    this.m_currentArchiveTS = Long.MAX_VALUE;
    if ((this.m_outMode == InstrProcessor.OutMode.OUT_MODE_FULLCOPY) || (this.m_outMode == InstrProcessor.OutMode.OUT_MODE_OVERWRITE))
    {
      try
      {
        drainJobQueue();
        this.m_archiveOut.flush();
        this.m_archiveOut.close();
        this.m_archiveOut = null;
        if (this.m_outMode != InstrProcessor.OutMode.OUT_MODE_OVERWRITE) {
          return;
        }
        if (!Files.renameFile(this.m_tempArchiveFile, this.m_origArchiveFile, true)) {
          throw new EMMARuntimeException("could not rename temporary file [" + this.m_tempArchiveFile + "] to [" + this.m_origArchiveFile + "]: make sure the original file is not locked and can be deleted");
        }
      }
      catch (IOException paramFile1)
      {
        throw new EMMARuntimeException(paramFile1);
      }
      if (localLogger.atTRACE2()) {
        localLogger.trace2("handleArchiveEnd", "renamed temp archive [" + this.m_tempArchiveFile.getAbsolutePath() + "] to [" + this.m_origArchiveFile + "]");
      }
      this.m_tempArchiveFile = null;
      this.m_origArchiveFile = null;
    }
  }
  
  public final void handleArchiveEntry(JarInputStream paramJarInputStream, ZipEntry paramZipEntry)
  {
    Object localObject2 = this.m_log;
    if (((Logger)localObject2).atTRACE2()) {
      ((Logger)localObject2).trace2("handleArchiveEntry", "[" + paramZipEntry.getName() + "]");
    }
    Object localObject1 = paramZipEntry.getName();
    Object localObject3 = ((String)localObject1).toLowerCase();
    int i;
    int j;
    if ((this.m_outMode == InstrProcessor.OutMode.OUT_MODE_FULLCOPY) || (this.m_outMode == InstrProcessor.OutMode.OUT_MODE_OVERWRITE))
    {
      i = 1;
      j = 0;
      if (!((String)localObject3).endsWith(".class")) {
        break label753;
      }
      localObject3 = ((String)localObject1).substring(0, ((String)localObject1).length() - 6).replace('/', '.');
      if ((this.m_coverageFilter != null) && (!this.m_coverageFilter.included((String)localObject3))) {
        break label750;
      }
      localObject1 = null;
    }
    for (;;)
    {
      try
      {
        if (this.m_outMode == InstrProcessor.OutMode.OUT_MODE_COPY) {
          localFile = new File(((String)localObject3).replace('.', File.separatorChar).concat(".class"));
        }
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        File localFile;
        boolean bool;
        long l3;
        i = j;
        if (0 == 0) {
          continue;
        }
        try
        {
          throw new NullPointerException();
        }
        catch (Exception paramJarInputStream)
        {
          throw new EMMARuntimeException(paramJarInputStream);
        }
        if (i == 0) {
          continue;
        }
        arrayOfByte = new byte[this.m_readpos];
        System.arraycopy(this.m_readbuf, 0, arrayOfByte, 0, arrayOfByte.length);
        this.m_classCopies += 1;
        paramZipEntry.setTime(this.m_timeStamp);
        addJob(new EntryWriteJob(this.m_archiveOut, arrayOfByte, paramZipEntry, true));
        continue;
      }
      catch (IOException paramJarInputStream)
      {
        label225:
        label588:
        label614:
        label639:
        label706:
        throw new EMMARuntimeException(paramJarInputStream);
      }
      finally
      {
        if (0 != 0) {}
        try
        {
          throw new NullPointerException();
        }
        catch (Exception paramJarInputStream)
        {
          throw new EMMARuntimeException(paramJarInputStream);
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = getFullOutFile(null, localFile, true);
          bool = this.m_mdata.hasDescriptor(Descriptors.javaNameToVMName((String)localObject3));
          if (bool)
          {
            if (0 != 0) {}
            try
            {
              throw new NullPointerException();
            }
            catch (Exception paramJarInputStream)
            {
              throw new EMMARuntimeException(paramJarInputStream);
            }
            return;
            i = 0;
            break;
          }
          l3 = ((File)localObject1).lastModified();
          if (l3 > 0L)
          {
            long l2 = paramZipEntry.getTime();
            long l1 = l2;
            if (l2 < 0L) {
              l1 = this.m_currentArchiveTS;
            }
            if (l1 <= l3)
            {
              if (((Logger)localObject2).atVERBOSE()) {
                ((Logger)localObject2).verbose("destination file [" + localFile + "] skipped: more recent than the source");
              }
              if (0 == 0) {
                break label225;
              }
              try
              {
                throw new NullPointerException();
              }
              catch (Exception paramJarInputStream)
              {
                throw new EMMARuntimeException(paramJarInputStream);
              }
            }
          }
          readZipEntry(paramJarInputStream, paramZipEntry);
          localObject2 = ClassDefParser.parseClass(this.m_readbuf, this.m_readpos);
          localObject3 = this.m_visitor;
          if (this.m_outMode == InstrProcessor.OutMode.OUT_MODE_OVERWRITE)
          {
            bool = true;
            ((InstrVisitor)localObject3).process((ClassDef)localObject2, bool, true, true, this.m_instrResult);
            if (!this.m_instrResult.m_instrumented) {
              break label639;
            }
            this.m_classInstrs += 1;
            this.m_mdata.add(this.m_instrResult.m_descriptor, false);
            this.m_baos.reset();
            ClassWriter.writeClassTable((ClassDef)localObject2, this.m_baos);
            if (i == 0) {
              break label588;
            }
            paramZipEntry.setTime(this.m_timeStamp);
            addJob(new EntryWriteJob(this.m_archiveOut, this.m_baos.copyByteArray(), paramZipEntry, false));
            i = j;
            if (0 == 0) {}
          }
        }
        catch (IOException paramJarInputStream)
        {
          break label706;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          break label614;
        }
        try
        {
          throw new NullPointerException();
        }
        catch (Exception paramJarInputStream)
        {
          throw new EMMARuntimeException(paramJarInputStream);
        }
      }
      if (i != 0)
      {
        try
        {
          readZipEntry(paramJarInputStream, paramZipEntry);
          paramJarInputStream = new byte[this.m_readpos];
          System.arraycopy(this.m_readbuf, 0, paramJarInputStream, 0, paramJarInputStream.length);
          this.m_classCopies += 1;
          paramZipEntry.setTime(this.m_timeStamp);
          addJob(new EntryWriteJob(this.m_archiveOut, paramJarInputStream, paramZipEntry, true));
          return;
        }
        catch (IOException paramJarInputStream)
        {
          throw new EMMARuntimeException(paramJarInputStream);
        }
        bool = false;
        continue;
        addJob(new FileWriteJob((File)localObject1, this.m_baos.copyByteArray(), true));
        continue;
        byte[] arrayOfByte;
        label750:
        continue;
        label753:
        j = i;
        if (i != 0)
        {
          j = i;
          if (arrayOfByte.equalsIgnoreCase("META-INF/")) {
            j = 0;
          }
        }
        i = j;
        if (j != 0)
        {
          i = j;
          if (arrayOfByte.equalsIgnoreCase("META-INF/MANIFEST.MF")) {
            i = 0;
          }
        }
      }
    }
  }
  
  public final void handleArchiveStart(File paramFile1, File paramFile2, Manifest paramManifest)
  {
    Logger localLogger = this.m_log;
    if (localLogger.atTRACE2()) {
      localLogger.trace2("handleArchiveStart", "[" + paramFile1 + "] [" + paramFile2 + "]");
    }
    this.m_currentArchiveTS = Files.newFile(paramFile1, paramFile2).lastModified();
    Manifest localManifest;
    if ((this.m_outMode == InstrProcessor.OutMode.OUT_MODE_FULLCOPY) || (this.m_outMode == InstrProcessor.OutMode.OUT_MODE_OVERWRITE))
    {
      if (paramManifest == null) {
        break label288;
      }
      localManifest = new Manifest(paramManifest);
    }
    for (;;)
    {
      Attributes localAttributes = localManifest.getMainAttributes();
      if (paramManifest == null) {
        localAttributes.put(Attributes.Name.MANIFEST_VERSION, "1.0");
      }
      localAttributes.put(new Attributes.Name("Created-By"), "EMMA v0.0.0 (unsupported private build)");
      localAttributes.put(Attributes.Name.IMPLEMENTATION_TITLE, "instrumented version of [" + paramFile2.getAbsolutePath() + "]");
      localAttributes.put(Attributes.Name.SPECIFICATION_TITLE, "instrumented on " + new Date(this.m_timeStamp) + " [" + Property.getSystemFingerprint() + "]");
      if (this.m_outMode == InstrProcessor.OutMode.OUT_MODE_FULLCOPY) {
        try
        {
          paramFile1 = new FileOutputStream(getFullOutFile(paramFile1, paramFile2, false));
          if (localManifest != null)
          {
            paramFile1 = new JarOutputStream(paramFile1, localManifest);
            label282:
            this.m_archiveOut = paramFile1;
          }
          label288:
          do
          {
            return;
            localManifest = new Manifest();
            break;
            paramFile1 = new JarOutputStream(paramFile1);
            break label282;
          } while (this.m_outMode != InstrProcessor.OutMode.OUT_MODE_OVERWRITE);
        }
        catch (IOException paramFile1)
        {
          throw new EMMARuntimeException(paramFile1);
        }
      }
    }
    this.m_origArchiveFile = Files.newFile(paramFile1, paramFile2);
    paramFile2 = Files.getFileName(paramFile2) + "emma";
    for (;;)
    {
      try
      {
        this.m_tempArchiveFile = Files.createTempFile(paramFile1, paramFile2, ".et");
        if (localLogger.atTRACE2()) {
          localLogger.trace2("handleArchiveStart", "created temp archive [" + this.m_tempArchiveFile.getAbsolutePath() + "]");
        }
        paramFile1 = new FileOutputStream(this.m_tempArchiveFile);
        if (localManifest != null)
        {
          paramFile1 = new JarOutputStream(paramFile1, localManifest);
          this.m_archiveOut = paramFile1;
          return;
        }
      }
      catch (IOException paramFile1)
      {
        throw new EMMARuntimeException(paramFile1);
      }
      paramFile1 = new JarOutputStream(paramFile1);
    }
  }
  
  public final void handleDirEnd(File paramFile1, File paramFile2)
  {
    Logger localLogger = this.m_log;
    if (localLogger.atTRACE2()) {
      localLogger.trace2("handleDirEnd", "[" + paramFile1 + "] [" + paramFile2 + "]");
    }
    if (this.m_outMode == InstrProcessor.OutMode.OUT_MODE_OVERWRITE) {}
    try
    {
      drainJobQueue();
      return;
    }
    catch (IOException paramFile1)
    {
      throw new EMMARuntimeException(paramFile1);
    }
  }
  
  public final void handleDirStart(File paramFile1, File paramFile2)
  {
    Logger localLogger = this.m_log;
    if (localLogger.atTRACE2()) {
      localLogger.trace2("handleDirStart", "[" + paramFile1 + "] [" + paramFile2 + "]");
    }
    if (this.m_outMode == InstrProcessor.OutMode.OUT_MODE_FULLCOPY) {
      createDir(new File(getFullOutDir(paramFile1, true), paramFile2.getPath()), true);
    }
  }
  
  public final void handleFile(File paramFile1, File paramFile2)
  {
    Object localObject2 = this.m_log;
    if (((Logger)localObject2).atTRACE2()) {
      ((Logger)localObject2).trace2("handleFile", "[" + paramFile1 + "] [" + paramFile2 + "]");
    }
    Object localObject1 = paramFile2.getPath();
    Object localObject3 = ((String)localObject1).toLowerCase();
    int i;
    boolean bool1;
    label96:
    int j;
    if (this.m_outMode == InstrProcessor.OutMode.OUT_MODE_FULLCOPY)
    {
      i = 1;
      if (this.m_outMode != InstrProcessor.OutMode.OUT_MODE_COPY) {
        break label223;
      }
      bool1 = true;
      j = 0;
      if (!((String)localObject3).endsWith(".class")) {
        break label689;
      }
      localObject3 = ((String)localObject1).substring(0, ((String)localObject1).length() - 6).replace(File.separatorChar, '.');
      if ((this.m_coverageFilter != null) && (!this.m_coverageFilter.included((String)localObject3))) {
        break label686;
      }
    }
    label223:
    label686:
    label689:
    for (;;)
    {
      try
      {
        File localFile = Files.newFile(paramFile1, paramFile2.getPath());
        localObject1 = getFullOutFile(paramFile1, paramFile2, true);
        if (this.m_outMode == InstrProcessor.OutMode.OUT_MODE_COPY)
        {
          bool2 = this.m_mdata.hasDescriptor(Descriptors.javaNameToVMName((String)localObject3));
          if (bool2)
          {
            return;
            i = 0;
            break;
            bool1 = false;
            break label96;
          }
          long l = ((File)localObject1).lastModified();
          if ((l > 0L) && (localFile.lastModified() <= l))
          {
            if (((Logger)localObject2).atVERBOSE()) {
              ((Logger)localObject2).verbose("destination file [" + localObject1 + "] skipped: more recent that the source file");
            }
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
        }
        readFile(localFile);
        localObject2 = ClassDefParser.parseClass(this.m_readbuf, this.m_readpos);
        localObject3 = this.m_visitor;
        if (this.m_outMode == InstrProcessor.OutMode.OUT_MODE_OVERWRITE)
        {
          bool2 = true;
          ((InstrVisitor)localObject3).process((ClassDef)localObject2, bool2, true, true, this.m_instrResult);
          if (!this.m_instrResult.m_instrumented) {
            continue;
          }
          this.m_classInstrs += 1;
          this.m_mdata.add(this.m_instrResult.m_descriptor, false);
          this.m_baos.reset();
          ClassWriter.writeClassTable((ClassDef)localObject2, this.m_baos);
          addJob(new FileWriteJob((File)localObject1, this.m_baos.copyByteArray(), bool1));
          i = j;
          if (0 == 0) {}
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        boolean bool2;
        i = j;
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
        throw new EMMARuntimeException(paramFile1);
      }
      if (i != 0)
      {
        try
        {
          readFile(Files.newFile(paramFile1, paramFile2.getPath()));
          localObject1 = new byte[this.m_readpos];
          System.arraycopy(this.m_readbuf, 0, localObject1, 0, localObject1.length);
          this.m_classCopies += 1;
          addJob(new FileWriteJob(getFullOutFile(paramFile1, paramFile2, true), (byte[])localObject1, bool1));
          return;
        }
        catch (IOException paramFile1)
        {
          throw new EMMARuntimeException(paramFile1);
        }
        bool2 = false;
        continue;
        if (i != 0)
        {
          localObject2 = new byte[this.m_readpos];
          System.arraycopy(this.m_readbuf, 0, localObject2, 0, this.m_readpos);
          this.m_classCopies += 1;
          addJob(new FileWriteJob((File)localObject1, (byte[])localObject2, bool1));
          continue;
        }
      }
    }
  }
  
  protected void reset()
  {
    this.m_visitor = null;
    this.m_mdata = null;
    this.m_readbuf = null;
    this.m_baos = null;
    int i = 0;
    while (i < this.m_jobs.length)
    {
      this.m_jobs[i] = null;
      i += 1;
    }
    if (this.m_archiveOut != null) {}
    try
    {
      this.m_archiveOut.close();
      if (this.m_tempArchiveFile != null) {
        this.m_tempArchiveFile.delete();
      }
      this.m_archiveOut = null;
      this.m_origArchiveFile = null;
      this.m_tempArchiveFile = null;
      super.reset();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private static final class EntryWriteJob
    extends InstrProcessorST.Job
  {
    byte[] m_data;
    final ZipEntry m_entry;
    final boolean m_isCopy;
    final ZipOutputStream m_out;
    
    EntryWriteJob(ZipOutputStream paramZipOutputStream, byte[] paramArrayOfByte, ZipEntry paramZipEntry, boolean paramBoolean)
    {
      super();
      this.m_out = paramZipOutputStream;
      this.m_data = paramArrayOfByte;
      this.m_entry = paramZipEntry;
      this.m_isCopy = paramBoolean;
    }
    
    protected void run()
      throws IOException
    {
      InstrProcessorST.writeZipEntry(this.m_data, this.m_out, this.m_entry, this.m_isCopy);
      this.m_data = null;
    }
  }
  
  private static final class FileWriteJob
    extends InstrProcessorST.Job
  {
    byte[] m_data;
    final boolean m_mkdirs;
    final File m_outFile;
    
    FileWriteJob(File paramFile, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      super();
      this.m_outFile = paramFile;
      this.m_data = paramArrayOfByte;
      this.m_mkdirs = paramBoolean;
    }
    
    protected void run()
      throws IOException
    {
      InstrProcessorST.writeFile(this.m_data, this.m_outFile, this.m_mkdirs);
      this.m_data = null;
    }
  }
  
  private static abstract class Job
  {
    protected abstract void run()
      throws IOException;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/instr/InstrProcessorST.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */