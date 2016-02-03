package com.amazonaws.mobileconnectors.kinesis.kinesisrecorder.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.mobileconnectors.kinesis.kinesisrecorder.KinesisRecorderConfig;
import com.amazonaws.mobileconnectors.kinesis.kinesisrecorder.internal.logging.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.concurrent.locks.ReentrantLock;

public class FileRecordStore
  implements RecordStore
{
  private static final Logger logger = Logger.getLogger(FileRecordStore.class);
  private final ReentrantLock accessLock = new ReentrantLock(true);
  private KinesisRecorderConfig config;
  private FileManager fileManager;
  private File recordFile;
  
  public FileRecordStore(File paramFile, KinesisRecorderConfig paramKinesisRecorderConfig)
  {
    this.fileManager = new FileManager(paramFile);
    this.config = paramKinesisRecorderConfig;
    tryCreateRecordsFile();
  }
  
  /* Error */
  private File deleteReadRecords(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 5
    //   12: aload_0
    //   13: getfield 47	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:fileManager	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileManager;
    //   16: ldc 75
    //   18: invokevirtual 79	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileManager:createDirectory	(Ljava/lang/String;)Ljava/io/File;
    //   21: astore 10
    //   23: new 81	java/io/File
    //   26: dup
    //   27: aload 10
    //   29: ldc 83
    //   31: invokespecial 86	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   34: astore 4
    //   36: aload 4
    //   38: invokevirtual 89	java/io/File:exists	()Z
    //   41: ifeq +19 -> 60
    //   44: aload 4
    //   46: invokevirtual 92	java/io/File:delete	()Z
    //   49: ifne +11 -> 60
    //   52: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:logger	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger;
    //   55: ldc 94
    //   57: invokevirtual 98	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:e	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 47	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:fileManager	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileManager;
    //   64: aload 4
    //   66: invokevirtual 102	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileManager:createFile	(Ljava/io/File;)Ljava/io/File;
    //   69: astore 11
    //   71: aload 11
    //   73: ifnull +187 -> 260
    //   76: aload_0
    //   77: getfield 57	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:recordFile	Ljava/io/File;
    //   80: invokevirtual 89	java/io/File:exists	()Z
    //   83: ifeq +177 -> 260
    //   86: aload 11
    //   88: invokevirtual 89	java/io/File:exists	()Z
    //   91: ifeq +169 -> 260
    //   94: new 104	java/io/BufferedReader
    //   97: dup
    //   98: new 106	java/io/FileReader
    //   101: dup
    //   102: aload_0
    //   103: getfield 57	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:recordFile	Ljava/io/File;
    //   106: invokespecial 107	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   109: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   112: astore 4
    //   114: aload 4
    //   116: astore 7
    //   118: new 112	java/io/PrintWriter
    //   121: dup
    //   122: new 114	java/io/FileWriter
    //   125: dup
    //   126: aload 11
    //   128: iconst_1
    //   129: invokespecial 117	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   132: invokespecial 120	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   135: astore 6
    //   137: iconst_0
    //   138: istore_2
    //   139: aload 4
    //   141: invokevirtual 124	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   144: astore 5
    //   146: aload 5
    //   148: ifnull +134 -> 282
    //   151: iload_2
    //   152: iconst_1
    //   153: iadd
    //   154: istore_3
    //   155: iload_3
    //   156: istore_2
    //   157: iload_3
    //   158: iload_1
    //   159: if_icmple -20 -> 139
    //   162: aload 6
    //   164: aload 5
    //   166: invokevirtual 127	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   169: aload 6
    //   171: invokevirtual 130	java/io/PrintWriter:flush	()V
    //   174: iload_3
    //   175: istore_2
    //   176: goto -37 -> 139
    //   179: astore 7
    //   181: aload 4
    //   183: astore 5
    //   185: aload 6
    //   187: astore 4
    //   189: aload 7
    //   191: astore 6
    //   193: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:logger	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger;
    //   196: ldc -124
    //   198: aload 6
    //   200: invokevirtual 135	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   203: aload 4
    //   205: ifnull +8 -> 213
    //   208: aload 4
    //   210: invokevirtual 138	java/io/PrintWriter:close	()V
    //   213: aload 5
    //   215: ifnull +8 -> 223
    //   218: aload 5
    //   220: invokevirtual 139	java/io/BufferedReader:close	()V
    //   223: new 81	java/io/File
    //   226: dup
    //   227: aload 10
    //   229: ldc 83
    //   231: invokespecial 86	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   234: astore 4
    //   236: aload 4
    //   238: invokevirtual 89	java/io/File:exists	()Z
    //   241: ifeq +19 -> 260
    //   244: aload 4
    //   246: invokevirtual 92	java/io/File:delete	()Z
    //   249: ifne +11 -> 260
    //   252: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:logger	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger;
    //   255: ldc -115
    //   257: invokevirtual 98	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:e	(Ljava/lang/String;)V
    //   260: aload_0
    //   261: getfield 57	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:recordFile	Ljava/io/File;
    //   264: areturn
    //   265: astore 4
    //   267: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:logger	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger;
    //   270: ldc -113
    //   272: aload 4
    //   274: invokevirtual 135	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   277: aload_0
    //   278: getfield 57	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:recordFile	Ljava/io/File;
    //   281: areturn
    //   282: aload 6
    //   284: ifnull +8 -> 292
    //   287: aload 6
    //   289: invokevirtual 138	java/io/PrintWriter:close	()V
    //   292: aload 4
    //   294: ifnull +8 -> 302
    //   297: aload 4
    //   299: invokevirtual 139	java/io/BufferedReader:close	()V
    //   302: aload_0
    //   303: getfield 57	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:recordFile	Ljava/io/File;
    //   306: invokevirtual 92	java/io/File:delete	()Z
    //   309: ifeq +63 -> 372
    //   312: aload 11
    //   314: aload_0
    //   315: getfield 57	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:recordFile	Ljava/io/File;
    //   318: invokevirtual 147	java/io/File:renameTo	(Ljava/io/File;)Z
    //   321: ifne +11 -> 332
    //   324: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:logger	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger;
    //   327: ldc -107
    //   329: invokevirtual 98	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:e	(Ljava/lang/String;)V
    //   332: aload_0
    //   333: aload_0
    //   334: getfield 47	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:fileManager	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileManager;
    //   337: new 81	java/io/File
    //   340: dup
    //   341: aload 10
    //   343: ldc -105
    //   345: invokespecial 86	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   348: invokevirtual 102	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileManager:createFile	(Ljava/io/File;)Ljava/io/File;
    //   351: putfield 57	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:recordFile	Ljava/io/File;
    //   354: goto -131 -> 223
    //   357: astore 4
    //   359: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:logger	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger;
    //   362: ldc -103
    //   364: aload 4
    //   366: invokevirtual 135	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   369: goto -146 -> 223
    //   372: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:logger	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger;
    //   375: ldc -101
    //   377: invokevirtual 98	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:e	(Ljava/lang/String;)V
    //   380: goto -157 -> 223
    //   383: astore 5
    //   385: aconst_null
    //   386: astore 4
    //   388: aload 9
    //   390: astore 6
    //   392: aload 6
    //   394: astore 8
    //   396: aload 4
    //   398: astore 7
    //   400: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:logger	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger;
    //   403: ldc -99
    //   405: aload 5
    //   407: invokevirtual 135	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   410: aload 6
    //   412: ifnull +8 -> 420
    //   415: aload 6
    //   417: invokevirtual 138	java/io/PrintWriter:close	()V
    //   420: aload 4
    //   422: ifnull -199 -> 223
    //   425: aload 4
    //   427: invokevirtual 139	java/io/BufferedReader:close	()V
    //   430: goto -207 -> 223
    //   433: astore 4
    //   435: goto -212 -> 223
    //   438: astore 5
    //   440: aconst_null
    //   441: astore 4
    //   443: iconst_0
    //   444: istore_1
    //   445: aload 6
    //   447: ifnull +8 -> 455
    //   450: aload 6
    //   452: invokevirtual 138	java/io/PrintWriter:close	()V
    //   455: aload 4
    //   457: ifnull +8 -> 465
    //   460: aload 4
    //   462: invokevirtual 139	java/io/BufferedReader:close	()V
    //   465: iload_1
    //   466: ifne +55 -> 521
    //   469: aload_0
    //   470: getfield 57	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:recordFile	Ljava/io/File;
    //   473: invokevirtual 92	java/io/File:delete	()Z
    //   476: ifeq +63 -> 539
    //   479: aload 11
    //   481: aload_0
    //   482: getfield 57	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:recordFile	Ljava/io/File;
    //   485: invokevirtual 147	java/io/File:renameTo	(Ljava/io/File;)Z
    //   488: ifne +11 -> 499
    //   491: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:logger	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger;
    //   494: ldc -107
    //   496: invokevirtual 98	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:e	(Ljava/lang/String;)V
    //   499: aload_0
    //   500: aload_0
    //   501: getfield 47	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:fileManager	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileManager;
    //   504: new 81	java/io/File
    //   507: dup
    //   508: aload 10
    //   510: ldc -105
    //   512: invokespecial 86	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   515: invokevirtual 102	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileManager:createFile	(Ljava/io/File;)Ljava/io/File;
    //   518: putfield 57	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:recordFile	Ljava/io/File;
    //   521: aload 5
    //   523: athrow
    //   524: astore 4
    //   526: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:logger	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger;
    //   529: ldc -103
    //   531: aload 4
    //   533: invokevirtual 135	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   536: goto -15 -> 521
    //   539: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:logger	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger;
    //   542: ldc -101
    //   544: invokevirtual 98	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:e	(Ljava/lang/String;)V
    //   547: goto -26 -> 521
    //   550: astore 4
    //   552: goto -250 -> 302
    //   555: astore 4
    //   557: goto -334 -> 223
    //   560: astore 4
    //   562: goto -97 -> 465
    //   565: astore 5
    //   567: iconst_0
    //   568: istore_1
    //   569: aload 8
    //   571: astore 6
    //   573: aload 7
    //   575: astore 4
    //   577: goto -132 -> 445
    //   580: astore 5
    //   582: iconst_0
    //   583: istore_1
    //   584: goto -139 -> 445
    //   587: astore 6
    //   589: aload 5
    //   591: astore 7
    //   593: iconst_1
    //   594: istore_1
    //   595: aload 6
    //   597: astore 5
    //   599: aload 4
    //   601: astore 6
    //   603: aload 7
    //   605: astore 4
    //   607: goto -162 -> 445
    //   610: astore 5
    //   612: aload 9
    //   614: astore 6
    //   616: goto -224 -> 392
    //   619: astore 5
    //   621: goto -229 -> 392
    //   624: astore 6
    //   626: aconst_null
    //   627: astore 4
    //   629: goto -436 -> 193
    //   632: astore 6
    //   634: aconst_null
    //   635: astore 7
    //   637: aload 4
    //   639: astore 5
    //   641: aload 7
    //   643: astore 4
    //   645: goto -452 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	this	FileRecordStore
    //   0	648	1	paramInt	int
    //   138	38	2	i	int
    //   154	21	3	j	int
    //   34	211	4	localObject1	Object
    //   265	33	4	localIOException1	IOException
    //   357	8	4	localIOException2	IOException
    //   386	40	4	localObject2	Object
    //   433	1	4	localIOException3	IOException
    //   441	20	4	localObject3	Object
    //   524	8	4	localIOException4	IOException
    //   550	1	4	localIOException5	IOException
    //   555	1	4	localIOException6	IOException
    //   560	1	4	localIOException7	IOException
    //   575	69	4	localObject4	Object
    //   10	209	5	localObject5	Object
    //   383	23	5	localIOException8	IOException
    //   438	84	5	localObject6	Object
    //   565	1	5	localObject7	Object
    //   580	10	5	localObject8	Object
    //   597	1	5	localObject9	Object
    //   610	1	5	localIOException9	IOException
    //   619	1	5	localIOException10	IOException
    //   639	1	5	localObject10	Object
    //   4	568	6	localObject11	Object
    //   587	9	6	localObject12	Object
    //   601	14	6	localObject13	Object
    //   624	1	6	localFileNotFoundException1	FileNotFoundException
    //   632	1	6	localFileNotFoundException2	FileNotFoundException
    //   116	1	7	localObject14	Object
    //   179	11	7	localFileNotFoundException3	FileNotFoundException
    //   398	244	7	localObject15	Object
    //   7	563	8	localObject16	Object
    //   1	612	9	localObject17	Object
    //   21	488	10	localFile1	File
    //   69	411	11	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   139	146	179	java/io/FileNotFoundException
    //   162	174	179	java/io/FileNotFoundException
    //   23	60	265	java/io/IOException
    //   60	71	265	java/io/IOException
    //   332	354	357	java/io/IOException
    //   94	114	383	java/io/IOException
    //   425	430	433	java/io/IOException
    //   94	114	438	finally
    //   499	521	524	java/io/IOException
    //   297	302	550	java/io/IOException
    //   218	223	555	java/io/IOException
    //   460	465	560	java/io/IOException
    //   118	137	565	finally
    //   400	410	565	finally
    //   139	146	580	finally
    //   162	174	580	finally
    //   193	203	587	finally
    //   118	137	610	java/io/IOException
    //   139	146	619	java/io/IOException
    //   162	174	619	java/io/IOException
    //   94	114	624	java/io/FileNotFoundException
    //   118	137	632	java/io/FileNotFoundException
  }
  
  private void tryCloseWriter(Writer paramWriter)
  {
    if (paramWriter != null) {}
    try
    {
      paramWriter.close();
      return;
    }
    catch (IOException paramWriter)
    {
      logger.e("Unable to close writer for records file", paramWriter);
    }
  }
  
  private boolean tryCreateRecordsFile()
  {
    if ((this.recordFile != null) && (this.recordFile.exists())) {
      return true;
    }
    try
    {
      if ((this.recordFile != null) && (this.recordFile.exists())) {
        return true;
      }
    }
    finally {}
    try
    {
      File localFile = this.fileManager.createDirectory("KinesisRecorder");
      this.recordFile = this.fileManager.createFile(new File(localFile, "KinesisRecords"));
      return true;
    }
    catch (IOException localIOException)
    {
      logger.deve("Unable to open records file");
      logger.e("An error occurred while attempting to create/open the records file", localIOException);
    }
    return false;
  }
  
  private Writer tryInitializeWriter()
  {
    try
    {
      if (tryCreateRecordsFile()) {
        return new OutputStreamWriter(this.fileManager.newOutputStream(this.recordFile, true));
      }
      throw new AmazonClientException("Unable to create record file");
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      logger.e("Records file not found to persist record to", localFileNotFoundException);
      throw new AmazonClientException("Unable to open record file writer", localFileNotFoundException);
    }
    catch (Exception localException)
    {
      throw new AmazonClientException("Unexpected error while creating recordsFile writer", localException);
    }
  }
  
  public RecordStore.RecordIterator iterator()
  {
    new RecordStore.RecordIterator()
    {
      boolean isEndOfFile = false;
      int linesRead = 0;
      String nextBuffer = null;
      BufferedReader reader = null;
      
      private void resetReader()
      {
        tryCloseReader();
        this.linesRead = 0;
        this.nextBuffer = null;
      }
      
      private void tryCloseReader()
      {
        if (this.reader != null) {}
        try
        {
          this.reader.close();
          return;
        }
        catch (IOException localIOException)
        {
          FileRecordStore.logger.e("Unable to close reader for records file", localIOException);
          return;
        }
        finally
        {
          this.reader = null;
        }
      }
      
      private boolean tryOpenReader()
      {
        if (this.reader != null) {
          return true;
        }
        if (!this.isEndOfFile) {
          try
          {
            InputStreamReader localInputStreamReader = new InputStreamReader(FileRecordStore.this.fileManager.newInputStream(FileRecordStore.this.recordFile));
            if (localInputStreamReader != null)
            {
              this.reader = new BufferedReader(localInputStreamReader);
              return true;
            }
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            for (;;)
            {
              FileRecordStore.logger.e("Could not open the records file", localFileNotFoundException);
              Object localObject = null;
            }
          }
        }
        return false;
      }
      
      /* Error */
      public boolean hasNext()
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: aload_0
        //   3: getfield 25	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore$1:this$0	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore;
        //   6: invokestatic 93	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:access$300	(Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore;)Ljava/util/concurrent/locks/ReentrantLock;
        //   9: invokevirtual 98	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   12: aload_0
        //   13: getfield 32	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore$1:nextBuffer	Ljava/lang/String;
        //   16: astore 4
        //   18: aload 4
        //   20: ifnull +15 -> 35
        //   23: aload_0
        //   24: getfield 25	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore$1:this$0	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore;
        //   27: invokestatic 93	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:access$300	(Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore;)Ljava/util/concurrent/locks/ReentrantLock;
        //   30: invokevirtual 101	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   33: iload_2
        //   34: ireturn
        //   35: aload_0
        //   36: invokespecial 103	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore$1:tryOpenReader	()Z
        //   39: istore_3
        //   40: iload_3
        //   41: ifne +15 -> 56
        //   44: aload_0
        //   45: getfield 25	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore$1:this$0	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore;
        //   48: invokestatic 93	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:access$300	(Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore;)Ljava/util/concurrent/locks/ReentrantLock;
        //   51: invokevirtual 101	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   54: iconst_0
        //   55: ireturn
        //   56: iconst_0
        //   57: istore_1
        //   58: iload_1
        //   59: ifne +31 -> 90
        //   62: aload_0
        //   63: aload_0
        //   64: getfield 34	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore$1:reader	Ljava/io/BufferedReader;
        //   67: invokevirtual 107	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   70: putfield 32	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore$1:nextBuffer	Ljava/lang/String;
        //   73: iconst_1
        //   74: istore_1
        //   75: goto -17 -> 58
        //   78: astore 4
        //   80: aload_0
        //   81: aconst_null
        //   82: putfield 32	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore$1:nextBuffer	Ljava/lang/String;
        //   85: iconst_1
        //   86: istore_1
        //   87: goto -29 -> 58
        //   90: aload_0
        //   91: getfield 32	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore$1:nextBuffer	Ljava/lang/String;
        //   94: ifnonnull -71 -> 23
        //   97: aload_0
        //   98: iconst_1
        //   99: putfield 36	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore$1:isEndOfFile	Z
        //   102: aload_0
        //   103: invokespecial 41	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore$1:tryCloseReader	()V
        //   106: iconst_0
        //   107: istore_2
        //   108: goto -85 -> 23
        //   111: astore 4
        //   113: aload_0
        //   114: getfield 25	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore$1:this$0	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore;
        //   117: invokestatic 93	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:access$300	(Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore;)Ljava/util/concurrent/locks/ReentrantLock;
        //   120: invokevirtual 101	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   123: aload 4
        //   125: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	126	0	this	1
        //   57	30	1	i	int
        //   1	107	2	bool1	boolean
        //   39	2	3	bool2	boolean
        //   16	3	4	str	String
        //   78	1	4	localIOException	IOException
        //   111	13	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   62	73	78	java/io/IOException
        //   12	18	111	finally
        //   35	40	111	finally
        //   62	73	111	finally
        //   80	85	111	finally
        //   90	106	111	finally
      }
      
      public String next()
      {
        FileRecordStore.this.accessLock.lock();
        for (;;)
        {
          try
          {
            if (this.nextBuffer != null)
            {
              str = this.nextBuffer;
              this.linesRead += 1;
              this.nextBuffer = null;
              return str;
            }
            boolean bool = tryOpenReader();
            if (!bool) {
              return null;
            }
            int i = 0;
            String str = null;
            Object localObject1;
            if (i == 0)
            {
              try
              {
                str = this.reader.readLine();
                i = 1;
              }
              catch (IOException localIOException)
              {
                i = 1;
                localObject1 = null;
              }
              continue;
            }
            if (localObject1 != null)
            {
              this.linesRead += 1;
              continue;
            }
            this.isEndOfFile = true;
          }
          finally
          {
            FileRecordStore.this.accessLock.unlock();
          }
          tryCloseReader();
        }
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException("The remove() operation is not supported for this iterator");
      }
      
      public void removeReadRecords()
      {
        FileRecordStore.this.accessLock.lock();
        try
        {
          FileRecordStore.this.deleteReadRecords(this.linesRead);
          resetReader();
          return;
        }
        finally
        {
          FileRecordStore.this.accessLock.unlock();
        }
      }
    };
  }
  
  /* Error */
  public boolean put(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aload_0
    //   9: getfield 40	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:accessLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   12: invokevirtual 207	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   15: aload_0
    //   16: invokespecial 209	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:tryInitializeWriter	()Ljava/io/Writer;
    //   19: astore 6
    //   21: iload_3
    //   22: istore_2
    //   23: aload 6
    //   25: ifnull +83 -> 108
    //   28: aload 6
    //   30: astore 4
    //   32: aload 6
    //   34: astore 5
    //   36: aload_0
    //   37: getfield 57	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:recordFile	Ljava/io/File;
    //   40: invokevirtual 213	java/io/File:length	()J
    //   43: aload_1
    //   44: invokevirtual 219	java/lang/String:getBytes	()[B
    //   47: arraylength
    //   48: i2l
    //   49: ladd
    //   50: aload_0
    //   51: getfield 49	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:config	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorderConfig;
    //   54: invokevirtual 224	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorderConfig:getMaxStorageSize	()J
    //   57: lcmp
    //   58: ifgt +65 -> 123
    //   61: aload 6
    //   63: astore 4
    //   65: aload 6
    //   67: astore 5
    //   69: aload 6
    //   71: new 226	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   78: aload_1
    //   79: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc -23
    //   84: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokevirtual 239	java/io/Writer:write	(Ljava/lang/String;)V
    //   93: aload 6
    //   95: astore 4
    //   97: aload 6
    //   99: astore 5
    //   101: aload 6
    //   103: invokevirtual 240	java/io/Writer:flush	()V
    //   106: iconst_1
    //   107: istore_2
    //   108: aload_0
    //   109: getfield 40	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:accessLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   112: invokevirtual 243	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   115: aload_0
    //   116: aload 6
    //   118: invokespecial 245	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:tryCloseWriter	(Ljava/io/Writer;)V
    //   121: iload_2
    //   122: ireturn
    //   123: aload 6
    //   125: astore 4
    //   127: aload 6
    //   129: astore 5
    //   131: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:logger	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger;
    //   134: new 226	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 227	java/lang/StringBuilder:<init>	()V
    //   141: ldc -9
    //   143: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: getfield 49	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:config	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorderConfig;
    //   150: invokevirtual 224	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/KinesisRecorderConfig:getMaxStorageSize	()J
    //   153: invokevirtual 250	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   156: ldc -4
    //   158: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokevirtual 98	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:e	(Ljava/lang/String;)V
    //   167: iload_3
    //   168: istore_2
    //   169: goto -61 -> 108
    //   172: astore_1
    //   173: aload 4
    //   175: astore 5
    //   177: getstatic 28	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:logger	Lcom/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger;
    //   180: ldc -2
    //   182: aload_1
    //   183: invokevirtual 135	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/logging/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   186: aload_0
    //   187: getfield 40	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:accessLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   190: invokevirtual 243	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   193: aload_0
    //   194: aload 4
    //   196: invokespecial 245	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:tryCloseWriter	(Ljava/io/Writer;)V
    //   199: iconst_0
    //   200: ireturn
    //   201: astore_1
    //   202: aload_0
    //   203: getfield 40	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:accessLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   206: invokevirtual 243	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   209: aload_0
    //   210: aload 5
    //   212: invokespecial 245	com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore:tryCloseWriter	(Ljava/io/Writer;)V
    //   215: aload_1
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	FileRecordStore
    //   0	217	1	paramString	String
    //   22	147	2	bool1	boolean
    //   1	167	3	bool2	boolean
    //   6	189	4	localObject1	Object
    //   3	208	5	localObject2	Object
    //   19	109	6	localWriter	Writer
    // Exception table:
    //   from	to	target	type
    //   15	21	172	java/io/IOException
    //   36	61	172	java/io/IOException
    //   69	93	172	java/io/IOException
    //   101	106	172	java/io/IOException
    //   131	167	172	java/io/IOException
    //   15	21	201	finally
    //   36	61	201	finally
    //   69	93	201	finally
    //   101	106	201	finally
    //   131	167	201	finally
    //   177	186	201	finally
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/retrica/com.venticake.retrica-21-dex2jar.jar!/com/amazonaws/mobileconnectors/kinesis/kinesisrecorder/internal/FileRecordStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */