package mobi.beyondpod.ui.dialogs;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.Formatter;
import java.util.Locale;
import mobi.beyondpod.rsscore.Configuration;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.TrackList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.ui.views.FeedListViewDataSource;
import mobi.beyondpod.ui.views.FeedListViewDataSource.ListDataItem;

public class FeedQuickPickDialog
  extends QuickPickDialogBase
{
  private static final String UNREAD = " " + CoreHelper.LoadResourceString(2131297155);
  private QuickFeedPickAdapter _Adapter;
  Feed _CurrentFeed;
  private FeedSelectedListener _FeedSelectedListener;
  
  public FeedQuickPickDialog(Context paramContext, FeedSelectedListener paramFeedSelectedListener, Feed paramFeed)
  {
    super(paramContext);
    this._CurrentFeed = paramFeed;
    this._FeedSelectedListener = paramFeedSelectedListener;
    this._Adapter = new QuickFeedPickAdapter(paramContext, paramFeed);
    this._ListView.setAdapter(this._Adapter);
  }
  
  protected void OnItemSelected(int paramInt)
  {
    Feed localFeed = this._Adapter.getSelectedFeed(paramInt);
    if (this._FeedSelectedListener != null) {
      this._FeedSelectedListener.onFeedSelected(localFeed);
    }
  }
  
  public void show(View paramView)
  {
    super.show(paramView);
    int i = this._Adapter.GetFeedPosition(this._CurrentFeed);
    if (i >= 0) {
      this._ListView.setSelection(i);
    }
  }
  
  public static abstract interface FeedSelectedListener
  {
    public abstract void onFeedSelected(Feed paramFeed);
  }
  
  private static class QuickFeedPickAdapter
    implements ListAdapter
  {
    private static final String NUM_EPISODES = CoreHelper.LoadResourceString(2131296966);
    static Typeface PrimaryBold;
    static Typeface PrimaryNormal;
    private static StringBuilder sFormatBuilder = new StringBuilder();
    private static Formatter sFormatter = new Formatter(sFormatBuilder, Locale.getDefault());
    Context _Context;
    Feed _CurrentFeed;
    private FeedListViewDataSource _DataSource = new FeedListViewDataSource();
    private LayoutInflater _Inflater;
    
    public QuickFeedPickAdapter(Context paramContext, Feed paramFeed)
    {
      this._Context = paramContext;
      this._CurrentFeed = paramFeed;
      this._Inflater = LayoutInflater.from(this._Context);
      this._DataSource.FilterAndGroupByFirstCategory(FeedRepository.getRootFeed(), Configuration.getHideReadFeeds(), this._CurrentFeed);
    }
    
    private void BuildViewItem(CategoryViewItem paramCategoryViewItem, Feed paramFeed)
    {
      sFormatBuilder.setLength(0);
      paramCategoryViewItem.PrimaryText.setText(paramFeed.getName());
      TextView localTextView = paramCategoryViewItem.PrimaryText;
      Typeface localTypeface;
      if (paramFeed == this._CurrentFeed)
      {
        localTypeface = PrimaryBold;
        localTextView.setTypeface(localTypeface);
        i = paramFeed.Tracks().size();
        if (paramFeed.NumUnreadItems() > 0) {
          sFormatter.format("%s%s", new Object[] { Integer.valueOf(paramFeed.NumUnreadItems()), FeedQuickPickDialog.UNREAD });
        }
        if (i > 0)
        {
          if (sFormatBuilder.length() > 0) {
            sFormatter.format(", ", new Object[0]);
          }
          sFormatter.format(NUM_EPISODES, new Object[] { Integer.valueOf(i) });
        }
        paramCategoryViewItem.SecondaryText.setText(sFormatBuilder.toString());
        paramCategoryViewItem = paramCategoryViewItem.colorIndicator;
        if (Configuration.getActiveFeedCategory() != CategoryManager.AllFeeds) {
          break label187;
        }
      }
      label187:
      for (int i = paramFeed.getCategories().getPrimary().Color();; i = Configuration.getActiveFeedCategory().Color())
      {
        paramCategoryViewItem.setBackgroundColor(i);
        return;
        localTypeface = PrimaryNormal;
        break;
      }
    }
    
    private int GetFeedPosition(Feed paramFeed)
    {
      return this._DataSource.GetFeedPosition(this._CurrentFeed);
    }
    
    public boolean areAllItemsEnabled()
    {
      return true;
    }
    
    public int getCount()
    {
      return this._DataSource.size();
    }
    
    public Object getItem(int paramInt)
    {
      return this._DataSource.GetAtPosition(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public int getItemViewType(int paramInt)
    {
      FeedListViewDataSource.ListDataItem localListDataItem = this._DataSource.GetAtPosition(paramInt);
      if ((localListDataItem == null) || ((localListDataItem.Feed == null) && (localListDataItem.Name == null))) {
        return -1;
      }
      if (localListDataItem.Feed == null) {
        return 0;
      }
      return 1;
    }
    
    Feed getSelectedFeed(int paramInt)
    {
      Object localObject = getItem(paramInt);
      if (localObject != null) {
        return ((FeedListViewDataSource.ListDataItem)localObject).Feed;
      }
      return null;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      FeedListViewDataSource.ListDataItem localListDataItem = this._DataSource.GetAtPosition(paramInt);
      paramViewGroup = paramView;
      Object localObject;
      try
      {
        if (localListDataItem.Feed != null)
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
            BuildViewItem((CategoryViewItem)localObject, localListDataItem.Feed);
            return paramView;
            paramViewGroup = paramView;
          }
        }
        paramViewGroup = paramView;
        localObject = paramView;
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
          return (View)localObject;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        localObject = paramViewGroup;
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
      return this._DataSource.size() == 0;
    }
    
    public boolean isEnabled(int paramInt)
    {
      FeedListViewDataSource.ListDataItem localListDataItem = this._DataSource.GetAtPosition(paramInt);
      if (localListDataItem == null) {}
      while ((localListDataItem.Feed == null) && ((localListDataItem.Feed != null) || (localListDataItem.Name != null))) {
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


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/dialogs/FeedQuickPickDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */