package mobi.beyondpod.rsscore.rss;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.RepositoryPersistence;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;

public class EnclosureDownloadHistory
{
  private static final String TAG = EnclosureDownloadHistory.class.getSimpleName();
  static Runnable _SaveHistoryRunnable = new Runnable()
  {
    public void run() {}
  };
  private static boolean _SavingHistory;
  private static HashMap<Integer, Long> m_history = null;
  private static boolean m_modified;
  
  public static void AddAllEnclosures(RssFeed paramRssFeed)
  {
    paramRssFeed = paramRssFeed.Items.iterator();
    for (;;)
    {
      if (!paramRssFeed.hasNext()) {
        return;
      }
      RssFeedItem localRssFeedItem = (RssFeedItem)paramRssFeed.next();
      if (localRssFeedItem.Enclosure() != null) {
        AddEnclosureInternal(localRssFeedItem.Enclosure(), true);
      }
    }
  }
  
  public static void AddEnclosure(RssEnclosure paramRssEnclosure, boolean paramBoolean)
  {
    AddEnclosureInternal(paramRssEnclosure, paramBoolean);
    SaveHistoryAsync();
  }
  
  private static void AddEnclosureInternal(RssEnclosure paramRssEnclosure, boolean paramBoolean)
  {
    synchronized ()
    {
      CoreHelper.WriteLogEntryInProduction(TAG, String.format("Inserted download History for: %s (hash:%s)...", new Object[] { paramRssEnclosure.RelativeLocalFileName(), Integer.valueOf(paramRssEnclosure.EnclosureID()) }));
      History().put(Integer.valueOf(paramRssEnclosure.EnclosureID()), Long.valueOf(new Date().getTime()));
      m_modified = true;
      return;
    }
  }
  
  public static void ClearHistory()
  {
    synchronized ()
    {
      History().clear();
      m_modified = true;
      return;
    }
  }
  
  public static boolean HasEntryFor(RssEnclosure paramRssEnclosure)
  {
    return (History().containsKey(Integer.valueOf(paramRssEnclosure.EnclosureID()))) || (History().containsKey(Integer.valueOf(paramRssEnclosure.EnclosureAlternativeID()))) || (History().containsKey(Integer.valueOf(paramRssEnclosure.EnclosureOldMountID()))) || (History().containsKey(Integer.valueOf(paramRssEnclosure.EnclosureRelativePathID())));
  }
  
  private static HashMap<Integer, Long> History()
  {
    if (m_history == null) {
      LoadHistory();
    }
    return m_history;
  }
  
  /* Error */
  private static void LoadHistory()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: new 120	java/util/HashMap
    //   8: dup
    //   9: invokespecial 155	java/util/HashMap:<init>	()V
    //   12: putstatic 28	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:m_history	Ljava/util/HashMap;
    //   15: new 157	java/io/File
    //   18: dup
    //   19: invokestatic 162	mobi/beyondpod/rsscore/Configuration:EnclosureDownloadHistoryFilePath	()Ljava/lang/String;
    //   22: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 4
    //   27: aload 4
    //   29: invokevirtual 168	java/io/File:exists	()Z
    //   32: ifeq +68 -> 100
    //   35: new 170	java/io/FileInputStream
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 173	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: astore 4
    //   46: new 175	java/io/DataInputStream
    //   49: dup
    //   50: aload 4
    //   52: invokespecial 178	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: astore_3
    //   56: aload_3
    //   57: invokevirtual 181	java/io/DataInputStream:readInt	()I
    //   60: istore_0
    //   61: aload_3
    //   62: invokevirtual 184	java/io/DataInputStream:readLong	()J
    //   65: lstore_1
    //   66: getstatic 28	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:m_history	Ljava/util/HashMap;
    //   69: iload_0
    //   70: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   73: lload_1
    //   74: invokestatic 118	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   77: invokevirtual 124	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   80: pop
    //   81: goto -25 -> 56
    //   84: astore_3
    //   85: aload 4
    //   87: invokevirtual 187	java/io/FileInputStream:close	()V
    //   90: aload 4
    //   92: ifnull +96 -> 188
    //   95: aload 4
    //   97: invokevirtual 187	java/io/FileInputStream:close	()V
    //   100: iconst_0
    //   101: putstatic 126	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:m_modified	Z
    //   104: return
    //   105: astore_3
    //   106: aload 5
    //   108: astore 4
    //   110: aload_3
    //   111: astore 5
    //   113: aload 4
    //   115: astore_3
    //   116: getstatic 26	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:TAG	Ljava/lang/String;
    //   119: ldc -67
    //   121: aload 5
    //   123: invokestatic 193	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   126: aload 4
    //   128: ifnull -28 -> 100
    //   131: aload 4
    //   133: invokevirtual 187	java/io/FileInputStream:close	()V
    //   136: goto -36 -> 100
    //   139: astore_3
    //   140: getstatic 26	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:TAG	Ljava/lang/String;
    //   143: ldc -67
    //   145: aload_3
    //   146: invokestatic 193	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   149: goto -49 -> 100
    //   152: astore 4
    //   154: aload_3
    //   155: ifnull +7 -> 162
    //   158: aload_3
    //   159: invokevirtual 187	java/io/FileInputStream:close	()V
    //   162: aload 4
    //   164: athrow
    //   165: astore_3
    //   166: getstatic 26	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:TAG	Ljava/lang/String;
    //   169: ldc -67
    //   171: aload_3
    //   172: invokestatic 193	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   175: goto -13 -> 162
    //   178: astore_3
    //   179: getstatic 26	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:TAG	Ljava/lang/String;
    //   182: ldc -67
    //   184: aload_3
    //   185: invokestatic 193	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   188: goto -88 -> 100
    //   191: astore 5
    //   193: aload 4
    //   195: astore_3
    //   196: aload 5
    //   198: astore 4
    //   200: goto -46 -> 154
    //   203: astore 5
    //   205: goto -92 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   60	10	0	i	int
    //   65	9	1	l	long
    //   1	61	3	localDataInputStream	java.io.DataInputStream
    //   84	1	3	localEOFException	java.io.EOFException
    //   105	6	3	localException1	Exception
    //   115	1	3	localObject1	Object
    //   139	20	3	localException2	Exception
    //   165	7	3	localException3	Exception
    //   178	7	3	localException4	Exception
    //   195	1	3	localObject2	Object
    //   25	107	4	localObject3	Object
    //   152	42	4	localObject4	Object
    //   198	1	4	localObject5	Object
    //   3	119	5	localException5	Exception
    //   191	6	5	localObject6	Object
    //   203	1	5	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   56	81	84	java/io/EOFException
    //   35	46	105	java/lang/Exception
    //   131	136	139	java/lang/Exception
    //   35	46	152	finally
    //   116	126	152	finally
    //   158	162	165	java/lang/Exception
    //   95	100	178	java/lang/Exception
    //   46	56	191	finally
    //   56	81	191	finally
    //   85	90	191	finally
    //   46	56	203	java/lang/Exception
    //   56	81	203	java/lang/Exception
    //   85	90	203	java/lang/Exception
  }
  
  public static void RemoveAllEnclosuresForFeed(RssFeed paramRssFeed)
  {
    paramRssFeed = paramRssFeed.Items.iterator();
    for (;;)
    {
      if (!paramRssFeed.hasNext()) {
        return;
      }
      RssFeedItem localRssFeedItem = (RssFeedItem)paramRssFeed.next();
      if (localRssFeedItem.Enclosure() != null) {
        RemoveEnclosureInternal(localRssFeedItem.Enclosure(), true);
      }
    }
  }
  
  public static void RemoveEnclosure(RssEnclosure paramRssEnclosure, boolean paramBoolean)
  {
    RemoveEnclosureInternal(paramRssEnclosure, paramBoolean);
    SaveHistoryAsync();
  }
  
  private static void RemoveEnclosureInternal(RssEnclosure paramRssEnclosure, boolean paramBoolean)
  {
    if (HasEntryFor(paramRssEnclosure)) {
      CoreHelper.WriteLogEntryInProduction(TAG, String.format("Deleted download History for: %s (hash:%s)", new Object[] { paramRssEnclosure.RelativeLocalFileName(), Integer.valueOf(paramRssEnclosure.EnclosureID()) }));
    }
    synchronized (History())
    {
      History().remove(Integer.valueOf(paramRssEnclosure.EnclosureID()));
      m_modified = true;
      return;
    }
  }
  
  public static void SaveHistoryAsync()
  {
    RepositoryPersistence.RepositoryHandler().removeCallbacks(_SaveHistoryRunnable);
    RepositoryPersistence.RepositoryHandler().postDelayed(_SaveHistoryRunnable, 1000L);
  }
  
  /* Error */
  private static void SaveHistoryInternal()
  {
    // Byte code:
    //   0: getstatic 126	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:m_modified	Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: getstatic 28	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:m_history	Ljava/util/HashMap;
    //   10: astore 6
    //   12: aload 6
    //   14: monitorenter
    //   15: getstatic 227	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:_SavingHistory	Z
    //   18: ifeq +13 -> 31
    //   21: aload 6
    //   23: monitorexit
    //   24: return
    //   25: astore_2
    //   26: aload 6
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    //   31: iconst_1
    //   32: putstatic 227	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:_SavingHistory	Z
    //   35: getstatic 26	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:TAG	Ljava/lang/String;
    //   38: ldc -27
    //   40: invokestatic 232	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: new 234	java/lang/StringBuilder
    //   46: dup
    //   47: invokestatic 162	mobi/beyondpod/rsscore/Configuration:EnclosureDownloadHistoryFilePath	()Ljava/lang/String;
    //   50: invokestatic 237	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   53: invokespecial 238	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: ldc -16
    //   58: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore 7
    //   66: aconst_null
    //   67: astore_3
    //   68: aconst_null
    //   69: astore 5
    //   71: aload_3
    //   72: astore_2
    //   73: new 249	java/io/FileOutputStream
    //   76: dup
    //   77: aload 7
    //   79: invokespecial 250	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   82: astore 4
    //   84: aload_3
    //   85: astore_2
    //   86: new 252	java/io/DataOutputStream
    //   89: dup
    //   90: aload 4
    //   92: invokespecial 255	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   95: astore_3
    //   96: getstatic 28	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:m_history	Ljava/util/HashMap;
    //   99: invokevirtual 259	java/util/HashMap:keySet	()Ljava/util/Set;
    //   102: invokeinterface 264 1 0
    //   107: anewarray 90	java/lang/Integer
    //   110: astore_2
    //   111: getstatic 28	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:m_history	Ljava/util/HashMap;
    //   114: invokevirtual 259	java/util/HashMap:keySet	()Ljava/util/Set;
    //   117: aload_2
    //   118: invokeinterface 268 2 0
    //   123: pop
    //   124: aload_2
    //   125: arraylength
    //   126: istore_1
    //   127: iconst_0
    //   128: istore_0
    //   129: iload_0
    //   130: iload_1
    //   131: if_icmplt +64 -> 195
    //   134: aload 4
    //   136: invokestatic 272	mobi/beyondpod/rsscore/helpers/CoreHelper:sync	(Ljava/io/FileOutputStream;)Z
    //   139: pop
    //   140: aload_3
    //   141: invokevirtual 273	java/io/DataOutputStream:close	()V
    //   144: aload_3
    //   145: ifnull +200 -> 345
    //   148: aload_3
    //   149: invokevirtual 273	java/io/DataOutputStream:close	()V
    //   152: aload 7
    //   154: invokestatic 162	mobi/beyondpod/rsscore/Configuration:EnclosureDownloadHistoryFilePath	()Ljava/lang/String;
    //   157: invokestatic 279	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   160: pop
    //   161: new 157	java/io/File
    //   164: dup
    //   165: aload 7
    //   167: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   170: invokevirtual 282	java/io/File:delete	()Z
    //   173: pop
    //   174: iconst_0
    //   175: putstatic 126	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:m_modified	Z
    //   178: getstatic 26	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:TAG	Ljava/lang/String;
    //   181: ldc_w 284
    //   184: invokestatic 106	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntryInProduction	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: iconst_0
    //   188: putstatic 227	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:_SavingHistory	Z
    //   191: aload 6
    //   193: monitorexit
    //   194: return
    //   195: aload_2
    //   196: iload_0
    //   197: aaload
    //   198: astore 5
    //   200: aload_3
    //   201: aload 5
    //   203: invokevirtual 287	java/lang/Integer:intValue	()I
    //   206: invokevirtual 291	java/io/DataOutputStream:writeInt	(I)V
    //   209: aload_3
    //   210: getstatic 28	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:m_history	Ljava/util/HashMap;
    //   213: aload 5
    //   215: invokevirtual 294	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   218: checkcast 115	java/lang/Long
    //   221: invokevirtual 297	java/lang/Long:longValue	()J
    //   224: invokevirtual 301	java/io/DataOutputStream:writeLong	(J)V
    //   227: iload_0
    //   228: iconst_1
    //   229: iadd
    //   230: istore_0
    //   231: goto -102 -> 129
    //   234: astore 4
    //   236: aload 5
    //   238: astore_3
    //   239: aload_3
    //   240: astore_2
    //   241: getstatic 26	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:TAG	Ljava/lang/String;
    //   244: ldc_w 303
    //   247: aload 4
    //   249: invokestatic 193	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   252: aload_3
    //   253: ifnull -101 -> 152
    //   256: aload_3
    //   257: invokevirtual 273	java/io/DataOutputStream:close	()V
    //   260: goto -108 -> 152
    //   263: astore_2
    //   264: getstatic 26	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:TAG	Ljava/lang/String;
    //   267: ldc_w 303
    //   270: aload_2
    //   271: invokestatic 193	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   274: goto -122 -> 152
    //   277: astore_3
    //   278: aload_2
    //   279: ifnull +7 -> 286
    //   282: aload_2
    //   283: invokevirtual 273	java/io/DataOutputStream:close	()V
    //   286: aload_3
    //   287: athrow
    //   288: astore_2
    //   289: getstatic 26	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:TAG	Ljava/lang/String;
    //   292: ldc_w 303
    //   295: aload_2
    //   296: invokestatic 193	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   299: goto -13 -> 286
    //   302: astore_2
    //   303: getstatic 26	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:TAG	Ljava/lang/String;
    //   306: ldc_w 303
    //   309: aload_2
    //   310: invokestatic 193	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   313: goto +32 -> 345
    //   316: astore_2
    //   317: getstatic 26	mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory:TAG	Ljava/lang/String;
    //   320: ldc_w 305
    //   323: aload_2
    //   324: invokestatic 193	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   327: goto -140 -> 187
    //   330: astore 4
    //   332: aload_3
    //   333: astore_2
    //   334: aload 4
    //   336: astore_3
    //   337: goto -59 -> 278
    //   340: astore 4
    //   342: goto -103 -> 239
    //   345: goto -193 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   128	103	0	i	int
    //   126	6	1	j	int
    //   25	5	2	localObject1	Object
    //   72	169	2	localObject2	Object
    //   263	20	2	localException1	Exception
    //   288	8	2	localException2	Exception
    //   302	8	2	localException3	Exception
    //   316	8	2	localException4	Exception
    //   333	1	2	localObject3	Object
    //   67	190	3	localObject4	Object
    //   277	56	3	localObject5	Object
    //   336	1	3	localObject6	Object
    //   82	53	4	localFileOutputStream	java.io.FileOutputStream
    //   234	14	4	localException5	Exception
    //   330	5	4	localObject7	Object
    //   340	1	4	localException6	Exception
    //   69	168	5	localObject8	Object
    //   10	182	6	localHashMap	HashMap
    //   64	102	7	str	String
    // Exception table:
    //   from	to	target	type
    //   15	24	25	finally
    //   26	29	25	finally
    //   31	66	25	finally
    //   148	152	25	finally
    //   152	187	25	finally
    //   187	194	25	finally
    //   256	260	25	finally
    //   264	274	25	finally
    //   282	286	25	finally
    //   286	288	25	finally
    //   289	299	25	finally
    //   303	313	25	finally
    //   317	327	25	finally
    //   73	84	234	java/lang/Exception
    //   86	96	234	java/lang/Exception
    //   256	260	263	java/lang/Exception
    //   73	84	277	finally
    //   86	96	277	finally
    //   241	252	277	finally
    //   282	286	288	java/lang/Exception
    //   148	152	302	java/lang/Exception
    //   152	187	316	java/lang/Exception
    //   96	127	330	finally
    //   134	144	330	finally
    //   200	227	330	finally
    //   96	127	340	java/lang/Exception
    //   134	144	340	java/lang/Exception
    //   200	227	340	java/lang/Exception
  }
  
  public static void SaveHistorySync() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/EnclosureDownloadHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */