package mobi.beyondpod.ui.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import mobi.beyondpod.rsscore.categories.CategoryList;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.DateTime;
import mobi.beyondpod.schedulercore.Event;
import mobi.beyondpod.schedulercore.ScheduleUtils;
import mobi.beyondpod.schedulercore.ScheduledTask;

public class CategoriesViewAdapter
  extends BaseAdapter
{
  private static final String NUM_EPISODES = CoreHelper.LoadResourceString(2131296966);
  private static final String NUM_FEEDS = CoreHelper.LoadResourceString(2131296967);
  Context _Context;
  CategoryList _Items = new CategoryList();
  CategoriesListView _Owner;
  private LayoutInflater mInflater;
  
  public CategoriesViewAdapter(Context paramContext, CategoriesListView paramCategoriesListView)
  {
    this._Context = paramContext;
    this._Owner = paramCategoriesListView;
    this.mInflater = LayoutInflater.from(this._Context);
  }
  
  private void BuildViewItem(CategoryViewItem paramCategoryViewItem, FeedCategory paramFeedCategory, View paramView)
  {
    paramCategoryViewItem.PrimaryText.setText(paramFeedCategory.Name());
    int i = paramFeedCategory.NumberOfPodcastsInCategory();
    TextView localTextView = paramCategoryViewItem.SecondaryText;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(String.format(NUM_FEEDS, new Object[] { Integer.valueOf(paramFeedCategory.NumberOfFeedsInCategory()) })));
    if (i > 0)
    {
      paramView = ", " + String.format(NUM_EPISODES, new Object[] { Integer.valueOf(i) });
      localTextView.setText(paramView);
      paramView = ScheduleUtils.GetScheduledTaskForCategory(paramFeedCategory);
      if ((paramView == null) || (!paramView.Active) || (!paramView.ExistsOnDevice())) {
        break label217;
      }
      paramCategoryViewItem.ScheduledImage.setVisibility(0);
      paramCategoryViewItem.ScheduledText.setVisibility(0);
      paramView = paramView.Event.StartTime();
      paramCategoryViewItem.ScheduledText.setText(DateTime.FormatTime(paramView) + " " + DateTime.FormatDate(paramView));
    }
    for (;;)
    {
      paramCategoryViewItem.DragDropImage.setVisibility(0);
      paramCategoryViewItem.colorIndicator.setBackgroundColor(paramFeedCategory.Color());
      return;
      paramView = "";
      break;
      label217:
      paramCategoryViewItem.ScheduledImage.setVisibility(8);
      paramCategoryViewItem.ScheduledText.setVisibility(8);
    }
  }
  
  public FeedCategory GetCategoryAtPosition(int paramInt)
  {
    return (FeedCategory)getItem(paramInt);
  }
  
  void SetCategories(CategoryList paramCategoryList)
  {
    this._Items.clear();
    this._Items.addAll(paramCategoryList);
    notifyDataSetChanged();
  }
  
  public boolean areAllItemsSelectable()
  {
    return true;
  }
  
  public int getCount()
  {
    return this._Items.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < getCount()) {
      return this._Items.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
  
  FeedCategory getSelectedCategory(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if (localObject != null) {
      return (FeedCategory)localObject;
    }
    return null;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramViewGroup = paramView;
    }
    for (;;)
    {
      try
      {
        paramView = this.mInflater.inflate(2130903087, null);
        paramViewGroup = paramView;
        localCategoryViewItem = new CategoryViewItem(null);
        paramViewGroup = paramView;
        localCategoryViewItem.PrimaryText = ((TextView)paramView.findViewById(2131230887));
        paramViewGroup = paramView;
        localCategoryViewItem.SecondaryText = ((TextView)paramView.findViewById(2131230888));
        paramViewGroup = paramView;
        localCategoryViewItem.ScheduledText = ((TextView)paramView.findViewById(2131230890));
        paramViewGroup = paramView;
        localCategoryViewItem.ScheduledImage = ((ImageView)paramView.findViewById(2131230889));
        paramViewGroup = paramView;
        localCategoryViewItem.colorIndicator = paramView.findViewById(2131230886);
        paramViewGroup = paramView;
        localCategoryViewItem.DragDropImage = ((ImageView)paramView.findViewById(2131230885));
        paramViewGroup = paramView;
        paramView.setTag(localCategoryViewItem);
        paramViewGroup = paramView;
        BuildViewItem(localCategoryViewItem, (FeedCategory)this._Items.get(paramInt), paramView);
        return paramView;
      }
      catch (Exception paramView)
      {
        CategoryViewItem localCategoryViewItem;
        paramView.printStackTrace();
      }
      paramViewGroup = paramView;
      localCategoryViewItem = (CategoryViewItem)paramView.getTag();
    }
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return true;
  }
  
  private static class CategoryViewItem
  {
    ImageView DragDropImage;
    TextView PrimaryText;
    ImageView ScheduledImage;
    TextView ScheduledText;
    TextView SecondaryText;
    View colorIndicator;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/CategoriesViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */