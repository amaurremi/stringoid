package mobi.beyondpod.rsscore.categories;

import mobi.beyondpod.R.string;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class AllFeedsCategory
  extends FeedCategory
{
  private static final String ALL_FEEDS = CoreHelper.LoadResourceString(R.string.category_all_feeds);
  
  public AllFeedsCategory()
  {
    super(ALL_FEEDS);
    this._Value = "";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/categories/AllFeedsCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */