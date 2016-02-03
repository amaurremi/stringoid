package com.vladium.emma.data;

import com.vladium.logging.Logger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public abstract class DataFactory
{
  private static final boolean DO_FSYNC = true;
  private static final int ENTRY_HEADER_LENGTH = 9;
  private static final int FILE_HEADER_LENGTH = 24;
  private static final int IO_BUF_SIZE = 32768;
  private static final int MAGIC = 1162693953;
  private static final int NULL_ARRAY_LENGTH = -1;
  public static final byte TYPE_COVERAGEDATA = 1;
  public static final byte TYPE_METADATA = 0;
  private static final long UNKNOWN = 0L;
  
  public static IMergeable[] load(File paramFile)
    throws IOException
  {
    if (paramFile == null) {
      throw new IllegalArgumentException("null input: file");
    }
    return mergeload(paramFile);
  }
  
  private static String makeAppVersion(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramInt1);
    localStringBuffer.append('.');
    localStringBuffer.append(paramInt2);
    localStringBuffer.append('.');
    localStringBuffer.append(paramInt3);
    return localStringBuffer.toString();
  }
  
  /* Error */
  private static IMergeable[] mergeload(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 82	com/vladium/logging/Logger:getLogger	()Lcom/vladium/logging/Logger;
    //   3: astore 16
    //   5: aload 16
    //   7: invokevirtual 86	com/vladium/logging/Logger:atTRACE1	()Z
    //   10: istore_2
    //   11: aload 16
    //   13: invokevirtual 89	com/vladium/logging/Logger:atTRACE2	()Z
    //   16: istore_3
    //   17: lconst_0
    //   18: lstore 4
    //   20: iload_2
    //   21: ifeq +8 -> 29
    //   24: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   27: lstore 4
    //   29: iconst_2
    //   30: anewarray 97	com/vladium/emma/data/IMergeable
    //   33: astore 17
    //   35: aload_0
    //   36: invokevirtual 102	java/io/File:exists	()Z
    //   39: ifne +38 -> 77
    //   42: new 47	java/io/IOException
    //   45: dup
    //   46: new 104	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   53: ldc 107
    //   55: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: invokevirtual 113	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   62: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc 115
    //   67: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokespecial 117	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   76: athrow
    //   77: aconst_null
    //   78: astore 15
    //   80: new 119	java/io/RandomAccessFile
    //   83: dup
    //   84: aload_0
    //   85: ldc 121
    //   87: invokespecial 124	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   90: astore 14
    //   92: aload 14
    //   94: invokevirtual 127	java/io/RandomAccessFile:length	()J
    //   97: lstore 10
    //   99: iload_2
    //   100: ifeq +39 -> 139
    //   103: aload 16
    //   105: ldc -128
    //   107: new 104	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   114: ldc -126
    //   116: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   123: ldc -121
    //   125: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: lload 10
    //   130: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   133: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokevirtual 142	com/vladium/logging/Logger:trace1	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: lload 10
    //   141: ldc2_w 143
    //   144: lcmp
    //   145: ifge +56 -> 201
    //   148: new 47	java/io/IOException
    //   151: dup
    //   152: new 104	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   159: ldc -110
    //   161: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_0
    //   165: invokevirtual 113	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   168: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc -108
    //   173: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc -106
    //   178: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokespecial 117	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   187: athrow
    //   188: astore_0
    //   189: aload 14
    //   191: ifnull +8 -> 199
    //   194: aload 14
    //   196: invokevirtual 153	java/io/RandomAccessFile:close	()V
    //   199: aload_0
    //   200: athrow
    //   201: lload 10
    //   203: ldc2_w 143
    //   206: lcmp
    //   207: ifle +70 -> 277
    //   210: aload 14
    //   212: ldc2_w 143
    //   215: invokevirtual 157	java/io/RandomAccessFile:seek	(J)V
    //   218: ldc2_w 143
    //   221: lstore 6
    //   223: lconst_0
    //   224: lstore 8
    //   226: iload_3
    //   227: ifeq +42 -> 269
    //   230: aload 16
    //   232: ldc -128
    //   234: new 104	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   241: ldc -126
    //   243: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_0
    //   247: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   250: ldc -97
    //   252: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload 14
    //   257: invokevirtual 162	java/io/RandomAccessFile:getFilePointer	()J
    //   260: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   263: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokevirtual 165	com/vladium/logging/Logger:trace2	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: lload 6
    //   271: lload 10
    //   273: lcmp
    //   274: iflt +69 -> 343
    //   277: aload 14
    //   279: ifnull +8 -> 287
    //   282: aload 14
    //   284: invokevirtual 153	java/io/RandomAccessFile:close	()V
    //   287: iload_2
    //   288: ifeq +52 -> 340
    //   291: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   294: lstore 6
    //   296: aload 16
    //   298: ldc -128
    //   300: new 104	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   307: ldc -126
    //   309: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_0
    //   313: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   316: ldc -89
    //   318: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: lload 6
    //   323: lload 4
    //   325: lsub
    //   326: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   329: ldc -87
    //   331: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokevirtual 142	com/vladium/logging/Logger:trace1	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: aload 17
    //   342: areturn
    //   343: aload 14
    //   345: invokevirtual 172	java/io/RandomAccessFile:readLong	()J
    //   348: lstore 12
    //   350: lload 12
    //   352: lconst_0
    //   353: lcmp
    //   354: ifle -77 -> 277
    //   357: lload 6
    //   359: lload 12
    //   361: ladd
    //   362: ldc2_w 173
    //   365: ladd
    //   366: lload 10
    //   368: lcmp
    //   369: ifgt -92 -> 277
    //   372: aload 14
    //   374: invokevirtual 178	java/io/RandomAccessFile:readByte	()B
    //   377: istore_1
    //   378: iload_1
    //   379: iflt -102 -> 277
    //   382: iload_1
    //   383: aload 17
    //   385: arraylength
    //   386: if_icmpge -109 -> 277
    //   389: iload_3
    //   390: ifeq +48 -> 438
    //   393: aload 16
    //   395: ldc -128
    //   397: new 104	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   404: ldc -126
    //   406: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload_0
    //   410: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   413: ldc -76
    //   415: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: lload 12
    //   420: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   423: ldc -74
    //   425: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: iload_1
    //   429: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   432: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokevirtual 165	com/vladium/logging/Logger:trace2	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: iload_3
    //   439: ifeq +8 -> 447
    //   442: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   445: lstore 8
    //   447: aload 14
    //   449: iload_1
    //   450: lload 12
    //   452: invokestatic 189	com/vladium/emma/data/DataFactory:readEntry	(Ljava/io/RandomAccessFile;BJ)Lcom/vladium/emma/data/IMergeable;
    //   455: astore 15
    //   457: iload_3
    //   458: ifeq +97 -> 555
    //   461: aload 16
    //   463: ldc -128
    //   465: new 104	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   472: ldc -65
    //   474: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   480: lload 8
    //   482: lsub
    //   483: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   486: ldc -87
    //   488: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokevirtual 165	com/vladium/logging/Logger:trace2	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: goto +58 -> 555
    //   500: lload 6
    //   502: ldc2_w 173
    //   505: lload 12
    //   507: ladd
    //   508: ladd
    //   509: lstore 6
    //   511: aload 14
    //   513: lload 6
    //   515: invokevirtual 157	java/io/RandomAccessFile:seek	(J)V
    //   518: goto -292 -> 226
    //   521: aload 17
    //   523: iload_1
    //   524: aload 18
    //   526: aload 15
    //   528: invokeinterface 195 2 0
    //   533: aastore
    //   534: goto -34 -> 500
    //   537: astore 14
    //   539: goto -252 -> 287
    //   542: astore 14
    //   544: goto -345 -> 199
    //   547: astore_0
    //   548: aload 15
    //   550: astore 14
    //   552: goto -363 -> 189
    //   555: aload 17
    //   557: iload_1
    //   558: aaload
    //   559: astore 18
    //   561: aload 18
    //   563: ifnonnull -42 -> 521
    //   566: aload 17
    //   568: iload_1
    //   569: aload 15
    //   571: aastore
    //   572: goto -72 -> 500
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	575	0	paramFile	File
    //   377	192	1	i	int
    //   10	278	2	bool1	boolean
    //   16	442	3	bool2	boolean
    //   18	306	4	l1	long
    //   221	293	6	l2	long
    //   224	257	8	l3	long
    //   97	270	10	l4	long
    //   348	158	12	l5	long
    //   90	422	14	localRandomAccessFile	RandomAccessFile
    //   537	1	14	localThrowable1	Throwable
    //   542	1	14	localThrowable2	Throwable
    //   550	1	14	localIMergeable1	IMergeable
    //   78	492	15	localIMergeable2	IMergeable
    //   3	459	16	localLogger	Logger
    //   33	534	17	arrayOfIMergeable	IMergeable[]
    //   524	38	18	localIMergeable3	IMergeable
    // Exception table:
    //   from	to	target	type
    //   92	99	188	finally
    //   103	139	188	finally
    //   148	188	188	finally
    //   210	218	188	finally
    //   230	269	188	finally
    //   343	350	188	finally
    //   372	378	188	finally
    //   382	389	188	finally
    //   393	438	188	finally
    //   442	447	188	finally
    //   447	457	188	finally
    //   461	497	188	finally
    //   511	518	188	finally
    //   521	534	188	finally
    //   282	287	537	java/lang/Throwable
    //   194	199	542	java/lang/Throwable
    //   80	92	547	finally
  }
  
  public static ICoverageData newCoverageData()
  {
    return new CoverageData();
  }
  
  public static IMetaData newMetaData(CoverageOptions paramCoverageOptions)
  {
    return new MetaData(paramCoverageOptions);
  }
  
  public static void persist(ICoverageData paramICoverageData, File paramFile, boolean paramBoolean)
    throws IOException
  {
    if (paramICoverageData == null) {
      throw new IllegalArgumentException("null input: data");
    }
    if (paramFile == null) {
      throw new IllegalArgumentException("null input: file");
    }
    if ((!paramBoolean) && (paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException("could not delete file [" + paramFile.getAbsolutePath() + "]");
    }
    persist(paramICoverageData, (byte)1, paramFile);
  }
  
  private static void persist(IMergeable paramIMergeable, byte paramByte, File paramFile)
    throws IOException
  {
    Logger localLogger = Logger.getLogger();
    boolean bool1 = localLogger.atTRACE1();
    boolean bool2 = localLogger.atTRACE2();
    long l1 = 0L;
    if (bool1) {
      l1 = System.currentTimeMillis();
    }
    int i = 0;
    int j = 0;
    Object localObject;
    try
    {
      if (!paramFile.exists()) {
        break label823;
      }
      if (paramFile.isFile()) {
        break label97;
      }
      throw new IOException("can persist in normal files only: " + paramFile.getAbsolutePath());
    }
    finally
    {
      localObject = null;
    }
    if (localObject != null) {}
    for (;;)
    {
      label97:
      long l3;
      long l2;
      try
      {
        ((RandomAccessFile)localObject).close();
        throw paramIMergeable;
        localRandomAccessFile = new RandomAccessFile(paramFile, "rw");
        localObject = localRandomAccessFile;
      }
      catch (Throwable paramFile)
      {
        try
        {
          RandomAccessFile localRandomAccessFile;
          l3 = localRandomAccessFile.length();
          int m;
          int i1;
          int n;
          if (bool1)
          {
            localObject = localRandomAccessFile;
            localLogger.trace1("persist", "[" + paramFile + "]: existing file length = " + l3);
            continue;
            if (i != 0)
            {
              if (j != 0)
              {
                localObject = localRandomAccessFile;
                localRandomAccessFile.seek(0L);
              }
              localObject = localRandomAccessFile;
              writeFileHeader(localRandomAccessFile);
              localObject = localRandomAccessFile;
              writeEntry(localLogger, localRandomAccessFile, 24L, paramIMergeable, paramByte);
            }
            if (localRandomAccessFile != null) {}
            try
            {
              localRandomAccessFile.close();
              if (bool1)
              {
                l2 = System.currentTimeMillis();
                localLogger.trace1("persist", "[" + paramFile + "]: file processed in " + (l2 - l1) + " ms");
              }
              return;
              j = 0;
              continue;
              localObject = localRandomAccessFile;
              if (localRandomAccessFile.readInt() == 1162693953) {
                break label945;
              }
              localObject = localRandomAccessFile;
              throw new IOException("cannot overwrite [" + paramFile.getAbsolutePath() + "]: not created by " + "EMMA");
              localObject = localRandomAccessFile;
              l2 = localRandomAccessFile.readLong();
              if (l2 != 32L)
              {
                j = 0;
                m = 0;
                i1 = 0;
                n = 0;
                i = m;
                localObject = localRandomAccessFile;
              }
              try
              {
                k = localRandomAccessFile.readInt();
                j = k;
                i = m;
                localObject = localRandomAccessFile;
                m = localRandomAccessFile.readInt();
                j = k;
                i = m;
                localObject = localRandomAccessFile;
                int i2 = localRandomAccessFile.readInt();
                i = i2;
                i1 = 1;
                n = m;
                j = k;
                m = i1;
                k = i;
              }
              catch (Throwable paramIMergeable)
              {
                long l4;
                int k = i1;
                m = n;
                n = i;
                continue;
              }
              if (m != 0)
              {
                localObject = localRandomAccessFile;
                throw new IOException("cannot merge new data into [" + paramFile.getAbsolutePath() + "]: created by another " + "EMMA" + " version [" + makeAppVersion(j, n, k) + "]");
              }
              localObject = localRandomAccessFile;
              throw new IOException("cannot merge new data into [" + paramFile.getAbsolutePath() + "]: created by another " + "EMMA" + " version");
              localObject = localRandomAccessFile;
              localRandomAccessFile.seek(24L);
              if (l3 != 24L) {
                break label962;
              }
              localObject = localRandomAccessFile;
              writeEntry(localLogger, localRandomAccessFile, 24L, paramIMergeable, paramByte);
              continue;
              if (!bool2) {
                break label970;
              }
              localObject = localRandomAccessFile;
              localLogger.trace2("persist", "[" + paramFile + "]: position " + localRandomAccessFile.getFilePointer());
              break label970;
              if (bool2)
              {
                localObject = localRandomAccessFile;
                localLogger.trace2("persist", "[" + paramFile + "]: adding entry at position " + l2);
              }
              localObject = localRandomAccessFile;
              writeEntry(localLogger, localRandomAccessFile, l2, paramIMergeable, paramByte);
              continue;
              localObject = localRandomAccessFile;
              l4 = localRandomAccessFile.readLong();
              if ((l4 <= 0L) || (l2 + l4 + 9L > l3)) {
                continue;
              }
              if (bool2)
              {
                localObject = localRandomAccessFile;
                localLogger.trace2("persist", "[" + paramFile + "]: found valid entry of size " + l4);
              }
              l2 += 9L + l4;
              localObject = localRandomAccessFile;
              localRandomAccessFile.seek(l2);
              continue;
              label823:
              if (bool1) {
                localLogger.trace1("persist", "[" + paramFile + "]: creating a new file");
              }
              localObject = paramFile.getParentFile();
              if (localObject != null) {
                ((File)localObject).mkdirs();
              }
              localRandomAccessFile = new RandomAccessFile(paramFile, "rw");
              i = 1;
            }
            catch (Throwable paramIMergeable)
            {
              continue;
            }
            paramFile = paramFile;
            continue;
          }
          if (l3 >= 4L) {
            continue;
          }
          i = 1;
          if (l3 <= 0L) {
            continue;
          }
          j = 1;
          continue;
          break;
        }
        finally {}
      }
      label945:
      if (l3 < 24L)
      {
        i = 1;
        j = 1;
        continue;
        label962:
        l2 = 24L;
        continue;
        label970:
        if (l2 < l3) {}
      }
    }
  }
  
  public static void persist(IMetaData paramIMetaData, File paramFile, boolean paramBoolean)
    throws IOException
  {
    if (paramIMetaData == null) {
      throw new IllegalArgumentException("null input: data");
    }
    if (paramFile == null) {
      throw new IllegalArgumentException("null input: file");
    }
    if ((!paramBoolean) && (paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException("could not delete file [" + paramFile.getAbsolutePath() + "]");
    }
    persist(paramIMetaData, (byte)0, paramFile);
  }
  
  public static void persist(ISessionData paramISessionData, File paramFile, boolean paramBoolean)
    throws IOException
  {
    if (paramISessionData == null) {
      throw new IllegalArgumentException("null input: data");
    }
    if (paramFile == null) {
      throw new IllegalArgumentException("null input: file");
    }
    if ((!paramBoolean) && (paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException("could not delete file [" + paramFile.getAbsolutePath() + "]");
    }
    persist(paramISessionData.getMetaData(), (byte)0, paramFile);
    persist(paramISessionData.getCoverageData(), (byte)1, paramFile);
  }
  
  public static boolean[] readBooleanArray(DataInput paramDataInput)
    throws IOException
  {
    int i = paramDataInput.readInt();
    Object localObject;
    if (i == -1)
    {
      localObject = null;
      return (boolean[])localObject;
    }
    boolean[] arrayOfBoolean = new boolean[i];
    for (;;)
    {
      i -= 1;
      localObject = arrayOfBoolean;
      if (i < 0) {
        break;
      }
      arrayOfBoolean[i] = paramDataInput.readBoolean();
    }
  }
  
  /* Error */
  public static ICoverageData readCoverageData(java.net.URL paramURL)
    throws IOException, java.lang.ClassNotFoundException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 297	java/io/ObjectInputStream
    //   5: dup
    //   6: new 299	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokevirtual 305	java/net/URL:openStream	()Ljava/io/InputStream;
    //   14: ldc 26
    //   16: invokespecial 308	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   19: invokespecial 311	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 315	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   27: checkcast 317	com/vladium/emma/data/ICoverageData
    //   30: astore_1
    //   31: aload_0
    //   32: ifnull +7 -> 39
    //   35: aload_0
    //   36: invokevirtual 318	java/io/ObjectInputStream:close	()V
    //   39: aload_1
    //   40: areturn
    //   41: astore_0
    //   42: aload_1
    //   43: ifnull +7 -> 50
    //   46: aload_1
    //   47: invokevirtual 318	java/io/ObjectInputStream:close	()V
    //   50: aload_0
    //   51: athrow
    //   52: astore_0
    //   53: aload_1
    //   54: areturn
    //   55: astore_1
    //   56: goto -6 -> 50
    //   59: astore_2
    //   60: aload_0
    //   61: astore_1
    //   62: aload_2
    //   63: astore_0
    //   64: goto -22 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramURL	java.net.URL
    //   1	53	1	localICoverageData	ICoverageData
    //   55	1	1	localException	Exception
    //   61	1	1	localURL	java.net.URL
    //   59	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	41	finally
    //   35	39	52	java/lang/Exception
    //   46	50	55	java/lang/Exception
    //   23	31	59	finally
  }
  
  private static IMergeable readEntry(RandomAccessFile paramRandomAccessFile, byte paramByte, long paramLong)
    throws IOException
  {
    paramRandomAccessFile = new DataInputStream(new RandomAccessFileInputStream(paramRandomAccessFile, 32768));
    switch (paramByte)
    {
    }
    for (paramRandomAccessFile = CoverageData.readExternal(paramRandomAccessFile);; paramRandomAccessFile = MetaData.readExternal(paramRandomAccessFile)) {
      return (IMergeable)paramRandomAccessFile;
    }
  }
  
  public static int[] readIntArray(DataInput paramDataInput)
    throws IOException
  {
    int i = paramDataInput.readInt();
    Object localObject;
    if (i == -1)
    {
      localObject = null;
      return (int[])localObject;
    }
    int[] arrayOfInt = new int[i];
    for (;;)
    {
      i -= 1;
      localObject = arrayOfInt;
      if (i < 0) {
        break;
      }
      arrayOfInt[i] = paramDataInput.readInt();
    }
  }
  
  /* Error */
  public static IMetaData readMetaData(java.net.URL paramURL)
    throws IOException, java.lang.ClassNotFoundException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 297	java/io/ObjectInputStream
    //   5: dup
    //   6: new 299	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokevirtual 305	java/net/URL:openStream	()Ljava/io/InputStream;
    //   14: ldc 26
    //   16: invokespecial 308	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   19: invokespecial 311	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: astore_0
    //   23: aload_0
    //   24: invokevirtual 315	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   27: checkcast 337	com/vladium/emma/data/IMetaData
    //   30: astore_1
    //   31: aload_0
    //   32: ifnull +7 -> 39
    //   35: aload_0
    //   36: invokevirtual 318	java/io/ObjectInputStream:close	()V
    //   39: aload_1
    //   40: areturn
    //   41: astore_0
    //   42: aload_1
    //   43: ifnull +7 -> 50
    //   46: aload_1
    //   47: invokevirtual 318	java/io/ObjectInputStream:close	()V
    //   50: aload_0
    //   51: athrow
    //   52: astore_0
    //   53: aload_1
    //   54: areturn
    //   55: astore_1
    //   56: goto -6 -> 50
    //   59: astore_2
    //   60: aload_0
    //   61: astore_1
    //   62: aload_2
    //   63: astore_0
    //   64: goto -22 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramURL	java.net.URL
    //   1	53	1	localIMetaData	IMetaData
    //   55	1	1	localException	Exception
    //   61	1	1	localURL	java.net.URL
    //   59	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	23	41	finally
    //   35	39	52	java/lang/Exception
    //   46	50	55	java/lang/Exception
    //   23	31	59	finally
  }
  
  public static void writeBooleanArray(boolean[] paramArrayOfBoolean, DataOutput paramDataOutput)
    throws IOException
  {
    if (paramArrayOfBoolean == null)
    {
      paramDataOutput.writeInt(-1);
      return;
    }
    int i = paramArrayOfBoolean.length;
    paramDataOutput.writeInt(i);
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      paramDataOutput.writeBoolean(paramArrayOfBoolean[i]);
    }
  }
  
  public static void writeCoverageData(ICoverageData paramICoverageData, OutputStream paramOutputStream)
    throws IOException
  {
    new ObjectOutputStream(paramOutputStream).writeObject(paramICoverageData);
  }
  
  private static void writeEntry(Logger paramLogger, RandomAccessFile paramRandomAccessFile, long paramLong, IMergeable paramIMergeable, byte paramByte)
    throws IOException
  {
    writeEntryHeader(paramRandomAccessFile, paramByte);
    RandomAccessFileOutputStream localRandomAccessFileOutputStream = new RandomAccessFileOutputStream(paramRandomAccessFile, 32768);
    DataOutputStream localDataOutputStream = new DataOutputStream(localRandomAccessFileOutputStream);
    switch (paramByte)
    {
    default: 
      CoverageData.writeExternal((CoverageData)paramIMergeable, localDataOutputStream);
    }
    for (;;)
    {
      localDataOutputStream.flush();
      paramRandomAccessFile.setLength(paramRandomAccessFile.getFilePointer());
      paramRandomAccessFile.seek(paramLong);
      paramRandomAccessFile.writeLong(localRandomAccessFileOutputStream.getCount());
      paramRandomAccessFile.getFD().sync();
      if (paramLogger.atTRACE2()) {
        paramLogger.trace2("writeEntry", "entry [" + paramIMergeable.getClass().getName() + "] length: " + localRandomAccessFileOutputStream.getCount());
      }
      return;
      MetaData.writeExternal((MetaData)paramIMergeable, localDataOutputStream);
    }
  }
  
  private static void writeEntryHeader(DataOutput paramDataOutput, byte paramByte)
    throws IOException
  {
    paramDataOutput.writeLong(0L);
    paramDataOutput.writeByte(paramByte);
  }
  
  private static void writeFileHeader(DataOutput paramDataOutput)
    throws IOException
  {
    paramDataOutput.writeInt(1162693953);
    paramDataOutput.writeLong(32L);
    paramDataOutput.writeInt(0);
    paramDataOutput.writeInt(0);
    paramDataOutput.writeInt(0);
  }
  
  public static void writeIntArray(int[] paramArrayOfInt, DataOutput paramDataOutput)
    throws IOException
  {
    if (paramArrayOfInt == null)
    {
      paramDataOutput.writeInt(-1);
      return;
    }
    int i = paramArrayOfInt.length;
    paramDataOutput.writeInt(i);
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      paramDataOutput.writeInt(paramArrayOfInt[i]);
    }
  }
  
  public static void writeMetaData(IMetaData paramIMetaData, OutputStream paramOutputStream)
    throws IOException
  {
    new ObjectOutputStream(paramOutputStream).writeObject(paramIMetaData);
  }
  
  /* Error */
  public static void writeMetaData(IMetaData paramIMetaData, java.net.URL paramURL)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 423	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   4: astore_2
    //   5: aload_2
    //   6: iconst_1
    //   7: invokevirtual 428	java/net/URLConnection:setDoOutput	(Z)V
    //   10: aconst_null
    //   11: astore_1
    //   12: aload_2
    //   13: invokevirtual 432	java/net/URLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   16: astore_2
    //   17: aload_2
    //   18: astore_1
    //   19: aload_0
    //   20: aload_2
    //   21: invokestatic 434	com/vladium/emma/data/DataFactory:writeMetaData	(Lcom/vladium/emma/data/IMetaData;Ljava/io/OutputStream;)V
    //   24: aload_2
    //   25: astore_1
    //   26: aload_2
    //   27: invokevirtual 437	java/io/OutputStream:flush	()V
    //   30: aload_2
    //   31: ifnull +7 -> 38
    //   34: aload_2
    //   35: invokevirtual 438	java/io/OutputStream:close	()V
    //   38: return
    //   39: astore_0
    //   40: aload_1
    //   41: ifnull +7 -> 48
    //   44: aload_1
    //   45: invokevirtual 438	java/io/OutputStream:close	()V
    //   48: aload_0
    //   49: athrow
    //   50: astore_0
    //   51: return
    //   52: astore_1
    //   53: goto -5 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	paramIMetaData	IMetaData
    //   0	56	1	paramURL	java.net.URL
    //   4	31	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	17	39	finally
    //   19	24	39	finally
    //   26	30	39	finally
    //   34	38	50	java/lang/Exception
    //   44	48	52	java/lang/Exception
  }
  
  private static final class RandomAccessFileInputStream
    extends BufferedInputStream
  {
    private long m_count;
    
    RandomAccessFileInputStream(RandomAccessFile paramRandomAccessFile, int paramInt)
      throws IOException
    {
      super(paramInt);
    }
    
    public void close() {}
    
    final long getCount()
    {
      return this.m_count;
    }
    
    public final int read()
      throws IOException
    {
      int i = super.read();
      if (i >= 0) {
        this.m_count += 1L;
      }
      return i;
    }
    
    public final int read(byte[] paramArrayOfByte)
      throws IOException
    {
      int i = super.read(paramArrayOfByte);
      if (i >= 0) {
        this.m_count += i;
      }
      return i;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 >= 0) {
        this.m_count += paramInt1;
      }
      return paramInt1;
    }
  }
  
  private static final class RandomAccessFileOutputStream
    extends BufferedOutputStream
  {
    private long m_count;
    
    RandomAccessFileOutputStream(RandomAccessFile paramRandomAccessFile, int paramInt)
      throws IOException
    {
      super(paramInt);
    }
    
    public void close() {}
    
    final long getCount()
    {
      return this.m_count;
    }
    
    public final void write(int paramInt)
      throws IOException
    {
      super.write(paramInt);
      this.m_count += 1L;
    }
    
    public final void write(byte[] paramArrayOfByte)
      throws IOException
    {
      super.write(paramArrayOfByte);
      this.m_count += paramArrayOfByte.length;
    }
    
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      this.m_count += paramInt2;
    }
  }
  
  private static final class UCFileInputStream
    extends FileInputStream
  {
    UCFileInputStream(FileDescriptor paramFileDescriptor)
    {
      super();
    }
    
    public void close() {}
  }
  
  private static final class UCFileOutputStream
    extends FileOutputStream
  {
    UCFileOutputStream(FileDescriptor paramFileDescriptor)
    {
      super();
    }
    
    public void close() {}
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/go weather ex/com.gau.go.launcherex.gowidget.weatherwidget-124-dex2jar.jar!/com/vladium/emma/data/DataFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */