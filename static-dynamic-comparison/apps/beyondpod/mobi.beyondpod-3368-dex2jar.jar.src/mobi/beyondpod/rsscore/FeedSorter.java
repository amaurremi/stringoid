package mobi.beyondpod.rsscore;

import java.util.Comparator;
import java.util.Date;

public class FeedSorter
  implements Comparator<Feed>
{
  private int _SortOrder;
  
  public FeedSorter(int paramInt)
  {
    this._SortOrder = paramInt;
  }
  
  public int compare(Feed paramFeed1, Feed paramFeed2)
  {
    if (paramFeed1.equals(paramFeed2)) {}
    do
    {
      do
      {
        Date localDate1;
        Date localDate2;
        do
        {
          do
          {
            return 0;
            localDate1 = paramFeed1.getLastModifiedDate();
            localDate2 = paramFeed2.getLastModifiedDate();
            paramFeed1 = paramFeed1.getName();
            paramFeed2 = paramFeed2.getName();
            switch (this._SortOrder)
            {
            default: 
              return -1;
            }
          } while ((localDate1 == null) && (localDate2 == null));
          if ((localDate1 != null) && (localDate2 == null)) {
            return 1;
          }
          if ((localDate1 == null) && (localDate2 != null)) {
            return -1;
          }
          return localDate1.compareTo(localDate2);
        } while ((localDate1 == null) && (localDate2 == null));
        if ((localDate2 != null) && (localDate1 == null)) {
          return 1;
        }
        if ((localDate2 == null) && (localDate1 != null)) {
          return -1;
        }
        return localDate2.compareTo(localDate1);
      } while ((paramFeed1 == null) && (paramFeed2 == null));
      if ((paramFeed1 != null) && (paramFeed2 == null)) {
        return 1;
      }
      if ((paramFeed1 == null) && (paramFeed2 != null)) {
        return -1;
      }
      return paramFeed1.compareToIgnoreCase(paramFeed2);
    } while ((paramFeed1 == null) && (paramFeed2 == null));
    if ((paramFeed2 != null) && (paramFeed1 == null)) {
      return 1;
    }
    if ((paramFeed2 == null) && (paramFeed1 != null)) {
      return -1;
    }
    return paramFeed2.compareToIgnoreCase(paramFeed1);
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/FeedSorter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */