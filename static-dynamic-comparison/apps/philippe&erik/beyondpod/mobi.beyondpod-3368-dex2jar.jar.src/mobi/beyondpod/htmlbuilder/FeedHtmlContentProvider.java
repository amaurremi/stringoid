package mobi.beyondpod.htmlbuilder;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import mobi.beyondpod.ui.views.FeedContentListViewDataSource;

public class FeedHtmlContentProvider
  extends ContentProvider
{
  public static final String BP_Provider_Authority = "beyondpod";
  static int _CalculatedPageSize;
  static Feed _CurrentFeed;
  static RssFeed _CurrentRssFeed;
  static File _DefaultDocument;
  static FeedContentItemTemplate _FeedContentItemTemplate = new FeedContentItemTemplate();
  static File _InfoDocument;
  static long _LastParseDuration;
  static long _LastTemplateTransformationDuration;
  static Exception _ParseException;
  
  public static String ConstructItemDocument(String paramString, boolean paramBoolean)
  {
    RssFeedItem localRssFeedItem = FeedContentListViewDataSource.GetItemById(paramString);
    if (localRssFeedItem != null) {}
    for (;;)
    {
      try
      {
        _FeedContentItemTemplate.ItemContent = localRssFeedItem.Description;
        FeedContentItemTemplate localFeedContentItemTemplate = _FeedContentItemTemplate;
        if (localRssFeedItem.PubDate() == null) {
          break label148;
        }
        String str1 = DateTime.FormatDateTime(localRssFeedItem.PubDate());
        localFeedContentItemTemplate.ItemPubDate = str1;
        _FeedContentItemTemplate.ItemTitle = localRssFeedItem.Title;
        localFeedContentItemTemplate = _FeedContentItemTemplate;
        if (StringUtils.IsNullOrEmpty(localRssFeedItem.OriginatingFeedTitle))
        {
          str1 = localRssFeedItem.ParentFeed().Title;
          localFeedContentItemTemplate.OriginatingFeed = str1;
          _FeedContentItemTemplate.ItemLink = localRssFeedItem.Link;
          if (paramBoolean)
          {
            _FeedContentItemTemplate.SaveAsHtml(InfoDocument());
            return InfoDocument().getAbsolutePath();
          }
        }
        else
        {
          str1 = localRssFeedItem.OriginatingFeedTitle;
          continue;
        }
        str1 = _FeedContentItemTemplate.ToHtml();
        return str1;
      }
      catch (Exception localException)
      {
        RssTemplatingEngine.TransformFeedLoadError(paramString, localException.getMessage(), InfoDocument());
      }
      return "";
      label148:
      String str2 = "";
    }
  }
  
  public static String ConstructItemDocumentWithTemplate(String paramString, boolean paramBoolean, int paramInt)
  {
    _FeedContentItemTemplate.SwitchTemplateResourceTo(paramInt);
    return ConstructItemDocument(paramString, paramBoolean);
  }
  
  public static Feed CurrentFeed()
  {
    return _CurrentFeed;
  }
  
  public static RssFeed CurrentRssFeed()
  {
    return _CurrentRssFeed;
  }
  
  static File InfoDocument()
  {
    if (_InfoDocument == null) {
      _InfoDocument = new File(Configuration.RssCachePath(), "BeyondPodInfo.html");
    }
    return _InfoDocument;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    return false;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
    throws FileNotFoundException
  {
    Object localObject = paramUri.getPathSegments();
    if ((((List)localObject).size() > 1) && ("BeyondPodStorageRootPath".equals(((List)localObject).get(0))))
    {
      paramUri = (String)((List)localObject).get(1);
      if (!StringUtils.IsNullOrEmpty(paramUri))
      {
        paramString = new File(Configuration.BeyondPodPublicStorageRootPath(), paramUri);
        if (paramString.exists()) {
          return ParcelFileDescriptor.open(paramString, 268435456);
        }
      }
      RssTemplatingEngine.TransformFeedLoadError(paramUri, "Unable to find the requested resource", InfoDocument());
      return ParcelFileDescriptor.open(InfoDocument(), 268435456);
    }
    if ((((List)localObject).size() > 1) && ("BeyondPodImagePath".equals(((List)localObject).get(0))))
    {
      paramUri = (String)((List)localObject).get(1);
      if (!StringUtils.IsNullOrEmpty(paramUri))
      {
        paramString = new File(Configuration.RssImageCachePath(), paramUri);
        if (paramString.exists()) {
          return ParcelFileDescriptor.open(paramString, 268435456);
        }
      }
      RssTemplatingEngine.TransformFeedLoadError(paramUri, "Unable to find the requested resource", InfoDocument());
      return ParcelFileDescriptor.open(InfoDocument(), 268435456);
    }
    if ((((List)localObject).size() > 1) && ("rssItemId".equals(((List)localObject).get(0))))
    {
      localObject = (String)((List)localObject).get(1);
      if (!StringUtils.IsNullOrEmpty((String)localObject))
      {
        paramUri = (Uri)localObject;
        if (((String)localObject).endsWith(".html")) {
          paramUri = ((String)localObject).substring(0, ((String)localObject).length() - 5);
        }
        ConstructItemDocument(paramUri, true);
        return ParcelFileDescriptor.open(InfoDocument(), 268435456);
      }
    }
    return super.openFile(paramUri, paramString);
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/htmlbuilder/FeedHtmlContentProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */