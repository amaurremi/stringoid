package org.osmdroid.tileprovider.tilesource.bing;

import android.content.Context;
import java.util.Locale;
import microsoft.mappoint.TileSystem;
import org.osmdroid.ResourceProxy.string;
import org.osmdroid.tileprovider.MapTile;
import org.osmdroid.tileprovider.tilesource.IStyledTileSource;
import org.osmdroid.tileprovider.tilesource.QuadTreeTileSource;
import org.osmdroid.tileprovider.tilesource.bing.imagerymetadata.ImageryMetaDataResource;
import org.osmdroid.tileprovider.util.ManifestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BingMapTileSource
  extends QuadTreeTileSource
  implements IStyledTileSource<String>
{
  private static final String BASE_URL_PATTERN = "http://dev.virtualearth.net/REST/V1/Imagery/Metadata/%s?mapVersion=v1&output=json&key=%s";
  private static final String BING_KEY = "BING_KEY";
  private static final String FILENAME_ENDING = ".jpeg";
  public static final String IMAGERYSET_AERIAL = "Aerial";
  public static final String IMAGERYSET_AERIALWITHLABELS = "AerialWithLabels";
  public static final String IMAGERYSET_ROAD = "Road";
  private static final Logger logger = LoggerFactory.getLogger(BingMapTileSource.class);
  private static String mBingMapKey = "";
  private String mBaseUrl;
  private ImageryMetaDataResource mImageryData = ImageryMetaDataResource.getDefaultInstance();
  private String mLocale;
  private String mStyle = "Road";
  private String mUrl;
  
  public BingMapTileSource(String paramString)
  {
    super("BingMap", ResourceProxy.string.bing, -1, -1, -1, ".jpeg", null);
    this.mLocale = paramString;
    if (this.mLocale == null) {
      this.mLocale = (Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());
    }
  }
  
  public static String getBingKey()
  {
    return mBingMapKey;
  }
  
  /* Error */
  private ImageryMetaDataResource getMetaData()
  {
    // Byte code:
    //   0: getstatic 44	org/osmdroid/tileprovider/tilesource/bing/BingMapTileSource:logger	Lorg/slf4j/Logger;
    //   3: ldc 113
    //   5: invokeinterface 118 2 0
    //   10: invokestatic 124	org/osmdroid/http/HttpClientFactory:createHttpClient	()Lorg/apache/http/client/HttpClient;
    //   13: astore_1
    //   14: new 126	org/apache/http/client/methods/HttpGet
    //   17: dup
    //   18: ldc 11
    //   20: iconst_2
    //   21: anewarray 128	java/lang/Object
    //   24: dup
    //   25: iconst_0
    //   26: aload_0
    //   27: getfield 64	org/osmdroid/tileprovider/tilesource/bing/BingMapTileSource:mStyle	Ljava/lang/String;
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: getstatic 48	org/osmdroid/tileprovider/tilesource/bing/BingMapTileSource:mBingMapKey	Ljava/lang/String;
    //   36: aastore
    //   37: invokestatic 132	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   40: invokespecial 133	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   43: astore_2
    //   44: getstatic 44	org/osmdroid/tileprovider/tilesource/bing/BingMapTileSource:logger	Lorg/slf4j/Logger;
    //   47: new 76	java/lang/StringBuilder
    //   50: dup
    //   51: ldc -121
    //   53: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: aload_2
    //   57: invokeinterface 141 1 0
    //   62: invokevirtual 144	java/net/URI:toString	()Ljava/lang/String;
    //   65: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokeinterface 147 2 0
    //   76: aload_1
    //   77: aload_2
    //   78: invokeinterface 153 2 0
    //   83: invokeinterface 159 1 0
    //   88: astore_3
    //   89: aload_3
    //   90: ifnonnull +58 -> 148
    //   93: getstatic 44	org/osmdroid/tileprovider/tilesource/bing/BingMapTileSource:logger	Lorg/slf4j/Logger;
    //   96: new 76	java/lang/StringBuilder
    //   99: dup
    //   100: ldc -95
    //   102: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload_2
    //   106: invokeinterface 141 1 0
    //   111: invokevirtual 144	java/net/URI:toString	()Ljava/lang/String;
    //   114: invokevirtual 100	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokeinterface 164 2 0
    //   125: aload_1
    //   126: invokeinterface 168 1 0
    //   131: invokeinterface 173 1 0
    //   136: getstatic 44	org/osmdroid/tileprovider/tilesource/bing/BingMapTileSource:logger	Lorg/slf4j/Logger;
    //   139: ldc -81
    //   141: invokeinterface 118 2 0
    //   146: aconst_null
    //   147: areturn
    //   148: aload_3
    //   149: invokeinterface 181 1 0
    //   154: astore_2
    //   155: new 183	java/io/ByteArrayOutputStream
    //   158: dup
    //   159: invokespecial 185	java/io/ByteArrayOutputStream:<init>	()V
    //   162: astore_3
    //   163: new 187	java/io/BufferedOutputStream
    //   166: dup
    //   167: aload_3
    //   168: sipush 8192
    //   171: invokespecial 190	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   174: astore 4
    //   176: aload_2
    //   177: aload 4
    //   179: invokestatic 196	org/osmdroid/tileprovider/util/StreamUtils:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   182: pop2
    //   183: aload 4
    //   185: invokevirtual 199	java/io/BufferedOutputStream:flush	()V
    //   188: aload_3
    //   189: invokevirtual 200	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   192: invokestatic 206	org/osmdroid/tileprovider/tilesource/bing/imagerymetadata/ImageryMetaData:getInstanceFromJSON	(Ljava/lang/String;)Lorg/osmdroid/tileprovider/tilesource/bing/imagerymetadata/ImageryMetaDataResource;
    //   195: astore_2
    //   196: aload_1
    //   197: invokeinterface 168 1 0
    //   202: invokeinterface 173 1 0
    //   207: getstatic 44	org/osmdroid/tileprovider/tilesource/bing/BingMapTileSource:logger	Lorg/slf4j/Logger;
    //   210: ldc -81
    //   212: invokeinterface 118 2 0
    //   217: aload_2
    //   218: areturn
    //   219: astore_2
    //   220: getstatic 44	org/osmdroid/tileprovider/tilesource/bing/BingMapTileSource:logger	Lorg/slf4j/Logger;
    //   223: ldc -48
    //   225: aload_2
    //   226: invokeinterface 211 3 0
    //   231: aload_1
    //   232: invokeinterface 168 1 0
    //   237: invokeinterface 173 1 0
    //   242: getstatic 44	org/osmdroid/tileprovider/tilesource/bing/BingMapTileSource:logger	Lorg/slf4j/Logger;
    //   245: ldc -81
    //   247: invokeinterface 118 2 0
    //   252: aconst_null
    //   253: areturn
    //   254: astore_2
    //   255: aload_1
    //   256: invokeinterface 168 1 0
    //   261: invokeinterface 173 1 0
    //   266: getstatic 44	org/osmdroid/tileprovider/tilesource/bing/BingMapTileSource:logger	Lorg/slf4j/Logger;
    //   269: ldc -81
    //   271: invokeinterface 118 2 0
    //   276: aload_2
    //   277: athrow
    //   278: astore_1
    //   279: goto -13 -> 266
    //   282: astore_1
    //   283: goto -41 -> 242
    //   286: astore_1
    //   287: goto -80 -> 207
    //   290: astore_1
    //   291: goto -155 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	BingMapTileSource
    //   13	243	1	localHttpClient	org.apache.http.client.HttpClient
    //   278	1	1	localUnsupportedOperationException1	UnsupportedOperationException
    //   282	1	1	localUnsupportedOperationException2	UnsupportedOperationException
    //   286	1	1	localUnsupportedOperationException3	UnsupportedOperationException
    //   290	1	1	localUnsupportedOperationException4	UnsupportedOperationException
    //   43	175	2	localObject1	Object
    //   219	7	2	localException	Exception
    //   254	23	2	localObject2	Object
    //   88	101	3	localObject3	Object
    //   174	10	4	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   76	89	219	java/lang/Exception
    //   93	125	219	java/lang/Exception
    //   148	196	219	java/lang/Exception
    //   76	89	254	finally
    //   93	125	254	finally
    //   148	196	254	finally
    //   220	231	254	finally
    //   255	266	278	java/lang/UnsupportedOperationException
    //   231	242	282	java/lang/UnsupportedOperationException
    //   196	207	286	java/lang/UnsupportedOperationException
    //   125	136	290	java/lang/UnsupportedOperationException
  }
  
  private ImageryMetaDataResource initMetaData()
  {
    if (!this.mImageryData.m_isInitialised) {}
    try
    {
      if (!this.mImageryData.m_isInitialised)
      {
        ImageryMetaDataResource localImageryMetaDataResource = getMetaData();
        if (localImageryMetaDataResource != null)
        {
          this.mImageryData = localImageryMetaDataResource;
          TileSystem.setTileSize(getTileSizePixels());
          updateBaseUrl();
        }
      }
      return this.mImageryData;
    }
    finally {}
  }
  
  public static void retrieveBingKey(Context paramContext)
  {
    mBingMapKey = ManifestUtil.retrieveKey(paramContext, "BING_KEY");
  }
  
  protected String getBaseUrl()
  {
    if (!this.mImageryData.m_isInitialised) {
      initMetaData();
    }
    return this.mBaseUrl;
  }
  
  public int getMaximumZoomLevel()
  {
    return this.mImageryData.m_zoomMax;
  }
  
  public int getMinimumZoomLevel()
  {
    return this.mImageryData.m_zoomMin;
  }
  
  public String getStyle()
  {
    return this.mStyle;
  }
  
  public int getTileSizePixels()
  {
    return this.mImageryData.m_imageHeight;
  }
  
  public String getTileURLString(MapTile paramMapTile)
  {
    if (!this.mImageryData.m_isInitialised) {
      initMetaData();
    }
    return String.format(this.mUrl, new Object[] { quadTree(paramMapTile) });
  }
  
  public String pathBase()
  {
    return this.mName + this.mStyle;
  }
  
  public void setStyle(String paramString)
  {
    if (!paramString.equals(this.mStyle)) {}
    synchronized (this.mStyle)
    {
      this.mUrl = null;
      this.mBaseUrl = null;
      this.mImageryData.m_isInitialised = false;
      this.mStyle = paramString;
      return;
    }
  }
  
  protected void updateBaseUrl()
  {
    logger.trace("updateBaseUrl");
    String str = this.mImageryData.getSubDomain();
    int i = this.mImageryData.m_imageUrl.lastIndexOf("/");
    if (i > 0) {}
    for (this.mBaseUrl = this.mImageryData.m_imageUrl.substring(0, i);; this.mBaseUrl = this.mImageryData.m_imageUrl)
    {
      this.mUrl = this.mImageryData.m_imageUrl;
      if (str != null)
      {
        this.mBaseUrl = String.format(this.mBaseUrl, new Object[] { str });
        this.mUrl = String.format(this.mUrl, new Object[] { str, "%s", this.mLocale });
      }
      logger.debug("updated url = " + this.mUrl);
      logger.trace("end updateBaseUrl");
      return;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/where is that/com.jaysquared.games.whereishd.releasefree-72-dex2jar.jar!/org/osmdroid/tileprovider/tilesource/bing/BingMapTileSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */