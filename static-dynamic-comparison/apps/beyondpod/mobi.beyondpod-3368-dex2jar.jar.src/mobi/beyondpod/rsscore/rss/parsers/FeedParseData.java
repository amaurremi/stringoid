package mobi.beyondpod.rsscore.rss.parsers;

import java.util.ArrayList;
import java.util.UUID;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;
import org.xml.sax.SAXException;

public class FeedParseData
{
  public static final int FeedParseLevel_Complete = 0;
  public static final int FeedParseLevel_ItemAndEnclosureEssentials = 2;
  public static final int FeedParseLevel_ItemEssentials = 1;
  public static final int FeedType_Atom = 2;
  public static final int FeedType_FEEDLY = 6;
  public static final int FeedType_HTML = 5;
  public static final int FeedType_OPML = 3;
  public static final int FeedType_RDF = 4;
  public static final int FeedType_RSS = 1;
  public static final int FeedType_UNKNOWN = -1;
  public long CachedFileSize;
  public String EnclosureDownloadPath = "";
  public final Feed Feed = new Feed(UUID.randomUUID(), null);
  public boolean ForceUniqueEnclosureNames = false;
  public boolean LoadTempFeed = false;
  public int MaxItemsToParse = Configuration.DBGMaxFeedPosts();
  public int PageSize;
  public long ParseDuration = 0L;
  public Exception ParseException = null;
  public int ParseLevel = 0;
  public int ParsedFeedType = -1;
  public final RssFeed RssFeed = new RssFeed();
  public int StartAtItem;
  private ParseListener _ParseListener;
  
  public FeedParseData(int paramInt)
  {
    this.ParseLevel = paramInt;
  }
  
  public static boolean IsRssFeedType(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 2)
      {
        bool1 = bool2;
        if (paramInt != 4)
        {
          bool1 = bool2;
          if (paramInt != 6) {
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  public long AverageItemSize()
  {
    if ((this.RssFeed == null) || (this.RssFeed.Items.size() == 0) || (this.CachedFileSize == 0L)) {
      return 0L;
    }
    return this.CachedFileSize / this.RssFeed.Items.size();
  }
  
  public boolean HasParseFailed()
  {
    SAXException localSAXException;
    if (this.ParseException != null)
    {
      if ((this.ParseException instanceof SAXException))
      {
        localSAXException = (SAXException)this.ParseException;
        if (localSAXException.getException() == null) {}
      }
    }
    else {
      return !(localSAXException.getException() instanceof ParserUtils.TooManyItemsException);
    }
    return true;
  }
  
  public void NotifyItemParsed(RssFeedItem paramRssFeedItem)
  {
    if (this._ParseListener != null) {
      this._ParseListener.OnItemParsed(paramRssFeedItem);
    }
  }
  
  public void NotifyParseCompleted()
  {
    if (this._ParseListener != null) {
      this._ParseListener.OnParseCompleted(this.RssFeed);
    }
  }
  
  public void NotifyParseStarted()
  {
    if (this._ParseListener != null) {
      this._ParseListener.OnParseStarted(this.RssFeed);
    }
  }
  
  public void setParseListener(ParseListener paramParseListener)
  {
    this._ParseListener = paramParseListener;
  }
  
  public static abstract interface ParseListener
  {
    public abstract void OnItemParsed(RssFeedItem paramRssFeedItem);
    
    public abstract void OnParseCompleted(RssFeed paramRssFeed);
    
    public abstract void OnParseStarted(RssFeed paramRssFeed);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/parsers/FeedParseData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */