package mobi.beyondpod.rsscore;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.R.raw;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.FileUtils;
import mobi.beyondpod.rsscore.repository.DatabaseHelper;
import mobi.beyondpod.rsscore.repository.RepositoryPersistence;
import mobi.beyondpod.rsscore.rss.ItemStateHistory;

public class StartupContentBuilder
{
  private static final String TAG = StartupContentBuilder.class.getSimpleName();
  private static boolean _RepositoryBackupInProgress = false;
  private static Runnable _RepositoryBackupRunnable = new Runnable()
  {
    public void run() {}
  };
  private static boolean _RepositorySnapshotInProgress = false;
  Content[] _DemoContent = BeyondPodApplication.GetInstance().GetDemoContent();
  Content[] _PermanentContent = { new Content(R.raw.seed_trackstate, new File(Configuration.TrackStateBackupPath())), new Content(R.raw.nomedia, new File(Configuration.RssImageCachePath(), ".nomedia")) };
  
  public static void BackupRepositoriesAsync()
  {
    RepositoryPersistence.RepositoryHandler().removeCallbacks(_RepositoryBackupRunnable);
    RepositoryPersistence.RepositoryHandler().post(_RepositoryBackupRunnable);
  }
  
  /* Error */
  private static void BackupRepositoriesInternal()
  {
    // Byte code:
    //   0: getstatic 36	mobi/beyondpod/rsscore/StartupContentBuilder:_RepositoryBackupInProgress	Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: iconst_1
    //   8: putstatic 36	mobi/beyondpod/rsscore/StartupContentBuilder:_RepositoryBackupInProgress	Z
    //   11: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   14: lstore_1
    //   15: new 112	mobi/beyondpod/rsscore/repository/XMLRepositoryStorage
    //   18: dup
    //   19: invokespecial 113	mobi/beyondpod/rsscore/repository/XMLRepositoryStorage:<init>	()V
    //   22: invokestatic 53	mobi/beyondpod/rsscore/Configuration:TrackStateBackupPath	()Ljava/lang/String;
    //   25: invokevirtual 116	mobi/beyondpod/rsscore/repository/XMLRepositoryStorage:BackupRepositoryToFile	(Ljava/lang/String;)V
    //   28: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   31: new 118	java/lang/StringBuilder
    //   34: dup
    //   35: ldc 120
    //   37: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   43: lload_1
    //   44: lsub
    //   45: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   48: ldc 127
    //   50: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: invokestatic 144	mobi/beyondpod/rsscore/rss/LicenseManager:CurrentLicenseKind	()I
    //   62: istore_0
    //   63: iload_0
    //   64: ifeq +313 -> 377
    //   67: iload_0
    //   68: iconst_5
    //   69: if_icmpeq +308 -> 377
    //   72: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   75: lstore_1
    //   76: invokestatic 149	mobi/beyondpod/rsscore/repository/DatabaseHelper:DatabasePath	()Ljava/lang/String;
    //   79: invokestatic 152	mobi/beyondpod/rsscore/Configuration:DatabaseBackupFilePath	()Ljava/lang/String;
    //   82: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   85: ifeq +268 -> 353
    //   88: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   91: new 118	java/lang/StringBuilder
    //   94: dup
    //   95: ldc -96
    //   97: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   103: lload_1
    //   104: lsub
    //   105: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   108: ldc 127
    //   110: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: invokestatic 163	mobi/beyondpod/rsscore/Configuration:ItemHistoryFilePath	()Ljava/lang/String;
    //   122: invokestatic 167	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   125: ifeq +48 -> 173
    //   128: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   131: lstore_1
    //   132: invokestatic 163	mobi/beyondpod/rsscore/Configuration:ItemHistoryFilePath	()Ljava/lang/String;
    //   135: invokestatic 170	mobi/beyondpod/rsscore/Configuration:ItemHistoryBackupFilePath	()Ljava/lang/String;
    //   138: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   141: pop
    //   142: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   145: new 118	java/lang/StringBuilder
    //   148: dup
    //   149: ldc -84
    //   151: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   157: lload_1
    //   158: lsub
    //   159: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   162: ldc 127
    //   164: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: invokestatic 175	mobi/beyondpod/rsscore/Configuration:EnclosureDownloadHistoryFilePath	()Ljava/lang/String;
    //   176: invokestatic 167	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   179: ifeq +48 -> 227
    //   182: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   185: lstore_1
    //   186: invokestatic 175	mobi/beyondpod/rsscore/Configuration:EnclosureDownloadHistoryFilePath	()Ljava/lang/String;
    //   189: invokestatic 178	mobi/beyondpod/rsscore/Configuration:EnclosureDownloadHistoryBackupFilePath	()Ljava/lang/String;
    //   192: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   195: pop
    //   196: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   199: new 118	java/lang/StringBuilder
    //   202: dup
    //   203: ldc -76
    //   205: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   208: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   211: lload_1
    //   212: lsub
    //   213: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   216: ldc 127
    //   218: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: invokestatic 183	mobi/beyondpod/rsscore/Configuration:SmartPlaylistFilePath	()Ljava/lang/String;
    //   230: invokestatic 167	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   233: ifeq +48 -> 281
    //   236: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   239: lstore_1
    //   240: invokestatic 183	mobi/beyondpod/rsscore/Configuration:SmartPlaylistFilePath	()Ljava/lang/String;
    //   243: invokestatic 186	mobi/beyondpod/rsscore/Configuration:SmartPlaylistBackupFilePath	()Ljava/lang/String;
    //   246: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   249: pop
    //   250: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   253: new 118	java/lang/StringBuilder
    //   256: dup
    //   257: ldc -68
    //   259: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   262: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   265: lload_1
    //   266: lsub
    //   267: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   270: ldc 127
    //   272: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: invokestatic 191	mobi/beyondpod/rsscore/Configuration:PlaylistFilePath	()Ljava/lang/String;
    //   284: invokestatic 167	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   287: ifeq +48 -> 335
    //   290: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   293: lstore_1
    //   294: invokestatic 191	mobi/beyondpod/rsscore/Configuration:PlaylistFilePath	()Ljava/lang/String;
    //   297: invokestatic 194	mobi/beyondpod/rsscore/Configuration:PlaylistBackupFilePath	()Ljava/lang/String;
    //   300: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   303: pop
    //   304: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   307: new 118	java/lang/StringBuilder
    //   310: dup
    //   311: ldc -60
    //   313: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   319: lload_1
    //   320: lsub
    //   321: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   324: ldc 127
    //   326: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: iconst_0
    //   336: putstatic 36	mobi/beyondpod/rsscore/StartupContentBuilder:_RepositoryBackupInProgress	Z
    //   339: return
    //   340: astore_3
    //   341: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   344: ldc -58
    //   346: aload_3
    //   347: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   350: goto -291 -> 59
    //   353: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   356: ldc -52
    //   358: invokestatic 207	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: goto -242 -> 119
    //   364: astore_3
    //   365: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   368: ldc -47
    //   370: aload_3
    //   371: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   374: goto -255 -> 119
    //   377: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   380: ldc -45
    //   382: invokestatic 207	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: goto -266 -> 119
    //   388: astore_3
    //   389: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   392: ldc -43
    //   394: aload_3
    //   395: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   398: goto -225 -> 173
    //   401: astore_3
    //   402: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   405: ldc -41
    //   407: aload_3
    //   408: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   411: goto -184 -> 227
    //   414: astore_3
    //   415: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   418: ldc -39
    //   420: aload_3
    //   421: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   424: goto -143 -> 281
    //   427: astore_3
    //   428: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   431: ldc -37
    //   433: aload_3
    //   434: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   437: goto -102 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   62	8	0	i	int
    //   14	306	1	l	long
    //   340	7	3	localException1	Exception
    //   364	7	3	localException2	Exception
    //   388	7	3	localException3	Exception
    //   401	7	3	localException4	Exception
    //   414	7	3	localException5	Exception
    //   427	7	3	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   11	59	340	java/lang/Exception
    //   72	119	364	java/lang/Exception
    //   353	361	364	java/lang/Exception
    //   128	173	388	java/lang/Exception
    //   182	227	401	java/lang/Exception
    //   236	281	414	java/lang/Exception
    //   290	335	427	java/lang/Exception
  }
  
  public static void BackupRepositoriesSync() {}
  
  /* Error */
  public static boolean CreateRepositorySnapshot()
  {
    // Byte code:
    //   0: getstatic 38	mobi/beyondpod/rsscore/StartupContentBuilder:_RepositorySnapshotInProgress	Z
    //   3: ifeq +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: iconst_1
    //   9: putstatic 38	mobi/beyondpod/rsscore/StartupContentBuilder:_RepositorySnapshotInProgress	Z
    //   12: iconst_1
    //   13: istore_1
    //   14: invokestatic 227	mobi/beyondpod/rsscore/Configuration:SettingsFilePath	()Ljava/lang/String;
    //   17: invokestatic 167	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   20: ifeq +370 -> 390
    //   23: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   26: lstore_2
    //   27: invokestatic 227	mobi/beyondpod/rsscore/Configuration:SettingsFilePath	()Ljava/lang/String;
    //   30: invokestatic 230	mobi/beyondpod/rsscore/Configuration:SettingsBackupManagerFilePath	()Ljava/lang/String;
    //   33: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   36: pop
    //   37: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   40: new 118	java/lang/StringBuilder
    //   43: dup
    //   44: ldc -24
    //   46: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   52: lload_2
    //   53: lsub
    //   54: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   57: ldc 127
    //   59: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: new 146	mobi/beyondpod/rsscore/repository/DatabaseHelper
    //   71: dup
    //   72: invokestatic 78	mobi/beyondpod/BeyondPodApplication:GetInstance	()Lmobi/beyondpod/BeyondPodApplication;
    //   75: invokevirtual 236	mobi/beyondpod/BeyondPodApplication:getApplicationContext	()Landroid/content/Context;
    //   78: invokespecial 239	mobi/beyondpod/rsscore/repository/DatabaseHelper:<init>	(Landroid/content/Context;)V
    //   81: invokevirtual 242	mobi/beyondpod/rsscore/repository/DatabaseHelper:cleanup	()V
    //   84: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   87: lstore_2
    //   88: invokestatic 149	mobi/beyondpod/rsscore/repository/DatabaseHelper:DatabasePath	()Ljava/lang/String;
    //   91: invokestatic 245	mobi/beyondpod/rsscore/Configuration:DatabaseBackupManagerFilePath	()Ljava/lang/String;
    //   94: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   97: ifeq +327 -> 424
    //   100: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   103: new 118	java/lang/StringBuilder
    //   106: dup
    //   107: ldc -9
    //   109: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   115: lload_2
    //   116: lsub
    //   117: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   120: ldc 127
    //   122: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: iload_1
    //   132: istore_0
    //   133: invokestatic 163	mobi/beyondpod/rsscore/Configuration:ItemHistoryFilePath	()Ljava/lang/String;
    //   136: invokestatic 167	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   139: ifeq +50 -> 189
    //   142: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   145: lstore_2
    //   146: invokestatic 163	mobi/beyondpod/rsscore/Configuration:ItemHistoryFilePath	()Ljava/lang/String;
    //   149: invokestatic 250	mobi/beyondpod/rsscore/Configuration:ItemHistoryBackupManagerFilePath	()Ljava/lang/String;
    //   152: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   155: pop
    //   156: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   159: new 118	java/lang/StringBuilder
    //   162: dup
    //   163: ldc -4
    //   165: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   168: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   171: lload_2
    //   172: lsub
    //   173: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   176: ldc 127
    //   178: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: iload_1
    //   188: istore_0
    //   189: iload_0
    //   190: istore_1
    //   191: invokestatic 175	mobi/beyondpod/rsscore/Configuration:EnclosureDownloadHistoryFilePath	()Ljava/lang/String;
    //   194: invokestatic 167	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   197: ifeq +51 -> 248
    //   200: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   203: lstore_2
    //   204: invokestatic 175	mobi/beyondpod/rsscore/Configuration:EnclosureDownloadHistoryFilePath	()Ljava/lang/String;
    //   207: invokestatic 255	mobi/beyondpod/rsscore/Configuration:EnclosureDownloadHistoryBackupManagerFilePath	()Ljava/lang/String;
    //   210: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   213: pop
    //   214: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   217: new 118	java/lang/StringBuilder
    //   220: dup
    //   221: ldc_w 257
    //   224: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   227: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   230: lload_2
    //   231: lsub
    //   232: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   235: ldc 127
    //   237: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: iload_0
    //   247: istore_1
    //   248: iload_1
    //   249: istore_0
    //   250: invokestatic 183	mobi/beyondpod/rsscore/Configuration:SmartPlaylistFilePath	()Ljava/lang/String;
    //   253: invokestatic 167	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   256: ifeq +51 -> 307
    //   259: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   262: lstore_2
    //   263: invokestatic 183	mobi/beyondpod/rsscore/Configuration:SmartPlaylistFilePath	()Ljava/lang/String;
    //   266: invokestatic 260	mobi/beyondpod/rsscore/Configuration:SmartPlaylistBackupManagerFilePath	()Ljava/lang/String;
    //   269: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   272: pop
    //   273: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   276: new 118	java/lang/StringBuilder
    //   279: dup
    //   280: ldc_w 262
    //   283: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   286: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   289: lload_2
    //   290: lsub
    //   291: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   294: ldc 127
    //   296: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: iload_1
    //   306: istore_0
    //   307: iload_0
    //   308: istore_1
    //   309: invokestatic 191	mobi/beyondpod/rsscore/Configuration:PlaylistFilePath	()Ljava/lang/String;
    //   312: invokestatic 167	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   315: ifeq +51 -> 366
    //   318: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   321: lstore_2
    //   322: invokestatic 191	mobi/beyondpod/rsscore/Configuration:PlaylistFilePath	()Ljava/lang/String;
    //   325: invokestatic 265	mobi/beyondpod/rsscore/Configuration:PlaylistBackupManagerFilePath	()Ljava/lang/String;
    //   328: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   331: pop
    //   332: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   335: new 118	java/lang/StringBuilder
    //   338: dup
    //   339: ldc_w 267
    //   342: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   345: invokestatic 110	java/lang/System:currentTimeMillis	()J
    //   348: lload_2
    //   349: lsub
    //   350: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   353: ldc 127
    //   355: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: iload_0
    //   365: istore_1
    //   366: iconst_0
    //   367: putstatic 38	mobi/beyondpod/rsscore/StartupContentBuilder:_RepositorySnapshotInProgress	Z
    //   370: iload_1
    //   371: ireturn
    //   372: astore 4
    //   374: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   377: ldc_w 269
    //   380: aload 4
    //   382: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   385: iconst_0
    //   386: istore_1
    //   387: goto -319 -> 68
    //   390: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   393: new 118	java/lang/StringBuilder
    //   396: dup
    //   397: ldc_w 271
    //   400: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   403: invokestatic 227	mobi/beyondpod/rsscore/Configuration:SettingsFilePath	()Ljava/lang/String;
    //   406: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc_w 273
    //   412: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   421: goto -353 -> 68
    //   424: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   427: ldc_w 275
    //   430: invokestatic 207	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: goto -302 -> 131
    //   436: astore 4
    //   438: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   441: ldc_w 277
    //   444: aload 4
    //   446: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   449: goto -318 -> 131
    //   452: astore 4
    //   454: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   457: ldc_w 279
    //   460: aload 4
    //   462: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   465: iconst_0
    //   466: istore_0
    //   467: goto -278 -> 189
    //   470: astore 4
    //   472: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   475: ldc_w 281
    //   478: aload 4
    //   480: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   483: iconst_0
    //   484: istore_1
    //   485: goto -237 -> 248
    //   488: astore 4
    //   490: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   493: ldc_w 283
    //   496: aload 4
    //   498: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   501: iconst_0
    //   502: istore_0
    //   503: goto -196 -> 307
    //   506: astore 4
    //   508: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   511: ldc_w 285
    //   514: aload 4
    //   516: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   519: iconst_0
    //   520: istore_1
    //   521: goto -155 -> 366
    // Local variable table:
    //   start	length	slot	name	signature
    //   132	371	0	bool1	boolean
    //   13	508	1	bool2	boolean
    //   26	323	2	l	long
    //   372	9	4	localException1	Exception
    //   436	9	4	localException2	Exception
    //   452	9	4	localException3	Exception
    //   470	9	4	localException4	Exception
    //   488	9	4	localException5	Exception
    //   506	9	4	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   23	68	372	java/lang/Exception
    //   84	131	436	java/lang/Exception
    //   424	433	436	java/lang/Exception
    //   142	187	452	java/lang/Exception
    //   200	246	470	java/lang/Exception
    //   259	305	488	java/lang/Exception
    //   318	364	506	java/lang/Exception
  }
  
  private static void DeleteAllSyncRecords(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      int i = paramSQLiteDatabase.delete("change_history", null, null);
      CoreHelper.WriteTraceEntry(TAG, "Deleted " + i + " sync records.");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      CoreHelper.WriteLogEntry(TAG, "Unable to delete sync records in restored database! Probably restoring an old database");
    }
  }
  
  public static boolean DeleteDatabase()
  {
    new DatabaseHelper(BeyondPodApplication.GetInstance().getApplicationContext()).cleanup();
    boolean bool = new File(DatabaseHelper.DatabasePath()).delete();
    if (bool)
    {
      CoreHelper.WriteTraceEntry(TAG, "BeyondPod database file was sucessfully deleted!");
      return bool;
    }
    CoreHelper.WriteTraceEntry(TAG, "Unable to delete BeyondPod database!");
    return bool;
  }
  
  public static Content[] LoadSeedFeedImages()
  {
    List localList = LoadSeedFeedImagesForLocale(BeyondPodApplication.GetInstance().getApplicationContext().getResources().getConfiguration().locale);
    if (localList.size() == 0) {
      localList.addAll(LoadSeedFeedImagesForLocale(Locale.US));
    }
    return (Content[])localList.toArray(new Content[localList.size()]);
  }
  
  private static List<Content> LoadSeedFeedImagesForFolder(String paramString)
  {
    try
    {
      String[] arrayOfString = BeyondPodApplication.GetInstance().getApplicationContext().getResources().getAssets().list(paramString);
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        i = 0;
        if (i >= j)
        {
          paramString = localArrayList2.iterator();
          if (paramString.hasNext()) {
            break label181;
          }
        }
      }
      else
      {
        return localArrayList1;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ArrayList localArrayList1;
        ArrayList localArrayList2;
        int i;
        Object localObject = null;
        continue;
        String str = localObject[i];
        if (str.startsWith("include__")) {
          localArrayList2.add(str.replace("include__", ""));
        }
        for (;;)
        {
          i += 1;
          break;
          localArrayList1.add(new Content(paramString + "/" + str, new File(Configuration.RssImageCachePath(), str.replace(".jpg", ".img"))));
        }
        label181:
        localArrayList1.addAll(LoadSeedFeedImagesForFolder((String)paramString.next()));
      }
    }
  }
  
  private static List<Content> LoadSeedFeedImagesForLocale(Locale paramLocale)
  {
    String str = "seed_feed_images" + "_" + paramLocale.toString();
    List localList2 = LoadSeedFeedImagesForFolder(str);
    List localList1 = localList2;
    if (localList2.size() == 0)
    {
      str = "seed_feed_images" + "_" + paramLocale.getLanguage();
      localList1 = LoadSeedFeedImagesForFolder(str);
    }
    if (localList1.size() > 0) {
      CoreHelper.WriteTraceEntry(TAG, "Loaded demo content from: " + str + " (Locale: " + paramLocale + ")");
    }
    for (;;)
    {
      if (localList1.size() == 0) {
        CoreHelper.WriteTraceEntry(TAG, "No demo content for locale: " + paramLocale);
      }
      return localList1;
      CoreHelper.WriteTraceEntry(TAG, "Loaded demo content from: " + "seed_feed_images");
      localList1 = LoadSeedFeedImagesForFolder("seed_feed_images");
    }
  }
  
  public static void PatchDatabaseAfterRestore()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = SQLiteDatabase.openDatabase(Configuration.DatabaseBackupFilePath(), null, 0);
      localObject1 = localSQLiteDatabase;
      localObject3 = localSQLiteDatabase;
      PatchFeedPaths(localSQLiteDatabase);
      localObject1 = localSQLiteDatabase;
      localObject3 = localSQLiteDatabase;
      PatchTrackPaths(localSQLiteDatabase);
      localObject1 = localSQLiteDatabase;
      localObject3 = localSQLiteDatabase;
      DeleteAllSyncRecords(localSQLiteDatabase);
      if (localSQLiteDatabase != null) {
        localSQLiteDatabase.close();
      }
      return;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      CoreHelper.LogException(TAG, "Unable to patch restored database!", localException);
      return;
    }
    finally
    {
      if (localObject3 != null) {
        ((SQLiteDatabase)localObject3).close();
      }
    }
  }
  
  /* Error */
  private static void PatchFeedPaths(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 11
    //   6: iconst_0
    //   7: istore 4
    //   9: iconst_0
    //   10: istore 5
    //   12: iconst_0
    //   13: istore_3
    //   14: aload 11
    //   16: astore 10
    //   18: iload 4
    //   20: istore_1
    //   21: aload 12
    //   23: astore 9
    //   25: iload 5
    //   27: istore_2
    //   28: aload_0
    //   29: invokevirtual 460	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   32: aload 11
    //   34: astore 10
    //   36: iload 4
    //   38: istore_1
    //   39: aload 12
    //   41: astore 9
    //   43: iload 5
    //   45: istore_2
    //   46: new 462	android/content/ContentValues
    //   49: dup
    //   50: invokespecial 463	android/content/ContentValues:<init>	()V
    //   53: astore 13
    //   55: aload 11
    //   57: astore 10
    //   59: iload 4
    //   61: istore_1
    //   62: aload 12
    //   64: astore 9
    //   66: iload 5
    //   68: istore_2
    //   69: aload_0
    //   70: ldc_w 465
    //   73: iconst_3
    //   74: anewarray 383	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: ldc_w 467
    //   82: aastore
    //   83: dup
    //   84: iconst_1
    //   85: ldc_w 469
    //   88: aastore
    //   89: dup
    //   90: iconst_2
    //   91: ldc_w 471
    //   94: aastore
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: aconst_null
    //   99: aconst_null
    //   100: invokevirtual 475	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   103: astore 11
    //   105: aload 11
    //   107: astore 10
    //   109: iload 4
    //   111: istore_1
    //   112: aload 11
    //   114: astore 9
    //   116: iload 5
    //   118: istore_2
    //   119: aload 11
    //   121: invokeinterface 480 1 0
    //   126: istore 6
    //   128: aload 11
    //   130: astore 10
    //   132: iload 4
    //   134: istore_1
    //   135: aload 11
    //   137: astore 9
    //   139: iload 5
    //   141: istore_2
    //   142: aload 11
    //   144: invokeinterface 483 1 0
    //   149: pop
    //   150: iconst_0
    //   151: istore 5
    //   153: iload 5
    //   155: iload 6
    //   157: if_icmplt +75 -> 232
    //   160: aload 11
    //   162: astore 10
    //   164: iload_3
    //   165: istore_1
    //   166: aload 11
    //   168: astore 9
    //   170: iload_3
    //   171: istore_2
    //   172: aload_0
    //   173: invokevirtual 486	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   176: aload_0
    //   177: invokevirtual 489	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   180: aload 11
    //   182: ifnull +20 -> 202
    //   185: aload 11
    //   187: invokeinterface 492 1 0
    //   192: ifne +10 -> 202
    //   195: aload 11
    //   197: invokeinterface 493 1 0
    //   202: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   205: new 118	java/lang/StringBuilder
    //   208: dup
    //   209: ldc_w 495
    //   212: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: iload_3
    //   216: invokevirtual 300	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: ldc_w 497
    //   222: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: return
    //   232: aload 11
    //   234: astore 10
    //   236: iload_3
    //   237: istore_1
    //   238: aload 11
    //   240: astore 9
    //   242: iload_3
    //   243: istore_2
    //   244: aload 11
    //   246: iconst_0
    //   247: invokeinterface 501 2 0
    //   252: lstore 7
    //   254: aload 11
    //   256: astore 10
    //   258: iload_3
    //   259: istore_1
    //   260: aload 11
    //   262: astore 9
    //   264: iload_3
    //   265: istore_2
    //   266: aload 11
    //   268: iconst_2
    //   269: invokeinterface 505 2 0
    //   274: ldc_w 388
    //   277: invokestatic 511	mobi/beyondpod/rsscore/helpers/StringUtils:TryParseStringFromString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   280: astore 12
    //   282: aload 11
    //   284: astore 10
    //   286: iload_3
    //   287: istore_1
    //   288: aload 11
    //   290: astore 9
    //   292: iload_3
    //   293: istore_2
    //   294: aload 12
    //   296: invokestatic 517	mobi/beyondpod/rsscore/repository/FeedRepository:PatchRootPath	(Ljava/lang/String;)Ljava/lang/String;
    //   299: astore 14
    //   301: iload_3
    //   302: istore 4
    //   304: aload 11
    //   306: astore 10
    //   308: iload_3
    //   309: istore_1
    //   310: aload 11
    //   312: astore 9
    //   314: iload_3
    //   315: istore_2
    //   316: aload 12
    //   318: aload 14
    //   320: invokestatic 520	mobi/beyondpod/rsscore/helpers/StringUtils:Equals	(Ljava/lang/String;Ljava/lang/String;)Z
    //   323: ifne +108 -> 431
    //   326: aload 11
    //   328: astore 10
    //   330: iload_3
    //   331: istore_1
    //   332: aload 11
    //   334: astore 9
    //   336: iload_3
    //   337: istore_2
    //   338: aload 13
    //   340: ldc_w 471
    //   343: aload 14
    //   345: invokevirtual 523	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: aload 11
    //   350: astore 10
    //   352: iload_3
    //   353: istore_1
    //   354: aload 11
    //   356: astore 9
    //   358: iload_3
    //   359: istore_2
    //   360: aload_0
    //   361: ldc_w 465
    //   364: aload 13
    //   366: new 118	java/lang/StringBuilder
    //   369: dup
    //   370: ldc_w 525
    //   373: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   376: lload 7
    //   378: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   381: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: aconst_null
    //   385: invokevirtual 529	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   388: iconst_1
    //   389: if_icmpeq +76 -> 465
    //   392: aload 11
    //   394: astore 10
    //   396: iload_3
    //   397: istore_1
    //   398: aload 11
    //   400: astore 9
    //   402: iload_3
    //   403: istore_2
    //   404: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   407: new 118	java/lang/StringBuilder
    //   410: dup
    //   411: ldc_w 531
    //   414: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   417: aload 12
    //   419: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   428: iload_3
    //   429: istore 4
    //   431: aload 11
    //   433: astore 10
    //   435: iload 4
    //   437: istore_1
    //   438: aload 11
    //   440: astore 9
    //   442: iload 4
    //   444: istore_2
    //   445: aload 11
    //   447: invokeinterface 534 1 0
    //   452: pop
    //   453: iload 5
    //   455: iconst_1
    //   456: iadd
    //   457: istore 5
    //   459: iload 4
    //   461: istore_3
    //   462: goto -309 -> 153
    //   465: iload_3
    //   466: iconst_1
    //   467: iadd
    //   468: istore 4
    //   470: goto -39 -> 431
    //   473: astore 11
    //   475: aload 10
    //   477: astore 9
    //   479: iload_1
    //   480: istore_2
    //   481: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   484: ldc_w 536
    //   487: aload 11
    //   489: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   492: aload_0
    //   493: invokevirtual 489	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   496: aload 10
    //   498: ifnull +20 -> 518
    //   501: aload 10
    //   503: invokeinterface 492 1 0
    //   508: ifne +10 -> 518
    //   511: aload 10
    //   513: invokeinterface 493 1 0
    //   518: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   521: new 118	java/lang/StringBuilder
    //   524: dup
    //   525: ldc_w 495
    //   528: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   531: iload_1
    //   532: invokevirtual 300	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   535: ldc_w 497
    //   538: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   547: return
    //   548: astore 10
    //   550: aload_0
    //   551: invokevirtual 489	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   554: aload 9
    //   556: ifnull +20 -> 576
    //   559: aload 9
    //   561: invokeinterface 492 1 0
    //   566: ifne +10 -> 576
    //   569: aload 9
    //   571: invokeinterface 493 1 0
    //   576: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   579: new 118	java/lang/StringBuilder
    //   582: dup
    //   583: ldc_w 495
    //   586: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   589: iload_2
    //   590: invokevirtual 300	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   593: ldc_w 497
    //   596: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   605: aload 10
    //   607: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	608	0	paramSQLiteDatabase	SQLiteDatabase
    //   20	512	1	i	int
    //   27	563	2	j	int
    //   13	455	3	k	int
    //   7	462	4	m	int
    //   10	448	5	n	int
    //   126	32	6	i1	int
    //   252	125	7	l	long
    //   23	547	9	localObject1	Object
    //   16	496	10	localCursor1	android.database.Cursor
    //   548	58	10	localObject2	Object
    //   4	442	11	localCursor2	android.database.Cursor
    //   473	15	11	localSQLException	android.database.SQLException
    //   1	417	12	str1	String
    //   53	312	13	localContentValues	android.content.ContentValues
    //   299	45	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   28	32	473	android/database/SQLException
    //   46	55	473	android/database/SQLException
    //   69	105	473	android/database/SQLException
    //   119	128	473	android/database/SQLException
    //   142	150	473	android/database/SQLException
    //   172	176	473	android/database/SQLException
    //   244	254	473	android/database/SQLException
    //   266	282	473	android/database/SQLException
    //   294	301	473	android/database/SQLException
    //   316	326	473	android/database/SQLException
    //   338	348	473	android/database/SQLException
    //   360	392	473	android/database/SQLException
    //   404	428	473	android/database/SQLException
    //   445	453	473	android/database/SQLException
    //   28	32	548	finally
    //   46	55	548	finally
    //   69	105	548	finally
    //   119	128	548	finally
    //   142	150	548	finally
    //   172	176	548	finally
    //   244	254	548	finally
    //   266	282	548	finally
    //   294	301	548	finally
    //   316	326	548	finally
    //   338	348	548	finally
    //   360	392	548	finally
    //   404	428	548	finally
    //   445	453	548	finally
    //   481	492	548	finally
  }
  
  /* Error */
  private static void PatchTrackPaths(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 11
    //   6: iconst_0
    //   7: istore 4
    //   9: iconst_0
    //   10: istore 5
    //   12: iconst_0
    //   13: istore_3
    //   14: aload 11
    //   16: astore 10
    //   18: iload 4
    //   20: istore_1
    //   21: aload 12
    //   23: astore 9
    //   25: iload 5
    //   27: istore_2
    //   28: aload_0
    //   29: invokevirtual 460	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   32: aload 11
    //   34: astore 10
    //   36: iload 4
    //   38: istore_1
    //   39: aload 12
    //   41: astore 9
    //   43: iload 5
    //   45: istore_2
    //   46: new 462	android/content/ContentValues
    //   49: dup
    //   50: invokespecial 463	android/content/ContentValues:<init>	()V
    //   53: astore 13
    //   55: aload 11
    //   57: astore 10
    //   59: iload 4
    //   61: istore_1
    //   62: aload 12
    //   64: astore 9
    //   66: iload 5
    //   68: istore_2
    //   69: aload_0
    //   70: ldc_w 538
    //   73: iconst_2
    //   74: anewarray 383	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: ldc_w 467
    //   82: aastore
    //   83: dup
    //   84: iconst_1
    //   85: ldc_w 471
    //   88: aastore
    //   89: aconst_null
    //   90: aconst_null
    //   91: aconst_null
    //   92: aconst_null
    //   93: aconst_null
    //   94: invokevirtual 475	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   97: astore 11
    //   99: aload 11
    //   101: astore 10
    //   103: iload 4
    //   105: istore_1
    //   106: aload 11
    //   108: astore 9
    //   110: iload 5
    //   112: istore_2
    //   113: aload 11
    //   115: invokeinterface 480 1 0
    //   120: istore 6
    //   122: aload 11
    //   124: astore 10
    //   126: iload 4
    //   128: istore_1
    //   129: aload 11
    //   131: astore 9
    //   133: iload 5
    //   135: istore_2
    //   136: aload 11
    //   138: invokeinterface 483 1 0
    //   143: pop
    //   144: iconst_0
    //   145: istore 5
    //   147: iload 5
    //   149: iload 6
    //   151: if_icmplt +75 -> 226
    //   154: aload 11
    //   156: astore 10
    //   158: iload_3
    //   159: istore_1
    //   160: aload 11
    //   162: astore 9
    //   164: iload_3
    //   165: istore_2
    //   166: aload_0
    //   167: invokevirtual 486	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   170: aload_0
    //   171: invokevirtual 489	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   174: aload 11
    //   176: ifnull +20 -> 196
    //   179: aload 11
    //   181: invokeinterface 492 1 0
    //   186: ifne +10 -> 196
    //   189: aload 11
    //   191: invokeinterface 493 1 0
    //   196: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   199: new 118	java/lang/StringBuilder
    //   202: dup
    //   203: ldc_w 495
    //   206: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   209: iload_3
    //   210: invokevirtual 300	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: ldc_w 540
    //   216: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: return
    //   226: aload 11
    //   228: astore 10
    //   230: iload_3
    //   231: istore_1
    //   232: aload 11
    //   234: astore 9
    //   236: iload_3
    //   237: istore_2
    //   238: aload 11
    //   240: iconst_0
    //   241: invokeinterface 501 2 0
    //   246: lstore 7
    //   248: aload 11
    //   250: astore 10
    //   252: iload_3
    //   253: istore_1
    //   254: aload 11
    //   256: astore 9
    //   258: iload_3
    //   259: istore_2
    //   260: aload 11
    //   262: iconst_1
    //   263: invokeinterface 505 2 0
    //   268: ldc_w 388
    //   271: invokestatic 511	mobi/beyondpod/rsscore/helpers/StringUtils:TryParseStringFromString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   274: astore 12
    //   276: aload 11
    //   278: astore 10
    //   280: iload_3
    //   281: istore_1
    //   282: aload 11
    //   284: astore 9
    //   286: iload_3
    //   287: istore_2
    //   288: aload 12
    //   290: invokestatic 517	mobi/beyondpod/rsscore/repository/FeedRepository:PatchRootPath	(Ljava/lang/String;)Ljava/lang/String;
    //   293: astore 14
    //   295: iload_3
    //   296: istore 4
    //   298: aload 11
    //   300: astore 10
    //   302: iload_3
    //   303: istore_1
    //   304: aload 11
    //   306: astore 9
    //   308: iload_3
    //   309: istore_2
    //   310: aload 12
    //   312: aload 14
    //   314: invokestatic 520	mobi/beyondpod/rsscore/helpers/StringUtils:Equals	(Ljava/lang/String;Ljava/lang/String;)Z
    //   317: ifne +108 -> 425
    //   320: aload 11
    //   322: astore 10
    //   324: iload_3
    //   325: istore_1
    //   326: aload 11
    //   328: astore 9
    //   330: iload_3
    //   331: istore_2
    //   332: aload 13
    //   334: ldc_w 471
    //   337: aload 14
    //   339: invokevirtual 523	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: aload 11
    //   344: astore 10
    //   346: iload_3
    //   347: istore_1
    //   348: aload 11
    //   350: astore 9
    //   352: iload_3
    //   353: istore_2
    //   354: aload_0
    //   355: ldc_w 538
    //   358: aload 13
    //   360: new 118	java/lang/StringBuilder
    //   363: dup
    //   364: ldc_w 525
    //   367: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   370: lload 7
    //   372: invokevirtual 125	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   375: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: aconst_null
    //   379: invokevirtual 529	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   382: iconst_1
    //   383: if_icmpeq +76 -> 459
    //   386: aload 11
    //   388: astore 10
    //   390: iload_3
    //   391: istore_1
    //   392: aload 11
    //   394: astore 9
    //   396: iload_3
    //   397: istore_2
    //   398: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   401: new 118	java/lang/StringBuilder
    //   404: dup
    //   405: ldc_w 542
    //   408: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   411: aload 12
    //   413: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   422: iload_3
    //   423: istore 4
    //   425: aload 11
    //   427: astore 10
    //   429: iload 4
    //   431: istore_1
    //   432: aload 11
    //   434: astore 9
    //   436: iload 4
    //   438: istore_2
    //   439: aload 11
    //   441: invokeinterface 534 1 0
    //   446: pop
    //   447: iload 5
    //   449: iconst_1
    //   450: iadd
    //   451: istore 5
    //   453: iload 4
    //   455: istore_3
    //   456: goto -309 -> 147
    //   459: iload_3
    //   460: iconst_1
    //   461: iadd
    //   462: istore 4
    //   464: goto -39 -> 425
    //   467: astore 11
    //   469: aload 10
    //   471: astore 9
    //   473: iload_1
    //   474: istore_2
    //   475: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   478: ldc_w 544
    //   481: aload 11
    //   483: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   486: aload_0
    //   487: invokevirtual 489	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   490: aload 10
    //   492: ifnull +20 -> 512
    //   495: aload 10
    //   497: invokeinterface 492 1 0
    //   502: ifne +10 -> 512
    //   505: aload 10
    //   507: invokeinterface 493 1 0
    //   512: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   515: new 118	java/lang/StringBuilder
    //   518: dup
    //   519: ldc_w 495
    //   522: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   525: iload_1
    //   526: invokevirtual 300	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   529: ldc_w 540
    //   532: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   541: return
    //   542: astore 10
    //   544: aload_0
    //   545: invokevirtual 489	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   548: aload 9
    //   550: ifnull +20 -> 570
    //   553: aload 9
    //   555: invokeinterface 492 1 0
    //   560: ifne +10 -> 570
    //   563: aload 9
    //   565: invokeinterface 493 1 0
    //   570: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   573: new 118	java/lang/StringBuilder
    //   576: dup
    //   577: ldc_w 495
    //   580: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   583: iload_2
    //   584: invokevirtual 300	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   587: ldc_w 540
    //   590: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   599: aload 10
    //   601: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	602	0	paramSQLiteDatabase	SQLiteDatabase
    //   20	506	1	i	int
    //   27	557	2	j	int
    //   13	449	3	k	int
    //   7	456	4	m	int
    //   10	442	5	n	int
    //   120	32	6	i1	int
    //   246	125	7	l	long
    //   23	541	9	localObject1	Object
    //   16	490	10	localCursor1	android.database.Cursor
    //   542	58	10	localObject2	Object
    //   4	436	11	localCursor2	android.database.Cursor
    //   467	15	11	localSQLException	android.database.SQLException
    //   1	411	12	str1	String
    //   53	306	13	localContentValues	android.content.ContentValues
    //   293	45	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   28	32	467	android/database/SQLException
    //   46	55	467	android/database/SQLException
    //   69	99	467	android/database/SQLException
    //   113	122	467	android/database/SQLException
    //   136	144	467	android/database/SQLException
    //   166	170	467	android/database/SQLException
    //   238	248	467	android/database/SQLException
    //   260	276	467	android/database/SQLException
    //   288	295	467	android/database/SQLException
    //   310	320	467	android/database/SQLException
    //   332	342	467	android/database/SQLException
    //   354	386	467	android/database/SQLException
    //   398	422	467	android/database/SQLException
    //   439	447	467	android/database/SQLException
    //   28	32	542	finally
    //   46	55	542	finally
    //   69	99	542	finally
    //   113	122	542	finally
    //   136	144	542	finally
    //   166	170	542	finally
    //   238	248	542	finally
    //   260	276	542	finally
    //   288	295	542	finally
    //   310	320	542	finally
    //   332	342	542	finally
    //   354	386	542	finally
    //   398	422	542	finally
    //   439	447	542	finally
    //   475	486	542	finally
  }
  
  /* Error */
  public static boolean RestoreFromRepositoryShapshot()
  {
    // Byte code:
    //   0: invokestatic 245	mobi/beyondpod/rsscore/Configuration:DatabaseBackupManagerFilePath	()Ljava/lang/String;
    //   3: invokestatic 167	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   6: ifeq +177 -> 183
    //   9: invokestatic 245	mobi/beyondpod/rsscore/Configuration:DatabaseBackupManagerFilePath	()Ljava/lang/String;
    //   12: invokestatic 152	mobi/beyondpod/rsscore/Configuration:DatabaseBackupFilePath	()Ljava/lang/String;
    //   15: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   18: pop
    //   19: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   22: ldc_w 547
    //   25: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: invokestatic 230	mobi/beyondpod/rsscore/Configuration:SettingsBackupManagerFilePath	()Ljava/lang/String;
    //   31: invokestatic 167	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   34: ifeq +174 -> 208
    //   37: invokestatic 230	mobi/beyondpod/rsscore/Configuration:SettingsBackupManagerFilePath	()Ljava/lang/String;
    //   40: invokestatic 227	mobi/beyondpod/rsscore/Configuration:SettingsFilePath	()Ljava/lang/String;
    //   43: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   46: pop
    //   47: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   50: ldc_w 549
    //   53: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: invokestatic 250	mobi/beyondpod/rsscore/Configuration:ItemHistoryBackupManagerFilePath	()Ljava/lang/String;
    //   59: invokestatic 167	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   62: ifeq +172 -> 234
    //   65: invokestatic 250	mobi/beyondpod/rsscore/Configuration:ItemHistoryBackupManagerFilePath	()Ljava/lang/String;
    //   68: invokestatic 163	mobi/beyondpod/rsscore/Configuration:ItemHistoryFilePath	()Ljava/lang/String;
    //   71: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   74: pop
    //   75: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   78: ldc_w 551
    //   81: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: invokestatic 255	mobi/beyondpod/rsscore/Configuration:EnclosureDownloadHistoryBackupManagerFilePath	()Ljava/lang/String;
    //   87: invokestatic 167	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   90: ifeq +170 -> 260
    //   93: invokestatic 255	mobi/beyondpod/rsscore/Configuration:EnclosureDownloadHistoryBackupManagerFilePath	()Ljava/lang/String;
    //   96: invokestatic 175	mobi/beyondpod/rsscore/Configuration:EnclosureDownloadHistoryFilePath	()Ljava/lang/String;
    //   99: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   102: pop
    //   103: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   106: ldc_w 553
    //   109: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: invokestatic 260	mobi/beyondpod/rsscore/Configuration:SmartPlaylistBackupManagerFilePath	()Ljava/lang/String;
    //   115: invokestatic 167	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   118: ifeq +168 -> 286
    //   121: invokestatic 260	mobi/beyondpod/rsscore/Configuration:SmartPlaylistBackupManagerFilePath	()Ljava/lang/String;
    //   124: invokestatic 183	mobi/beyondpod/rsscore/Configuration:SmartPlaylistFilePath	()Ljava/lang/String;
    //   127: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   130: pop
    //   131: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   134: ldc_w 555
    //   137: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: invokestatic 265	mobi/beyondpod/rsscore/Configuration:PlaylistBackupManagerFilePath	()Ljava/lang/String;
    //   143: invokestatic 167	mobi/beyondpod/rsscore/helpers/FileUtils:Exists	(Ljava/lang/String;)Z
    //   146: ifeq +166 -> 312
    //   149: invokestatic 265	mobi/beyondpod/rsscore/Configuration:PlaylistBackupManagerFilePath	()Ljava/lang/String;
    //   152: invokestatic 191	mobi/beyondpod/rsscore/Configuration:PlaylistFilePath	()Ljava/lang/String;
    //   155: invokestatic 158	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   158: pop
    //   159: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   162: ldc_w 557
    //   165: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: iconst_1
    //   169: ireturn
    //   170: astore_0
    //   171: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   174: ldc_w 559
    //   177: aload_0
    //   178: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   181: iconst_0
    //   182: ireturn
    //   183: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   186: ldc_w 561
    //   189: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: iconst_0
    //   193: ireturn
    //   194: astore_0
    //   195: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   198: ldc_w 563
    //   201: aload_0
    //   202: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: goto -149 -> 56
    //   208: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   211: ldc_w 565
    //   214: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: goto -161 -> 56
    //   220: astore_0
    //   221: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   224: ldc_w 567
    //   227: aload_0
    //   228: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   231: goto -147 -> 84
    //   234: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   237: ldc_w 569
    //   240: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: goto -159 -> 84
    //   246: astore_0
    //   247: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   250: ldc_w 571
    //   253: aload_0
    //   254: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   257: goto -145 -> 112
    //   260: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   263: ldc_w 573
    //   266: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: goto -157 -> 112
    //   272: astore_0
    //   273: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   276: ldc_w 575
    //   279: aload_0
    //   280: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   283: goto -143 -> 140
    //   286: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   289: ldc_w 577
    //   292: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: goto -155 -> 140
    //   298: astore_0
    //   299: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   302: ldc_w 579
    //   305: aload_0
    //   306: invokestatic 202	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   309: goto -141 -> 168
    //   312: getstatic 29	mobi/beyondpod/rsscore/StartupContentBuilder:TAG	Ljava/lang/String;
    //   315: ldc_w 581
    //   318: invokestatic 138	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: goto -153 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   170	8	0	localException1	Exception
    //   194	8	0	localException2	Exception
    //   220	8	0	localException3	Exception
    //   246	8	0	localException4	Exception
    //   272	8	0	localException5	Exception
    //   298	8	0	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   9	28	170	java/lang/Exception
    //   37	56	194	java/lang/Exception
    //   65	84	220	java/lang/Exception
    //   93	112	246	java/lang/Exception
    //   121	140	272	java/lang/Exception
    //   149	168	298	java/lang/Exception
  }
  
  public static void RestoreRepositoriesIfNeeded(boolean paramBoolean)
  {
    if ((FileUtils.Exists(Configuration.ItemHistoryBackupFilePath())) && (!FileUtils.Exists(Configuration.ItemHistoryFilePath()))) {}
    try
    {
      FileUtils.CopyFile(Configuration.ItemHistoryBackupFilePath(), Configuration.ItemHistoryFilePath());
      CoreHelper.WriteTraceEntry(TAG, "Restored long term Item State History backup!");
      if ((!FileUtils.Exists(Configuration.EnclosureDownloadHistoryBackupFilePath())) || (FileUtils.Exists(Configuration.EnclosureDownloadHistoryFilePath()))) {}
    }
    catch (Exception localException2)
    {
      try
      {
        FileUtils.CopyFile(Configuration.EnclosureDownloadHistoryBackupFilePath(), Configuration.EnclosureDownloadHistoryFilePath());
        CoreHelper.WriteTraceEntry(TAG, "Restored long term Download History backup!");
        if ((!FileUtils.Exists(Configuration.SmartPlaylistBackupFilePath())) || (FileUtils.Exists(Configuration.SmartPlaylistFilePath()))) {}
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            FileUtils.CopyFile(Configuration.SmartPlaylistBackupFilePath(), Configuration.SmartPlaylistFilePath());
            CoreHelper.WriteTraceEntry(TAG, "Restored long term Smart Playlist backup!");
            if ((paramBoolean) && (FileUtils.Exists(Configuration.PlaylistBackupFilePath())) && (!FileUtils.Exists(Configuration.PlaylistFilePath()))) {}
            try
            {
              FileUtils.CopyFile(Configuration.PlaylistBackupFilePath(), Configuration.PlaylistFilePath());
              CoreHelper.WriteTraceEntry(TAG, "Restored long term Playlist backup!");
              return;
            }
            catch (Exception localException4)
            {
              CoreHelper.LogException(TAG, "Unable to restore long term Playlist backup!", localException4);
            }
            localException1 = localException1;
            CoreHelper.LogException(TAG, "Unable to restore long term Item State History backup!", localException1);
          }
          localException2 = localException2;
          CoreHelper.LogException(TAG, "Unable to restore long term Download History backup!", localException2);
        }
        catch (Exception localException3)
        {
          for (;;)
          {
            CoreHelper.LogException(TAG, "Unable to restore long term Smart Playlist backup!", localException3);
          }
        }
      }
    }
  }
  
  public void CheckAndCreateStartupContent(boolean paramBoolean)
  {
    int j = 0;
    RestoreRepositoriesIfNeeded(paramBoolean);
    Content[] arrayOfContent = this._PermanentContent;
    int k = arrayOfContent.length;
    int i = 0;
    if (i >= k)
    {
      if (!Configuration.GoogleSyncInitialized())
      {
        ItemStateHistory.PurgeAllGoogleReaderItems();
        Configuration.setGoogleSyncInitialized(true);
      }
      if (!Configuration.AreSettingsInitialized())
      {
        CoreHelper.WriteTraceEntry(TAG, "Initializing User Default Settings...");
        BeyondPodApplication.GetInstance().ConfigureDefaults();
      }
      if (paramBoolean) {
        break label102;
      }
    }
    for (;;)
    {
      return;
      Content localContent = arrayOfContent[i];
      if (!localContent.DestinationFile.exists()) {
        CoreHelper.CopyResToFile(localContent.SourceResourceID, localContent.DestinationFile);
      }
      i += 1;
      break;
      label102:
      arrayOfContent = this._DemoContent;
      k = arrayOfContent.length;
      i = j;
      while (i < k)
      {
        localContent = arrayOfContent[i];
        if (!localContent.DestinationFile.exists()) {
          CoreHelper.CopyAssetToFile(localContent.AssetName, localContent.DestinationFile);
        }
        i += 1;
      }
    }
  }
  
  public static class Content
  {
    public String AssetName;
    public File DestinationFile;
    public int SourceResourceID;
    
    public Content(int paramInt, File paramFile)
    {
      this.SourceResourceID = paramInt;
      this.DestinationFile = paramFile;
      this.AssetName = null;
    }
    
    public Content(String paramString, File paramFile)
    {
      this.SourceResourceID = 0;
      this.AssetName = paramString;
      this.DestinationFile = paramFile;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/StartupContentBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */