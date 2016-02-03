package mobi.beyondpod.rsscore;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.FileUtils;

public class BackupRestore
{
  private static int BuffSize = 1024;
  public static final String PREFERENCE_KEY = "BackupRestore";
  public static final int RESULT_BACKUP_FAILED = -1;
  public static final int RESULT_BACKUP_RESTORE_ALREADY_IN_PROGRESS = -4;
  public static final int RESULT_BACKUP_SUCCESS = 0;
  public static final int RESULT_RESTORE_FAILED = -3;
  public static final int RESULT_RESTORE_PREPARE_FAILED = -2;
  public static final int RESULT_RESTORE_PREPARE_SUCCESS = 1;
  public static final int RESULT_RESTORE_SUCCESS = 3;
  private static final String TAG = BackupRestore.class.getSimpleName();
  private static Thread _Worker;
  private static final String _ZipFileExtension = ".bpbak";
  private static String _ZipFileName = "BeyondPod_Backup_";
  
  public static void CleanSnapshotFolder()
  {
    if ((_Worker != null) && (_Worker.isAlive())) {}
    File localFile;
    do
    {
      return;
      localFile = new File(Configuration.BackupManagerBackupPath());
    } while (!localFile.exists());
    _Worker = new Thread(new Runnable()
    {
      public void run()
      {
        BackupRestore.ClearDirectory(BackupRestore.this);
      }
    }, TAG);
    _Worker.start();
  }
  
  private static boolean ClearDirectory(File paramFile)
  {
    boolean bool = true;
    File[] arrayOfFile = null;
    if (paramFile.exists()) {
      arrayOfFile = paramFile.listFiles();
    }
    if ((arrayOfFile == null) || (arrayOfFile.length < 1)) {
      return true;
    }
    int j = 0;
    int k = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      if (i >= k)
      {
        CoreHelper.WriteTraceEntry(TAG, String.format("Cleaned %s of %s files from %s", new Object[] { Integer.valueOf(j), Integer.valueOf(arrayOfFile.length), paramFile }));
        return bool;
      }
      File localFile = arrayOfFile[i];
      if (!localFile.delete())
      {
        CoreHelper.WriteTraceEntry(TAG, "Failed to delete file " + localFile.getName());
        bool = false;
      }
      j += 1;
      i += 1;
    }
  }
  
  public static void CreateZippedBackup(BackupRestoreOperationResult paramBackupRestoreOperationResult)
  {
    if ((_Worker != null) && (_Worker.isAlive()))
    {
      if (paramBackupRestoreOperationResult != null) {
        paramBackupRestoreOperationResult.OperationFailed(-4, "");
      }
      return;
    }
    _Worker = new Thread(new Runnable()
    {
      public void run()
      {
        BackupRestore.CreateZippedBackupInternal(BackupRestore.this);
      }
    }, TAG);
    _Worker.start();
  }
  
  private static void CreateZippedBackupInternal(BackupRestoreOperationResult paramBackupRestoreOperationResult)
  {
    CoreHelper.WriteTraceEntry(TAG, "Starting Backup");
    localFile = new File(Configuration.BackupManagerBackupPath());
    if (localFile.exists())
    {
      ClearDirectory(localFile);
      if (localFile.list().length > 0)
      {
        paramBackupRestoreOperationResult.OperationFailed(-1, "Failed to empty backup snapshot folder " + localFile.getPath());
        return;
      }
    }
    if (!StartupContentBuilder.CreateRepositorySnapshot())
    {
      paramBackupRestoreOperationResult.OperationFailed(-1, "Failed to create backup snapshot!");
      return;
    }
    Object localObject1 = new File(Configuration.DefaultBackupPath());
    if (!((File)localObject1).exists())
    {
      CoreHelper.WriteTraceEntry(TAG, "Backup folder does not exist! Creating " + ((File)localObject1).getPath());
      ((File)localObject1).mkdirs();
    }
    if (!((File)localObject1).exists())
    {
      paramBackupRestoreOperationResult.OperationFailed(-1, "Failed to create the backup folder " + ((File)localObject1).getPath());
      return;
    }
    localObject2 = new SimpleDateFormat("yyyy-MM-dd");
    localObject2 = new File((File)localObject1, _ZipFileName + ((SimpleDateFormat)localObject2).format(new Date())).getPath();
    int i = 1;
    localObject1 = "";
    for (;;)
    {
      if (!FileUtils.Exists(localObject2 + (String)localObject1 + ".bpbak"))
      {
        localObject2 = localObject2 + (String)localObject1 + ".bpbak";
        CoreHelper.WriteTraceEntry(TAG, "Saving backip to " + (String)localObject2);
      }
      try
      {
        paramBackupRestoreOperationResult.OperationCompleted(0, (String)localObject2, ZipBackupFiles(localFile, (String)localObject2));
        CoreHelper.WriteTraceEntry(TAG, "Backup Completed!");
        return;
      }
      catch (Exception localException)
      {
        localObject2 = new File((String)localObject2);
        if (!((File)localObject2).exists()) {
          break;
        }
        ((File)localObject2).delete();
        CoreHelper.WriteTraceEntry(TAG, "Backup failed! Reason: " + localException.getMessage());
        paramBackupRestoreOperationResult.OperationFailed(-1, localException.getMessage());
        return;
      }
      finally
      {
        ClearDirectory(localFile);
      }
      localObject1 = "-" + i;
      i += 1;
    }
  }
  
  public static File[] EnumerateRestoreZipFiles()
  {
    File localFile = new File(Configuration.DefaultBackupPath());
    File[] arrayOfFile = null;
    if (localFile.exists()) {
      arrayOfFile = localFile.listFiles(new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          return paramAnonymousFile.getName().endsWith(".bpbak");
        }
      });
    }
    if ((arrayOfFile == null) || (arrayOfFile.length == 0)) {
      return null;
    }
    Arrays.sort(arrayOfFile, new Comparator()
    {
      public int compare(File paramAnonymousFile1, File paramAnonymousFile2)
      {
        return Long.valueOf(paramAnonymousFile2.lastModified()).compareTo(Long.valueOf(paramAnonymousFile1.lastModified()));
      }
    });
    return arrayOfFile;
  }
  
  public static ArrayList<String> ExtractReastoreFileNames(File[] paramArrayOfFile)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfFile.length);
    int k = _ZipFileName.length();
    int m = ".bpbak".length();
    int n = paramArrayOfFile.length;
    int i = 0;
    if (i >= n) {
      return localArrayList;
    }
    String str = paramArrayOfFile[i].getName();
    if (str.startsWith(_ZipFileName)) {}
    for (int j = k;; j = 0)
    {
      localArrayList.add(str.substring(j, str.length() - m));
      i += 1;
      break;
    }
  }
  
  /* Error */
  private static void RestoreBackup(File paramFile, BackupRestoreOperationResult paramBackupRestoreOperationResult)
  {
    // Byte code:
    //   0: getstatic 56	mobi/beyondpod/rsscore/BackupRestore:TAG	Ljava/lang/String;
    //   3: new 128	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 269
    //   10: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   17: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: invokestatic 123	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: new 77	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: ldc_w 274
    //   31: invokespecial 201	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   34: astore_2
    //   35: new 276	mobi/beyondpod/rsscore/BackupManifest
    //   38: dup
    //   39: aload_2
    //   40: invokespecial 277	mobi/beyondpod/rsscore/BackupManifest:<init>	(Ljava/io/File;)V
    //   43: astore_3
    //   44: getstatic 56	mobi/beyondpod/rsscore/BackupRestore:TAG	Ljava/lang/String;
    //   47: new 128	java/lang/StringBuilder
    //   50: dup
    //   51: ldc_w 279
    //   54: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: aload_3
    //   58: invokevirtual 280	mobi/beyondpod/rsscore/BackupManifest:toString	()Ljava/lang/String;
    //   61: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 123	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: invokestatic 283	mobi/beyondpod/rsscore/StartupContentBuilder:RestoreFromRepositoryShapshot	()Z
    //   73: ifne +20 -> 93
    //   76: aload_1
    //   77: bipush -3
    //   79: ldc_w 285
    //   82: invokeinterface 149 3 0
    //   87: aload_0
    //   88: invokestatic 158	mobi/beyondpod/rsscore/BackupRestore:ClearDirectory	(Ljava/io/File;)Z
    //   91: pop
    //   92: return
    //   93: getstatic 56	mobi/beyondpod/rsscore/BackupRestore:TAG	Ljava/lang/String;
    //   96: ldc_w 287
    //   99: invokestatic 123	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: getstatic 56	mobi/beyondpod/rsscore/BackupRestore:TAG	Ljava/lang/String;
    //   105: ldc_w 289
    //   108: invokestatic 123	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: invokestatic 292	mobi/beyondpod/rsscore/StartupContentBuilder:PatchDatabaseAfterRestore	()V
    //   114: getstatic 56	mobi/beyondpod/rsscore/BackupRestore:TAG	Ljava/lang/String;
    //   117: ldc_w 294
    //   120: invokestatic 123	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_1
    //   124: iconst_3
    //   125: aload_2
    //   126: invokevirtual 167	java/io/File:getPath	()Ljava/lang/String;
    //   129: aload_3
    //   130: invokeinterface 217 4 0
    //   135: goto -48 -> 87
    //   138: astore_2
    //   139: getstatic 56	mobi/beyondpod/rsscore/BackupRestore:TAG	Ljava/lang/String;
    //   142: new 128	java/lang/StringBuilder
    //   145: dup
    //   146: ldc_w 296
    //   149: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload_2
    //   153: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   156: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 123	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_1
    //   166: bipush -3
    //   168: aload_2
    //   169: invokevirtual 229	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   172: invokeinterface 149 3 0
    //   177: aload_0
    //   178: invokestatic 158	mobi/beyondpod/rsscore/BackupRestore:ClearDirectory	(Ljava/io/File;)Z
    //   181: pop
    //   182: return
    //   183: astore_1
    //   184: aload_0
    //   185: invokestatic 158	mobi/beyondpod/rsscore/BackupRestore:ClearDirectory	(Ljava/io/File;)Z
    //   188: pop
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramFile	File
    //   0	191	1	paramBackupRestoreOperationResult	BackupRestoreOperationResult
    //   34	92	2	localFile	File
    //   138	31	2	localException	Exception
    //   43	87	3	localBackupManifest	BackupManifest
    // Exception table:
    //   from	to	target	type
    //   35	87	138	java/lang/Exception
    //   93	135	138	java/lang/Exception
    //   35	87	183	finally
    //   93	135	183	finally
    //   139	177	183	finally
  }
  
  public static void RestoreBackup(final BackupRestoreOperationResult paramBackupRestoreOperationResult)
  {
    if ((_Worker != null) && (_Worker.isAlive())) {
      if (paramBackupRestoreOperationResult != null) {
        paramBackupRestoreOperationResult.OperationFailed(-4, "");
      }
    }
    File localFile;
    do
    {
      return;
      localFile = new File(Configuration.BackupManagerBackupPath());
      if (localFile.exists()) {
        break;
      }
    } while (paramBackupRestoreOperationResult == null);
    paramBackupRestoreOperationResult.OperationFailed(-3, "Invalid shanpshot folder");
    return;
    _Worker = new Thread(new Runnable()
    {
      public void run()
      {
        BackupRestore.RestoreBackup(BackupRestore.this, paramBackupRestoreOperationResult);
      }
    }, TAG);
    _Worker.start();
  }
  
  public static void UnzipBackup(File paramFile, final BackupRestoreOperationResult paramBackupRestoreOperationResult)
  {
    if ((_Worker != null) && (_Worker.isAlive())) {
      if (paramBackupRestoreOperationResult != null) {
        paramBackupRestoreOperationResult.OperationFailed(-4, "");
      }
    }
    do
    {
      return;
      if ((paramFile != null) && (paramFile.exists())) {
        break;
      }
    } while (paramBackupRestoreOperationResult == null);
    paramBackupRestoreOperationResult.OperationFailed(-3, "Invalid restore file");
    return;
    _Worker = new Thread(new Runnable()
    {
      public void run()
      {
        BackupRestore.UnzipBackupInternal(BackupRestore.this, paramBackupRestoreOperationResult);
      }
    }, TAG);
    _Worker.start();
  }
  
  /* Error */
  private static BackupManifest UnzipBackupFiles(File paramFile1, File paramFile2)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 88	java/io/File:exists	()Z
    //   4: ifne +14 -> 18
    //   7: new 308	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc_w 310
    //   14: invokespecial 311	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_1
    //   19: invokevirtual 88	java/io/File:exists	()Z
    //   22: ifne +14 -> 36
    //   25: new 308	java/lang/IllegalArgumentException
    //   28: dup
    //   29: ldc_w 313
    //   32: invokespecial 311	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   35: athrow
    //   36: aconst_null
    //   37: astore 4
    //   39: aconst_null
    //   40: astore_3
    //   41: getstatic 62	mobi/beyondpod/rsscore/BackupRestore:BuffSize	I
    //   44: newarray <illegal type>
    //   46: astore 7
    //   48: new 315	java/util/zip/ZipFile
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 316	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   56: astore 8
    //   58: aload 4
    //   60: astore_3
    //   61: aload 8
    //   63: ldc_w 274
    //   66: invokevirtual 320	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   69: astore 6
    //   71: aload 6
    //   73: ifnull +248 -> 321
    //   76: aload 4
    //   78: astore_3
    //   79: new 77	java/io/File
    //   82: dup
    //   83: aload_1
    //   84: ldc_w 274
    //   87: invokespecial 201	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   90: astore_0
    //   91: new 322	java/io/BufferedOutputStream
    //   94: dup
    //   95: new 324	java/io/FileOutputStream
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 325	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   103: getstatic 62	mobi/beyondpod/rsscore/BackupRestore:BuffSize	I
    //   106: invokespecial 328	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   109: astore 5
    //   111: new 330	java/io/BufferedInputStream
    //   114: dup
    //   115: aload 8
    //   117: aload 6
    //   119: invokevirtual 334	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   122: getstatic 62	mobi/beyondpod/rsscore/BackupRestore:BuffSize	I
    //   125: invokespecial 337	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   128: astore 4
    //   130: aload_0
    //   131: astore_3
    //   132: aload 4
    //   134: astore 6
    //   136: aload 5
    //   138: astore 6
    //   140: aload 4
    //   142: aload 7
    //   144: iconst_0
    //   145: getstatic 62	mobi/beyondpod/rsscore/BackupRestore:BuffSize	I
    //   148: invokevirtual 341	java/io/BufferedInputStream:read	([BII)I
    //   151: istore_2
    //   152: iload_2
    //   153: iconst_m1
    //   154: if_icmpne +127 -> 281
    //   157: aload_0
    //   158: astore_3
    //   159: aload 4
    //   161: astore 6
    //   163: aload 5
    //   165: astore 6
    //   167: aload 5
    //   169: invokevirtual 344	java/io/BufferedOutputStream:close	()V
    //   172: aload_0
    //   173: astore_3
    //   174: aload 4
    //   176: astore 6
    //   178: aload 5
    //   180: astore 6
    //   182: aload 4
    //   184: invokevirtual 345	java/io/BufferedInputStream:close	()V
    //   187: aload_0
    //   188: astore_3
    //   189: aload 4
    //   191: astore 6
    //   193: aload 5
    //   195: astore 6
    //   197: new 276	mobi/beyondpod/rsscore/BackupManifest
    //   200: dup
    //   201: aload_0
    //   202: invokespecial 277	mobi/beyondpod/rsscore/BackupManifest:<init>	(Ljava/io/File;)V
    //   205: astore 9
    //   207: aload_0
    //   208: astore_3
    //   209: aload 4
    //   211: astore 6
    //   213: aload 5
    //   215: astore 6
    //   217: aload 8
    //   219: invokevirtual 349	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   222: invokestatic 354	java/util/Collections:list	(Ljava/util/Enumeration;)Ljava/util/ArrayList;
    //   225: invokevirtual 358	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   228: astore 10
    //   230: aload_0
    //   231: astore_3
    //   232: aload 4
    //   234: astore 6
    //   236: aload 5
    //   238: astore 6
    //   240: aload 10
    //   242: invokeinterface 363 1 0
    //   247: ifne +94 -> 341
    //   250: aload_0
    //   251: astore_3
    //   252: aload 4
    //   254: astore 6
    //   256: aload 5
    //   258: astore 6
    //   260: aload 8
    //   262: invokevirtual 364	java/util/zip/ZipFile:close	()V
    //   265: iconst_1
    //   266: ifne +12 -> 278
    //   269: aload_0
    //   270: ifnull +8 -> 278
    //   273: aload_0
    //   274: invokevirtual 126	java/io/File:delete	()Z
    //   277: pop
    //   278: aload 9
    //   280: areturn
    //   281: aload_0
    //   282: astore_3
    //   283: aload 4
    //   285: astore 6
    //   287: aload 5
    //   289: astore 6
    //   291: aload 5
    //   293: aload 7
    //   295: iconst_0
    //   296: iload_2
    //   297: invokevirtual 368	java/io/BufferedOutputStream:write	([BII)V
    //   300: goto -170 -> 130
    //   303: astore_0
    //   304: aload_3
    //   305: astore_1
    //   306: iconst_0
    //   307: ifne +12 -> 319
    //   310: aload_1
    //   311: ifnull +8 -> 319
    //   314: aload_1
    //   315: invokevirtual 126	java/io/File:delete	()Z
    //   318: pop
    //   319: aload_0
    //   320: athrow
    //   321: aload 4
    //   323: astore_3
    //   324: new 308	java/lang/IllegalArgumentException
    //   327: dup
    //   328: ldc_w 370
    //   331: invokespecial 311	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   334: athrow
    //   335: astore_0
    //   336: aload_3
    //   337: astore_1
    //   338: goto -32 -> 306
    //   341: aload_0
    //   342: astore_3
    //   343: aload 4
    //   345: astore 6
    //   347: aload 5
    //   349: astore 6
    //   351: aload 10
    //   353: invokeinterface 374 1 0
    //   358: checkcast 376	java/util/zip/ZipEntry
    //   361: astore 11
    //   363: aload_0
    //   364: astore_3
    //   365: aload 4
    //   367: astore 6
    //   369: aload 5
    //   371: astore 6
    //   373: aload 11
    //   375: invokevirtual 377	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   378: astore 12
    //   380: aload_0
    //   381: astore_3
    //   382: aload 4
    //   384: astore 6
    //   386: aload 5
    //   388: astore 6
    //   390: aload 12
    //   392: ldc_w 274
    //   395: invokevirtual 380	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   398: ifne -168 -> 230
    //   401: aload_0
    //   402: astore_3
    //   403: aload 4
    //   405: astore 6
    //   407: aload 5
    //   409: astore 6
    //   411: new 77	java/io/File
    //   414: dup
    //   415: aload_1
    //   416: aload 12
    //   418: invokespecial 201	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   421: astore_0
    //   422: new 322	java/io/BufferedOutputStream
    //   425: dup
    //   426: new 324	java/io/FileOutputStream
    //   429: dup
    //   430: aload_0
    //   431: invokespecial 325	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   434: getstatic 62	mobi/beyondpod/rsscore/BackupRestore:BuffSize	I
    //   437: invokespecial 328	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   440: astore 5
    //   442: new 330	java/io/BufferedInputStream
    //   445: dup
    //   446: aload 8
    //   448: aload 11
    //   450: invokevirtual 334	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   453: getstatic 62	mobi/beyondpod/rsscore/BackupRestore:BuffSize	I
    //   456: invokespecial 337	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   459: astore 4
    //   461: aload_0
    //   462: astore_3
    //   463: aload 4
    //   465: aload 7
    //   467: iconst_0
    //   468: getstatic 62	mobi/beyondpod/rsscore/BackupRestore:BuffSize	I
    //   471: invokevirtual 341	java/io/BufferedInputStream:read	([BII)I
    //   474: istore_2
    //   475: iload_2
    //   476: iconst_m1
    //   477: if_icmpne +54 -> 531
    //   480: aload_0
    //   481: astore_3
    //   482: aload 4
    //   484: invokevirtual 345	java/io/BufferedInputStream:close	()V
    //   487: aload_0
    //   488: astore_3
    //   489: aload 5
    //   491: invokevirtual 344	java/io/BufferedOutputStream:close	()V
    //   494: aload_0
    //   495: astore_3
    //   496: getstatic 56	mobi/beyondpod/rsscore/BackupRestore:TAG	Ljava/lang/String;
    //   499: new 128	java/lang/StringBuilder
    //   502: dup
    //   503: ldc_w 279
    //   506: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   509: aload_0
    //   510: invokevirtual 134	java/io/File:getName	()Ljava/lang/String;
    //   513: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc_w 382
    //   519: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 123	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: goto -298 -> 230
    //   531: aload_0
    //   532: astore_3
    //   533: aload 5
    //   535: aload 7
    //   537: iconst_0
    //   538: iload_2
    //   539: invokevirtual 368	java/io/BufferedOutputStream:write	([BII)V
    //   542: goto -81 -> 461
    //   545: astore_0
    //   546: aload_3
    //   547: astore_1
    //   548: goto -242 -> 306
    //   551: astore_3
    //   552: aload_0
    //   553: astore_1
    //   554: aload_3
    //   555: astore_0
    //   556: goto -250 -> 306
    //   559: astore_3
    //   560: aload_0
    //   561: astore_1
    //   562: aload_3
    //   563: astore_0
    //   564: goto -258 -> 306
    //   567: astore_3
    //   568: aload_0
    //   569: astore_1
    //   570: aload_3
    //   571: astore_0
    //   572: goto -266 -> 306
    //   575: astore_3
    //   576: aload_0
    //   577: astore_1
    //   578: aload_3
    //   579: astore_0
    //   580: goto -274 -> 306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	paramFile1	File
    //   0	583	1	paramFile2	File
    //   151	388	2	i	int
    //   40	507	3	localObject1	Object
    //   551	4	3	localObject2	Object
    //   559	4	3	localObject3	Object
    //   567	4	3	localObject4	Object
    //   575	4	3	localObject5	Object
    //   37	446	4	localBufferedInputStream	BufferedInputStream
    //   109	425	5	localBufferedOutputStream	BufferedOutputStream
    //   69	341	6	localObject6	Object
    //   46	490	7	arrayOfByte	byte[]
    //   56	391	8	localZipFile	java.util.zip.ZipFile
    //   205	74	9	localBackupManifest	BackupManifest
    //   228	124	10	localIterator	Iterator
    //   361	88	11	localZipEntry	ZipEntry
    //   378	39	12	str	String
    // Exception table:
    //   from	to	target	type
    //   140	152	303	finally
    //   167	172	303	finally
    //   182	187	303	finally
    //   197	207	303	finally
    //   217	230	303	finally
    //   240	250	303	finally
    //   260	265	303	finally
    //   291	300	303	finally
    //   351	363	303	finally
    //   373	380	303	finally
    //   390	401	303	finally
    //   411	422	303	finally
    //   61	71	335	finally
    //   79	91	335	finally
    //   324	335	335	finally
    //   463	475	335	finally
    //   482	487	335	finally
    //   489	494	335	finally
    //   496	528	335	finally
    //   533	542	335	finally
    //   48	58	545	finally
    //   91	111	551	finally
    //   111	130	559	finally
    //   422	442	567	finally
    //   442	461	575	finally
  }
  
  private static void UnzipBackupInternal(File paramFile, BackupRestoreOperationResult paramBackupRestoreOperationResult)
  {
    CoreHelper.WriteTraceEntry(TAG, "Preparing restore of " + paramFile);
    File localFile = new File(Configuration.BackupManagerBackupPath());
    if (localFile.exists())
    {
      ClearDirectory(localFile);
      if (localFile.list().length > 0) {
        paramBackupRestoreOperationResult.OperationFailed(-2, "Failed to empty backup snapshot folder " + localFile.getPath());
      }
    }
    else if (!localFile.mkdirs())
    {
      paramBackupRestoreOperationResult.OperationFailed(-2, "Failed to create backup snapshot folder " + localFile.getPath());
      return;
    }
    try
    {
      paramFile = UnzipBackupFiles(paramFile, localFile);
      CoreHelper.WriteTraceEntry(TAG, "Prepare complete!");
      paramBackupRestoreOperationResult.OperationCompleted(1, "", paramFile);
      return;
    }
    catch (Exception paramFile)
    {
      CoreHelper.WriteLogEntry(TAG, "Prepare failed! Reason: " + paramFile.getMessage());
      paramBackupRestoreOperationResult.OperationFailed(-2, paramFile.getMessage());
    }
  }
  
  private static BackupManifest ZipBackupFiles(File paramFile, String paramString)
    throws Exception
  {
    if (FileUtils.Exists(paramString)) {
      throw new IllegalArgumentException("Destination backup file " + paramString + " already exists!");
    }
    Object localObject1 = paramFile.listFiles();
    if (localObject1.length == 0) {
      throw new IllegalArgumentException("There is nothing to compress!");
    }
    paramFile = BackupManifest.CreateManifest(paramFile.getPath(), (File[])localObject1);
    if (paramFile == null) {
      throw new IOException("Unable to create backup manifest!");
    }
    Object localObject2 = new ArrayList(localObject1.length + 1);
    ((ArrayList)localObject2).add(paramFile);
    int j = localObject1.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        paramString = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(new File(paramString))));
        localObject1 = new byte[BuffSize];
        localObject2 = ((ArrayList)localObject2).iterator();
        if (((Iterator)localObject2).hasNext()) {
          break;
        }
        paramString.close();
        return new BackupManifest(paramFile);
      }
      ((ArrayList)localObject2).add(localObject1[i]);
      i += 1;
    }
    File localFile = (File)((Iterator)localObject2).next();
    CoreHelper.WriteTraceEntry(TAG, "Compressing " + localFile.getName() + "...");
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(localFile), BuffSize);
    paramString.putNextEntry(new ZipEntry(localFile.getName()));
    for (;;)
    {
      i = localBufferedInputStream.read((byte[])localObject1, 0, BuffSize);
      if (i == -1)
      {
        localBufferedInputStream.close();
        break;
      }
      paramString.write((byte[])localObject1, 0, i);
    }
  }
  
  public static abstract interface BackupRestoreOperationResult
  {
    public abstract void OperationCompleted(int paramInt, String paramString, BackupManifest paramBackupManifest);
    
    public abstract void OperationFailed(int paramInt, String paramString);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/BackupRestore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */