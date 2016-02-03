package mobi.beyondpod.services.player;

import android.os.Handler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import mobi.beyondpod.R.string;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.rsscore.repository.RepositoryPersistence;

public class SmartPlaylistTemplate
{
  private static final String CATEGORY_LABEL = CoreHelper.LoadResourceString(R.string.smartplay_category_label);
  private static final String TAG = SmartPlaylistTemplate.class.getSimpleName();
  ArrayList<SmartPlaylistEntry> _Entries;
  Runnable _SaveToFileRunnable = new Runnable()
  {
    public void run()
    {
      SmartPlaylistTemplate.this.SaveToFileInternal();
    }
  };
  
  static boolean CanIncludeInPlaylist(Track paramTrack, List<Track> paramList)
  {
    if (paramTrack.IsPlayed()) {}
    while ((paramTrack.IsRemoteEpisode()) && ((paramTrack.getParentFeed().getPodcastDownloadAction() == 1) || (paramTrack.getParentFeed().getPodcastDownloadAction() == 4)) && (!paramTrack.HasDownloadStarted())) {
      return false;
    }
    return PlayList.CanAddToPlaylist(paramTrack, paramList);
  }
  
  public static boolean IsConfigured()
  {
    File localFile = new File(Configuration.SmartPlaylistFilePath());
    return (localFile.exists()) && (localFile.length() > 0L);
  }
  
  /* Error */
  private ArrayList<SmartPlaylistEntry> LoadFromFile()
  {
    // Byte code:
    //   0: invokestatic 110	mobi/beyondpod/rsscore/repository/FeedRepository:IsRepositoryAvailable	()Z
    //   3: ifne +13 -> 16
    //   6: getstatic 27	mobi/beyondpod/services/player/SmartPlaylistTemplate:TAG	Ljava/lang/String;
    //   9: ldc 112
    //   11: invokestatic 116	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aconst_null
    //   15: areturn
    //   16: aconst_null
    //   17: astore_1
    //   18: aconst_null
    //   19: astore_3
    //   20: new 118	java/util/ArrayList
    //   23: dup
    //   24: invokespecial 119	java/util/ArrayList:<init>	()V
    //   27: astore 4
    //   29: new 84	java/io/File
    //   32: dup
    //   33: invokestatic 89	mobi/beyondpod/rsscore/Configuration:SmartPlaylistFilePath	()Ljava/lang/String;
    //   36: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 95	java/io/File:exists	()Z
    //   44: ifeq +194 -> 238
    //   47: getstatic 27	mobi/beyondpod/services/player/SmartPlaylistTemplate:TAG	Ljava/lang/String;
    //   50: new 121	java/lang/StringBuilder
    //   53: dup
    //   54: ldc 123
    //   56: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: aload_2
    //   60: invokevirtual 99	java/io/File:length	()J
    //   63: invokevirtual 128	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   66: ldc -126
    //   68: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 139	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: new 141	java/io/FileInputStream
    //   80: dup
    //   81: aload_2
    //   82: invokespecial 144	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   85: astore_2
    //   86: new 146	java/io/DataInputStream
    //   89: dup
    //   90: aload_2
    //   91: invokespecial 149	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore_1
    //   95: aload_1
    //   96: invokestatic 153	mobi/beyondpod/services/player/SmartPlaylistTemplate$SmartPlaylistEntry:Deserialize	(Ljava/io/DataInputStream;)Lmobi/beyondpod/services/player/SmartPlaylistTemplate$SmartPlaylistEntry;
    //   99: astore_3
    //   100: aload_3
    //   101: ifnull -6 -> 95
    //   104: aload 4
    //   106: aload_3
    //   107: invokevirtual 157	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   110: pop
    //   111: goto -16 -> 95
    //   114: astore_1
    //   115: aload_2
    //   116: invokevirtual 160	java/io/FileInputStream:close	()V
    //   119: aload_2
    //   120: ifnull +141 -> 261
    //   123: aload_2
    //   124: invokevirtual 160	java/io/FileInputStream:close	()V
    //   127: getstatic 27	mobi/beyondpod/services/player/SmartPlaylistTemplate:TAG	Ljava/lang/String;
    //   130: new 121	java/lang/StringBuilder
    //   133: dup
    //   134: ldc -94
    //   136: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: aload 4
    //   141: invokevirtual 165	java/util/ArrayList:size	()I
    //   144: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   147: ldc -86
    //   149: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 139	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload 4
    //   160: areturn
    //   161: astore_1
    //   162: aload_3
    //   163: astore_2
    //   164: aload_1
    //   165: astore_3
    //   166: aload_2
    //   167: astore_1
    //   168: getstatic 27	mobi/beyondpod/services/player/SmartPlaylistTemplate:TAG	Ljava/lang/String;
    //   171: ldc -84
    //   173: aload_3
    //   174: invokestatic 176	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: aload_2
    //   178: ifnull -51 -> 127
    //   181: aload_2
    //   182: invokevirtual 160	java/io/FileInputStream:close	()V
    //   185: goto -58 -> 127
    //   188: astore_1
    //   189: getstatic 27	mobi/beyondpod/services/player/SmartPlaylistTemplate:TAG	Ljava/lang/String;
    //   192: ldc -84
    //   194: aload_1
    //   195: invokestatic 176	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   198: goto -71 -> 127
    //   201: astore_2
    //   202: aload_1
    //   203: ifnull +7 -> 210
    //   206: aload_1
    //   207: invokevirtual 160	java/io/FileInputStream:close	()V
    //   210: aload_2
    //   211: athrow
    //   212: astore_1
    //   213: getstatic 27	mobi/beyondpod/services/player/SmartPlaylistTemplate:TAG	Ljava/lang/String;
    //   216: ldc -84
    //   218: aload_1
    //   219: invokestatic 176	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: goto -12 -> 210
    //   225: astore_1
    //   226: getstatic 27	mobi/beyondpod/services/player/SmartPlaylistTemplate:TAG	Ljava/lang/String;
    //   229: ldc -84
    //   231: aload_1
    //   232: invokestatic 176	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   235: goto -108 -> 127
    //   238: getstatic 27	mobi/beyondpod/services/player/SmartPlaylistTemplate:TAG	Ljava/lang/String;
    //   241: ldc -78
    //   243: invokestatic 181	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntryInProduction	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: goto -119 -> 127
    //   249: astore_3
    //   250: aload_2
    //   251: astore_1
    //   252: aload_3
    //   253: astore_2
    //   254: goto -52 -> 202
    //   257: astore_3
    //   258: goto -92 -> 166
    //   261: goto -134 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	SmartPlaylistTemplate
    //   17	79	1	localDataInputStream	DataInputStream
    //   114	1	1	localEOFException	java.io.EOFException
    //   161	4	1	localException1	Exception
    //   167	1	1	localObject1	Object
    //   188	19	1	localException2	Exception
    //   212	7	1	localException3	Exception
    //   225	7	1	localException4	Exception
    //   251	1	1	localObject2	Object
    //   39	143	2	localObject3	Object
    //   201	50	2	localObject4	Object
    //   253	1	2	localObject5	Object
    //   19	155	3	localObject6	Object
    //   249	4	3	localObject7	Object
    //   257	1	3	localException5	Exception
    //   27	132	4	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   95	100	114	java/io/EOFException
    //   104	111	114	java/io/EOFException
    //   77	86	161	java/lang/Exception
    //   181	185	188	java/lang/Exception
    //   77	86	201	finally
    //   168	177	201	finally
    //   206	210	212	java/lang/Exception
    //   123	127	225	java/lang/Exception
    //   86	95	249	finally
    //   95	100	249	finally
    //   104	111	249	finally
    //   115	119	249	finally
    //   86	95	257	java/lang/Exception
    //   95	100	257	java/lang/Exception
    //   104	111	257	java/lang/Exception
    //   115	119	257	java/lang/Exception
  }
  
  /* Error */
  private void SaveToFileInternal()
  {
    // Byte code:
    //   0: invokestatic 89	mobi/beyondpod/rsscore/Configuration:SmartPlaylistFilePath	()Ljava/lang/String;
    //   3: astore 5
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore 4
    //   10: aload_3
    //   11: astore_2
    //   12: getstatic 27	mobi/beyondpod/services/player/SmartPlaylistTemplate:TAG	Ljava/lang/String;
    //   15: new 121	java/lang/StringBuilder
    //   18: dup
    //   19: ldc -71
    //   21: invokespecial 124	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: invokevirtual 186	mobi/beyondpod/services/player/SmartPlaylistTemplate:size	()I
    //   28: invokevirtual 168	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc -68
    //   33: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 139	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteTraceEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_3
    //   43: astore_2
    //   44: new 190	java/io/FileOutputStream
    //   47: dup
    //   48: aload 5
    //   50: invokespecial 191	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   53: astore_3
    //   54: new 193	java/io/DataOutputStream
    //   57: dup
    //   58: aload_3
    //   59: invokespecial 196	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   62: astore_2
    //   63: iconst_0
    //   64: istore_1
    //   65: iload_1
    //   66: aload_0
    //   67: invokevirtual 186	mobi/beyondpod/services/player/SmartPlaylistTemplate:size	()I
    //   70: if_icmpne +24 -> 94
    //   73: aload_3
    //   74: invokestatic 200	mobi/beyondpod/rsscore/helpers/CoreHelper:sync	(Ljava/io/FileOutputStream;)Z
    //   77: pop
    //   78: aload_3
    //   79: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   82: aload_3
    //   83: ifnull +110 -> 193
    //   86: aload_3
    //   87: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   90: invokestatic 206	mobi/beyondpod/rsscore/StartupContentBuilder:BackupRepositoriesAsync	()V
    //   93: return
    //   94: aload_0
    //   95: invokevirtual 209	mobi/beyondpod/services/player/SmartPlaylistTemplate:Entries	()Ljava/util/ArrayList;
    //   98: iload_1
    //   99: invokevirtual 213	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   102: checkcast 8	mobi/beyondpod/services/player/SmartPlaylistTemplate$SmartPlaylistEntry
    //   105: aload_2
    //   106: invokevirtual 217	mobi/beyondpod/services/player/SmartPlaylistTemplate$SmartPlaylistEntry:Serialize	(Ljava/io/DataOutputStream;)V
    //   109: iload_1
    //   110: iconst_1
    //   111: iadd
    //   112: istore_1
    //   113: goto -48 -> 65
    //   116: astore_2
    //   117: aload 4
    //   119: astore_3
    //   120: aload_2
    //   121: astore 4
    //   123: aload_3
    //   124: astore_2
    //   125: getstatic 27	mobi/beyondpod/services/player/SmartPlaylistTemplate:TAG	Ljava/lang/String;
    //   128: ldc -37
    //   130: aload 4
    //   132: invokestatic 176	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: aload_3
    //   136: ifnull -46 -> 90
    //   139: aload_3
    //   140: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   143: goto -53 -> 90
    //   146: astore_2
    //   147: getstatic 27	mobi/beyondpod/services/player/SmartPlaylistTemplate:TAG	Ljava/lang/String;
    //   150: ldc -37
    //   152: aload_2
    //   153: invokestatic 176	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   156: goto -66 -> 90
    //   159: astore_3
    //   160: aload_2
    //   161: ifnull +7 -> 168
    //   164: aload_2
    //   165: invokevirtual 201	java/io/FileOutputStream:close	()V
    //   168: aload_3
    //   169: athrow
    //   170: astore_2
    //   171: getstatic 27	mobi/beyondpod/services/player/SmartPlaylistTemplate:TAG	Ljava/lang/String;
    //   174: ldc -37
    //   176: aload_2
    //   177: invokestatic 176	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   180: goto -12 -> 168
    //   183: astore_2
    //   184: getstatic 27	mobi/beyondpod/services/player/SmartPlaylistTemplate:TAG	Ljava/lang/String;
    //   187: ldc -37
    //   189: aload_2
    //   190: invokestatic 176	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   193: goto -103 -> 90
    //   196: astore 4
    //   198: aload_3
    //   199: astore_2
    //   200: aload 4
    //   202: astore_3
    //   203: goto -43 -> 160
    //   206: astore 4
    //   208: goto -85 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	SmartPlaylistTemplate
    //   64	49	1	i	int
    //   11	95	2	localObject1	Object
    //   116	5	2	localException1	Exception
    //   124	1	2	localObject2	Object
    //   146	19	2	localException2	Exception
    //   170	7	2	localException3	Exception
    //   183	7	2	localException4	Exception
    //   199	1	2	localObject3	Object
    //   6	134	3	localObject4	Object
    //   159	40	3	localObject5	Object
    //   202	1	3	localObject6	Object
    //   8	123	4	localObject7	Object
    //   196	5	4	localObject8	Object
    //   206	1	4	localException5	Exception
    //   3	46	5	str	String
    // Exception table:
    //   from	to	target	type
    //   12	42	116	java/lang/Exception
    //   44	54	116	java/lang/Exception
    //   139	143	146	java/lang/Exception
    //   12	42	159	finally
    //   44	54	159	finally
    //   125	135	159	finally
    //   164	168	170	java/lang/Exception
    //   86	90	183	java/lang/Exception
    //   54	63	196	finally
    //   65	82	196	finally
    //   94	109	196	finally
    //   54	63	206	java/lang/Exception
    //   65	82	206	java/lang/Exception
    //   94	109	206	java/lang/Exception
  }
  
  public void Clear()
  {
    Entries().clear();
  }
  
  public ArrayList<SmartPlaylistEntry> Entries()
  {
    if (this._Entries == null) {
      this._Entries = LoadFromFile();
    }
    return this._Entries;
  }
  
  public List<Track> GeneratePlaylist()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = Entries().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localArrayList;
      }
      localArrayList.addAll(((SmartPlaylistEntry)localIterator.next()).GetTracks(localArrayList));
    }
  }
  
  public boolean HasEntryForCategory(FeedCategory paramFeedCategory)
  {
    int i = 0;
    for (;;)
    {
      if (i == size()) {
        return false;
      }
      SmartPlaylistEntry localSmartPlaylistEntry = (SmartPlaylistEntry)Entries().get(i);
      if ((localSmartPlaylistEntry.Category != null) && (localSmartPlaylistEntry.Category.equals(paramFeedCategory))) {
        return true;
      }
      i += 1;
    }
  }
  
  public boolean IsEmpty()
  {
    return Entries().size() == 0;
  }
  
  public boolean IsLoaded()
  {
    return Entries() != null;
  }
  
  public void SaveToFile()
  {
    RepositoryPersistence.RepositoryHandler().removeCallbacks(this._SaveToFileRunnable);
    RepositoryPersistence.RepositoryHandler().postDelayed(this._SaveToFileRunnable, 100L);
  }
  
  public void SwapItems(int paramInt1, int paramInt2)
  {
    SmartPlaylistEntry localSmartPlaylistEntry = (SmartPlaylistEntry)Entries().get(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= size())) {
      return;
    }
    Entries().set(paramInt1, (SmartPlaylistEntry)Entries().get(paramInt2));
    Entries().set(paramInt2, localSmartPlaylistEntry);
  }
  
  public int size()
  {
    return Entries().size();
  }
  
  public static class SmartPlaylistEntry
  {
    public FeedCategory Category;
    public int ContentType = -2;
    public Feed Feed;
    public int NumTracks;
    public int SortOrder = 2;
    
    public SmartPlaylistEntry(Integer paramInteger1, Integer paramInteger2)
    {
      this.NumTracks = paramInteger1.intValue();
      this.SortOrder = paramInteger2.intValue();
    }
    
    public SmartPlaylistEntry(Feed paramFeed, Integer paramInteger1, Integer paramInteger2)
    {
      this(paramInteger1, paramInteger2);
      this.Feed = paramFeed;
    }
    
    public SmartPlaylistEntry(FeedCategory paramFeedCategory, Integer paramInteger1, Integer paramInteger2)
    {
      this(paramInteger1, paramInteger2);
      this.Category = paramFeedCategory;
    }
    
    public static SmartPlaylistEntry Deserialize(DataInputStream paramDataInputStream)
      throws IOException
    {
      Object localObject3 = null;
      Object localObject6 = null;
      Object localObject2 = null;
      Object localObject1 = localObject3;
      try
      {
        String str = paramDataInputStream.readUTF();
        localObject1 = localObject3;
        localObject2 = str;
        FeedCategory localFeedCategory = CategoryManager.GetCategoryByValue(str);
        localObject4 = localFeedCategory;
        localObject5 = localObject6;
        localObject3 = str;
        localObject1 = localFeedCategory;
        localObject2 = str;
        if (localFeedCategory == CategoryManager.CategoryNull)
        {
          localObject1 = localFeedCategory;
          localObject2 = str;
          localObject5 = FeedRepository.GetFeedById(UUID.fromString(str));
          localObject3 = str;
          localObject4 = localFeedCategory;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Object localObject4;
        for (;;)
        {
          CoreHelper.WriteLogEntry(SmartPlaylistTemplate.TAG, "Failed to parse UUID from string: " + (String)localObject2);
          localObject4 = localObject1;
          Object localObject5 = localObject6;
          localObject3 = localObject2;
        }
        if (localObject4 == CategoryManager.CategoryNull) {
          break label161;
        }
        return new SmartPlaylistEntry((FeedCategory)localObject4, (Integer)localObject1, paramDataInputStream);
        label161:
        CoreHelper.WriteLogEntryInProduction(SmartPlaylistTemplate.TAG, "Unable to find feed or category with ID " + (String)localObject3 + " in the repository");
      }
      localObject1 = Integer.valueOf(paramDataInputStream.readInt());
      paramDataInputStream = Integer.valueOf(paramDataInputStream.readInt());
      if (localObject5 != null) {
        return new SmartPlaylistEntry((Feed)localObject5, (Integer)localObject1, paramDataInputStream);
      }
      return null;
    }
    
    public List<Feed> GetFeeds()
    {
      FeedList localFeedList = new FeedList();
      if (this.Feed != null) {
        localFeedList.add(this.Feed);
      }
      for (;;)
      {
        return localFeedList;
        Iterator localIterator = FeedRepository.getRootFeed().SubFeeds().iterator();
        while (localIterator.hasNext())
        {
          Feed localFeed = (Feed)localIterator.next();
          if (CategoryManager.IsInCategory(localFeed, this.Category)) {
            localFeedList.add(localFeed);
          }
        }
      }
    }
    
    public List<Track> GetTracks(List<Track> paramList)
    {
      if (this.Feed != null) {
        return FeedPlaylistTemplate.GeneratePlaylist(this.Feed, this.NumTracks, this.SortOrder, this.ContentType, paramList);
      }
      return CategoryPlaylistTemplate.GeneratePlaylist(this.Category, this.NumTracks, this.SortOrder, this.ContentType, paramList);
    }
    
    public void Serialize(DataOutputStream paramDataOutputStream)
      throws IOException
    {
      if (this.Feed != null) {
        paramDataOutputStream.writeUTF(this.Feed.ID().toString());
      }
      for (;;)
      {
        paramDataOutputStream.writeInt(this.NumTracks);
        paramDataOutputStream.writeInt(this.SortOrder);
        do
        {
          return;
        } while (this.Category == null);
        paramDataOutputStream.writeUTF(this.Category.Value());
      }
    }
    
    public String toString()
    {
      if (this.Feed != null) {
        return this.Feed.toString();
      }
      if (this.Category != null) {
        return SmartPlaylistTemplate.CATEGORY_LABEL + ": " + this.Category.toString();
      }
      return "";
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/services/player/SmartPlaylistTemplate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */