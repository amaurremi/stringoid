package com.jumptap.adtag.activity;

import android.content.Context;
import android.util.Log;
import android.webkit.WebView;
import com.jumptap.adtag.JtAdWidgetSettings;
import com.jumptap.adtag.db.DBManager;
import com.jumptap.adtag.media.JTMediaPlayer;
import com.jumptap.adtag.media.VideoCacheItem;
import com.jumptap.adtag.utils.JtAdFetcher;
import com.jumptap.adtag.utils.JtAdUrlBuilder;
import com.jumptap.adtag.utils.JtException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class JTVideo
{
  private static final String ADID_STR = "AdID";
  private static final String CLICK_THROUGH_STR = "ClickThrough";
  private static final String IMPRESSION_STR = "Impression";
  private static final String MEDIA_FILE_STR = "MediaFile";
  private static final String URL_STR = "URL";
  private static final long WEEK_IN_MILLIS = 604800000L;
  private static String adId = "";
  private static String adRequestId;
  private static String clickThroughUrl;
  private static File downloadingMediaFile;
  private static boolean isDownLoading = false;
  private static int totalKbRead = 0;
  private static List<String> trackingUrlArr = new ArrayList();
  private static String videoUrl;
  
  static
  {
    clickThroughUrl = "";
    videoUrl = "";
  }
  
  private static boolean checkIfExpired(VideoCacheItem paramVideoCacheItem)
  {
    long l = Long.parseLong(paramVideoCacheItem.getDate());
    return System.currentTimeMillis() - l > 604800000L;
  }
  
  protected static void clearTrackingUrl()
  {
    trackingUrlArr.clear();
  }
  
  private static void deleteVideo(VideoCacheItem paramVideoCacheItem, DBManager paramDBManager, Context paramContext)
  {
    Log.i("JtAd", "deleting from db item = " + paramVideoCacheItem.toString());
    paramDBManager.deleteVideoCacheItemById(paramVideoCacheItem.getId());
    paramVideoCacheItem = new File(paramContext.getCacheDir(), paramVideoCacheItem.getAdID() + ".dat");
    if (paramVideoCacheItem.exists()) {
      paramVideoCacheItem.delete();
    }
  }
  
  private static void getAdContent(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new JtAdFetcher(paramContext, null);
      String str;
      Log.e("JtAd", "FAil to get ad content url is =" + paramString, paramContext);
    }
    catch (JtException paramContext)
    {
      try
      {
        paramContext.setUrl(paramString);
        str = paramContext.getAdContent();
        adRequestId = paramContext.getAdRequestId();
        parseAdContent(str);
        return;
      }
      catch (JtException paramContext)
      {
        for (;;) {}
      }
      paramContext = paramContext;
    }
  }
  
  protected static String getAdRequestId()
  {
    return adRequestId;
  }
  
  protected static String getClickThroughUrl()
  {
    return clickThroughUrl;
  }
  
  private static VideoCacheItem getLastItem(DBManager paramDBManager)
  {
    return (VideoCacheItem)paramDBManager.selectAllVideoCacheItems().get(0);
  }
  
  protected static List<String> getTrackingUrl()
  {
    return trackingUrlArr;
  }
  
  private static void initParams()
  {
    clearTrackingUrl();
    clickThroughUrl = "";
    videoUrl = "";
    adId = "";
  }
  
  public static boolean isReady()
  {
    return JTMediaPlayer.getInstance().isReady();
  }
  
  private static boolean isVideoInCache(DBManager paramDBManager)
  {
    return paramDBManager.selectAllVideoCacheItems().size() > 0;
  }
  
  private static void maintainDB(DBManager paramDBManager, Context paramContext)
  {
    Log.i("JtAd", "maintainDB");
    List localList = paramDBManager.selectAllVideoCacheItems();
    int i = 0;
    while (i < localList.size())
    {
      VideoCacheItem localVideoCacheItem = (VideoCacheItem)localList.get(i);
      Log.i("JtAd", "found in db: item = " + localVideoCacheItem.toString());
      if (checkIfExpired(localVideoCacheItem)) {
        deleteVideo(localVideoCacheItem, paramDBManager, paramContext);
      }
      i += 1;
    }
  }
  
  private static void parseAdContent(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      Log.e("JtAd", "Cannot parse content since adContent is empty");
      return;
    }
    Object localObject = SAXParserFactory.newInstance();
    try
    {
      initParams();
      localObject = ((SAXParserFactory)localObject).newSAXParser().getXMLReader();
      ((XMLReader)localObject).setContentHandler(new DefaultHandler()
      {
        private boolean isAdID = false;
        private boolean isClickThrough = false;
        private boolean isImpression = false;
        private boolean isMediaFile = false;
        private boolean isUrl = false;
        
        public void characters(char[] paramAnonymousArrayOfChar, int paramAnonymousInt1, int paramAnonymousInt2)
          throws SAXException
        {
          super.characters(paramAnonymousArrayOfChar, paramAnonymousInt1, paramAnonymousInt2);
          paramAnonymousArrayOfChar = new String(paramAnonymousArrayOfChar, paramAnonymousInt1, paramAnonymousInt2).trim();
          if ((this.isUrl) && (paramAnonymousArrayOfChar != null) && (!paramAnonymousArrayOfChar.equals(""))) {
            if (this.isImpression) {
              JTVideo.trackingUrlArr.add(paramAnonymousArrayOfChar);
            }
          }
          while ((!this.isAdID) || (paramAnonymousArrayOfChar == null) || (paramAnonymousArrayOfChar.equals("")))
          {
            do
            {
              return;
              if (this.isClickThrough)
              {
                JTVideo.access$402(paramAnonymousArrayOfChar);
                return;
              }
            } while (!this.isMediaFile);
            JTVideo.access$102(paramAnonymousArrayOfChar);
            return;
          }
          JTVideo.access$202(paramAnonymousArrayOfChar);
        }
        
        public void endElement(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
          throws SAXException
        {
          super.endElement(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
          if (paramAnonymousString2.equals("Impression")) {
            this.isImpression = false;
          }
          do
          {
            return;
            if (paramAnonymousString2.equals("ClickThrough"))
            {
              this.isClickThrough = false;
              return;
            }
            if (paramAnonymousString2.equals("MediaFile"))
            {
              this.isMediaFile = false;
              return;
            }
            if (paramAnonymousString2.equals("URL"))
            {
              this.isUrl = false;
              return;
            }
          } while (!paramAnonymousString2.equals("AdID"));
          this.isAdID = false;
        }
        
        public void startDocument()
          throws SAXException
        {
          super.startDocument();
        }
        
        public void startElement(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Attributes paramAnonymousAttributes)
          throws SAXException
        {
          super.startElement(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousAttributes);
          if (paramAnonymousString2.compareTo("Impression") == 0) {
            this.isImpression = true;
          }
          do
          {
            return;
            if (paramAnonymousString2.compareTo("ClickThrough") == 0)
            {
              this.isClickThrough = true;
              return;
            }
            if (paramAnonymousString2.compareTo("MediaFile") == 0)
            {
              this.isMediaFile = true;
              return;
            }
            if (paramAnonymousString2.equals("URL"))
            {
              this.isUrl = true;
              return;
            }
          } while (!paramAnonymousString2.equals("AdID"));
          this.isAdID = true;
        }
      });
      ((XMLReader)localObject).parse(new InputSource(new StringReader(paramString)));
      return;
    }
    catch (Exception localException)
    {
      Log.e("JtAd", "The following execption was thrown while SAX parsing : " + localException.getMessage());
      Log.e("JtAd", "SAX fail to parse content:" + paramString);
    }
  }
  
  public static boolean prepare(JtAdWidgetSettings paramJtAdWidgetSettings, Context paramContext)
  {
    return prepare(paramJtAdWidgetSettings, paramContext, false);
  }
  
  protected static boolean prepare(JtAdWidgetSettings paramJtAdWidgetSettings, Context paramContext, boolean paramBoolean)
  {
    DBManager localDBManager = DBManager.getInstance(paramContext);
    Object localObject = new JtAdUrlBuilder(paramJtAdWidgetSettings, paramContext);
    boolean bool2 = isVideoInCache(localDBManager);
    Log.d("JtAd", "in prepare  shouldForceDownload= " + paramBoolean + "  isVideoInCache=" + bool2);
    if (paramBoolean) {
      localDBManager.deleteAllVideoCacheItems();
    }
    boolean bool1 = false;
    if ((!bool2) || (paramBoolean))
    {
      Log.d("JtAd", "video not found in cache . downloading new video");
      getAdContent(paramContext, ((JtAdUrlBuilder)localObject).getAdUrl(new WebView(paramContext), "type=video&specific=false"));
      runSaveVideoThread(localDBManager, paramContext);
      paramBoolean = bool1;
    }
    for (;;)
    {
      maintainDB(localDBManager, paramContext);
      return paramBoolean;
      VideoCacheItem localVideoCacheItem = getLastItem(localDBManager);
      String str = localVideoCacheItem.getAdID();
      Log.d("JtAd", "video found in cache adid = " + str);
      getAdContent(paramContext, ((JtAdUrlBuilder)localObject).getAdUrl(new WebView(paramContext), "type=video&specific=true&adid=" + str));
      Log.d("JtAd", "TL return adid = " + adId);
      if (str.equals(adId))
      {
        Log.d("JtAd", "prepering video from cache");
        downloadingMediaFile = new File(paramContext.getCacheDir(), adId + ".dat");
        paramJtAdWidgetSettings = JTMediaPlayer.getInstance();
        try
        {
          localObject = new FileInputStream(downloadingMediaFile);
          paramJtAdWidgetSettings.prepareVideo(((FileInputStream)localObject).getFD());
          ((FileInputStream)localObject).close();
          paramBoolean = true;
        }
        catch (FileNotFoundException paramJtAdWidgetSettings)
        {
          Log.e("JtAd", "Fail to play video", paramJtAdWidgetSettings);
          paramBoolean = bool1;
        }
        catch (IOException paramJtAdWidgetSettings)
        {
          Log.e("JtAd", "Fail to play video", paramJtAdWidgetSettings);
          paramBoolean = bool1;
        }
      }
      else
      {
        Log.d("JtAd", "video  in cache is not valid downloading new file");
        deleteVideo(localVideoCacheItem, localDBManager, paramContext);
        prepare(paramJtAdWidgetSettings, paramContext, true);
        paramBoolean = bool1;
      }
    }
  }
  
  private static void runSaveVideoThread(final DBManager paramDBManager, Context paramContext)
  {
    if ((videoUrl != null) && (!videoUrl.equals("")))
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          try
          {
            if (!JTVideo.isDownLoading)
            {
              JTVideo.access$002(true);
              JTVideo.saveVideoToFile(JTVideo.videoUrl, this.val$context);
              Object localObject = "" + System.currentTimeMillis();
              localObject = new VideoCacheItem(JTVideo.adId, (String)localObject);
              paramDBManager.insertVideoCacheItem((VideoCacheItem)localObject);
              JTVideo.access$002(false);
            }
            return;
          }
          catch (IOException localIOException)
          {
            Log.e("JtAd", "cannot save video", localIOException);
          }
        }
      }).start();
      return;
    }
    Log.e("JtAd", "cannot save video since url is empty");
  }
  
  public static void saveVideoToFile(String paramString, Context paramContext)
    throws IOException
  {
    Object localObject = new URL(paramString).openConnection();
    ((URLConnection)localObject).connect();
    localObject = ((URLConnection)localObject).getInputStream();
    if (localObject == null)
    {
      Log.e("JtAd", "Unable to create InputStream for mediaUrl:" + paramString);
      return;
    }
    downloadingMediaFile = new File(paramContext.getCacheDir(), adId + ".dat");
    if (downloadingMediaFile.exists()) {
      downloadingMediaFile.delete();
    }
    paramString = new FileOutputStream(downloadingMediaFile);
    paramContext = new byte['䀀'];
    int i = 0;
    for (;;)
    {
      int j = ((InputStream)localObject).read(paramContext);
      if (j <= 0)
      {
        ((InputStream)localObject).close();
        Log.i("JtAd", "Done saving file  " + adId + ".dat, total" + totalKbRead + " Kb read");
        return;
      }
      paramString.write(paramContext, 0, j);
      i += j;
      totalKbRead = i / 1000;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/logo quiz/logo.quiz.game.category-48-dex2jar.jar!/com/jumptap/adtag/activity/JTVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */