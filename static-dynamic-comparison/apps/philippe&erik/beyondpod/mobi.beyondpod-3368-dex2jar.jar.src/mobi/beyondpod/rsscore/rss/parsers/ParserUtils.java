package mobi.beyondpod.rsscore.rss.parsers;

import java.util.ArrayList;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.rss.entities.RssEnclosure;
import mobi.beyondpod.rsscore.rss.entities.RssFeed;
import mobi.beyondpod.rsscore.rss.entities.RssFeedItem;

public class ParserUtils
{
  public static void HandleEndOfRssFeedItem(FeedParseData paramFeedParseData, RssFeedItem paramRssFeedItem)
  {
    paramRssFeedItem.ItemID();
    if (Configuration.ShowContentListPostImages()) {
      paramRssFeedItem.ItemImageUrls();
    }
    if (!StringUtils.IsNullOrEmpty(paramRssFeedItem.EnclosureDuration))
    {
      RssEnclosure localRssEnclosure = paramRssFeedItem.Enclosure();
      if ((localRssEnclosure != null) && (localRssEnclosure.Duration == 0L)) {
        localRssEnclosure.Duration = StringUtils.SafeParseLong(paramRssFeedItem.EnclosureDuration, 0L);
      }
    }
    paramFeedParseData.RssFeed.Items.add(paramRssFeedItem);
    paramFeedParseData.NotifyItemParsed(paramRssFeedItem);
  }
  
  public static class TooManyItemsException
    extends Exception
  {}
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/parsers/ParserUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */