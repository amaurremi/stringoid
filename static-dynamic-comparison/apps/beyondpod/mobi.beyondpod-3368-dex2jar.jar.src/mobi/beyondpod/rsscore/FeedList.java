package mobi.beyondpod.rsscore;

import java.util.ArrayList;
import java.util.Iterator;
import mobi.beyondpod.rsscore.helpers.StringUtils;

public class FeedList
  extends ArrayList<Feed>
{
  private static final long serialVersionUID = -2448414566581027008L;
  
  public boolean containsUrl(String paramString)
  {
    Iterator localIterator = iterator();
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
    } while (!StringUtils.Equals(((Feed)localIterator.next()).getFeedUrl(), paramString));
    return true;
  }
  
  public int getUnplayedTrackCount()
  {
    int i = 0;
    Iterator localIterator = iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return i;
      }
      i += ((Feed)localIterator.next()).getUnplayedTrackCount();
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/FeedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */