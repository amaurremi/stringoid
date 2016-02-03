package mobi.beyondpod.ui.views;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.beyondpod.rsscore.Feed;
import mobi.beyondpod.rsscore.FeedList;
import mobi.beyondpod.rsscore.categories.CategoryManager;
import mobi.beyondpod.rsscore.categories.FeedCategories;
import mobi.beyondpod.rsscore.categories.FeedCategory;
import mobi.beyondpod.rsscore.helpers.CoreHelper;
import mobi.beyondpod.rsscore.helpers.StringUtils;
import mobi.beyondpod.rsscore.repository.FeedRepository;
import mobi.beyondpod.ui.commands.CommandManager;
import mobi.beyondpod.ui.core.InertCheckBox;

public class OpmlViewAdapter
  extends BaseAdapter
{
  private static final String BACK_TO_S = CoreHelper.LoadResourceString(2131297076);
  private static final String GO_BACK = CoreHelper.LoadResourceString(2131297077);
  private static final String IN_S = CoreHelper.LoadResourceString(2131297075);
  private static final String ITEMS = CoreHelper.LoadResourceString(2131297078);
  static Typeface PrimaryBold;
  static Typeface PrimaryNormal;
  private Feed _Feed;
  private CharSequence _IfEmptyText;
  private LayoutInflater _Inflater;
  View.OnClickListener _ItemPreviewListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = (Feed)paramAnonymousView.getTag();
      if (paramAnonymousView != null) {
        CommandManager.CmdOpenFeedPreview(paramAnonymousView.getFeedUri(), paramAnonymousView.getName(), null, paramAnonymousView.IsGReaderFeed());
      }
    }
  };
  ArrayList<Feed> _Items = new ArrayList();
  private ListView _Owner;
  
  public OpmlViewAdapter(Context paramContext, ListView paramListView)
  {
    this._Inflater = LayoutInflater.from(paramContext);
    this._Owner = paramListView;
  }
  
  private OpmlViewItem BuildViewItem(OpmlViewItem paramOpmlViewItem, int paramInt)
  {
    Object localObject2 = (Feed)this._Items.get(paramInt);
    paramOpmlViewItem.PrimaryText.setText(((Feed)localObject2).getName());
    int i = ((Feed)localObject2).SubFeeds().size();
    Object localObject3 = paramOpmlViewItem.SecondaryText;
    if (i > 0)
    {
      localObject1 = i + " " + ITEMS;
      ((TextView)localObject3).setText((CharSequence)localObject1);
      boolean bool = IsFeedImportable((Feed)localObject2);
      localObject1 = paramOpmlViewItem.ItemCheck;
      if (!bool) {
        break label227;
      }
      paramInt = 0;
      label99:
      ((CheckBox)localObject1).setVisibility(paramInt);
      paramOpmlViewItem.SecondaryImage.setVisibility(4);
      if (!bool) {
        break label233;
      }
      paramOpmlViewItem.Preview.setOnClickListener(this._ItemPreviewListener);
      paramOpmlViewItem.Preview.setTag(localObject2);
      paramOpmlViewItem.Preview.setVisibility(0);
      label146:
      if (!((Feed)localObject2).equals(FeedRepository.getGoUpPlaceholder())) {
        break label288;
      }
      paramOpmlViewItem.SecondaryImage.setImageResource(2130837845);
      paramOpmlViewItem.SecondaryImage.setVisibility(0);
      localObject2 = paramOpmlViewItem.PrimaryText;
      if (!StringUtils.IsNullOrEmpty(this._Feed.ParentFeed().getName())) {
        break label260;
      }
      localObject1 = GO_BACK;
      label201:
      ((TextView)localObject2).setText((CharSequence)localObject1);
      paramOpmlViewItem.PrimaryText.setTypeface(PrimaryNormal);
    }
    label227:
    label233:
    label260:
    label288:
    do
    {
      return paramOpmlViewItem;
      localObject1 = "";
      break;
      paramInt = 8;
      break label99;
      paramOpmlViewItem.Preview.setOnClickListener(null);
      paramOpmlViewItem.Preview.setTag(null);
      paramOpmlViewItem.Preview.setVisibility(4);
      break label146;
      localObject1 = String.format(BACK_TO_S, new Object[] { this._Feed.ParentFeed().getName() });
      break label201;
      if (i != 0) {
        break label408;
      }
      localObject2 = FeedRepository.GetFeedByUrl(((Feed)localObject2).getFeedUrl());
    } while (localObject2 == null);
    Object localObject1 = ((Feed)localObject2).getCategories().getPrimary().Name();
    localObject2 = ((Feed)localObject2).getCategories().getSecondary().Name();
    localObject3 = CategoryManager.Unassigned.Name();
    if (!((String)localObject3).equals(localObject1)) {}
    for (;;)
    {
      paramOpmlViewItem.SecondaryText.setText(String.format(IN_S, new Object[] { localObject1 }));
      paramOpmlViewItem.Preview.setVisibility(8);
      return paramOpmlViewItem;
      if (!((String)localObject3).equals(localObject2)) {
        localObject1 = localObject2;
      } else {
        localObject1 = localObject3;
      }
    }
    label408:
    paramOpmlViewItem.SecondaryImage.setImageResource(2130837833);
    paramOpmlViewItem.SecondaryImage.setVisibility(0);
    return paramOpmlViewItem;
  }
  
  public void Clear()
  {
    this._Feed = null;
    this._Items.clear();
  }
  
  FeedList Feeds()
  {
    FeedList localFeedList = new FeedList();
    Iterator localIterator = this._Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localFeedList;
      }
      Feed localFeed = (Feed)localIterator.next();
      if (localFeed != null) {
        localFeedList.add(localFeed);
      }
    }
  }
  
  public boolean IsFeedImportable(Feed paramFeed)
  {
    return (FeedRepository.GetFeedByUrl(paramFeed.getFeedUrl()) == null) && (paramFeed.SubFeeds().size() == 0) && (!paramFeed.equals(FeedRepository.getGoUpPlaceholder()));
  }
  
  public void Refresh()
  {
    notifyDataSetChanged();
  }
  
  void SetRootFeed(Feed paramFeed)
  {
    this._Feed = paramFeed;
    this._Items.clear();
    Object localObject = (FeedList)paramFeed.SubFeeds().clone();
    if (paramFeed != null)
    {
      paramFeed = paramFeed.SubFeeds().iterator();
      if (paramFeed.hasNext()) {
        break label103;
      }
      paramFeed = ((FeedList)localObject).iterator();
    }
    for (;;)
    {
      if (!paramFeed.hasNext())
      {
        if (this._Feed.CanNavigateUp()) {
          this._Items.add(0, FeedRepository.getGoUpPlaceholder());
        }
        notifyDataSetChanged();
        this._Owner.postDelayed(new Runnable()
        {
          public void run()
          {
            OpmlViewAdapter.this._Owner.setSelectionAfterHeaderView();
          }
        }, 100L);
        return;
        label103:
        Feed localFeed = (Feed)paramFeed.next();
        if (FeedRepository.GetFeedByUrl(localFeed.getFeedUrl()) != null) {
          break;
        }
        this._Items.add(localFeed);
        ((FeedList)localObject).remove(localFeed);
        break;
      }
      localObject = (Feed)paramFeed.next();
      this._Items.add(localObject);
    }
  }
  
  public boolean areAllItemsSelectable()
  {
    return false;
  }
  
  public int getCount()
  {
    return this._Items.size();
  }
  
  Feed getFeedAtPosition(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if (localObject == null) {
      return null;
    }
    return (Feed)localObject;
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
  
  Feed getRootFeed()
  {
    return this._Feed;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((Feed)this._Items.get(paramInt) != null)
    {
      if (paramView == null) {
        paramViewGroup = paramView;
      }
      for (;;)
      {
        try
        {
          View localView = this._Inflater.inflate(2130903144, null);
          paramViewGroup = localView;
          OpmlViewItem localOpmlViewItem = new OpmlViewItem(null);
          paramViewGroup = localView;
          localOpmlViewItem.PrimaryText = ((TextView)localView.findViewById(2131231130));
          paramViewGroup = localView;
          localOpmlViewItem.SecondaryText = ((TextView)localView.findViewById(2131231131));
          paramViewGroup = localView;
          localOpmlViewItem.ItemCheck = ((InertCheckBox)localView.findViewById(2131231127));
          paramViewGroup = localView;
          localOpmlViewItem.Preview = localView.findViewById(2131231129);
          paramViewGroup = localView;
          localOpmlViewItem.SecondaryImage = ((ImageView)localView.findViewById(2131231128));
          paramViewGroup = localView;
          localView.setTag(localOpmlViewItem);
          localObject = localOpmlViewItem;
          paramView = localView;
          paramViewGroup = localView;
          if (PrimaryNormal == null)
          {
            paramViewGroup = localView;
            PrimaryNormal = localOpmlViewItem.PrimaryText.getTypeface();
            paramViewGroup = localView;
            PrimaryBold = Typeface.create(PrimaryNormal, 1);
            paramView = localView;
            localObject = localOpmlViewItem;
          }
          paramViewGroup = paramView;
          BuildViewItem((OpmlViewItem)localObject, paramInt);
          return paramView;
        }
        catch (Exception paramView)
        {
          Object localObject;
          paramView.printStackTrace();
        }
        paramViewGroup = paramView;
        localObject = (OpmlViewItem)paramView.getTag();
      }
    }
    localObject = paramView;
    if (paramView == null)
    {
      paramViewGroup = paramView;
      localObject = this._Inflater.inflate(2130903131, null);
    }
    paramViewGroup = (ViewGroup)localObject;
    ((TextView)localObject).setText(this._IfEmptyText);
    return (View)localObject;
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 1;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this._Items.get(paramInt) != null;
  }
  
  public int numCheckableFeeds()
  {
    int i = 0;
    Iterator localIterator = this._Items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return i;
      }
      if (IsFeedImportable((Feed)localIterator.next())) {
        i += 1;
      }
    }
  }
  
  public void setIfEmptyText(CharSequence paramCharSequence)
  {
    this._IfEmptyText = paramCharSequence;
  }
  
  private static class OpmlViewItem
  {
    CheckBox ItemCheck;
    View Preview;
    TextView PrimaryText;
    ImageView SecondaryImage;
    TextView SecondaryText;
  }
}


/* Location:              /Users/amaurremi/uw/stringoid/static-dynamic-comparison/apps/beyondpod/mobi.beyondpod-3368-dex2jar.jar!/mobi/beyondpod/ui/views/OpmlViewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */