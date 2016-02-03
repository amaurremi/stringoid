package mobi.beyondpod.rsscore.categories;

import java.util.Iterator;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;

public class FeedCategory
  implements Comparable<FeedCategory>
{
  protected int _Color = 0;
  protected String _Name = "";
  protected String _Value = "";
  
  public FeedCategory(String paramString)
  {
    paramString = paramString.trim();
    this._Name = paramString;
    this._Value = paramString;
  }
  
  public static FeedCategory Deserialize(String paramString)
  {
    String[] arrayOfString = paramString.split("\\^");
    Object localObject = CategoryManager.CategoryNull;
    if (arrayOfString.length > 0)
    {
      if (!CategoryManager.Unassigned.Value().equals(arrayOfString[0])) {
        break label64;
      }
      paramString = CategoryManager.Unassigned;
    }
    for (;;)
    {
      localObject = paramString;
      if (arrayOfString.length > 1)
      {
        paramString._Color = StringUtils.TryParseIntFromString(arrayOfString[1], Integer.valueOf(0)).intValue();
        localObject = paramString;
      }
      return (FeedCategory)localObject;
      label64:
      if (CategoryManager.AllFeeds.Value().equals(arrayOfString[0])) {
        paramString = CategoryManager.AllFeeds;
      } else {
        paramString = new FeedCategory(arrayOfString[0]);
      }
    }
  }
  
  public int Color()
  {
    return this._Color;
  }
  
  public boolean HasUnreadFeeds()
  {
    Iterator localIterator = FeedRepository.GetFeedsInCategory(this).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
    } while (!((Feed)localIterator.next()).MayHaveUnreadItems());
    return true;
  }
  
  public String Name()
  {
    return this._Name;
  }
  
  public int NumberOfFeedsInCategory()
  {
    return FeedRepository.GetFeedsInCategory(this).size();
  }
  
  public int NumberOfPodcastsInCategory()
  {
    int i = 0;
    Iterator localIterator = FeedRepository.GetFeedsInCategory(this).iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return i;
      }
      i += ((Feed)localIterator.next()).TracksAndSubTracks().size();
    }
  }
  
  public void RenameTo(String paramString)
  {
    this._Name = paramString;
    this._Value = paramString;
  }
  
  public String SerializedData()
  {
    return this._Value + "^" + this._Color;
  }
  
  public String Value()
  {
    return this._Value;
  }
  
  public int compareTo(FeedCategory paramFeedCategory)
  {
    if (paramFeedCategory == null) {
      return 1;
    }
    return Name().compareTo(paramFeedCategory.Name());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject instanceof FeedCategory)) {}
      for (;;)
      {
        paramObject = (FeedCategory)paramObject;
        if (paramObject != null) {
          break;
        }
        return false;
        paramObject = null;
      }
    } while ((StringUtils.EqualsIgnoreCase(this._Name, ((FeedCategory)paramObject)._Name)) && (StringUtils.EqualsIgnoreCase(this._Value, ((FeedCategory)paramObject)._Value)));
    return false;
  }
  
  public int hashCode()
  {
    return this._Name.hashCode() + this._Value.hashCode() * 29;
  }
  
  void setColor(int paramInt)
  {
    this._Color = paramInt;
  }
  
  public String toString()
  {
    return Name();
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/categories/FeedCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */