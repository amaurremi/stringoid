package mobi.beyondpod.rsscore.categories;

import java.util.Iterator;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.services.player.SmartPlaylistTemplate;

public final class CategoryManager
{
  public static FeedCategory AllFeeds;
  public static FeedCategory CategoryNull = new NullCategory();
  public static final int MAX_FEED_CATEGORIES = 2;
  private static final String TAG = "CategoryManager";
  public static FeedCategory Unassigned;
  private static final CategoryList m_Categories = new CategoryList();
  private static boolean m_IsModified = true;
  
  static
  {
    AllFeeds = new AllFeedsCategory();
    Unassigned = new CategoryNone();
  }
  
  public static void AddCategory(String paramString)
    throws Exception
  {
    AssertCategoryValueDoesNotExist(paramString);
    AddCategory(new FeedCategory(paramString));
  }
  
  public static void AddCategory(FeedCategory paramFeedCategory)
  {
    if (!m_Categories.contains(paramFeedCategory)) {
      m_Categories.add(paramFeedCategory);
    }
    SetIsModified(true);
    FeedRepository.NotifyCategoryEvent(12);
  }
  
  private static void AssertCategoryValueDoesNotExist(String paramString)
    throws Exception
  {
    if (GetCategoryByValue(paramString) != CategoryNull) {
      throw new Exception("Category " + paramString + " already exists!");
    }
  }
  
  public static void Clear()
  {
    m_Categories.clear();
    CoreHelper.WriteTraceEntry("CategoryManager", "Categories unloaded");
  }
  
  public static void DeleteCategory(FeedCategory paramFeedCategory)
  {
    m_Categories.remove(paramFeedCategory);
    if (Configuration.getActiveFeedCategory().equals(paramFeedCategory)) {
      Configuration.setActiveFeedCategory(AllFeeds);
    }
    Iterator localIterator = FeedRepository.getRootFeed().SubFeeds().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        SetIsModified(true);
        FeedRepository.NotifyCategoryEvent(13);
        return;
      }
      Feed localFeed = (Feed)localIterator.next();
      if (localFeed.getCategories().getPrimary().equals(paramFeedCategory)) {
        localFeed.getCategories().setPrimary(Unassigned);
      }
      if (localFeed.getCategories().getSecondary() == paramFeedCategory) {
        localFeed.getCategories().setSecondary(Unassigned);
      }
    }
  }
  
  public static void Deserialize(String paramString)
  {
    paramString = paramString.split("\\|");
    m_Categories.clear();
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j)
      {
        if (!m_Categories.contains(AllFeeds)) {
          m_Categories.add(0, AllFeeds);
        }
        if (!m_Categories.contains(Unassigned)) {
          m_Categories.add(Unassigned);
        }
        return;
      }
      String str = paramString[i];
      if (!StringUtils.IsNullOrEmpty(str)) {
        m_Categories.add(FeedCategory.Deserialize(str));
      }
      i += 1;
    }
  }
  
  public static CategoryList GetCategoriesForAssignment()
  {
    CategoryList localCategoryList = new CategoryList();
    localCategoryList.addAll(m_Categories);
    localCategoryList.remove(AllFeeds);
    return localCategoryList;
  }
  
  public static CategoryList GetCategoriesForFeedsList()
  {
    CategoryList localCategoryList = new CategoryList();
    localCategoryList.addAll(m_Categories);
    return localCategoryList;
  }
  
  public static CategoryList GetCategoriesForFilter()
  {
    return m_Categories;
  }
  
  public static CategoryList GetCategoriesForFilterNoUncategorized()
  {
    CategoryList localCategoryList = new CategoryList();
    localCategoryList.addAll(m_Categories);
    localCategoryList.remove(Unassigned);
    return localCategoryList;
  }
  
  public static FeedCategory GetCategoryByValue(String paramString)
  {
    if (StringUtils.IsNullOrEmpty(paramString)) {
      return AllFeeds;
    }
    paramString = paramString.trim();
    if (StringUtils.EqualsIgnoreCase(Unassigned.Value(), paramString)) {
      return Unassigned;
    }
    Iterator localIterator = m_Categories.iterator();
    FeedCategory localFeedCategory;
    do
    {
      if (!localIterator.hasNext()) {
        return CategoryNull;
      }
      localFeedCategory = (FeedCategory)localIterator.next();
    } while (!StringUtils.EqualsIgnoreCase(localFeedCategory.Value(), paramString));
    return localFeedCategory;
  }
  
  public static boolean HasCategory(FeedCategory paramFeedCategory)
  {
    Iterator localIterator = m_Categories.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        return false;
      }
    } while ((FeedCategory)localIterator.next() != paramFeedCategory);
    return true;
  }
  
  public static boolean IsInCategory(Feed paramFeed, FeedCategory paramFeedCategory)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFeed == null) || (paramFeedCategory == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramFeedCategory.equals(AllFeeds));
      if (paramFeed.getCategories() == null) {
        break;
      }
      bool1 = bool2;
    } while (paramFeed.getCategories().IsOfCategory(paramFeedCategory));
    return false;
  }
  
  public static boolean IsModified()
  {
    return m_IsModified;
  }
  
  public static void MoveCategory(FeedCategory paramFeedCategory1, FeedCategory paramFeedCategory2)
  {
    int i = m_Categories.indexOf(paramFeedCategory1);
    int j = m_Categories.indexOf(paramFeedCategory2);
    if ((i >= 0) && (j >= 0)) {
      MoveCategoryByPos(i, j);
    }
  }
  
  private static void MoveCategoryByPos(int paramInt1, int paramInt2)
  {
    FeedCategory localFeedCategory = (FeedCategory)m_Categories.get(paramInt1);
    if ((localFeedCategory != null) && (paramInt2 >= 0) && (paramInt2 < m_Categories.size()))
    {
      m_Categories.remove(localFeedCategory);
      m_Categories.add(paramInt2, localFeedCategory);
      SetIsModified(true);
      FeedRepository.NotifyCategoryEvent(14);
    }
  }
  
  public static void RenameCategory(FeedCategory paramFeedCategory, String paramString)
    throws Exception
  {
    AssertCategoryValueDoesNotExist(paramString);
    boolean bool = Configuration.getActiveFeedCategory().equals(paramFeedCategory);
    Object localObject = null;
    if (SmartPlaylistTemplate.IsConfigured())
    {
      SmartPlaylistTemplate localSmartPlaylistTemplate = new SmartPlaylistTemplate();
      localObject = localSmartPlaylistTemplate;
      if (!localSmartPlaylistTemplate.HasEntryForCategory(paramFeedCategory)) {
        localObject = null;
      }
    }
    paramFeedCategory.RenameTo(paramString);
    if (localObject != null) {
      ((SmartPlaylistTemplate)localObject).SaveToFile();
    }
    paramString = FeedRepository.getRootFeed().SubFeeds().iterator();
    for (;;)
    {
      if (!paramString.hasNext())
      {
        if (bool) {
          Configuration.setActiveFeedCategory(paramFeedCategory);
        }
        SetIsModified(true);
        FeedRepository.NotifyCategoryEvent(14);
        return;
      }
      localObject = (Feed)paramString.next();
      if (IsInCategory((Feed)localObject, paramFeedCategory)) {
        ((Feed)localObject).Touch();
      }
    }
  }
  
  public static String Serialize()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        localIterator = m_Categories.iterator();
        boolean bool = localIterator.hasNext();
        if (bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Iterator localIterator;
        CoreHelper.LogException("CategoryManager", "Unable to serialize categories!", localException);
        continue;
      }
      return localStringBuilder.toString();
      localStringBuilder.append(((FeedCategory)localIterator.next()).SerializedData());
      localStringBuilder.append("|");
    }
  }
  
  public static void SetCategoryColor(FeedCategory paramFeedCategory, int paramInt)
  {
    if (paramFeedCategory == null) {
      return;
    }
    paramFeedCategory.setColor(paramInt);
    SetIsModified(true);
    FeedRepository.NotifyCategoryEvent(14);
  }
  
  public static void SetIsModified(boolean paramBoolean)
  {
    m_IsModified = paramBoolean;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/rsscore/categories/CategoryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */