package mobi.beyondpod.rsscore.categories;

import mobi.beyondpod.rsscore.helpers.StringUtils;

public class FeedCategories
{
  private boolean m_Modified = false;
  private FeedCategory m_Primary = CategoryManager.Unassigned;
  private FeedCategory m_Secondary = CategoryManager.Unassigned;
  
  public static FeedCategories Deserialize(String paramString)
  {
    FeedCategories localFeedCategories = new FeedCategories();
    if (StringUtils.IsNullOrEmpty(paramString)) {}
    do
    {
      return localFeedCategories;
      paramString = paramString.split("\\|");
      if (paramString.length > 0) {
        localFeedCategories.m_Primary = LoadCategory(paramString[0]);
      }
    } while (paramString.length <= 1);
    localFeedCategories.m_Secondary = LoadCategory(paramString[1]);
    return localFeedCategories;
  }
  
  private static FeedCategory LoadCategory(String paramString)
  {
    FeedCategory localFeedCategory = CategoryManager.GetCategoryByValue(paramString.trim());
    paramString = localFeedCategory;
    if (localFeedCategory == CategoryManager.CategoryNull) {
      paramString = CategoryManager.Unassigned;
    }
    return paramString;
  }
  
  public boolean IsOfCategory(FeedCategory paramFeedCategory)
  {
    if (paramFeedCategory == CategoryManager.Unassigned) {
      if ((getPrimary() != CategoryManager.Unassigned) || (getSecondary() != CategoryManager.Unassigned)) {}
    }
    while ((getPrimary() == paramFeedCategory) || (getSecondary() == paramFeedCategory))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public String Serialize()
  {
    return getPrimary().Value() + "|" + getSecondary().Value();
  }
  
  public void SetIsModified(boolean paramBoolean)
  {
    this.m_Modified = paramBoolean;
  }
  
  public boolean getIsModified()
  {
    return this.m_Modified;
  }
  
  public boolean getIsUnassigned()
  {
    return (getPrimary() == CategoryManager.Unassigned) && (getSecondary() == CategoryManager.Unassigned);
  }
  
  public FeedCategory getPrimary()
  {
    return this.m_Primary;
  }
  
  public FeedCategory getSecondary()
  {
    return this.m_Secondary;
  }
  
  public void setPrimary(FeedCategory paramFeedCategory)
  {
    this.m_Primary = paramFeedCategory;
    this.m_Modified = true;
  }
  
  public void setSecondary(FeedCategory paramFeedCategory)
  {
    this.m_Secondary = paramFeedCategory;
    this.m_Modified = true;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/categories/FeedCategories.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */