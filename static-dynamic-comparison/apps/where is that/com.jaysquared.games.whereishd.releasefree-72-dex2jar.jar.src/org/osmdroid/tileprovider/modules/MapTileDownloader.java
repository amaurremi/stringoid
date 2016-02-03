package org.osmdroid.tileprovider.modules;

import android.graphics.drawable.Drawable;
import java.util.concurrent.atomic.AtomicReference;
import org.osmdroid.tileprovider.BitmapPool;
import org.osmdroid.tileprovider.IMapTileProviderCallback;
import org.osmdroid.tileprovider.MapTileRequestState;
import org.osmdroid.tileprovider.ReusableBitmapDrawable;
import org.osmdroid.tileprovider.tilesource.ITileSource;
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapTileDownloader
  extends MapTileModuleProviderBase
{
  private static final Logger logger = LoggerFactory.getLogger(MapTileDownloader.class);
  private final IFilesystemCache mFilesystemCache;
  private final INetworkAvailablityCheck mNetworkAvailablityCheck;
  private final AtomicReference<OnlineTileSourceBase> mTileSource = new AtomicReference();
  
  public MapTileDownloader(ITileSource paramITileSource)
  {
    this(paramITileSource, null, null);
  }
  
  public MapTileDownloader(ITileSource paramITileSource, IFilesystemCache paramIFilesystemCache)
  {
    this(paramITileSource, paramIFilesystemCache, null);
  }
  
  public MapTileDownloader(ITileSource paramITileSource, IFilesystemCache paramIFilesystemCache, INetworkAvailablityCheck paramINetworkAvailablityCheck)
  {
    this(paramITileSource, paramIFilesystemCache, paramINetworkAvailablityCheck, 2, 40);
  }
  
  public MapTileDownloader(ITileSource paramITileSource, IFilesystemCache paramIFilesystemCache, INetworkAvailablityCheck paramINetworkAvailablityCheck, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.mFilesystemCache = paramIFilesystemCache;
    this.mNetworkAvailablityCheck = paramINetworkAvailablityCheck;
    setTileSource(paramITileSource);
  }
  
  public int getMaximumZoomLevel()
  {
    OnlineTileSourceBase localOnlineTileSourceBase = (OnlineTileSourceBase)this.mTileSource.get();
    if (localOnlineTileSourceBase != null) {
      return localOnlineTileSourceBase.getMaximumZoomLevel();
    }
    return 22;
  }
  
  public int getMinimumZoomLevel()
  {
    OnlineTileSourceBase localOnlineTileSourceBase = (OnlineTileSourceBase)this.mTileSource.get();
    if (localOnlineTileSourceBase != null) {
      return localOnlineTileSourceBase.getMinimumZoomLevel();
    }
    return 0;
  }
  
  protected String getName()
  {
    return "Online Tile Download Provider";
  }
  
  protected String getThreadGroupName()
  {
    return "downloader";
  }
  
  protected Runnable getTileLoader()
  {
    return new TileLoader();
  }
  
  public ITileSource getTileSource()
  {
    return (ITileSource)this.mTileSource.get();
  }
  
  public boolean getUsesDataConnection()
  {
    return true;
  }
  
  public void setTileSource(ITileSource paramITileSource)
  {
    if ((paramITileSource instanceof OnlineTileSourceBase))
    {
      this.mTileSource.set((OnlineTileSourceBase)paramITileSource);
      return;
    }
    this.mTileSource.set(null);
  }
  
  protected class TileLoader
    extends MapTileModuleProviderBase.TileLoader
  {
    protected TileLoader()
    {
      super();
    }
    
    /* Error */
    public Drawable loadTile(MapTileRequestState paramMapTileRequestState)
      throws MapTileModuleProviderBase.CantContinueException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 13	org/osmdroid/tileprovider/modules/MapTileDownloader$TileLoader:this$0	Lorg/osmdroid/tileprovider/modules/MapTileDownloader;
      //   4: invokestatic 35	org/osmdroid/tileprovider/modules/MapTileDownloader:access$000	(Lorg/osmdroid/tileprovider/modules/MapTileDownloader;)Ljava/util/concurrent/atomic/AtomicReference;
      //   7: invokevirtual 41	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   10: checkcast 43	org/osmdroid/tileprovider/tilesource/OnlineTileSourceBase
      //   13: astore 23
      //   15: aload 23
      //   17: ifnonnull +5 -> 22
      //   20: aconst_null
      //   21: areturn
      //   22: aconst_null
      //   23: astore 17
      //   25: aconst_null
      //   26: astore 18
      //   28: aconst_null
      //   29: astore 19
      //   31: aconst_null
      //   32: astore 20
      //   34: aconst_null
      //   35: astore 21
      //   37: aconst_null
      //   38: astore 16
      //   40: aconst_null
      //   41: astore 5
      //   43: aconst_null
      //   44: astore 13
      //   46: aconst_null
      //   47: astore 11
      //   49: aconst_null
      //   50: astore 14
      //   52: aconst_null
      //   53: astore 15
      //   55: aconst_null
      //   56: astore 12
      //   58: aload_1
      //   59: invokevirtual 49	org/osmdroid/tileprovider/MapTileRequestState:getMapTile	()Lorg/osmdroid/tileprovider/MapTile;
      //   62: astore 22
      //   64: aload 16
      //   66: astore 6
      //   68: aload 17
      //   70: astore_3
      //   71: aload 5
      //   73: astore 4
      //   75: aload 18
      //   77: astore 7
      //   79: aload 19
      //   81: astore 8
      //   83: aload 20
      //   85: astore 9
      //   87: aload 21
      //   89: astore 10
      //   91: aload_0
      //   92: getfield 13	org/osmdroid/tileprovider/modules/MapTileDownloader$TileLoader:this$0	Lorg/osmdroid/tileprovider/modules/MapTileDownloader;
      //   95: invokestatic 53	org/osmdroid/tileprovider/modules/MapTileDownloader:access$100	(Lorg/osmdroid/tileprovider/modules/MapTileDownloader;)Lorg/osmdroid/tileprovider/modules/INetworkAvailablityCheck;
      //   98: ifnull +57 -> 155
      //   101: aload 16
      //   103: astore 6
      //   105: aload 17
      //   107: astore_3
      //   108: aload 5
      //   110: astore 4
      //   112: aload 18
      //   114: astore 7
      //   116: aload 19
      //   118: astore 8
      //   120: aload 20
      //   122: astore 9
      //   124: aload 21
      //   126: astore 10
      //   128: aload_0
      //   129: getfield 13	org/osmdroid/tileprovider/modules/MapTileDownloader$TileLoader:this$0	Lorg/osmdroid/tileprovider/modules/MapTileDownloader;
      //   132: invokestatic 53	org/osmdroid/tileprovider/modules/MapTileDownloader:access$100	(Lorg/osmdroid/tileprovider/modules/MapTileDownloader;)Lorg/osmdroid/tileprovider/modules/INetworkAvailablityCheck;
      //   135: invokeinterface 59 1 0
      //   140: istore_2
      //   141: iload_2
      //   142: ifne +13 -> 155
      //   145: aconst_null
      //   146: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   149: aconst_null
      //   150: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   153: aconst_null
      //   154: areturn
      //   155: aload 16
      //   157: astore 6
      //   159: aload 17
      //   161: astore_3
      //   162: aload 5
      //   164: astore 4
      //   166: aload 18
      //   168: astore 7
      //   170: aload 19
      //   172: astore 8
      //   174: aload 20
      //   176: astore 9
      //   178: aload 21
      //   180: astore 10
      //   182: aload 23
      //   184: aload 22
      //   186: invokevirtual 69	org/osmdroid/tileprovider/tilesource/OnlineTileSourceBase:getTileURLString	(Lorg/osmdroid/tileprovider/MapTile;)Ljava/lang/String;
      //   189: astore_1
      //   190: aload 16
      //   192: astore 6
      //   194: aload 17
      //   196: astore_3
      //   197: aload 5
      //   199: astore 4
      //   201: aload 18
      //   203: astore 7
      //   205: aload 19
      //   207: astore 8
      //   209: aload 20
      //   211: astore 9
      //   213: aload 21
      //   215: astore 10
      //   217: aload_1
      //   218: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   221: istore_2
      //   222: iload_2
      //   223: ifeq +13 -> 236
      //   226: aconst_null
      //   227: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   230: aconst_null
      //   231: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   234: aconst_null
      //   235: areturn
      //   236: aload 16
      //   238: astore 6
      //   240: aload 17
      //   242: astore_3
      //   243: aload 5
      //   245: astore 4
      //   247: aload 18
      //   249: astore 7
      //   251: aload 19
      //   253: astore 8
      //   255: aload 20
      //   257: astore 9
      //   259: aload 21
      //   261: astore 10
      //   263: invokestatic 81	org/osmdroid/http/HttpClientFactory:createHttpClient	()Lorg/apache/http/client/HttpClient;
      //   266: new 83	org/apache/http/client/methods/HttpGet
      //   269: dup
      //   270: aload_1
      //   271: invokespecial 86	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
      //   274: invokeinterface 92 2 0
      //   279: astore_1
      //   280: aload 16
      //   282: astore 6
      //   284: aload 17
      //   286: astore_3
      //   287: aload 5
      //   289: astore 4
      //   291: aload 18
      //   293: astore 7
      //   295: aload 19
      //   297: astore 8
      //   299: aload 20
      //   301: astore 9
      //   303: aload 21
      //   305: astore 10
      //   307: aload_1
      //   308: invokeinterface 98 1 0
      //   313: astore 24
      //   315: aload 16
      //   317: astore 6
      //   319: aload 17
      //   321: astore_3
      //   322: aload 5
      //   324: astore 4
      //   326: aload 18
      //   328: astore 7
      //   330: aload 19
      //   332: astore 8
      //   334: aload 20
      //   336: astore 9
      //   338: aload 21
      //   340: astore 10
      //   342: aload 24
      //   344: invokeinterface 104 1 0
      //   349: sipush 200
      //   352: if_icmpeq +78 -> 430
      //   355: aload 16
      //   357: astore 6
      //   359: aload 17
      //   361: astore_3
      //   362: aload 5
      //   364: astore 4
      //   366: aload 18
      //   368: astore 7
      //   370: aload 19
      //   372: astore 8
      //   374: aload 20
      //   376: astore 9
      //   378: aload 21
      //   380: astore 10
      //   382: invokestatic 108	org/osmdroid/tileprovider/modules/MapTileDownloader:access$200	()Lorg/slf4j/Logger;
      //   385: new 110	java/lang/StringBuilder
      //   388: dup
      //   389: invokespecial 113	java/lang/StringBuilder:<init>	()V
      //   392: ldc 115
      //   394: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   397: aload 22
      //   399: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   402: ldc 124
      //   404: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   407: aload 24
      //   409: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   412: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   415: invokeinterface 133 2 0
      //   420: aconst_null
      //   421: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   424: aconst_null
      //   425: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   428: aconst_null
      //   429: areturn
      //   430: aload 16
      //   432: astore 6
      //   434: aload 17
      //   436: astore_3
      //   437: aload 5
      //   439: astore 4
      //   441: aload 18
      //   443: astore 7
      //   445: aload 19
      //   447: astore 8
      //   449: aload 20
      //   451: astore 9
      //   453: aload 21
      //   455: astore 10
      //   457: aload_1
      //   458: invokeinterface 137 1 0
      //   463: astore_1
      //   464: aload_1
      //   465: ifnonnull +68 -> 533
      //   468: aload 16
      //   470: astore 6
      //   472: aload 17
      //   474: astore_3
      //   475: aload 5
      //   477: astore 4
      //   479: aload 18
      //   481: astore 7
      //   483: aload 19
      //   485: astore 8
      //   487: aload 20
      //   489: astore 9
      //   491: aload 21
      //   493: astore 10
      //   495: invokestatic 108	org/osmdroid/tileprovider/modules/MapTileDownloader:access$200	()Lorg/slf4j/Logger;
      //   498: new 110	java/lang/StringBuilder
      //   501: dup
      //   502: invokespecial 113	java/lang/StringBuilder:<init>	()V
      //   505: ldc -117
      //   507: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   510: aload 22
      //   512: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   515: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   518: invokeinterface 133 2 0
      //   523: aconst_null
      //   524: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   527: aconst_null
      //   528: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   531: aconst_null
      //   532: areturn
      //   533: aload 16
      //   535: astore 6
      //   537: aload 17
      //   539: astore_3
      //   540: aload 5
      //   542: astore 4
      //   544: aload 18
      //   546: astore 7
      //   548: aload 19
      //   550: astore 8
      //   552: aload 20
      //   554: astore 9
      //   556: aload 21
      //   558: astore 10
      //   560: aload_1
      //   561: invokeinterface 145 1 0
      //   566: astore_1
      //   567: aload_1
      //   568: astore 6
      //   570: aload_1
      //   571: astore_3
      //   572: aload 5
      //   574: astore 4
      //   576: aload_1
      //   577: astore 7
      //   579: aload_1
      //   580: astore 8
      //   582: aload_1
      //   583: astore 9
      //   585: aload_1
      //   586: astore 10
      //   588: new 147	java/io/ByteArrayOutputStream
      //   591: dup
      //   592: invokespecial 148	java/io/ByteArrayOutputStream:<init>	()V
      //   595: astore 16
      //   597: aload_1
      //   598: astore 6
      //   600: aload_1
      //   601: astore_3
      //   602: aload 5
      //   604: astore 4
      //   606: aload_1
      //   607: astore 7
      //   609: aload_1
      //   610: astore 8
      //   612: aload_1
      //   613: astore 9
      //   615: aload_1
      //   616: astore 10
      //   618: new 150	java/io/BufferedOutputStream
      //   621: dup
      //   622: aload 16
      //   624: sipush 8192
      //   627: invokespecial 153	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
      //   630: astore 5
      //   632: aload_1
      //   633: aload 5
      //   635: invokestatic 157	org/osmdroid/tileprovider/util/StreamUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
      //   638: pop2
      //   639: aload 5
      //   641: invokevirtual 162	java/io/OutputStream:flush	()V
      //   644: new 164	java/io/ByteArrayInputStream
      //   647: dup
      //   648: aload 16
      //   650: invokevirtual 168	java/io/ByteArrayOutputStream:toByteArray	()[B
      //   653: invokespecial 171	java/io/ByteArrayInputStream:<init>	([B)V
      //   656: astore_3
      //   657: aload_0
      //   658: getfield 13	org/osmdroid/tileprovider/modules/MapTileDownloader$TileLoader:this$0	Lorg/osmdroid/tileprovider/modules/MapTileDownloader;
      //   661: invokestatic 175	org/osmdroid/tileprovider/modules/MapTileDownloader:access$300	(Lorg/osmdroid/tileprovider/modules/MapTileDownloader;)Lorg/osmdroid/tileprovider/modules/IFilesystemCache;
      //   664: ifnull +25 -> 689
      //   667: aload_0
      //   668: getfield 13	org/osmdroid/tileprovider/modules/MapTileDownloader$TileLoader:this$0	Lorg/osmdroid/tileprovider/modules/MapTileDownloader;
      //   671: invokestatic 175	org/osmdroid/tileprovider/modules/MapTileDownloader:access$300	(Lorg/osmdroid/tileprovider/modules/MapTileDownloader;)Lorg/osmdroid/tileprovider/modules/IFilesystemCache;
      //   674: aload 23
      //   676: aload 22
      //   678: aload_3
      //   679: invokeinterface 181 4 0
      //   684: pop
      //   685: aload_3
      //   686: invokevirtual 184	java/io/ByteArrayInputStream:reset	()V
      //   689: aload 23
      //   691: aload_3
      //   692: invokevirtual 188	org/osmdroid/tileprovider/tilesource/OnlineTileSourceBase:getDrawable	(Ljava/io/InputStream;)Landroid/graphics/drawable/Drawable;
      //   695: astore_3
      //   696: aload_1
      //   697: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   700: aload 5
      //   702: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   705: aload_3
      //   706: areturn
      //   707: astore_3
      //   708: aload 12
      //   710: astore 5
      //   712: aload 6
      //   714: astore_1
      //   715: aload_3
      //   716: astore 6
      //   718: aload_1
      //   719: astore_3
      //   720: aload 5
      //   722: astore 4
      //   724: invokestatic 108	org/osmdroid/tileprovider/modules/MapTileDownloader:access$200	()Lorg/slf4j/Logger;
      //   727: new 110	java/lang/StringBuilder
      //   730: dup
      //   731: invokespecial 113	java/lang/StringBuilder:<init>	()V
      //   734: ldc -66
      //   736: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   739: aload 22
      //   741: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   744: ldc -64
      //   746: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   749: aload 6
      //   751: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   754: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   757: invokeinterface 133 2 0
      //   762: aload_1
      //   763: astore_3
      //   764: aload 5
      //   766: astore 4
      //   768: new 21	org/osmdroid/tileprovider/modules/MapTileModuleProviderBase$CantContinueException
      //   771: dup
      //   772: aload_0
      //   773: getfield 13	org/osmdroid/tileprovider/modules/MapTileDownloader$TileLoader:this$0	Lorg/osmdroid/tileprovider/modules/MapTileDownloader;
      //   776: aload 6
      //   778: invokespecial 195	org/osmdroid/tileprovider/modules/MapTileModuleProviderBase$CantContinueException:<init>	(Lorg/osmdroid/tileprovider/modules/MapTileModuleProviderBase;Ljava/lang/Throwable;)V
      //   781: athrow
      //   782: astore 5
      //   784: aload_3
      //   785: astore_1
      //   786: aload_1
      //   787: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   790: aload 4
      //   792: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   795: aload 5
      //   797: athrow
      //   798: astore 6
      //   800: aload 13
      //   802: astore 5
      //   804: aload 7
      //   806: astore_1
      //   807: aload_1
      //   808: astore_3
      //   809: aload 5
      //   811: astore 4
      //   813: invokestatic 108	org/osmdroid/tileprovider/modules/MapTileDownloader:access$200	()Lorg/slf4j/Logger;
      //   816: new 110	java/lang/StringBuilder
      //   819: dup
      //   820: invokespecial 113	java/lang/StringBuilder:<init>	()V
      //   823: ldc -59
      //   825: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   828: aload 22
      //   830: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   833: ldc -64
      //   835: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   838: aload 6
      //   840: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   843: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   846: invokeinterface 133 2 0
      //   851: aload_1
      //   852: astore_3
      //   853: aload 5
      //   855: astore 4
      //   857: new 21	org/osmdroid/tileprovider/modules/MapTileModuleProviderBase$CantContinueException
      //   860: dup
      //   861: aload_0
      //   862: getfield 13	org/osmdroid/tileprovider/modules/MapTileDownloader$TileLoader:this$0	Lorg/osmdroid/tileprovider/modules/MapTileDownloader;
      //   865: aload 6
      //   867: invokespecial 195	org/osmdroid/tileprovider/modules/MapTileModuleProviderBase$CantContinueException:<init>	(Lorg/osmdroid/tileprovider/modules/MapTileModuleProviderBase;Ljava/lang/Throwable;)V
      //   870: athrow
      //   871: aload_1
      //   872: astore_3
      //   873: aload 5
      //   875: astore 4
      //   877: invokestatic 108	org/osmdroid/tileprovider/modules/MapTileDownloader:access$200	()Lorg/slf4j/Logger;
      //   880: new 110	java/lang/StringBuilder
      //   883: dup
      //   884: invokespecial 113	java/lang/StringBuilder:<init>	()V
      //   887: ldc -57
      //   889: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   892: aload 22
      //   894: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   897: ldc -64
      //   899: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   902: aload 6
      //   904: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   907: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   910: invokeinterface 133 2 0
      //   915: aload_1
      //   916: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   919: aload 5
      //   921: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   924: aconst_null
      //   925: areturn
      //   926: astore 6
      //   928: aload 14
      //   930: astore 5
      //   932: aload 8
      //   934: astore_1
      //   935: aload_1
      //   936: astore_3
      //   937: aload 5
      //   939: astore 4
      //   941: invokestatic 108	org/osmdroid/tileprovider/modules/MapTileDownloader:access$200	()Lorg/slf4j/Logger;
      //   944: new 110	java/lang/StringBuilder
      //   947: dup
      //   948: invokespecial 113	java/lang/StringBuilder:<init>	()V
      //   951: ldc -55
      //   953: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   956: aload 22
      //   958: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   961: ldc -64
      //   963: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   966: aload 6
      //   968: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   971: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   974: invokeinterface 133 2 0
      //   979: aload_1
      //   980: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   983: aload 5
      //   985: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   988: goto -64 -> 924
      //   991: astore 6
      //   993: aload 15
      //   995: astore 5
      //   997: aload 9
      //   999: astore_1
      //   1000: aload_1
      //   1001: astore_3
      //   1002: aload 5
      //   1004: astore 4
      //   1006: invokestatic 108	org/osmdroid/tileprovider/modules/MapTileDownloader:access$200	()Lorg/slf4j/Logger;
      //   1009: new 110	java/lang/StringBuilder
      //   1012: dup
      //   1013: invokespecial 113	java/lang/StringBuilder:<init>	()V
      //   1016: ldc -53
      //   1018: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1021: aload 22
      //   1023: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   1026: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1029: aload 6
      //   1031: invokeinterface 207 3 0
      //   1036: aload_1
      //   1037: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   1040: aload 5
      //   1042: invokestatic 65	org/osmdroid/tileprovider/util/StreamUtils:closeStream	(Ljava/io/Closeable;)V
      //   1045: goto -121 -> 924
      //   1048: astore_3
      //   1049: aload 5
      //   1051: astore 4
      //   1053: aload_3
      //   1054: astore 5
      //   1056: goto -270 -> 786
      //   1059: astore 6
      //   1061: goto -61 -> 1000
      //   1064: astore 6
      //   1066: goto -131 -> 935
      //   1069: astore 6
      //   1071: goto -200 -> 871
      //   1074: astore 6
      //   1076: goto -269 -> 807
      //   1079: astore 6
      //   1081: goto -363 -> 718
      //   1084: astore 6
      //   1086: aload 10
      //   1088: astore_1
      //   1089: aload 11
      //   1091: astore 5
      //   1093: goto -222 -> 871
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1096	0	this	TileLoader
      //   0	1096	1	paramMapTileRequestState	MapTileRequestState
      //   140	83	2	bool	boolean
      //   70	636	3	localObject1	Object
      //   707	9	3	localUnknownHostException1	java.net.UnknownHostException
      //   719	283	3	localMapTileRequestState	MapTileRequestState
      //   1048	6	3	localObject2	Object
      //   73	979	4	localObject3	Object
      //   41	724	5	localObject4	Object
      //   782	14	5	localObject5	Object
      //   802	290	5	localObject6	Object
      //   66	711	6	localObject7	Object
      //   798	105	6	localLowMemoryException1	org.osmdroid.tileprovider.tilesource.BitmapTileSourceBase.LowMemoryException
      //   926	41	6	localIOException1	java.io.IOException
      //   991	39	6	localThrowable1	Throwable
      //   1059	1	6	localThrowable2	Throwable
      //   1064	1	6	localIOException2	java.io.IOException
      //   1069	1	6	localFileNotFoundException1	java.io.FileNotFoundException
      //   1074	1	6	localLowMemoryException2	org.osmdroid.tileprovider.tilesource.BitmapTileSourceBase.LowMemoryException
      //   1079	1	6	localUnknownHostException2	java.net.UnknownHostException
      //   1084	1	6	localFileNotFoundException2	java.io.FileNotFoundException
      //   77	728	7	localObject8	Object
      //   81	852	8	localObject9	Object
      //   85	913	9	localObject10	Object
      //   89	998	10	localObject11	Object
      //   47	1043	11	localObject12	Object
      //   56	653	12	localObject13	Object
      //   44	757	13	localObject14	Object
      //   50	879	14	localObject15	Object
      //   53	941	15	localObject16	Object
      //   38	611	16	localByteArrayOutputStream	java.io.ByteArrayOutputStream
      //   23	515	17	localObject17	Object
      //   26	519	18	localObject18	Object
      //   29	520	19	localObject19	Object
      //   32	521	20	localObject20	Object
      //   35	522	21	localObject21	Object
      //   62	960	22	localMapTile	org.osmdroid.tileprovider.MapTile
      //   13	677	23	localOnlineTileSourceBase	OnlineTileSourceBase
      //   313	95	24	localStatusLine	org.apache.http.StatusLine
      // Exception table:
      //   from	to	target	type
      //   91	101	707	java/net/UnknownHostException
      //   128	141	707	java/net/UnknownHostException
      //   182	190	707	java/net/UnknownHostException
      //   217	222	707	java/net/UnknownHostException
      //   263	280	707	java/net/UnknownHostException
      //   307	315	707	java/net/UnknownHostException
      //   342	355	707	java/net/UnknownHostException
      //   382	420	707	java/net/UnknownHostException
      //   457	464	707	java/net/UnknownHostException
      //   495	523	707	java/net/UnknownHostException
      //   560	567	707	java/net/UnknownHostException
      //   588	597	707	java/net/UnknownHostException
      //   618	632	707	java/net/UnknownHostException
      //   91	101	782	finally
      //   128	141	782	finally
      //   182	190	782	finally
      //   217	222	782	finally
      //   263	280	782	finally
      //   307	315	782	finally
      //   342	355	782	finally
      //   382	420	782	finally
      //   457	464	782	finally
      //   495	523	782	finally
      //   560	567	782	finally
      //   588	597	782	finally
      //   618	632	782	finally
      //   724	762	782	finally
      //   768	782	782	finally
      //   813	851	782	finally
      //   857	871	782	finally
      //   877	915	782	finally
      //   941	979	782	finally
      //   1006	1036	782	finally
      //   91	101	798	org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase$LowMemoryException
      //   128	141	798	org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase$LowMemoryException
      //   182	190	798	org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase$LowMemoryException
      //   217	222	798	org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase$LowMemoryException
      //   263	280	798	org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase$LowMemoryException
      //   307	315	798	org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase$LowMemoryException
      //   342	355	798	org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase$LowMemoryException
      //   382	420	798	org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase$LowMemoryException
      //   457	464	798	org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase$LowMemoryException
      //   495	523	798	org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase$LowMemoryException
      //   560	567	798	org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase$LowMemoryException
      //   588	597	798	org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase$LowMemoryException
      //   618	632	798	org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase$LowMemoryException
      //   91	101	926	java/io/IOException
      //   128	141	926	java/io/IOException
      //   182	190	926	java/io/IOException
      //   217	222	926	java/io/IOException
      //   263	280	926	java/io/IOException
      //   307	315	926	java/io/IOException
      //   342	355	926	java/io/IOException
      //   382	420	926	java/io/IOException
      //   457	464	926	java/io/IOException
      //   495	523	926	java/io/IOException
      //   560	567	926	java/io/IOException
      //   588	597	926	java/io/IOException
      //   618	632	926	java/io/IOException
      //   91	101	991	java/lang/Throwable
      //   128	141	991	java/lang/Throwable
      //   182	190	991	java/lang/Throwable
      //   217	222	991	java/lang/Throwable
      //   263	280	991	java/lang/Throwable
      //   307	315	991	java/lang/Throwable
      //   342	355	991	java/lang/Throwable
      //   382	420	991	java/lang/Throwable
      //   457	464	991	java/lang/Throwable
      //   495	523	991	java/lang/Throwable
      //   560	567	991	java/lang/Throwable
      //   588	597	991	java/lang/Throwable
      //   618	632	991	java/lang/Throwable
      //   632	689	1048	finally
      //   689	696	1048	finally
      //   632	689	1059	java/lang/Throwable
      //   689	696	1059	java/lang/Throwable
      //   632	689	1064	java/io/IOException
      //   689	696	1064	java/io/IOException
      //   632	689	1069	java/io/FileNotFoundException
      //   689	696	1069	java/io/FileNotFoundException
      //   632	689	1074	org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase$LowMemoryException
      //   689	696	1074	org/osmdroid/tileprovider/tilesource/BitmapTileSourceBase$LowMemoryException
      //   632	689	1079	java/net/UnknownHostException
      //   689	696	1079	java/net/UnknownHostException
      //   91	101	1084	java/io/FileNotFoundException
      //   128	141	1084	java/io/FileNotFoundException
      //   182	190	1084	java/io/FileNotFoundException
      //   217	222	1084	java/io/FileNotFoundException
      //   263	280	1084	java/io/FileNotFoundException
      //   307	315	1084	java/io/FileNotFoundException
      //   342	355	1084	java/io/FileNotFoundException
      //   382	420	1084	java/io/FileNotFoundException
      //   457	464	1084	java/io/FileNotFoundException
      //   495	523	1084	java/io/FileNotFoundException
      //   560	567	1084	java/io/FileNotFoundException
      //   588	597	1084	java/io/FileNotFoundException
      //   618	632	1084	java/io/FileNotFoundException
    }
    
    protected void tileLoaded(MapTileRequestState paramMapTileRequestState, Drawable paramDrawable)
    {
      MapTileDownloader.this.removeTileFromQueues(paramMapTileRequestState.getMapTile());
      paramMapTileRequestState.getCallback().mapTileRequestCompleted(paramMapTileRequestState, null);
      if ((paramDrawable instanceof ReusableBitmapDrawable)) {
        BitmapPool.getInstance().returnDrawableToPool((ReusableBitmapDrawable)paramDrawable);
      }
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/modules/MapTileDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */