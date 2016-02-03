package mobi.beyondpod.rsscore.rss.entities;

import java.util.Comparator;
import java.util.Date;

public class RssFeedItemSorter
  implements Comparator<RssFeedItem>
{
  private int _SortOrder;
  
  public RssFeedItemSorter(int paramInt)
  {
    this._SortOrder = paramInt;
  }
  
  int Compare(RssFeedItem paramRssFeedItem1, RssFeedItem paramRssFeedItem2)
  {
    if (paramRssFeedItem2 == null) {}
    do
    {
      return -1;
      if ((paramRssFeedItem1.PubDate() == null) && (paramRssFeedItem2.PubDate() == null)) {
        return 0;
      }
    } while (paramRssFeedItem2.PubDate() == null);
    if (paramRssFeedItem1.PubDate() == null) {
      return 1;
    }
    return paramRssFeedItem2.PubDate().compareTo(paramRssFeedItem1.PubDate());
  }
  
  public int compare(RssFeedItem paramRssFeedItem1, RssFeedItem paramRssFeedItem2)
  {
    if (paramRssFeedItem1.equals(paramRssFeedItem2)) {
      return 0;
    }
    if (this._SortOrder == 3) {
      return Compare(paramRssFeedItem1, paramRssFeedItem2);
    }
    return Compare(paramRssFeedItem2, paramRssFeedItem1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/rss/entities/RssFeedItemSorter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */