package mobi.beyondpod.rsscore.categories;

import mobi.beyondpod.R.string;
import mobi.beyondpod.rsscore.helpers.CoreHelper;

public class CategoryNone
  extends FeedCategory
{
  private static final String UNCATEGORIZED_NAME = CoreHelper.LoadResourceString(R.string.category_uncategorized);
  private static final String UNCATEGORIZED_VALUE = "Uncategorized";
  
  public CategoryNone()
  {
    super(UNCATEGORIZED_NAME);
    this._Value = "Uncategorized";
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/categories/CategoryNone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */