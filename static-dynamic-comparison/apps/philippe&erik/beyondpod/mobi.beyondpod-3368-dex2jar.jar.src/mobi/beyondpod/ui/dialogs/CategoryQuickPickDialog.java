package mobi.beyondpod.ui.dialogs;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.categories.CategoryList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.ui.commands.CommandManager;

public class CategoryQuickPickDialog
  extends QuickPickDialogBase
{
  public static final int CUSTOMIZE_FOR_EPISODES = 1;
  public static final int CUSTOMIZE_FOR_FEEDS = 0;
  private QuickCategoryPickAdapter _Adapter;
  private CategorySelectedListener _CategorySelectedListener;
  FeedCategory _CurrentCategory;
  
  public CategoryQuickPickDialog(Context paramContext, CategorySelectedListener paramCategorySelectedListener, FeedCategory paramFeedCategory, int paramInt)
  {
    super(paramContext);
    this._CurrentCategory = paramFeedCategory;
    this._CategorySelectedListener = paramCategorySelectedListener;
    this._Adapter = new QuickCategoryPickAdapter(paramContext, this._CurrentCategory, paramInt);
    this._ListView.setAdapter(this._Adapter);
  }
  
  protected void OnItemSelected(int paramInt)
  {
    if (paramInt == this._Adapter.getCount()) {
      CommandManager.CmdOpenManageCategoriesView();
    }
    FeedCategory localFeedCategory;
    do
    {
      return;
      localFeedCategory = this._Adapter.getCategoryAt(paramInt);
      if ((localFeedCategory == null) && (this._CategorySelectedListener != null)) {
        this._CategorySelectedListener.onFeedSelected(this._Adapter.getFeedAt(paramInt));
      }
    } while (this._CategorySelectedListener == null);
    this._CategorySelectedListener.onCategorySelected(localFeedCategory);
  }
  
  public static abstract interface CategorySelectedListener
  {
    public abstract void onCategorySelected(FeedCategory paramFeedCategory);
    
    public abstract void onFeedSelected(Feed paramFeed);
  }
  
  public static class ListDataItem
  {
    public FeedCategory Category;
    public Feed Feed;
    public String Name;
    
    public ListDataItem(String paramString, FeedCategory paramFeedCategory, Feed paramFeed)
    {
      this.Name = paramString;
      this.Category = paramFeedCategory;
      this.Feed = paramFeed;
    }
  }
  
  private static class QuickCategoryPickAdapter
    implements ListAdapter
  {
    private static final String ALL_EPISODESS = CoreHelper.LoadResourceString(2131296377);
    private static final String NUM_EPISODES = CoreHelper.LoadResourceString(2131296966);
    private static final String NUM_FEEDS = CoreHelper.LoadResourceString(2131296967);
    static Typeface PrimaryBold;
    static Typeface PrimaryNormal;
    private static StringBuilder sFormatBuilder = new StringBuilder();
    private static Formatter sFormatter = new Formatter(sFormatBuilder, Locale.getDefault());
    Context _Context;
    FeedCategory _CurrentCategory;
    int _CustomizeFor = 0;
    private LayoutInflater _Inflater;
    ArrayList<CategoryQuickPickDialog.ListDataItem> _Items = new ArrayList();
    
    public QuickCategoryPickAdapter(Context paramContext, FeedCategory paramFeedCategory, int paramInt)
    {
      this._CurrentCategory = paramFeedCategory;
      this._CustomizeFor = paramInt;
      this._Context = paramContext;
      this._Inflater = LayoutInflater.from(this._Context);
      paramFeedCategory = CategoryManager.GetCategoriesForFilter().iterator();
      if (!paramFeedCategory.hasNext()) {
        if (paramInt == 1)
        {
          paramFeedCategory = Configuration.getRecentFeeds();
          if (paramFeedCategory.size() > 0)
          {
            this._Items.add(new CategoryQuickPickDialog.ListDataItem(paramContext.getResources().getString(2131296965), null, null));
            paramContext = paramFeedCategory.iterator();
          }
        }
      }
      for (;;)
      {
        if (!paramContext.hasNext())
        {
          return;
          FeedCategory localFeedCategory = (FeedCategory)paramFeedCategory.next();
          if ((paramInt == 1) && (localFeedCategory.NumberOfPodcastsInCategory() == 0) && (localFeedCategory != this._CurrentCategory)) {
            break;
          }
          this._Items.add(new CategoryQuickPickDialog.ListDataItem(null, localFeedCategory, null));
          break;
        }
        paramFeedCategory = (Feed)paramContext.next();
        this._Items.add(new CategoryQuickPickDialog.ListDataItem(null, null, paramFeedCategory));
      }
    }
    
    private void BuildCategoryViewItem(CategoryViewItem paramCategoryViewItem, FeedCategory paramFeedCategory, View paramView)
    {
      sFormatBuilder.setLength(0);
      TextView localTextView = paramCategoryViewItem.PrimaryText;
      label56:
      int i;
      if ((paramFeedCategory == CategoryManager.AllFeeds) && (this._CustomizeFor == 1))
      {
        paramView = ALL_EPISODESS;
        localTextView.setText(paramView);
        localTextView = paramCategoryViewItem.PrimaryText;
        if (paramFeedCategory != this._CurrentCategory) {
          break label135;
        }
        paramView = PrimaryBold;
        localTextView.setTypeface(paramView);
        i = paramFeedCategory.NumberOfFeedsInCategory();
        if (this._CustomizeFor != 0) {
          break label142;
        }
        if (i > 0) {
          sFormatter.format(NUM_FEEDS, new Object[] { Integer.valueOf(i) });
        }
      }
      for (;;)
      {
        paramCategoryViewItem.SecondaryText.setText(sFormatBuilder.toString());
        paramCategoryViewItem.colorIndicator.setBackgroundColor(paramFeedCategory.Color());
        return;
        paramView = paramFeedCategory.Name();
        break;
        label135:
        paramView = PrimaryNormal;
        break label56;
        label142:
        i = paramFeedCategory.NumberOfPodcastsInCategory();
        if (i > 0) {
          sFormatter.format(NUM_EPISODES, new Object[] { Integer.valueOf(i) });
        }
      }
    }
    
    private void BuildFeedViewItem(CategoryViewItem paramCategoryViewItem, Feed paramFeed, View paramView)
    {
      sFormatBuilder.setLength(0);
      paramCategoryViewItem.PrimaryText.setText(paramFeed.getName());
      paramView = Configuration.getActiveFeedFilter();
      TextView localTextView = paramCategoryViewItem.PrimaryText;
      if (paramFeed.equals(paramView)) {}
      for (paramView = PrimaryBold;; paramView = PrimaryNormal)
      {
        localTextView.setTypeface(paramView);
        int i = paramFeed.TracksAndSubTracks().size();
        if (i > 0) {
          sFormatter.format(NUM_EPISODES, new Object[] { Integer.valueOf(i) });
        }
        paramCategoryViewItem.SecondaryText.setText(sFormatBuilder.toString());
        paramCategoryViewItem.colorIndicator.setBackgroundColor(paramFeed.getCategories().getPrimary().Color());
        return;
      }
    }
    
    public boolean areAllItemsEnabled()
    {
      return true;
    }
    
    FeedCategory getCategoryAt(int paramInt)
    {
      Object localObject = getItem(paramInt);
      if (localObject != null) {
        return ((CategoryQuickPickDialog.ListDataItem)localObject).Category;
      }
      return null;
    }
    
    public int getCount()
    {
      return this._Items.size();
    }
    
    Feed getFeedAt(int paramInt)
    {
      Object localObject = getItem(paramInt);
      if (localObject != null) {
        return ((CategoryQuickPickDialog.ListDataItem)localObject).Feed;
      }
      return null;
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
      return 0L;
    }
    
    public int getItemViewType(int paramInt)
    {
      CategoryQuickPickDialog.ListDataItem localListDataItem = (CategoryQuickPickDialog.ListDataItem)this._Items.get(paramInt);
      if ((localListDataItem == null) || ((localListDataItem.Feed == null) && (localListDataItem.Category == null) && (localListDataItem.Name == null))) {
        return -1;
      }
      if ((localListDataItem.Feed == null) && (localListDataItem.Category == null)) {
        return 0;
      }
      return 1;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      CategoryQuickPickDialog.ListDataItem localListDataItem = (CategoryQuickPickDialog.ListDataItem)this._Items.get(paramInt);
      paramViewGroup = paramView;
      try
      {
        if (localListDataItem.Category == null)
        {
          paramViewGroup = paramView;
          if (localListDataItem.Feed == null) {}
        }
        else
        {
          CategoryViewItem localCategoryViewItem;
          if (paramView == null)
          {
            paramViewGroup = paramView;
            View localView = this._Inflater.inflate(2130903088, null);
            paramViewGroup = localView;
            localCategoryViewItem = new CategoryViewItem(null);
            paramViewGroup = localView;
            localCategoryViewItem.PrimaryText = ((TextView)localView.findViewById(2131230887));
            paramViewGroup = localView;
            localCategoryViewItem.SecondaryText = ((TextView)localView.findViewById(2131230888));
            paramViewGroup = localView;
            localCategoryViewItem.colorIndicator = localView.findViewById(2131230886);
            paramViewGroup = localView;
            localView.setTag(localCategoryViewItem);
            localObject = localCategoryViewItem;
            paramView = localView;
            paramViewGroup = localView;
            if (PrimaryNormal == null)
            {
              paramViewGroup = localView;
              PrimaryNormal = localCategoryViewItem.PrimaryText.getTypeface();
              paramViewGroup = localView;
              PrimaryBold = Typeface.create(PrimaryNormal, 1);
              paramView = localView;
            }
          }
          for (localObject = localCategoryViewItem;; localObject = (CategoryViewItem)paramView.getTag())
          {
            paramViewGroup = paramView;
            if (localListDataItem.Feed == null) {
              break;
            }
            paramViewGroup = paramView;
            BuildFeedViewItem((CategoryViewItem)localObject, localListDataItem.Feed, paramView);
            return paramView;
            paramViewGroup = paramView;
          }
          paramViewGroup = paramView;
          BuildCategoryViewItem((CategoryViewItem)localObject, localListDataItem.Category, paramView);
          return paramView;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return paramViewGroup;
      }
      paramViewGroup = paramView;
      Object localObject = paramView;
      if (localListDataItem.Name != null)
      {
        localObject = paramView;
        if (paramView == null)
        {
          paramViewGroup = paramView;
          localObject = this._Inflater.inflate(2130903132, null);
        }
        paramViewGroup = (ViewGroup)localObject;
        ((TextView)localObject).setText(localListDataItem.Name);
      }
      return (View)localObject;
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public boolean hasStableIds()
    {
      return false;
    }
    
    public boolean isEmpty()
    {
      return this._Items.size() == 0;
    }
    
    public boolean isEnabled(int paramInt)
    {
      CategoryQuickPickDialog.ListDataItem localListDataItem = (CategoryQuickPickDialog.ListDataItem)this._Items.get(paramInt);
      if (localListDataItem == null) {}
      while ((localListDataItem.Feed == null) && (localListDataItem.Category == null)) {
        return false;
      }
      return true;
    }
    
    public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
    
    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
    
    private static class CategoryViewItem
    {
      TextView PrimaryText;
      TextView SecondaryText;
      View colorIndicator;
    }
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/CategoryQuickPickDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */