package mobi.beyondpod.rsscore.repository;

import java.util.Iterator;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.Track;
import mobi.beyondpod.rsscore.TrackDictionary;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.FileUtils;
import mobi.beyondpod.schedulercore.ScheduledTask;

public class XMLRepositoryStorage
  implements IRepositoryStorage
{
  private static final String TAG = "XMLRepositoryStorage";
  
  /* Error */
  private TrackDictionary LoadRepositoryInternal(String paramString)
    throws Throwable
  {
    // Byte code:
    //   0: new 21	mobi/beyondpod/rsscore/TrackDictionary
    //   3: dup
    //   4: invokespecial 22	mobi/beyondpod/rsscore/TrackDictionary:<init>	()V
    //   7: astore 4
    //   9: ldc 10
    //   11: ldc 24
    //   13: invokestatic 30	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntryInProduction	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: invokestatic 36	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   19: invokevirtual 40	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   22: invokevirtual 46	javax/xml/parsers/SAXParser:getXMLReader	()Lorg/xml/sax/XMLReader;
    //   25: astore 6
    //   27: aload 6
    //   29: new 48	mobi/beyondpod/rsscore/repository/RepositoryHandler
    //   32: dup
    //   33: aload 4
    //   35: invokestatic 54	mobi/beyondpod/rsscore/repository/FeedRepository:getRootFeed	()Lmobi/beyondpod/rsscore/Feed;
    //   38: invokespecial 57	mobi/beyondpod/rsscore/repository/RepositoryHandler:<init>	(Lmobi/beyondpod/rsscore/TrackDictionary;Lmobi/beyondpod/rsscore/Feed;)V
    //   41: invokeinterface 63 2 0
    //   46: aconst_null
    //   47: astore_2
    //   48: aconst_null
    //   49: astore 5
    //   51: new 65	java/io/FileInputStream
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 68	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   59: astore_3
    //   60: aload 6
    //   62: new 70	org/xml/sax/InputSource
    //   65: dup
    //   66: aload_3
    //   67: invokespecial 73	org/xml/sax/InputSource:<init>	(Ljava/io/InputStream;)V
    //   70: invokeinterface 77 2 0
    //   75: aload_3
    //   76: ifnull +7 -> 83
    //   79: aload_3
    //   80: invokevirtual 80	java/io/FileInputStream:close	()V
    //   83: invokestatic 83	mobi/beyondpod/rsscore/repository/FeedRepository:OnRepositoryScaningForChanges	()V
    //   86: aload 4
    //   88: areturn
    //   89: astore 4
    //   91: aload 5
    //   93: astore_3
    //   94: aload_3
    //   95: astore_2
    //   96: ldc 10
    //   98: ldc 85
    //   100: iconst_2
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_1
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload 4
    //   112: invokevirtual 89	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   115: aastore
    //   116: invokestatic 95	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   119: invokestatic 98	mobi/beyondpod/rsscore/helpers/CoreHelper:WriteLogEntry	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_3
    //   123: astore_2
    //   124: aload 4
    //   126: athrow
    //   127: astore_1
    //   128: aload_2
    //   129: ifnull +7 -> 136
    //   132: aload_2
    //   133: invokevirtual 80	java/io/FileInputStream:close	()V
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: aload_3
    //   140: astore_2
    //   141: goto -13 -> 128
    //   144: astore 4
    //   146: goto -52 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	XMLRepositoryStorage
    //   0	149	1	paramString	String
    //   47	94	2	localObject1	Object
    //   59	81	3	localObject2	Object
    //   7	80	4	localTrackDictionary	TrackDictionary
    //   89	36	4	localThrowable1	Throwable
    //   144	1	4	localThrowable2	Throwable
    //   49	43	5	localObject3	Object
    //   25	36	6	localXMLReader	org.xml.sax.XMLReader
    // Exception table:
    //   from	to	target	type
    //   51	60	89	java/lang/Throwable
    //   51	60	127	finally
    //   96	122	127	finally
    //   124	127	127	finally
    //   60	75	138	finally
    //   60	75	144	java/lang/Throwable
  }
  
  /* Error */
  public void BackupRepositoryToFile(String paramString)
  {
    // Byte code:
    //   0: getstatic 106	mobi/beyondpod/rsscore/repository/FeedRepository:_TrackDictionary	Lmobi/beyondpod/rsscore/TrackDictionary;
    //   3: astore 5
    //   5: aload 5
    //   7: monitorenter
    //   8: invokestatic 109	mobi/beyondpod/rsscore/repository/FeedRepository:OnRepositorySaveStart	()V
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore 4
    //   16: new 111	mobi/beyondpod/rsscore/helpers/XmlTextWriter
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 112	mobi/beyondpod/rsscore/helpers/XmlTextWriter:<init>	(Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 115	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartDocument	()V
    //   29: aload_1
    //   30: ldc 117
    //   32: invokevirtual 120	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartElement	(Ljava/lang/String;)V
    //   35: aload_1
    //   36: ldc 122
    //   38: invokevirtual 120	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartElement	(Ljava/lang/String;)V
    //   41: aload_1
    //   42: invokestatic 127	mobi/beyondpod/rsscore/categories/CategoryManager:Serialize	()Ljava/lang/String;
    //   45: invokevirtual 130	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteString	(Ljava/lang/String;)V
    //   48: aload_1
    //   49: ldc 122
    //   51: invokevirtual 133	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteEndElement	(Ljava/lang/String;)V
    //   54: aload_1
    //   55: invokestatic 139	mobi/beyondpod/schedulercore/ScheduledTasksManager:SaveTasks	(Lmobi/beyondpod/rsscore/helpers/XmlTextWriter;)V
    //   58: aload_1
    //   59: ldc -115
    //   61: invokevirtual 120	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartElement	(Ljava/lang/String;)V
    //   64: aload_1
    //   65: ldc -113
    //   67: invokestatic 149	mobi/beyondpod/rsscore/rss/LicenseManager:TrialStartDate	()Ljava/util/Date;
    //   70: invokestatic 155	mobi/beyondpod/rsscore/helpers/DateTime:ToLongString	(Ljava/util/Date;)Ljava/lang/String;
    //   73: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: getstatic 106	mobi/beyondpod/rsscore/repository/FeedRepository:_TrackDictionary	Lmobi/beyondpod/rsscore/TrackDictionary;
    //   79: invokevirtual 162	mobi/beyondpod/rsscore/TrackDictionary:values	()Ljava/util/Collection;
    //   82: invokeinterface 168 1 0
    //   87: astore_3
    //   88: aload_3
    //   89: invokeinterface 174 1 0
    //   94: ifne +65 -> 159
    //   97: aload_1
    //   98: ldc -115
    //   100: invokevirtual 133	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteEndElement	(Ljava/lang/String;)V
    //   103: aload_1
    //   104: ldc -80
    //   106: invokevirtual 120	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartElement	(Ljava/lang/String;)V
    //   109: invokestatic 54	mobi/beyondpod/rsscore/repository/FeedRepository:getRootFeed	()Lmobi/beyondpod/rsscore/Feed;
    //   112: invokevirtual 182	mobi/beyondpod/rsscore/Feed:SubFeeds	()Lmobi/beyondpod/rsscore/FeedList;
    //   115: invokevirtual 185	mobi/beyondpod/rsscore/FeedList:iterator	()Ljava/util/Iterator;
    //   118: astore_3
    //   119: aload_3
    //   120: invokeinterface 174 1 0
    //   125: ifne +315 -> 440
    //   128: aload_1
    //   129: ldc -80
    //   131: invokevirtual 133	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteEndElement	(Ljava/lang/String;)V
    //   134: aload_1
    //   135: ldc 117
    //   137: invokevirtual 133	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteEndElement	(Ljava/lang/String;)V
    //   140: aload_1
    //   141: invokevirtual 186	mobi/beyondpod/rsscore/helpers/XmlTextWriter:close	()V
    //   144: aload_1
    //   145: ifnull +853 -> 998
    //   148: aload_1
    //   149: invokevirtual 186	mobi/beyondpod/rsscore/helpers/XmlTextWriter:close	()V
    //   152: invokestatic 189	mobi/beyondpod/rsscore/repository/FeedRepository:OnRepositorySaveComplete	()V
    //   155: aload 5
    //   157: monitorexit
    //   158: return
    //   159: aload_3
    //   160: invokeinterface 193 1 0
    //   165: checkcast 195	mobi/beyondpod/rsscore/Track
    //   168: astore 4
    //   170: aload_1
    //   171: ldc -59
    //   173: invokevirtual 120	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartElement	(Ljava/lang/String;)V
    //   176: aload_1
    //   177: ldc -57
    //   179: aload 4
    //   181: invokevirtual 202	mobi/beyondpod/rsscore/Track:TrackPath	()Ljava/lang/String;
    //   184: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_1
    //   188: ldc -52
    //   190: aload 4
    //   192: invokevirtual 208	mobi/beyondpod/rsscore/Track:getTotalTime	()J
    //   195: invokestatic 214	mobi/beyondpod/rsscore/helpers/StringUtils:LongToInvariantCultureString	(J)Ljava/lang/String;
    //   198: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_1
    //   202: ldc -40
    //   204: aload 4
    //   206: invokevirtual 219	mobi/beyondpod/rsscore/Track:getPlayedTime	()J
    //   209: invokestatic 214	mobi/beyondpod/rsscore/helpers/StringUtils:LongToInvariantCultureString	(J)Ljava/lang/String;
    //   212: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload_1
    //   216: ldc -35
    //   218: aload 4
    //   220: invokevirtual 224	mobi/beyondpod/rsscore/Track:getName	()Ljava/lang/String;
    //   223: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_1
    //   227: ldc -30
    //   229: aload 4
    //   231: invokevirtual 229	mobi/beyondpod/rsscore/Track:ContentMimeType	()Ljava/lang/String;
    //   234: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload 4
    //   239: invokevirtual 232	mobi/beyondpod/rsscore/Track:IsPlayed	()Z
    //   242: ifeq +191 -> 433
    //   245: ldc -22
    //   247: astore_2
    //   248: aload_1
    //   249: ldc -20
    //   251: aload_2
    //   252: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload_1
    //   256: ldc -18
    //   258: aload 4
    //   260: invokevirtual 241	mobi/beyondpod/rsscore/Track:getProtocol	()Ljava/lang/String;
    //   263: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload_1
    //   267: ldc -13
    //   269: aload 4
    //   271: invokevirtual 246	mobi/beyondpod/rsscore/Track:TrackImagePath	()Ljava/lang/String;
    //   274: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: aload_1
    //   278: ldc -8
    //   280: aload 4
    //   282: invokevirtual 251	mobi/beyondpod/rsscore/Track:TrackDescription	()Ljava/lang/String;
    //   285: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload_1
    //   289: ldc -3
    //   291: aload 4
    //   293: invokevirtual 256	mobi/beyondpod/rsscore/Track:TrackPostTitle	()Ljava/lang/String;
    //   296: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload_1
    //   300: ldc_w 258
    //   303: aload 4
    //   305: invokevirtual 261	mobi/beyondpod/rsscore/Track:TrackPostUrl	()Ljava/lang/String;
    //   308: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload 4
    //   313: invokevirtual 264	mobi/beyondpod/rsscore/Track:Locked	()Z
    //   316: ifeq +685 -> 1001
    //   319: ldc -22
    //   321: astore_2
    //   322: aload_1
    //   323: ldc_w 266
    //   326: aload_2
    //   327: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload_1
    //   331: ldc_w 268
    //   334: aload 4
    //   336: invokevirtual 271	mobi/beyondpod/rsscore/Track:getUrl	()Ljava/lang/String;
    //   339: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: aload_1
    //   343: ldc_w 273
    //   346: aload 4
    //   348: invokevirtual 276	mobi/beyondpod/rsscore/Track:getDownloadSize	()J
    //   351: invokestatic 214	mobi/beyondpod/rsscore/helpers/StringUtils:LongToInvariantCultureString	(J)Ljava/lang/String;
    //   354: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload_1
    //   358: ldc_w 278
    //   361: aload 4
    //   363: invokevirtual 281	mobi/beyondpod/rsscore/Track:getDownloadedPortion	()J
    //   366: invokestatic 214	mobi/beyondpod/rsscore/helpers/StringUtils:LongToInvariantCultureString	(J)Ljava/lang/String;
    //   369: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload 4
    //   374: invokevirtual 284	mobi/beyondpod/rsscore/Track:getLastModifiedDate	()Ljava/util/Date;
    //   377: ifnull +631 -> 1008
    //   380: aload 4
    //   382: invokevirtual 284	mobi/beyondpod/rsscore/Track:getLastModifiedDate	()Ljava/util/Date;
    //   385: invokestatic 155	mobi/beyondpod/rsscore/helpers/DateTime:ToLongString	(Ljava/util/Date;)Ljava/lang/String;
    //   388: astore_2
    //   389: aload_1
    //   390: ldc_w 286
    //   393: aload_2
    //   394: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: aload_1
    //   398: ldc -59
    //   400: invokevirtual 133	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteEndElement	(Ljava/lang/String;)V
    //   403: goto -315 -> 88
    //   406: astore_3
    //   407: aload_1
    //   408: astore_2
    //   409: ldc 10
    //   411: ldc_w 288
    //   414: aload_3
    //   415: invokestatic 292	mobi/beyondpod/rsscore/helpers/CoreHelper:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   418: aload_1
    //   419: ifnull -267 -> 152
    //   422: aload_1
    //   423: invokevirtual 186	mobi/beyondpod/rsscore/helpers/XmlTextWriter:close	()V
    //   426: goto -274 -> 152
    //   429: astore_1
    //   430: goto -278 -> 152
    //   433: ldc_w 294
    //   436: astore_2
    //   437: goto -189 -> 248
    //   440: aload_3
    //   441: invokeinterface 193 1 0
    //   446: checkcast 178	mobi/beyondpod/rsscore/Feed
    //   449: astore 4
    //   451: aload_1
    //   452: ldc_w 296
    //   455: invokevirtual 120	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteStartElement	(Ljava/lang/String;)V
    //   458: aload_1
    //   459: ldc_w 298
    //   462: aload 4
    //   464: invokevirtual 302	mobi/beyondpod/rsscore/Feed:ID	()Ljava/util/UUID;
    //   467: invokevirtual 307	java/util/UUID:toString	()Ljava/lang/String;
    //   470: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   473: aload_1
    //   474: ldc -57
    //   476: aload 4
    //   478: invokevirtual 310	mobi/beyondpod/rsscore/Feed:GetRawFeedPath	()Ljava/lang/String;
    //   481: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   484: aload_1
    //   485: ldc -35
    //   487: aload 4
    //   489: invokevirtual 311	mobi/beyondpod/rsscore/Feed:getName	()Ljava/lang/String;
    //   492: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: aload_1
    //   496: ldc_w 313
    //   499: aload 4
    //   501: invokevirtual 317	mobi/beyondpod/rsscore/Feed:getAllowAutoTrackDeletions	()I
    //   504: invokestatic 322	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   507: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   510: aload_1
    //   511: ldc_w 324
    //   514: aload 4
    //   516: invokevirtual 327	mobi/beyondpod/rsscore/Feed:getPreferredEnclosureIndex	()I
    //   519: invokestatic 322	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   522: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload_1
    //   526: ldc_w 329
    //   529: aload 4
    //   531: invokevirtual 332	mobi/beyondpod/rsscore/Feed:getType	()I
    //   534: invokestatic 322	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   537: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: aload_1
    //   541: ldc_w 268
    //   544: aload 4
    //   546: invokevirtual 335	mobi/beyondpod/rsscore/Feed:getFeedUrl	()Ljava/lang/String;
    //   549: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: aload_1
    //   553: ldc_w 337
    //   556: aload 4
    //   558: invokevirtual 340	mobi/beyondpod/rsscore/Feed:getFeedImageUrl	()Ljava/lang/String;
    //   561: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: aload_1
    //   565: ldc_w 342
    //   568: aload 4
    //   570: invokevirtual 345	mobi/beyondpod/rsscore/Feed:NumUnreadItems	()I
    //   573: invokestatic 322	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   576: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: aload 4
    //   581: invokevirtual 346	mobi/beyondpod/rsscore/Feed:getLastModifiedDate	()Ljava/util/Date;
    //   584: ifnull +377 -> 961
    //   587: aload 4
    //   589: invokevirtual 346	mobi/beyondpod/rsscore/Feed:getLastModifiedDate	()Ljava/util/Date;
    //   592: invokestatic 155	mobi/beyondpod/rsscore/helpers/DateTime:ToLongString	(Ljava/util/Date;)Ljava/lang/String;
    //   595: astore_2
    //   596: aload_1
    //   597: ldc_w 286
    //   600: aload_2
    //   601: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   604: aload 4
    //   606: invokevirtual 349	mobi/beyondpod/rsscore/Feed:getLastServerModifiedDate	()Ljava/util/Date;
    //   609: ifnull +406 -> 1015
    //   612: aload 4
    //   614: invokevirtual 349	mobi/beyondpod/rsscore/Feed:getLastServerModifiedDate	()Ljava/util/Date;
    //   617: invokestatic 155	mobi/beyondpod/rsscore/helpers/DateTime:ToLongString	(Ljava/util/Date;)Ljava/lang/String;
    //   620: astore_2
    //   621: aload_1
    //   622: ldc_w 351
    //   625: aload_2
    //   626: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: aload_1
    //   630: ldc_w 353
    //   633: aload 4
    //   635: invokevirtual 357	mobi/beyondpod/rsscore/Feed:getCategories	()Lmobi/beyondpod/rsscore/categories/FeedCategories;
    //   638: invokevirtual 360	mobi/beyondpod/rsscore/categories/FeedCategories:Serialize	()Ljava/lang/String;
    //   641: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: aload_1
    //   645: ldc_w 362
    //   648: aload 4
    //   650: invokevirtual 365	mobi/beyondpod/rsscore/Feed:getPodcastDownloadAction	()I
    //   653: invokestatic 322	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   656: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   659: aload 4
    //   661: invokevirtual 368	mobi/beyondpod/rsscore/Feed:getForceUniqueTrackNames	()Z
    //   664: ifeq +358 -> 1022
    //   667: ldc -22
    //   669: astore_2
    //   670: aload_1
    //   671: ldc_w 370
    //   674: aload_2
    //   675: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   678: aload 4
    //   680: invokevirtual 373	mobi/beyondpod/rsscore/Feed:getShouldRememberPlayedPosition	()Z
    //   683: ifeq +346 -> 1029
    //   686: ldc -22
    //   688: astore_2
    //   689: aload_1
    //   690: ldc_w 375
    //   693: aload_2
    //   694: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: aload_1
    //   698: ldc_w 377
    //   701: aload 4
    //   703: invokevirtual 380	mobi/beyondpod/rsscore/Feed:getItemFingerprintAlgorithm	()I
    //   706: invokestatic 322	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   709: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   712: aload 4
    //   714: invokevirtual 383	mobi/beyondpod/rsscore/Feed:getLeftTruncateLongTrackNames	()Z
    //   717: ifeq +251 -> 968
    //   720: ldc -22
    //   722: astore_2
    //   723: aload_1
    //   724: ldc_w 385
    //   727: aload_2
    //   728: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   731: aload_1
    //   732: ldc_w 387
    //   735: aload 4
    //   737: invokevirtual 390	mobi/beyondpod/rsscore/Feed:getForceFeedItemSort	()I
    //   740: invokestatic 322	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   743: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   746: aload 4
    //   748: invokevirtual 393	mobi/beyondpod/rsscore/Feed:getLastItemID	()Ljava/lang/String;
    //   751: ifnull +15 -> 766
    //   754: aload_1
    //   755: ldc_w 395
    //   758: aload 4
    //   760: invokevirtual 393	mobi/beyondpod/rsscore/Feed:getLastItemID	()Ljava/lang/String;
    //   763: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   766: aload 4
    //   768: invokevirtual 398	mobi/beyondpod/rsscore/Feed:getTrackSortOrder	()I
    //   771: invokestatic 403	mobi/beyondpod/rsscore/Configuration:getPodcastsSortOrder	()I
    //   774: if_icmpeq +18 -> 792
    //   777: aload_1
    //   778: ldc_w 405
    //   781: aload 4
    //   783: invokevirtual 398	mobi/beyondpod/rsscore/Feed:getTrackSortOrder	()I
    //   786: invokestatic 322	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   789: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   792: aload_1
    //   793: ldc_w 407
    //   796: aload 4
    //   798: invokevirtual 410	mobi/beyondpod/rsscore/Feed:getFeedPlayer	()I
    //   801: invokestatic 322	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   804: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   807: aload 4
    //   809: invokevirtual 413	mobi/beyondpod/rsscore/Feed:getUserName	()Ljava/lang/String;
    //   812: invokestatic 417	mobi/beyondpod/rsscore/helpers/StringUtils:IsNullOrEmpty	(Ljava/lang/String;)Z
    //   815: ifne +15 -> 830
    //   818: aload_1
    //   819: ldc_w 419
    //   822: aload 4
    //   824: invokevirtual 413	mobi/beyondpod/rsscore/Feed:getUserName	()Ljava/lang/String;
    //   827: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: aload_1
    //   831: ldc_w 421
    //   834: aload 4
    //   836: invokevirtual 424	mobi/beyondpod/rsscore/Feed:getMaxNumberPodcastToDownload	()I
    //   839: invokestatic 322	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   842: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   845: aload 4
    //   847: invokevirtual 427	mobi/beyondpod/rsscore/Feed:getMaxNumGReaderItemsToGet	()I
    //   850: ifle +18 -> 868
    //   853: aload_1
    //   854: ldc_w 429
    //   857: aload 4
    //   859: invokevirtual 427	mobi/beyondpod/rsscore/Feed:getMaxNumGReaderItemsToGet	()I
    //   862: invokestatic 322	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   865: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   868: aload 4
    //   870: invokevirtual 432	mobi/beyondpod/rsscore/Feed:getKeepAtMostPodcasts	()I
    //   873: invokestatic 435	mobi/beyondpod/rsscore/Configuration:getGlobalDefaultKeepAtMostPodcasts	()I
    //   876: if_icmpeq +18 -> 894
    //   879: aload_1
    //   880: ldc_w 437
    //   883: aload 4
    //   885: invokevirtual 432	mobi/beyondpod/rsscore/Feed:getKeepAtMostPodcasts	()I
    //   888: invokestatic 322	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   891: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   894: aload 4
    //   896: invokevirtual 441	mobi/beyondpod/rsscore/Feed:getMaximumPodcastAge	()Lmobi/beyondpod/rsscore/helpers/TimeSpan;
    //   899: invokestatic 444	mobi/beyondpod/rsscore/Configuration:getGlobalDefaultMaximumPodcastAge	()Lmobi/beyondpod/rsscore/helpers/TimeSpan;
    //   902: if_acmpeq +22 -> 924
    //   905: aload_1
    //   906: ldc_w 446
    //   909: aload 4
    //   911: invokevirtual 441	mobi/beyondpod/rsscore/Feed:getMaximumPodcastAge	()Lmobi/beyondpod/rsscore/helpers/TimeSpan;
    //   914: invokevirtual 452	mobi/beyondpod/rsscore/helpers/TimeSpan:getTotalDays	()D
    //   917: d2i
    //   918: invokestatic 322	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   921: invokevirtual 158	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteAttributeString	(Ljava/lang/String;Ljava/lang/String;)V
    //   924: aload_1
    //   925: ldc_w 296
    //   928: invokevirtual 133	mobi/beyondpod/rsscore/helpers/XmlTextWriter:WriteEndElement	(Ljava/lang/String;)V
    //   931: goto -812 -> 119
    //   934: astore_3
    //   935: aload_1
    //   936: astore_2
    //   937: aload_3
    //   938: astore_1
    //   939: aload_2
    //   940: ifnull +7 -> 947
    //   943: aload_2
    //   944: invokevirtual 186	mobi/beyondpod/rsscore/helpers/XmlTextWriter:close	()V
    //   947: aload_1
    //   948: athrow
    //   949: astore_1
    //   950: invokestatic 189	mobi/beyondpod/rsscore/repository/FeedRepository:OnRepositorySaveComplete	()V
    //   953: aload_1
    //   954: athrow
    //   955: astore_1
    //   956: aload 5
    //   958: monitorexit
    //   959: aload_1
    //   960: athrow
    //   961: ldc_w 454
    //   964: astore_2
    //   965: goto -369 -> 596
    //   968: ldc_w 294
    //   971: astore_2
    //   972: goto -249 -> 723
    //   975: astore_1
    //   976: goto -824 -> 152
    //   979: astore_2
    //   980: goto -33 -> 947
    //   983: astore_1
    //   984: goto -34 -> 950
    //   987: astore_1
    //   988: goto -49 -> 939
    //   991: astore_3
    //   992: aload 4
    //   994: astore_1
    //   995: goto -588 -> 407
    //   998: goto -846 -> 152
    //   1001: ldc_w 294
    //   1004: astore_2
    //   1005: goto -683 -> 322
    //   1008: ldc_w 454
    //   1011: astore_2
    //   1012: goto -623 -> 389
    //   1015: ldc_w 454
    //   1018: astore_2
    //   1019: goto -398 -> 621
    //   1022: ldc_w 294
    //   1025: astore_2
    //   1026: goto -356 -> 670
    //   1029: ldc_w 294
    //   1032: astore_2
    //   1033: goto -344 -> 689
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1036	0	this	XMLRepositoryStorage
    //   0	1036	1	paramString	String
    //   12	960	2	str1	String
    //   979	1	2	localException1	Exception
    //   1004	29	2	str2	String
    //   87	73	3	localIterator	Iterator
    //   406	35	3	localException2	Exception
    //   934	4	3	localObject1	Object
    //   991	1	3	localException3	Exception
    //   14	979	4	localObject2	Object
    //   3	954	5	localTrackDictionary	TrackDictionary
    // Exception table:
    //   from	to	target	type
    //   25	88	406	java/lang/Exception
    //   88	119	406	java/lang/Exception
    //   119	144	406	java/lang/Exception
    //   159	245	406	java/lang/Exception
    //   248	319	406	java/lang/Exception
    //   322	389	406	java/lang/Exception
    //   389	403	406	java/lang/Exception
    //   440	596	406	java/lang/Exception
    //   596	621	406	java/lang/Exception
    //   621	667	406	java/lang/Exception
    //   670	686	406	java/lang/Exception
    //   689	720	406	java/lang/Exception
    //   723	766	406	java/lang/Exception
    //   766	792	406	java/lang/Exception
    //   792	830	406	java/lang/Exception
    //   830	868	406	java/lang/Exception
    //   868	894	406	java/lang/Exception
    //   894	924	406	java/lang/Exception
    //   924	931	406	java/lang/Exception
    //   422	426	429	java/lang/Exception
    //   25	88	934	finally
    //   88	119	934	finally
    //   119	144	934	finally
    //   159	245	934	finally
    //   248	319	934	finally
    //   322	389	934	finally
    //   389	403	934	finally
    //   440	596	934	finally
    //   596	621	934	finally
    //   621	667	934	finally
    //   670	686	934	finally
    //   689	720	934	finally
    //   723	766	934	finally
    //   766	792	934	finally
    //   792	830	934	finally
    //   830	868	934	finally
    //   868	894	934	finally
    //   894	924	934	finally
    //   924	931	934	finally
    //   422	426	949	finally
    //   943	947	949	finally
    //   947	949	949	finally
    //   8	11	955	finally
    //   152	158	955	finally
    //   950	955	955	finally
    //   956	959	955	finally
    //   148	152	975	java/lang/Exception
    //   943	947	979	java/lang/Exception
    //   148	152	983	finally
    //   16	25	987	finally
    //   409	418	987	finally
    //   16	25	991	java/lang/Exception
  }
  
  public void DeleteFeed(Feed paramFeed) {}
  
  public void DeleteRepositoryFiles()
  {
    FileUtils.DeleteFileIfExists(Configuration.TrackStateBackupPath());
  }
  
  public void DeleteTask(ScheduledTask paramScheduledTask) {}
  
  public void DeleteTrack(Track paramTrack) {}
  
  public void DeleteTracks(TrackList paramTrackList) {}
  
  public void LoadRepository()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    FeedRepository.OnRepositoryLoadStart();
    FeedRepository.getRootFeed().SubFeeds().clear();
    FeedRepository._TrackDictionary.clear();
    CoreHelper.WriteLogEntry("XMLRepositoryStorage", "Trying to load repository from the long term XML backup: " + Configuration.TrackStateBackupPath());
    if (FileUtils.Exists(Configuration.TrackStateBackupPath()))
    {
      localObject1 = localObject2;
      try
      {
        localObject2 = LoadRepositoryInternal(Configuration.TrackStateBackupPath());
        localObject1 = localObject2;
        FeedRepository.RepositoryLoadKind = 3;
        localObject1 = localObject2;
        CoreHelper.WriteLogEntry("XMLRepositoryStorage", "Loaded " + FeedRepository.getRootFeed().SubFeeds().size() + " feeds " + " and " + ((TrackDictionary)localObject2).size() + " tracks from the XML backup file");
        localObject1 = localObject2;
        CoreHelper.KeepDeviceAwake();
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          FeedRepository.RepositoryLoadKind = 0;
          CoreHelper.WriteLogEntry("XMLRepositoryStorage", "Failed to load from the long term XML repository backup file! Giving up!");
        }
      }
      localObject2 = FeedRepository.getRootFeed().SubFeeds().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext())
      {
        return;
        CoreHelper.WriteLogEntry("XMLRepositoryStorage", "Long term XML repository backup file does not exist! Giving up!");
        break;
      }
      RepositoryPersistence.BuildFeedList((Feed)localThrowable.next(), (TrackDictionary)localObject1);
    }
  }
  
  public void SaveRepository() {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/repository/XMLRepositoryStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */