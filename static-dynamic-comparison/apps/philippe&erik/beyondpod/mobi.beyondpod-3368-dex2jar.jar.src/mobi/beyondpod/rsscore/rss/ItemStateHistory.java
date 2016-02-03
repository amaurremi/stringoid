package mobi.beyondpod.rsscore.rss;

import android.os.Handler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import mobi.beyondpod.BeyondPodApplication;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.SimpleMessageBus;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryEvents.RepositoryEvent;
import mobi.beyondpod.rsscore.repository.RepositoryPersistence;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;

public class ItemStateHistory
{
  public static int AutoSaveModificationCount;
  private static final String TAG = ItemStateHistory.class.getSimpleName();
  private static volatile int _ModificationChangeCount;
  private static volatile boolean _Saving;
  private static Runnable _StateSaverRunnnable;
  private static HashMap<UUID, HashMap<String, ItemStatus>> m_history;
  
  static
  {
    AutoSaveModificationCount = 3;
    m_history = null;
    _StateSaverRunnnable = new Runnable()
    {
      public void run() {}
    };
    LoadHistory();
  }
  
  private static void AutoSaveHistory()
  {
    if (_ModificationChangeCount > AutoSaveModificationCount) {
      SaveHistoryAsync();
    }
  }
  
  public static void ClearHistory()
  {
    synchronized ()
    {
      History().clear();
      MarkModified();
      return;
    }
  }
  
  public static void ClearItemReadStatus(RssFeedItem arg0)
  {
    ItemStatus localItemStatus = GetOrCreateItemStatus(???);
    LogFirstReaderStatusChange(???);
    synchronized (History())
    {
      localItemStatus.ClearRead();
      MarkModified();
      AutoSaveHistory();
      return;
    }
  }
  
  public static void ClearItemStarredStatus(RssFeedItem paramRssFeedItem)
  {
    ItemStatus localItemStatus = GetOrCreateItemStatus(paramRssFeedItem);
    synchronized (History())
    {
      LogFirstReaderStatusChange(paramRssFeedItem);
      if ((Configuration.EnableLoggingInProduction()) && (IsFeedlyItemKey(paramRssFeedItem.ItemID()))) {
        CoreHelper.WriteLogEntryInProduction(TAG, "*** Clear starred on reader post: " + paramRssFeedItem.Title + " ->" + paramRssFeedItem.OriginatingFeed);
      }
      localItemStatus.ClearStarred();
      MarkModified();
      AutoSaveHistory();
      return;
    }
  }
  
  public static String DumpHistory()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    localStringBuilder.append(">>> Item History Dump------------\n ");
    Iterator localIterator1 = m_history.keySet().iterator();
    UUID localUUID;
    do
    {
      if (!localIterator1.hasNext())
      {
        if (i != 0) {
          localStringBuilder.append(">>> The Item State history is empty!");
        }
        return localStringBuilder.toString();
      }
      localUUID = (UUID)localIterator1.next();
    } while (((HashMap)m_history.get(localUUID)).keySet().size() <= 0);
    i = 0;
    localStringBuilder.append(localUUID + "(" + ((HashMap)m_history.get(localUUID)).keySet().size() + ")\n");
    Iterator localIterator2 = ((HashMap)m_history.get(localUUID)).keySet().iterator();
    for (;;)
    {
      if (!localIterator2.hasNext())
      {
        localStringBuilder.append("\n");
        break;
      }
      String str = (String)localIterator2.next();
      localStringBuilder.append("  " + str + ":" + ((HashMap)m_history.get(localUUID)).get(str) + "\n");
    }
  }
  
  public static HashMap<String, ItemStatus> GetAllUnsynchronizedGoogleReaderItems()
  {
    HashMap localHashMap2 = new HashMap();
    synchronized (History())
    {
      String str;
      ItemStatus localItemStatus;
      do
      {
        Iterator localIterator = m_history.keySet().iterator();
        UUID localUUID;
        Object localObject2;
        while (!((Iterator)localObject2).hasNext())
        {
          do
          {
            if (!localIterator.hasNext()) {
              return localHashMap2;
            }
            localUUID = (UUID)localIterator.next();
            localObject2 = FeedRepository.GetFeedById(localUUID);
          } while ((localObject2 == null) || (!((Feed)localObject2).IsGReaderFeed()) || (((HashMap)m_history.get(localUUID)).keySet().size() <= 0));
          localObject2 = ((HashMap)m_history.get(localUUID)).keySet().iterator();
        }
        str = (String)((Iterator)localObject2).next();
        localItemStatus = (ItemStatus)((HashMap)m_history.get(localUUID)).get(str);
      } while ((localItemStatus.IsReadSynced()) && (localItemStatus.IsStarSynced()));
      localHashMap2.put(str, localItemStatus);
    }
  }
  
  public static String GetItemIdUsedForStatus(RssFeedItem paramRssFeedItem)
  {
    UUID localUUID = paramRssFeedItem.OriginatingFeedID();
    String str = paramRssFeedItem.ItemID();
    if ((localUUID == null) || (paramRssFeedItem == null) || (str == null)) {
      return null;
    }
    paramRssFeedItem = (HashMap)History().get(localUUID);
    if (paramRssFeedItem != null)
    {
      paramRssFeedItem = (ItemStatus)paramRssFeedItem.get(str);
      if (paramRssFeedItem != null) {
        return ">" + str + "< (" + paramRssFeedItem.toString() + ")";
      }
    }
    if (IsFeedlyItemKey(str)) {
      return "NA-FOR-READER-ITEMS";
    }
    return "STATUS-NOT-FOUND";
  }
  
  private static ItemStatus GetItemStatus(RssFeedItem paramRssFeedItem)
  {
    UUID localUUID = paramRssFeedItem.OriginatingFeedID();
    String str = paramRssFeedItem.ItemID();
    if ((localUUID == null) || (paramRssFeedItem == null) || (str == null)) {}
    do
    {
      return null;
      paramRssFeedItem = (HashMap)History().get(localUUID);
    } while (paramRssFeedItem == null);
    return (ItemStatus)paramRssFeedItem.get(str);
  }
  
  private static ItemStatus GetOrCreateItemStatus(RssFeedItem paramRssFeedItem)
  {
    UUID localUUID = paramRssFeedItem.OriginatingFeedID();
    Object localObject1 = GetItemStatus(paramRssFeedItem);
    if (localObject1 != null) {
      return (ItemStatus)localObject1;
    }
    Object localObject2 = (HashMap)History().get(localUUID);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new HashMap();
      History().put(localUUID, localObject1);
    }
    localObject2 = new ItemStatus(true, true, paramRssFeedItem.getRead(), paramRssFeedItem.getStarred());
    ((HashMap)localObject1).put(paramRssFeedItem.ItemID(), localObject2);
    return (ItemStatus)localObject2;
  }
  
  public static boolean HasStatusFor(RssFeedItem paramRssFeedItem)
  {
    return GetItemStatus(paramRssFeedItem) != null;
  }
  
  public static boolean HasUnsynchronizedGoogleReaderItems()
  {
    Object localObject;
    do
    {
      Iterator localIterator1 = m_history.keySet().iterator();
      UUID localUUID;
      do
      {
        Iterator localIterator2;
        do
        {
          do
          {
            if (!localIterator1.hasNext()) {
              return false;
            }
            localUUID = (UUID)localIterator1.next();
          } while (((HashMap)m_history.get(localUUID)).keySet().size() <= 0);
          localIterator2 = ((HashMap)m_history.get(localUUID)).keySet().iterator();
        } while (!localIterator2.hasNext());
        localObject = (String)localIterator2.next();
      } while (!IsFeedlyItemKey((String)localObject));
      localObject = (ItemStatus)((HashMap)m_history.get(localUUID)).get(localObject);
    } while ((((ItemStatus)localObject).IsReadSynced()) && (((ItemStatus)localObject).IsStarSynced()));
    return true;
  }
  
  private static HashMap<UUID, HashMap<String, ItemStatus>> History()
  {
    if (m_history == null) {
      LoadHistory();
    }
    return m_history;
  }
  
  private static boolean IsFeedlyItemKey(String paramString)
  {
    return paramString.length() > 20;
  }
  
  public static boolean IsItemRead(RssFeedItem paramRssFeedItem)
  {
    paramRssFeedItem = GetItemStatus(paramRssFeedItem);
    if (paramRssFeedItem == null) {
      return false;
    }
    return paramRssFeedItem.IsRead();
  }
  
  public static boolean IsItemStarred(RssFeedItem paramRssFeedItem)
  {
    paramRssFeedItem = GetItemStatus(paramRssFeedItem);
    if (paramRssFeedItem == null) {
      return false;
    }
    return paramRssFeedItem.IsStarred();
  }
  
  /* Error */
  private static void LoadHistory()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: new 58	java/util/HashMap
    //   8: dup
    //   9: invokespecial 181	java/util/HashMap:<init>	()V
    //   12: putstatic 35	mobi/beyondpod/rsscore/rss/ItemStateHistory:m_history	Ljava/util/HashMap;
    //   15: new 254	java/io/File
    //   18: dup
    //   19: invokestatic 257	mobi/beyondpod/rsscore/Configuration:ItemHistoryFilePath	()Ljava/lang/String;
    //   22: invokespecial 258	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore_3
    //   26: aload_3
    //   27: invokevirtual 261	java/io/File:exists	()Z
    //   30: ifeq +111 -> 141
    //   33: new 263	java/io/FileInputStream
    //   36: dup
    //   37: aload_3
    //   38: invokespecial 266	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: astore_3
    //   42: new 268	java/io/DataInputStream
    //   45: dup
    //   46: aload_3
    //   47: invokespecial 271	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore 6
    //   52: aconst_null
    //   53: astore_2
    //   54: aload 6
    //   56: invokevirtual 274	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   59: invokestatic 278	java/util/UUID:fromString	(Ljava/lang/String;)Ljava/util/UUID;
    //   62: astore 4
    //   64: aload 4
    //   66: astore_2
    //   67: aload 6
    //   69: invokevirtual 281	java/io/DataInputStream:readInt	()I
    //   72: istore_1
    //   73: aload_2
    //   74: ifnull -22 -> 52
    //   77: getstatic 35	mobi/beyondpod/rsscore/rss/ItemStateHistory:m_history	Ljava/util/HashMap;
    //   80: aload_2
    //   81: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   84: checkcast 58	java/util/HashMap
    //   87: astore 5
    //   89: aload 5
    //   91: astore 4
    //   93: aload 5
    //   95: ifnonnull +199 -> 294
    //   98: new 58	java/util/HashMap
    //   101: dup
    //   102: invokespecial 181	java/util/HashMap:<init>	()V
    //   105: astore 4
    //   107: goto +187 -> 294
    //   110: iload_0
    //   111: iload_1
    //   112: if_icmpne +38 -> 150
    //   115: getstatic 35	mobi/beyondpod/rsscore/rss/ItemStateHistory:m_history	Ljava/util/HashMap;
    //   118: aload_2
    //   119: aload 4
    //   121: invokevirtual 202	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: pop
    //   125: goto -73 -> 52
    //   128: astore_2
    //   129: aload_3
    //   130: invokevirtual 284	java/io/FileInputStream:close	()V
    //   133: aload_3
    //   134: ifnull +137 -> 271
    //   137: aload_3
    //   138: invokevirtual 284	java/io/FileInputStream:close	()V
    //   141: iconst_0
    //   142: putstatic 48	mobi/beyondpod/rsscore/rss/ItemStateHistory:_ModificationChangeCount	I
    //   145: return
    //   146: astore_2
    //   147: goto -18 -> 129
    //   150: aload 6
    //   152: invokevirtual 274	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   155: astore 5
    //   157: new 8	mobi/beyondpod/rsscore/rss/ItemStateHistory$ItemStatus
    //   160: dup
    //   161: invokespecial 285	mobi/beyondpod/rsscore/rss/ItemStateHistory$ItemStatus:<init>	()V
    //   164: astore 7
    //   166: aload 7
    //   168: aload 6
    //   170: invokevirtual 289	mobi/beyondpod/rsscore/rss/ItemStateHistory$ItemStatus:Read	(Ljava/io/DataInputStream;)V
    //   173: aload 4
    //   175: aload 5
    //   177: aload 7
    //   179: invokevirtual 202	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   182: pop
    //   183: iload_0
    //   184: iconst_1
    //   185: iadd
    //   186: istore_0
    //   187: goto -77 -> 110
    //   190: astore_2
    //   191: aload 4
    //   193: astore_3
    //   194: aload_2
    //   195: astore 4
    //   197: aload_3
    //   198: astore_2
    //   199: getstatic 31	mobi/beyondpod/rsscore/rss/ItemStateHistory:TAG	Ljava/lang/String;
    //   202: ldc_w 291
    //   205: aload 4
    //   207: invokestatic 295	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: aload_3
    //   211: ifnull -70 -> 141
    //   214: aload_3
    //   215: invokevirtual 284	java/io/FileInputStream:close	()V
    //   218: goto -77 -> 141
    //   221: astore_2
    //   222: getstatic 31	mobi/beyondpod/rsscore/rss/ItemStateHistory:TAG	Ljava/lang/String;
    //   225: ldc_w 291
    //   228: aload_2
    //   229: invokestatic 295	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   232: goto -91 -> 141
    //   235: astore_3
    //   236: aload_2
    //   237: ifnull +7 -> 244
    //   240: aload_2
    //   241: invokevirtual 284	java/io/FileInputStream:close	()V
    //   244: aload_3
    //   245: athrow
    //   246: astore_2
    //   247: getstatic 31	mobi/beyondpod/rsscore/rss/ItemStateHistory:TAG	Ljava/lang/String;
    //   250: ldc_w 291
    //   253: aload_2
    //   254: invokestatic 295	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   257: goto -13 -> 244
    //   260: astore_2
    //   261: getstatic 31	mobi/beyondpod/rsscore/rss/ItemStateHistory:TAG	Ljava/lang/String;
    //   264: ldc_w 291
    //   267: aload_2
    //   268: invokestatic 295	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   271: goto -130 -> 141
    //   274: astore 4
    //   276: aload_3
    //   277: astore_2
    //   278: aload 4
    //   280: astore_3
    //   281: goto -45 -> 236
    //   284: astore 4
    //   286: goto -89 -> 197
    //   289: astore 4
    //   291: goto -224 -> 67
    //   294: iconst_0
    //   295: istore_0
    //   296: goto -186 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   110	186	0	i	int
    //   72	41	1	j	int
    //   1	118	2	localObject1	Object
    //   128	1	2	localEOFException1	java.io.EOFException
    //   146	1	2	localEOFException2	java.io.EOFException
    //   190	5	2	localException1	Exception
    //   198	1	2	localObject2	Object
    //   221	20	2	localException2	Exception
    //   246	8	2	localException3	Exception
    //   260	8	2	localException4	Exception
    //   277	1	2	localObject3	Object
    //   25	190	3	localObject4	Object
    //   235	42	3	localObject5	Object
    //   280	1	3	localObject6	Object
    //   3	203	4	localObject7	Object
    //   274	5	4	localObject8	Object
    //   284	1	4	localException5	Exception
    //   289	1	4	localException6	Exception
    //   87	89	5	localObject9	Object
    //   50	119	6	localDataInputStream	DataInputStream
    //   164	14	7	localItemStatus	ItemStatus
    // Exception table:
    //   from	to	target	type
    //   67	73	128	java/io/EOFException
    //   77	89	128	java/io/EOFException
    //   98	107	128	java/io/EOFException
    //   115	125	128	java/io/EOFException
    //   150	183	128	java/io/EOFException
    //   54	64	146	java/io/EOFException
    //   33	42	190	java/lang/Exception
    //   214	218	221	java/lang/Exception
    //   33	42	235	finally
    //   199	210	235	finally
    //   240	244	246	java/lang/Exception
    //   137	141	260	java/lang/Exception
    //   42	52	274	finally
    //   54	64	274	finally
    //   67	73	274	finally
    //   77	89	274	finally
    //   98	107	274	finally
    //   115	125	274	finally
    //   129	133	274	finally
    //   150	183	274	finally
    //   42	52	284	java/lang/Exception
    //   67	73	284	java/lang/Exception
    //   77	89	284	java/lang/Exception
    //   98	107	284	java/lang/Exception
    //   115	125	284	java/lang/Exception
    //   129	133	284	java/lang/Exception
    //   150	183	284	java/lang/Exception
    //   54	64	289	java/lang/Exception
  }
  
  private static void LogFirstReaderStatusChange(RssFeedItem paramRssFeedItem)
  {
    if ((Configuration.EnableLoggingInProduction()) && (IsFeedlyItemKey(paramRssFeedItem.ItemID())) && (!HasUnsynchronizedGoogleReaderItems())) {
      CoreHelper.WriteLogEntryInProduction(TAG, "*** First Reader change triggred by: " + paramRssFeedItem.Title + " ->" + paramRssFeedItem.OriginatingFeed);
    }
  }
  
  public static void MarkModified()
  {
    _ModificationChangeCount += 1;
  }
  
  public static void MarkTracksItemAsRead(Track paramTrack)
  {
    if (StringUtils.IsNullOrEmpty(paramTrack.RssItemID())) {}
    Feed localFeed;
    RssFeedItem localRssFeedItem;
    do
    {
      return;
      localFeed = paramTrack.getParentFeed();
      localRssFeedItem = new RssFeedItem(localFeed.ID(), paramTrack.RssItemID());
    } while (IsItemRead(localRssFeedItem));
    SetItemAsRead(localRssFeedItem);
    CoreHelper.WriteLogEntryInProduction(TAG, String.format("Marked Item as READ when item's track is marked as PLAYED! Track: %s (ID:%s)...", new Object[] { paramTrack.DisplayName(), paramTrack.RssItemID() }));
    if (localFeed.NumUnreadItems() > 0) {
      localFeed.setNumUnreadItems(localFeed.NumUnreadItems() - 1);
    }
    BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(15, paramTrack));
    SaveHistoryAsync();
  }
  
  public static void MarkTracksItemAsUnRead(Track paramTrack)
  {
    if (StringUtils.IsNullOrEmpty(paramTrack.RssItemID())) {}
    Feed localFeed;
    RssFeedItem localRssFeedItem;
    do
    {
      return;
      localFeed = paramTrack.getParentFeed();
      localRssFeedItem = new RssFeedItem(localFeed.ID(), paramTrack.RssItemID());
    } while (!IsItemRead(localRssFeedItem));
    ClearItemReadStatus(localRssFeedItem);
    CoreHelper.WriteLogEntryInProduction(TAG, String.format("Marked Item as UN-READ when item's track is marked as UN-PLAYED! Track: %s (ID:%s)...", new Object[] { paramTrack.DisplayName(), paramTrack.RssItemID() }));
    if (localFeed.NumUnreadItems() >= 0) {
      localFeed.setNumUnreadItems(localFeed.NumUnreadItems() + 1);
    }
    BeyondPodApplication.MessageBus.PublishEventAsync(new RepositoryEvents.RepositoryEvent(15, paramTrack));
    SaveHistoryAsync();
  }
  
  public static void PurgeAllGoogleReaderItems()
  {
    synchronized ()
    {
      Iterator localIterator1 = m_history.keySet().iterator();
      UUID localUUID;
      Iterator localIterator2;
      do
      {
        if (!localIterator1.hasNext())
        {
          SaveHistoryAsync();
          return;
        }
        localUUID = (UUID)localIterator1.next();
        localIterator2 = ((HashMap)m_history.get(localUUID)).keySet().iterator();
      } while ((!localIterator2.hasNext()) || (!IsFeedlyItemKey((String)localIterator2.next())));
      ((HashMap)m_history.get(localUUID)).clear();
      MarkModified();
      CoreHelper.WriteTraceEntry(TAG, "Purged all Reader History Items for feed ID: " + localUUID);
    }
  }
  
  public static void PurgeOldRecordsForFeed(RssFeed paramRssFeed)
  {
    if (paramRssFeed == null) {
      return;
    }
    for (;;)
    {
      ArrayList localArrayList;
      Iterator localIterator;
      synchronized (History())
      {
        if (History().containsKey(paramRssFeed.FeedID))
        {
          localArrayList = new ArrayList();
          localIterator = ((HashMap)History().get(paramRssFeed.FeedID)).keySet().iterator();
          if (localIterator.hasNext()) {
            break label134;
          }
          if (localArrayList.size() > 0)
          {
            localIterator = localArrayList.iterator();
            if (localIterator.hasNext()) {
              break label219;
            }
            CoreHelper.WriteTraceEntry(TAG, ">>> Purged " + localArrayList.size() + " items from the Item State History for feed " + paramRssFeed.Title);
            MarkModified();
          }
        }
        return;
      }
      label134:
      String str = (String)localIterator.next();
      if (paramRssFeed.GetItemById(str) == null)
      {
        localArrayList.add(str);
      }
      else
      {
        ItemStatus localItemStatus = (ItemStatus)((HashMap)History().get(paramRssFeed.FeedID)).get(str);
        if ((!Configuration.IgnoreGoogleReaderReadStatus()) && (localItemStatus.IsReadSynced()) && (localItemStatus.IsStarSynced()))
        {
          localArrayList.add(str);
          continue;
          label219:
          str = (String)localIterator.next();
          ((HashMap)History().get(paramRssFeed.FeedID)).remove(str);
        }
      }
    }
  }
  
  public static void RemoveAllItemsFor(UUID paramUUID)
  {
    if (!History().containsKey(paramUUID)) {
      return;
    }
    synchronized (History())
    {
      History().remove(paramUUID);
      MarkModified();
      return;
    }
  }
  
  public static void SaveHistoryAsync()
  {
    RepositoryPersistence.RepositoryHandler().removeCallbacks(_StateSaverRunnnable);
    RepositoryPersistence.RepositoryHandler().post(_StateSaverRunnnable);
  }
  
  /* Error */
  private static void SaveHistoryInternal()
  {
    // Byte code:
    //   0: getstatic 427	mobi/beyondpod/rsscore/rss/ItemStateHistory:_Saving	Z
    //   3: ifne +9 -> 12
    //   6: getstatic 48	mobi/beyondpod/rsscore/rss/ItemStateHistory:_ModificationChangeCount	I
    //   9: ifne +4 -> 13
    //   12: return
    //   13: iconst_1
    //   14: putstatic 427	mobi/beyondpod/rsscore/rss/ItemStateHistory:_Saving	Z
    //   17: iconst_1
    //   18: istore_2
    //   19: iconst_1
    //   20: istore_0
    //   21: iconst_1
    //   22: istore_1
    //   23: getstatic 31	mobi/beyondpod/rsscore/rss/ItemStateHistory:TAG	Ljava/lang/String;
    //   26: ldc_w 429
    //   29: invokestatic 370	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: invokestatic 56	mobi/beyondpod/rsscore/rss/ItemStateHistory:History	()Ljava/util/HashMap;
    //   35: astore 8
    //   37: aload 8
    //   39: monitorenter
    //   40: new 96	java/lang/StringBuilder
    //   43: dup
    //   44: invokestatic 257	mobi/beyondpod/rsscore/Configuration:ItemHistoryFilePath	()Ljava/lang/String;
    //   47: invokestatic 433	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   50: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: ldc_w 435
    //   56: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore 9
    //   64: aconst_null
    //   65: astore 4
    //   67: aconst_null
    //   68: astore 7
    //   70: new 437	java/io/FileOutputStream
    //   73: dup
    //   74: aload 9
    //   76: invokespecial 438	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   79: astore 5
    //   81: iload_2
    //   82: istore_0
    //   83: new 440	java/io/DataOutputStream
    //   86: dup
    //   87: aload 5
    //   89: invokespecial 443	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   92: astore 4
    //   94: iload_2
    //   95: istore_0
    //   96: getstatic 35	mobi/beyondpod/rsscore/rss/ItemStateHistory:m_history	Ljava/util/HashMap;
    //   99: invokevirtual 137	java/util/HashMap:keySet	()Ljava/util/Set;
    //   102: invokeinterface 143 1 0
    //   107: astore 6
    //   109: iload_1
    //   110: istore_0
    //   111: aload 6
    //   113: invokeinterface 148 1 0
    //   118: ifne +96 -> 214
    //   121: iload_1
    //   122: istore_0
    //   123: aload 5
    //   125: invokestatic 447	mobi/beyondpod/rsscore/helpers/CoreHelper:sync	(Ljava/io/FileOutputStream;)Z
    //   128: pop
    //   129: iload_1
    //   130: istore_0
    //   131: aload 5
    //   133: invokevirtual 448	java/io/FileOutputStream:close	()V
    //   136: aload 5
    //   138: ifnull +365 -> 503
    //   141: aload 5
    //   143: invokevirtual 448	java/io/FileOutputStream:close	()V
    //   146: new 254	java/io/File
    //   149: dup
    //   150: aload 9
    //   152: invokespecial 258	java/io/File:<init>	(Ljava/lang/String;)V
    //   155: astore 4
    //   157: iload_1
    //   158: ifeq +348 -> 506
    //   161: new 254	java/io/File
    //   164: dup
    //   165: invokestatic 257	mobi/beyondpod/rsscore/Configuration:ItemHistoryFilePath	()Ljava/lang/String;
    //   168: invokespecial 258	java/io/File:<init>	(Ljava/lang/String;)V
    //   171: astore 5
    //   173: aload 4
    //   175: invokevirtual 451	java/io/File:delete	()Z
    //   178: pop
    //   179: aload 5
    //   181: invokevirtual 451	java/io/File:delete	()Z
    //   184: pop
    //   185: iconst_0
    //   186: putstatic 48	mobi/beyondpod/rsscore/rss/ItemStateHistory:_ModificationChangeCount	I
    //   189: iconst_0
    //   190: putstatic 427	mobi/beyondpod/rsscore/rss/ItemStateHistory:_Saving	Z
    //   193: getstatic 31	mobi/beyondpod/rsscore/rss/ItemStateHistory:TAG	Ljava/lang/String;
    //   196: ldc_w 453
    //   199: invokestatic 370	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: aload 8
    //   204: monitorexit
    //   205: return
    //   206: astore 4
    //   208: aload 8
    //   210: monitorexit
    //   211: aload 4
    //   213: athrow
    //   214: iload_1
    //   215: istore_0
    //   216: aload 6
    //   218: invokeinterface 154 1 0
    //   223: checkcast 156	java/util/UUID
    //   226: astore 7
    //   228: iload_1
    //   229: istore_0
    //   230: aload 7
    //   232: invokestatic 187	mobi/beyondpod/rsscore/repository/FeedRepository:GetFeedById	(Ljava/util/UUID;)Lmobi/beyondpod/rsscore/Feed;
    //   235: ifnonnull +69 -> 304
    //   238: iload_1
    //   239: istore_0
    //   240: getstatic 31	mobi/beyondpod/rsscore/rss/ItemStateHistory:TAG	Ljava/lang/String;
    //   243: ldc_w 455
    //   246: invokestatic 370	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: goto -140 -> 109
    //   252: astore 6
    //   254: aload 5
    //   256: astore 4
    //   258: getstatic 31	mobi/beyondpod/rsscore/rss/ItemStateHistory:TAG	Ljava/lang/String;
    //   261: ldc_w 457
    //   264: aload 6
    //   266: invokestatic 295	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   269: iload_0
    //   270: istore_1
    //   271: aload 5
    //   273: ifnull -127 -> 146
    //   276: aload 5
    //   278: invokevirtual 448	java/io/FileOutputStream:close	()V
    //   281: iload_0
    //   282: istore_1
    //   283: goto -137 -> 146
    //   286: astore 4
    //   288: getstatic 31	mobi/beyondpod/rsscore/rss/ItemStateHistory:TAG	Ljava/lang/String;
    //   291: ldc_w 457
    //   294: aload 4
    //   296: invokestatic 295	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   299: iload_0
    //   300: istore_1
    //   301: goto -155 -> 146
    //   304: iload_1
    //   305: istore_0
    //   306: getstatic 35	mobi/beyondpod/rsscore/rss/ItemStateHistory:m_history	Ljava/util/HashMap;
    //   309: aload 7
    //   311: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   314: checkcast 58	java/util/HashMap
    //   317: invokevirtual 137	java/util/HashMap:keySet	()Ljava/util/Set;
    //   320: invokeinterface 164 1 0
    //   325: ifle -216 -> 109
    //   328: iconst_0
    //   329: istore_3
    //   330: iconst_0
    //   331: istore_2
    //   332: iload_3
    //   333: istore_0
    //   334: aload 4
    //   336: aload 7
    //   338: invokevirtual 458	java/util/UUID:toString	()Ljava/lang/String;
    //   341: invokevirtual 461	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   344: iload_3
    //   345: istore_0
    //   346: aload 4
    //   348: getstatic 35	mobi/beyondpod/rsscore/rss/ItemStateHistory:m_history	Ljava/util/HashMap;
    //   351: aload 7
    //   353: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   356: checkcast 58	java/util/HashMap
    //   359: invokevirtual 137	java/util/HashMap:keySet	()Ljava/util/Set;
    //   362: invokeinterface 164 1 0
    //   367: invokevirtual 464	java/io/DataOutputStream:writeInt	(I)V
    //   370: iload_3
    //   371: istore_0
    //   372: getstatic 35	mobi/beyondpod/rsscore/rss/ItemStateHistory:m_history	Ljava/util/HashMap;
    //   375: aload 7
    //   377: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   380: checkcast 58	java/util/HashMap
    //   383: invokevirtual 137	java/util/HashMap:keySet	()Ljava/util/Set;
    //   386: invokeinterface 143 1 0
    //   391: astore 10
    //   393: iload_2
    //   394: istore_1
    //   395: iload_3
    //   396: istore_0
    //   397: aload 10
    //   399: invokeinterface 148 1 0
    //   404: ifeq -295 -> 109
    //   407: iload_3
    //   408: istore_0
    //   409: aload 10
    //   411: invokeinterface 154 1 0
    //   416: checkcast 175	java/lang/String
    //   419: astore 11
    //   421: iload_3
    //   422: istore_0
    //   423: aload 4
    //   425: aload 11
    //   427: invokevirtual 461	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   430: iload_3
    //   431: istore_0
    //   432: getstatic 35	mobi/beyondpod/rsscore/rss/ItemStateHistory:m_history	Ljava/util/HashMap;
    //   435: aload 7
    //   437: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   440: checkcast 58	java/util/HashMap
    //   443: aload 11
    //   445: invokevirtual 160	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   448: checkcast 8	mobi/beyondpod/rsscore/rss/ItemStateHistory$ItemStatus
    //   451: aload 4
    //   453: invokevirtual 468	mobi/beyondpod/rsscore/rss/ItemStateHistory$ItemStatus:Write	(Ljava/io/DataOutputStream;)V
    //   456: goto -63 -> 393
    //   459: astore 4
    //   461: aload 5
    //   463: ifnull +8 -> 471
    //   466: aload 5
    //   468: invokevirtual 448	java/io/FileOutputStream:close	()V
    //   471: aload 4
    //   473: athrow
    //   474: astore 5
    //   476: getstatic 31	mobi/beyondpod/rsscore/rss/ItemStateHistory:TAG	Ljava/lang/String;
    //   479: ldc_w 457
    //   482: aload 5
    //   484: invokestatic 295	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   487: goto -16 -> 471
    //   490: astore 4
    //   492: getstatic 31	mobi/beyondpod/rsscore/rss/ItemStateHistory:TAG	Ljava/lang/String;
    //   495: ldc_w 457
    //   498: aload 4
    //   500: invokestatic 295	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   503: goto -357 -> 146
    //   506: aload 4
    //   508: invokevirtual 261	java/io/File:exists	()Z
    //   511: ifeq -322 -> 189
    //   514: aload 4
    //   516: invokevirtual 471	java/io/File:length	()J
    //   519: lconst_0
    //   520: lcmp
    //   521: ifle -332 -> 189
    //   524: aload 9
    //   526: invokestatic 257	mobi/beyondpod/rsscore/Configuration:ItemHistoryFilePath	()Ljava/lang/String;
    //   529: invokestatic 477	mobi/beyondpod/rsscore/helpers/FileUtils:CopyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   532: pop
    //   533: aload 4
    //   535: invokevirtual 451	java/io/File:delete	()Z
    //   538: pop
    //   539: iconst_0
    //   540: putstatic 48	mobi/beyondpod/rsscore/rss/ItemStateHistory:_ModificationChangeCount	I
    //   543: goto -354 -> 189
    //   546: astore 4
    //   548: getstatic 31	mobi/beyondpod/rsscore/rss/ItemStateHistory:TAG	Ljava/lang/String;
    //   551: ldc_w 479
    //   554: aload 4
    //   556: invokestatic 295	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   559: goto -370 -> 189
    //   562: astore 6
    //   564: aload 4
    //   566: astore 5
    //   568: aload 6
    //   570: astore 4
    //   572: goto -111 -> 461
    //   575: astore 6
    //   577: aload 7
    //   579: astore 5
    //   581: goto -327 -> 254
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	412	0	i	int
    //   22	373	1	j	int
    //   18	376	2	k	int
    //   329	102	3	m	int
    //   65	109	4	localObject1	Object
    //   206	6	4	localObject2	Object
    //   256	1	4	localObject3	Object
    //   286	166	4	localException1	Exception
    //   459	13	4	localObject4	Object
    //   490	44	4	localException2	Exception
    //   546	19	4	localException3	Exception
    //   570	1	4	localObject5	Object
    //   79	388	5	localObject6	Object
    //   474	9	5	localException4	Exception
    //   566	14	5	localObject7	Object
    //   107	110	6	localIterator1	Iterator
    //   252	13	6	localException5	Exception
    //   562	7	6	localObject8	Object
    //   575	1	6	localException6	Exception
    //   68	510	7	localUUID	UUID
    //   35	174	8	localHashMap	HashMap
    //   62	463	9	str1	String
    //   391	19	10	localIterator2	Iterator
    //   419	25	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   40	64	206	finally
    //   141	146	206	finally
    //   146	157	206	finally
    //   161	189	206	finally
    //   189	205	206	finally
    //   208	211	206	finally
    //   276	281	206	finally
    //   288	299	206	finally
    //   466	471	206	finally
    //   471	474	206	finally
    //   476	487	206	finally
    //   492	503	206	finally
    //   506	543	206	finally
    //   548	559	206	finally
    //   83	94	252	java/lang/Exception
    //   96	109	252	java/lang/Exception
    //   111	121	252	java/lang/Exception
    //   123	129	252	java/lang/Exception
    //   131	136	252	java/lang/Exception
    //   216	228	252	java/lang/Exception
    //   230	238	252	java/lang/Exception
    //   240	249	252	java/lang/Exception
    //   306	328	252	java/lang/Exception
    //   334	344	252	java/lang/Exception
    //   346	370	252	java/lang/Exception
    //   372	393	252	java/lang/Exception
    //   397	407	252	java/lang/Exception
    //   409	421	252	java/lang/Exception
    //   423	430	252	java/lang/Exception
    //   432	456	252	java/lang/Exception
    //   276	281	286	java/lang/Exception
    //   83	94	459	finally
    //   96	109	459	finally
    //   111	121	459	finally
    //   123	129	459	finally
    //   131	136	459	finally
    //   216	228	459	finally
    //   230	238	459	finally
    //   240	249	459	finally
    //   306	328	459	finally
    //   334	344	459	finally
    //   346	370	459	finally
    //   372	393	459	finally
    //   397	407	459	finally
    //   409	421	459	finally
    //   423	430	459	finally
    //   432	456	459	finally
    //   466	471	474	java/lang/Exception
    //   141	146	490	java/lang/Exception
    //   146	157	546	java/lang/Exception
    //   161	189	546	java/lang/Exception
    //   506	543	546	java/lang/Exception
    //   70	81	562	finally
    //   258	269	562	finally
    //   70	81	575	java/lang/Exception
  }
  
  public static void SaveHistorySync()
  {
    if (!_Saving) {
      SaveHistoryInternal();
    }
  }
  
  public static void SetItemAsRead(RssFeedItem paramRssFeedItem)
  {
    if (paramRssFeedItem == null) {
      return;
    }
    synchronized (History())
    {
      ItemStatus localItemStatus = GetOrCreateItemStatus(paramRssFeedItem);
      LogFirstReaderStatusChange(paramRssFeedItem);
      localItemStatus.SetRead();
      MarkModified();
      AutoSaveHistory();
      return;
    }
  }
  
  public static void SetItemAsStarred(RssFeedItem paramRssFeedItem)
  {
    synchronized ()
    {
      ItemStatus localItemStatus = GetOrCreateItemStatus(paramRssFeedItem);
      LogFirstReaderStatusChange(paramRssFeedItem);
      if ((Configuration.EnableLoggingInProduction()) && (IsFeedlyItemKey(paramRssFeedItem.ItemID()))) {
        CoreHelper.WriteLogEntryInProduction(TAG, "*** Starred reader post: " + paramRssFeedItem.Title + " ->" + paramRssFeedItem.OriginatingFeed);
      }
      localItemStatus.SetStarred();
      MarkModified();
      AutoSaveHistory();
      return;
    }
  }
  
  public static void SetItemsAsReadUnread(List<RssFeedItem> paramList, boolean paramBoolean)
  {
    for (;;)
    {
      ItemStatus localItemStatus;
      synchronized ()
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext())
        {
          SaveHistoryAsync();
          return;
        }
        RssFeedItem localRssFeedItem = (RssFeedItem)paramList.next();
        if ((localRssFeedItem.ItemID() == null) || (localRssFeedItem.ItemID() == null) || ((!paramBoolean) && (localRssFeedItem.IsGoogleReadLocked) && (!Configuration.IgnoreGoogleReaderReadStatus())) || (localRssFeedItem.IsMockItem().booleanValue())) {
          continue;
        }
        localItemStatus = GetOrCreateItemStatus(localRssFeedItem);
        LogFirstReaderStatusChange(localRssFeedItem);
        if (paramBoolean)
        {
          localItemStatus.SetRead();
          localRssFeedItem.clearGoogleRead();
          _ModificationChangeCount += 1;
        }
      }
      localItemStatus.ClearRead();
    }
  }
  
  public static class ItemStatus
  {
    static int READ = 1;
    static int READ_SYNCED = 32;
    static int SHARED;
    static int STARRED = 2;
    static int STAR_SYNCED = 64;
    private volatile int _Data = 0;
    
    static
    {
      SHARED = 4;
    }
    
    public ItemStatus() {}
    
    public ItemStatus(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      if (paramBoolean3) {
        SetRead();
      }
      if (paramBoolean4) {
        SetStarred();
      }
      if (paramBoolean1) {
        SetReadSynced();
      }
      if (paramBoolean2) {
        SetStarSynced();
      }
    }
    
    public void ClearRead()
    {
      this._Data &= (READ ^ 0xFFFFFFFF);
      ClearReadSynced();
    }
    
    public void ClearReadSynced()
    {
      this._Data &= (READ_SYNCED ^ 0xFFFFFFFF);
    }
    
    public void ClearSharred()
    {
      this._Data &= (SHARED ^ 0xFFFFFFFF);
    }
    
    public void ClearStarSynced()
    {
      this._Data &= (STAR_SYNCED ^ 0xFFFFFFFF);
    }
    
    public void ClearStarred()
    {
      this._Data &= (STARRED ^ 0xFFFFFFFF);
      ClearStarSynced();
    }
    
    public boolean IsRead()
    {
      return (this._Data & READ) == READ;
    }
    
    public boolean IsReadSynced()
    {
      if (Configuration.IgnoreGoogleReaderReadStatus()) {}
      while ((this._Data & READ_SYNCED) != 0) {
        return true;
      }
      return false;
    }
    
    public boolean IsShared()
    {
      return (this._Data & SHARED) != 0;
    }
    
    public boolean IsStarSynced()
    {
      return (this._Data & STAR_SYNCED) != 0;
    }
    
    public boolean IsStarred()
    {
      return (this._Data & STARRED) == STARRED;
    }
    
    public void Read(DataInputStream paramDataInputStream)
      throws IOException
    {
      this._Data = paramDataInputStream.readInt();
    }
    
    public void SetRead()
    {
      this._Data |= READ;
      ClearReadSynced();
    }
    
    public void SetReadSynced()
    {
      this._Data |= READ_SYNCED;
    }
    
    public void SetShared()
    {
      this._Data |= SHARED;
    }
    
    public void SetStarSynced()
    {
      this._Data |= STAR_SYNCED;
    }
    
    public void SetStarred()
    {
      this._Data |= STARRED;
      ClearStarSynced();
    }
    
    public void Write(DataOutputStream paramDataOutputStream)
      throws IOException
    {
      paramDataOutputStream.writeInt(this._Data);
    }
    
    public String toString()
    {
      return String.format("RS:%s, SS:%s - R:%s, S:%s", new Object[] { Boolean.valueOf(IsReadSynced()), Boolean.valueOf(IsStarSynced()), Boolean.valueOf(IsRead()), Boolean.valueOf(IsStarred()) });
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/ItemStateHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */